package br.inf.sefaz.portalfiscal.xsd;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jboss.forge.roaster.Roaster;
import org.jboss.forge.roaster.model.Type;
import org.jboss.forge.roaster.model.source.*;
import org.json.JSONArray;
import org.json.JSONObject;
import br.inf.sefaz.portalfiscal.xml.annotation.ElementList;
import br.inf.sefaz.portalfiscal.xml.annotation.Embeddable;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;
import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WXmlXsd {
    public class AnnotationElement {
        private Map<String, ArrayList<String>> stringArrayListMap;

        private Map<String, String> stringStringMap;


        public Map<String, ArrayList<String>> getStringArrayListMap() {
            return stringArrayListMap;
        }

        public void setStringArrayListMap(Map<String, ArrayList<String>> stringArrayListMap) {
            this.stringArrayListMap = stringArrayListMap;
        }

        public void putArray(String key, String name) {
            if (stringArrayListMap == null) {
                stringArrayListMap = new HashMap<>();
            }
            if (!stringArrayListMap.containsKey(key)) {
                stringArrayListMap.put(key, new ArrayList<String>());
            }
            stringArrayListMap.get(key).add(name);
        }

        public void put(String key, String value) {
            if (stringStringMap == null) {
                stringStringMap = new HashMap<>();
            }
            stringStringMap.put(key, value);
        }

        public Map<String, String> getStringStringMap() {
            return stringStringMap;
        }

        public void setStringStringMap(Map<String, String> stringStringMap) {
            this.stringStringMap = stringStringMap;
        }
    }

    private HashMap<String, Xsd> fileDocumentHashMap = new LinkedHashMap<>();
    private File file;
    private final Xsd[] files;

    public WXmlXsd(File file, Xsd[] files) {
        this.file = file;
        this.files = files;
    }

    interface FieldSourceCall {
        void callback(FieldSource fieldSource, HashMap<String, AnnotationElement> annotationSources);
    }

    private HashMap<String, FieldSourceCall> simpleTypes = new LinkedHashMap<>();
    private HashMap<String, JavaClassSource> complexType = new LinkedHashMap<>();

   public static class Xsd {

        private File file;
        private String packageName;
        private Document document;

        public Xsd(File file, String packageName) {

            this.file = file;
            this.packageName = packageName;
        }

        public File getFile() {
            return file;
        }

        public void setFile(File file) {
            this.file = file;
        }

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        public void setDocument(Document document) {
            this.document = document;
        }

        public Document getDocument() {
            return document;
        }
    }


    public void buildSchemas() throws IOException, DocumentException {
        for (Xsd file : files) {
            buildSchemas(file);
        }
        for (String file : this.fileDocumentHashMap.keySet()) {
            Xsd d = this.fileDocumentHashMap.get(file);
            build(d.getPackageName(), d.getDocument());
        }
        for (String key : complexType.keySet()) {
            JavaClassSource classSource = complexType.get(key);
            File file = new File(this.file, classSource.getPackage().replaceAll("\\.", "\\\\") + "\\" + classSource.getName() + ".java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write(classSource.toString());
            output.close();
        }
    }

    private void build(String aPackage,Document document) {
        Element schema = document.getRootElement();
        String uri =schema.attribute("targetNamespace").getValue();
        for (Iterator<Element> it = schema.elementIterator(); it.hasNext(); ) {
            final Element element = it.next();
            if (element.getName().contentEquals("simpleType")) {
                simpleTypes.put(element.attribute("name").getValue(), new FieldSourceCall() {
                    @Override
                    public void callback(FieldSource fieldSource, HashMap<String, AnnotationElement> annotationSources) {
                        buildSimpleType(fieldSource, element, annotationSources);

                    }

                });
            }
        }
        for (Iterator<Element> it =schema.elementIterator(); it.hasNext(); ) {
            final Element element = it.next();
            if (element.getName().contentEquals("complexType")) {
                JavaClassSource dd = buildComplexType(aPackage, null, element,null);
                complexType.put(dd.getName(), dd);
            }
        }
        for (Iterator<Element> it = schema.elementIterator(); it.hasNext(); ) {
            final Element element = it.next();
            if (element.getName().contentEquals("element")) {
                buildComplexTypeElement(aPackage, element);
            }
        }
        for (Iterator<Element> it =schema.elementIterator();  it.hasNext(); ) {
            final Element element = it.next();

            if (element.getName().contentEquals("simpleType")) {

            } else if (element.getName().contentEquals("include")) {

            } else if (element.getName().contentEquals("import")) {

            } else if (element.getName().contentEquals("complexType")) {

            } else if (element.getName().contentEquals("element")) {


            } else {
                System.out.println("OK");
            }

        }
    }

    private void buildComplexTypeElement(String aPackage, Element element) {
        if (element.attribute("name") != null) {
            String name = element.attribute("name").getValue();
            Element eel = (Element) element.clone();
            eel.addAttribute("name","content");
            JavaClassSource javaClass = Roaster.create(JavaClassSource.class);
            javaClass.setPackage(aPackage);
            javaClass.setName(capitalize(name));
            boolean b = false;
            HashMap<String, AnnotationElement> annotationElements = new LinkedHashMap<>();
            buildElement(aPackage, javaClass, eel, b, annotationElements, element.attribute("name").getName(), null);
            javaClass.addAnnotation( Embeddable.class);
            javaClass.addAnnotation(WXml.class);
            complexType.put(javaClass.getName(), javaClass);
        }
    }


    private AnnotationSource getAnnotationValidation(JavaClassSource parent) {
        AnnotationSource annotation1 = null;
        for (AnnotationSource<?> a :parent.getAnnotations()){
            String qualifiedName = a.getQualifiedName();
            if ( qualifiedName.contentEquals(Validation.class.getCanonicalName())){
                annotation1=a;
            }
        }
        if (annotation1==null){
            annotation1 = parent.addAnnotation(Validation.class);
        }
        return annotation1;
    }

    AnnotationSource  getAnnotationValidation(FieldSource<JavaClassSource>  fieldSource){
        AnnotationSource annotation1 = null;
        for (AnnotationSource<?> a :fieldSource.getAnnotations()){
            String qualifiedName = a.getQualifiedName();
            if ( qualifiedName.contentEquals(Validation.class.getCanonicalName())){
                annotation1=a;
            }
        }
        if (annotation1==null){
            annotation1 = fieldSource.addAnnotation(Validation.class);
        }
        return annotation1;
    }

    private void buildElement(String aPackage, JavaClassSource parent, Element el, boolean b, HashMap<String, AnnotationElement> annotationSources, String gname,  JSONArray choice) {
        String name = null;
        String typeName = null;
        if (el.attribute("name") != null) {
            name = el.attribute("name").getValue();
        }
        if (el.attribute("type") != null) {
            typeName = el.attribute("type").getValue();
        }
        if (el.attribute("ref") != null && el.attribute("ref").getValue().contentEquals("ds:Signature")) {
            name = "signature";
            typeName = "SignatureType";
        }

        if (name != null) {
            if (parent.getField(name) != null) {
                return;
            }
            FieldSource<JavaClassSource> fieldSource = parent.addField();
            fieldSource.setPrivate();
            fieldSource.setName(name);
            if (choice!=null){
                choice.put(name);
            }
            for (Iterator<Element> it = el.elementIterator(); it.hasNext();) {
                final Element element = it.next();
                if (element.getName().contentEquals("annotation")) {
                    buildAnnotation(fieldSource, element);
                } else if (element.getName().contentEquals("complexType")) {
                    JavaClassSource d = buildComplexType(aPackage, parent, element, name,null);
                    String dde = d.getName();
                    fieldSource.setType(dde);
                } else if (element.getName().contentEquals("simpleType")) {
                    buildSimpleType(fieldSource, element, annotationSources);
                } else if (element.getName().contentEquals("unique")) {
                    buildUnique(element);
                } else {
                    System.out.println("OK");
                }
            }
            if (typeName != null) {
                if (simpleTypes.containsKey(typeName)) {
                    simpleTypes.get(typeName).callback(fieldSource, annotationSources);
                } else if (typeName.contentEquals("ds:DigestValueType")) {
                    fieldSource.setType(String.class);
                } else if (typeName.contentEquals("ds:SignatureValueType")) {
                    fieldSource.setType(String.class);
                }else if (typeName.contentEquals("xs:dateTime")) {
                    fieldSource.setType(String.class);
                } else if (typeName.contentEquals("xs:date")) {
                    fieldSource.setType(String.class);
                } else if (typeName.indexOf(":") > -1) {
                    fieldSource.setType(typeName.split(":")[1]);
                } else if (typeName.contentEquals("base64Binary")) {
                    fieldSource.setType(String.class);
                } else if (typeName.contentEquals("string")) {
                    fieldSource.setType(String.class);
                } else if (complexType.containsKey(typeName)) {
                    fieldSource.setType(complexType.get(typeName));
                } else {
                    fieldSource.setType(typeName);
                }
            }
            boolean required = b;
            String minOccurs = "1";
            if (el.attribute("minOccurs") != null) {
                minOccurs =el.attribute("minOccurs").getValue();
                if (Integer.parseInt(el.attribute("minOccurs").getValue()) == 0) {
                    required = false;
                }
            }


            if (el.attribute("maxOccurs") != null) {
                fieldSource.setType("List<" + buildType(fieldSource.getType()) + ">");
                parent.addImport(List.class);
                parent.addImport(ArrayList.class);

                fieldSource.setLiteralInitializer( "new ArrayList()" );

                createGETSETList(parent, name, fieldSource.getType().getQualifiedNameWithGenerics());

                AnnotationSource annotation = fieldSource.addAnnotation(ElementList.class);
                if (gname == null)
                    annotation.setStringValue("name", name);
                else
                    annotation.setStringValue("name", gname);
                annotation.setLiteralValue("inline", "true");

                AnnotationSource annotation1 = getAnnotationValidation(fieldSource);
                annotation1.setLiteralValue("required", "" + required);
                annotation1.setStringValue("minOccurs", minOccurs);
            } else {
                createGETSET(parent, name, buildType(fieldSource.getType()));
                AnnotationSource annotation = fieldSource.addAnnotation( br.inf.sefaz.portalfiscal.xml.annotation.Element.class);

                if (gname == null)
                    annotation.setStringValue("name", name);
                else
                    annotation.setStringValue("name", gname);
                AnnotationSource annotation1 = getAnnotationValidation(fieldSource);
                annotation1.setLiteralValue("required", "" + required);
                annotation1.setStringValue("minOccurs", minOccurs);
            }


            addAnnotation(fieldSource, annotationSources);

        }
    }



    private void buildAttribute(String aPackage, FieldSource fieldSource, Element el, HashMap<String, AnnotationElement> annotationSources , JSONArray choice) {
        if (el.attribute("name") != null) {
            fieldSource.setPrivate();
            JavaClassSource classSource = (JavaClassSource) fieldSource.getOrigin();
            String name = el.attribute("name").getValue();
            fieldSource.setName(name);
            for (Iterator<Element> it = el.elementIterator(); it.hasNext();) {
                final Element element = it.next();
                if (element.getName().contentEquals("annotation")) {
                    buildAnnotation(fieldSource, element);
                } else if (element.getName().contentEquals("complexType")) {
                    JavaClassSource d = buildComplexType(aPackage, classSource, element,null);
                    fieldSource.setType(d);
                } else if (element.getName().contentEquals("simpleType")) {
                    buildSimpleType(fieldSource, element, annotationSources);
                } else if (element.getName().contentEquals("unique")) {
                    buildUnique(element);
                } else {
                    System.out.println("OK");
                }
            }
            if (el.attribute("type") != null) {
                String typeName = el.attribute("type").getValue();
                if (simpleTypes.containsKey(typeName)) {
                    simpleTypes.get(typeName).callback(fieldSource, annotationSources);
                } else {
                    fieldSource.setType(String.class);
                }
            }
            AnnotationSource annotation = fieldSource.addAnnotation(br.inf.sefaz.portalfiscal.xml.annotation.Attribute.class);
            annotation.setStringValue("name", name);
            createGETSET(classSource, name, buildType(fieldSource.getType()));

        }

    }


    void createGETSETList(JavaClassSource classSource, String name, String type) {
        MethodSource<JavaClassSource> get = classSource.addMethod()
                .setName("get" + capitalize(name))
                .setPublic()
                .setReturnType(type)
                .setBody("" +
                        "return this." + name + ";");
        classSource.addMethod()
                .setName("set" + capitalize(name))
                .setPublic()
                .setBody("this." + name + " = " + name + ";")
                .addParameter(type, name);
    }

    void createGETSET(JavaClassSource classSource, String name, String type) {
        classSource.addMethod()
                .setName("get" + capitalize(name))
                .setPublic()
                .setReturnType(type)
                .setBody("return this." + name + ";");
        classSource.addMethod()
                .setName("set" + capitalize(name))
                .setPublic()
                .setBody("this." + name + " = " + name + ";")
                .addParameter(type, name);
    }


    private String capitalize(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1);
    }

    private void buildUnique(Element el) {

    }

    private JavaClassSource buildComplexType(String aPackage, JavaClassSource parent, Element element, String name, JSONArray choice) {
        JavaClassSource dd = buildComplexType(aPackage, parent, element,choice);
        dd.addAnnotation( br.inf.sefaz.portalfiscal.xml.annotation.Element.class).setStringValue("name",name);
        return dd;
    }


    private JavaClassSource buildComplexType(String aPackage, JavaClassSource parent, Element el , JSONArray choice) {
        String name = null;
        if (el.attribute("name") != null) {
            name = el.attribute("name").getValue();

        } else {
            Element e = (Element) el.getParent();
            name = e.attribute("name").getValue();
        }


        JavaClassSource javaClass = Roaster.create(JavaClassSource.class);
        javaClass.setPackage(aPackage);
        javaClass.setName(capitalize(name));
        if (parent != null) {
            javaClass.setStatic(true);
            JavaClassSource origin = parent;
            while (true) {
                JavaClassSource _origin = origin.getOrigin();
                if (_origin == null || _origin == origin) {
                    break;
                }
                origin = _origin;

            }

            for (Import anImport : javaClass.getImports()) {
                origin.addImport(anImport);
            }
            javaClass = parent.addNestedType(javaClass);
        }
        HashMap<String, AnnotationElement> classA = new HashMap<>();

        List<JSONArray> treeChoices=new ArrayList<>();
        for (Iterator<Element> it = el.elementIterator(); it.hasNext();) {
            final Element element = it.next();
            if (element.getName().contentEquals("annotation")) {
                buildAnnotation(javaClass, element);
            } else if (element.getName().contentEquals("sequence")) {
                JSONArray c=null;
                if (choice!=null){
                    choice.put(c=new JSONArray());
                }
                buildSequence(aPackage, javaClass, element, classA, true, new HashMap<String, AnnotationElement>(),c);


            } else if (element.getName().contentEquals("attribute")) {
                buildAttribute(aPackage, javaClass.addField(), element, new HashMap<String, AnnotationElement>(),choice);
            } else if (element.getName().contentEquals("choice")) {
                JSONArray c=null;
                if (choice==null){
                    c = new JSONArray();
                    treeChoices.add(c);
                }else {
                    choice.put(c=new JSONArray());
                }
                buildChoice(aPackage, javaClass, element, classA, false, new HashMap<String, AnnotationElement>(),c);
            } else if (element.getName().contentEquals("simpleContent")) {

            } else {
                System.out.println("OK");
            }
        }
        if (treeChoices.size()>0)
        addChoices(javaClass, treeChoices);
        javaClass.addAnnotation(WXml.class);
        addAnnotation(javaClass, classA);
        return javaClass;
    }

    private void addChoices(JavaClassSource parent, List<JSONArray> treeChoices) {
        String dd = parent.getCanonicalName();
        JSONArray a =new JSONArray();
        for (JSONArray tc : treeChoices){
            a.put(tc);
        }
        if (a.length()==1)
            getAnnotationValidation(parent).setStringValue("choices",a.get(0).toString());
        else {
            getAnnotationValidation(parent).setStringValue("choices",a.toString());
        }
    }


//    private JSONObject addChoices(TreeChoice choice) {
//        JSONObject jsonObject =new JSONObject();
//        JSONArray treeChoices =new JSONArray();
//        for (TreeChoice tc : choice.treeChoices){
//            treeChoices.put(addChoices(tc));
//        }
//        JSONArray options =new JSONArray();
//        for (String tc : choice.options){
//            options.put(tc);
//        }
//
//        if (treeChoices.length()>0)
//        jsonObject.put("choices",treeChoices);
//        if (options.length()>0)
//        jsonObject.put("options",options);
//
//        return  jsonObject;
//    }
//


    private void addAnnotation(AnnotationTargetSource javaClass, HashMap<String, AnnotationElement> classA) {

        for (String s : classA.keySet()) {



            AnnotationElement annotationElement = classA.get(s);
            AnnotationSource d = javaClass.addAnnotation(s);
            if (annotationElement.getStringArrayListMap() != null) {

                for (String ss : annotationElement.getStringArrayListMap().keySet()) {

                    ArrayList<String> l = annotationElement.getStringArrayListMap().get(ss);
                    d.setStringArrayValue(ss, l.toArray(new String[l.size()]));
                }
            }
            if (annotationElement.getStringStringMap() != null) {
                for (String ss : annotationElement.getStringStringMap().keySet()) {
                    d.setStringValue(ss, annotationElement.getStringStringMap().get(ss));
                }
            }


        }
    }

    private void buildChoice(String aPackage, JavaClassSource parent, Element el, HashMap<String, AnnotationElement> classA, boolean b, HashMap<String, AnnotationElement> annotationElements , JSONArray choice) {
        List<String> list = new ArrayList();
        Integer minOccurs=null;
        if ( el.attribute("minOccurs")!=null){
            minOccurs =Integer.parseInt(el.attribute("minOccurs").getValue());
        }
        for (Iterator<Element> it = el.elementIterator(); it.hasNext();) {
            final Element element = it.next();
            if (element.getName().contentEquals("annotation")) {
                buildAnnotation(parent, element);
            } else if (element.getName().contentEquals("element")) {
                JSONArray c;
                JSONObject j=new JSONObject();
                j.put("minOccurs",minOccurs);
                j.put("items",c=new JSONArray());
                choice.put(j);
                if (element.attribute("name") != null) {
                   String name = element.attribute("name").getValue();
                   list.add(name);
                   addOrder(classA, name);
                }
                buildElement(aPackage, parent, element, b, annotationElements, null, c);
            } else if (element.getName().contentEquals("sequence")) {
                JSONArray c;
                JSONObject j=new JSONObject();
                j.put("minOccurs",minOccurs);
                j.put("items",c=new JSONArray());
                choice.put(j);
                buildSequence(aPackage, parent, element, classA, b, annotationElements,c);
            } else {
                System.out.println("OK");
            }
        }

    }

    private String buildType(Type<JavaClassSource> type) {
        JavaClassSource origin = type.getOrigin();
        if (origin != null) {
            List<String> list = new ArrayList();
            while (true) {
                list.add(origin.getName());
                JavaClassSource _origin = origin.getOrigin();
                if (_origin == null || _origin == origin) {
                    break;
                }
                origin = _origin;

            }
            ;
            return type.getName();
        } else {

            return type.getQualifiedNameWithGenerics();

        }


    }


    private void buildSequence(String aPackage, JavaClassSource parent, Element el, HashMap<String, AnnotationElement> classA, boolean b, HashMap<String, AnnotationElement> annotationElements, JSONArray choice) {

        Integer minOccurs= null;
        if ( el.attribute("minOccurs")!=null){
            minOccurs =Integer.parseInt(el.attribute("minOccurs").getValue());
        }

        if (el.attribute("minOccurs") != null) {
            if (Integer.parseInt(el.attribute("minOccurs").getValue()) == 0) {
                b = false;
            }
        }

        List<JSONArray> treeChoices=new ArrayList<>();
        List<String> list = new ArrayList<>();
        for (Iterator<Element> it = el.elementIterator(); it.hasNext();) {
            final Element element = it.next();
            if (element.getName().contentEquals("annotation")) {
                buildAnnotation(parent, element);
            } else if (element.getName().contentEquals("element")) {
                if (element.attribute("name") != null) {
                    String name = element.attribute("name").getValue();
                    list.add(name);
                    addOrder(classA, name);
                }
                buildElement(aPackage, parent, element, b, annotationElements, null,choice);
            } else if (element.getName().contentEquals("choice")) {
                JSONArray c=null;
                if (choice==null){
                    c = new JSONArray();
                    treeChoices.add(c);
                }else {
                    choice.put(c=new JSONArray());
                }
                buildChoice(aPackage, parent, element, classA, false, annotationElements,c);
            } else if (element.getName().contentEquals("sequence")) {
                JSONArray c = null;
                if (choice!=null){
                    JSONObject j=new JSONObject();
                    j.put("minOccurs",minOccurs);
                    j.put("items",c=new JSONArray());
                    choice.put(j);
                }
                buildSequence(aPackage, parent, element, classA, b, annotationElements,c);
            } else {
                System.out.println("OK");
            }
        }
        if (treeChoices.size()>0)
        addChoices(parent,treeChoices);

    }

    private void addOrder(HashMap<String, AnnotationElement> classA, String name) {
        AnnotationElement annotationElement = new AnnotationElement();
        String nnn =Order.class.getCanonicalName();
        if (classA.containsKey(nnn)) {
            annotationElement = classA.get(nnn);
        }
        annotationElement.putArray("elements", name);
        classA.put(nnn, annotationElement);
    }

    private void buildSimpleType(FieldSource fieldSource, Element el, HashMap<String, AnnotationElement> annotationSources) {
        for (Iterator<Element> it = el.elementIterator(); it.hasNext();) {
            final Element element = it.next();
            if (element.getName().contentEquals("annotation")) {
                buildAnnotation(fieldSource, element);
            } else if (element.getName().contentEquals("restriction")) {
                buildRestriction(fieldSource, element, annotationSources);
            } else {
                System.out.println("OK");
            }
        }

    }

    private void buildAnnotation(JavaDocCapableSource parent, Element element) {
        parent.getJavaDoc().setFullText(element.elementIterator().next().getText());
    }

    private void buildRestriction(FieldSource fieldSource, Element el, HashMap<String, AnnotationElement> annotationSources) {
        String type = el.attribute("base").getValue();
        AnnotationSource annotationElement = getAnnotationValidation(fieldSource);

        ArrayList<String> enumerations = new ArrayList<>();
        for (Iterator<Element> it = el.elementIterator(); it.hasNext();) {
            final Element element = it.next();
            List<Attribute> attributes = element.attributes();
            if ( element.getName().contentEquals("enumeration")){
                enumerations.add(element.attribute("value").getValue());
            }else {
                for (Attribute attribute :attributes) {
                    annotationElement.setStringValue(element.getName(),attribute.getValue());
                }
            }

        }
        if (enumerations.size()>0)
        annotationElement.setStringArrayValue("enumerations",enumerations.toArray(new String[enumerations.size()]));
        annotationElement.setStringValue("text",fieldSource.getJavaDoc().getFullText().trim());
        if (type.contentEquals("xs:string")) {
            fieldSource.setType(String.class);
        } else if (type.contentEquals("nfe:TString")) {
            fieldSource.setType(String.class);
        } else if (type.contentEquals("TString")) {
            fieldSource.setType(String.class);
        } else if (type.contentEquals("xs:ID")) {
            fieldSource.setType(String.class);
        } else if (type.contentEquals("anyURI")) {
            fieldSource.setType(String.class);
        } else if (type.contentEquals("xs:string")) {
            fieldSource.setType(String.class);
        }else if (type.contentEquals("TServ")) {
            fieldSource.setType(String.class);
        }else if (type.contentEquals("xs:token")) {
            fieldSource.setType(String.class);
        }else {
            System.out.println("OK");
        }
    }

    private void buildSchemas(Xsd file) throws  DocumentException {
        if (!fileDocumentHashMap.containsKey(file.getFile().getAbsolutePath())) {

            SAXReader reader = new SAXReader();
            Document document = reader.read(file.getFile());
            Element schema = document.getRootElement();
            for (Iterator<Element> it = schema.elementIterator(); it.hasNext();) {
                final Element element = it.next();
                String path = file.getFile().getParentFile().getAbsolutePath();
                String name = element.getName();
                if (name.contentEquals("include")) {
                    String schemaLocation = element.attribute("schemaLocation").getValue();
                    File ff = new File(path + "\\" + schemaLocation);
                    String pp = file.getPackageName();
                    for (Xsd f1 : this.files) {
                        String p1 = f1.getFile().getAbsolutePath();
                        String p2 = ff.getAbsolutePath();

                        if (p1.contentEquals(p2)) {
                            pp = f1.getPackageName();
                        }
                    }
                    Xsd d = new Xsd(ff, pp);
                    buildSchemas(d);
                }
            }
            file.setDocument(document);

            fileDocumentHashMap.put(file.getFile().getAbsolutePath(), file);
        }
    }

}
