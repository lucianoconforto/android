package br.inf.sefaz.portalfiscal.model.consultaCadastro_v2_00;

import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.model.nfe_v4.TEndereco;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;
import java.util.List;
import java.util.ArrayList;
import br.inf.sefaz.portalfiscal.xml.annotation.ElementList;
import br.inf.sefaz.portalfiscal.xml.annotation.Attribute;

/**
 * Tipo Retorno Pedido de Consulta de cadastro de contribuintes
 */
@WXml
@Order(elements = "infCons")
public class TRetConsCad {

	/**
	 * Dados do Resultado doDados do Pedido de Consulta de cadastro de
	 * contribuintes
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
	@Order(elements = {"verAplic", "cStat", "xMotivo", "UF", "IE", "CNPJ",
			"CPF", "dhCons", "cUF", "infCad"})
	@Element(name = "infCons")
	public static class InfCons {
		/**
		 * Tipo Versão do Aplicativo
		 */
		@Validation(minLength = "1", maxLength = "20", text = "Tipo Vers\u00E3o do Aplicativo", required = true, minOccurs = "1")
		@Element(name = "verAplic")
		private String verAplic;
		/**
		 * Tipo Código da Mensagem enviada
		 */
		@Validation(whiteSpace = "preserve", pattern = "[0-9]{3}", text = "Tipo C\u00F3digo da Mensagem enviada", required = true, minOccurs = "1")
		@Element(name = "cStat")
		private String cStat;
		/**
		 * Tipo Motivo
		 */
		@Validation(maxLength = "255", minLength = "1", text = "Tipo Motivo", required = true, minOccurs = "1")
		@Element(name = "xMotivo")
		private String xMotivo;
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
		/**
		 * Data da Consulta
		 */
		@Element(name = "dhCons")
		@Validation(required = true, minOccurs = "1")
		private String dhCons;
		/**
		 * Tipo Código da UF da tabela do IBGE
		 */
		@Validation(whiteSpace = "preserve", enumerations = {"11", "12", "13",
				"14", "15", "16", "17", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "31", "32", "33", "35", "41", "42", "43",
				"50", "51", "52", "53"}, text = "Tipo C\u00F3digo da UF da tabela do IBGE", required = true, minOccurs = "1")
		@Element(name = "cUF")
		private String cUF;
		/**
		 * Informações cadastrais do contribuinte consultado
		 */
		@ElementList(name = "infCad", inline = true)
		@Validation(required = false, minOccurs = "0")
		private List<InfCad> infCad = new ArrayList();

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

		public String getDhCons() {
			return this.dhCons;
		}

		public void setDhCons(String dhCons) {
			this.dhCons = dhCons;
		}

		public String getCUF() {
			return this.cUF;
		}

		public void setCUF(String cUF) {
			this.cUF = cUF;
		}

