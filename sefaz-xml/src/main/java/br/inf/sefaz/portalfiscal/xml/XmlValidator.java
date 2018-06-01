package br.inf.sefaz.portalfiscal.xml;

import org.json.JSONArray;
import org.json.JSONObject;
import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Attribute;
import br.inf.sefaz.portalfiscal.xml.annotation.ElementList;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XmlValidator<T> {
    private boolean valid;
    private Map<String,String> errors;
    private T value;
    private Class<T> type;

    public  XmlValidator(T value, Class<T> type)  {
        this.value = value;
        this.type = type;
    }

    private static  <T  extends Annotation> T getAnnotation(Field d, Class<T > aClass) {
        if (d.isAnnotationPresent(aClass)){
            return d.getAnnotation(aClass);
        }
        Class<?> type = d.getType();
        if (type.isAssignableFrom(List.class)){
            Class pType = (Class) ((ParameterizedType) d.getGenericType()).getActualTypeArguments()[0];
            return (T) pType.getAnnotation(aClass);
        }else {
            return  type.getAnnotation(aClass);
        }
    }

    private static boolean isAnnotationPresent(Field d, Class<? extends Annotation> aClass) {
        if (d.isAnnotationPresent(aClass)){
            return true;
        }
        Class<?> type = d.getType();
        if (type.isAssignableFrom(List.class)){
            Class pType = (Class) ((ParameterizedType) d.getGenericType()).getActualTypeArguments()[0];
            return pType.isAnnotationPresent(aClass);
        }else {
            return  type.isAnnotationPresent(aClass);
        }

    }
    private static Class getType(Field d) {
        Class<?> type = d.getType();
        if (type.isAssignableFrom(List.class)){
            Class pType = (Class) ((ParameterizedType) d.getGenericType()).getActualTypeArguments()[0];
            return pType;
        }else {
            return type;
        }

    }

    public void  validate() throws Exception {
        this.errors = new HashMap<>();
        validate(value,type);
        if (errors.size()>0){
            throw new Exception(join("\n",errors));
        }
    }


    private void   validateValue(Field field, Class<?> type, Validation validation, Object v){
        if (validation.maxLength().length()>0){
            int maxLength = toInt(validation.maxLength());
        }
        if (validation.minLength().length()>0){
            int minLength = toInt(validation.minLength());
        }

        if (validation.enumerations().length>0){
            boolean b = false;
            for (String enumeration :validation.enumerations()){
                if (enumeration.contentEquals(v.toString())){
                    b = true;
                }
            }
            if (!b){
                errors.put(  type.getCanonicalName() + "."+field.getName()+".@enumeration"," not contains in enumeration " + join(" ,",validation.enumerations())+ "");
            }

        }

        if (validation.pattern().length()>0){
            String regex =validation.pattern();
            String ss = v.toString();
            Pattern padrao = Pattern.compile(regex);
            Matcher pesquisa = padrao.matcher(ss);
            if (pesquisa.find()){


            }else {
                errors.put(  type.getCanonicalName() + "."+field.getName()+".@regex"," not matcher "+regex);

            }

        }
    }

    private void validate(Object value, Class<?> type) throws IllegalAccessException, NoSuchFieldException {
        if ( type.isAnnotationPresent(Validation.class)){
            Validation annotation = type.getAnnotation(Validation.class);
            JSONArray choices = new JSONArray(  annotation.choices());
            validateChoices(type ,errors,choices,value);
        }

        Field[] fields = type.getDeclaredFields();
        for (Field field :fields){
            field.setAccessible(true);
            if (field.isAnnotationPresent(Validation.class)){
                Validation validation = field.getAnnotation(Validation.class);
                Object v = field.get(value);
                if (v==null){
                    if (validation.required()){
                        errors.put(type.getCanonicalName() +"." +field.getName()+".@required","field is required");
                    }
                }else if (isAnnotationPresent(field,ElementList.class)) {
                    Class f = getType(field);
                    List list = (List) v;
                    for (Object item  : list){
                        if (f.isAnnotationPresent(WXml.class)){
                            validate(item,f);
                        }else {
                            validateValue(field,type,validation,item);
                        }
                    }

                }else if (isAnnotationPresent(field,Element.class)) {
                    Class f = getType(field);

                    if (f.isAnnotationPresent(WXml.class)){
                        validate(v,f);
                    }else {
                        validateValue(field, type,validation,v);
                    }

                }else if (isAnnotationPresent(field,Attribute.class)) {
                    Class f = getType(field);


                    validateValue(field, type,validation,v);

                }else {

                    System.out.println("dgfsdgdsg");


                }

            }
        }


    }


    private ArrayList<String> validateChoicesItems(JSONArray items, Object value) throws NoSuchFieldException, IllegalAccessException {
        Class<? extends Object> c = value.getClass();
        List<String> strings = new ArrayList<>();
        for (int  jj=0; items.length()> jj ; jj++) {
            strings.add(items.getString(jj));
        }
        ArrayList<String> li = new ArrayList<>();
        for ( String s: strings){
            Field f = getField(c,s);

            f.setAccessible(true);
            Validation validation = f.getAnnotation(Validation.class);
            if (!validation.minOccurs().contentEquals("0")){
                Object v = f.get(value);
                if (v==null){
                    li.add(" é requerido o campo "+s);
                }
            }
        }
        return li;
    }

    private Field getField(Class<?> c, String s) {
        Field[] fields = c.getDeclaredFields();
        for ( Field field :fields){
            if (field.getName().toLowerCase().contentEquals(s.toLowerCase())){
                return  field;
            }
        }
        return null;
    }

    private void validateChoices(Class type, Map<String, String> errors, JSONArray choices, Object value) throws NoSuchFieldException, IllegalAccessException {
        boolean b = false;
        ArrayList<String> l1 = new ArrayList<>();

        for (int  ii=0; choices.length()> ii ; ii++) {
            JSONObject choice = choices.getJSONObject(ii);
            JSONArray items = choice.getJSONArray("items");
            Integer minOccurs;
            if (choice.has("minOccurs"))
                minOccurs = choice.getInt("minOccurs");
            else
                minOccurs=1;
            ArrayList<String> l = validateChoicesItems(items, value);
            if (l.size()>0){
                l1.add("("+join(" and  ", l)+")");
            }

            if (b){

            }else if (minOccurs==0&&l.size()==items.length()){
                b =true;
            }else if (l.size()< items.length()){
                b =true;
            }else {
                b =false;
            }
        }
        if (!b){
            this.errors.put(type.getCanonicalName()+".@choice","("+join("or",l1)+")");
        }
    }
    private String join( String s, String[] list) {
        String listString ="";
        String s1 ="";
        for (String sa : list)
        {
            listString += s1 + sa;
            s1 = s;
        }
        return listString;
    }
    private String join( String s, ArrayList<String> list) {
        String listString ="";
        String s1 ="";
        for (String sa : list)
        {
            listString += s1 + sa;
            s1 = s;
        }
        return listString;
    }


    private String join(String s, Map<String, String> errors) {

        String listString ="";
        String s1 ="";
        for (String sa : errors.keySet())
        {
            listString += s1 +" "+ sa+ " " +  errors.get(sa);
            s1 = s;
        }
        return listString;
    }
    private int toInt(String s) {
        if (s.length()==0)
            return 0;
        return Integer.parseInt(s);
    }

    public boolean isValid() {
        return errors.size() > 0;
    }

}
