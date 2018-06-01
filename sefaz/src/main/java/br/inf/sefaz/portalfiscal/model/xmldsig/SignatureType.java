package br.inf.sefaz.portalfiscal.model.xmldsig;

import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Attribute;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;

@WXml
@Order(elements = {"SignedInfo", "SignatureValue", "KeyInfo"})
public class SignatureType {

	@Element(name = "SignedInfo")
	@Validation(required = true, minOccurs = "1")
	private SignedInfoType SignedInfo;
	@Element(name = "SignatureValue")
	@Validation(required = true, minOccurs = "1")
	private String SignatureValue;
	@Element(name = "KeyInfo")
	@Validation(required = true, minOccurs = "1")
	private KeyInfoType KeyInfo;
	@Attribute(name = "Id")
	private String Id;

	public SignedInfoType getSignedInfo() {
		return this.SignedInfo;
	}

	public void setSignedInfo(SignedInfoType SignedInfo) {
		this.SignedInfo = SignedInfo;
	}

	public String getSignatureValue() {
		return this.SignatureValue;
	}

	public void setSignatureValue(String SignatureValue) {
		this.SignatureValue = SignatureValue;
	}

	public KeyInfoType getKeyInfo() {
		return this.KeyInfo;
	}

	public void setKeyInfo(KeyInfoType KeyInfo) {
		this.KeyInfo = KeyInfo;
	}

	public String getId() {
		return this.Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}
}