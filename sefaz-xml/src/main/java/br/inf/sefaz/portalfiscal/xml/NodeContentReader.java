package br.inf.sefaz.portalfiscal.xml;
import org.dom4j.Element;
import org.dom4j.QName;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NodeContentReader extends NodeContent {
    private List<Element> elements;

    public NodeContentReader(Element element) {
        this.elements = new ArrayList<>();
        this.elements.add(element);
    }
    public NodeContentReader(List<Element> elements) {
        this.elements = elements;
    }

    @Override
    public <T> T readEntity(XmlSerializer serializer , Class<T> tClass, Map<String,QName> qNameMap) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (elements==null|| elements.size()==0)
            return null;
        return (T) serializer.decode(elements.get(0),tClass,qNameMap);
    }

    @Override
    public  <T> List<T> readEntityList(XmlSerializer serializer , Class<T> tClass , Map<String,QName> qNameMap) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (elements==null|| elements.size()==0)
            return null;
        List<T> ts = new ArrayList<>();
        for (Element element :       elements) {
            ts.add( (T) serializer.decode(element,tClass,qNameMap));
        }
        return ts;
    }
    @Override
    public  Element getElement(XmlSerializer serializer, Map<String,QName> qNameMap ) {
        if (elements==null|| elements.size()==0)
            return null;
        return elements.get(0);
    }

    @Override
    public List<Element> getElementList(XmlSerializer serializer, Map<String,QName> qNameMap ) {
        return elements;
    }
}
