package br.inf.sefaz.portalfiscal.model.xmldsig;

import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Embeddable;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;

@Embeddable
@WXml
public class Signature {

	@Element(name = "name")
	@Validation(required = false, minOccurs = "1")
	private SignatureType content;

	public SignatureType getContent() {
		return this.content;
	}

	public void setContent(SignatureType content) {
		this.content = content;
	}
}