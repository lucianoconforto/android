package br.inf.sefaz.portalfiscal.model.xmldsig;

import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;

@WXml
@Order(elements = "X509Certificate")
public class X509DataType {

	@Element(name = "X509Certificate")
	@Validation(required = true, minOccurs = "1")
	private String X509Certificate;

	public String getX509Certificate() {
		return this.X509Certificate;
	}

	public void setX509Certificate(String X509Certificate) {
		this.X509Certificate = X509Certificate;
	}
}