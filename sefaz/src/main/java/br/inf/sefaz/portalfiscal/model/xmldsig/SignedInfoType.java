package br.inf.sefaz.portalfiscal.model.xmldsig;

import br.inf.sefaz.portalfiscal.xml.annotation.Attribute;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;

@WXml
@Order(elements = {"CanonicalizationMethod", "SignatureMethod", "Reference"})
public class SignedInfoType {

	@Element(name = "CanonicalizationMethod")
	@Validation(required = true, minOccurs = "1")
	private CanonicalizationMethod CanonicalizationMethod;
	@Element(name = "SignatureMethod")
	@Validation(required = true, minOccurs = "1")
	private SignatureMethod SignatureMethod;
	@Element(name = "Reference")
	@Validation(required = true, minOccurs = "1")
	private ReferenceType Reference;
	@Attribute(name = "Id")
	private String Id;

	@WXml
	@Element(name = "CanonicalizationMethod")
	public static class CanonicalizationMethod {
		@Attribute(name = "Algorithm")
		private String Algorithm;

		public String getAlgorithm() {
			return this.Algorithm;
		}

		public void setAlgorithm(String Algorithm) {
			this.Algorithm = Algorithm;
		}
	}

	public CanonicalizationMethod getCanonicalizationMethod() {
		return this.CanonicalizationMethod;
	}

	public void setCanonicalizationMethod(
			CanonicalizationMethod CanonicalizationMethod) {
		this.CanonicalizationMethod = CanonicalizationMethod;
	}

	@WXml
	@Element(name = "SignatureMethod")
	public static class SignatureMethod {
		@Attribute(name = "Algorithm")
		private String Algorithm;

		public String getAlgorithm() {
			return this.Algorithm;
		}

		public void setAlgorithm(String Algorithm) {
			this.Algorithm = Algorithm;
		}
	}

	public SignatureMethod getSignatureMethod() {
		return this.SignatureMethod;
	}

	public void setSignatureMethod(SignatureMethod SignatureMethod) {
		this.SignatureMethod = SignatureMethod;
	}

	public ReferenceType getReference() {
		return this.Reference;
	}

	public void setReference(ReferenceType Reference) {
		this.Reference = Reference;
	}

	public String getId() {
		return this.Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}
}