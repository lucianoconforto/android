package br.inf.sefaz.portalfiscal.xml;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.QName;
import org.dom4j.dom.DOMCDATA;
import org.dom4j.dom.DOMElement;
import org.dom4j.dom.DOMText;
import org.dom4j.io.SAXReader;
import org.dom4j.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.Attribute;
import br.inf.sefaz.portalfiscal.xml.annotation.ElementList;
import br.inf.sefaz.portalfiscal.xml.annotation.Namespace;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;
import br.inf.sefaz.portalfiscal.xml.annotation.Value;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;

import java.io.StringReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class XmlSerializer {

    private final Encoded encoded;
    private final Decoded decoded;

    public XmlSerializer(){
         encoded = new Encoded(this);
         decoded = new Decoded(this);

    }
    public Element encode(Object o, Map<String, QName> qNameMap) throws Exception {
        return encoded.encode(o,qNameMap);
    }
    public <T> T decode(Element element, Class<T> tClass, Map<String, QName> qNameMap) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return (T) decoded.decode(element,(Type )tClass,qNameMap);
    }
    public <T> T decode(String s, Class<T> tClass, Map<String, QName> qNameMap) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, DocumentException {
        return (T) decoded.decode(s,(Type )tClass,qNameMap);
    }


    static List<Field> sort(Field fields[], final String[] propOrder) {

        List<Field> fieldList = new ArrayList<>();
        for (Field field : fields) {
            fieldList.add(field);
        }
        Collections.sort(fieldList, new Comparator<Field>() {
            @Override
            public int compare(Field f1, Field f2) {
                int ll = propOrder.length + 1;
                int d1 = 0;
                int d2 = 0;
                String xmlElementName1 = "";
                String xmlElementName2 = "";
                if (f1.isAnnotationPresent(ElementList.class)) {
                    ElementList xmlElement1 = getAnnotation(f1,ElementList.class);
                     xmlElementName1 = xmlElement1.name();
                }
                if (f1.isAnnotationPresent(br.inf.sefaz.portalfiscal.xml.annotation.Element.class)) {
                    br.inf.sefaz.portalfiscal.xml.annotation.Element xmlElement1 = getAnnotation(f1, br.inf.sefaz.portalfiscal.xml.annotation.Element.class);
                    xmlElementName1 = xmlElement1.name();
                }

                if (f2.isAnnotationPresent(ElementList.class)) {
                    ElementList xmlElement1 = getAnnotation(f2,ElementList.class);
                    xmlElementName2 = xmlElement1.name();
                }

                if (f2.isAnnotationPresent(br.inf.sefaz.portalfiscal.xml.annotation.Element.class)) {
                    br.inf.sefaz.portalfiscal.xml.annotation.Element xmlElement1 = getAnnotation(f2, br.inf.sefaz.portalfiscal.xml.annotation.Element.class);
                    xmlElementName2 = xmlElement1.name();
                }
                for (String atr : propOrder) {
                    if (xmlElementName1.toLowerCase().contentEquals(atr.toLowerCase())) {
                        d1 = ll;
                    }
                    if (xmlElementName2.toLowerCase().contentEquals(atr.toLowerCase())) {
                        d2 = ll;
                    }
                    ll--;
                }
                return d2 - d1;
            }
        });
        return fieldList;
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

    static  public  class  Decoded {
        private XmlSerializer xmlSerializer;

        public Decoded(XmlSerializer xmlSerializer) {

            this.xmlSerializer = xmlSerializer;
        }

        public <T> T decode(String item, Class<T> type, Map<String,QName> qNameMap) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, DocumentException {
            return (T) decode(item,(Type)type , qNameMap);
        }
        public Object decode(String item, Type type, Map<String,QName> qNameMap) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, DocumentException {
            SAXReader reader = new SAXReader();
            Document document = reader.read(new StringReader(item));
            return  decode(document.getRootElement() ,type,qNameMap);
        }
        public Object decode(Element item, Type type ,  Map<String,QName> qNameMap) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
            String sss = item.asXML();
            Class<?> cl = (Class<?>) type;
            Constructor<?> cc = cl.getConstructor(new Class<?>[]{});
            Object inst = cc.newInstance();
            Field[] fields = cl.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (isAnnotationPresent(field,ElementList.class)) {
                    Class pType = (Class) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                    ElementList xmlElement = getAnnotation(field,ElementList.class);
                    String localName = xmlElement.name();
                    List list = new ArrayList();
                    for (Iterator<Element> it = item.elementIterator(); it.hasNext();) {
                        final Element element = it.next();
                        String _localName = element.getName();
                        boolean b=_localName.contentEquals(localName);
                        if (b){
                            list.add(decodeValue(element, pType,qNameMap));
                        }
                    }
                    if (list.size()>0){
                        field.set(inst, list);
                    }else {
                        field.set(inst, null);
                    }
                } else if (isAnnotationPresent(field, br.inf.sefaz.portalfiscal.xml.annotation.Element.class)) {
                    Class pType = (Class) field.getGenericType();
                    br.inf.sefaz.portalfiscal.xml.annotation.Element xmlElement = getAnnotation(field , br.inf.sefaz.portalfiscal.xml.annotation.Element.class);
                    String localName = xmlElement.name();
                    Object o =null;
                    for (Iterator<Element> it = item.elementIterator(); it.hasNext();) {
                        final Element element = it.next();
                        String _localName = element.getName();
                        boolean b= _localName.contentEquals(localName);
                        if (b){
                            o = decodeValue(element, pType,qNameMap);
                            break;
                        }
                    }
                    if (o!=null){
                        field.set(inst, o);
                    }
                } else if (isAnnotationPresent(field,Attribute.class)) {
                    Attribute xmlAttribute = getAnnotation(field ,Attribute.class);

                    if ( item.attribute(xmlAttribute.name())!=null)
                    field.set(inst,item.attribute(xmlAttribute.name()).getValue());
                } else if (isAnnotationPresent(field,Value.class)) {
                    Class pType = (Class) field.getGenericType();
                    Value xmlAttribute = getAnnotation(field ,Value.class);
                    List<Element> elements = new ArrayList<>();
                    for (Iterator<Element> it = item.elementIterator(); it.hasNext();) {
                        final Element element = it.next();
                        elements.add(element);
                    }
                    if (elements.size()>0){
                        NodeContent o = null;
                        if (pType.isAssignableFrom(NodeContent.class)){
                            o = new NodeContentReader(elements);
                        }
                        if (o!=null){
                            field.set(inst, o);
                        }

                    }
                }
            }
            return inst;
        }

        private Object decodeValue(Element element, Class pType, Map<String, QName> qNameMap) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
            Object o;
            if (pType.isAssignableFrom(NodeContent.class)){
                 o = new NodeContentReader(element);
            } else if (pType.isAnnotationPresent(WXml.class)) {
                 o  = decode(element,pType,qNameMap);
            } else {
                 o = element.getStringValue();
            }
            return o;
        }


    }
    static  public  class  Encoded {
        private XmlSerializer xmlSerializer;

        public Encoded(XmlSerializer xmlSerializer) {

            this.xmlSerializer = xmlSerializer;
        }

        public Element encode(Object o , Map<String,QName> qNameMap ) throws Exception {
            if (o==null){
                return  null;
            }
            Class<?> c1 = o.getClass();



            String tagName = c1.getSimpleName();
            String prefix = "";
            String reference = "";
            if (c1.isAnnotationPresent(br.inf.sefaz.portalfiscal.xml.annotation.Element.class)) {
                br.inf.sefaz.portalfiscal.xml.annotation.Element element = c1.getAnnotation(br.inf.sefaz.portalfiscal.xml.annotation.Element.class);
                String n = element.name();
                if (n.indexOf(":")>0){
                    String[] ns = n.split(":");
                    prefix =ns[0];
                    tagName =ns[1];
                }
            }
            if (c1.isAnnotationPresent(Namespace.class)) {
                Namespace annotation = c1.getAnnotation(Namespace.class);
                reference =annotation.reference();
            }
            Element element = new DOMElement( QName.get(tagName,prefix,reference));
            String[] propOrder = new String[0];
            if (c1.isAnnotationPresent(Order.class)) {
                Order order = c1.getAnnotation(Order.class);
                propOrder = order.elements();
            }


            if ( qNameMap.containsKey(c1.getCanonicalName())){
                element.setQName(qNameMap.get(c1.getCanonicalName()));
            }
            return encodeElementChild(element,o,propOrder, qNameMap );


        }
        private Element encodeElement(Field field, QName qName ,  Object item , Map<String,QName> qNameMap ) throws Exception {
            DOMElement node;
            if (isAnnotationPresent(field,WXml.class)){
                node = new DOMElement(qName);
                Class<?> type = field.getType();
                if (type.isAssignableFrom(List.class)){
                    Class pType = (Class) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0];
                    if ( qNameMap.containsKey(pType.getCanonicalName())){
                        node.setQName(qNameMap.get(pType.getCanonicalName()));
                    }
                }else {
                    if ( qNameMap.containsKey(type.getCanonicalName())){
                        node.setQName(qNameMap.get(type.getCanonicalName()));
                    }
                }
                String[] propOrder = new String[0];
                if (isAnnotationPresent(field,Order.class)) {
                    Order order = getAnnotation(field,Order.class);
                    propOrder = order.elements();
                }
                encodeElementChild(node,item,propOrder,qNameMap );
            }else {
                if (field.getName().toLowerCase().contentEquals("qrcode")){
                    node = new DOMElement(qName);
                    node.add(new DOMCDATA(item.toString()));

                }else {

                    node = new DOMElement(qName);
                    node.add(new DOMText(item.toString()));
                }
            }
            return node;
        }
        private Element encodeElementChild(Element documentElement, Object value , String [] propOrder, Map<String,QName> qNameMap ) throws Exception {
            Class<?> cl = value.getClass();
            List<Field> fields = sort(cl.getDeclaredFields(), propOrder);
            for (Field field : fields) {
                field.setAccessible(true);
                if (isAnnotationPresent(field,ElementList.class)) {
                    ElementList xmlElement = getAnnotation(field ,ElementList.class);

                    java.lang.Object v = field.get(value);
                    if (Collection.class.isAssignableFrom(field.getType())) {
                        Collection collection = (Collection) v;
                        if (collection != null) {
                            for (Object item : collection) {

                                String reference = xmlElement.reference();
                                if (xmlElement.reference().length()==0 &&xmlElement.prefix().contentEquals(documentElement.getNamespacePrefix()) ){
                                    reference = documentElement.getNamespaceURI();
                                }
                                documentElement.add( encodeElement(field,QName.get(xmlElement.name(),xmlElement.prefix(),reference),item,qNameMap));
                            }
                        }
                    }
                } else if (isAnnotationPresent(field, br.inf.sefaz.portalfiscal.xml.annotation.Element.class)) {
                    br.inf.sefaz.portalfiscal.xml.annotation.Element xmlElement = getAnnotation(field , br.inf.sefaz.portalfiscal.xml.annotation.Element.class);
                    Object v = field.get(value);
                    if (v != null) {

                        String reference = xmlElement.reference();
                        if (xmlElement.reference().length()==0 &&xmlElement.prefix().contentEquals(documentElement.getNamespacePrefix()) ){
                            reference = documentElement.getNamespaceURI();
                        }


                        documentElement.add( encodeElement(field, QName.get(xmlElement.name(),xmlElement.prefix(),reference),v,qNameMap));
                    }
                } else if (isAnnotationPresent(field,Attribute.class)) {
                    Attribute xmlAttribute = getAnnotation(field ,Attribute.class);
                    Object v = field.get(value);
                    if (v != null) {
                        documentElement.addAttribute(xmlAttribute.name(), v.toString());
                    }
                } else if (isAnnotationPresent(field,Value.class)) {
                    Object v = field.get(value);
                    if (v != null) {
                        NodeContent o = (NodeContent) v;
                        List<Element> elements = o.getElementList(xmlSerializer,qNameMap);
                        if (elements!=null){
                            for (Element e: elements){
                                documentElement.add(e);
                            }
                        }
                    }
                }
            }
            return documentElement;
        }
    }


}
