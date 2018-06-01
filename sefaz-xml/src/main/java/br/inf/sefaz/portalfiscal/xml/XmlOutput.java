package br.inf.sefaz.portalfiscal.xml;
import org.dom4j.Attribute;
import org.dom4j.CDATA;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.dom4j.Text;

import java.util.Iterator;

public class XmlOutput {
   public  static final String CANONICAL_XML = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";

    public static byte[] canonicalize(Element element, String canonicalXml) {
        String canonVersion = "C14N";
        boolean withComments = false;
        String xmlS = canonicalizeXml(element, canonVersion, withComments);
        return xmlS.getBytes();
    }

    private static String canonicalizeXml(Element element, String canonVersion, boolean withComments) {
        StringBuffer stringBuffer = new StringBuffer();
        canonicalizeXml(stringBuffer,element,canonVersion,withComments);
        String s = stringBuffer.toString();
        return s;
    }

    private static void canonicalizeXml( StringBuffer stringBuffer ,Element element, String canonVersion, boolean withComments) {
        stringBuffer.append("<"+element.getName());
        String uu = " ";
        if (element.getNamespaceURI()!=null&&element.getNamespaceURI().length()>0){
            Element p = element.getParent();
            if (p==null||p.getNamespaceURI()==null||!p.getNamespacePrefix().contentEquals(p.getNamespacePrefix())||!p.getNamespaceURI().contentEquals(element.getNamespaceURI())){
                if (element.getNamespacePrefix().length()==0){
                    stringBuffer.append(uu+"xmlns=\""+element.getNamespaceURI()+"\"");
                }else {
                    stringBuffer.append(uu+"xmlns:"+element.getNamespacePrefix()+"=\""+element.getNamespaceURI()+"\"");
                }
            }
        }
        for (Attribute attribute:element.attributes()){
            stringBuffer.append(uu+ attribute.getName()+"=\""+attribute.getValue()+"\"");
            uu=" ";
        }
        stringBuffer.append(">");
        for (Iterator<Node> it = element.nodeIterator(); it.hasNext();){
            final Node e = it.next();
            if ( e  instanceof  Element){
                canonicalizeXml(stringBuffer, (Element) e,  canonVersion,  withComments);
            }else  if ( e  instanceof Text){
                String v = e.asXML();
                stringBuffer.append(v);
            }else if ( e  instanceof CDATA){
                String v = e.asXML();
                stringBuffer.append(v);
            }

        }
        stringBuffer.append("</"+element.getName()+">");
    }
}