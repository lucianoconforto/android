package br.inf.sefaz.portalfiscal.xml;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;
import org.dom4j.QName;

public class NodeContentWriter extends NodeContent {
    private List value;
    public NodeContentWriter(List value) {
        this.value = value;
    }
    public NodeContentWriter(Object value) {
        if (value!=null){
            this.value = new ArrayList();
            this.value.add(value);
        }
    }
    @Override
    public <T> T readEntity(XmlSerializer serializer , Class<T> tClass, Map<String,QName> qNameMap) {
        if (value==null|| value.size()==0)
            return null;
        return (T) value.get(0);
    }
    @Override
    public  <T> List<T> readEntityList(XmlSerializer serializer , Class<T> tClass, Map<String,QName> qNameMap) {
        if (value==null|| value.size()==0)
            return null;
        return (List<T>) value;
    }
    @Override
    public Element getElement(XmlSerializer serializer , Map<String,QName> qNameMap ) throws Exception {
        if (value==null|| value.size()==0)
            return null;
        return serializer.encode(value.get(0),qNameMap);
    }
    @Override
    public List<Element> getElementList(XmlSerializer serializer , Map<String,QName> qNameMap ) throws Exception {
        if (value==null|| value.size()==0)
            return null;
        List<Element> elements = new ArrayList<>();
        List<Object> l = (List<Object>) value;
        for ( Object i : l){
            elements.add(serializer.encode(i,qNameMap));
        }
        return elements;
    }
}
