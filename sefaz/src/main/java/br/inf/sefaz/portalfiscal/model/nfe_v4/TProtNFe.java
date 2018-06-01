package br.inf.sefaz.portalfiscal.model.nfe_v4;

import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.Attribute;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;
import br.inf.sefaz.portalfiscal.model.xmldsig.SignatureType;

/**
 * Tipo Protocolo de status resultado do processamento da NF-e
 */
@WXml
@Order(elements = "infProt")
public class TProtNFe {

	/**
	 * Dados do protocolo de status
	 */
	@Element(name = "infProt")
	@Validation(required = true, minOccurs = "1")
	private InfProt infProt;
	@Element(name = "signature")
	@Validation(required = false, minOccurs = "0")
	private SignatureType signature;
	/**
	 * Tipo Versão da NF-e - 4.00
	 */
	@Validation(whiteSpace = "preserve", pattern = "4\\.00", text = "Tipo Vers\u00E3o da NF-e - 4.00")
	@Attribute(name = "versao")
	private String versao;

	@WXml
	@Order(elements = {"tpAmb", "verAplic", "chNFe", "dhRecbto", "nProt",
			"digVal", "cStat", "xMotivo"})
	@Element(name = "infProt")
	public static class InfProt {
		/**
		 * Tipo Ambiente
		 */
		@Validation(whiteSpace = "preserve", enumerations = {"1", "2"}, text = "Tipo Ambiente", required = true, minOccurs = "1")
		@Element(name = "tpAmb")
		private String tpAmb;
		/**
		 * Tipo Versão do Aplicativo
		 */
		@Validation(minLength = "1", maxLength = "20", text = "Tipo Vers\u00E3o do Aplicativo", required = true, minOccurs = "1")
		@Element(name = "verAplic")
		private String verAplic;
		/**
		 * Tipo Chave da Nota Fiscal Eletrônica
		 */
		@Validation(whiteSpace = "preserve", maxLength = "44", pattern = "[0-9]{44}", text = "Tipo Chave da Nota Fiscal Eletr\u00F4nica", required = true, minOccurs = "1")
		@Element(name = "chNFe")
		private String chNFe;
		/**
		 * Data e Hora, formato UTC (AAAA-MM-DDThh:mm:ssTZD, onde TZD = +hh:mm
		 * ou -hh:mm)
		 */
		@Validation(whiteSpace = "preserve", pattern = "(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))T(20|21|22|23|[0-1]\\d):[0-5]\\d:[0-5]\\d([\\-,\\+](0[0-9]|10|11):00|([\\+](12):00))", text = "Data e Hora, formato UTC (AAAA-MM-DDThh:mm:ssTZD, onde TZD = +hh:mm ou -hh:mm)", required = true, minOccurs = "1")
		@Element(name = "dhRecbto")
		private String dhRecbto;
		/**
		 * Tipo Número do Protocolo de Status
		 */
		@Validation(whiteSpace = "preserve", maxLength = "15", pattern = "[0-9]{15}", text = "Tipo N\u00FAmero do Protocolo de Status", required = false, minOccurs = "0")
		@Element(name = "nProt")
		private String nProt;
		/**
		 * Digest Value da NF-e processada. Utilizado para conferir a
		 * integridade da NF-e original.
		 */
		@Element(name = "digVal")
		@Validation(required = false, minOccurs = "0")
		private String digVal;
		/**
		 * Tipo Código da Mensagem enviada
		 */
		@Validation(whiteSpace = "preserve", maxLength = "3", pattern = "[0-9]{3}", text = "Tipo C\u00F3digo da Mensagem enviada", required = true, minOccurs = "1")
		@Element(name = "cStat")
		private String cStat;
		/**
		 * Tipo Motivo
		 */
		@Validation(maxLength = "255", minLength = "1", text = "Tipo Motivo", required = true, minOccurs = "1")
		@Element(name = "xMotivo")
		private String xMotivo;
		@Attribute(name = "Id")
		private String Id;

		public String getTpAmb() {
			return this.tpAmb;
		}

		public void setTpAmb(String tpAmb) {
			this.tpAmb = tpAmb;
		}

		public String getVerAplic() {
			return this.verAplic;
		}

		public void setVerAplic(String verAplic) {
			this.verAplic = verAplic;
		}

		public String getChNFe() {
			return this.chNFe;
		}

		public void setChNFe(String chNFe) {
			this.chNFe = chNFe;
		}

		public String getDhRecbto() {
			return this.dhRecbto;
		}

		public void setDhRecbto(String dhRecbto) {
			this.dhRecbto = dhRecbto;
		}

		public String getNProt() {
			return this.nProt;
		}

		public void setNProt(String nProt) {
			this.nProt = nProt;
		}

		public String getDigVal() {
			return this.digVal;
		}

		public void setDigVal(String digVal) {
			this.digVal = digVal;
		}

		public String getCStat() {
			return this.cStat;
		}

		public void setCStat(String cStat) {
			this.cStat = cStat;
		}

		public String getXMotivo() {
			return this.xMotivo;
		}

		public void setXMotivo(String xMotivo) {
			this.xMotivo = xMotivo;
		}

		public String getId() {
			return this.Id;
		}

		public void setId(String Id) {
			this.Id = Id;
		}
	}

	public InfProt getInfProt() {
		return this.infProt;
	}

	public void setInfProt(InfProt infProt) {
		this.infProt = infProt;
	}

	public SignatureType getSignature() {
		return this.signature;
	}

	public void setSignature(SignatureType signature) {
		this.signature = signature;
	}

	public String getVersao() {
		return this.versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}
}