		@Validation(choices = "[{\"items\":[\"CNPJ\"]},{\"items\":[\"CPF\"]}]")
		@WXml
		@Order(elements = {"IE", "CNPJ", "CPF", "UF", "cSit", "indCredNFe",
				"indCredCTe", "xNome", "xFant", "xRegApur", "CNAE", "dIniAtiv",
				"dUltSit", "dBaixa", "IEUnica", "IEAtual", "ender"})
		@Element(name = "infCad")
		public static class InfCad {
			/**
			 * Tipo Inscrição Estadual do Emitente // alterado EM 24/10/08 para
			 * aceitar ISENTO
			 */
			@Validation(whiteSpace = "preserve", pattern = "[0-9]{2,14}|ISENTO", text = "Tipo Inscri\u00E7\u00E3o Estadual do Emitente // alterado EM 24/10/08 para aceitar ISENTO", required = true, minOccurs = "1")
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
			/**
			 * Tipo Sigla da UF
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"AC", "AL",
					"AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS",
					"MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR",
					"RS", "SC", "SE", "SP", "TO", "EX"}, text = "Tipo Sigla da UF", required = true, minOccurs = "1")
			@Element(name = "UF")
			private String UF;
			/**
			 * Situação cadastral do contribuinte: 0 - não habilitado 1 -
			 * habilitado
			 */
			@Validation(enumerations = {"0", "1"}, text = "Situa\u00E7\u00E3o cadastral do contribuinte:\n0 - n\u00E3o habilitado\n1 - habilitado", required = true, minOccurs = "1")
			@Element(name = "cSit")
			private String cSit;
			/**
			 * Indicador de contribuinte credenciado a emitir NF-e. 0 - Não
			 * credenciado para emissão da NF-e; 1 - Credenciado; 2 -
			 * Credenciado com obrigatoriedade para todas operações; 3 -
			 * Credenciado com obrigatoriedade parcial; 4 – a SEFAZ não fornece
			 * a informação. Este indicador significa apenas que o contribuinte
			 * é credenciado para emitir NF-e na SEFAZ consultada.
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"0", "1", "2",
					"3", "4"}, text = "Indicador de contribuinte credenciado a emitir NF-e.\n0 - N\u00E3o credenciado para emiss\u00E3o da NF-e;\n1 - Credenciado;\n2 - Credenciado com obrigatoriedade para todas opera\u00E7\u00F5es;\n3 - Credenciado com obrigatoriedade parcial;\n4 \u2013 a SEFAZ n\u00E3o fornece a informa\u00E7\u00E3o.\nEste indicador significa apenas que o contribuinte \u00E9 credenciado para emitir NF-e na SEFAZ consultada.", required = true, minOccurs = "1")
			@Element(name = "indCredNFe")
			private String indCredNFe;
			/**
			 * Indicador de contribuinte credenciado a emitir CT-e. 0 - Não
			 * credenciado para emissão da CT-e; 1 - Credenciado; 2 -
			 * Credenciado com obrigatoriedade para todas operações; 3 -
			 * Credenciado com obrigatoriedade parcial; 4 – a SEFAZ não fornece
			 * a informação. Este indicador significa apenas que o contribuinte
			 * é credenciado para emitir CT-e na SEFAZ consultada.
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"0", "1", "2",
					"3", "4"}, text = "Indicador de contribuinte credenciado a emitir CT-e.\n0 - N\u00E3o credenciado para emiss\u00E3o da CT-e;\n1 - Credenciado;\n2 - Credenciado com obrigatoriedade para todas opera\u00E7\u00F5es;\n3 - Credenciado com obrigatoriedade parcial;\n4 \u2013 a SEFAZ n\u00E3o fornece a informa\u00E7\u00E3o.\nEste indicador significa apenas que o contribuinte \u00E9 credenciado para emitir CT-e na SEFAZ consultada.", required = true, minOccurs = "1")
			@Element(name = "indCredCTe")
			private String indCredCTe;
			/**
			 * Razão Social ou nome do contribuinte
			 */
			@Validation(minLength = "1", maxLength = "60", text = "Raz\u00E3o Social ou nome do contribuinte", required = true, minOccurs = "1")
			@Element(name = "xNome")
			private String xNome;
			/**
			 * Razão Social ou nome do contribuinte
			 */
			@Validation(minLength = "1", maxLength = "60", text = "Raz\u00E3o Social ou nome do contribuinte", required = false, minOccurs = "0")
			@Element(name = "xFant")
			private String xFant;
			/**
			 * Regime de Apuração do ICMS
			 */
			@Validation(minLength = "1", maxLength = "60", text = "Regime de Apura\u00E7\u00E3o do ICMS", required = false, minOccurs = "0")
			@Element(name = "xRegApur")
			private String xRegApur;
			/**
			 * CNAE Fiscal do contribuinte
			 */
			@Validation(pattern = "[0-9]{6,7}", text = "CNAE Fiscal do contribuinte", required = false, minOccurs = "0")
			@Element(name = "CNAE")
			private String CNAE;
			/**
			 * Data de início de atividades do contribuinte
			 */
			@Element(name = "dIniAtiv")
			@Validation(required = false, minOccurs = "0")
			private String dIniAtiv;
			/**
			 * Data da última modificação da situação cadastral do contribuinte.
			 */
			@Element(name = "dUltSit")
			@Validation(required = false, minOccurs = "0")
			private String dUltSit;
			/**
			 * Data de ocorrência da baixa do contribuinte.
			 */
			@Element(name = "dBaixa")
			@Validation(required = false, minOccurs = "0")
			private String dBaixa;
			/**
			 * Tipo Inscrição Estadual do Emitente // alterado EM 24/10/08 para
			 * aceitar ISENTO
			 */
			@Validation(whiteSpace = "preserve", pattern = "[0-9]{2,14}|ISENTO", text = "Tipo Inscri\u00E7\u00E3o Estadual do Emitente // alterado EM 24/10/08 para aceitar ISENTO", required = false, minOccurs = "0")
			@Element(name = "IEUnica")
			private String IEUnica;
			/**
			 * Tipo Inscrição Estadual do Emitente // alterado EM 24/10/08 para
			 * aceitar ISENTO
			 */
			@Validation(whiteSpace = "preserve", pattern = "[0-9]{2,14}|ISENTO", text = "Tipo Inscri\u00E7\u00E3o Estadual do Emitente // alterado EM 24/10/08 para aceitar ISENTO", required = false, minOccurs = "0")
			@Element(name = "IEAtual")
			private String IEAtual;
			/**
			 * Endereço
			 */
			@Element(name = "ender")
			@Validation(required = false, minOccurs = "0")
			private TEndereco ender;

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

