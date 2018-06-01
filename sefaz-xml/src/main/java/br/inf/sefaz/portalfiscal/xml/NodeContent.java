package br.inf.sefaz.portalfiscal.xml;

import org.dom4j.Element;
import org.dom4j.QName;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public abstract class NodeContent {
   public abstract  <T> T readEntity(XmlSerializer serializer , Class<T> tClass, Map<String,QName> qNameMap) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
   public abstract  <T> List<T> readEntityList(XmlSerializer serializer, Class<T> tClass, Map<String,QName> qNameMap) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
   public abstract Element getElement(XmlSerializer serializer , Map<String,QName> qNameMap ) throws Exception;
   public abstract List<Element> getElementList(XmlSerializer serializer, Map<String,QName> qNameMap ) throws Exception;
}
