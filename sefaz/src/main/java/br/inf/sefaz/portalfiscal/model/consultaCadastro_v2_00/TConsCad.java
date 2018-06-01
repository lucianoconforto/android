package br.inf.sefaz.portalfiscal.model.consultaCadastro_v2_00;

import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;
import br.inf.sefaz.portalfiscal.xml.annotation.Attribute;

/**
 * Tipo Pedido de Consulta de cadastro de contribuintes
 */
@WXml
@Order(elements = "infCons")
public class TConsCad {

	/**
	 * Dados do Pedido de Consulta de cadastro de contribuintes
	 */
	@Element(name = "infCons")
	@Validation(required = true, minOccurs = "1")
	private InfCons infCons;
	/**
	 * Tipo Versão do Leiaute da Consulta Cadastro 2.00
	 */
	@Validation(pattern = "2\\.00", text = "Tipo Vers\u00E3o do Leiaute da Consulta Cadastro 2.00")
	@Attribute(name = "versao")
	private String versao;

	/**
	 * argumento de pesquisa
	 */
	@Validation(choices = "[{\"items\":[\"IE\"]},{\"items\":[\"CNPJ\"]},{\"items\":[\"CPF\"]}]")
	@WXml
	@Order(elements = {"xServ", "UF", "IE", "CNPJ", "CPF"})
	@Element(name = "infCons")
	public static class InfCons {
		/**
		 * Serviço Solicitado
		 */
		@Validation(enumerations = "CONS-CAD", text = "Servi\u00E7o Solicitado", required = true, minOccurs = "1")
		@Element(name = "xServ")
		private String xServ;
		/**
		 * Tipo Sigla da UF consultada
		 */
		@Validation(enumerations = {"AC", "AL", "AM", "AP", "BA", "CE", "DF",
				"ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI",
				"PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO",
				"SU"}, text = "Tipo Sigla da UF consultada", required = true, minOccurs = "1")
		@Element(name = "UF")
		private String UF;
		/**
		 * Tipo Inscrição Estadual do Emitente // alterado EM 24/10/08 para
		 * aceitar ISENTO
		 */
		@Validation(whiteSpace = "preserve", pattern = "[0-9]{2,14}|ISENTO", text = "Tipo Inscri\u00E7\u00E3o Estadual do Emitente // alterado EM 24/10/08 para aceitar ISENTO", required = false, minOccurs = "1")
		@Element(name = "IE")
		private String IE;
		/**
		 * Tipo Número do CNPJ tmanho varíavel (3-14)
		 */
		@Validation(whiteSpace = "preserve", pattern = "[0-9]{3,14}", text = "Tipo N\u00FAmero do CNPJ tmanho var\u00EDavel (3-14)", required = false, minOccurs = "1")
		@Element(name = "CNPJ")
		private String CNPJ;
		/**
		 * Tipo Número do CPF de tamanho variável (3-11)
		 */
		@Validation(whiteSpace = "preserve", pattern = "[0-9]{3,11}", text = "Tipo N\u00FAmero do CPF de tamanho vari\u00E1vel (3-11)", required = false, minOccurs = "1")
		@Element(name = "CPF")
		private String CPF;

		public String getXServ() {
			return this.xServ;
		}

		public void setXServ(String xServ) {
			this.xServ = xServ;
		}

		public String getUF() {
			return this.UF;
		}

		public void setUF(String UF) {
			this.UF = UF;
		}

		public String getIE() {
			return this.IE;
		}

		public void setIE(String IE) {
			this.IE = IE;
		}

		public String getCNPJ() {
			return this.CNPJ;
		}

		public void setCNPJ(String CNPJ) {
			this.CNPJ = CNPJ;
		}

		public String getCPF() {
			return this.CPF;
		}

		public void setCPF(String CPF) {
			this.CPF = CPF;
		}
	}

	public InfCons getInfCons() {
		return this.infCons;
	}

	public void setInfCons(InfCons infCons) {
		this.infCons = infCons;
	}

	public String getVersao() {
		return this.versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}
}