			public String getUF() {
				return this.UF;
			}

			public void setUF(String UF) {
				this.UF = UF;
			}

			public String getCSit() {
				return this.cSit;
			}

			public void setCSit(String cSit) {
				this.cSit = cSit;
			}

			public String getIndCredNFe() {
				return this.indCredNFe;
			}

			public void setIndCredNFe(String indCredNFe) {
				this.indCredNFe = indCredNFe;
			}

			public String getIndCredCTe() {
				return this.indCredCTe;
			}

			public void setIndCredCTe(String indCredCTe) {
				this.indCredCTe = indCredCTe;
			}

			public String getXNome() {
				return this.xNome;
			}

			public void setXNome(String xNome) {
				this.xNome = xNome;
			}

			public String getXFant() {
				return this.xFant;
			}

			public void setXFant(String xFant) {
				this.xFant = xFant;
			}

			public String getXRegApur() {
				return this.xRegApur;
			}

			public void setXRegApur(String xRegApur) {
				this.xRegApur = xRegApur;
			}

			public String getCNAE() {
				return this.CNAE;
			}

			public void setCNAE(String CNAE) {
				this.CNAE = CNAE;
			}

			public String getDIniAtiv() {
				return this.dIniAtiv;
			}

			public void setDIniAtiv(String dIniAtiv) {
				this.dIniAtiv = dIniAtiv;
			}

			public String getDUltSit() {
				return this.dUltSit;
			}

			public void setDUltSit(String dUltSit) {
				this.dUltSit = dUltSit;
			}

			public String getDBaixa() {
				return this.dBaixa;
			}

			public void setDBaixa(String dBaixa) {
				this.dBaixa = dBaixa;
			}

			public String getIEUnica() {
				return this.IEUnica;
			}

			public void setIEUnica(String IEUnica) {
				this.IEUnica = IEUnica;
			}

			public String getIEAtual() {
				return this.IEAtual;
			}

			public void setIEAtual(String IEAtual) {
				this.IEAtual = IEAtual;
			}

			public TEndereco getEnder() {
				return this.ender;
			}

			public void setEnder(TEndereco ender) {
				this.ender = ender;
			}
		}

		public List<InfCad> getInfCad() {
			return this.infCad;
		}

		public void setInfCad(java.util.List<InfCad> infCad) {
			this.infCad = infCad;
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