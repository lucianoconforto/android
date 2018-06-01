package br.inf.sefaz.portalfiscal.model.nfe_v4;

import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;
import br.inf.sefaz.portalfiscal.xml.annotation.Attribute;

/**
 * Tipo Retorno do Pedido de Autorização da Nota Fiscal Eletrônica
 */
@Validation(choices = "[{\"items\":[\"infRec\"]},{\"items\":[\"protNFe\"]}]")
@WXml
@Order(elements = {"tpAmb", "verAplic", "cStat", "xMotivo", "cUF", "dhRecbto",
		"infRec", "protNFe"})
public class TRetEnviNFe {

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
	/**
	 * Tipo Código da UF da tabela do IBGE
	 */
	@Validation(whiteSpace = "preserve", enumerations = {"11", "12", "13",
			"14", "15", "16", "17", "21", "22", "23", "24", "25", "26", "27",
			"28", "29", "31", "32", "33", "35", "41", "42", "43", "50", "51",
			"52", "53"}, text = "Tipo C\u00F3digo da UF da tabela do IBGE", required = true, minOccurs = "1")
	@Element(name = "cUF")
	private String cUF;
	/**
	 * Data e Hora, formato UTC (AAAA-MM-DDThh:mm:ssTZD, onde TZD = +hh:mm ou
	 * -hh:mm)
	 */
	@Validation(whiteSpace = "preserve", pattern = "(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))T(20|21|22|23|[0-1]\\d):[0-5]\\d:[0-5]\\d([\\-,\\+](0[0-9]|10|11):00|([\\+](12):00))", text = "Data e Hora, formato UTC (AAAA-MM-DDThh:mm:ssTZD, onde TZD = +hh:mm ou -hh:mm)", required = true, minOccurs = "1")
	@Element(name = "dhRecbto")
	private String dhRecbto;
	/**
	 * Dados do Recibo do Lote
	 */
	@Element(name = "infRec")
	@Validation(required = false, minOccurs = "0")
	private InfRec infRec;
	/**
	 * Protocolo de status resultado do processamento sincrono da NFC-e
	 */
	@Element(name = "protNFe")
	@Validation(required = false, minOccurs = "0")
	private TProtNFe protNFe;
	/**
	 * Tipo Versão da NF-e - 4.00
	 */
	@Validation(whiteSpace = "preserve", pattern = "4\\.00", text = "Tipo Vers\u00E3o da NF-e - 4.00")
	@Attribute(name = "versao")
	private String versao;

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

	public String getCUF() {
		return this.cUF;
	}

	public void setCUF(String cUF) {
		this.cUF = cUF;
	}

	public String getDhRecbto() {
		return this.dhRecbto;
	}

	public void setDhRecbto(String dhRecbto) {
		this.dhRecbto = dhRecbto;
	}

	@WXml
	@Order(elements = {"nRec", "tMed"})
	@Element(name = "infRec")
	public static class InfRec {
		/**
		 * Tipo Número do Recibo do envio de lote de NF-e
		 */
		@Validation(whiteSpace = "preserve", maxLength = "15", pattern = "[0-9]{15}", text = "Tipo N\u00FAmero do Recibo do envio de lote de NF-e", required = true, minOccurs = "1")
		@Element(name = "nRec")
		private String nRec;
		/**
		 * Tipo temp médio em segundos
		 */
		@Validation(whiteSpace = "preserve", pattern = "[0-9]{1,4}", text = "Tipo temp m\u00E9dio em segundos", required = true, minOccurs = "1")
		@Element(name = "tMed")
		private String tMed;

		public String getNRec() {
			return this.nRec;
		}

		public void setNRec(String nRec) {
			this.nRec = nRec;
		}

		public String getTMed() {
			return this.tMed;
		}

		public void setTMed(String tMed) {
			this.tMed = tMed;
		}
	}

	public InfRec getInfRec() {
		return this.infRec;
	}

	public void setInfRec(InfRec infRec) {
		this.infRec = infRec;
	}

	public TProtNFe getProtNFe() {
		return this.protNFe;
	}

	public void setProtNFe(TProtNFe protNFe) {
		this.protNFe = protNFe;
	}

	public String getVersao() {
		return this.versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}
}