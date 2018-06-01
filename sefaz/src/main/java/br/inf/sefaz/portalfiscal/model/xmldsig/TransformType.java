package br.inf.sefaz.portalfiscal.model.xmldsig;

import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Attribute;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;

@WXml
@Order(elements = "XPath")
public class TransformType {

	@Element(name = "XPath")
	@Validation(required = false, minOccurs = "1")
	private String XPath;
	@Attribute(name = "Algorithm")
	private String Algorithm;

	public String getXPath() {
		return this.XPath;
	}

	public void setXPath(String XPath) {
		this.XPath = XPath;
	}

	public String getAlgorithm() {
		return this.Algorithm;
	}

	public void setAlgorithm(String Algorithm) {
		this.Algorithm = Algorithm;
	}
}