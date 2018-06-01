package br.inf.sefaz.portalfiscal.model.xmldsig;

import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Attribute;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;

@WXml
@Order(elements = {"Transforms", "DigestMethod", "DigestValue"})
public class ReferenceType {

	@Element(name = "Transforms")
	@Validation(required = true, minOccurs = "1")
	private TransformsType Transforms;
	@Element(name = "DigestMethod")
	@Validation(required = true, minOccurs = "1")
	private DigestMethod DigestMethod;
	@Element(name = "DigestValue")
	@Validation(required = true, minOccurs = "1")
	private String DigestValue;
	@Attribute(name = "Id")
	private String Id;
	/**
	 */
	@Validation(minLength = "2", text = "")
	@Attribute(name = "URI")
	private String URI;
	@Attribute(name = "Type")
	private String Type;

	public TransformsType getTransforms() {
		return this.Transforms;
	}

	public void setTransforms(TransformsType Transforms) {
		this.Transforms = Transforms;
	}

	@WXml
	@Element(name = "DigestMethod")
	public static class DigestMethod {
		@Attribute(name = "Algorithm")
		private String Algorithm;

		public String getAlgorithm() {
			return this.Algorithm;
		}

		public void setAlgorithm(String Algorithm) {
			this.Algorithm = Algorithm;
		}
	}

	public DigestMethod getDigestMethod() {
		return this.DigestMethod;
	}

	public void setDigestMethod(DigestMethod DigestMethod) {
		this.DigestMethod = DigestMethod;
	}

	public String getDigestValue() {
		return this.DigestValue;
	}

	public void setDigestValue(String DigestValue) {
		this.DigestValue = DigestValue;
	}

	public String getId() {
		return this.Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	public String getURI() {
		return this.URI;
	}

	public void setURI(String URI) {
		this.URI = URI;
	}

	public String getType() {
		return this.Type;
	}

	public void setType(String Type) {
		this.Type = Type;
	}
}