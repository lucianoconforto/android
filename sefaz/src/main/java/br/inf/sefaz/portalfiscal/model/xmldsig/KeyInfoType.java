package br.inf.sefaz.portalfiscal.model.xmldsig;

import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Attribute;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;

@WXml
@Order(elements = "X509Data")
public class KeyInfoType {

	@Element(name = "X509Data")
	@Validation(required = true, minOccurs = "1")
	private X509DataType X509Data;
	@Attribute(name = "Id")
	private String Id;

	public X509DataType getX509Data() {
		return this.X509Data;
	}

	public void setX509Data(X509DataType X509Data) {
		this.X509Data = X509Data;
	}

	public String getId() {
		return this.Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}
}