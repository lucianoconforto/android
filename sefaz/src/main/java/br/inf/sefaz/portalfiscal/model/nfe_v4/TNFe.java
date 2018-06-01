package br.inf.sefaz.portalfiscal.model.nfe_v4;

import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;
import java.util.List;
import java.util.ArrayList;
import br.inf.sefaz.portalfiscal.xml.annotation.ElementList;
import br.inf.sefaz.portalfiscal.xml.annotation.Attribute;
import br.inf.sefaz.portalfiscal.model.xmldsig.SignatureType;

/**
 * Tipo Nota Fiscal Eletrônica
 */
@WXml
@Order(elements = {"infNFe", "infNFeSupl"})
public class TNFe {

	/**
	 * Informações da Nota Fiscal eletrônica
	 */
	@Element(name = "infNFe")
	@Validation(required = true, minOccurs = "1")
	private InfNFe infNFe;
	/**
	 * Informações suplementares Nota Fiscal
	 */
	@Element(name = "infNFeSupl")
	@Validation(required = false, minOccurs = "0")
	private InfNFeSupl infNFeSupl;
	@Element(name = "signature")
	@Validation(required = true, minOccurs = "1")
	private SignatureType signature;

	@WXml
	@Order(elements = {"ide", "emit", "avulsa", "dest", "retirada", "entrega",
			"autXML", "det", "total", "transp", "cobr", "pag", "infAdic",
			"exporta", "compra", "cana"})
	@Element(name = "infNFe")
	public static class InfNFe {
		/**
		 * identificação da NF-e
		 */
		@Element(name = "ide")
		@Validation(required = true, minOccurs = "1")
		private Ide ide;
		/**
		 * Identificação do emitente
		 */
		@Element(name = "emit")
		@Validation(required = true, minOccurs = "1")
		private Emit emit;
		/**
		 * Emissão de avulsa, informar os dados do Fisco emitente
		 */
		@Element(name = "avulsa")
		@Validation(required = false, minOccurs = "0")
		private Avulsa avulsa;
		/**
		 * Identificação do Destinatário
		 */
		@Element(name = "dest")
		@Validation(required = false, minOccurs = "0")
		private Dest dest;
		/**
		 * Identificação do Local de Retirada (informar apenas quando for
		 * diferente do endereço do remetente)
		 */
		@Element(name = "retirada")
		@Validation(required = false, minOccurs = "0")
		private TLocal retirada;
		/**
		 * Identificação do Local de Entrega (informar apenas quando for
		 * diferente do endereço do destinatário)
		 */
		@Element(name = "entrega")
		@Validation(required = false, minOccurs = "0")
		private TLocal entrega;
		/**
		 * Pessoas autorizadas para o download do XML da NF-e
		 */
		@ElementList(name = "autXML", inline = true)
		@Validation(required = false, minOccurs = "0")
		private List<AutXML> autXML = new ArrayList();
		/**
		 * Dados dos detalhes da NF-e
		 */
		@ElementList(name = "det", inline = true)
		@Validation(required = true, minOccurs = "1")
		private List<Det> det = new ArrayList();
		/**
		 * Dados dos totais da NF-e
		 */
		@Element(name = "total")
		@Validation(required = true, minOccurs = "1")
		private Total total;
		/**
		 * Dados dos transportes da NF-e
		 */
		@Element(name = "transp")
		@Validation(required = true, minOccurs = "1")
		private Transp transp;
		/**
		 * Dados da cobrança da NF-e
		 */
		@Element(name = "cobr")
		@Validation(required = false, minOccurs = "0")
		private Cobr cobr;
		/**
		 * Dados de Pagamento. Obrigatório apenas para (NFC-e) NT 2012/004
		 */
		@Element(name = "pag")
		@Validation(required = true, minOccurs = "1")
		private Pag pag;
		/**
		 * Informações adicionais da NF-e
		 */
		@Element(name = "infAdic")
		@Validation(required = false, minOccurs = "0")
		private InfAdic infAdic;
		/**
		 * Informações de exportação
		 */
		@Element(name = "exporta")
		@Validation(required = false, minOccurs = "0")
		private Exporta exporta;
		/**
		 * Informações de compras (Nota de Empenho, Pedido e Contrato)
		 */
		@Element(name = "compra")
		@Validation(required = false, minOccurs = "0")
		private Compra compra;
		/**
		 * Informações de registro aquisições de cana
		 */
		@Element(name = "cana")
		@Validation(required = false, minOccurs = "0")
		private Cana cana;
		/**
		 * Tipo Versão da NF-e - 4.00
		 */
		@Validation(whiteSpace = "preserve", pattern = "4\\.00", text = "Tipo Vers\u00E3o da NF-e - 4.00")
		@Attribute(name = "versao")
		private String versao;
		/**
		 * PL_005d - 11/08/09 - validação do Id
		 */
		@Validation(pattern = "NFe[0-9]{44}", text = "PL_005d - 11/08/09 - valida\u00E7\u00E3o do Id")
		@Attribute(name = "Id")
		private String Id;

		/**
		 * Informar apenas para tpEmis diferente de 1
		 */
		@WXml
		@Order(elements = {"cUF", "cNF", "natOp", "mod", "serie", "nNF",
				"dhEmi", "dhSaiEnt", "tpNF", "idDest", "cMunFG", "tpImp",
				"tpEmis", "cDV", "tpAmb", "finNFe", "indFinal", "indPres",
				"procEmi", "verProc", "dhCont", "xJust", "NFref"})
		@Element(name = "ide")
		public static class Ide {
			/**
			 * Tipo Código da UF da tabela do IBGE
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"11", "12",
					"13", "14", "15", "16", "17", "21", "22", "23", "24", "25",
					"26", "27", "28", "29", "31", "32", "33", "35", "41", "42",
					"43", "50", "51", "52", "53"}, text = "Tipo C\u00F3digo da UF da tabela do IBGE", required = true, minOccurs = "1")
			@Element(name = "cUF")
			private String cUF;
			/**
			 * Código numérico que compõe a Chave de Acesso. Número aleatório
			 * gerado pelo emitente para cada NF-e.
			 */
			@Validation(whiteSpace = "preserve", pattern = "[0-9]{8}", text = "C\u00F3digo num\u00E9rico que comp\u00F5e a Chave de Acesso. N\u00FAmero aleat\u00F3rio gerado pelo emitente para cada NF-e.", required = true, minOccurs = "1")
			@Element(name = "cNF")
			private String cNF;
			/**
			 * Descrição da Natureza da Operação
			 */
			@Validation(minLength = "1", maxLength = "60", text = "Descri\u00E7\u00E3o da Natureza da Opera\u00E7\u00E3o", required = true, minOccurs = "1")
			@Element(name = "natOp")
			private String natOp;
			/**
			 * Tipo Modelo Documento Fiscal
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"55", "65"}, text = "Tipo Modelo Documento Fiscal", required = true, minOccurs = "1")
			@Element(name = "mod")
			private String mod;
			/**
			 * Tipo Série do Documento Fiscal
			 */
			@Validation(whiteSpace = "preserve", pattern = "0|[1-9]{1}[0-9]{0,2}", text = "Tipo S\u00E9rie do Documento Fiscal", required = true, minOccurs = "1")
			@Element(name = "serie")
			private String serie;
			/**
			 * Tipo Número do Documento Fiscal
			 */
			@Validation(whiteSpace = "preserve", pattern = "[1-9]{1}[0-9]{0,8}", text = "Tipo N\u00FAmero do Documento Fiscal", required = true, minOccurs = "1")
			@Element(name = "nNF")
			private String nNF;
			/**
			 * Data e Hora, formato UTC (AAAA-MM-DDThh:mm:ssTZD, onde TZD =
			 * +hh:mm ou -hh:mm)
			 */
			@Validation(whiteSpace = "preserve", pattern = "(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))T(20|21|22|23|[0-1]\\d):[0-5]\\d:[0-5]\\d([\\-,\\+](0[0-9]|10|11):00|([\\+](12):00))", text = "Data e Hora, formato UTC (AAAA-MM-DDThh:mm:ssTZD, onde TZD = +hh:mm ou -hh:mm)", required = true, minOccurs = "1")
			@Element(name = "dhEmi")
			private String dhEmi;
			/**
			 * Data e Hora, formato UTC (AAAA-MM-DDThh:mm:ssTZD, onde TZD =
			 * +hh:mm ou -hh:mm)
			 */
			@Validation(whiteSpace = "preserve", pattern = "(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))T(20|21|22|23|[0-1]\\d):[0-5]\\d:[0-5]\\d([\\-,\\+](0[0-9]|10|11):00|([\\+](12):00))", text = "Data e Hora, formato UTC (AAAA-MM-DDThh:mm:ssTZD, onde TZD = +hh:mm ou -hh:mm)", required = false, minOccurs = "0")
			@Element(name = "dhSaiEnt")
			private String dhSaiEnt;
			/**
			 * Tipo do Documento Fiscal (0 - entrada; 1 - saída)
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"0", "1"}, text = "Tipo do Documento Fiscal (0 - entrada; 1 - sa\u00EDda)", required = true, minOccurs = "1")
			@Element(name = "tpNF")
			private String tpNF;
			/**
			 * Identificador de Local de destino da operação
			 * (1-Interna;2-Interestadual;3-Exterior)
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"1", "2", "3"}, text = "Identificador de Local de destino da opera\u00E7\u00E3o (1-Interna;2-Interestadual;3-Exterior)", required = true, minOccurs = "1")
			@Element(name = "idDest")
			private String idDest;
			/**
			 * Tipo Código do Município da tabela do IBGE
			 */
			@Validation(whiteSpace = "preserve", pattern = "[0-9]{7}", text = "Tipo C\u00F3digo do Munic\u00EDpio da tabela do IBGE", required = true, minOccurs = "1")
			@Element(name = "cMunFG")
			private String cMunFG;
			/**
			 * Formato de impressão do DANFE (0-sem DANFE;1-DANFe Retrato;
			 * 2-DANFe Paisagem;3-DANFe Simplificado; 4-DANFe NFC-e;5-DANFe
			 * NFC-e em mensagem eletrônica)
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"0", "1", "2",
					"3", "4", "5"}, text = "Formato de impress\u00E3o do DANFE (0-sem DANFE;1-DANFe Retrato; 2-DANFe Paisagem;3-DANFe Simplificado;\n\t\t\t\t\t\t\t\t\t\t\t4-DANFe NFC-e;5-DANFe NFC-e em mensagem eletr\u00F4nica)", required = true, minOccurs = "1")
			@Element(name = "tpImp")
			private String tpImp;
			/**
			 * Forma de emissão da NF-e 1 - Normal; 2 - Contingência FS 3 -
			 * Contingência SCAN 4 - Contingência DPEC 5 - Contingência FSDA 6 -
			 * Contingência SVC - AN 7 - Contingência SVC - RS 9 - Contingência
			 * off-line NFC-e
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"1", "2", "3",
					"4", "5", "6", "7", "9"}, text = "Forma de emiss\u00E3o da NF-e\n1 - Normal;\n2 - Conting\u00EAncia FS\n3 - Conting\u00EAncia SCAN\n4 - Conting\u00EAncia DPEC\n5 - Conting\u00EAncia FSDA\n6 - Conting\u00EAncia SVC - AN\n7 - Conting\u00EAncia SVC - RS\n9 - Conting\u00EAncia off-line NFC-e", required = true, minOccurs = "1")
			@Element(name = "tpEmis")
			private String tpEmis;
			/**
			 * Digito Verificador da Chave de Acesso da NF-e
			 */
			@Validation(whiteSpace = "preserve", pattern = "[0-9]{1}", text = "Digito Verificador da Chave de Acesso da NF-e", required = true, minOccurs = "1")
			@Element(name = "cDV")
			private String cDV;
			/**
			 * Tipo Ambiente
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"1", "2"}, text = "Tipo Ambiente", required = true, minOccurs = "1")
			@Element(name = "tpAmb")
			private String tpAmb;
			/**
			 * Tipo Finalidade da NF-e (1=Normal; 2=Complementar; 3=Ajuste;
			 * 4=Devolução/Retorno)
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"1", "2", "3",
					"4"}, text = "Tipo Finalidade da NF-e (1=Normal; 2=Complementar; 3=Ajuste; 4=Devolu\u00E7\u00E3o/Retorno)", required = true, minOccurs = "1")
			@Element(name = "finNFe")
			private String finNFe;
			/**
			 * Indica operação com consumidor final (0-Não;1-Consumidor Final)
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"0", "1"}, text = "Indica opera\u00E7\u00E3o com consumidor final (0-N\u00E3o;1-Consumidor Final)", required = true, minOccurs = "1")
			@Element(name = "indFinal")
			private String indFinal;
			/**
			 * Indicador de presença do comprador no estabelecimento comercial
			 * no momento da oepração (0-Não se aplica (ex.: Nota Fiscal
			 * complementar ou de ajuste;1-Operação presencial;2-Não presencial,
			 * internet;3-Não presencial, teleatendimento;4-NFC-e entrega em
			 * domicílio;5-Operação presencial, fora do estabelecimento;9-Não
			 * presencial, outros)
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"0", "1", "2",
					"3", "4", "5", "9"}, text = "Indicador de presen\u00E7a do comprador no estabelecimento comercial no momento da oepra\u00E7\u00E3o\n\t\t\t\t\t\t\t\t\t\t\t(0-N\u00E3o se aplica (ex.: Nota Fiscal complementar ou de ajuste;1-Opera\u00E7\u00E3o presencial;2-N\u00E3o presencial, internet;3-N\u00E3o presencial, teleatendimento;4-NFC-e entrega em domic\u00EDlio;5-Opera\u00E7\u00E3o presencial, fora do estabelecimento;9-N\u00E3o presencial, outros)", required = true, minOccurs = "1")
			@Element(name = "indPres")
			private String indPres;
			/**
			 * Tipo processo de emissão da NF-e
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"0", "1", "2",
					"3"}, text = "Tipo processo de emiss\u00E3o da NF-e", required = true, minOccurs = "1")
			@Element(name = "procEmi")
			private String procEmi;
			/**
			 * versão do aplicativo utilizado no processo de emissão
			 */
			@Validation(minLength = "1", maxLength = "20", text = "vers\u00E3o do aplicativo utilizado no processo de\nemiss\u00E3o", required = true, minOccurs = "1")
			@Element(name = "verProc")
			private String verProc;
			/**
			 * Data e Hora, formato UTC (AAAA-MM-DDThh:mm:ssTZD, onde TZD =
			 * +hh:mm ou -hh:mm)
			 */
			@Validation(whiteSpace = "preserve", pattern = "(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))T(20|21|22|23|[0-1]\\d):[0-5]\\d:[0-5]\\d([\\-,\\+](0[0-9]|10|11):00|([\\+](12):00))", text = "Data e Hora, formato UTC (AAAA-MM-DDThh:mm:ssTZD, onde TZD = +hh:mm ou -hh:mm)", required = false, minOccurs = "1")
			@Element(name = "dhCont")
			private String dhCont;
			/**
			 * Informar a Justificativa da entrada
			 */
			@Validation(minLength = "15", maxLength = "256", text = "Informar a Justificativa da entrada", required = false, minOccurs = "1")
			@Element(name = "xJust")
			private String xJust;
			/**
			 * Grupo de infromações da NF referenciada
			 */
			@ElementList(name = "NFref", inline = true)
			@Validation(required = false, minOccurs = "0")
			private List<NFref> NFref = new ArrayList();

			public String getCUF() {
				return this.cUF;
			}

			public void setCUF(String cUF) {
				this.cUF = cUF;
			}

			public String getCNF() {
				return this.cNF;
			}

			public void setCNF(String cNF) {
				this.cNF = cNF;
			}

			public String getNatOp() {
				return this.natOp;
			}

			public void setNatOp(String natOp) {
				this.natOp = natOp;
			}

			public String getMod() {
				return this.mod;
			}

			public void setMod(String mod) {
				this.mod = mod;
			}

			public String getSerie() {
				return this.serie;
			}

			public void setSerie(String serie) {
				this.serie = serie;
			}

			public String getNNF() {
				return this.nNF;
			}

			public void setNNF(String nNF) {
				this.nNF = nNF;
			}

			public String getDhEmi() {
				return this.dhEmi;
			}

			public void setDhEmi(String dhEmi) {
				this.dhEmi = dhEmi;
			}

			public String getDhSaiEnt() {
				return this.dhSaiEnt;
			}

			public void setDhSaiEnt(String dhSaiEnt) {
				this.dhSaiEnt = dhSaiEnt;
			}

			public String getTpNF() {
				return this.tpNF;
			}

			public void setTpNF(String tpNF) {
				this.tpNF = tpNF;
			}

			public String getIdDest() {
				return this.idDest;
			}

			public void setIdDest(String idDest) {
				this.idDest = idDest;
			}

			public String getCMunFG() {
				return this.cMunFG;
			}

			public void setCMunFG(String cMunFG) {
				this.cMunFG = cMunFG;
			}

			public String getTpImp() {
				return this.tpImp;
			}

			public void setTpImp(String tpImp) {
				this.tpImp = tpImp;
			}

			public String getTpEmis() {
				return this.tpEmis;
			}

			public void setTpEmis(String tpEmis) {
				this.tpEmis = tpEmis;
			}

			public String getCDV() {
				return this.cDV;
			}

			public void setCDV(String cDV) {
				this.cDV = cDV;
			}

			public String getTpAmb() {
				return this.tpAmb;
			}

			public void setTpAmb(String tpAmb) {
				this.tpAmb = tpAmb;
			}

			public String getFinNFe() {
				return this.finNFe;
			}

			public void setFinNFe(String finNFe) {
				this.finNFe = finNFe;
			}

			public String getIndFinal() {
				return this.indFinal;
			}

			public void setIndFinal(String indFinal) {
				this.indFinal = indFinal;
			}

			public String getIndPres() {
				return this.indPres;
			}

			public void setIndPres(String indPres) {
				this.indPres = indPres;
			}

			public String getProcEmi() {
				return this.procEmi;
			}

			public void setProcEmi(String procEmi) {
				this.procEmi = procEmi;
			}

			public String getVerProc() {
				return this.verProc;
			}

			public void setVerProc(String verProc) {
				this.verProc = verProc;
			}

			public String getDhCont() {
				return this.dhCont;
			}

			public void setDhCont(String dhCont) {
				this.dhCont = dhCont;
			}

			public String getXJust() {
				return this.xJust;
			}

			public void setXJust(String xJust) {
				this.xJust = xJust;
			}

			@Validation(choices = "[{\"items\":[\"refNFe\"]},{\"items\":[\"refNF\"]},{\"items\":[\"refNFP\"]},{\"items\":[\"refCTe\"]},{\"items\":[\"refECF\"]}]")
			@WXml
			@Order(elements = {"refNFe", "refNF", "refNFP", "refCTe", "refECF"})
			@Element(name = "NFref")
			public static class NFref {
				/**
				 * Tipo Chave da Nota Fiscal Eletrônica
				 */
				@Validation(whiteSpace = "preserve", maxLength = "44", pattern = "[0-9]{44}", text = "Tipo Chave da Nota Fiscal Eletr\u00F4nica", required = false, minOccurs = "1")
				@Element(name = "refNFe")
				private String refNFe;
				/**
				 * Dados da NF modelo 1/1A referenciada ou NF modelo 2
				 * referenciada
				 */
				@Element(name = "refNF")
				@Validation(required = false, minOccurs = "1")
				private RefNF refNF;
				/**
				 * Grupo com as informações NF de produtor referenciada
				 */
				@Element(name = "refNFP")
				@Validation(required = false, minOccurs = "1")
				private RefNFP refNFP;
				/**
				 * Tipo Chave da Nota Fiscal Eletrônica
				 */
				@Validation(whiteSpace = "preserve", maxLength = "44", pattern = "[0-9]{44}", text = "Tipo Chave da Nota Fiscal Eletr\u00F4nica", required = false, minOccurs = "1")
				@Element(name = "refCTe")
				private String refCTe;
				/**
				 * Grupo do Cupom Fiscal vinculado à NF-e
				 */
				@Element(name = "refECF")
				@Validation(required = false, minOccurs = "1")
				private RefECF refECF;

				public String getRefNFe() {
					return this.refNFe;
				}

				public void setRefNFe(String refNFe) {
					this.refNFe = refNFe;
				}

				@WXml
				@Order(elements = {"cUF", "AAMM", "CNPJ", "mod", "serie", "nNF"})
				@Element(name = "refNF")
				public static class RefNF {
					/**
					 * Tipo Código da UF da tabela do IBGE
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"11",
							"12", "13", "14", "15", "16", "17", "21", "22",
							"23", "24", "25", "26", "27", "28", "29", "31",
							"32", "33", "35", "41", "42", "43", "50", "51",
							"52", "53"}, text = "Tipo C\u00F3digo da UF da tabela do IBGE", required = true, minOccurs = "1")
					@Element(name = "cUF")
					private String cUF;
					/**
					 * AAMM da emissão
					 */
					@Validation(whiteSpace = "preserve", pattern = "[0-9]{2}[0]{1}[1-9]{1}|[0-9]{2}[1]{1}[0-2]{1}", text = "AAMM da emiss\u00E3o", required = true, minOccurs = "1")
					@Element(name = "AAMM")
					private String AAMM;
					/**
					 * Tipo Número do CNPJ
					 */
					@Validation(whiteSpace = "preserve", maxLength = "14", pattern = "[0-9]{14}", text = "Tipo N\u00FAmero do CNPJ", required = true, minOccurs = "1")
					@Element(name = "CNPJ")
					private String CNPJ;
					/**
					 * Código do modelo do Documento Fiscal. Utilizar 01 para NF
					 * modelo 1/1A e 02 para NF modelo 02
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"01",
							"02"}, text = "C\u00F3digo do modelo do Documento Fiscal. Utilizar 01 para NF modelo 1/1A e 02 para NF modelo 02", required = true, minOccurs = "1")
					@Element(name = "mod")
					private String mod;
					/**
					 * Tipo Série do Documento Fiscal
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|[1-9]{1}[0-9]{0,2}", text = "Tipo S\u00E9rie do Documento Fiscal", required = true, minOccurs = "1")
					@Element(name = "serie")
					private String serie;
					/**
					 * Tipo Número do Documento Fiscal
					 */
					@Validation(whiteSpace = "preserve", pattern = "[1-9]{1}[0-9]{0,8}", text = "Tipo N\u00FAmero do Documento Fiscal", required = true, minOccurs = "1")
					@Element(name = "nNF")
					private String nNF;

					public String getCUF() {
						return this.cUF;
					}

					public void setCUF(String cUF) {
						this.cUF = cUF;
					}

					public String getAAMM() {
						return this.AAMM;
					}

					public void setAAMM(String AAMM) {
						this.AAMM = AAMM;
					}

					public String getCNPJ() {
						return this.CNPJ;
					}

					public void setCNPJ(String CNPJ) {
						this.CNPJ = CNPJ;
					}

					public String getMod() {
						return this.mod;
					}

					public void setMod(String mod) {
						this.mod = mod;
					}

					public String getSerie() {
						return this.serie;
					}

					public void setSerie(String serie) {
						this.serie = serie;
					}

					public String getNNF() {
						return this.nNF;
					}

					public void setNNF(String nNF) {
						this.nNF = nNF;
					}
				}

				public RefNF getRefNF() {
					return this.refNF;
				}

				public void setRefNF(RefNF refNF) {
					this.refNF = refNF;
				}

				@Validation(choices = "[{\"items\":[\"CNPJ\"]},{\"items\":[\"CPF\"]}]")
				@WXml
				@Order(elements = {"cUF", "AAMM", "CNPJ", "CPF", "IE", "mod",
						"serie", "nNF"})
				@Element(name = "refNFP")
				public static class RefNFP {
					/**
					 * Tipo Código da UF da tabela do IBGE
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"11",
							"12", "13", "14", "15", "16", "17", "21", "22",
							"23", "24", "25", "26", "27", "28", "29", "31",
							"32", "33", "35", "41", "42", "43", "50", "51",
							"52", "53"}, text = "Tipo C\u00F3digo da UF da tabela do IBGE", required = true, minOccurs = "1")
					@Element(name = "cUF")
					private String cUF;
					/**
					 * AAMM da emissão da NF de produtor
					 */
					@Validation(whiteSpace = "preserve", pattern = "[0-9]{2}[0]{1}[1-9]{1}|[0-9]{2}[1]{1}[0-2]{1}", text = "AAMM da emiss\u00E3o da NF de produtor", required = true, minOccurs = "1")
					@Element(name = "AAMM")
					private String AAMM;
					/**
					 * Tipo Número do CNPJ
					 */
					@Validation(whiteSpace = "preserve", maxLength = "14", pattern = "[0-9]{14}", text = "Tipo N\u00FAmero do CNPJ", required = false, minOccurs = "1")
					@Element(name = "CNPJ")
					private String CNPJ;
					/**
					 * Tipo Número do CPF
					 */
					@Validation(whiteSpace = "preserve", maxLength = "11", pattern = "[0-9]{11}", text = "Tipo N\u00FAmero do CPF", required = false, minOccurs = "1")
					@Element(name = "CPF")
					private String CPF;
					/**
					 * Tipo Inscrição Estadual do Destinatário // alterado para
					 * aceitar vazio ou ISENTO - maio/2010 v2.0
					 */
					@Validation(whiteSpace = "preserve", maxLength = "14", pattern = "ISENTO|[0-9]{2,14}", text = "Tipo Inscri\u00E7\u00E3o Estadual do Destinat\u00E1rio // alterado para aceitar vazio ou ISENTO - maio/2010 v2.0", required = true, minOccurs = "1")
					@Element(name = "IE")
					private String IE;
					/**
					 * Código do modelo do Documento Fiscal - utilizar 04 para
					 * NF de produtor ou 01 para NF Avulsa
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"01",
							"04"}, text = "C\u00F3digo do modelo do Documento Fiscal - utilizar 04 para NF de produtor  ou 01 para NF Avulsa", required = true, minOccurs = "1")
					@Element(name = "mod")
					private String mod;
					/**
					 * Tipo Série do Documento Fiscal
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|[1-9]{1}[0-9]{0,2}", text = "Tipo S\u00E9rie do Documento Fiscal", required = true, minOccurs = "1")
					@Element(name = "serie")
					private String serie;
					/**
					 * Tipo Número do Documento Fiscal
					 */
					@Validation(whiteSpace = "preserve", pattern = "[1-9]{1}[0-9]{0,8}", text = "Tipo N\u00FAmero do Documento Fiscal", required = true, minOccurs = "1")
					@Element(name = "nNF")
					private String nNF;

					public String getCUF() {
						return this.cUF;
					}

					public void setCUF(String cUF) {
						this.cUF = cUF;
					}

					public String getAAMM() {
						return this.AAMM;
					}

					public void setAAMM(String AAMM) {
						this.AAMM = AAMM;
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

					public String getIE() {
						return this.IE;
					}

					public void setIE(String IE) {
						this.IE = IE;
					}

					public String getMod() {
						return this.mod;
					}

					public void setMod(String mod) {
						this.mod = mod;
					}

					public String getSerie() {
						return this.serie;
					}

					public void setSerie(String serie) {
						this.serie = serie;
					}

					public String getNNF() {
						return this.nNF;
					}

					public void setNNF(String nNF) {
						this.nNF = nNF;
					}
				}

				public RefNFP getRefNFP() {
					return this.refNFP;
				}

				public void setRefNFP(RefNFP refNFP) {
					this.refNFP = refNFP;
				}

				public String getRefCTe() {
					return this.refCTe;
				}

				public void setRefCTe(String refCTe) {
					this.refCTe = refCTe;
				}

				@WXml
				@Order(elements = {"mod", "nECF", "nCOO"})
				@Element(name = "refECF")
				public static class RefECF {
					/**
					 * Código do modelo do Documento Fiscal Preencher com "2B",
					 * quando se tratar de Cupom Fiscal emitido por máquina
					 * registradora (não ECF), com "2C", quando se tratar de
					 * Cupom Fiscal PDV, ou "2D", quando se tratar de Cupom
					 * Fiscal (emitido por ECF)
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"2B",
							"2C", "2D"}, text = "C\u00F3digo do modelo do Documento Fiscal \nPreencher com \"2B\", quando se tratar de Cupom Fiscal emitido por m\u00E1quina registradora (n\u00E3o ECF), com \"2C\", quando se tratar de Cupom Fiscal PDV, ou \"2D\", quando se tratar de Cupom Fiscal (emitido por ECF)", required = true, minOccurs = "1")
					@Element(name = "mod")
					private String mod;
					/**
					 * Informar o número de ordem seqüencial do ECF que emitiu o
					 * Cupom Fiscal vinculado à NF-e
					 */
					@Validation(whiteSpace = "preserve", pattern = "[0-9]{1,3}", text = "Informar o n\u00FAmero de ordem seq\u00FCencial do ECF que emitiu o Cupom Fiscal vinculado \u00E0 NF-e", required = true, minOccurs = "1")
					@Element(name = "nECF")
					private String nECF;
					/**
					 * Informar o Número do Contador de Ordem de Operação - COO
					 * vinculado à NF-e
					 */
					@Validation(whiteSpace = "preserve", pattern = "[0-9]{1,6}", text = "Informar o N\u00FAmero do Contador de Ordem de Opera\u00E7\u00E3o - COO vinculado \u00E0 NF-e", required = true, minOccurs = "1")
					@Element(name = "nCOO")
					private String nCOO;

					public String getMod() {
						return this.mod;
					}

					public void setMod(String mod) {
						this.mod = mod;
					}

					public String getNECF() {
						return this.nECF;
					}

					public void setNECF(String nECF) {
						this.nECF = nECF;
					}

					public String getNCOO() {
						return this.nCOO;
					}

					public void setNCOO(String nCOO) {
						this.nCOO = nCOO;
					}
				}

				public RefECF getRefECF() {
					return this.refECF;
				}

				public void setRefECF(RefECF refECF) {
					this.refECF = refECF;
				}
			}

			public List<NFref> getNFref() {
				return this.NFref;
			}

			public void setNFref(java.util.List<NFref> NFref) {
				this.NFref = NFref;
			}
		}

		public Ide getIde() {
			return this.ide;
		}

		public void setIde(Ide ide) {
			this.ide = ide;
		}

		/**
		 * Grupo de informações de interesse da Prefeitura
		 */
		@Validation(choices = "[{\"items\":[\"CNPJ\"]},{\"items\":[\"CPF\"]}]")
		@WXml
		@Order(elements = {"CNPJ", "CPF", "xNome", "xFant", "enderEmit", "IE",
				"IEST", "IM", "CNAE", "CRT"})
		@Element(name = "emit")
		public static class Emit {
			/**
			 * Tipo Número do CNPJ
			 */
			@Validation(whiteSpace = "preserve", maxLength = "14", pattern = "[0-9]{14}", text = "Tipo N\u00FAmero do CNPJ", required = false, minOccurs = "1")
			@Element(name = "CNPJ")
			private String CNPJ;
			/**
			 * Tipo Número do CPF
			 */
			@Validation(whiteSpace = "preserve", maxLength = "11", pattern = "[0-9]{11}", text = "Tipo N\u00FAmero do CPF", required = false, minOccurs = "1")
			@Element(name = "CPF")
			private String CPF;
			/**
			 * Razão Social ou Nome do emitente
			 */
			@Validation(maxLength = "60", minLength = "2", text = "Raz\u00E3o Social ou Nome do emitente", required = true, minOccurs = "1")
			@Element(name = "xNome")
			private String xNome;
			/**
			 * Nome fantasia
			 */
			@Validation(maxLength = "60", minLength = "1", text = "Nome fantasia", required = false, minOccurs = "0")
			@Element(name = "xFant")
			private String xFant;
			/**
			 * Endereço do emitente
			 */
			@Element(name = "enderEmit")
			@Validation(required = true, minOccurs = "1")
			private TEnderEmi enderEmit;
			/**
			 * Tipo Inscrição Estadual do Emitente // alterado EM 24/10/08 para
			 * aceitar ISENTO
			 */
			@Validation(whiteSpace = "preserve", maxLength = "14", pattern = "[0-9]{2,14}|ISENTO", text = "Tipo Inscri\u00E7\u00E3o Estadual do Emitente // alterado EM 24/10/08 para aceitar ISENTO", required = true, minOccurs = "1")
			@Element(name = "IE")
			private String IE;
			/**
			 * Tipo Inscrição Estadual do ST // acrescentado EM 24/10/08
			 */
			@Validation(whiteSpace = "preserve", maxLength = "14", pattern = "[0-9]{2,14}", text = "Tipo Inscri\u00E7\u00E3o Estadual do ST // acrescentado EM 24/10/08", required = false, minOccurs = "0")
			@Element(name = "IEST")
			private String IEST;
			/**
			 * Inscrição Municipal
			 */
			@Validation(minLength = "1", maxLength = "15", text = "Inscri\u00E7\u00E3o Municipal", required = false, minOccurs = "1")
			@Element(name = "IM")
			private String IM;
			/**
			 * CNAE Fiscal
			 */
			@Validation(whiteSpace = "preserve", pattern = "[0-9]{7}", text = "CNAE Fiscal", required = false, minOccurs = "0")
			@Element(name = "CNAE")
			private String CNAE;
			/**
			 * Código de Regime Tributário. Este campo será obrigatoriamente
			 * preenchido com: 1 – Simples Nacional; 2 – Simples Nacional –
			 * excesso de sublimite de receita bruta; 3 – Regime Normal.
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"1", "2", "3"}, text = "C\u00F3digo de Regime Tribut\u00E1rio. \nEste campo ser\u00E1 obrigatoriamente preenchido com:\n1 \u2013 Simples Nacional;\n2 \u2013 Simples Nacional \u2013 excesso de sublimite de receita bruta;\n3 \u2013 Regime Normal.", required = true, minOccurs = "1")
			@Element(name = "CRT")
			private String CRT;

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

			public TEnderEmi getEnderEmit() {
				return this.enderEmit;
			}

			public void setEnderEmit(TEnderEmi enderEmit) {
				this.enderEmit = enderEmit;
			}

			public String getIE() {
				return this.IE;
			}

			public void setIE(String IE) {
				this.IE = IE;
			}

			public String getIEST() {
				return this.IEST;
			}

			public void setIEST(String IEST) {
				this.IEST = IEST;
			}

			public String getIM() {
				return this.IM;
			}

			public void setIM(String IM) {
				this.IM = IM;
			}

			public String getCNAE() {
				return this.CNAE;
			}

			public void setCNAE(String CNAE) {
				this.CNAE = CNAE;
			}

			public String getCRT() {
				return this.CRT;
			}

			public void setCRT(String CRT) {
				this.CRT = CRT;
			}
		}

		public Emit getEmit() {
			return this.emit;
		}

		public void setEmit(Emit emit) {
			this.emit = emit;
		}

		@WXml
		@Order(elements = {"CNPJ", "xOrgao", "matr", "xAgente", "fone", "UF",
				"nDAR", "dEmi", "vDAR", "repEmi", "dPag"})
		@Element(name = "avulsa")
		public static class Avulsa {
			/**
			 * Tipo Número do CNPJ
			 */
			@Validation(whiteSpace = "preserve", maxLength = "14", pattern = "[0-9]{14}", text = "Tipo N\u00FAmero do CNPJ", required = true, minOccurs = "1")
			@Element(name = "CNPJ")
			private String CNPJ;
			/**
			 * Órgão emitente
			 */
			@Validation(maxLength = "60", minLength = "1", text = "\u00D3rg\u00E3o emitente", required = true, minOccurs = "1")
			@Element(name = "xOrgao")
			private String xOrgao;
			/**
			 * Matrícula do agente
			 */
			@Validation(minLength = "1", maxLength = "60", text = "Matr\u00EDcula do agente", required = true, minOccurs = "1")
			@Element(name = "matr")
			private String matr;
			/**
			 * Nome do agente
			 */
			@Validation(maxLength = "60", minLength = "1", text = "Nome do agente", required = true, minOccurs = "1")
			@Element(name = "xAgente")
			private String xAgente;
			/**
			 * Telefone
			 */
			@Validation(whiteSpace = "preserve", pattern = "[0-9]{6,14}", text = "Telefone", required = false, minOccurs = "0")
			@Element(name = "fone")
			private String fone;
			/**
			 * Tipo Sigla da UF de emissor // acrescentado em 24/10/08
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"AC", "AL",
					"AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS",
					"MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR",
					"RS", "SC", "SE", "SP", "TO"}, text = "Tipo Sigla da UF de emissor // acrescentado em 24/10/08", required = true, minOccurs = "1")
			@Element(name = "UF")
			private String UF;
			/**
			 * Número do Documento de Arrecadação de Receita
			 */
			@Validation(minLength = "1", maxLength = "60", text = "N\u00FAmero do Documento de Arrecada\u00E7\u00E3o de Receita", required = false, minOccurs = "0")
			@Element(name = "nDAR")
			private String nDAR;
			/**
			 * Tipo data AAAA-MM-DD
			 */
			@Validation(whiteSpace = "preserve", pattern = "(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))", text = "Tipo data AAAA-MM-DD", required = false, minOccurs = "0")
			@Element(name = "dEmi")
			private String dEmi;
			/**
			 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
			 */
			@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "0")
			@Element(name = "vDAR")
			private String vDAR;
			/**
			 * Repartição Fiscal emitente
			 */
			@Validation(minLength = "1", maxLength = "60", text = "Reparti\u00E7\u00E3o Fiscal emitente", required = true, minOccurs = "1")
			@Element(name = "repEmi")
			private String repEmi;
			/**
			 * Tipo data AAAA-MM-DD
			 */
			@Validation(whiteSpace = "preserve", pattern = "(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))", text = "Tipo data AAAA-MM-DD", required = false, minOccurs = "0")
			@Element(name = "dPag")
			private String dPag;

			public String getCNPJ() {
				return this.CNPJ;
			}

			public void setCNPJ(String CNPJ) {
				this.CNPJ = CNPJ;
			}

			public String getXOrgao() {
				return this.xOrgao;
			}

			public void setXOrgao(String xOrgao) {
				this.xOrgao = xOrgao;
			}

			public String getMatr() {
				return this.matr;
			}

			public void setMatr(String matr) {
				this.matr = matr;
			}

			public String getXAgente() {
				return this.xAgente;
			}

			public void setXAgente(String xAgente) {
				this.xAgente = xAgente;
			}

			public String getFone() {
				return this.fone;
			}

			public void setFone(String fone) {
				this.fone = fone;
			}

			public String getUF() {
				return this.UF;
			}

			public void setUF(String UF) {
				this.UF = UF;
			}

			public String getNDAR() {
				return this.nDAR;
			}

			public void setNDAR(String nDAR) {
				this.nDAR = nDAR;
			}

			public String getDEmi() {
				return this.dEmi;
			}

			public void setDEmi(String dEmi) {
				this.dEmi = dEmi;
			}

			public String getVDAR() {
				return this.vDAR;
			}

			public void setVDAR(String vDAR) {
				this.vDAR = vDAR;
			}

			public String getRepEmi() {
				return this.repEmi;
			}

			public void setRepEmi(String repEmi) {
				this.repEmi = repEmi;
			}

			public String getDPag() {
				return this.dPag;
			}

			public void setDPag(String dPag) {
				this.dPag = dPag;
			}
		}

		public Avulsa getAvulsa() {
			return this.avulsa;
		}

		public void setAvulsa(Avulsa avulsa) {
			this.avulsa = avulsa;
		}

		@Validation(choices = "[{\"items\":[\"CNPJ\"]},{\"items\":[\"CPF\"]},{\"items\":[\"idEstrangeiro\"]}]")
		@WXml
		@Order(elements = {"CNPJ", "CPF", "idEstrangeiro", "xNome",
				"enderDest", "indIEDest", "IE", "ISUF", "IM", "email"})
		@Element(name = "dest")
		public static class Dest {
			/**
			 * Tipo Número do CNPJ
			 */
			@Validation(whiteSpace = "preserve", maxLength = "14", pattern = "[0-9]{14}", text = "Tipo N\u00FAmero do CNPJ", required = false, minOccurs = "1")
			@Element(name = "CNPJ")
			private String CNPJ;
			/**
			 * Tipo Número do CPF
			 */
			@Validation(whiteSpace = "preserve", maxLength = "11", pattern = "[0-9]{11}", text = "Tipo N\u00FAmero do CPF", required = false, minOccurs = "1")
			@Element(name = "CPF")
			private String CPF;
			/**
			 * Identificador do destinatário, em caso de comprador estrangeiro
			 */
			@Validation(whiteSpace = "preserve", pattern = "([!-\u00FF]{0}|[!-\u00FF]{5,20})?", text = "Identificador do destinat\u00E1rio, em caso de comprador estrangeiro", required = false, minOccurs = "1")
			@Element(name = "idEstrangeiro")
			private String idEstrangeiro;
			/**
			 * Razão Social ou nome do destinatário
			 */
			@Validation(maxLength = "60", minLength = "2", text = "Raz\u00E3o Social ou nome do destinat\u00E1rio", required = false, minOccurs = "0")
			@Element(name = "xNome")
			private String xNome;
			/**
			 * Dados do endereço
			 */
			@Element(name = "enderDest")
			@Validation(required = false, minOccurs = "0")
			private TEndereco enderDest;
			/**
			 * Indicador da IE do destinatário: 1 – Contribuinte ICMSpagamento à
			 * vista; 2 – Contribuinte isento de inscrição; 9 – Não Contribuinte
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"1", "2", "9"}, text = "Indicador da IE do destinat\u00E1rio:\n1 \u2013 Contribuinte ICMSpagamento \u00E0 vista;\n2 \u2013 Contribuinte isento de inscri\u00E7\u00E3o;\n9 \u2013 N\u00E3o Contribuinte", required = true, minOccurs = "1")
			@Element(name = "indIEDest")
			private String indIEDest;
			/**
			 * Tipo Inscrição Estadual do Destinatário // alterado para aceitar
			 * vazio ou ISENTO - maio/2010 v2.0
			 */
			@Validation(whiteSpace = "preserve", maxLength = "14", pattern = "[0-9]{2,14}", text = "Tipo Inscri\u00E7\u00E3o Estadual do Destinat\u00E1rio // alterado para aceitar vazio ou ISENTO - maio/2010 v2.0", required = false, minOccurs = "0")
			@Element(name = "IE")
			private String IE;
			/**
			 * Inscrição na SUFRAMA (Obrigatório nas operações com as áreas com
			 * benefícios de incentivos fiscais sob controle da SUFRAMA) PL_005d
			 * - 11/08/09 - alterado para aceitar 8 ou 9 dígitos
			 */
			@Validation(whiteSpace = "preserve", pattern = "[0-9]{8,9}", text = "Inscri\u00E7\u00E3o na SUFRAMA (Obrigat\u00F3rio nas opera\u00E7\u00F5es com as \u00E1reas com benef\u00EDcios de incentivos fiscais sob controle da SUFRAMA) PL_005d - 11/08/09 - alterado para aceitar 8 ou 9 d\u00EDgitos", required = false, minOccurs = "0")
			@Element(name = "ISUF")
			private String ISUF;
			/**
			 * Inscrição Municipal do tomador do serviço
			 */
			@Validation(minLength = "1", maxLength = "15", text = "Inscri\u00E7\u00E3o Municipal do tomador do servi\u00E7o", required = false, minOccurs = "0")
			@Element(name = "IM")
			private String IM;
			/**
			 * Informar o e-mail do destinatário. O campo pode ser utilizado
			 * para informar o e-mail de recepção da NF-e indicada pelo
			 * destinatário
			 */
			@Validation(whiteSpace = "preserve", minLength = "1", maxLength = "60", text = "Informar o e-mail do destinat\u00E1rio. O campo pode ser utilizado para informar o e-mail\nde recep\u00E7\u00E3o da NF-e indicada pelo destinat\u00E1rio", required = false, minOccurs = "0")
			@Element(name = "email")
			private String email;

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

			public String getIdEstrangeiro() {
				return this.idEstrangeiro;
			}

			public void setIdEstrangeiro(String idEstrangeiro) {
				this.idEstrangeiro = idEstrangeiro;
			}

			public String getXNome() {
				return this.xNome;
			}

			public void setXNome(String xNome) {
				this.xNome = xNome;
			}

			public TEndereco getEnderDest() {
				return this.enderDest;
			}

			public void setEnderDest(TEndereco enderDest) {
				this.enderDest = enderDest;
			}

			public String getIndIEDest() {
				return this.indIEDest;
			}

			public void setIndIEDest(String indIEDest) {
				this.indIEDest = indIEDest;
			}

			public String getIE() {
				return this.IE;
			}

			public void setIE(String IE) {
				this.IE = IE;
			}

			public String getISUF() {
				return this.ISUF;
			}

			public void setISUF(String ISUF) {
				this.ISUF = ISUF;
			}

			public String getIM() {
				return this.IM;
			}

			public void setIM(String IM) {
				this.IM = IM;
			}

			public String getEmail() {
				return this.email;
			}

			public void setEmail(String email) {
				this.email = email;
			}
		}

		public Dest getDest() {
			return this.dest;
		}

		public void setDest(Dest dest) {
			this.dest = dest;
		}

		public TLocal getRetirada() {
			return this.retirada;
		}

		public void setRetirada(TLocal retirada) {
			this.retirada = retirada;
		}

		public TLocal getEntrega() {
			return this.entrega;
		}

		public void setEntrega(TLocal entrega) {
			this.entrega = entrega;
		}

		@Validation(choices = "[{\"items\":[\"CNPJ\"]},{\"items\":[\"CPF\"]}]")
		@WXml
		@Order(elements = {"CNPJ", "CPF"})
		@Element(name = "autXML")
		public static class AutXML {
			/**
			 * Tipo Número do CNPJ
			 */
			@Validation(whiteSpace = "preserve", maxLength = "14", pattern = "[0-9]{14}", text = "Tipo N\u00FAmero do CNPJ", required = false, minOccurs = "1")
			@Element(name = "CNPJ")
			private String CNPJ;
			/**
			 * Tipo Número do CPF
			 */
			@Validation(whiteSpace = "preserve", maxLength = "11", pattern = "[0-9]{11}", text = "Tipo N\u00FAmero do CPF", required = false, minOccurs = "1")
			@Element(name = "CPF")
			private String CPF;

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

		public List<AutXML> getAutXML() {
			return this.autXML;
		}

		public void setAutXML(java.util.List<AutXML> autXML) {
			this.autXML = autXML;
		}

		@WXml
		@Order(elements = {"prod", "imposto", "impostoDevol", "infAdProd"})
		@Element(name = "det")
		public static class Det {
			/**
			 * Dados dos produtos e serviços da NF-e
			 */
			@Element(name = "prod")
			@Validation(required = true, minOccurs = "1")
			private Prod prod;
			/**
			 * Tributos incidentes nos produtos ou serviços da NF-e
			 */
			@Element(name = "imposto")
			@Validation(required = true, minOccurs = "1")
			private Imposto imposto;
			@Element(name = "impostoDevol")
			@Validation(required = false, minOccurs = "0")
			private ImpostoDevol impostoDevol;
			/**
			 * Informações adicionais do produto (norma referenciada,
			 * informações complementares, etc)
			 */
			@Validation(minLength = "1", maxLength = "500", text = "Informa\u00E7\u00F5es adicionais do produto (norma referenciada, informa\u00E7\u00F5es complementares, etc)", required = false, minOccurs = "0")
			@Element(name = "infAdProd")
			private String infAdProd;
			/**
			 * Número do item do NF
			 */
			@Validation(whiteSpace = "preserve", pattern = "[1-9]{1}[0-9]{0,1}|[1-8]{1}[0-9]{2}|[9]{1}[0-8]{1}[0-9]{1}|[9]{1}[9]{1}[0]{1}", text = "N\u00FAmero do item do NF")
			@Attribute(name = "nItem")
			private String nItem;

			/**
			 * Informações específicas de produtos e serviços
			 */
			@Validation(choices = "[{\"minOccurs\":0,\"items\":[\"veicProd\"]},{\"minOccurs\":0,\"items\":[\"med\"]},{\"minOccurs\":0,\"items\":[\"arma\"]},{\"minOccurs\":0,\"items\":[\"comb\"]},{\"minOccurs\":0,\"items\":[\"nRECOPI\"]}]")
			@WXml
			@Order(elements = {"cProd", "cEAN", "xProd", "NCM", "NVE", "CEST",
					"indEscala", "CNPJFab", "cBenef", "EXTIPI", "CFOP", "uCom",
					"qCom", "vUnCom", "vProd", "cEANTrib", "uTrib", "qTrib",
					"vUnTrib", "vFrete", "vSeg", "vDesc", "vOutro", "indTot",
					"DI", "detExport", "xPed", "nItemPed", "nFCI", "rastro",
					"veicProd", "med", "arma", "comb", "nRECOPI"})
			@Element(name = "prod")
			public static class Prod {
				/**
				 * Código do produto ou serviço. Preencher com CFOP caso se
				 * trate de itens não relacionados com mercadorias/produto e que
				 * o contribuinte não possua codificação própria Formato
				 * ”CFOP9999”.
				 */
				@Validation(maxLength = "60", minLength = "1", text = "C\u00F3digo do produto ou servi\u00E7o. Preencher com CFOP caso se trate de itens n\u00E3o relacionados com mercadorias/produto e que o contribuinte n\u00E3o possua codifica\u00E7\u00E3o pr\u00F3pria\nFormato \u201DCFOP9999\u201D.", required = true, minOccurs = "1")
				@Element(name = "cProd")
				private String cProd;
				/**
				 * GTIN (Global Trade Item Number) do produto, antigo código EAN
				 * ou código de barras
				 */
				@Validation(whiteSpace = "preserve", pattern = "SEM GTIN|[0-9]{0}|[0-9]{8}|[0-9]{12,14}", text = "GTIN (Global Trade Item Number) do produto, antigo c\u00F3digo EAN ou c\u00F3digo de barras", required = true, minOccurs = "1")
				@Element(name = "cEAN")
				private String cEAN;
				/**
				 * Descrição do produto ou serviço
				 */
				@Validation(maxLength = "120", minLength = "1", text = "Descri\u00E7\u00E3o do produto ou servi\u00E7o", required = true, minOccurs = "1")
				@Element(name = "xProd")
				private String xProd;
				/**
				 * Código NCM (8 posições), será permitida a informação do
				 * gênero (posição do capítulo do NCM) quando a operação não for
				 * de comércio exterior (importação/exportação) ou o produto não
				 * seja tributado pelo IPI. Em caso de item de serviço ou item
				 * que não tenham produto (Ex. transferência de crédito, crédito
				 * do ativo imobilizado, etc.), informar o código 00 (zeros)
				 * (v2.0)
				 */
				@Validation(whiteSpace = "preserve", pattern = "[0-9]{2}|[0-9]{8}", text = "C\u00F3digo NCM (8 posi\u00E7\u00F5es), ser\u00E1 permitida a informa\u00E7\u00E3o do g\u00EAnero (posi\u00E7\u00E3o do cap\u00EDtulo do NCM) quando a opera\u00E7\u00E3o n\u00E3o for de com\u00E9rcio exterior (importa\u00E7\u00E3o/exporta\u00E7\u00E3o) ou o produto n\u00E3o seja tributado pelo IPI. Em caso de item de servi\u00E7o ou item que n\u00E3o tenham produto (Ex. transfer\u00EAncia de cr\u00E9dito, cr\u00E9dito do ativo imobilizado, etc.), informar o c\u00F3digo 00 (zeros) (v2.0)", required = true, minOccurs = "1")
				@Element(name = "NCM")
				private String NCM;
				/**
				 * Nomenclatura de Valor aduaneio e Estatístico
				 */
				@Validation(whiteSpace = "preserve", pattern = "[A-Z]{2}[0-9]{4}", text = "Nomenclatura de Valor aduaneio e Estat\u00EDstico", required = false, minOccurs = "0")
				@ElementList(name = "NVE", inline = true)
				private List<String> NVE = new ArrayList();
				/**
				 * Codigo especificador da Substuicao Tributaria - CEST, que
				 * identifica a mercadoria sujeita aos regimes de substituicao
				 * tributária e de antecipação do recolhimento do imposto
				 */
				@Validation(whiteSpace = "preserve", pattern = "[0-9]{7}", text = "Codigo especificador da Substuicao Tributaria - CEST, que identifica a mercadoria sujeita aos regimes de  substituicao tribut\u00E1ria e de antecipa\u00E7\u00E3o do recolhimento  do imposto", required = false, minOccurs = "1")
				@Element(name = "CEST")
				private String CEST;
				/**
				 */
				@Validation(enumerations = {"S", "N"}, text = "", required = false, minOccurs = "0")
				@Element(name = "indEscala")
				private String indEscala;
				/**
				 * Tipo Número do CNPJ
				 */
				@Validation(whiteSpace = "preserve", maxLength = "14", pattern = "[0-9]{14}", text = "Tipo N\u00FAmero do CNPJ", required = false, minOccurs = "0")
				@Element(name = "CNPJFab")
				private String CNPJFab;
				/**
				 */
				@Validation(length = "10", text = "", required = false, minOccurs = "0")
				@Element(name = "cBenef")
				private String cBenef;
				/**
				 * Código EX TIPI (3 posições)
				 */
				@Validation(whiteSpace = "preserve", pattern = "[0-9]{2,3}", text = "C\u00F3digo EX TIPI (3 posi\u00E7\u00F5es)", required = false, minOccurs = "0")
				@Element(name = "EXTIPI")
				private String EXTIPI;
				/**
				 * Cfop
				 */
				@Validation(whiteSpace = "preserve", pattern = "[1,2,3,5,6,7]{1}[0-9]{3}", text = "Cfop", required = true, minOccurs = "1")
				@Element(name = "CFOP")
				private String CFOP;
				/**
				 * Unidade comercial
				 */
				@Validation(maxLength = "6", minLength = "1", text = "Unidade comercial", required = true, minOccurs = "1")
				@Element(name = "uCom")
				private String uCom;
				/**
				 * Tipo Decimal com 11 inteiros, podendo ter de 1 até 4 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,4}|[1-9]{1}[0-9]{0,10}|[1-9]{1}[0-9]{0,10}(\\.[0-9]{1,4})?", text = "Tipo Decimal com 11 inteiros, podendo ter de 1 at\u00E9 4 decimais", required = true, minOccurs = "1")
				@Element(name = "qCom")
				private String qCom;
				/**
				 * Tipo Decimal com 11 inteiros, podendo ter de 1 até 10
				 * decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,10}|[1-9]{1}[0-9]{0,10}|[1-9]{1}[0-9]{0,10}(\\.[0-9]{1,10})?", text = "Tipo Decimal com 11 inteiros, podendo ter de 1 at\u00E9 10 decimais", required = true, minOccurs = "1")
				@Element(name = "vUnCom")
				private String vUnCom;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vProd")
				private String vProd;
				/**
				 * GTIN (Global Trade Item Number) da unidade tributável, antigo
				 * código EAN ou código de barras
				 */
				@Validation(whiteSpace = "preserve", pattern = "SEM GTIN|[0-9]{0}|[0-9]{8}|[0-9]{12,14}", text = "GTIN (Global Trade Item Number) da unidade tribut\u00E1vel, antigo c\u00F3digo EAN ou c\u00F3digo de barras", required = true, minOccurs = "1")
				@Element(name = "cEANTrib")
				private String cEANTrib;
				/**
				 * Unidade Tributável
				 */
				@Validation(maxLength = "6", minLength = "1", text = "Unidade Tribut\u00E1vel", required = true, minOccurs = "1")
				@Element(name = "uTrib")
				private String uTrib;
				/**
				 * Tipo Decimal com 11 inteiros, podendo ter de 1 até 4 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,4}|[1-9]{1}[0-9]{0,10}|[1-9]{1}[0-9]{0,10}(\\.[0-9]{1,4})?", text = "Tipo Decimal com 11 inteiros, podendo ter de 1 at\u00E9 4 decimais", required = true, minOccurs = "1")
				@Element(name = "qTrib")
				private String qTrib;
				/**
				 * Tipo Decimal com 11 inteiros, podendo ter de 1 até 10
				 * decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,10}|[1-9]{1}[0-9]{0,10}|[1-9]{1}[0-9]{0,10}(\\.[0-9]{1,10})?", text = "Tipo Decimal com 11 inteiros, podendo ter de 1 at\u00E9 10 decimais", required = true, minOccurs = "1")
				@Element(name = "vUnTrib")
				private String vUnTrib;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vFrete")
				private String vFrete;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vSeg")
				private String vSeg;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vDesc")
				private String vDesc;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vOutro")
				private String vOutro;
				/**
				 * Este campo deverá ser preenchido com: 0 – o valor do item
				 * (vProd) não compõe o valor total da NF-e (vProd) 1 – o valor
				 * do item (vProd) compõe o valor total da NF-e (vProd)
				 */
				@Validation(whiteSpace = "preserve", enumerations = {"0", "1"}, text = "Este campo dever\u00E1 ser preenchido com:\n 0 \u2013 o valor do item (vProd) n\u00E3o comp\u00F5e o valor total da NF-e (vProd)\n 1  \u2013 o valor do item (vProd) comp\u00F5e o valor total da NF-e (vProd)", required = true, minOccurs = "1")
				@Element(name = "indTot")
				private String indTot;
				/**
				 * Delcaração de Importação (NT 2011/004)
				 */
				@ElementList(name = "DI", inline = true)
				@Validation(required = false, minOccurs = "0")
				private List<DI> DI = new ArrayList();
				/**
				 * Detalhe da exportação
				 */
				@ElementList(name = "detExport", inline = true)
				@Validation(required = false, minOccurs = "0")
				private List<DetExport> detExport = new ArrayList();
				/**
				 * pedido de compra - Informação de interesse do emissor para
				 * controle do B2B.
				 */
				@Validation(minLength = "1", maxLength = "15", text = "pedido de compra - Informa\u00E7\u00E3o de interesse do emissor para controle do B2B.", required = false, minOccurs = "0")
				@Element(name = "xPed")
				private String xPed;
				/**
				 * Número do Item do Pedido de Compra - Identificação do número
				 * do item do pedido de Compra
				 */
				@Validation(whiteSpace = "preserve", pattern = "[0-9]{1,6}", text = "N\u00FAmero do Item do Pedido de Compra - Identifica\u00E7\u00E3o do n\u00FAmero do item do pedido de Compra", required = false, minOccurs = "0")
				@Element(name = "nItemPed")
				private String nItemPed;
				/**
				 * Identificador único (Globally Unique Identifier)
				 */
				@Validation(whiteSpace = "preserve", pattern = "[A-F0-9]{8}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{4}-[A-F0-9]{12}", text = "Identificador \u00FAnico (Globally Unique Identifier)", required = false, minOccurs = "0")
				@Element(name = "nFCI")
				private String nFCI;
				@ElementList(name = "rastro", inline = true)
				@Validation(required = false, minOccurs = "0")
				private List<Rastro> rastro = new ArrayList();
				/**
				 * Veículos novos
				 */
				@Element(name = "veicProd")
				@Validation(required = false, minOccurs = "1")
				private VeicProd veicProd;
				/**
				 * grupo do detalhamento de Medicamentos e de matérias-primas
				 * farmacêuticas
				 */
				@Element(name = "med")
				@Validation(required = false, minOccurs = "1")
				private Med med;
				/**
				 * Armamentos
				 */
				@ElementList(name = "arma", inline = true)
				@Validation(required = false, minOccurs = "1")
				private List<Arma> arma = new ArrayList();
				/**
				 * Informar apenas para operações com combustíveis líquidos
				 */
				@Element(name = "comb")
				@Validation(required = false, minOccurs = "1")
				private Comb comb;
				/**
				 * Número do RECOPI
				 */
				@Validation(whiteSpace = "preserve", maxLength = "20", pattern = "[0-9]{20}", text = "N\u00FAmero do RECOPI", required = false, minOccurs = "1")
				@Element(name = "nRECOPI")
				private String nRECOPI;

				public String getCProd() {
					return this.cProd;
				}

				public void setCProd(String cProd) {
					this.cProd = cProd;
				}

				public String getCEAN() {
					return this.cEAN;
				}

				public void setCEAN(String cEAN) {
					this.cEAN = cEAN;
				}

				public String getXProd() {
					return this.xProd;
				}

				public void setXProd(String xProd) {
					this.xProd = xProd;
				}

				public String getNCM() {
					return this.NCM;
				}

				public void setNCM(String NCM) {
					this.NCM = NCM;
				}

				public List<String> getNVE() {
					return this.NVE;
				}

				public void setNVE(java.util.List<String> NVE) {
					this.NVE = NVE;
				}

				public String getCEST() {
					return this.CEST;
				}

				public void setCEST(String CEST) {
					this.CEST = CEST;
				}

				public String getIndEscala() {
					return this.indEscala;
				}

				public void setIndEscala(String indEscala) {
					this.indEscala = indEscala;
				}

				public String getCNPJFab() {
					return this.CNPJFab;
				}

				public void setCNPJFab(String CNPJFab) {
					this.CNPJFab = CNPJFab;
				}

				public String getCBenef() {
					return this.cBenef;
				}

				public void setCBenef(String cBenef) {
					this.cBenef = cBenef;
				}

				public String getEXTIPI() {
					return this.EXTIPI;
				}

				public void setEXTIPI(String EXTIPI) {
					this.EXTIPI = EXTIPI;
				}

				public String getCFOP() {
					return this.CFOP;
				}

				public void setCFOP(String CFOP) {
					this.CFOP = CFOP;
				}

				public String getUCom() {
					return this.uCom;
				}

				public void setUCom(String uCom) {
					this.uCom = uCom;
				}

				public String getQCom() {
					return this.qCom;
				}

				public void setQCom(String qCom) {
					this.qCom = qCom;
				}

				public String getVUnCom() {
					return this.vUnCom;
				}

				public void setVUnCom(String vUnCom) {
					this.vUnCom = vUnCom;
				}

				public String getVProd() {
					return this.vProd;
				}

				public void setVProd(String vProd) {
					this.vProd = vProd;
				}

				public String getCEANTrib() {
					return this.cEANTrib;
				}

				public void setCEANTrib(String cEANTrib) {
					this.cEANTrib = cEANTrib;
				}

				public String getUTrib() {
					return this.uTrib;
				}

				public void setUTrib(String uTrib) {
					this.uTrib = uTrib;
				}

				public String getQTrib() {
					return this.qTrib;
				}

				public void setQTrib(String qTrib) {
					this.qTrib = qTrib;
				}

				public String getVUnTrib() {
					return this.vUnTrib;
				}

				public void setVUnTrib(String vUnTrib) {
					this.vUnTrib = vUnTrib;
				}

				public String getVFrete() {
					return this.vFrete;
				}

				public void setVFrete(String vFrete) {
					this.vFrete = vFrete;
				}

				public String getVSeg() {
					return this.vSeg;
				}

				public void setVSeg(String vSeg) {
					this.vSeg = vSeg;
				}

				public String getVDesc() {
					return this.vDesc;
				}

				public void setVDesc(String vDesc) {
					this.vDesc = vDesc;
				}

				public String getVOutro() {
					return this.vOutro;
				}

				public void setVOutro(String vOutro) {
					this.vOutro = vOutro;
				}

				public String getIndTot() {
					return this.indTot;
				}

				public void setIndTot(String indTot) {
					this.indTot = indTot;
				}

				@WXml
				@Order(elements = {"nDI", "dDI", "xLocDesemb", "UFDesemb",
						"dDesemb", "tpViaTransp", "vAFRMM", "tpIntermedio",
						"CNPJ", "UFTerceiro", "cExportador", "adi"})
				@Element(name = "DI")
				public static class DI {
					/**
					 * Numero do Documento de Importação DI/DSI/DA/DRI-E
					 * (DI/DSI/DA/DRI-E) (NT2011/004)
					 */
					@Validation(minLength = "1", maxLength = "12", text = "Numero do Documento de Importa\u00E7\u00E3o DI/DSI/DA/DRI-E (DI/DSI/DA/DRI-E) (NT2011/004)", required = true, minOccurs = "1")
					@Element(name = "nDI")
					private String nDI;
					/**
					 * Tipo data AAAA-MM-DD
					 */
					@Validation(whiteSpace = "preserve", pattern = "(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))", text = "Tipo data AAAA-MM-DD", required = true, minOccurs = "1")
					@Element(name = "dDI")
					private String dDI;
					/**
					 * Local do desembaraço aduaneiro
					 */
					@Validation(minLength = "1", maxLength = "60", text = "Local do desembara\u00E7o aduaneiro", required = true, minOccurs = "1")
					@Element(name = "xLocDesemb")
					private String xLocDesemb;
					/**
					 * Tipo Sigla da UF de emissor // acrescentado em 24/10/08
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"AC",
							"AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO",
							"MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI",
							"PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE",
							"SP", "TO"}, text = "Tipo Sigla da UF de emissor // acrescentado em 24/10/08", required = true, minOccurs = "1")
					@Element(name = "UFDesemb")
					private String UFDesemb;
					/**
					 * Tipo data AAAA-MM-DD
					 */
					@Validation(whiteSpace = "preserve", pattern = "(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))", text = "Tipo data AAAA-MM-DD", required = true, minOccurs = "1")
					@Element(name = "dDesemb")
					private String dDesemb;
					/**
					 * Via de transporte internacional informada na DI
					 * 1-Maritima
					 * ;2-Fluvial;3-Lacustre;4-Aerea;5-Postal;6-Ferroviaria
					 * ;7-Rodoviaria;8-Conduto;9-Meios Proprios;10-Entrada/Saida
					 * Ficta.
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"1",
							"2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
							"12"}, text = "Via de transporte internacional informada na DI\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t1-Maritima;2-Fluvial;3-Lacustre;4-Aerea;5-Postal;6-Ferroviaria;7-Rodoviaria;8-Conduto;9-Meios Proprios;10-Entrada/Saida Ficta.", required = true, minOccurs = "1")
					@Element(name = "tpViaTransp")
					private String tpViaTransp;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "0")
					@Element(name = "vAFRMM")
					private String vAFRMM;
					/**
					 * Forma de Importação quanto a intermediação 1-por conta
					 * propria;2-por conta e ordem;3-encomenda
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"1",
							"2", "3"}, text = "Forma de Importa\u00E7\u00E3o quanto a intermedia\u00E7\u00E3o \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t1-por conta propria;2-por conta e ordem;3-encomenda", required = true, minOccurs = "1")
					@Element(name = "tpIntermedio")
					private String tpIntermedio;
					/**
					 * Tipo Número do CNPJ
					 */
					@Validation(whiteSpace = "preserve", maxLength = "14", pattern = "[0-9]{14}", text = "Tipo N\u00FAmero do CNPJ", required = false, minOccurs = "0")
					@Element(name = "CNPJ")
					private String CNPJ;
					/**
					 * Tipo Sigla da UF de emissor // acrescentado em 24/10/08
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"AC",
							"AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO",
							"MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI",
							"PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE",
							"SP", "TO"}, text = "Tipo Sigla da UF de emissor // acrescentado em 24/10/08", required = false, minOccurs = "0")
					@Element(name = "UFTerceiro")
					private String UFTerceiro;
					/**
					 * Código do exportador (usado nos sistemas internos de
					 * informação do emitente da NF-e)
					 */
					@Validation(minLength = "1", maxLength = "60", text = "C\u00F3digo do exportador (usado nos sistemas internos de informa\u00E7\u00E3o do emitente da NF-e)", required = true, minOccurs = "1")
					@Element(name = "cExportador")
					private String cExportador;
					/**
					 * Adições (NT 2011/004)
					 */
					@ElementList(name = "adi", inline = true)
					@Validation(required = true, minOccurs = "1")
					private List<Adi> adi = new ArrayList();

					public String getNDI() {
						return this.nDI;
					}

					public void setNDI(String nDI) {
						this.nDI = nDI;
					}

					public String getDDI() {
						return this.dDI;
					}

					public void setDDI(String dDI) {
						this.dDI = dDI;
					}

					public String getXLocDesemb() {
						return this.xLocDesemb;
					}

					public void setXLocDesemb(String xLocDesemb) {
						this.xLocDesemb = xLocDesemb;
					}

					public String getUFDesemb() {
						return this.UFDesemb;
					}

					public void setUFDesemb(String UFDesemb) {
						this.UFDesemb = UFDesemb;
					}

					public String getDDesemb() {
						return this.dDesemb;
					}

					public void setDDesemb(String dDesemb) {
						this.dDesemb = dDesemb;
					}

					public String getTpViaTransp() {
						return this.tpViaTransp;
					}

					public void setTpViaTransp(String tpViaTransp) {
						this.tpViaTransp = tpViaTransp;
					}

					public String getVAFRMM() {
						return this.vAFRMM;
					}

					public void setVAFRMM(String vAFRMM) {
						this.vAFRMM = vAFRMM;
					}

					public String getTpIntermedio() {
						return this.tpIntermedio;
					}

					public void setTpIntermedio(String tpIntermedio) {
						this.tpIntermedio = tpIntermedio;
					}

					public String getCNPJ() {
						return this.CNPJ;
					}

					public void setCNPJ(String CNPJ) {
						this.CNPJ = CNPJ;
					}

					public String getUFTerceiro() {
						return this.UFTerceiro;
					}

					public void setUFTerceiro(String UFTerceiro) {
						this.UFTerceiro = UFTerceiro;
					}

					public String getCExportador() {
						return this.cExportador;
					}

					public void setCExportador(String cExportador) {
						this.cExportador = cExportador;
					}

					@WXml
					@Order(elements = {"nAdicao", "nSeqAdic", "cFabricante",
							"vDescDI", "nDraw"})
					@Element(name = "adi")
					public static class Adi {
						/**
						 * Número da Adição
						 */
						@Validation(whiteSpace = "preserve", pattern = "[1-9]{1}[0-9]{0,2}", text = "N\u00FAmero da Adi\u00E7\u00E3o", required = true, minOccurs = "1")
						@Element(name = "nAdicao")
						private String nAdicao;
						/**
						 * Número seqüencial do item dentro da Adição
						 */
						@Validation(whiteSpace = "preserve", pattern = "[1-9]{1}[0-9]{0,2}", text = "N\u00FAmero seq\u00FCencial do item dentro da Adi\u00E7\u00E3o", required = true, minOccurs = "1")
						@Element(name = "nSeqAdic")
						private String nSeqAdic;
						/**
						 * Código do fabricante estrangeiro (usado nos sistemas
						 * internos de informação do emitente da NF-e)
						 */
						@Validation(minLength = "1", maxLength = "60", text = "C\u00F3digo do fabricante estrangeiro (usado nos sistemas internos de informa\u00E7\u00E3o do emitente da NF-e)", required = true, minOccurs = "1")
						@Element(name = "cFabricante")
						private String cFabricante;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais, utilizado em tags opcionais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
						@Element(name = "vDescDI")
						private String vDescDI;
						/**
						 * Número do ato concessório de Drawback
						 */
						@Validation(whiteSpace = "preserve", pattern = "[0-9]{0,11}", text = "N\u00FAmero do ato concess\u00F3rio de Drawback", required = false, minOccurs = "0")
						@Element(name = "nDraw")
						private String nDraw;

						public String getNAdicao() {
							return this.nAdicao;
						}

						public void setNAdicao(String nAdicao) {
							this.nAdicao = nAdicao;
						}

						public String getNSeqAdic() {
							return this.nSeqAdic;
						}

						public void setNSeqAdic(String nSeqAdic) {
							this.nSeqAdic = nSeqAdic;
						}

						public String getCFabricante() {
							return this.cFabricante;
						}

						public void setCFabricante(String cFabricante) {
							this.cFabricante = cFabricante;
						}

						public String getVDescDI() {
							return this.vDescDI;
						}

						public void setVDescDI(String vDescDI) {
							this.vDescDI = vDescDI;
						}

						public String getNDraw() {
							return this.nDraw;
						}

						public void setNDraw(String nDraw) {
							this.nDraw = nDraw;
						}
					}

					public List<Adi> getAdi() {
						return this.adi;
					}

					public void setAdi(java.util.List<Adi> adi) {
						this.adi = adi;
					}
				}

				public List<DI> getDI() {
					return this.DI;
				}

				public void setDI(java.util.List<DI> DI) {
					this.DI = DI;
				}

				@WXml
				@Order(elements = {"nDraw", "exportInd"})
				@Element(name = "detExport")
				public static class DetExport {
					/**
					 * Número do ato concessório de Drawback
					 */
					@Validation(whiteSpace = "preserve", pattern = "[0-9]{0,11}", text = "N\u00FAmero do ato concess\u00F3rio de Drawback", required = false, minOccurs = "0")
					@Element(name = "nDraw")
					private String nDraw;
					/**
					 * Exportação indireta
					 */
					@Element(name = "exportInd")
					@Validation(required = false, minOccurs = "0")
					private ExportInd exportInd;

					public String getNDraw() {
						return this.nDraw;
					}

					public void setNDraw(String nDraw) {
						this.nDraw = nDraw;
					}

					@WXml
					@Order(elements = {"nRE", "chNFe", "qExport"})
					@Element(name = "exportInd")
					public static class ExportInd {
						/**
						 * Registro de exportação
						 */
						@Validation(whiteSpace = "preserve", pattern = "[0-9]{0,12}", text = "Registro de exporta\u00E7\u00E3o", required = true, minOccurs = "1")
						@Element(name = "nRE")
						private String nRE;
						/**
						 * Tipo Chave da Nota Fiscal Eletrônica
						 */
						@Validation(whiteSpace = "preserve", maxLength = "44", pattern = "[0-9]{44}", text = "Tipo Chave da Nota Fiscal Eletr\u00F4nica", required = true, minOccurs = "1")
						@Element(name = "chNFe")
						private String chNFe;
						/**
						 * Tipo Decimal com 11 inteiros, podendo ter de 1 até 4
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,4}|[1-9]{1}[0-9]{0,10}|[1-9]{1}[0-9]{0,10}(\\.[0-9]{1,4})?", text = "Tipo Decimal com 11 inteiros, podendo ter de 1 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "qExport")
						private String qExport;

						public String getNRE() {
							return this.nRE;
						}

						public void setNRE(String nRE) {
							this.nRE = nRE;
						}

						public String getChNFe() {
							return this.chNFe;
						}

						public void setChNFe(String chNFe) {
							this.chNFe = chNFe;
						}

						public String getQExport() {
							return this.qExport;
						}

						public void setQExport(String qExport) {
							this.qExport = qExport;
						}
					}

					public ExportInd getExportInd() {
						return this.exportInd;
					}

					public void setExportInd(ExportInd exportInd) {
						this.exportInd = exportInd;
					}
				}

				public List<DetExport> getDetExport() {
					return this.detExport;
				}

				public void setDetExport(java.util.List<DetExport> detExport) {
					this.detExport = detExport;
				}

				public String getXPed() {
					return this.xPed;
				}

				public void setXPed(String xPed) {
					this.xPed = xPed;
				}

				public String getNItemPed() {
					return this.nItemPed;
				}

				public void setNItemPed(String nItemPed) {
					this.nItemPed = nItemPed;
				}

				public String getNFCI() {
					return this.nFCI;
				}

				public void setNFCI(String nFCI) {
					this.nFCI = nFCI;
				}

				@WXml
				@Order(elements = {"nLote", "qLote", "dFab", "dVal", "cAgreg"})
				@Element(name = "rastro")
				public static class Rastro {
					/**
					 * Número do lote do produto.
					 */
					@Validation(minLength = "1", maxLength = "20", text = "N\u00FAmero do lote do produto.", required = true, minOccurs = "1")
					@Element(name = "nLote")
					private String nLote;
					/**
					 * Tipo Decimal com 8 inteiros, podendo ter de 1 até 3
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{3}|[1-9]{1}[0-9]{0,7}(\\.[0-9]{1,3})?", text = "Tipo Decimal com 8 inteiros, podendo ter de 1 at\u00E9 3 decimais", required = true, minOccurs = "1")
					@Element(name = "qLote")
					private String qLote;
					/**
					 * Tipo data AAAA-MM-DD
					 */
					@Validation(whiteSpace = "preserve", pattern = "(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))", text = "Tipo data AAAA-MM-DD", required = true, minOccurs = "1")
					@Element(name = "dFab")
					private String dFab;
					/**
					 * Tipo data AAAA-MM-DD
					 */
					@Validation(whiteSpace = "preserve", pattern = "(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))", text = "Tipo data AAAA-MM-DD", required = true, minOccurs = "1")
					@Element(name = "dVal")
					private String dVal;
					/**
					 */
					@Validation(whiteSpace = "preserve", pattern = "[0-9]{1,20}", text = "", required = false, minOccurs = "0")
					@Element(name = "cAgreg")
					private String cAgreg;

					public String getNLote() {
						return this.nLote;
					}

					public void setNLote(String nLote) {
						this.nLote = nLote;
					}

					public String getQLote() {
						return this.qLote;
					}

					public void setQLote(String qLote) {
						this.qLote = qLote;
					}

					public String getDFab() {
						return this.dFab;
					}

					public void setDFab(String dFab) {
						this.dFab = dFab;
					}

					public String getDVal() {
						return this.dVal;
					}

					public void setDVal(String dVal) {
						this.dVal = dVal;
					}

					public String getCAgreg() {
						return this.cAgreg;
					}

					public void setCAgreg(String cAgreg) {
						this.cAgreg = cAgreg;
					}
				}

				public List<Rastro> getRastro() {
					return this.rastro;
				}

				public void setRastro(java.util.List<Rastro> rastro) {
					this.rastro = rastro;
				}

				@WXml
				@Order(elements = {"tpOp", "chassi", "cCor", "xCor", "pot",
						"cilin", "pesoL", "pesoB", "nSerie", "tpComb",
						"nMotor", "CMT", "dist", "anoMod", "anoFab", "tpPint",
						"tpVeic", "espVeic", "VIN", "condVeic", "cMod",
						"cCorDENATRAN", "lota", "tpRest"})
				@Element(name = "veicProd")
				public static class VeicProd {
					/**
					 * Tipo da Operação (1 - Venda concessionária; 2 -
					 * Faturamento direto; 3 - Venda direta; 0 - Outros)
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"0",
							"1", "2", "3"}, text = "Tipo da Opera\u00E7\u00E3o (1 - Venda concession\u00E1ria; 2 - Faturamento direto; 3 - Venda direta; 0 - Outros)", required = true, minOccurs = "1")
					@Element(name = "tpOp")
					private String tpOp;
					/**
					 * Chassi do veículo - VIN (código-identificação-veículo)
					 */
					@Validation(length = "17", whiteSpace = "preserve", pattern = "[A-Z0-9]+", text = "Chassi do ve\u00EDculo - VIN (c\u00F3digo-identifica\u00E7\u00E3o-ve\u00EDculo)", required = true, minOccurs = "1")
					@Element(name = "chassi")
					private String chassi;
					/**
					 * Cor do veículo (código de cada montadora)
					 */
					@Validation(minLength = "1", maxLength = "4", text = "Cor do ve\u00EDculo (c\u00F3digo de cada montadora)", required = true, minOccurs = "1")
					@Element(name = "cCor")
					private String cCor;
					/**
					 * Descrição da cor
					 */
					@Validation(minLength = "1", maxLength = "40", text = "Descri\u00E7\u00E3o da cor", required = true, minOccurs = "1")
					@Element(name = "xCor")
					private String xCor;
					/**
					 * Potência máxima do motor do veículo em cavalo vapor (CV).
					 * (potência-veículo)
					 */
					@Validation(minLength = "1", maxLength = "4", text = "Pot\u00EAncia m\u00E1xima do motor do ve\u00EDculo em cavalo vapor (CV). (pot\u00EAncia-ve\u00EDculo)", required = true, minOccurs = "1")
					@Element(name = "pot")
					private String pot;
					/**
					 * Capacidade voluntária do motor expressa em centímetros
					 * cúbicos (CC). (cilindradas)
					 */
					@Validation(minLength = "1", maxLength = "4", text = "Capacidade volunt\u00E1ria do motor expressa em cent\u00EDmetros c\u00FAbicos (CC). (cilindradas)", required = true, minOccurs = "1")
					@Element(name = "cilin")
					private String cilin;
					/**
					 * Peso líquido
					 */
					@Validation(minLength = "1", maxLength = "9", text = "Peso l\u00EDquido", required = true, minOccurs = "1")
					@Element(name = "pesoL")
					private String pesoL;
					/**
					 * Peso bruto
					 */
					@Validation(minLength = "1", maxLength = "9", text = "Peso bruto", required = true, minOccurs = "1")
					@Element(name = "pesoB")
					private String pesoB;
					/**
					 * Serial (série)
					 */
					@Validation(minLength = "1", maxLength = "9", text = "Serial (s\u00E9rie)", required = true, minOccurs = "1")
					@Element(name = "nSerie")
					private String nSerie;
					/**
					 * Tipo de combustível-Tabela RENAVAM: 01-Álcool;
					 * 02-Gasolina; 03-Diesel; 16-Álcool/Gas.;
					 * 17-Gas./Álcool/GNV; 18-Gasolina/Elétrico
					 */
					@Validation(minLength = "1", maxLength = "2", text = "Tipo de combust\u00EDvel-Tabela RENAVAM: 01-\u00C1lcool; 02-Gasolina; 03-Diesel; 16-\u00C1lcool/Gas.; 17-Gas./\u00C1lcool/GNV; 18-Gasolina/El\u00E9trico", required = true, minOccurs = "1")
					@Element(name = "tpComb")
					private String tpComb;
					/**
					 * Número do motor
					 */
					@Validation(minLength = "1", maxLength = "21", text = "N\u00FAmero do motor", required = true, minOccurs = "1")
					@Element(name = "nMotor")
					private String nMotor;
					/**
					 * CMT-Capacidade Máxima de Tração - em Toneladas 4 casas
					 * decimais
					 */
					@Validation(minLength = "1", maxLength = "9", text = "CMT-Capacidade M\u00E1xima de Tra\u00E7\u00E3o - em Toneladas 4 casas decimais", required = true, minOccurs = "1")
					@Element(name = "CMT")
					private String CMT;
					/**
					 * Distância entre eixos
					 */
					@Validation(minLength = "1", maxLength = "4", text = "Dist\u00E2ncia entre eixos", required = true, minOccurs = "1")
					@Element(name = "dist")
					private String dist;
					/**
					 * Ano Modelo de Fabricação
					 */
					@Validation(whiteSpace = "preserve", pattern = "[0-9]{4}", text = "Ano Modelo de Fabrica\u00E7\u00E3o", required = true, minOccurs = "1")
					@Element(name = "anoMod")
					private String anoMod;
					/**
					 * Ano de Fabricação
					 */
					@Validation(whiteSpace = "preserve", pattern = "[0-9]{4}", text = "Ano de Fabrica\u00E7\u00E3o", required = true, minOccurs = "1")
					@Element(name = "anoFab")
					private String anoFab;
					/**
					 * Tipo de pintura
					 */
					@Validation(length = "1", text = "Tipo de pintura", required = true, minOccurs = "1")
					@Element(name = "tpPint")
					private String tpPint;
					/**
					 * Tipo de veículo (utilizar tabela RENAVAM)
					 */
					@Validation(whiteSpace = "preserve", pattern = "[0-9]{1,2}", text = "Tipo de ve\u00EDculo (utilizar tabela RENAVAM)", required = true, minOccurs = "1")
					@Element(name = "tpVeic")
					private String tpVeic;
					/**
					 * Espécie de veículo (utilizar tabela RENAVAM)
					 */
					@Validation(whiteSpace = "preserve", pattern = "[0-9]{1}", text = "Esp\u00E9cie de ve\u00EDculo (utilizar tabela RENAVAM)", required = true, minOccurs = "1")
					@Element(name = "espVeic")
					private String espVeic;
					/**
					 * Informa-se o veículo tem VIN (chassi) remarcado.
					 * R-Remarcado N-NormalVIN
					 */
					@Validation(length = "1", enumerations = {"R", "N"}, text = "Informa-se o ve\u00EDculo tem VIN (chassi) remarcado.\nR-Remarcado\nN-NormalVIN", required = true, minOccurs = "1")
					@Element(name = "VIN")
					private String VIN;
					/**
					 * Condição do veículo (1 - acabado; 2 - inacabado; 3 -
					 * semi-acabado)
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"1",
							"2", "3"}, text = "Condi\u00E7\u00E3o do ve\u00EDculo (1 - acabado; 2 - inacabado; 3 - semi-acabado)", required = true, minOccurs = "1")
					@Element(name = "condVeic")
					private String condVeic;
					/**
					 * Código Marca Modelo (utilizar tabela RENAVAM)
					 */
					@Validation(whiteSpace = "preserve", pattern = "[0-9]{1,6}", text = "C\u00F3digo Marca Modelo (utilizar tabela RENAVAM)", required = true, minOccurs = "1")
					@Element(name = "cMod")
					private String cMod;
					/**
					 * Código da Cor Segundo as regras de pré-cadastro do
					 * DENATRAN:
					 * 01-AMARELO;02-AZUL;03-BEGE;04-BRANCA;05-CINZA;06
					 * -DOURADA;07-GRENA
					 * 08-LARANJA;09-MARROM;10-PRATA;11-PRETA;12
					 * -ROSA;13-ROXA;14-VERDE;15-VERMELHA;16-FANTASIA
					 */
					@Validation(whiteSpace = "preserve", minLength = "1", maxLength = "2", pattern = "[0-9]{1,2}", text = "C\u00F3digo da Cor Segundo as regras de pr\u00E9-cadastro do DENATRAN: 01-AMARELO;02-AZUL;03-BEGE;04-BRANCA;05-CINZA;06-DOURADA;07-GRENA \n08-LARANJA;09-MARROM;10-PRATA;11-PRETA;12-ROSA;13-ROXA;14-VERDE;15-VERMELHA;16-FANTASIA", required = true, minOccurs = "1")
					@Element(name = "cCorDENATRAN")
					private String cCorDENATRAN;
					/**
					 * Quantidade máxima de permitida de passageiros sentados,
					 * inclusive motorista.
					 */
					@Validation(minLength = "1", maxLength = "3", whiteSpace = "preserve", pattern = "[0-9]{1,3}", text = "Quantidade m\u00E1xima de permitida de passageiros sentados, inclusive motorista.", required = true, minOccurs = "1")
					@Element(name = "lota")
					private String lota;
					/**
					 * Restrição 0 - Não há; 1 - Alienação Fiduciária; 2 -
					 * Arrendamento Mercantil; 3 - Reserva de Domínio; 4 -
					 * Penhor de Veículos; 9 - outras.
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"0",
							"1", "2", "3", "4", "9"}, text = "Restri\u00E7\u00E3o\n0 - N\u00E3o h\u00E1;\n1 - Aliena\u00E7\u00E3o Fiduci\u00E1ria;\n2 - Arrendamento Mercantil;\n3 - Reserva de Dom\u00EDnio;\n4 - Penhor de Ve\u00EDculos;\n9 - outras.", required = true, minOccurs = "1")
					@Element(name = "tpRest")
					private String tpRest;

					public String getTpOp() {
						return this.tpOp;
					}

					public void setTpOp(String tpOp) {
						this.tpOp = tpOp;
					}

					public String getChassi() {
						return this.chassi;
					}

					public void setChassi(String chassi) {
						this.chassi = chassi;
					}

					public String getCCor() {
						return this.cCor;
					}

					public void setCCor(String cCor) {
						this.cCor = cCor;
					}

					public String getXCor() {
						return this.xCor;
					}

					public void setXCor(String xCor) {
						this.xCor = xCor;
					}

					public String getPot() {
						return this.pot;
					}

					public void setPot(String pot) {
						this.pot = pot;
					}

					public String getCilin() {
						return this.cilin;
					}

					public void setCilin(String cilin) {
						this.cilin = cilin;
					}

					public String getPesoL() {
						return this.pesoL;
					}

					public void setPesoL(String pesoL) {
						this.pesoL = pesoL;
					}

					public String getPesoB() {
						return this.pesoB;
					}

					public void setPesoB(String pesoB) {
						this.pesoB = pesoB;
					}

					public String getNSerie() {
						return this.nSerie;
					}

					public void setNSerie(String nSerie) {
						this.nSerie = nSerie;
					}

					public String getTpComb() {
						return this.tpComb;
					}

					public void setTpComb(String tpComb) {
						this.tpComb = tpComb;
					}

					public String getNMotor() {
						return this.nMotor;
					}

					public void setNMotor(String nMotor) {
						this.nMotor = nMotor;
					}

					public String getCMT() {
						return this.CMT;
					}

					public void setCMT(String CMT) {
						this.CMT = CMT;
					}

					public String getDist() {
						return this.dist;
					}

					public void setDist(String dist) {
						this.dist = dist;
					}

					public String getAnoMod() {
						return this.anoMod;
					}

					public void setAnoMod(String anoMod) {
						this.anoMod = anoMod;
					}

					public String getAnoFab() {
						return this.anoFab;
					}

					public void setAnoFab(String anoFab) {
						this.anoFab = anoFab;
					}

					public String getTpPint() {
						return this.tpPint;
					}

					public void setTpPint(String tpPint) {
						this.tpPint = tpPint;
					}

					public String getTpVeic() {
						return this.tpVeic;
					}

					public void setTpVeic(String tpVeic) {
						this.tpVeic = tpVeic;
					}

					public String getEspVeic() {
						return this.espVeic;
					}

					public void setEspVeic(String espVeic) {
						this.espVeic = espVeic;
					}

					public String getVIN() {
						return this.VIN;
					}

					public void setVIN(String VIN) {
						this.VIN = VIN;
					}

					public String getCondVeic() {
						return this.condVeic;
					}

					public void setCondVeic(String condVeic) {
						this.condVeic = condVeic;
					}

					public String getCMod() {
						return this.cMod;
					}

					public void setCMod(String cMod) {
						this.cMod = cMod;
					}

					public String getCCorDENATRAN() {
						return this.cCorDENATRAN;
					}

					public void setCCorDENATRAN(String cCorDENATRAN) {
						this.cCorDENATRAN = cCorDENATRAN;
					}

					public String getLota() {
						return this.lota;
					}

					public void setLota(String lota) {
						this.lota = lota;
					}

					public String getTpRest() {
						return this.tpRest;
					}

					public void setTpRest(String tpRest) {
						this.tpRest = tpRest;
					}
				}

				public VeicProd getVeicProd() {
					return this.veicProd;
				}

				public void setVeicProd(VeicProd veicProd) {
					this.veicProd = veicProd;
				}

				@WXml
				@Order(elements = {"cProdANVISA", "vPMC"})
				@Element(name = "med")
				public static class Med {
					/**
					 * Código de Produto da ANVISA. Utilizar o número do
					 * registro do produto da Câmara de Regulação do Mercado de
					 * Medicamento – CMED.
					 */
					@Validation(length = "13", text = "C\u00F3digo de Produto da ANVISA. Utilizar o n\u00FAmero do registro do produto da C\u00E2mara de Regula\u00E7\u00E3o do Mercado de Medicamento \u2013 CMED.", required = true, minOccurs = "1")
					@Element(name = "cProdANVISA")
					private String cProdANVISA;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
					@Element(name = "vPMC")
					private String vPMC;

					public String getCProdANVISA() {
						return this.cProdANVISA;
					}

					public void setCProdANVISA(String cProdANVISA) {
						this.cProdANVISA = cProdANVISA;
					}

					public String getVPMC() {
						return this.vPMC;
					}

					public void setVPMC(String vPMC) {
						this.vPMC = vPMC;
					}
				}

				public Med getMed() {
					return this.med;
				}

				public void setMed(Med med) {
					this.med = med;
				}

				@WXml
				@Order(elements = {"tpArma", "nSerie", "nCano", "descr"})
				@Element(name = "arma")
				public static class Arma {
					/**
					 * Indicador do tipo de arma de fogo (0 - Uso permitido; 1 -
					 * Uso restrito)
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"0",
							"1"}, text = "Indicador do tipo de arma de fogo (0 - Uso permitido; 1 - Uso restrito)", required = true, minOccurs = "1")
					@Element(name = "tpArma")
					private String tpArma;
					/**
					 * Número de série da arma
					 */
					@Validation(minLength = "1", maxLength = "15", text = "N\u00FAmero de s\u00E9rie da arma", required = true, minOccurs = "1")
					@Element(name = "nSerie")
					private String nSerie;
					/**
					 * Número de série do cano
					 */
					@Validation(minLength = "1", maxLength = "15", text = "N\u00FAmero de s\u00E9rie do cano", required = true, minOccurs = "1")
					@Element(name = "nCano")
					private String nCano;
					/**
					 * Descrição completa da arma, compreendendo: calibre,
					 * marca, capacidade, tipo de funcionamento, comprimento e
					 * demais elementos que permitam a sua perfeita
					 * identificação.
					 */
					@Validation(minLength = "1", maxLength = "256", text = "Descri\u00E7\u00E3o completa da arma, compreendendo: calibre, marca, capacidade, tipo de funcionamento, comprimento e demais elementos que permitam a sua perfeita identifica\u00E7\u00E3o.", required = true, minOccurs = "1")
					@Element(name = "descr")
					private String descr;

					public String getTpArma() {
						return this.tpArma;
					}

					public void setTpArma(String tpArma) {
						this.tpArma = tpArma;
					}

					public String getNSerie() {
						return this.nSerie;
					}

					public void setNSerie(String nSerie) {
						this.nSerie = nSerie;
					}

					public String getNCano() {
						return this.nCano;
					}

					public void setNCano(String nCano) {
						this.nCano = nCano;
					}

					public String getDescr() {
						return this.descr;
					}

					public void setDescr(String descr) {
						this.descr = descr;
					}
				}

				public List<Arma> getArma() {
					return this.arma;
				}

				public void setArma(java.util.List<Arma> arma) {
					this.arma = arma;
				}

				@WXml
				@Order(elements = {"cProdANP", "descANP", "pGLP", "pGNn",
						"pGNi", "vPart", "CODIF", "qTemp", "UFCons", "CIDE",
						"encerrante"})
				@Element(name = "comb")
				public static class Comb {
					/**
					 * Código de produto da ANP. codificação de produtos do SIMP
					 * (http://www.anp.gov.br)
					 */
					@Validation(whiteSpace = "preserve", pattern = "[0-9]{9}", text = "C\u00F3digo de produto da ANP. codifica\u00E7\u00E3o de produtos do SIMP (http://www.anp.gov.br)", required = true, minOccurs = "1")
					@Element(name = "cProdANP")
					private String cProdANP;
					/**
					 * Descrição do Produto conforme ANP. Utilizar a descrição
					 * de produtos do Sistema de Informações de Movimentação de
					 * Produtos - SIMP (http://www.anp.gov.br/simp/).
					 */
					@Validation(minLength = "2", maxLength = "95", text = "Descri\u00E7\u00E3o do Produto conforme ANP. Utilizar a descri\u00E7\u00E3o de produtos do Sistema de Informa\u00E7\u00F5es de Movimenta\u00E7\u00E3o de Produtos - SIMP (http://www.anp.gov.br/simp/).", required = true, minOccurs = "1")
					@Element(name = "descANP")
					private String descANP;
					/**
					 * Tipo Decimal com 3 inteiros (no máximo 100), com até 4
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0(\\.[0-9]{2,4})?|[1-9]{1}[0-9]{0,1}(\\.[0-9]{2,4})?|100(\\.0{2,4})?", text = "Tipo Decimal com 3 inteiros (no m\u00E1ximo 100), com at\u00E9 4 decimais", required = false, minOccurs = "0")
					@Element(name = "pGLP")
					private String pGLP;
					/**
					 * Tipo Decimal com 3 inteiros (no máximo 100), com até 4
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0(\\.[0-9]{2,4})?|[1-9]{1}[0-9]{0,1}(\\.[0-9]{2,4})?|100(\\.0{2,4})?", text = "Tipo Decimal com 3 inteiros (no m\u00E1ximo 100), com at\u00E9 4 decimais", required = false, minOccurs = "0")
					@Element(name = "pGNn")
					private String pGNn;
					/**
					 * Tipo Decimal com 3 inteiros (no máximo 100), com até 4
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0(\\.[0-9]{2,4})?|[1-9]{1}[0-9]{0,1}(\\.[0-9]{2,4})?|100(\\.0{2,4})?", text = "Tipo Decimal com 3 inteiros (no m\u00E1ximo 100), com at\u00E9 4 decimais", required = false, minOccurs = "0")
					@Element(name = "pGNi")
					private String pGNi;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "0")
					@Element(name = "vPart")
					private String vPart;
					/**
					 * Código de autorização / registro do CODIF. Informar
					 * apenas quando a UF utilizar o CODIF (Sistema de Controle
					 * do Diferimento do Imposto nas Operações com AEAC - Álcool
					 * Etílico Anidro Combustível).
					 */
					@Validation(whiteSpace = "preserve", pattern = "[0-9]{1,21}", text = "C\u00F3digo de autoriza\u00E7\u00E3o / registro do CODIF. Informar apenas quando a UF utilizar o CODIF (Sistema de Controle do \t\t\tDiferimento do Imposto nas Opera\u00E7\u00F5es com AEAC - \u00C1lcool Et\u00EDlico Anidro Combust\u00EDvel).", required = false, minOccurs = "0")
					@Element(name = "CODIF")
					private String CODIF;
					/**
					 * Tipo Decimal com 12 inteiros, 1 a 4 decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0\\.[1-9]{1}[0-9]{3}|0\\.[0-9]{3}[1-9]{1}|0\\.[0-9]{2}[1-9]{1}[0-9]{1}|0\\.[0-9]{1}[1-9]{1}[0-9]{2}|[1-9]{1}[0-9]{0,11}(\\.[0-9]{4})?", text = "Tipo Decimal com 12 inteiros, 1 a 4 decimais", required = false, minOccurs = "0")
					@Element(name = "qTemp")
					private String qTemp;
					/**
					 * Tipo Sigla da UF
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"AC",
							"AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO",
							"MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI",
							"PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE",
							"SP", "TO", "EX"}, text = "Tipo Sigla da UF", required = true, minOccurs = "1")
					@Element(name = "UFCons")
					private String UFCons;
					/**
					 * CIDE Combustíveis
					 */
					@Element(name = "CIDE")
					@Validation(required = false, minOccurs = "0")
					private CIDE CIDE;
					/**
					 * Informações do grupo de "encerrante"
					 */
					@Element(name = "encerrante")
					@Validation(required = false, minOccurs = "0")
					private Encerrante encerrante;

					public String getCProdANP() {
						return this.cProdANP;
					}

					public void setCProdANP(String cProdANP) {
						this.cProdANP = cProdANP;
					}

					public String getDescANP() {
						return this.descANP;
					}

					public void setDescANP(String descANP) {
						this.descANP = descANP;
					}

					public String getPGLP() {
						return this.pGLP;
					}

					public void setPGLP(String pGLP) {
						this.pGLP = pGLP;
					}

					public String getPGNn() {
						return this.pGNn;
					}

					public void setPGNn(String pGNn) {
						this.pGNn = pGNn;
					}

					public String getPGNi() {
						return this.pGNi;
					}

					public void setPGNi(String pGNi) {
						this.pGNi = pGNi;
					}

					public String getVPart() {
						return this.vPart;
					}

					public void setVPart(String vPart) {
						this.vPart = vPart;
					}

					public String getCODIF() {
						return this.CODIF;
					}

					public void setCODIF(String CODIF) {
						this.CODIF = CODIF;
					}

					public String getQTemp() {
						return this.qTemp;
					}

					public void setQTemp(String qTemp) {
						this.qTemp = qTemp;
					}

					public String getUFCons() {
						return this.UFCons;
					}

					public void setUFCons(String UFCons) {
						this.UFCons = UFCons;
					}

					@WXml
					@Order(elements = {"qBCProd", "vAliqProd", "vCIDE"})
					@Element(name = "CIDE")
					public static class CIDE {
						/**
						 * Tipo Decimal com 12 inteiros de 1 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,4}|[1-9]{1}[0-9]{0,11}|[1-9]{1}[0-9]{0,11}(\\.[0-9]{1,4})?", text = "Tipo Decimal com 12 inteiros de 1 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "qBCProd")
						private String qBCProd;
						/**
						 * Tipo Decimal com 11 inteiros, podendo ter 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{4}|[1-9]{1}[0-9]{0,10}(\\.[0-9]{4})?", text = "Tipo Decimal com 11 inteiros, podendo ter 4 decimais", required = true, minOccurs = "1")
						@Element(name = "vAliqProd")
						private String vAliqProd;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vCIDE")
						private String vCIDE;

						public String getQBCProd() {
							return this.qBCProd;
						}

						public void setQBCProd(String qBCProd) {
							this.qBCProd = qBCProd;
						}

						public String getVAliqProd() {
							return this.vAliqProd;
						}

						public void setVAliqProd(String vAliqProd) {
							this.vAliqProd = vAliqProd;
						}

						public String getVCIDE() {
							return this.vCIDE;
						}

						public void setVCIDE(String vCIDE) {
							this.vCIDE = vCIDE;
						}
					}

					public CIDE getCIDE() {
						return this.CIDE;
					}

					public void setCIDE(CIDE CIDE) {
						this.CIDE = CIDE;
					}

					@WXml
					@Order(elements = {"nBico", "nBomba", "nTanque", "vEncIni",
							"vEncFin"})
					@Element(name = "encerrante")
					public static class Encerrante {
						/**
						 * Numero de identificação do Bico utilizado no
						 * abastecimento
						 */
						@Validation(whiteSpace = "preserve", pattern = "[0-9]{1,3}", text = "Numero de identifica\u00E7\u00E3o do Bico utilizado no abastecimento", required = true, minOccurs = "1")
						@Element(name = "nBico")
						private String nBico;
						/**
						 * Numero de identificação da bomba ao qual o bico está
						 * interligado
						 */
						@Validation(whiteSpace = "preserve", pattern = "[0-9]{1,3}", text = "Numero de identifica\u00E7\u00E3o da bomba ao qual o bico est\u00E1 interligado", required = false, minOccurs = "0")
						@Element(name = "nBomba")
						private String nBomba;
						/**
						 * Numero de identificação do tanque ao qual o bico está
						 * interligado
						 */
						@Validation(whiteSpace = "preserve", pattern = "[0-9]{1,3}", text = "Numero de identifica\u00E7\u00E3o do tanque ao qual o bico est\u00E1 interligado", required = true, minOccurs = "1")
						@Element(name = "nTanque")
						private String nTanque;
						/**
						 * Tipo Decimal com 12 inteiros, podendo ter 3 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{3}|[1-9]{1}[0-9]{0,11}(\\.[0-9]{3})?", text = "Tipo Decimal com 12 inteiros, podendo ter  3 decimais", required = true, minOccurs = "1")
						@Element(name = "vEncIni")
						private String vEncIni;
						/**
						 * Tipo Decimal com 12 inteiros, podendo ter 3 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{3}|[1-9]{1}[0-9]{0,11}(\\.[0-9]{3})?", text = "Tipo Decimal com 12 inteiros, podendo ter  3 decimais", required = true, minOccurs = "1")
						@Element(name = "vEncFin")
						private String vEncFin;

						public String getNBico() {
							return this.nBico;
						}

						public void setNBico(String nBico) {
							this.nBico = nBico;
						}

						public String getNBomba() {
							return this.nBomba;
						}

						public void setNBomba(String nBomba) {
							this.nBomba = nBomba;
						}

						public String getNTanque() {
							return this.nTanque;
						}

						public void setNTanque(String nTanque) {
							this.nTanque = nTanque;
						}

						public String getVEncIni() {
							return this.vEncIni;
						}

						public void setVEncIni(String vEncIni) {
							this.vEncIni = vEncIni;
						}

						public String getVEncFin() {
							return this.vEncFin;
						}

						public void setVEncFin(String vEncFin) {
							this.vEncFin = vEncFin;
						}
					}

					public Encerrante getEncerrante() {
						return this.encerrante;
					}

					public void setEncerrante(Encerrante encerrante) {
						this.encerrante = encerrante;
					}
				}

				public Comb getComb() {
					return this.comb;
				}

				public void setComb(Comb comb) {
					this.comb = comb;
				}

				public String getNRECOPI() {
					return this.nRECOPI;
				}

				public void setNRECOPI(String nRECOPI) {
					this.nRECOPI = nRECOPI;
				}
			}

			public Prod getProd() {
				return this.prod;
			}

			public void setProd(Prod prod) {
				this.prod = prod;
			}

			@Validation(choices = "[{\"items\":[\"ICMS\",\"IPI\",\"II\"]},{\"items\":[\"ISSQN\"]}]")
			@WXml
			@Order(elements = {"vTotTrib", "ICMS", "IPI", "II", "IPI", "ISSQN",
					"PIS", "PISST", "COFINS", "COFINSST", "ICMSUFDest"})
			@Element(name = "imposto")
			public static class Imposto {
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "0")
				@Element(name = "vTotTrib")
				private String vTotTrib;
				/**
				 * Dados do ICMS Normal e ST
				 */
				@Element(name = "ICMS")
				@Validation(required = false, minOccurs = "1")
				private ICMS ICMS;
				@Element(name = "IPI")
				@Validation(required = false, minOccurs = "0")
				private TIpi IPI;
				/**
				 * Dados do Imposto de Importação
				 */
				@Element(name = "II")
				@Validation(required = false, minOccurs = "0")
				private II II;
				/**
				 * ISSQN
				 */
				@Element(name = "ISSQN")
				@Validation(required = false, minOccurs = "1")
				private ISSQN ISSQN;
				/**
				 * Dados do PIS
				 */
				@Element(name = "PIS")
				@Validation(required = false, minOccurs = "0")
				private PIS PIS;
				/**
				 * Dados do PIS Substituição Tributária
				 */
				@Element(name = "PISST")
				@Validation(required = false, minOccurs = "0")
				private PISST PISST;
				/**
				 * Dados do COFINS
				 */
				@Element(name = "COFINS")
				@Validation(required = false, minOccurs = "0")
				private COFINS COFINS;
				/**
				 * Dados do COFINS da Substituição Tributaria;
				 */
				@Element(name = "COFINSST")
				@Validation(required = false, minOccurs = "0")
				private COFINSST COFINSST;
				/**
				 * Grupo a ser informado nas vendas interestarduais para
				 * consumidor final, não contribuinte de ICMS
				 */
				@Element(name = "ICMSUFDest")
				@Validation(required = false, minOccurs = "0")
				private ICMSUFDest ICMSUFDest;

				public String getVTotTrib() {
					return this.vTotTrib;
				}

				public void setVTotTrib(String vTotTrib) {
					this.vTotTrib = vTotTrib;
				}

				@Validation(choices = "[{\"items\":[\"ICMS00\"]},{\"items\":[\"ICMS10\"]},{\"items\":[\"ICMS20\"]},{\"items\":[\"ICMS30\"]},{\"items\":[\"ICMS40\"]},{\"items\":[\"ICMS51\"]},{\"items\":[\"ICMS60\"]},{\"items\":[\"ICMS70\"]},{\"items\":[\"ICMS90\"]},{\"items\":[\"ICMSPart\"]},{\"items\":[\"ICMSST\"]},{\"items\":[\"ICMSSN101\"]},{\"items\":[\"ICMSSN102\"]},{\"items\":[\"ICMSSN201\"]},{\"items\":[\"ICMSSN202\"]},{\"items\":[\"ICMSSN500\"]},{\"items\":[\"ICMSSN900\"]}]")
				@WXml
				@Order(elements = {"ICMS00", "ICMS10", "ICMS20", "ICMS30",
						"ICMS40", "ICMS51", "ICMS60", "ICMS70", "ICMS90",
						"ICMSPart", "ICMSST", "ICMSSN101", "ICMSSN102",
						"ICMSSN201", "ICMSSN202", "ICMSSN500", "ICMSSN900"})
				@Element(name = "ICMS")
				public static class ICMS {
					/**
					 * Tributação pelo ICMS 00 - Tributada integralmente
					 */
					@Element(name = "ICMS00")
					@Validation(required = false, minOccurs = "1")
					private ICMS00 ICMS00;
					/**
					 * Tributação pelo ICMS 10 - Tributada e com cobrança do
					 * ICMS por substituição tributária
					 */
					@Element(name = "ICMS10")
					@Validation(required = false, minOccurs = "1")
					private ICMS10 ICMS10;
					/**
					 * Tributção pelo ICMS 20 - Com redução de base de cálculo
					 */
					@Element(name = "ICMS20")
					@Validation(required = false, minOccurs = "1")
					private ICMS20 ICMS20;
					/**
					 * Tributação pelo ICMS 30 - Isenta ou não tributada e com
					 * cobrança do ICMS por substituição tributária
					 */
					@Element(name = "ICMS30")
					@Validation(required = false, minOccurs = "1")
					private ICMS30 ICMS30;
					/**
					 * Tributação pelo ICMS 40 - Isenta 41 - Não tributada 50 -
					 * Suspensão
					 */
					@Element(name = "ICMS40")
					@Validation(required = false, minOccurs = "1")
					private ICMS40 ICMS40;
					/**
					 * Tributção pelo ICMS 51 - Diferimento A exigência do
					 * preenchimento das informações do ICMS diferido fica à
					 * critério de cada UF.
					 */
					@Element(name = "ICMS51")
					@Validation(required = false, minOccurs = "1")
					private ICMS51 ICMS51;
					/**
					 * Tributação pelo ICMS 60 - ICMS cobrado anteriormente por
					 * substituição tributária
					 */
					@Element(name = "ICMS60")
					@Validation(required = false, minOccurs = "1")
					private ICMS60 ICMS60;
					/**
					 * Tributação pelo ICMS 70 - Com redução de base de cálculo
					 * e cobrança do ICMS por substituição tributária
					 */
					@Element(name = "ICMS70")
					@Validation(required = false, minOccurs = "1")
					private ICMS70 ICMS70;
					/**
					 * Tributação pelo ICMS 90 - Outras
					 */
					@Element(name = "ICMS90")
					@Validation(required = false, minOccurs = "1")
					private ICMS90 ICMS90;
					/**
					 * Partilha do ICMS entre a UF de origem e UF de destino ou
					 * a UF definida na legislação Operação interestadual para
					 * consumidor final com partilha do ICMS devido na operação
					 * entre a UF de origem e a UF do destinatário ou ou a UF
					 * definida na legislação. (Ex. UF da concessionária de
					 * entrega do veículos)
					 */
					@Element(name = "ICMSPart")
					@Validation(required = false, minOccurs = "1")
					private ICMSPart ICMSPart;
					/**
					 * Grupo de informação do ICMSST devido para a UF de
					 * destino, nas operações interestaduais de produtos que
					 * tiveram retenção antecipada de ICMS por ST na UF do
					 * remetente. Repasse via Substituto Tributário.
					 */
					@Element(name = "ICMSST")
					@Validation(required = false, minOccurs = "1")
					private ICMSST ICMSST;
					/**
					 * Tributação do ICMS pelo SIMPLES NACIONAL e CSOSN=101
					 * (v.2.0)
					 */
					@Element(name = "ICMSSN101")
					@Validation(required = false, minOccurs = "1")
					private ICMSSN101 ICMSSN101;
					/**
					 * Tributação do ICMS pelo SIMPLES NACIONAL e CSOSN=102,
					 * 103, 300 ou 400 (v.2.0))
					 */
					@Element(name = "ICMSSN102")
					@Validation(required = false, minOccurs = "1")
					private ICMSSN102 ICMSSN102;
					/**
					 * Tributação do ICMS pelo SIMPLES NACIONAL e CSOSN=201
					 * (v.2.0)
					 */
					@Element(name = "ICMSSN201")
					@Validation(required = false, minOccurs = "1")
					private ICMSSN201 ICMSSN201;
					/**
					 * Tributação do ICMS pelo SIMPLES NACIONAL e CSOSN=202 ou
					 * 203 (v.2.0)
					 */
					@Element(name = "ICMSSN202")
					@Validation(required = false, minOccurs = "1")
					private ICMSSN202 ICMSSN202;
					/**
					 * Tributação do ICMS pelo SIMPLES NACIONAL,CRT=1 – Simples
					 * Nacional e CSOSN=500 (v.2.0)
					 */
					@Element(name = "ICMSSN500")
					@Validation(required = false, minOccurs = "1")
					private ICMSSN500 ICMSSN500;
					/**
					 * Tributação do ICMS pelo SIMPLES NACIONAL, CRT=1 – Simples
					 * Nacional e CSOSN=900 (v2.0)
					 */
					@Element(name = "ICMSSN900")
					@Validation(required = false, minOccurs = "1")
					private ICMSSN900 ICMSSN900;

					@WXml
					@Order(elements = {"orig", "CST", "modBC", "vBC", "pICMS",
							"vICMS", "pFCP", "vFCP"})
					@Element(name = "ICMS00")
					public static class ICMS00 {
						/**
						 * Tipo Origem da mercadoria CST ICMS origem da
						 * mercadoria: 0-Nacional exceto as indicadas nos
						 * códigos 3, 4, 5 e 8; 1-Estrangeira - Importação
						 * direta; 2-Estrangeira - Adquirida no mercado interno;
						 * 3-Nacional, conteudo superior 40% e inferior ou igual
						 * a 70%; 4-Nacional, processos produtivos básicos;
						 * 5-Nacional, conteudo inferior 40%; 6-Estrangeira -
						 * Importação direta, com similar nacional, lista CAMEX;
						 * 7-Estrangeira - mercado interno, sem simular,lista
						 * CAMEX;8-Nacional, Conteúdo de Importação superior a
						 * 70%.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5", "6", "7", "8"}, text = "Tipo Origem da mercadoria CST ICMS  origem da mercadoria: 0-Nacional exceto as indicadas nos c\u00F3digos 3, 4, 5 e 8;\n1-Estrangeira - Importa\u00E7\u00E3o direta; 2-Estrangeira - Adquirida no mercado interno; 3-Nacional, conteudo superior 40% e inferior ou igual a 70%; 4-Nacional, processos produtivos b\u00E1sicos; 5-Nacional, conteudo inferior 40%; 6-Estrangeira - Importa\u00E7\u00E3o direta, com similar nacional, lista CAMEX; 7-Estrangeira - mercado interno, sem simular,lista CAMEX;8-Nacional, Conte\u00FAdo de Importa\u00E7\u00E3o superior a 70%.", required = true, minOccurs = "1")
						@Element(name = "orig")
						private String orig;
						/**
						 * Tributção pelo ICMS 00 - Tributada integralmente
						 */
						@Validation(whiteSpace = "preserve", enumerations = "00", text = "Tribut\u00E7\u00E3o pelo ICMS\n00 - Tributada integralmente", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;
						/**
						 * Modalidade de determinação da BC do ICMS: 0 - Margem
						 * Valor Agregado (%); 1 - Pauta (valor); 2 - Preço
						 * Tabelado Máximo (valor); 3 - Valor da Operação.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3"}, text = "Modalidade de determina\u00E7\u00E3o da BC do ICMS:\n0 - Margem Valor Agregado (%);\n1 - Pauta (valor);\n2 - Pre\u00E7o Tabelado M\u00E1ximo (valor);\n3 - Valor da Opera\u00E7\u00E3o.", required = true, minOccurs = "1")
						@Element(name = "modBC")
						private String modBC;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vBC")
						private String vBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "pICMS")
						private String pICMS;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vICMS")
						private String vICMS;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "1")
						@Element(name = "pFCP")
						private String pFCP;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vFCP")
						private String vFCP;

						public String getOrig() {
							return this.orig;
						}

						public void setOrig(String orig) {
							this.orig = orig;
						}

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}

						public String getModBC() {
							return this.modBC;
						}

						public void setModBC(String modBC) {
							this.modBC = modBC;
						}

						public String getVBC() {
							return this.vBC;
						}

						public void setVBC(String vBC) {
							this.vBC = vBC;
						}

						public String getPICMS() {
							return this.pICMS;
						}

						public void setPICMS(String pICMS) {
							this.pICMS = pICMS;
						}

						public String getVICMS() {
							return this.vICMS;
						}

						public void setVICMS(String vICMS) {
							this.vICMS = vICMS;
						}

						public String getPFCP() {
							return this.pFCP;
						}

						public void setPFCP(String pFCP) {
							this.pFCP = pFCP;
						}

						public String getVFCP() {
							return this.vFCP;
						}

						public void setVFCP(String vFCP) {
							this.vFCP = vFCP;
						}
					}

					public ICMS00 getICMS00() {
						return this.ICMS00;
					}

					public void setICMS00(ICMS00 ICMS00) {
						this.ICMS00 = ICMS00;
					}

					@WXml
					@Order(elements = {"orig", "CST", "modBC", "vBC", "pICMS",
							"vICMS", "vBCFCP", "pFCP", "vFCP", "modBCST",
							"pMVAST", "pRedBCST", "vBCST", "pICMSST",
							"vICMSST", "vBCFCPST", "pFCPST", "vFCPST"})
					@Element(name = "ICMS10")
					public static class ICMS10 {
						/**
						 * Tipo Origem da mercadoria CST ICMS origem da
						 * mercadoria: 0-Nacional exceto as indicadas nos
						 * códigos 3, 4, 5 e 8; 1-Estrangeira - Importação
						 * direta; 2-Estrangeira - Adquirida no mercado interno;
						 * 3-Nacional, conteudo superior 40% e inferior ou igual
						 * a 70%; 4-Nacional, processos produtivos básicos;
						 * 5-Nacional, conteudo inferior 40%; 6-Estrangeira -
						 * Importação direta, com similar nacional, lista CAMEX;
						 * 7-Estrangeira - mercado interno, sem simular,lista
						 * CAMEX;8-Nacional, Conteúdo de Importação superior a
						 * 70%.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5", "6", "7", "8"}, text = "Tipo Origem da mercadoria CST ICMS  origem da mercadoria: 0-Nacional exceto as indicadas nos c\u00F3digos 3, 4, 5 e 8;\n1-Estrangeira - Importa\u00E7\u00E3o direta; 2-Estrangeira - Adquirida no mercado interno; 3-Nacional, conteudo superior 40% e inferior ou igual a 70%; 4-Nacional, processos produtivos b\u00E1sicos; 5-Nacional, conteudo inferior 40%; 6-Estrangeira - Importa\u00E7\u00E3o direta, com similar nacional, lista CAMEX; 7-Estrangeira - mercado interno, sem simular,lista CAMEX;8-Nacional, Conte\u00FAdo de Importa\u00E7\u00E3o superior a 70%.", required = true, minOccurs = "1")
						@Element(name = "orig")
						private String orig;
						/**
						 * 10 - Tributada e com cobrança do ICMS por
						 * substituição tributária
						 */
						@Validation(whiteSpace = "preserve", enumerations = "10", text = "10 - Tributada e com cobran\u00E7a do ICMS por substitui\u00E7\u00E3o tribut\u00E1ria", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;
						/**
						 * Modalidade de determinação da BC do ICMS: 0 - Margem
						 * Valor Agregado (%); 1 - Pauta (valor); 2 - Preço
						 * Tabelado Máximo (valor); 3 - Valor da Operação.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3"}, text = "Modalidade de determina\u00E7\u00E3o da BC do ICMS:\n0 - Margem Valor Agregado (%);\n1 - Pauta (valor);\n2 - Pre\u00E7o Tabelado M\u00E1ximo (valor);\n3 - Valor da Opera\u00E7\u00E3o.", required = true, minOccurs = "1")
						@Element(name = "modBC")
						private String modBC;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vBC")
						private String vBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "pICMS")
						private String pICMS;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vICMS")
						private String vICMS;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCFCP")
						private String vBCFCP;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "1")
						@Element(name = "pFCP")
						private String pFCP;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vFCP")
						private String vFCP;
						/**
						 * Modalidade de determinação da BC do ICMS ST: 0 –
						 * Preço tabelado ou máximo sugerido; 1 - Lista Negativa
						 * (valor); 2 - Lista Positiva (valor); 3 - Lista Neutra
						 * (valor); 4 - Margem Valor Agregado (%); 5 - Pauta
						 * (valor);
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5"}, text = "Modalidade de determina\u00E7\u00E3o da BC do ICMS ST:\n0 \u2013 Pre\u00E7o tabelado ou m\u00E1ximo  sugerido;\n1 - Lista Negativa (valor);\n2 - Lista Positiva (valor);\n3 - Lista Neutra (valor);\n4 - Margem Valor Agregado (%);\n5 - Pauta (valor);", required = true, minOccurs = "1")
						@Element(name = "modBCST")
						private String modBCST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pMVAST")
						private String pMVAST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pRedBCST")
						private String pRedBCST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vBCST")
						private String vBCST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "pICMSST")
						private String pICMSST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vICMSST")
						private String vICMSST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCFCPST")
						private String vBCFCPST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "1")
						@Element(name = "pFCPST")
						private String pFCPST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vFCPST")
						private String vFCPST;

						public String getOrig() {
							return this.orig;
						}

						public void setOrig(String orig) {
							this.orig = orig;
						}

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}

						public String getModBC() {
							return this.modBC;
						}

						public void setModBC(String modBC) {
							this.modBC = modBC;
						}

						public String getVBC() {
							return this.vBC;
						}

						public void setVBC(String vBC) {
							this.vBC = vBC;
						}

						public String getPICMS() {
							return this.pICMS;
						}

						public void setPICMS(String pICMS) {
							this.pICMS = pICMS;
						}

						public String getVICMS() {
							return this.vICMS;
						}

						public void setVICMS(String vICMS) {
							this.vICMS = vICMS;
						}

						public String getVBCFCP() {
							return this.vBCFCP;
						}

						public void setVBCFCP(String vBCFCP) {
							this.vBCFCP = vBCFCP;
						}

						public String getPFCP() {
							return this.pFCP;
						}

						public void setPFCP(String pFCP) {
							this.pFCP = pFCP;
						}

						public String getVFCP() {
							return this.vFCP;
						}

						public void setVFCP(String vFCP) {
							this.vFCP = vFCP;
						}

						public String getModBCST() {
							return this.modBCST;
						}

						public void setModBCST(String modBCST) {
							this.modBCST = modBCST;
						}

						public String getPMVAST() {
							return this.pMVAST;
						}

						public void setPMVAST(String pMVAST) {
							this.pMVAST = pMVAST;
						}

						public String getPRedBCST() {
							return this.pRedBCST;
						}

						public void setPRedBCST(String pRedBCST) {
							this.pRedBCST = pRedBCST;
						}

						public String getVBCST() {
							return this.vBCST;
						}

						public void setVBCST(String vBCST) {
							this.vBCST = vBCST;
						}

						public String getPICMSST() {
							return this.pICMSST;
						}

						public void setPICMSST(String pICMSST) {
							this.pICMSST = pICMSST;
						}

						public String getVICMSST() {
							return this.vICMSST;
						}

						public void setVICMSST(String vICMSST) {
							this.vICMSST = vICMSST;
						}

						public String getVBCFCPST() {
							return this.vBCFCPST;
						}

						public void setVBCFCPST(String vBCFCPST) {
							this.vBCFCPST = vBCFCPST;
						}

						public String getPFCPST() {
							return this.pFCPST;
						}

						public void setPFCPST(String pFCPST) {
							this.pFCPST = pFCPST;
						}

						public String getVFCPST() {
							return this.vFCPST;
						}

						public void setVFCPST(String vFCPST) {
							this.vFCPST = vFCPST;
						}
					}

					public ICMS10 getICMS10() {
						return this.ICMS10;
					}

					public void setICMS10(ICMS10 ICMS10) {
						this.ICMS10 = ICMS10;
					}

					/**
					 * Grupo desoneração
					 */
					@WXml
					@Order(elements = {"orig", "CST", "modBC", "pRedBC", "vBC",
							"pICMS", "vICMS", "vBCFCP", "pFCP", "vFCP",
							"vICMSDeson", "motDesICMS"})
					@Element(name = "ICMS20")
					public static class ICMS20 {
						/**
						 * Tipo Origem da mercadoria CST ICMS origem da
						 * mercadoria: 0-Nacional exceto as indicadas nos
						 * códigos 3, 4, 5 e 8; 1-Estrangeira - Importação
						 * direta; 2-Estrangeira - Adquirida no mercado interno;
						 * 3-Nacional, conteudo superior 40% e inferior ou igual
						 * a 70%; 4-Nacional, processos produtivos básicos;
						 * 5-Nacional, conteudo inferior 40%; 6-Estrangeira -
						 * Importação direta, com similar nacional, lista CAMEX;
						 * 7-Estrangeira - mercado interno, sem simular,lista
						 * CAMEX;8-Nacional, Conteúdo de Importação superior a
						 * 70%.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5", "6", "7", "8"}, text = "Tipo Origem da mercadoria CST ICMS  origem da mercadoria: 0-Nacional exceto as indicadas nos c\u00F3digos 3, 4, 5 e 8;\n1-Estrangeira - Importa\u00E7\u00E3o direta; 2-Estrangeira - Adquirida no mercado interno; 3-Nacional, conteudo superior 40% e inferior ou igual a 70%; 4-Nacional, processos produtivos b\u00E1sicos; 5-Nacional, conteudo inferior 40%; 6-Estrangeira - Importa\u00E7\u00E3o direta, com similar nacional, lista CAMEX; 7-Estrangeira - mercado interno, sem simular,lista CAMEX;8-Nacional, Conte\u00FAdo de Importa\u00E7\u00E3o superior a 70%.", required = true, minOccurs = "1")
						@Element(name = "orig")
						private String orig;
						/**
						 * Tributção pelo ICMS 20 - Com redução de base de
						 * cálculo
						 */
						@Validation(whiteSpace = "preserve", enumerations = "20", text = "Tribut\u00E7\u00E3o pelo ICMS\n20 - Com redu\u00E7\u00E3o de base de c\u00E1lculo", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;
						/**
						 * Modalidade de determinação da BC do ICMS: 0 - Margem
						 * Valor Agregado (%); 1 - Pauta (valor); 2 - Preço
						 * Tabelado Máximo (valor); 3 - Valor da Operação.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3"}, text = "Modalidade de determina\u00E7\u00E3o da BC do ICMS:\n0 - Margem Valor Agregado (%);\n1 - Pauta (valor);\n2 - Pre\u00E7o Tabelado M\u00E1ximo (valor);\n3 - Valor da Opera\u00E7\u00E3o.", required = true, minOccurs = "1")
						@Element(name = "modBC")
						private String modBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "pRedBC")
						private String pRedBC;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vBC")
						private String vBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "pICMS")
						private String pICMS;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vICMS")
						private String vICMS;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCFCP")
						private String vBCFCP;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "1")
						@Element(name = "pFCP")
						private String pFCP;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vFCP")
						private String vFCP;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vICMSDeson")
						private String vICMSDeson;
						/**
						 * Motivo da desoneração do ICMS:3-Uso na
						 * agropecuária;9-Outros;12-Fomento agropecuário
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"3", "9", "12"}, text = "Motivo da desonera\u00E7\u00E3o do ICMS:3-Uso na agropecu\u00E1ria;9-Outros;12-Fomento agropecu\u00E1rio", required = false, minOccurs = "1")
						@Element(name = "motDesICMS")
						private String motDesICMS;

						public String getOrig() {
							return this.orig;
						}

						public void setOrig(String orig) {
							this.orig = orig;
						}

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}

						public String getModBC() {
							return this.modBC;
						}

						public void setModBC(String modBC) {
							this.modBC = modBC;
						}

						public String getPRedBC() {
							return this.pRedBC;
						}

						public void setPRedBC(String pRedBC) {
							this.pRedBC = pRedBC;
						}

						public String getVBC() {
							return this.vBC;
						}

						public void setVBC(String vBC) {
							this.vBC = vBC;
						}

						public String getPICMS() {
							return this.pICMS;
						}

						public void setPICMS(String pICMS) {
							this.pICMS = pICMS;
						}

						public String getVICMS() {
							return this.vICMS;
						}

						public void setVICMS(String vICMS) {
							this.vICMS = vICMS;
						}

						public String getVBCFCP() {
							return this.vBCFCP;
						}

						public void setVBCFCP(String vBCFCP) {
							this.vBCFCP = vBCFCP;
						}

						public String getPFCP() {
							return this.pFCP;
						}

						public void setPFCP(String pFCP) {
							this.pFCP = pFCP;
						}

						public String getVFCP() {
							return this.vFCP;
						}

						public void setVFCP(String vFCP) {
							this.vFCP = vFCP;
						}

						public String getVICMSDeson() {
							return this.vICMSDeson;
						}

						public void setVICMSDeson(String vICMSDeson) {
							this.vICMSDeson = vICMSDeson;
						}

						public String getMotDesICMS() {
							return this.motDesICMS;
						}

						public void setMotDesICMS(String motDesICMS) {
							this.motDesICMS = motDesICMS;
						}
					}

					public ICMS20 getICMS20() {
						return this.ICMS20;
					}

					public void setICMS20(ICMS20 ICMS20) {
						this.ICMS20 = ICMS20;
					}

					/**
					 * Grupo desoneração
					 */
					@WXml
					@Order(elements = {"orig", "CST", "modBCST", "pMVAST",
							"pRedBCST", "vBCST", "pICMSST", "vICMSST",
							"vBCFCPST", "pFCPST", "vFCPST", "vICMSDeson",
							"motDesICMS"})
					@Element(name = "ICMS30")
					public static class ICMS30 {
						/**
						 * Tipo Origem da mercadoria CST ICMS origem da
						 * mercadoria: 0-Nacional exceto as indicadas nos
						 * códigos 3, 4, 5 e 8; 1-Estrangeira - Importação
						 * direta; 2-Estrangeira - Adquirida no mercado interno;
						 * 3-Nacional, conteudo superior 40% e inferior ou igual
						 * a 70%; 4-Nacional, processos produtivos básicos;
						 * 5-Nacional, conteudo inferior 40%; 6-Estrangeira -
						 * Importação direta, com similar nacional, lista CAMEX;
						 * 7-Estrangeira - mercado interno, sem simular,lista
						 * CAMEX;8-Nacional, Conteúdo de Importação superior a
						 * 70%.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5", "6", "7", "8"}, text = "Tipo Origem da mercadoria CST ICMS  origem da mercadoria: 0-Nacional exceto as indicadas nos c\u00F3digos 3, 4, 5 e 8;\n1-Estrangeira - Importa\u00E7\u00E3o direta; 2-Estrangeira - Adquirida no mercado interno; 3-Nacional, conteudo superior 40% e inferior ou igual a 70%; 4-Nacional, processos produtivos b\u00E1sicos; 5-Nacional, conteudo inferior 40%; 6-Estrangeira - Importa\u00E7\u00E3o direta, com similar nacional, lista CAMEX; 7-Estrangeira - mercado interno, sem simular,lista CAMEX;8-Nacional, Conte\u00FAdo de Importa\u00E7\u00E3o superior a 70%.", required = true, minOccurs = "1")
						@Element(name = "orig")
						private String orig;
						/**
						 * Tributção pelo ICMS 30 - Isenta ou não tributada e
						 * com cobrança do ICMS por substituição tributária
						 */
						@Validation(whiteSpace = "preserve", enumerations = "30", text = "Tribut\u00E7\u00E3o pelo ICMS\n30 - Isenta ou n\u00E3o tributada e com cobran\u00E7a do ICMS por substitui\u00E7\u00E3o tribut\u00E1ria", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;
						/**
						 * Modalidade de determinação da BC do ICMS ST: 0 –
						 * Preço tabelado ou máximo sugerido; 1 - Lista Negativa
						 * (valor); 2 - Lista Positiva (valor); 3 - Lista Neutra
						 * (valor); 4 - Margem Valor Agregado (%); 5 - Pauta
						 * (valor).
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5"}, text = "Modalidade de determina\u00E7\u00E3o da BC do ICMS ST:\n0 \u2013 Pre\u00E7o tabelado ou m\u00E1ximo  sugerido;\n1 - Lista Negativa (valor);\n2 - Lista Positiva (valor);\n3 - Lista Neutra (valor);\n4 - Margem Valor Agregado (%);\n5 - Pauta (valor).", required = true, minOccurs = "1")
						@Element(name = "modBCST")
						private String modBCST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pMVAST")
						private String pMVAST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pRedBCST")
						private String pRedBCST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vBCST")
						private String vBCST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "pICMSST")
						private String pICMSST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vICMSST")
						private String vICMSST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCFCPST")
						private String vBCFCPST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "1")
						@Element(name = "pFCPST")
						private String pFCPST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vFCPST")
						private String vFCPST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vICMSDeson")
						private String vICMSDeson;
						/**
						 * Motivo da desoneração do ICMS:6-Utilitários
						 * Motocicleta AÁrea Livre;7-SUFRAMA;9-Outros
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"6", "7", "9"}, text = "Motivo da desonera\u00E7\u00E3o do ICMS:6-Utilit\u00E1rios Motocicleta A\u00C1rea Livre;7-SUFRAMA;9-Outros", required = false, minOccurs = "1")
						@Element(name = "motDesICMS")
						private String motDesICMS;

						public String getOrig() {
							return this.orig;
						}

						public void setOrig(String orig) {
							this.orig = orig;
						}

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}

						public String getModBCST() {
							return this.modBCST;
						}

						public void setModBCST(String modBCST) {
							this.modBCST = modBCST;
						}

						public String getPMVAST() {
							return this.pMVAST;
						}

						public void setPMVAST(String pMVAST) {
							this.pMVAST = pMVAST;
						}

						public String getPRedBCST() {
							return this.pRedBCST;
						}

						public void setPRedBCST(String pRedBCST) {
							this.pRedBCST = pRedBCST;
						}

						public String getVBCST() {
							return this.vBCST;
						}

						public void setVBCST(String vBCST) {
							this.vBCST = vBCST;
						}

						public String getPICMSST() {
							return this.pICMSST;
						}

						public void setPICMSST(String pICMSST) {
							this.pICMSST = pICMSST;
						}

						public String getVICMSST() {
							return this.vICMSST;
						}

						public void setVICMSST(String vICMSST) {
							this.vICMSST = vICMSST;
						}

						public String getVBCFCPST() {
							return this.vBCFCPST;
						}

						public void setVBCFCPST(String vBCFCPST) {
							this.vBCFCPST = vBCFCPST;
						}

						public String getPFCPST() {
							return this.pFCPST;
						}

						public void setPFCPST(String pFCPST) {
							this.pFCPST = pFCPST;
						}

						public String getVFCPST() {
							return this.vFCPST;
						}

						public void setVFCPST(String vFCPST) {
							this.vFCPST = vFCPST;
						}

						public String getVICMSDeson() {
							return this.vICMSDeson;
						}

						public void setVICMSDeson(String vICMSDeson) {
							this.vICMSDeson = vICMSDeson;
						}

						public String getMotDesICMS() {
							return this.motDesICMS;
						}

						public void setMotDesICMS(String motDesICMS) {
							this.motDesICMS = motDesICMS;
						}
					}

					public ICMS30 getICMS30() {
						return this.ICMS30;
					}

					public void setICMS30(ICMS30 ICMS30) {
						this.ICMS30 = ICMS30;
					}

					@WXml
					@Order(elements = {"orig", "CST", "vICMSDeson",
							"motDesICMS"})
					@Element(name = "ICMS40")
					public static class ICMS40 {
						/**
						 * Tipo Origem da mercadoria CST ICMS origem da
						 * mercadoria: 0-Nacional exceto as indicadas nos
						 * códigos 3, 4, 5 e 8; 1-Estrangeira - Importação
						 * direta; 2-Estrangeira - Adquirida no mercado interno;
						 * 3-Nacional, conteudo superior 40% e inferior ou igual
						 * a 70%; 4-Nacional, processos produtivos básicos;
						 * 5-Nacional, conteudo inferior 40%; 6-Estrangeira -
						 * Importação direta, com similar nacional, lista CAMEX;
						 * 7-Estrangeira - mercado interno, sem simular,lista
						 * CAMEX;8-Nacional, Conteúdo de Importação superior a
						 * 70%.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5", "6", "7", "8"}, text = "Tipo Origem da mercadoria CST ICMS  origem da mercadoria: 0-Nacional exceto as indicadas nos c\u00F3digos 3, 4, 5 e 8;\n1-Estrangeira - Importa\u00E7\u00E3o direta; 2-Estrangeira - Adquirida no mercado interno; 3-Nacional, conteudo superior 40% e inferior ou igual a 70%; 4-Nacional, processos produtivos b\u00E1sicos; 5-Nacional, conteudo inferior 40%; 6-Estrangeira - Importa\u00E7\u00E3o direta, com similar nacional, lista CAMEX; 7-Estrangeira - mercado interno, sem simular,lista CAMEX;8-Nacional, Conte\u00FAdo de Importa\u00E7\u00E3o superior a 70%.", required = true, minOccurs = "1")
						@Element(name = "orig")
						private String orig;
						/**
						 * Tributação pelo ICMS 40 - Isenta 41 - Não tributada
						 * 50 - Suspensão 51 - Diferimento
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"40", "41", "50"}, text = "Tributa\u00E7\u00E3o pelo ICMS \n40 - Isenta \n41 - N\u00E3o tributada \n50 - Suspens\u00E3o \n51 - Diferimento", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vICMSDeson")
						private String vICMSDeson;
						/**
						 * Este campo será preenchido quando o campo anterior
						 * estiver preenchido. Informar o motivo da desoneração:
						 * 1 – Táxi; 3 – Produtor Agropecuário; 4 –
						 * Frotista/Locadora; 5 – Diplomático/Consular; 6 –
						 * Utilitários e Motocicletas da Amazônia Ocidental e
						 * Áreas de Livre Comércio (Resolução 714/88 e 790/94 –
						 * CONTRAN e suas alterações); 7 – SUFRAMA; 8 - Venda a
						 * órgão Público; 9 – Outros 10- Deficiente Condutor 11-
						 * Deficiente não condutor 16 - Olimpíadas Rio 2016 90 -
						 * Solicitado pelo Fisco
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"1", "3", "4", "5", "6", "7", "8", "9", "10",
								"11", "16", "90"}, text = "Este campo ser\u00E1 preenchido quando o campo anterior estiver preenchido.\nInformar o motivo da desonera\u00E7\u00E3o:\n1 \u2013 T\u00E1xi;\n3 \u2013 Produtor Agropecu\u00E1rio;\n4 \u2013 Frotista/Locadora;\n5 \u2013 Diplom\u00E1tico/Consular;\n6 \u2013 Utilit\u00E1rios e Motocicletas da Amaz\u00F4nia Ocidental e \u00C1reas de Livre Com\u00E9rcio (Resolu\u00E7\u00E3o 714/88 e 790/94 \u2013 CONTRAN e suas altera\u00E7\u00F5es);\n7 \u2013 SUFRAMA;\n8 - Venda a \u00F3rg\u00E3o P\u00FAblico;\n9 \u2013 Outros\n10- Deficiente Condutor\n11- Deficiente n\u00E3o condutor\n16 - Olimp\u00EDadas Rio 2016\n90 - Solicitado pelo Fisco", required = false, minOccurs = "1")
						@Element(name = "motDesICMS")
						private String motDesICMS;

						public String getOrig() {
							return this.orig;
						}

						public void setOrig(String orig) {
							this.orig = orig;
						}

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}

						public String getVICMSDeson() {
							return this.vICMSDeson;
						}

						public void setVICMSDeson(String vICMSDeson) {
							this.vICMSDeson = vICMSDeson;
						}

						public String getMotDesICMS() {
							return this.motDesICMS;
						}

						public void setMotDesICMS(String motDesICMS) {
							this.motDesICMS = motDesICMS;
						}
					}

					public ICMS40 getICMS40() {
						return this.ICMS40;
					}

					public void setICMS40(ICMS40 ICMS40) {
						this.ICMS40 = ICMS40;
					}

					@WXml
					@Order(elements = {"orig", "CST", "modBC", "pRedBC", "vBC",
							"pICMS", "vICMSOp", "pDif", "vICMSDif", "vICMS",
							"vBCFCP", "pFCP", "vFCP"})
					@Element(name = "ICMS51")
					public static class ICMS51 {
						/**
						 * Tipo Origem da mercadoria CST ICMS origem da
						 * mercadoria: 0-Nacional exceto as indicadas nos
						 * códigos 3, 4, 5 e 8; 1-Estrangeira - Importação
						 * direta; 2-Estrangeira - Adquirida no mercado interno;
						 * 3-Nacional, conteudo superior 40% e inferior ou igual
						 * a 70%; 4-Nacional, processos produtivos básicos;
						 * 5-Nacional, conteudo inferior 40%; 6-Estrangeira -
						 * Importação direta, com similar nacional, lista CAMEX;
						 * 7-Estrangeira - mercado interno, sem simular,lista
						 * CAMEX;8-Nacional, Conteúdo de Importação superior a
						 * 70%.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5", "6", "7", "8"}, text = "Tipo Origem da mercadoria CST ICMS  origem da mercadoria: 0-Nacional exceto as indicadas nos c\u00F3digos 3, 4, 5 e 8;\n1-Estrangeira - Importa\u00E7\u00E3o direta; 2-Estrangeira - Adquirida no mercado interno; 3-Nacional, conteudo superior 40% e inferior ou igual a 70%; 4-Nacional, processos produtivos b\u00E1sicos; 5-Nacional, conteudo inferior 40%; 6-Estrangeira - Importa\u00E7\u00E3o direta, com similar nacional, lista CAMEX; 7-Estrangeira - mercado interno, sem simular,lista CAMEX;8-Nacional, Conte\u00FAdo de Importa\u00E7\u00E3o superior a 70%.", required = true, minOccurs = "1")
						@Element(name = "orig")
						private String orig;
						/**
						 * Tributção pelo ICMS 20 - Com redução de base de
						 * cálculo
						 */
						@Validation(whiteSpace = "preserve", enumerations = "51", text = "Tribut\u00E7\u00E3o pelo ICMS\n20 - Com redu\u00E7\u00E3o de base de c\u00E1lculo", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;
						/**
						 * Modalidade de determinação da BC do ICMS: 0 - Margem
						 * Valor Agregado (%); 1 - Pauta (valor); 2 - Preço
						 * Tabelado Máximo (valor); 3 - Valor da Operação.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3"}, text = "Modalidade de determina\u00E7\u00E3o da BC do ICMS:\n0 - Margem Valor Agregado (%);\n1 - Pauta (valor);\n2 - Pre\u00E7o Tabelado M\u00E1ximo (valor);\n3 - Valor da Opera\u00E7\u00E3o.", required = false, minOccurs = "0")
						@Element(name = "modBC")
						private String modBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = false, minOccurs = "0")
						@Element(name = "pRedBC")
						private String pRedBC;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "0")
						@Element(name = "vBC")
						private String vBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = false, minOccurs = "0")
						@Element(name = "pICMS")
						private String pICMS;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "0")
						@Element(name = "vICMSOp")
						private String vICMSOp;
						/**
						 * Tipo Decimal com 3 inteiros (no máximo 100), com até
						 * 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0(\\.[0-9]{2,4})?|[1-9]{1}[0-9]{0,1}(\\.[0-9]{2,4})?|100(\\.0{2,4})?", text = "Tipo Decimal com 3 inteiros (no m\u00E1ximo 100), com at\u00E9 4 decimais", required = false, minOccurs = "0")
						@Element(name = "pDif")
						private String pDif;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "0")
						@Element(name = "vICMSDif")
						private String vICMSDif;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "0")
						@Element(name = "vICMS")
						private String vICMS;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCFCP")
						private String vBCFCP;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "1")
						@Element(name = "pFCP")
						private String pFCP;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vFCP")
						private String vFCP;

						public String getOrig() {
							return this.orig;
						}

						public void setOrig(String orig) {
							this.orig = orig;
						}

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}

						public String getModBC() {
							return this.modBC;
						}

						public void setModBC(String modBC) {
							this.modBC = modBC;
						}

						public String getPRedBC() {
							return this.pRedBC;
						}

						public void setPRedBC(String pRedBC) {
							this.pRedBC = pRedBC;
						}

						public String getVBC() {
							return this.vBC;
						}

						public void setVBC(String vBC) {
							this.vBC = vBC;
						}

						public String getPICMS() {
							return this.pICMS;
						}

						public void setPICMS(String pICMS) {
							this.pICMS = pICMS;
						}

						public String getVICMSOp() {
							return this.vICMSOp;
						}

						public void setVICMSOp(String vICMSOp) {
							this.vICMSOp = vICMSOp;
						}

						public String getPDif() {
							return this.pDif;
						}

						public void setPDif(String pDif) {
							this.pDif = pDif;
						}

						public String getVICMSDif() {
							return this.vICMSDif;
						}

						public void setVICMSDif(String vICMSDif) {
							this.vICMSDif = vICMSDif;
						}

						public String getVICMS() {
							return this.vICMS;
						}

						public void setVICMS(String vICMS) {
							this.vICMS = vICMS;
						}

						public String getVBCFCP() {
							return this.vBCFCP;
						}

						public void setVBCFCP(String vBCFCP) {
							this.vBCFCP = vBCFCP;
						}

						public String getPFCP() {
							return this.pFCP;
						}

						public void setPFCP(String pFCP) {
							this.pFCP = pFCP;
						}

						public String getVFCP() {
							return this.vFCP;
						}

						public void setVFCP(String vFCP) {
							this.vFCP = vFCP;
						}
					}

					public ICMS51 getICMS51() {
						return this.ICMS51;
					}

					public void setICMS51(ICMS51 ICMS51) {
						this.ICMS51 = ICMS51;
					}

					/**
					 * NT2010/004
					 */
					@WXml
					@Order(elements = {"orig", "CST", "vBCSTRet", "pST",
							"vICMSSTRet", "vBCFCPSTRet", "pFCPSTRet",
							"vFCPSTRet"})
					@Element(name = "ICMS60")
					public static class ICMS60 {
						/**
						 * Tipo Origem da mercadoria CST ICMS origem da
						 * mercadoria: 0-Nacional exceto as indicadas nos
						 * códigos 3, 4, 5 e 8; 1-Estrangeira - Importação
						 * direta; 2-Estrangeira - Adquirida no mercado interno;
						 * 3-Nacional, conteudo superior 40% e inferior ou igual
						 * a 70%; 4-Nacional, processos produtivos básicos;
						 * 5-Nacional, conteudo inferior 40%; 6-Estrangeira -
						 * Importação direta, com similar nacional, lista CAMEX;
						 * 7-Estrangeira - mercado interno, sem simular,lista
						 * CAMEX;8-Nacional, Conteúdo de Importação superior a
						 * 70%.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5", "6", "7", "8"}, text = "Tipo Origem da mercadoria CST ICMS  origem da mercadoria: 0-Nacional exceto as indicadas nos c\u00F3digos 3, 4, 5 e 8;\n1-Estrangeira - Importa\u00E7\u00E3o direta; 2-Estrangeira - Adquirida no mercado interno; 3-Nacional, conteudo superior 40% e inferior ou igual a 70%; 4-Nacional, processos produtivos b\u00E1sicos; 5-Nacional, conteudo inferior 40%; 6-Estrangeira - Importa\u00E7\u00E3o direta, com similar nacional, lista CAMEX; 7-Estrangeira - mercado interno, sem simular,lista CAMEX;8-Nacional, Conte\u00FAdo de Importa\u00E7\u00E3o superior a 70%.", required = true, minOccurs = "1")
						@Element(name = "orig")
						private String orig;
						/**
						 * Tributação pelo ICMS 60 - ICMS cobrado anteriormente
						 * por substituição tributária
						 */
						@Validation(whiteSpace = "preserve", enumerations = "60", text = "Tributa\u00E7\u00E3o pelo ICMS \n60 - ICMS cobrado anteriormente por substitui\u00E7\u00E3o tribut\u00E1ria", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCSTRet")
						private String vBCSTRet;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "1")
						@Element(name = "pST")
						private String pST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vICMSSTRet")
						private String vICMSSTRet;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCFCPSTRet")
						private String vBCFCPSTRet;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "1")
						@Element(name = "pFCPSTRet")
						private String pFCPSTRet;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vFCPSTRet")
						private String vFCPSTRet;

						public String getOrig() {
							return this.orig;
						}

						public void setOrig(String orig) {
							this.orig = orig;
						}

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}

						public String getVBCSTRet() {
							return this.vBCSTRet;
						}

						public void setVBCSTRet(String vBCSTRet) {
							this.vBCSTRet = vBCSTRet;
						}

						public String getPST() {
							return this.pST;
						}

						public void setPST(String pST) {
							this.pST = pST;
						}

						public String getVICMSSTRet() {
							return this.vICMSSTRet;
						}

						public void setVICMSSTRet(String vICMSSTRet) {
							this.vICMSSTRet = vICMSSTRet;
						}

						public String getVBCFCPSTRet() {
							return this.vBCFCPSTRet;
						}

						public void setVBCFCPSTRet(String vBCFCPSTRet) {
							this.vBCFCPSTRet = vBCFCPSTRet;
						}

						public String getPFCPSTRet() {
							return this.pFCPSTRet;
						}

						public void setPFCPSTRet(String pFCPSTRet) {
							this.pFCPSTRet = pFCPSTRet;
						}

						public String getVFCPSTRet() {
							return this.vFCPSTRet;
						}

						public void setVFCPSTRet(String vFCPSTRet) {
							this.vFCPSTRet = vFCPSTRet;
						}
					}

					public ICMS60 getICMS60() {
						return this.ICMS60;
					}

					public void setICMS60(ICMS60 ICMS60) {
						this.ICMS60 = ICMS60;
					}

					/**
					 * Grupo desoneração
					 */
					@WXml
					@Order(elements = {"orig", "CST", "modBC", "pRedBC", "vBC",
							"pICMS", "vICMS", "vBCFCP", "pFCP", "vFCP",
							"modBCST", "pMVAST", "pRedBCST", "vBCST",
							"pICMSST", "vICMSST", "vBCFCPST", "pFCPST",
							"vFCPST", "vICMSDeson", "motDesICMS"})
					@Element(name = "ICMS70")
					public static class ICMS70 {
						/**
						 * Tipo Origem da mercadoria CST ICMS origem da
						 * mercadoria: 0-Nacional exceto as indicadas nos
						 * códigos 3, 4, 5 e 8; 1-Estrangeira - Importação
						 * direta; 2-Estrangeira - Adquirida no mercado interno;
						 * 3-Nacional, conteudo superior 40% e inferior ou igual
						 * a 70%; 4-Nacional, processos produtivos básicos;
						 * 5-Nacional, conteudo inferior 40%; 6-Estrangeira -
						 * Importação direta, com similar nacional, lista CAMEX;
						 * 7-Estrangeira - mercado interno, sem simular,lista
						 * CAMEX;8-Nacional, Conteúdo de Importação superior a
						 * 70%.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5", "6", "7", "8"}, text = "Tipo Origem da mercadoria CST ICMS  origem da mercadoria: 0-Nacional exceto as indicadas nos c\u00F3digos 3, 4, 5 e 8;\n1-Estrangeira - Importa\u00E7\u00E3o direta; 2-Estrangeira - Adquirida no mercado interno; 3-Nacional, conteudo superior 40% e inferior ou igual a 70%; 4-Nacional, processos produtivos b\u00E1sicos; 5-Nacional, conteudo inferior 40%; 6-Estrangeira - Importa\u00E7\u00E3o direta, com similar nacional, lista CAMEX; 7-Estrangeira - mercado interno, sem simular,lista CAMEX;8-Nacional, Conte\u00FAdo de Importa\u00E7\u00E3o superior a 70%.", required = true, minOccurs = "1")
						@Element(name = "orig")
						private String orig;
						/**
						 * Tributção pelo ICMS 70 - Com redução de base de
						 * cálculo e cobrança do ICMS por substituição
						 * tributária
						 */
						@Validation(whiteSpace = "preserve", enumerations = "70", text = "Tribut\u00E7\u00E3o pelo ICMS\n70 - Com redu\u00E7\u00E3o de base de c\u00E1lculo e cobran\u00E7a do ICMS por substitui\u00E7\u00E3o tribut\u00E1ria", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;
						/**
						 * Modalidade de determinação da BC do ICMS: 0 - Margem
						 * Valor Agregado (%); 1 - Pauta (valor); 2 - Preço
						 * Tabelado Máximo (valor); 3 - Valor da Operação.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3"}, text = "Modalidade de determina\u00E7\u00E3o da BC do ICMS:\n0 - Margem Valor Agregado (%);\n1 - Pauta (valor);\n2 - Pre\u00E7o Tabelado M\u00E1ximo (valor);\n3 - Valor da Opera\u00E7\u00E3o.", required = true, minOccurs = "1")
						@Element(name = "modBC")
						private String modBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "pRedBC")
						private String pRedBC;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vBC")
						private String vBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "pICMS")
						private String pICMS;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vICMS")
						private String vICMS;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCFCP")
						private String vBCFCP;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "1")
						@Element(name = "pFCP")
						private String pFCP;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vFCP")
						private String vFCP;
						/**
						 * Modalidade de determinação da BC do ICMS ST: 0 –
						 * Preço tabelado ou máximo sugerido; 1 - Lista Negativa
						 * (valor); 2 - Lista Positiva (valor); 3 - Lista Neutra
						 * (valor); 4 - Margem Valor Agregado (%); 5 - Pauta
						 * (valor).
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5"}, text = "Modalidade de determina\u00E7\u00E3o da BC do ICMS ST:\n0 \u2013 Pre\u00E7o tabelado ou m\u00E1ximo  sugerido;\n1 - Lista Negativa (valor);\n2 - Lista Positiva (valor);\n3 - Lista Neutra (valor);\n4 - Margem Valor Agregado (%);\n5 - Pauta (valor).", required = true, minOccurs = "1")
						@Element(name = "modBCST")
						private String modBCST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pMVAST")
						private String pMVAST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pRedBCST")
						private String pRedBCST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vBCST")
						private String vBCST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "pICMSST")
						private String pICMSST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vICMSST")
						private String vICMSST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCFCPST")
						private String vBCFCPST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "1")
						@Element(name = "pFCPST")
						private String pFCPST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vFCPST")
						private String vFCPST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vICMSDeson")
						private String vICMSDeson;
						/**
						 * Motivo da desoneração do ICMS:3-Uso na
						 * agropecuária;9-Outros;12-Fomento agropecuário
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"3", "9", "12"}, text = "Motivo da desonera\u00E7\u00E3o do ICMS:3-Uso na agropecu\u00E1ria;9-Outros;12-Fomento agropecu\u00E1rio", required = false, minOccurs = "1")
						@Element(name = "motDesICMS")
						private String motDesICMS;

						public String getOrig() {
							return this.orig;
						}

						public void setOrig(String orig) {
							this.orig = orig;
						}

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}

						public String getModBC() {
							return this.modBC;
						}

						public void setModBC(String modBC) {
							this.modBC = modBC;
						}

						public String getPRedBC() {
							return this.pRedBC;
						}

						public void setPRedBC(String pRedBC) {
							this.pRedBC = pRedBC;
						}

						public String getVBC() {
							return this.vBC;
						}

						public void setVBC(String vBC) {
							this.vBC = vBC;
						}

						public String getPICMS() {
							return this.pICMS;
						}

						public void setPICMS(String pICMS) {
							this.pICMS = pICMS;
						}

						public String getVICMS() {
							return this.vICMS;
						}

						public void setVICMS(String vICMS) {
							this.vICMS = vICMS;
						}

						public String getVBCFCP() {
							return this.vBCFCP;
						}

						public void setVBCFCP(String vBCFCP) {
							this.vBCFCP = vBCFCP;
						}

						public String getPFCP() {
							return this.pFCP;
						}

						public void setPFCP(String pFCP) {
							this.pFCP = pFCP;
						}

						public String getVFCP() {
							return this.vFCP;
						}

						public void setVFCP(String vFCP) {
							this.vFCP = vFCP;
						}

						public String getModBCST() {
							return this.modBCST;
						}

						public void setModBCST(String modBCST) {
							this.modBCST = modBCST;
						}

						public String getPMVAST() {
							return this.pMVAST;
						}

						public void setPMVAST(String pMVAST) {
							this.pMVAST = pMVAST;
						}

						public String getPRedBCST() {
							return this.pRedBCST;
						}

						public void setPRedBCST(String pRedBCST) {
							this.pRedBCST = pRedBCST;
						}

						public String getVBCST() {
							return this.vBCST;
						}

						public void setVBCST(String vBCST) {
							this.vBCST = vBCST;
						}

						public String getPICMSST() {
							return this.pICMSST;
						}

						public void setPICMSST(String pICMSST) {
							this.pICMSST = pICMSST;
						}

						public String getVICMSST() {
							return this.vICMSST;
						}

						public void setVICMSST(String vICMSST) {
							this.vICMSST = vICMSST;
						}

						public String getVBCFCPST() {
							return this.vBCFCPST;
						}

						public void setVBCFCPST(String vBCFCPST) {
							this.vBCFCPST = vBCFCPST;
						}

						public String getPFCPST() {
							return this.pFCPST;
						}

						public void setPFCPST(String pFCPST) {
							this.pFCPST = pFCPST;
						}

						public String getVFCPST() {
							return this.vFCPST;
						}

						public void setVFCPST(String vFCPST) {
							this.vFCPST = vFCPST;
						}

						public String getVICMSDeson() {
							return this.vICMSDeson;
						}

						public void setVICMSDeson(String vICMSDeson) {
							this.vICMSDeson = vICMSDeson;
						}

						public String getMotDesICMS() {
							return this.motDesICMS;
						}

						public void setMotDesICMS(String motDesICMS) {
							this.motDesICMS = motDesICMS;
						}
					}

					public ICMS70 getICMS70() {
						return this.ICMS70;
					}

					public void setICMS70(ICMS70 ICMS70) {
						this.ICMS70 = ICMS70;
					}

					/**
					 * Grupo desoneração
					 */
					@WXml
					@Order(elements = {"orig", "CST", "modBC", "vBC", "pRedBC",
							"pICMS", "vICMS", "vBCFCP", "pFCP", "vFCP",
							"modBCST", "pMVAST", "pRedBCST", "vBCST",
							"pICMSST", "vICMSST", "vBCFCPST", "pFCPST",
							"vFCPST", "vICMSDeson", "motDesICMS"})
					@Element(name = "ICMS90")
					public static class ICMS90 {
						/**
						 * Tipo Origem da mercadoria CST ICMS origem da
						 * mercadoria: 0-Nacional exceto as indicadas nos
						 * códigos 3, 4, 5 e 8; 1-Estrangeira - Importação
						 * direta; 2-Estrangeira - Adquirida no mercado interno;
						 * 3-Nacional, conteudo superior 40% e inferior ou igual
						 * a 70%; 4-Nacional, processos produtivos básicos;
						 * 5-Nacional, conteudo inferior 40%; 6-Estrangeira -
						 * Importação direta, com similar nacional, lista CAMEX;
						 * 7-Estrangeira - mercado interno, sem simular,lista
						 * CAMEX;8-Nacional, Conteúdo de Importação superior a
						 * 70%.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5", "6", "7", "8"}, text = "Tipo Origem da mercadoria CST ICMS  origem da mercadoria: 0-Nacional exceto as indicadas nos c\u00F3digos 3, 4, 5 e 8;\n1-Estrangeira - Importa\u00E7\u00E3o direta; 2-Estrangeira - Adquirida no mercado interno; 3-Nacional, conteudo superior 40% e inferior ou igual a 70%; 4-Nacional, processos produtivos b\u00E1sicos; 5-Nacional, conteudo inferior 40%; 6-Estrangeira - Importa\u00E7\u00E3o direta, com similar nacional, lista CAMEX; 7-Estrangeira - mercado interno, sem simular,lista CAMEX;8-Nacional, Conte\u00FAdo de Importa\u00E7\u00E3o superior a 70%.", required = true, minOccurs = "1")
						@Element(name = "orig")
						private String orig;
						/**
						 * Tributção pelo ICMS 90 - Outras
						 */
						@Validation(whiteSpace = "preserve", enumerations = "90", text = "Tribut\u00E7\u00E3o pelo ICMS\n90 - Outras", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;
						/**
						 * Modalidade de determinação da BC do ICMS: 0 - Margem
						 * Valor Agregado (%); 1 - Pauta (valor); 2 - Preço
						 * Tabelado Máximo (valor); 3 - Valor da Operação.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3"}, text = "Modalidade de determina\u00E7\u00E3o da BC do ICMS: \n0 - Margem Valor Agregado (%);\n1 - Pauta (valor);\n2 - Pre\u00E7o Tabelado M\u00E1ximo (valor);\n3 - Valor da Opera\u00E7\u00E3o.", required = false, minOccurs = "1")
						@Element(name = "modBC")
						private String modBC;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBC")
						private String vBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pRedBC")
						private String pRedBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = false, minOccurs = "1")
						@Element(name = "pICMS")
						private String pICMS;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vICMS")
						private String vICMS;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCFCP")
						private String vBCFCP;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "1")
						@Element(name = "pFCP")
						private String pFCP;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vFCP")
						private String vFCP;
						/**
						 * Modalidade de determinação da BC do ICMS ST: 0 –
						 * Preço tabelado ou máximo sugerido; 1 - Lista Negativa
						 * (valor); 2 - Lista Positiva (valor); 3 - Lista Neutra
						 * (valor); 4 - Margem Valor Agregado (%); 5 - Pauta
						 * (valor).
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5"}, text = "Modalidade de determina\u00E7\u00E3o da BC do ICMS ST:\n0 \u2013 Pre\u00E7o tabelado ou m\u00E1ximo  sugerido;\n1 - Lista Negativa (valor);\n2 - Lista Positiva (valor);\n3 - Lista Neutra (valor);\n4 - Margem Valor Agregado (%);\n5 - Pauta (valor).", required = false, minOccurs = "1")
						@Element(name = "modBCST")
						private String modBCST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pMVAST")
						private String pMVAST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pRedBCST")
						private String pRedBCST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCST")
						private String vBCST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = false, minOccurs = "1")
						@Element(name = "pICMSST")
						private String pICMSST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vICMSST")
						private String vICMSST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCFCPST")
						private String vBCFCPST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "1")
						@Element(name = "pFCPST")
						private String pFCPST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vFCPST")
						private String vFCPST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vICMSDeson")
						private String vICMSDeson;
						/**
						 * Motivo da desoneração do ICMS:3-Uso na
						 * agropecuária;9-Outros;12-Fomento agropecuário
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"3", "9", "12"}, text = "Motivo da desonera\u00E7\u00E3o do ICMS:3-Uso na agropecu\u00E1ria;9-Outros;12-Fomento agropecu\u00E1rio", required = false, minOccurs = "1")
						@Element(name = "motDesICMS")
						private String motDesICMS;

						public String getOrig() {
							return this.orig;
						}

						public void setOrig(String orig) {
							this.orig = orig;
						}

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}

						public String getModBC() {
							return this.modBC;
						}

						public void setModBC(String modBC) {
							this.modBC = modBC;
						}

						public String getVBC() {
							return this.vBC;
						}

						public void setVBC(String vBC) {
							this.vBC = vBC;
						}

						public String getPRedBC() {
							return this.pRedBC;
						}

						public void setPRedBC(String pRedBC) {
							this.pRedBC = pRedBC;
						}

						public String getPICMS() {
							return this.pICMS;
						}

						public void setPICMS(String pICMS) {
							this.pICMS = pICMS;
						}

						public String getVICMS() {
							return this.vICMS;
						}

						public void setVICMS(String vICMS) {
							this.vICMS = vICMS;
						}

						public String getVBCFCP() {
							return this.vBCFCP;
						}

						public void setVBCFCP(String vBCFCP) {
							this.vBCFCP = vBCFCP;
						}

						public String getPFCP() {
							return this.pFCP;
						}

						public void setPFCP(String pFCP) {
							this.pFCP = pFCP;
						}

						public String getVFCP() {
							return this.vFCP;
						}

						public void setVFCP(String vFCP) {
							this.vFCP = vFCP;
						}

						public String getModBCST() {
							return this.modBCST;
						}

						public void setModBCST(String modBCST) {
							this.modBCST = modBCST;
						}

						public String getPMVAST() {
							return this.pMVAST;
						}

						public void setPMVAST(String pMVAST) {
							this.pMVAST = pMVAST;
						}

						public String getPRedBCST() {
							return this.pRedBCST;
						}

						public void setPRedBCST(String pRedBCST) {
							this.pRedBCST = pRedBCST;
						}

						public String getVBCST() {
							return this.vBCST;
						}

						public void setVBCST(String vBCST) {
							this.vBCST = vBCST;
						}

						public String getPICMSST() {
							return this.pICMSST;
						}

						public void setPICMSST(String pICMSST) {
							this.pICMSST = pICMSST;
						}

						public String getVICMSST() {
							return this.vICMSST;
						}

						public void setVICMSST(String vICMSST) {
							this.vICMSST = vICMSST;
						}

						public String getVBCFCPST() {
							return this.vBCFCPST;
						}

						public void setVBCFCPST(String vBCFCPST) {
							this.vBCFCPST = vBCFCPST;
						}

						public String getPFCPST() {
							return this.pFCPST;
						}

						public void setPFCPST(String pFCPST) {
							this.pFCPST = pFCPST;
						}

						public String getVFCPST() {
							return this.vFCPST;
						}

						public void setVFCPST(String vFCPST) {
							this.vFCPST = vFCPST;
						}

						public String getVICMSDeson() {
							return this.vICMSDeson;
						}

						public void setVICMSDeson(String vICMSDeson) {
							this.vICMSDeson = vICMSDeson;
						}

						public String getMotDesICMS() {
							return this.motDesICMS;
						}

						public void setMotDesICMS(String motDesICMS) {
							this.motDesICMS = motDesICMS;
						}
					}

					public ICMS90 getICMS90() {
						return this.ICMS90;
					}

					public void setICMS90(ICMS90 ICMS90) {
						this.ICMS90 = ICMS90;
					}

					@WXml
					@Order(elements = {"orig", "CST", "modBC", "vBC", "pRedBC",
							"pICMS", "vICMS", "modBCST", "pMVAST", "pRedBCST",
							"vBCST", "pICMSST", "vICMSST", "pBCOp", "UFST"})
					@Element(name = "ICMSPart")
					public static class ICMSPart {
						/**
						 * Tipo Origem da mercadoria CST ICMS origem da
						 * mercadoria: 0-Nacional exceto as indicadas nos
						 * códigos 3, 4, 5 e 8; 1-Estrangeira - Importação
						 * direta; 2-Estrangeira - Adquirida no mercado interno;
						 * 3-Nacional, conteudo superior 40% e inferior ou igual
						 * a 70%; 4-Nacional, processos produtivos básicos;
						 * 5-Nacional, conteudo inferior 40%; 6-Estrangeira -
						 * Importação direta, com similar nacional, lista CAMEX;
						 * 7-Estrangeira - mercado interno, sem simular,lista
						 * CAMEX;8-Nacional, Conteúdo de Importação superior a
						 * 70%.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5", "6", "7", "8"}, text = "Tipo Origem da mercadoria CST ICMS  origem da mercadoria: 0-Nacional exceto as indicadas nos c\u00F3digos 3, 4, 5 e 8;\n1-Estrangeira - Importa\u00E7\u00E3o direta; 2-Estrangeira - Adquirida no mercado interno; 3-Nacional, conteudo superior 40% e inferior ou igual a 70%; 4-Nacional, processos produtivos b\u00E1sicos; 5-Nacional, conteudo inferior 40%; 6-Estrangeira - Importa\u00E7\u00E3o direta, com similar nacional, lista CAMEX; 7-Estrangeira - mercado interno, sem simular,lista CAMEX;8-Nacional, Conte\u00FAdo de Importa\u00E7\u00E3o superior a 70%.", required = true, minOccurs = "1")
						@Element(name = "orig")
						private String orig;
						/**
						 * Tributação pelo ICMS 10 - Tributada e com cobrança do
						 * ICMS por substituição tributária; 90 – Outros.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"10", "90"}, text = "Tributa\u00E7\u00E3o pelo ICMS \n10 - Tributada e com cobran\u00E7a do ICMS por substitui\u00E7\u00E3o tribut\u00E1ria;\n90 \u2013 Outros.", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;
						/**
						 * Modalidade de determinação da BC do ICMS: 0 - Margem
						 * Valor Agregado (%); 1 - Pauta (valor); 2 - Preço
						 * Tabelado Máximo (valor); 3 - Valor da Operação.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3"}, text = "Modalidade de determina\u00E7\u00E3o da BC do ICMS: \n0 - Margem Valor Agregado (%);\n1 - Pauta (valor);\n2 - Pre\u00E7o Tabelado M\u00E1ximo (valor);\n3 - Valor da Opera\u00E7\u00E3o.", required = true, minOccurs = "1")
						@Element(name = "modBC")
						private String modBC;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vBC")
						private String vBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pRedBC")
						private String pRedBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "pICMS")
						private String pICMS;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vICMS")
						private String vICMS;
						/**
						 * Modalidade de determinação da BC do ICMS ST: 0 –
						 * Preço tabelado ou máximo sugerido; 1 - Lista Negativa
						 * (valor); 2 - Lista Positiva (valor); 3 - Lista Neutra
						 * (valor); 4 - Margem Valor Agregado (%); 5 - Pauta
						 * (valor).
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5"}, text = "Modalidade de determina\u00E7\u00E3o da BC do ICMS ST:\n0 \u2013 Pre\u00E7o tabelado ou m\u00E1ximo  sugerido;\n1 - Lista Negativa (valor);\n2 - Lista Positiva (valor);\n3 - Lista Neutra (valor);\n4 - Margem Valor Agregado (%);\n5 - Pauta (valor).", required = true, minOccurs = "1")
						@Element(name = "modBCST")
						private String modBCST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pMVAST")
						private String pMVAST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pRedBCST")
						private String pRedBCST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vBCST")
						private String vBCST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "pICMSST")
						private String pICMSST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vICMSST")
						private String vICMSST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = true, minOccurs = "1")
						@Element(name = "pBCOp")
						private String pBCOp;
						/**
						 * Tipo Sigla da UF
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES",
								"GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE",
								"PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC",
								"SE", "SP", "TO", "EX"}, text = "Tipo Sigla da UF", required = true, minOccurs = "1")
						@Element(name = "UFST")
						private String UFST;

						public String getOrig() {
							return this.orig;
						}

						public void setOrig(String orig) {
							this.orig = orig;
						}

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}

						public String getModBC() {
							return this.modBC;
						}

						public void setModBC(String modBC) {
							this.modBC = modBC;
						}

						public String getVBC() {
							return this.vBC;
						}

						public void setVBC(String vBC) {
							this.vBC = vBC;
						}

						public String getPRedBC() {
							return this.pRedBC;
						}

						public void setPRedBC(String pRedBC) {
							this.pRedBC = pRedBC;
						}

						public String getPICMS() {
							return this.pICMS;
						}

						public void setPICMS(String pICMS) {
							this.pICMS = pICMS;
						}

						public String getVICMS() {
							return this.vICMS;
						}

						public void setVICMS(String vICMS) {
							this.vICMS = vICMS;
						}

						public String getModBCST() {
							return this.modBCST;
						}

						public void setModBCST(String modBCST) {
							this.modBCST = modBCST;
						}

						public String getPMVAST() {
							return this.pMVAST;
						}

						public void setPMVAST(String pMVAST) {
							this.pMVAST = pMVAST;
						}

						public String getPRedBCST() {
							return this.pRedBCST;
						}

						public void setPRedBCST(String pRedBCST) {
							this.pRedBCST = pRedBCST;
						}

						public String getVBCST() {
							return this.vBCST;
						}

						public void setVBCST(String vBCST) {
							this.vBCST = vBCST;
						}

						public String getPICMSST() {
							return this.pICMSST;
						}

						public void setPICMSST(String pICMSST) {
							this.pICMSST = pICMSST;
						}

						public String getVICMSST() {
							return this.vICMSST;
						}

						public void setVICMSST(String vICMSST) {
							this.vICMSST = vICMSST;
						}

						public String getPBCOp() {
							return this.pBCOp;
						}

						public void setPBCOp(String pBCOp) {
							this.pBCOp = pBCOp;
						}

						public String getUFST() {
							return this.UFST;
						}

						public void setUFST(String UFST) {
							this.UFST = UFST;
						}
					}

					public ICMSPart getICMSPart() {
						return this.ICMSPart;
					}

					public void setICMSPart(ICMSPart ICMSPart) {
						this.ICMSPart = ICMSPart;
					}

					@WXml
					@Order(elements = {"orig", "CST", "vBCSTRet", "vICMSSTRet",
							"vBCSTDest", "vICMSSTDest"})
					@Element(name = "ICMSST")
					public static class ICMSST {
						/**
						 * Tipo Origem da mercadoria CST ICMS origem da
						 * mercadoria: 0-Nacional exceto as indicadas nos
						 * códigos 3, 4, 5 e 8; 1-Estrangeira - Importação
						 * direta; 2-Estrangeira - Adquirida no mercado interno;
						 * 3-Nacional, conteudo superior 40% e inferior ou igual
						 * a 70%; 4-Nacional, processos produtivos básicos;
						 * 5-Nacional, conteudo inferior 40%; 6-Estrangeira -
						 * Importação direta, com similar nacional, lista CAMEX;
						 * 7-Estrangeira - mercado interno, sem simular,lista
						 * CAMEX;8-Nacional, Conteúdo de Importação superior a
						 * 70%.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5", "6", "7", "8"}, text = "Tipo Origem da mercadoria CST ICMS  origem da mercadoria: 0-Nacional exceto as indicadas nos c\u00F3digos 3, 4, 5 e 8;\n1-Estrangeira - Importa\u00E7\u00E3o direta; 2-Estrangeira - Adquirida no mercado interno; 3-Nacional, conteudo superior 40% e inferior ou igual a 70%; 4-Nacional, processos produtivos b\u00E1sicos; 5-Nacional, conteudo inferior 40%; 6-Estrangeira - Importa\u00E7\u00E3o direta, com similar nacional, lista CAMEX; 7-Estrangeira - mercado interno, sem simular,lista CAMEX;8-Nacional, Conte\u00FAdo de Importa\u00E7\u00E3o superior a 70%.", required = true, minOccurs = "1")
						@Element(name = "orig")
						private String orig;
						/**
						 * Tributção pelo ICMS 41-Não Tributado. 60-Cobrado
						 * anteriormente por substituição tributária.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"41", "60"}, text = "Tribut\u00E7\u00E3o pelo ICMS\n41-N\u00E3o Tributado.\n60-Cobrado anteriormente por substitui\u00E7\u00E3o tribut\u00E1ria.", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vBCSTRet")
						private String vBCSTRet;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vICMSSTRet")
						private String vICMSSTRet;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vBCSTDest")
						private String vBCSTDest;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vICMSSTDest")
						private String vICMSSTDest;

						public String getOrig() {
							return this.orig;
						}

						public void setOrig(String orig) {
							this.orig = orig;
						}

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}

						public String getVBCSTRet() {
							return this.vBCSTRet;
						}

						public void setVBCSTRet(String vBCSTRet) {
							this.vBCSTRet = vBCSTRet;
						}

						public String getVICMSSTRet() {
							return this.vICMSSTRet;
						}

						public void setVICMSSTRet(String vICMSSTRet) {
							this.vICMSSTRet = vICMSSTRet;
						}

						public String getVBCSTDest() {
							return this.vBCSTDest;
						}

						public void setVBCSTDest(String vBCSTDest) {
							this.vBCSTDest = vBCSTDest;
						}

						public String getVICMSSTDest() {
							return this.vICMSSTDest;
						}

						public void setVICMSSTDest(String vICMSSTDest) {
							this.vICMSSTDest = vICMSSTDest;
						}
					}

					public ICMSST getICMSST() {
						return this.ICMSST;
					}

					public void setICMSST(ICMSST ICMSST) {
						this.ICMSST = ICMSST;
					}

					@WXml
					@Order(elements = {"orig", "CSOSN", "pCredSN",
							"vCredICMSSN"})
					@Element(name = "ICMSSN101")
					public static class ICMSSN101 {
						/**
						 * Tipo Origem da mercadoria CST ICMS origem da
						 * mercadoria: 0-Nacional exceto as indicadas nos
						 * códigos 3, 4, 5 e 8; 1-Estrangeira - Importação
						 * direta; 2-Estrangeira - Adquirida no mercado interno;
						 * 3-Nacional, conteudo superior 40% e inferior ou igual
						 * a 70%; 4-Nacional, processos produtivos básicos;
						 * 5-Nacional, conteudo inferior 40%; 6-Estrangeira -
						 * Importação direta, com similar nacional, lista CAMEX;
						 * 7-Estrangeira - mercado interno, sem simular,lista
						 * CAMEX;8-Nacional, Conteúdo de Importação superior a
						 * 70%.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5", "6", "7", "8"}, text = "Tipo Origem da mercadoria CST ICMS  origem da mercadoria: 0-Nacional exceto as indicadas nos c\u00F3digos 3, 4, 5 e 8;\n1-Estrangeira - Importa\u00E7\u00E3o direta; 2-Estrangeira - Adquirida no mercado interno; 3-Nacional, conteudo superior 40% e inferior ou igual a 70%; 4-Nacional, processos produtivos b\u00E1sicos; 5-Nacional, conteudo inferior 40%; 6-Estrangeira - Importa\u00E7\u00E3o direta, com similar nacional, lista CAMEX; 7-Estrangeira - mercado interno, sem simular,lista CAMEX;8-Nacional, Conte\u00FAdo de Importa\u00E7\u00E3o superior a 70%.", required = true, minOccurs = "1")
						@Element(name = "orig")
						private String orig;
						/**
						 * 101- Tributada pelo Simples Nacional com permissão de
						 * crédito. (v.2.0)
						 */
						@Validation(whiteSpace = "preserve", enumerations = "101", text = "101- Tributada pelo Simples Nacional com permiss\u00E3o de cr\u00E9dito. (v.2.0)", required = true, minOccurs = "1")
						@Element(name = "CSOSN")
						private String CSOSN;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "pCredSN")
						private String pCredSN;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vCredICMSSN")
						private String vCredICMSSN;

						public String getOrig() {
							return this.orig;
						}

						public void setOrig(String orig) {
							this.orig = orig;
						}

						public String getCSOSN() {
							return this.CSOSN;
						}

						public void setCSOSN(String CSOSN) {
							this.CSOSN = CSOSN;
						}

						public String getPCredSN() {
							return this.pCredSN;
						}

						public void setPCredSN(String pCredSN) {
							this.pCredSN = pCredSN;
						}

						public String getVCredICMSSN() {
							return this.vCredICMSSN;
						}

						public void setVCredICMSSN(String vCredICMSSN) {
							this.vCredICMSSN = vCredICMSSN;
						}
					}

					public ICMSSN101 getICMSSN101() {
						return this.ICMSSN101;
					}

					public void setICMSSN101(ICMSSN101 ICMSSN101) {
						this.ICMSSN101 = ICMSSN101;
					}

					@WXml
					@Order(elements = {"orig", "CSOSN"})
					@Element(name = "ICMSSN102")
					public static class ICMSSN102 {
						/**
						 * Tipo Origem da mercadoria CST ICMS origem da
						 * mercadoria: 0-Nacional exceto as indicadas nos
						 * códigos 3, 4, 5 e 8; 1-Estrangeira - Importação
						 * direta; 2-Estrangeira - Adquirida no mercado interno;
						 * 3-Nacional, conteudo superior 40% e inferior ou igual
						 * a 70%; 4-Nacional, processos produtivos básicos;
						 * 5-Nacional, conteudo inferior 40%; 6-Estrangeira -
						 * Importação direta, com similar nacional, lista CAMEX;
						 * 7-Estrangeira - mercado interno, sem simular,lista
						 * CAMEX;8-Nacional, Conteúdo de Importação superior a
						 * 70%.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5", "6", "7", "8"}, text = "Tipo Origem da mercadoria CST ICMS  origem da mercadoria: 0-Nacional exceto as indicadas nos c\u00F3digos 3, 4, 5 e 8;\n1-Estrangeira - Importa\u00E7\u00E3o direta; 2-Estrangeira - Adquirida no mercado interno; 3-Nacional, conteudo superior 40% e inferior ou igual a 70%; 4-Nacional, processos produtivos b\u00E1sicos; 5-Nacional, conteudo inferior 40%; 6-Estrangeira - Importa\u00E7\u00E3o direta, com similar nacional, lista CAMEX; 7-Estrangeira - mercado interno, sem simular,lista CAMEX;8-Nacional, Conte\u00FAdo de Importa\u00E7\u00E3o superior a 70%.", required = true, minOccurs = "1")
						@Element(name = "orig")
						private String orig;
						/**
						 * 102- Tributada pelo Simples Nacional sem permissão de
						 * crédito. 103 – Isenção do ICMS no Simples Nacional
						 * para faixa de receita bruta. 300 – Imune. 400 – Não
						 * tributda pelo Simples Nacional (v.2.0) (v.2.0)
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"102", "103", "300", "400"}, text = "102- Tributada pelo Simples Nacional sem permiss\u00E3o de cr\u00E9dito. \n103 \u2013 Isen\u00E7\u00E3o do ICMS  no Simples Nacional para faixa de receita bruta.\n300 \u2013 Imune.\n400 \u2013 N\u00E3o tributda pelo Simples Nacional (v.2.0) (v.2.0)", required = true, minOccurs = "1")
						@Element(name = "CSOSN")
						private String CSOSN;

						public String getOrig() {
							return this.orig;
						}

						public void setOrig(String orig) {
							this.orig = orig;
						}

						public String getCSOSN() {
							return this.CSOSN;
						}

						public void setCSOSN(String CSOSN) {
							this.CSOSN = CSOSN;
						}
					}

					public ICMSSN102 getICMSSN102() {
						return this.ICMSSN102;
					}

					public void setICMSSN102(ICMSSN102 ICMSSN102) {
						this.ICMSSN102 = ICMSSN102;
					}

					@WXml
					@Order(elements = {"orig", "CSOSN", "modBCST", "pMVAST",
							"pRedBCST", "vBCST", "pICMSST", "vICMSST",
							"vBCFCPST", "pFCPST", "vFCPST", "pCredSN",
							"vCredICMSSN"})
					@Element(name = "ICMSSN201")
					public static class ICMSSN201 {
						/**
						 * Tipo Origem da mercadoria CST ICMS origem da
						 * mercadoria: 0-Nacional exceto as indicadas nos
						 * códigos 3, 4, 5 e 8; 1-Estrangeira - Importação
						 * direta; 2-Estrangeira - Adquirida no mercado interno;
						 * 3-Nacional, conteudo superior 40% e inferior ou igual
						 * a 70%; 4-Nacional, processos produtivos básicos;
						 * 5-Nacional, conteudo inferior 40%; 6-Estrangeira -
						 * Importação direta, com similar nacional, lista CAMEX;
						 * 7-Estrangeira - mercado interno, sem simular,lista
						 * CAMEX;8-Nacional, Conteúdo de Importação superior a
						 * 70%.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5", "6", "7", "8"}, text = "Tipo Origem da mercadoria CST ICMS  origem da mercadoria: 0-Nacional exceto as indicadas nos c\u00F3digos 3, 4, 5 e 8;\n1-Estrangeira - Importa\u00E7\u00E3o direta; 2-Estrangeira - Adquirida no mercado interno; 3-Nacional, conteudo superior 40% e inferior ou igual a 70%; 4-Nacional, processos produtivos b\u00E1sicos; 5-Nacional, conteudo inferior 40%; 6-Estrangeira - Importa\u00E7\u00E3o direta, com similar nacional, lista CAMEX; 7-Estrangeira - mercado interno, sem simular,lista CAMEX;8-Nacional, Conte\u00FAdo de Importa\u00E7\u00E3o superior a 70%.", required = true, minOccurs = "1")
						@Element(name = "orig")
						private String orig;
						/**
						 * 201- Tributada pelo Simples Nacional com permissão de
						 * crédito e com cobrança do ICMS por Substituição
						 * Tributária (v.2.0)
						 */
						@Validation(whiteSpace = "preserve", enumerations = "201", text = "201- Tributada pelo Simples Nacional com permiss\u00E3o de cr\u00E9dito e com cobran\u00E7a do ICMS por Substitui\u00E7\u00E3o Tribut\u00E1ria (v.2.0)", required = true, minOccurs = "1")
						@Element(name = "CSOSN")
						private String CSOSN;
						/**
						 * Modalidade de determinação da BC do ICMS ST: 0 –
						 * Preço tabelado ou máximo sugerido; 1 - Lista Negativa
						 * (valor); 2 - Lista Positiva (valor); 3 - Lista Neutra
						 * (valor); 4 - Margem Valor Agregado (%); 5 - Pauta
						 * (valor). (v2.0)
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5"}, text = "Modalidade de determina\u00E7\u00E3o da BC do ICMS ST:\n0 \u2013 Pre\u00E7o tabelado ou m\u00E1ximo  sugerido;\n1 - Lista Negativa (valor);\n2 - Lista Positiva (valor);\n3 - Lista Neutra (valor);\n4 - Margem Valor Agregado (%);\n5 - Pauta (valor). (v2.0)", required = true, minOccurs = "1")
						@Element(name = "modBCST")
						private String modBCST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pMVAST")
						private String pMVAST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pRedBCST")
						private String pRedBCST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vBCST")
						private String vBCST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "pICMSST")
						private String pICMSST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vICMSST")
						private String vICMSST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCFCPST")
						private String vBCFCPST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "1")
						@Element(name = "pFCPST")
						private String pFCPST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vFCPST")
						private String vFCPST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "pCredSN")
						private String pCredSN;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vCredICMSSN")
						private String vCredICMSSN;

						public String getOrig() {
							return this.orig;
						}

						public void setOrig(String orig) {
							this.orig = orig;
						}

						public String getCSOSN() {
							return this.CSOSN;
						}

						public void setCSOSN(String CSOSN) {
							this.CSOSN = CSOSN;
						}

						public String getModBCST() {
							return this.modBCST;
						}

						public void setModBCST(String modBCST) {
							this.modBCST = modBCST;
						}

						public String getPMVAST() {
							return this.pMVAST;
						}

						public void setPMVAST(String pMVAST) {
							this.pMVAST = pMVAST;
						}

						public String getPRedBCST() {
							return this.pRedBCST;
						}

						public void setPRedBCST(String pRedBCST) {
							this.pRedBCST = pRedBCST;
						}

						public String getVBCST() {
							return this.vBCST;
						}

						public void setVBCST(String vBCST) {
							this.vBCST = vBCST;
						}

						public String getPICMSST() {
							return this.pICMSST;
						}

						public void setPICMSST(String pICMSST) {
							this.pICMSST = pICMSST;
						}

						public String getVICMSST() {
							return this.vICMSST;
						}

						public void setVICMSST(String vICMSST) {
							this.vICMSST = vICMSST;
						}

						public String getVBCFCPST() {
							return this.vBCFCPST;
						}

						public void setVBCFCPST(String vBCFCPST) {
							this.vBCFCPST = vBCFCPST;
						}

						public String getPFCPST() {
							return this.pFCPST;
						}

						public void setPFCPST(String pFCPST) {
							this.pFCPST = pFCPST;
						}

						public String getVFCPST() {
							return this.vFCPST;
						}

						public void setVFCPST(String vFCPST) {
							this.vFCPST = vFCPST;
						}

						public String getPCredSN() {
							return this.pCredSN;
						}

						public void setPCredSN(String pCredSN) {
							this.pCredSN = pCredSN;
						}

						public String getVCredICMSSN() {
							return this.vCredICMSSN;
						}

						public void setVCredICMSSN(String vCredICMSSN) {
							this.vCredICMSSN = vCredICMSSN;
						}
					}

					public ICMSSN201 getICMSSN201() {
						return this.ICMSSN201;
					}

					public void setICMSSN201(ICMSSN201 ICMSSN201) {
						this.ICMSSN201 = ICMSSN201;
					}

					@WXml
					@Order(elements = {"orig", "CSOSN", "modBCST", "pMVAST",
							"pRedBCST", "vBCST", "pICMSST", "vICMSST",
							"vBCFCPST", "pFCPST", "vFCPST"})
					@Element(name = "ICMSSN202")
					public static class ICMSSN202 {
						/**
						 * Tipo Origem da mercadoria CST ICMS origem da
						 * mercadoria: 0-Nacional exceto as indicadas nos
						 * códigos 3, 4, 5 e 8; 1-Estrangeira - Importação
						 * direta; 2-Estrangeira - Adquirida no mercado interno;
						 * 3-Nacional, conteudo superior 40% e inferior ou igual
						 * a 70%; 4-Nacional, processos produtivos básicos;
						 * 5-Nacional, conteudo inferior 40%; 6-Estrangeira -
						 * Importação direta, com similar nacional, lista CAMEX;
						 * 7-Estrangeira - mercado interno, sem simular,lista
						 * CAMEX;8-Nacional, Conteúdo de Importação superior a
						 * 70%.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5", "6", "7", "8"}, text = "Tipo Origem da mercadoria CST ICMS  origem da mercadoria: 0-Nacional exceto as indicadas nos c\u00F3digos 3, 4, 5 e 8;\n1-Estrangeira - Importa\u00E7\u00E3o direta; 2-Estrangeira - Adquirida no mercado interno; 3-Nacional, conteudo superior 40% e inferior ou igual a 70%; 4-Nacional, processos produtivos b\u00E1sicos; 5-Nacional, conteudo inferior 40%; 6-Estrangeira - Importa\u00E7\u00E3o direta, com similar nacional, lista CAMEX; 7-Estrangeira - mercado interno, sem simular,lista CAMEX;8-Nacional, Conte\u00FAdo de Importa\u00E7\u00E3o superior a 70%.", required = true, minOccurs = "1")
						@Element(name = "orig")
						private String orig;
						/**
						 * 202- Tributada pelo Simples Nacional sem permissão de
						 * crédito e com cobrança do ICMS por Substituição
						 * Tributária; 203- Isenção do ICMS nos Simples Nacional
						 * para faixa de receita bruta e com cobrança do ICMS
						 * por Substituição Tributária (v.2.0)
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"202", "203"}, text = "202- Tributada pelo Simples Nacional sem permiss\u00E3o de cr\u00E9dito e com cobran\u00E7a do ICMS por Substitui\u00E7\u00E3o Tribut\u00E1ria;\n203-  Isen\u00E7\u00E3o do ICMS nos Simples Nacional para faixa de receita bruta e com cobran\u00E7a do ICMS por Substitui\u00E7\u00E3o Tribut\u00E1ria (v.2.0)", required = true, minOccurs = "1")
						@Element(name = "CSOSN")
						private String CSOSN;
						/**
						 * Modalidade de determinação da BC do ICMS ST: 0 –
						 * Preço tabelado ou máximo sugerido; 1 - Lista Negativa
						 * (valor); 2 - Lista Positiva (valor); 3 - Lista Neutra
						 * (valor); 4 - Margem Valor Agregado (%); 5 - Pauta
						 * (valor). (v2.0)
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5"}, text = "Modalidade de determina\u00E7\u00E3o da BC do ICMS ST:\n0 \u2013 Pre\u00E7o tabelado ou m\u00E1ximo  sugerido;\n1 - Lista Negativa (valor);\n2 - Lista Positiva (valor);\n3 - Lista Neutra (valor);\n4 - Margem Valor Agregado (%);\n5 - Pauta (valor). (v2.0)", required = true, minOccurs = "1")
						@Element(name = "modBCST")
						private String modBCST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pMVAST")
						private String pMVAST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pRedBCST")
						private String pRedBCST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vBCST")
						private String vBCST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "pICMSST")
						private String pICMSST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vICMSST")
						private String vICMSST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCFCPST")
						private String vBCFCPST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "1")
						@Element(name = "pFCPST")
						private String pFCPST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vFCPST")
						private String vFCPST;

						public String getOrig() {
							return this.orig;
						}

						public void setOrig(String orig) {
							this.orig = orig;
						}

						public String getCSOSN() {
							return this.CSOSN;
						}

						public void setCSOSN(String CSOSN) {
							this.CSOSN = CSOSN;
						}

						public String getModBCST() {
							return this.modBCST;
						}

						public void setModBCST(String modBCST) {
							this.modBCST = modBCST;
						}

						public String getPMVAST() {
							return this.pMVAST;
						}

						public void setPMVAST(String pMVAST) {
							this.pMVAST = pMVAST;
						}

						public String getPRedBCST() {
							return this.pRedBCST;
						}

						public void setPRedBCST(String pRedBCST) {
							this.pRedBCST = pRedBCST;
						}

						public String getVBCST() {
							return this.vBCST;
						}

						public void setVBCST(String vBCST) {
							this.vBCST = vBCST;
						}

						public String getPICMSST() {
							return this.pICMSST;
						}

						public void setPICMSST(String pICMSST) {
							this.pICMSST = pICMSST;
						}

						public String getVICMSST() {
							return this.vICMSST;
						}

						public void setVICMSST(String vICMSST) {
							this.vICMSST = vICMSST;
						}

						public String getVBCFCPST() {
							return this.vBCFCPST;
						}

						public void setVBCFCPST(String vBCFCPST) {
							this.vBCFCPST = vBCFCPST;
						}

						public String getPFCPST() {
							return this.pFCPST;
						}

						public void setPFCPST(String pFCPST) {
							this.pFCPST = pFCPST;
						}

						public String getVFCPST() {
							return this.vFCPST;
						}

						public void setVFCPST(String vFCPST) {
							this.vFCPST = vFCPST;
						}
					}

					public ICMSSN202 getICMSSN202() {
						return this.ICMSSN202;
					}

					public void setICMSSN202(ICMSSN202 ICMSSN202) {
						this.ICMSSN202 = ICMSSN202;
					}

					@WXml
					@Order(elements = {"orig", "CSOSN", "vBCSTRet", "pST",
							"vICMSSTRet", "vBCFCPSTRet", "pFCPSTRet",
							"vFCPSTRet"})
					@Element(name = "ICMSSN500")
					public static class ICMSSN500 {
						/**
						 * Tipo Origem da mercadoria CST ICMS origem da
						 * mercadoria: 0-Nacional exceto as indicadas nos
						 * códigos 3, 4, 5 e 8; 1-Estrangeira - Importação
						 * direta; 2-Estrangeira - Adquirida no mercado interno;
						 * 3-Nacional, conteudo superior 40% e inferior ou igual
						 * a 70%; 4-Nacional, processos produtivos básicos;
						 * 5-Nacional, conteudo inferior 40%; 6-Estrangeira -
						 * Importação direta, com similar nacional, lista CAMEX;
						 * 7-Estrangeira - mercado interno, sem simular,lista
						 * CAMEX;8-Nacional, Conteúdo de Importação superior a
						 * 70%.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5", "6", "7", "8"}, text = "Tipo Origem da mercadoria CST ICMS  origem da mercadoria: 0-Nacional exceto as indicadas nos c\u00F3digos 3, 4, 5 e 8;\n1-Estrangeira - Importa\u00E7\u00E3o direta; 2-Estrangeira - Adquirida no mercado interno; 3-Nacional, conteudo superior 40% e inferior ou igual a 70%; 4-Nacional, processos produtivos b\u00E1sicos; 5-Nacional, conteudo inferior 40%; 6-Estrangeira - Importa\u00E7\u00E3o direta, com similar nacional, lista CAMEX; 7-Estrangeira - mercado interno, sem simular,lista CAMEX;8-Nacional, Conte\u00FAdo de Importa\u00E7\u00E3o superior a 70%.", required = true, minOccurs = "1")
						@Element(name = "orig")
						private String orig;
						/**
						 * 500 – ICMS cobrado anterirmente por substituição
						 * tributária (substituído) ou por antecipação (v.2.0)
						 */
						@Validation(whiteSpace = "preserve", enumerations = "500", text = "500 \u2013 ICMS cobrado anterirmente por substitui\u00E7\u00E3o tribut\u00E1ria (substitu\u00EDdo) ou por antecipa\u00E7\u00E3o\n(v.2.0)", required = true, minOccurs = "1")
						@Element(name = "CSOSN")
						private String CSOSN;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCSTRet")
						private String vBCSTRet;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "1")
						@Element(name = "pST")
						private String pST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vICMSSTRet")
						private String vICMSSTRet;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCFCPSTRet")
						private String vBCFCPSTRet;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "1")
						@Element(name = "pFCPSTRet")
						private String pFCPSTRet;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vFCPSTRet")
						private String vFCPSTRet;

						public String getOrig() {
							return this.orig;
						}

						public void setOrig(String orig) {
							this.orig = orig;
						}

						public String getCSOSN() {
							return this.CSOSN;
						}

						public void setCSOSN(String CSOSN) {
							this.CSOSN = CSOSN;
						}

						public String getVBCSTRet() {
							return this.vBCSTRet;
						}

						public void setVBCSTRet(String vBCSTRet) {
							this.vBCSTRet = vBCSTRet;
						}

						public String getPST() {
							return this.pST;
						}

						public void setPST(String pST) {
							this.pST = pST;
						}

						public String getVICMSSTRet() {
							return this.vICMSSTRet;
						}

						public void setVICMSSTRet(String vICMSSTRet) {
							this.vICMSSTRet = vICMSSTRet;
						}

						public String getVBCFCPSTRet() {
							return this.vBCFCPSTRet;
						}

						public void setVBCFCPSTRet(String vBCFCPSTRet) {
							this.vBCFCPSTRet = vBCFCPSTRet;
						}

						public String getPFCPSTRet() {
							return this.pFCPSTRet;
						}

						public void setPFCPSTRet(String pFCPSTRet) {
							this.pFCPSTRet = pFCPSTRet;
						}

						public String getVFCPSTRet() {
							return this.vFCPSTRet;
						}

						public void setVFCPSTRet(String vFCPSTRet) {
							this.vFCPSTRet = vFCPSTRet;
						}
					}

					public ICMSSN500 getICMSSN500() {
						return this.ICMSSN500;
					}

					public void setICMSSN500(ICMSSN500 ICMSSN500) {
						this.ICMSSN500 = ICMSSN500;
					}

					@WXml
					@Order(elements = {"orig", "CSOSN", "modBC", "vBC",
							"pRedBC", "pICMS", "vICMS", "modBCST", "pMVAST",
							"pRedBCST", "vBCST", "pICMSST", "vICMSST",
							"vBCFCPST", "pFCPST", "vFCPST", "pCredSN",
							"vCredICMSSN"})
					@Element(name = "ICMSSN900")
					public static class ICMSSN900 {
						/**
						 * Tipo Origem da mercadoria CST ICMS origem da
						 * mercadoria: 0-Nacional exceto as indicadas nos
						 * códigos 3, 4, 5 e 8; 1-Estrangeira - Importação
						 * direta; 2-Estrangeira - Adquirida no mercado interno;
						 * 3-Nacional, conteudo superior 40% e inferior ou igual
						 * a 70%; 4-Nacional, processos produtivos básicos;
						 * 5-Nacional, conteudo inferior 40%; 6-Estrangeira -
						 * Importação direta, com similar nacional, lista CAMEX;
						 * 7-Estrangeira - mercado interno, sem simular,lista
						 * CAMEX;8-Nacional, Conteúdo de Importação superior a
						 * 70%.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5", "6", "7", "8"}, text = "Tipo Origem da mercadoria CST ICMS  origem da mercadoria: 0-Nacional exceto as indicadas nos c\u00F3digos 3, 4, 5 e 8;\n1-Estrangeira - Importa\u00E7\u00E3o direta; 2-Estrangeira - Adquirida no mercado interno; 3-Nacional, conteudo superior 40% e inferior ou igual a 70%; 4-Nacional, processos produtivos b\u00E1sicos; 5-Nacional, conteudo inferior 40%; 6-Estrangeira - Importa\u00E7\u00E3o direta, com similar nacional, lista CAMEX; 7-Estrangeira - mercado interno, sem simular,lista CAMEX;8-Nacional, Conte\u00FAdo de Importa\u00E7\u00E3o superior a 70%.", required = true, minOccurs = "1")
						@Element(name = "orig")
						private String orig;
						/**
						 * Tributação pelo ICMS 900 - Outros(v2.0)
						 */
						@Validation(whiteSpace = "preserve", enumerations = "900", text = "Tributa\u00E7\u00E3o pelo ICMS 900 - Outros(v2.0)", required = true, minOccurs = "1")
						@Element(name = "CSOSN")
						private String CSOSN;
						/**
						 * Modalidade de determinação da BC do ICMS: 0 - Margem
						 * Valor Agregado (%); 1 - Pauta (valor); 2 - Preço
						 * Tabelado Máximo (valor); 3 - Valor da Operação.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3"}, text = "Modalidade de determina\u00E7\u00E3o da BC do ICMS: \n0 - Margem Valor Agregado (%);\n1 - Pauta (valor);\n2 - Pre\u00E7o Tabelado M\u00E1ximo (valor);\n3 - Valor da Opera\u00E7\u00E3o.", required = false, minOccurs = "1")
						@Element(name = "modBC")
						private String modBC;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBC")
						private String vBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pRedBC")
						private String pRedBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = false, minOccurs = "1")
						@Element(name = "pICMS")
						private String pICMS;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vICMS")
						private String vICMS;
						/**
						 * Modalidade de determinação da BC do ICMS ST: 0 –
						 * Preço tabelado ou máximo sugerido; 1 - Lista Negativa
						 * (valor); 2 - Lista Positiva (valor); 3 - Lista Neutra
						 * (valor); 4 - Margem Valor Agregado (%); 5 - Pauta
						 * (valor).
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"0", "1", "2", "3", "4", "5"}, text = "Modalidade de determina\u00E7\u00E3o da BC do ICMS ST:\n0 \u2013 Pre\u00E7o tabelado ou m\u00E1ximo  sugerido;\n1 - Lista Negativa (valor);\n2 - Lista Positiva (valor);\n3 - Lista Neutra (valor);\n4 - Margem Valor Agregado (%);\n5 - Pauta (valor).", required = false, minOccurs = "1")
						@Element(name = "modBCST")
						private String modBCST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pMVAST")
						private String pMVAST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "0")
						@Element(name = "pRedBCST")
						private String pRedBCST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCST")
						private String vBCST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = false, minOccurs = "1")
						@Element(name = "pICMSST")
						private String pICMSST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vICMSST")
						private String vICMSST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBCFCPST")
						private String vBCFCPST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros e 2 até 4
						 * decimais. Utilizados em TAGs opcionais, não aceita
						 * valor zero.
						 */
						@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros e 2 at\u00E9 4 decimais. Utilizados em TAGs opcionais, n\u00E3o aceita valor zero.", required = false, minOccurs = "1")
						@Element(name = "pFCPST")
						private String pFCPST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vFCPST")
						private String vFCPST;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = false, minOccurs = "1")
						@Element(name = "pCredSN")
						private String pCredSN;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vCredICMSSN")
						private String vCredICMSSN;

						public String getOrig() {
							return this.orig;
						}

						public void setOrig(String orig) {
							this.orig = orig;
						}

						public String getCSOSN() {
							return this.CSOSN;
						}

						public void setCSOSN(String CSOSN) {
							this.CSOSN = CSOSN;
						}

						public String getModBC() {
							return this.modBC;
						}

						public void setModBC(String modBC) {
							this.modBC = modBC;
						}

						public String getVBC() {
							return this.vBC;
						}

						public void setVBC(String vBC) {
							this.vBC = vBC;
						}

						public String getPRedBC() {
							return this.pRedBC;
						}

						public void setPRedBC(String pRedBC) {
							this.pRedBC = pRedBC;
						}

						public String getPICMS() {
							return this.pICMS;
						}

						public void setPICMS(String pICMS) {
							this.pICMS = pICMS;
						}

						public String getVICMS() {
							return this.vICMS;
						}

						public void setVICMS(String vICMS) {
							this.vICMS = vICMS;
						}

						public String getModBCST() {
							return this.modBCST;
						}

						public void setModBCST(String modBCST) {
							this.modBCST = modBCST;
						}

						public String getPMVAST() {
							return this.pMVAST;
						}

						public void setPMVAST(String pMVAST) {
							this.pMVAST = pMVAST;
						}

						public String getPRedBCST() {
							return this.pRedBCST;
						}

						public void setPRedBCST(String pRedBCST) {
							this.pRedBCST = pRedBCST;
						}

						public String getVBCST() {
							return this.vBCST;
						}

						public void setVBCST(String vBCST) {
							this.vBCST = vBCST;
						}

						public String getPICMSST() {
							return this.pICMSST;
						}

						public void setPICMSST(String pICMSST) {
							this.pICMSST = pICMSST;
						}

						public String getVICMSST() {
							return this.vICMSST;
						}

						public void setVICMSST(String vICMSST) {
							this.vICMSST = vICMSST;
						}

						public String getVBCFCPST() {
							return this.vBCFCPST;
						}

						public void setVBCFCPST(String vBCFCPST) {
							this.vBCFCPST = vBCFCPST;
						}

						public String getPFCPST() {
							return this.pFCPST;
						}

						public void setPFCPST(String pFCPST) {
							this.pFCPST = pFCPST;
						}

						public String getVFCPST() {
							return this.vFCPST;
						}

						public void setVFCPST(String vFCPST) {
							this.vFCPST = vFCPST;
						}

						public String getPCredSN() {
							return this.pCredSN;
						}

						public void setPCredSN(String pCredSN) {
							this.pCredSN = pCredSN;
						}

						public String getVCredICMSSN() {
							return this.vCredICMSSN;
						}

						public void setVCredICMSSN(String vCredICMSSN) {
							this.vCredICMSSN = vCredICMSSN;
						}
					}

					public ICMSSN900 getICMSSN900() {
						return this.ICMSSN900;
					}

					public void setICMSSN900(ICMSSN900 ICMSSN900) {
						this.ICMSSN900 = ICMSSN900;
					}
				}

				public ICMS getICMS() {
					return this.ICMS;
				}

				public void setICMS(ICMS ICMS) {
					this.ICMS = ICMS;
				}

				public TIpi getIPI() {
					return this.IPI;
				}

				public void setIPI(TIpi IPI) {
					this.IPI = IPI;
				}

				@WXml
				@Order(elements = {"vBC", "vDespAdu", "vII", "vIOF"})
				@Element(name = "II")
				public static class II {
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
					@Element(name = "vBC")
					private String vBC;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
					@Element(name = "vDespAdu")
					private String vDespAdu;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
					@Element(name = "vII")
					private String vII;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
					@Element(name = "vIOF")
					private String vIOF;

					public String getVBC() {
						return this.vBC;
					}

					public void setVBC(String vBC) {
						this.vBC = vBC;
					}

					public String getVDespAdu() {
						return this.vDespAdu;
					}

					public void setVDespAdu(String vDespAdu) {
						this.vDespAdu = vDespAdu;
					}

					public String getVII() {
						return this.vII;
					}

					public void setVII(String vII) {
						this.vII = vII;
					}

					public String getVIOF() {
						return this.vIOF;
					}

					public void setVIOF(String vIOF) {
						this.vIOF = vIOF;
					}
				}

				public II getII() {
					return this.II;
				}

				public void setII(II II) {
					this.II = II;
				}

				@WXml
				@Order(elements = {"vBC", "vAliq", "vISSQN", "cMunFG",
						"cListServ", "vDeducao", "vOutro", "vDescIncond",
						"vDescCond", "vISSRet", "indISS", "cServico", "cMun",
						"cPais", "nProcesso", "indIncentivo"})
				@Element(name = "ISSQN")
				public static class ISSQN {
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
					@Element(name = "vBC")
					private String vBC;
					/**
					 * Tipo Decimal com até 3 dígitos inteiros, podendo ter de 2
					 * até 4 decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
					@Element(name = "vAliq")
					private String vAliq;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
					@Element(name = "vISSQN")
					private String vISSQN;
					/**
					 * Tipo Código do Município da tabela do IBGE
					 */
					@Validation(whiteSpace = "preserve", pattern = "[0-9]{7}", text = "Tipo C\u00F3digo do Munic\u00EDpio da tabela do IBGE", required = true, minOccurs = "1")
					@Element(name = "cMunFG")
					private String cMunFG;
					/**
					 * Tipo Código da Lista de Serviços LC 116/2003
					 */
					@Validation(whiteSpace = "preserve", enumerations = {
							"01.01", "01.02", "01.03", "01.04", "01.05",
							"01.06", "01.07", "01.08", "02.01", "03.02",
							"03.03", "03.04", "03.05", "04.01", "04.02",
							"04.03", "04.04", "04.05", "04.06", "04.07",
							"04.08", "04.09", "04.10", "04.11", "04.12",
							"04.13", "04.14", "04.15", "04.16", "04.17",
							"04.18", "04.19", "04.20", "04.21", "04.22",
							"04.23", "05.01", "05.02", "05.03", "05.04",
							"05.05", "05.06", "05.07", "05.08", "05.09",
							"06.01", "06.02", "06.03", "06.04", "06.05",
							"07.01", "07.02", "07.03", "07.04", "07.05",
							"07.06", "07.07", "07.08", "07.09", "07.10",
							"07.11", "07.12", "07.13", "07.16", "07.17",
							"07.18", "07.19", "07.20", "07.21", "07.22",
							"08.01", "08.02", "09.01", "09.02", "09.03",
							"10.01", "10.02", "10.03", "10.04", "10.05",
							"10.06", "10.07", "10.08", "10.09", "10.10",
							"11.01", "11.02", "11.03", "11.04", "12.01",
							"12.02", "12.03", "12.04", "12.05", "12.06",
							"12.07", "12.08", "12.09", "12.10", "12.11",
							"12.12", "12.13", "12.14", "12.15", "12.16",
							"12.17", "13.02", "13.03", "13.04", "13.05",
							"14.01", "14.02", "14.03", "14.04", "14.05",
							"14.06", "14.07", "14.08", "14.09", "14.10",
							"14.11", "14.12", "14.13", "15.01", "15.02",
							"15.03", "15.04", "15.05", "15.06", "15.07",
							"15.08", "15.09", "15.10", "15.11", "15.12",
							"15.13", "15.14", "15.15", "15.16", "15.17",
							"15.18", "16.01", "17.01", "17.02", "17.03",
							"17.04", "17.05", "17.06", "17.08", "17.09",
							"17.10", "17.11", "17.12", "17.13", "17.14",
							"17.15", "17.16", "17.17", "17.18", "17.19",
							"17.20", "17.21", "17.22", "17.23", "17.24",
							"17.25", "18.01", "19.01", "20.01", "20.02",
							"20.03", "21.01", "22.01", "23.01", "24.01",
							"25.01", "25.02", "25.03", "25.04", "26.01",
							"27.01", "28.01", "29.01", "30.01", "31.01",
							"32.01", "33.01", "34.01", "35.01", "36.01",
							"37.01", "38.01", "39.01", "40.01"}, text = "Tipo C\u00F3digo da Lista de Servi\u00E7os LC 116/2003", required = true, minOccurs = "1")
					@Element(name = "cListServ")
					private String cListServ;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais, utilizado em tags opcionais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
					@Element(name = "vDeducao")
					private String vDeducao;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais, utilizado em tags opcionais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
					@Element(name = "vOutro")
					private String vOutro;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais, utilizado em tags opcionais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
					@Element(name = "vDescIncond")
					private String vDescIncond;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais, utilizado em tags opcionais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
					@Element(name = "vDescCond")
					private String vDescCond;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais, utilizado em tags opcionais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
					@Element(name = "vISSRet")
					private String vISSRet;
					/**
					 * Exibilidade do ISS:1-Exigível;2-Não
					 * incidente;3-Isenção;4-Exportação;5-Imunidade;6-Exig.Susp.
					 * Judicial;7-Exig.Susp. ADM
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"1",
							"2", "3", "4", "5", "6", "7"}, text = "Exibilidade do ISS:1-Exig\u00EDvel;2-N\u00E3o incidente;3-Isen\u00E7\u00E3o;4-Exporta\u00E7\u00E3o;5-Imunidade;6-Exig.Susp. Judicial;7-Exig.Susp. ADM", required = true, minOccurs = "1")
					@Element(name = "indISS")
					private String indISS;
					/**
					 * Código do serviço prestado dentro do município
					 */
					@Validation(whiteSpace = "preserve", minLength = "1", maxLength = "20", text = "C\u00F3digo do servi\u00E7o prestado dentro do munic\u00EDpio", required = false, minOccurs = "0")
					@Element(name = "cServico")
					private String cServico;
					/**
					 * Tipo Código do Município da tabela do IBGE
					 */
					@Validation(whiteSpace = "preserve", pattern = "[0-9]{7}", text = "Tipo C\u00F3digo do Munic\u00EDpio da tabela do IBGE", required = false, minOccurs = "0")
					@Element(name = "cMun")
					private String cMun;
					/**
					 * Código de Pais
					 */
					@Validation(whiteSpace = "preserve", pattern = "[0-9]{1,4}", text = "C\u00F3digo de Pais", required = false, minOccurs = "0")
					@Element(name = "cPais")
					private String cPais;
					/**
					 * Número do Processo administrativo ou judicial de
					 * suspenção do processo
					 */
					@Validation(whiteSpace = "preserve", minLength = "1", maxLength = "30", text = "N\u00FAmero do Processo administrativo ou judicial de suspen\u00E7\u00E3o do processo", required = false, minOccurs = "0")
					@Element(name = "nProcesso")
					private String nProcesso;
					/**
					 * Indicador de Incentivo Fiscal. 1=Sim; 2=Não
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"1",
							"2"}, text = "Indicador de Incentivo Fiscal. 1=Sim; 2=N\u00E3o", required = true, minOccurs = "1")
					@Element(name = "indIncentivo")
					private String indIncentivo;

					public String getVBC() {
						return this.vBC;
					}

					public void setVBC(String vBC) {
						this.vBC = vBC;
					}

					public String getVAliq() {
						return this.vAliq;
					}

					public void setVAliq(String vAliq) {
						this.vAliq = vAliq;
					}

					public String getVISSQN() {
						return this.vISSQN;
					}

					public void setVISSQN(String vISSQN) {
						this.vISSQN = vISSQN;
					}

					public String getCMunFG() {
						return this.cMunFG;
					}

					public void setCMunFG(String cMunFG) {
						this.cMunFG = cMunFG;
					}

					public String getCListServ() {
						return this.cListServ;
					}

					public void setCListServ(String cListServ) {
						this.cListServ = cListServ;
					}

					public String getVDeducao() {
						return this.vDeducao;
					}

					public void setVDeducao(String vDeducao) {
						this.vDeducao = vDeducao;
					}

					public String getVOutro() {
						return this.vOutro;
					}

					public void setVOutro(String vOutro) {
						this.vOutro = vOutro;
					}

					public String getVDescIncond() {
						return this.vDescIncond;
					}

					public void setVDescIncond(String vDescIncond) {
						this.vDescIncond = vDescIncond;
					}

					public String getVDescCond() {
						return this.vDescCond;
					}

					public void setVDescCond(String vDescCond) {
						this.vDescCond = vDescCond;
					}

					public String getVISSRet() {
						return this.vISSRet;
					}

					public void setVISSRet(String vISSRet) {
						this.vISSRet = vISSRet;
					}

					public String getIndISS() {
						return this.indISS;
					}

					public void setIndISS(String indISS) {
						this.indISS = indISS;
					}

					public String getCServico() {
						return this.cServico;
					}

					public void setCServico(String cServico) {
						this.cServico = cServico;
					}

					public String getCMun() {
						return this.cMun;
					}

					public void setCMun(String cMun) {
						this.cMun = cMun;
					}

					public String getCPais() {
						return this.cPais;
					}

					public void setCPais(String cPais) {
						this.cPais = cPais;
					}

					public String getNProcesso() {
						return this.nProcesso;
					}

					public void setNProcesso(String nProcesso) {
						this.nProcesso = nProcesso;
					}

					public String getIndIncentivo() {
						return this.indIncentivo;
					}

					public void setIndIncentivo(String indIncentivo) {
						this.indIncentivo = indIncentivo;
					}
				}

				public ISSQN getISSQN() {
					return this.ISSQN;
				}

				public void setISSQN(ISSQN ISSQN) {
					this.ISSQN = ISSQN;
				}

				@Validation(choices = "[{\"items\":[\"PISAliq\"]},{\"items\":[\"PISQtde\"]},{\"items\":[\"PISNT\"]},{\"items\":[\"PISOutr\"]}]")
				@WXml
				@Order(elements = {"PISAliq", "PISQtde", "PISNT", "PISOutr"})
				@Element(name = "PIS")
				public static class PIS {
					/**
					 * Código de Situação Tributária do PIS. 01 – Operação
					 * Tributável - Base de Cálculo = Valor da Operação Alíquota
					 * Normal (Cumulativo/Não Cumulativo); 02 - Operação
					 * Tributável - Base de Calculo = Valor da Operação
					 * (Alíquota Diferenciada);
					 */
					@Element(name = "PISAliq")
					@Validation(required = false, minOccurs = "1")
					private PISAliq PISAliq;
					/**
					 * Código de Situação Tributária do PIS. 03 - Operação
					 * Tributável - Base de Calculo = Quantidade Vendida x
					 * Alíquota por Unidade de Produto;
					 */
					@Element(name = "PISQtde")
					@Validation(required = false, minOccurs = "1")
					private PISQtde PISQtde;
					/**
					 * Código de Situação Tributária do PIS. 04 - Operação
					 * Tributável - Tributação Monofásica - (Alíquota Zero); 06
					 * - Operação Tributável - Alíquota Zero; 07 - Operação
					 * Isenta da contribuição; 08 - Operação Sem Incidência da
					 * contribuição; 09 - Operação com suspensão da
					 * contribuição;
					 */
					@Element(name = "PISNT")
					@Validation(required = false, minOccurs = "1")
					private PISNT PISNT;
					/**
					 * Código de Situação Tributária do PIS. 99 - Outras
					 * Operações.
					 */
					@Element(name = "PISOutr")
					@Validation(required = false, minOccurs = "1")
					private PISOutr PISOutr;

					@WXml
					@Order(elements = {"CST", "vBC", "pPIS", "vPIS"})
					@Element(name = "PISAliq")
					public static class PISAliq {
						/**
						 * Código de Situação Tributária do PIS. 01 – Operação
						 * Tributável - Base de Cálculo = Valor da Operação
						 * Alíquota Normal (Cumulativo/Não Cumulativo); 02 -
						 * Operação Tributável - Base de Calculo = Valor da
						 * Operação (Alíquota Diferenciada);
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"01", "02"}, text = "C\u00F3digo de Situa\u00E7\u00E3o Tribut\u00E1ria do PIS.\n 01 \u2013 Opera\u00E7\u00E3o Tribut\u00E1vel - Base de C\u00E1lculo = Valor da Opera\u00E7\u00E3o Al\u00EDquota Normal (Cumulativo/N\u00E3o Cumulativo);\n02 - Opera\u00E7\u00E3o Tribut\u00E1vel - Base de Calculo = Valor da Opera\u00E7\u00E3o (Al\u00EDquota Diferenciada);", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vBC")
						private String vBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "pPIS")
						private String pPIS;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vPIS")
						private String vPIS;

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}

						public String getVBC() {
							return this.vBC;
						}

						public void setVBC(String vBC) {
							this.vBC = vBC;
						}

						public String getPPIS() {
							return this.pPIS;
						}

						public void setPPIS(String pPIS) {
							this.pPIS = pPIS;
						}

						public String getVPIS() {
							return this.vPIS;
						}

						public void setVPIS(String vPIS) {
							this.vPIS = vPIS;
						}
					}

					public PISAliq getPISAliq() {
						return this.PISAliq;
					}

					public void setPISAliq(PISAliq PISAliq) {
						this.PISAliq = PISAliq;
					}

					@WXml
					@Order(elements = {"CST", "qBCProd", "vAliqProd", "vPIS"})
					@Element(name = "PISQtde")
					public static class PISQtde {
						/**
						 * Código de Situação Tributária do PIS. 03 - Operação
						 * Tributável - Base de Calculo = Quantidade Vendida x
						 * Alíquota por Unidade de Produto;
						 */
						@Validation(whiteSpace = "preserve", enumerations = "03", text = "C\u00F3digo de Situa\u00E7\u00E3o Tribut\u00E1ria do PIS.\n03 - Opera\u00E7\u00E3o Tribut\u00E1vel - Base de Calculo = Quantidade Vendida x Al\u00EDquota por Unidade de Produto;", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;
						/**
						 * Tipo Decimal com 12 inteiros de 1 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,4}|[1-9]{1}[0-9]{0,11}|[1-9]{1}[0-9]{0,11}(\\.[0-9]{1,4})?", text = "Tipo Decimal com 12 inteiros de 1 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "qBCProd")
						private String qBCProd;
						/**
						 * Tipo Decimal com 11 inteiros, podendo ter de 1 até 4
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,4}|[1-9]{1}[0-9]{0,10}|[1-9]{1}[0-9]{0,10}(\\.[0-9]{1,4})?", text = "Tipo Decimal com 11 inteiros, podendo ter de 1 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "vAliqProd")
						private String vAliqProd;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vPIS")
						private String vPIS;

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}

						public String getQBCProd() {
							return this.qBCProd;
						}

						public void setQBCProd(String qBCProd) {
							this.qBCProd = qBCProd;
						}

						public String getVAliqProd() {
							return this.vAliqProd;
						}

						public void setVAliqProd(String vAliqProd) {
							this.vAliqProd = vAliqProd;
						}

						public String getVPIS() {
							return this.vPIS;
						}

						public void setVPIS(String vPIS) {
							this.vPIS = vPIS;
						}
					}

					public PISQtde getPISQtde() {
						return this.PISQtde;
					}

					public void setPISQtde(PISQtde PISQtde) {
						this.PISQtde = PISQtde;
					}

					@WXml
					@Order(elements = "CST")
					@Element(name = "PISNT")
					public static class PISNT {
						/**
						 * Código de Situação Tributária do PIS. 04 - Operação
						 * Tributável - Tributação Monofásica - (Alíquota Zero);
						 * 05 - Operação Tributável (ST); 06 - Operação
						 * Tributável - Alíquota Zero; 07 - Operação Isenta da
						 * contribuição; 08 - Operação Sem Incidência da
						 * contribuição; 09 - Operação com suspensão da
						 * contribuição;
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"04", "05", "06", "07", "08", "09"}, text = "C\u00F3digo de Situa\u00E7\u00E3o Tribut\u00E1ria do PIS.\n04 - Opera\u00E7\u00E3o Tribut\u00E1vel - Tributa\u00E7\u00E3o Monof\u00E1sica - (Al\u00EDquota Zero);\n05 - Opera\u00E7\u00E3o Tribut\u00E1vel (ST);\n06 - Opera\u00E7\u00E3o Tribut\u00E1vel - Al\u00EDquota Zero;\n07 - Opera\u00E7\u00E3o Isenta da contribui\u00E7\u00E3o;\n08 - Opera\u00E7\u00E3o Sem Incid\u00EAncia da contribui\u00E7\u00E3o;\n09 - Opera\u00E7\u00E3o com suspens\u00E3o da contribui\u00E7\u00E3o;", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}
					}

					public PISNT getPISNT() {
						return this.PISNT;
					}

					public void setPISNT(PISNT PISNT) {
						this.PISNT = PISNT;
					}

					@Validation(choices = "[{\"items\":[\"vBC\",\"pPIS\"]},{\"items\":[\"qBCProd\",\"vAliqProd\"]}]")
					@WXml
					@Order(elements = {"CST", "vBC", "pPIS", "qBCProd",
							"vAliqProd", "vPIS"})
					@Element(name = "PISOutr")
					public static class PISOutr {
						/**
						 * Código de Situação Tributária do PIS. 99 - Outras
						 * Operações.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"49", "50", "51", "52", "53", "54", "55", "56",
								"60", "61", "62", "63", "64", "65", "66", "67",
								"70", "71", "72", "73", "74", "75", "98", "99"}, text = "C\u00F3digo de Situa\u00E7\u00E3o Tribut\u00E1ria do PIS.\n99 - Outras Opera\u00E7\u00F5es.", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBC")
						private String vBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = false, minOccurs = "1")
						@Element(name = "pPIS")
						private String pPIS;
						/**
						 * Tipo Decimal com 12 inteiros de 1 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,4}|[1-9]{1}[0-9]{0,11}|[1-9]{1}[0-9]{0,11}(\\.[0-9]{1,4})?", text = "Tipo Decimal com 12 inteiros de 1 at\u00E9 4 decimais", required = false, minOccurs = "1")
						@Element(name = "qBCProd")
						private String qBCProd;
						/**
						 * Tipo Decimal com 11 inteiros, podendo ter de 1 até 4
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,4}|[1-9]{1}[0-9]{0,10}|[1-9]{1}[0-9]{0,10}(\\.[0-9]{1,4})?", text = "Tipo Decimal com 11 inteiros, podendo ter de 1 at\u00E9 4 decimais", required = false, minOccurs = "1")
						@Element(name = "vAliqProd")
						private String vAliqProd;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vPIS")
						private String vPIS;

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}

						public String getVBC() {
							return this.vBC;
						}

						public void setVBC(String vBC) {
							this.vBC = vBC;
						}

						public String getPPIS() {
							return this.pPIS;
						}

						public void setPPIS(String pPIS) {
							this.pPIS = pPIS;
						}

						public String getQBCProd() {
							return this.qBCProd;
						}

						public void setQBCProd(String qBCProd) {
							this.qBCProd = qBCProd;
						}

						public String getVAliqProd() {
							return this.vAliqProd;
						}

						public void setVAliqProd(String vAliqProd) {
							this.vAliqProd = vAliqProd;
						}

						public String getVPIS() {
							return this.vPIS;
						}

						public void setVPIS(String vPIS) {
							this.vPIS = vPIS;
						}
					}

					public PISOutr getPISOutr() {
						return this.PISOutr;
					}

					public void setPISOutr(PISOutr PISOutr) {
						this.PISOutr = PISOutr;
					}
				}

				public PIS getPIS() {
					return this.PIS;
				}

				public void setPIS(PIS PIS) {
					this.PIS = PIS;
				}

				@Validation(choices = "[{\"items\":[\"vBC\",\"pPIS\"]},{\"items\":[\"qBCProd\",\"vAliqProd\"]}]")
				@WXml
				@Order(elements = {"vBC", "pPIS", "qBCProd", "vAliqProd",
						"vPIS"})
				@Element(name = "PISST")
				public static class PISST {
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais, utilizado em tags opcionais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "1")
					@Element(name = "vBC")
					private String vBC;
					/**
					 * Tipo Decimal com até 3 dígitos inteiros, podendo ter de 2
					 * até 4 decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = false, minOccurs = "1")
					@Element(name = "pPIS")
					private String pPIS;
					/**
					 * Tipo Decimal com 12 inteiros e 4 decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,4}|[1-9]{1}[0-9]{0,11}|[1-9]{1}[0-9]{0,11}(\\.[0-9]{4})?", text = "Tipo Decimal com 12 inteiros e 4 decimais", required = false, minOccurs = "1")
					@Element(name = "qBCProd")
					private String qBCProd;
					/**
					 * Tipo Decimal com 11 inteiros, podendo ter 4 decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{4}|[1-9]{1}[0-9]{0,10}(\\.[0-9]{4})?", text = "Tipo Decimal com 11 inteiros, podendo ter 4 decimais", required = false, minOccurs = "1")
					@Element(name = "vAliqProd")
					private String vAliqProd;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
					@Element(name = "vPIS")
					private String vPIS;

					public String getVBC() {
						return this.vBC;
					}

					public void setVBC(String vBC) {
						this.vBC = vBC;
					}

					public String getPPIS() {
						return this.pPIS;
					}

					public void setPPIS(String pPIS) {
						this.pPIS = pPIS;
					}

					public String getQBCProd() {
						return this.qBCProd;
					}

					public void setQBCProd(String qBCProd) {
						this.qBCProd = qBCProd;
					}

					public String getVAliqProd() {
						return this.vAliqProd;
					}

					public void setVAliqProd(String vAliqProd) {
						this.vAliqProd = vAliqProd;
					}

					public String getVPIS() {
						return this.vPIS;
					}

					public void setVPIS(String vPIS) {
						this.vPIS = vPIS;
					}
				}

				public PISST getPISST() {
					return this.PISST;
				}

				public void setPISST(PISST PISST) {
					this.PISST = PISST;
				}

				@Validation(choices = "[{\"items\":[\"COFINSAliq\"]},{\"items\":[\"COFINSQtde\"]},{\"items\":[\"COFINSNT\"]},{\"items\":[\"COFINSOutr\"]}]")
				@WXml
				@Order(elements = {"COFINSAliq", "COFINSQtde", "COFINSNT",
						"COFINSOutr"})
				@Element(name = "COFINS")
				public static class COFINS {
					/**
					 * Código de Situação Tributária do COFINS. 01 – Operação
					 * Tributável - Base de Cálculo = Valor da Operação Alíquota
					 * Normal (Cumulativo/Não Cumulativo); 02 - Operação
					 * Tributável - Base de Calculo = Valor da Operação
					 * (Alíquota Diferenciada);
					 */
					@Element(name = "COFINSAliq")
					@Validation(required = false, minOccurs = "1")
					private COFINSAliq COFINSAliq;
					/**
					 * Código de Situação Tributária do COFINS. 03 - Operação
					 * Tributável - Base de Calculo = Quantidade Vendida x
					 * Alíquota por Unidade de Produto;
					 */
					@Element(name = "COFINSQtde")
					@Validation(required = false, minOccurs = "1")
					private COFINSQtde COFINSQtde;
					/**
					 * Código de Situação Tributária do COFINS: 04 - Operação
					 * Tributável - Tributação Monofásica - (Alíquota Zero); 06
					 * - Operação Tributável - Alíquota Zero; 07 - Operação
					 * Isenta da contribuição; 08 - Operação Sem Incidência da
					 * contribuição; 09 - Operação com suspensão da
					 * contribuição;
					 */
					@Element(name = "COFINSNT")
					@Validation(required = false, minOccurs = "1")
					private COFINSNT COFINSNT;
					/**
					 * Código de Situação Tributária do COFINS: 49 - Outras
					 * Operações de Saída 50 - Operação com Direito a Crédito -
					 * Vinculada Exclusivamente a Receita Tributada no Mercado
					 * Interno 51 - Operação com Direito a Crédito – Vinculada
					 * Exclusivamente a Receita Não Tributada no Mercado Interno
					 * 52 - Operação com Direito a Crédito - Vinculada
					 * Exclusivamente a Receita de Exportação 53 - Operação com
					 * Direito a Crédito - Vinculada a Receitas Tributadas e
					 * Não-Tributadas no Mercado Interno 54 - Operação com
					 * Direito a Crédito - Vinculada a Receitas Tributadas no
					 * Mercado Interno e de Exportação 55 - Operação com Direito
					 * a Crédito - Vinculada a Receitas Não-Tributadas no
					 * Mercado Interno e de Exportação 56 - Operação com Direito
					 * a Crédito - Vinculada a Receitas Tributadas e
					 * Não-Tributadas no Mercado Interno, e de Exportação 60 -
					 * Crédito Presumido - Operação de Aquisição Vinculada
					 * Exclusivamente a Receita Tributada no Mercado Interno 61
					 * - Crédito Presumido - Operação de Aquisição Vinculada
					 * Exclusivamente a Receita Não-Tributada no Mercado Interno
					 * 62 - Crédito Presumido - Operação de Aquisição Vinculada
					 * Exclusivamente a Receita de Exportação 63 - Crédito
					 * Presumido - Operação de Aquisição Vinculada a Receitas
					 * Tributadas e Não-Tributadas no Mercado Interno 64 -
					 * Crédito Presumido - Operação de Aquisição Vinculada a
					 * Receitas Tributadas no Mercado Interno e de Exportação 65
					 * - Crédito Presumido - Operação de Aquisição Vinculada a
					 * Receitas Não-Tributadas no Mercado Interno e de
					 * Exportação 66 - Crédito Presumido - Operação de Aquisição
					 * Vinculada a Receitas Tributadas e Não-Tributadas no
					 * Mercado Interno, e de Exportação 67 - Crédito Presumido -
					 * Outras Operações 70 - Operação de Aquisição sem Direito a
					 * Crédito 71 - Operação de Aquisição com Isenção 72 -
					 * Operação de Aquisição com Suspensão 73 - Operação de
					 * Aquisição a Alíquota Zero 74 - Operação de Aquisição sem
					 * Incidência da Contribuição 75 - Operação de Aquisição por
					 * Substituição Tributária 98 - Outras Operações de Entrada
					 * 99 - Outras Operações.
					 */
					@Element(name = "COFINSOutr")
					@Validation(required = false, minOccurs = "1")
					private COFINSOutr COFINSOutr;

					@WXml
					@Order(elements = {"CST", "vBC", "pCOFINS", "vCOFINS"})
					@Element(name = "COFINSAliq")
					public static class COFINSAliq {
						/**
						 * Código de Situação Tributária do COFINS. 01 –
						 * Operação Tributável - Base de Cálculo = Valor da
						 * Operação Alíquota Normal (Cumulativo/Não Cumulativo);
						 * 02 - Operação Tributável - Base de Calculo = Valor da
						 * Operação (Alíquota Diferenciada);
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"01", "02"}, text = "C\u00F3digo de Situa\u00E7\u00E3o Tribut\u00E1ria do COFINS.\n 01 \u2013 Opera\u00E7\u00E3o Tribut\u00E1vel - Base de C\u00E1lculo = Valor da Opera\u00E7\u00E3o Al\u00EDquota Normal (Cumulativo/N\u00E3o Cumulativo);\n02 - Opera\u00E7\u00E3o Tribut\u00E1vel - Base de Calculo = Valor da Opera\u00E7\u00E3o (Al\u00EDquota Diferenciada);", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vBC")
						private String vBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "pCOFINS")
						private String pCOFINS;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vCOFINS")
						private String vCOFINS;

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}

						public String getVBC() {
							return this.vBC;
						}

						public void setVBC(String vBC) {
							this.vBC = vBC;
						}

						public String getPCOFINS() {
							return this.pCOFINS;
						}

						public void setPCOFINS(String pCOFINS) {
							this.pCOFINS = pCOFINS;
						}

						public String getVCOFINS() {
							return this.vCOFINS;
						}

						public void setVCOFINS(String vCOFINS) {
							this.vCOFINS = vCOFINS;
						}
					}

					public COFINSAliq getCOFINSAliq() {
						return this.COFINSAliq;
					}

					public void setCOFINSAliq(COFINSAliq COFINSAliq) {
						this.COFINSAliq = COFINSAliq;
					}

					@WXml
					@Order(elements = {"CST", "qBCProd", "vAliqProd", "vCOFINS"})
					@Element(name = "COFINSQtde")
					public static class COFINSQtde {
						/**
						 * Código de Situação Tributária do COFINS. 03 -
						 * Operação Tributável - Base de Calculo = Quantidade
						 * Vendida x Alíquota por Unidade de Produto;
						 */
						@Validation(enumerations = "03", text = "C\u00F3digo de Situa\u00E7\u00E3o Tribut\u00E1ria do COFINS.\n03 - Opera\u00E7\u00E3o Tribut\u00E1vel - Base de Calculo = Quantidade Vendida x Al\u00EDquota por Unidade de Produto;", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;
						/**
						 * Tipo Decimal com 12 inteiros de 1 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,4}|[1-9]{1}[0-9]{0,11}|[1-9]{1}[0-9]{0,11}(\\.[0-9]{1,4})?", text = "Tipo Decimal com 12 inteiros de 1 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "qBCProd")
						private String qBCProd;
						/**
						 * Tipo Decimal com 11 inteiros, podendo ter de 1 até 4
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,4}|[1-9]{1}[0-9]{0,10}|[1-9]{1}[0-9]{0,10}(\\.[0-9]{1,4})?", text = "Tipo Decimal com 11 inteiros, podendo ter de 1 at\u00E9 4 decimais", required = true, minOccurs = "1")
						@Element(name = "vAliqProd")
						private String vAliqProd;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vCOFINS")
						private String vCOFINS;

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}

						public String getQBCProd() {
							return this.qBCProd;
						}

						public void setQBCProd(String qBCProd) {
							this.qBCProd = qBCProd;
						}

						public String getVAliqProd() {
							return this.vAliqProd;
						}

						public void setVAliqProd(String vAliqProd) {
							this.vAliqProd = vAliqProd;
						}

						public String getVCOFINS() {
							return this.vCOFINS;
						}

						public void setVCOFINS(String vCOFINS) {
							this.vCOFINS = vCOFINS;
						}
					}

					public COFINSQtde getCOFINSQtde() {
						return this.COFINSQtde;
					}

					public void setCOFINSQtde(COFINSQtde COFINSQtde) {
						this.COFINSQtde = COFINSQtde;
					}

					@WXml
					@Order(elements = "CST")
					@Element(name = "COFINSNT")
					public static class COFINSNT {
						/**
						 * Código de Situação Tributária do COFINS: 04 -
						 * Operação Tributável - Tributação Monofásica -
						 * (Alíquota Zero); 05 - Operação Tributável (ST); 06 -
						 * Operação Tributável - Alíquota Zero; 07 - Operação
						 * Isenta da contribuição; 08 - Operação Sem Incidência
						 * da contribuição; 09 - Operação com suspensão da
						 * contribuição;
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"04", "05", "06", "07", "08", "09"}, text = "C\u00F3digo de Situa\u00E7\u00E3o Tribut\u00E1ria do COFINS:\n04 - Opera\u00E7\u00E3o Tribut\u00E1vel - Tributa\u00E7\u00E3o Monof\u00E1sica - (Al\u00EDquota Zero);\n05 - Opera\u00E7\u00E3o Tribut\u00E1vel (ST);\n06 - Opera\u00E7\u00E3o Tribut\u00E1vel - Al\u00EDquota Zero;\n07 - Opera\u00E7\u00E3o Isenta da contribui\u00E7\u00E3o;\n08 - Opera\u00E7\u00E3o Sem Incid\u00EAncia da contribui\u00E7\u00E3o;\n09 - Opera\u00E7\u00E3o com suspens\u00E3o da contribui\u00E7\u00E3o;", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}
					}

					public COFINSNT getCOFINSNT() {
						return this.COFINSNT;
					}

					public void setCOFINSNT(COFINSNT COFINSNT) {
						this.COFINSNT = COFINSNT;
					}

					@Validation(choices = "[{\"items\":[\"vBC\",\"pCOFINS\"]},{\"items\":[\"qBCProd\",\"vAliqProd\"]}]")
					@WXml
					@Order(elements = {"CST", "vBC", "pCOFINS", "qBCProd",
							"vAliqProd", "vCOFINS"})
					@Element(name = "COFINSOutr")
					public static class COFINSOutr {
						/**
						 * Código de Situação Tributária do COFINS: 49 - Outras
						 * Operações de Saída 50 - Operação com Direito a
						 * Crédito - Vinculada Exclusivamente a Receita
						 * Tributada no Mercado Interno 51 - Operação com
						 * Direito a Crédito – Vinculada Exclusivamente a
						 * Receita Não Tributada no Mercado Interno 52 -
						 * Operação com Direito a Crédito - Vinculada
						 * Exclusivamente a Receita de Exportação 53 - Operação
						 * com Direito a Crédito - Vinculada a Receitas
						 * Tributadas e Não-Tributadas no Mercado Interno 54 -
						 * Operação com Direito a Crédito - Vinculada a Receitas
						 * Tributadas no Mercado Interno e de Exportação 55 -
						 * Operação com Direito a Crédito - Vinculada a Receitas
						 * Não-Tributadas no Mercado Interno e de Exportação 56
						 * - Operação com Direito a Crédito - Vinculada a
						 * Receitas Tributadas e Não-Tributadas no Mercado
						 * Interno, e de Exportação 60 - Crédito Presumido -
						 * Operação de Aquisição Vinculada Exclusivamente a
						 * Receita Tributada no Mercado Interno 61 - Crédito
						 * Presumido - Operação de Aquisição Vinculada
						 * Exclusivamente a Receita Não-Tributada no Mercado
						 * Interno 62 - Crédito Presumido - Operação de
						 * Aquisição Vinculada Exclusivamente a Receita de
						 * Exportação 63 - Crédito Presumido - Operação de
						 * Aquisição Vinculada a Receitas Tributadas e
						 * Não-Tributadas no Mercado Interno 64 - Crédito
						 * Presumido - Operação de Aquisição Vinculada a
						 * Receitas Tributadas no Mercado Interno e de
						 * Exportação 65 - Crédito Presumido - Operação de
						 * Aquisição Vinculada a Receitas Não-Tributadas no
						 * Mercado Interno e de Exportação 66 - Crédito
						 * Presumido - Operação de Aquisição Vinculada a
						 * Receitas Tributadas e Não-Tributadas no Mercado
						 * Interno, e de Exportação 67 - Crédito Presumido -
						 * Outras Operações 70 - Operação de Aquisição sem
						 * Direito a Crédito 71 - Operação de Aquisição com
						 * Isenção 72 - Operação de Aquisição com Suspensão 73 -
						 * Operação de Aquisição a Alíquota Zero 74 - Operação
						 * de Aquisição sem Incidência da Contribuição 75 -
						 * Operação de Aquisição por Substituição Tributária 98
						 * - Outras Operações de Entrada 99 - Outras Operações.
						 */
						@Validation(whiteSpace = "preserve", enumerations = {
								"49", "50", "51", "52", "53", "54", "55", "56",
								"60", "61", "62", "63", "64", "65", "66", "67",
								"70", "71", "72", "73", "74", "75", "98", "99"}, text = "C\u00F3digo de Situa\u00E7\u00E3o Tribut\u00E1ria do COFINS:\n49 - Outras Opera\u00E7\u00F5es de Sa\u00EDda\n50 - Opera\u00E7\u00E3o com Direito a Cr\u00E9dito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno\n51 - Opera\u00E7\u00E3o com Direito a Cr\u00E9dito \u2013 Vinculada Exclusivamente a Receita N\u00E3o Tributada no Mercado Interno\n52 - Opera\u00E7\u00E3o com Direito a Cr\u00E9dito - Vinculada Exclusivamente a Receita de Exporta\u00E7\u00E3o\n53 - Opera\u00E7\u00E3o com Direito a Cr\u00E9dito - Vinculada a Receitas Tributadas e N\u00E3o-Tributadas no Mercado Interno\n54 - Opera\u00E7\u00E3o com Direito a Cr\u00E9dito - Vinculada a Receitas Tributadas no Mercado Interno e de Exporta\u00E7\u00E3o\n55 - Opera\u00E7\u00E3o com Direito a Cr\u00E9dito - Vinculada a Receitas N\u00E3o-Tributadas no Mercado Interno e de Exporta\u00E7\u00E3o\n56 - Opera\u00E7\u00E3o com Direito a Cr\u00E9dito - Vinculada a Receitas Tributadas e N\u00E3o-Tributadas no Mercado Interno, e de Exporta\u00E7\u00E3o\n60 - Cr\u00E9dito Presumido - Opera\u00E7\u00E3o de Aquisi\u00E7\u00E3o Vinculada Exclusivamente a Receita Tributada no Mercado Interno\n61 - Cr\u00E9dito Presumido - Opera\u00E7\u00E3o de Aquisi\u00E7\u00E3o Vinculada Exclusivamente a Receita N\u00E3o-Tributada no Mercado Interno\n62 - Cr\u00E9dito Presumido - Opera\u00E7\u00E3o de Aquisi\u00E7\u00E3o Vinculada Exclusivamente a Receita de Exporta\u00E7\u00E3o\n63 - Cr\u00E9dito Presumido - Opera\u00E7\u00E3o de Aquisi\u00E7\u00E3o Vinculada a Receitas Tributadas e N\u00E3o-Tributadas no Mercado Interno\n64 - Cr\u00E9dito Presumido - Opera\u00E7\u00E3o de Aquisi\u00E7\u00E3o Vinculada a Receitas Tributadas no Mercado Interno e de Exporta\u00E7\u00E3o\n65 - Cr\u00E9dito Presumido - Opera\u00E7\u00E3o de Aquisi\u00E7\u00E3o Vinculada a Receitas N\u00E3o-Tributadas no Mercado Interno e de Exporta\u00E7\u00E3o\n66 - Cr\u00E9dito Presumido - Opera\u00E7\u00E3o de Aquisi\u00E7\u00E3o Vinculada a Receitas Tributadas e N\u00E3o-Tributadas no Mercado Interno, e de Exporta\u00E7\u00E3o\n67 - Cr\u00E9dito Presumido - Outras Opera\u00E7\u00F5es\n70 - Opera\u00E7\u00E3o de Aquisi\u00E7\u00E3o sem Direito a Cr\u00E9dito\n71 - Opera\u00E7\u00E3o de Aquisi\u00E7\u00E3o com Isen\u00E7\u00E3o\n72 - Opera\u00E7\u00E3o de Aquisi\u00E7\u00E3o com Suspens\u00E3o\n73 - Opera\u00E7\u00E3o de Aquisi\u00E7\u00E3o a Al\u00EDquota Zero\n74 - Opera\u00E7\u00E3o de Aquisi\u00E7\u00E3o sem Incid\u00EAncia da Contribui\u00E7\u00E3o\n75 - Opera\u00E7\u00E3o de Aquisi\u00E7\u00E3o por Substitui\u00E7\u00E3o Tribut\u00E1ria\n98 - Outras Opera\u00E7\u00F5es de Entrada\n99 - Outras Opera\u00E7\u00F5es.", required = true, minOccurs = "1")
						@Element(name = "CST")
						private String CST;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
						@Element(name = "vBC")
						private String vBC;
						/**
						 * Tipo Decimal com até 3 dígitos inteiros, podendo ter
						 * de 2 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = false, minOccurs = "1")
						@Element(name = "pCOFINS")
						private String pCOFINS;
						/**
						 * Tipo Decimal com 12 inteiros de 1 até 4 decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,4}|[1-9]{1}[0-9]{0,11}|[1-9]{1}[0-9]{0,11}(\\.[0-9]{1,4})?", text = "Tipo Decimal com 12 inteiros de 1 at\u00E9 4 decimais", required = false, minOccurs = "1")
						@Element(name = "qBCProd")
						private String qBCProd;
						/**
						 * Tipo Decimal com 11 inteiros, podendo ter de 1 até 4
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,4}|[1-9]{1}[0-9]{0,10}|[1-9]{1}[0-9]{0,10}(\\.[0-9]{1,4})?", text = "Tipo Decimal com 11 inteiros, podendo ter de 1 at\u00E9 4 decimais", required = false, minOccurs = "1")
						@Element(name = "vAliqProd")
						private String vAliqProd;
						/**
						 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
						 * decimais
						 */
						@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
						@Element(name = "vCOFINS")
						private String vCOFINS;

						public String getCST() {
							return this.CST;
						}

						public void setCST(String CST) {
							this.CST = CST;
						}

						public String getVBC() {
							return this.vBC;
						}

						public void setVBC(String vBC) {
							this.vBC = vBC;
						}

						public String getPCOFINS() {
							return this.pCOFINS;
						}

						public void setPCOFINS(String pCOFINS) {
							this.pCOFINS = pCOFINS;
						}

						public String getQBCProd() {
							return this.qBCProd;
						}

						public void setQBCProd(String qBCProd) {
							this.qBCProd = qBCProd;
						}

						public String getVAliqProd() {
							return this.vAliqProd;
						}

						public void setVAliqProd(String vAliqProd) {
							this.vAliqProd = vAliqProd;
						}

						public String getVCOFINS() {
							return this.vCOFINS;
						}

						public void setVCOFINS(String vCOFINS) {
							this.vCOFINS = vCOFINS;
						}
					}

					public COFINSOutr getCOFINSOutr() {
						return this.COFINSOutr;
					}

					public void setCOFINSOutr(COFINSOutr COFINSOutr) {
						this.COFINSOutr = COFINSOutr;
					}
				}

				public COFINS getCOFINS() {
					return this.COFINS;
				}

				public void setCOFINS(COFINS COFINS) {
					this.COFINS = COFINS;
				}

				@Validation(choices = "[{\"items\":[\"vBC\",\"pCOFINS\"]},{\"items\":[\"qBCProd\",\"vAliqProd\"]}]")
				@WXml
				@Order(elements = {"vBC", "pCOFINS", "qBCProd", "vAliqProd",
						"vCOFINS"})
				@Element(name = "COFINSST")
				public static class COFINSST {
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
					@Element(name = "vBC")
					private String vBC;
					/**
					 * Tipo Decimal com até 3 dígitos inteiros, podendo ter de 2
					 * até 4 decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = false, minOccurs = "1")
					@Element(name = "pCOFINS")
					private String pCOFINS;
					/**
					 * Tipo Decimal com 12 inteiros e 4 decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,4}|[1-9]{1}[0-9]{0,11}|[1-9]{1}[0-9]{0,11}(\\.[0-9]{4})?", text = "Tipo Decimal com 12 inteiros e 4 decimais", required = false, minOccurs = "1")
					@Element(name = "qBCProd")
					private String qBCProd;
					/**
					 * Tipo Decimal com 11 inteiros, podendo ter 4 decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{4}|[1-9]{1}[0-9]{0,10}(\\.[0-9]{4})?", text = "Tipo Decimal com 11 inteiros, podendo ter 4 decimais", required = false, minOccurs = "1")
					@Element(name = "vAliqProd")
					private String vAliqProd;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
					@Element(name = "vCOFINS")
					private String vCOFINS;

					public String getVBC() {
						return this.vBC;
					}

					public void setVBC(String vBC) {
						this.vBC = vBC;
					}

					public String getPCOFINS() {
						return this.pCOFINS;
					}

					public void setPCOFINS(String pCOFINS) {
						this.pCOFINS = pCOFINS;
					}

					public String getQBCProd() {
						return this.qBCProd;
					}

					public void setQBCProd(String qBCProd) {
						this.qBCProd = qBCProd;
					}

					public String getVAliqProd() {
						return this.vAliqProd;
					}

					public void setVAliqProd(String vAliqProd) {
						this.vAliqProd = vAliqProd;
					}

					public String getVCOFINS() {
						return this.vCOFINS;
					}

					public void setVCOFINS(String vCOFINS) {
						this.vCOFINS = vCOFINS;
					}
				}

				public COFINSST getCOFINSST() {
					return this.COFINSST;
				}

				public void setCOFINSST(COFINSST COFINSST) {
					this.COFINSST = COFINSST;
				}

				@WXml
				@Order(elements = {"vBCUFDest", "vBCFCPUFDest", "pFCPUFDest",
						"pICMSUFDest", "pICMSInter", "pICMSInterPart",
						"vFCPUFDest", "vICMSUFDest", "vICMSUFRemet"})
				@Element(name = "ICMSUFDest")
				public static class ICMSUFDest {
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
					@Element(name = "vBCUFDest")
					private String vBCUFDest;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "0")
					@Element(name = "vBCFCPUFDest")
					private String vBCFCPUFDest;
					/**
					 * Tipo Decimal com até 3 dígitos inteiros, podendo ter de 2
					 * até 4 decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = false, minOccurs = "0")
					@Element(name = "pFCPUFDest")
					private String pFCPUFDest;
					/**
					 * Tipo Decimal com até 3 dígitos inteiros, podendo ter de 2
					 * até 4 decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
					@Element(name = "pICMSUFDest")
					private String pICMSUFDest;
					/**
					 * Alíquota interestadual das UF envolvidas: - 4% alíquota
					 * interestadual para produtos importados; - 7% para os
					 * Estados de origem do Sul e Sudeste (exceto ES), destinado
					 * para os Estados do Norte e Nordeste ou ES; - 12% para os
					 * demais casos.
					 */
					@Validation(whiteSpace = "preserve", enumerations = {
							"4.00", "7.00", "12.00"}, text = "Al\u00EDquota interestadual das UF envolvidas: - 4% al\u00EDquota interestadual para produtos importados; - 7% para os Estados de origem do Sul e Sudeste (exceto ES), destinado para os Estados do Norte e Nordeste  ou ES; - 12% para os demais casos.", required = true, minOccurs = "1")
					@Element(name = "pICMSInter")
					private String pICMSInter;
					/**
					 * Tipo Decimal com até 3 dígitos inteiros, podendo ter de 2
					 * até 4 decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
					@Element(name = "pICMSInterPart")
					private String pICMSInterPart;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "0")
					@Element(name = "vFCPUFDest")
					private String vFCPUFDest;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
					@Element(name = "vICMSUFDest")
					private String vICMSUFDest;
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
					@Element(name = "vICMSUFRemet")
					private String vICMSUFRemet;

					public String getVBCUFDest() {
						return this.vBCUFDest;
					}

					public void setVBCUFDest(String vBCUFDest) {
						this.vBCUFDest = vBCUFDest;
					}

					public String getVBCFCPUFDest() {
						return this.vBCFCPUFDest;
					}

					public void setVBCFCPUFDest(String vBCFCPUFDest) {
						this.vBCFCPUFDest = vBCFCPUFDest;
					}

					public String getPFCPUFDest() {
						return this.pFCPUFDest;
					}

					public void setPFCPUFDest(String pFCPUFDest) {
						this.pFCPUFDest = pFCPUFDest;
					}

					public String getPICMSUFDest() {
						return this.pICMSUFDest;
					}

					public void setPICMSUFDest(String pICMSUFDest) {
						this.pICMSUFDest = pICMSUFDest;
					}

					public String getPICMSInter() {
						return this.pICMSInter;
					}

					public void setPICMSInter(String pICMSInter) {
						this.pICMSInter = pICMSInter;
					}

					public String getPICMSInterPart() {
						return this.pICMSInterPart;
					}

					public void setPICMSInterPart(String pICMSInterPart) {
						this.pICMSInterPart = pICMSInterPart;
					}

					public String getVFCPUFDest() {
						return this.vFCPUFDest;
					}

					public void setVFCPUFDest(String vFCPUFDest) {
						this.vFCPUFDest = vFCPUFDest;
					}

					public String getVICMSUFDest() {
						return this.vICMSUFDest;
					}

					public void setVICMSUFDest(String vICMSUFDest) {
						this.vICMSUFDest = vICMSUFDest;
					}

					public String getVICMSUFRemet() {
						return this.vICMSUFRemet;
					}

					public void setVICMSUFRemet(String vICMSUFRemet) {
						this.vICMSUFRemet = vICMSUFRemet;
					}
				}

				public ICMSUFDest getICMSUFDest() {
					return this.ICMSUFDest;
				}

				public void setICMSUFDest(ICMSUFDest ICMSUFDest) {
					this.ICMSUFDest = ICMSUFDest;
				}
			}

			public Imposto getImposto() {
				return this.imposto;
			}

			public void setImposto(Imposto imposto) {
				this.imposto = imposto;
			}

			@WXml
			@Order(elements = {"pDevol", "IPI"})
			@Element(name = "impostoDevol")
			public static class ImpostoDevol {
				/**
				 * Tipo Decimal com 3 inteiros (no máximo 100), com 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0(\\.[0-9]{2})?|100(\\.00)?|[1-9]{1}[0-9]{0,1}(\\.[0-9]{2})?", text = "Tipo Decimal com 3 inteiros (no m\u00E1ximo 100), com 2 decimais", required = true, minOccurs = "1")
				@Element(name = "pDevol")
				private String pDevol;
				/**
				 * Informação de IPI devolvido
				 */
				@Element(name = "IPI")
				@Validation(required = true, minOccurs = "1")
				private IPI IPI;

				public String getPDevol() {
					return this.pDevol;
				}

				public void setPDevol(String pDevol) {
					this.pDevol = pDevol;
				}

				@WXml
				@Order(elements = "vIPIDevol")
				@Element(name = "IPI")
				public static class IPI {
					/**
					 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2
					 * decimais
					 */
					@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
					@Element(name = "vIPIDevol")
					private String vIPIDevol;

					public String getVIPIDevol() {
						return this.vIPIDevol;
					}

					public void setVIPIDevol(String vIPIDevol) {
						this.vIPIDevol = vIPIDevol;
					}
				}

				public IPI getIPI() {
					return this.IPI;
				}

				public void setIPI(IPI IPI) {
					this.IPI = IPI;
				}
			}

			public ImpostoDevol getImpostoDevol() {
				return this.impostoDevol;
			}

			public void setImpostoDevol(ImpostoDevol impostoDevol) {
				this.impostoDevol = impostoDevol;
			}

			public String getInfAdProd() {
				return this.infAdProd;
			}

			public void setInfAdProd(String infAdProd) {
				this.infAdProd = infAdProd;
			}

			public String getNItem() {
				return this.nItem;
			}

			public void setNItem(String nItem) {
				this.nItem = nItem;
			}
		}

		public List<Det> getDet() {
			return this.det;
		}

		public void setDet(java.util.List<Det> det) {
			this.det = det;
		}

		@WXml
		@Order(elements = {"ICMSTot", "ISSQNtot", "retTrib"})
		@Element(name = "total")
		public static class Total {
			/**
			 * Totais referentes ao ICMS
			 */
			@Element(name = "ICMSTot")
			@Validation(required = true, minOccurs = "1")
			private ICMSTot ICMSTot;
			/**
			 * Totais referentes ao ISSQN
			 */
			@Element(name = "ISSQNtot")
			@Validation(required = false, minOccurs = "0")
			private ISSQNtot ISSQNtot;
			/**
			 * Retenção de Tributos Federais
			 */
			@Element(name = "retTrib")
			@Validation(required = false, minOccurs = "0")
			private RetTrib retTrib;

			@WXml
			@Order(elements = {"vBC", "vICMS", "vICMSDeson", "vFCPUFDest",
					"vICMSUFDest", "vICMSUFRemet", "vFCP", "vBCST", "vST",
					"vFCPST", "vFCPSTRet", "vProd", "vFrete", "vSeg", "vDesc",
					"vII", "vIPI", "vIPIDevol", "vPIS", "vCOFINS", "vOutro",
					"vNF", "vTotTrib"})
			@Element(name = "ICMSTot")
			public static class ICMSTot {
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vBC")
				private String vBC;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vICMS")
				private String vICMS;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vICMSDeson")
				private String vICMSDeson;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "0")
				@Element(name = "vFCPUFDest")
				private String vFCPUFDest;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "0")
				@Element(name = "vICMSUFDest")
				private String vICMSUFDest;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "0")
				@Element(name = "vICMSUFRemet")
				private String vICMSUFRemet;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vFCP")
				private String vFCP;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vBCST")
				private String vBCST;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vST")
				private String vST;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vFCPST")
				private String vFCPST;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vFCPSTRet")
				private String vFCPSTRet;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vProd")
				private String vProd;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vFrete")
				private String vFrete;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vSeg")
				private String vSeg;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vDesc")
				private String vDesc;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vII")
				private String vII;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vIPI")
				private String vIPI;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vIPIDevol")
				private String vIPIDevol;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vPIS")
				private String vPIS;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vCOFINS")
				private String vCOFINS;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vOutro")
				private String vOutro;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vNF")
				private String vNF;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "0")
				@Element(name = "vTotTrib")
				private String vTotTrib;

				public String getVBC() {
					return this.vBC;
				}

				public void setVBC(String vBC) {
					this.vBC = vBC;
				}

				public String getVICMS() {
					return this.vICMS;
				}

				public void setVICMS(String vICMS) {
					this.vICMS = vICMS;
				}

				public String getVICMSDeson() {
					return this.vICMSDeson;
				}

				public void setVICMSDeson(String vICMSDeson) {
					this.vICMSDeson = vICMSDeson;
				}

				public String getVFCPUFDest() {
					return this.vFCPUFDest;
				}

				public void setVFCPUFDest(String vFCPUFDest) {
					this.vFCPUFDest = vFCPUFDest;
				}

				public String getVICMSUFDest() {
					return this.vICMSUFDest;
				}

				public void setVICMSUFDest(String vICMSUFDest) {
					this.vICMSUFDest = vICMSUFDest;
				}

				public String getVICMSUFRemet() {
					return this.vICMSUFRemet;
				}

				public void setVICMSUFRemet(String vICMSUFRemet) {
					this.vICMSUFRemet = vICMSUFRemet;
				}

				public String getVFCP() {
					return this.vFCP;
				}

				public void setVFCP(String vFCP) {
					this.vFCP = vFCP;
				}

				public String getVBCST() {
					return this.vBCST;
				}

				public void setVBCST(String vBCST) {
					this.vBCST = vBCST;
				}

				public String getVST() {
					return this.vST;
				}

				public void setVST(String vST) {
					this.vST = vST;
				}

				public String getVFCPST() {
					return this.vFCPST;
				}

				public void setVFCPST(String vFCPST) {
					this.vFCPST = vFCPST;
				}

				public String getVFCPSTRet() {
					return this.vFCPSTRet;
				}

				public void setVFCPSTRet(String vFCPSTRet) {
					this.vFCPSTRet = vFCPSTRet;
				}

				public String getVProd() {
					return this.vProd;
				}

				public void setVProd(String vProd) {
					this.vProd = vProd;
				}

				public String getVFrete() {
					return this.vFrete;
				}

				public void setVFrete(String vFrete) {
					this.vFrete = vFrete;
				}

				public String getVSeg() {
					return this.vSeg;
				}

				public void setVSeg(String vSeg) {
					this.vSeg = vSeg;
				}

				public String getVDesc() {
					return this.vDesc;
				}

				public void setVDesc(String vDesc) {
					this.vDesc = vDesc;
				}

				public String getVII() {
					return this.vII;
				}

				public void setVII(String vII) {
					this.vII = vII;
				}

				public String getVIPI() {
					return this.vIPI;
				}

				public void setVIPI(String vIPI) {
					this.vIPI = vIPI;
				}

				public String getVIPIDevol() {
					return this.vIPIDevol;
				}

				public void setVIPIDevol(String vIPIDevol) {
					this.vIPIDevol = vIPIDevol;
				}

				public String getVPIS() {
					return this.vPIS;
				}

				public void setVPIS(String vPIS) {
					this.vPIS = vPIS;
				}

				public String getVCOFINS() {
					return this.vCOFINS;
				}

				public void setVCOFINS(String vCOFINS) {
					this.vCOFINS = vCOFINS;
				}

				public String getVOutro() {
					return this.vOutro;
				}

				public void setVOutro(String vOutro) {
					this.vOutro = vOutro;
				}

				public String getVNF() {
					return this.vNF;
				}

				public void setVNF(String vNF) {
					this.vNF = vNF;
				}

				public String getVTotTrib() {
					return this.vTotTrib;
				}

				public void setVTotTrib(String vTotTrib) {
					this.vTotTrib = vTotTrib;
				}
			}

			public ICMSTot getICMSTot() {
				return this.ICMSTot;
			}

			public void setICMSTot(ICMSTot ICMSTot) {
				this.ICMSTot = ICMSTot;
			}

			@WXml
			@Order(elements = {"vServ", "vBC", "vISS", "vPIS", "vCOFINS",
					"dCompet", "vDeducao", "vOutro", "vDescIncond",
					"vDescCond", "vISSRet", "cRegTrib"})
			@Element(name = "ISSQNtot")
			public static class ISSQNtot {
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vServ")
				private String vServ;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vBC")
				private String vBC;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vISS")
				private String vISS;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vPIS")
				private String vPIS;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vCOFINS")
				private String vCOFINS;
				/**
				 * Tipo data AAAA-MM-DD
				 */
				@Validation(whiteSpace = "preserve", pattern = "(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))", text = "Tipo data AAAA-MM-DD", required = true, minOccurs = "1")
				@Element(name = "dCompet")
				private String dCompet;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vDeducao")
				private String vDeducao;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vOutro")
				private String vOutro;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vDescIncond")
				private String vDescIncond;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vDescCond")
				private String vDescCond;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vISSRet")
				private String vISSRet;
				/**
				 * Código do regime especial de tributação
				 */
				@Validation(whiteSpace = "preserve", enumerations = {"1", "2",
						"3", "4", "5", "6"}, text = "C\u00F3digo do regime especial de tributa\u00E7\u00E3o", required = false, minOccurs = "0")
				@Element(name = "cRegTrib")
				private String cRegTrib;

				public String getVServ() {
					return this.vServ;
				}

				public void setVServ(String vServ) {
					this.vServ = vServ;
				}

				public String getVBC() {
					return this.vBC;
				}

				public void setVBC(String vBC) {
					this.vBC = vBC;
				}

				public String getVISS() {
					return this.vISS;
				}

				public void setVISS(String vISS) {
					this.vISS = vISS;
				}

				public String getVPIS() {
					return this.vPIS;
				}

				public void setVPIS(String vPIS) {
					this.vPIS = vPIS;
				}

				public String getVCOFINS() {
					return this.vCOFINS;
				}

				public void setVCOFINS(String vCOFINS) {
					this.vCOFINS = vCOFINS;
				}

				public String getDCompet() {
					return this.dCompet;
				}

				public void setDCompet(String dCompet) {
					this.dCompet = dCompet;
				}

				public String getVDeducao() {
					return this.vDeducao;
				}

				public void setVDeducao(String vDeducao) {
					this.vDeducao = vDeducao;
				}

				public String getVOutro() {
					return this.vOutro;
				}

				public void setVOutro(String vOutro) {
					this.vOutro = vOutro;
				}

				public String getVDescIncond() {
					return this.vDescIncond;
				}

				public void setVDescIncond(String vDescIncond) {
					this.vDescIncond = vDescIncond;
				}

				public String getVDescCond() {
					return this.vDescCond;
				}

				public void setVDescCond(String vDescCond) {
					this.vDescCond = vDescCond;
				}

				public String getVISSRet() {
					return this.vISSRet;
				}

				public void setVISSRet(String vISSRet) {
					this.vISSRet = vISSRet;
				}

				public String getCRegTrib() {
					return this.cRegTrib;
				}

				public void setCRegTrib(String cRegTrib) {
					this.cRegTrib = cRegTrib;
				}
			}

			public ISSQNtot getISSQNtot() {
				return this.ISSQNtot;
			}

			public void setISSQNtot(ISSQNtot ISSQNtot) {
				this.ISSQNtot = ISSQNtot;
			}

			@WXml
			@Order(elements = {"vRetPIS", "vRetCOFINS", "vRetCSLL", "vBCIRRF",
					"vIRRF", "vBCRetPrev", "vRetPrev"})
			@Element(name = "retTrib")
			public static class RetTrib {
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vRetPIS")
				private String vRetPIS;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vRetCOFINS")
				private String vRetCOFINS;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vRetCSLL")
				private String vRetCSLL;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vBCIRRF")
				private String vBCIRRF;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vIRRF")
				private String vIRRF;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vBCRetPrev")
				private String vBCRetPrev;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vRetPrev")
				private String vRetPrev;

				public String getVRetPIS() {
					return this.vRetPIS;
				}

				public void setVRetPIS(String vRetPIS) {
					this.vRetPIS = vRetPIS;
				}

				public String getVRetCOFINS() {
					return this.vRetCOFINS;
				}

				public void setVRetCOFINS(String vRetCOFINS) {
					this.vRetCOFINS = vRetCOFINS;
				}

				public String getVRetCSLL() {
					return this.vRetCSLL;
				}

				public void setVRetCSLL(String vRetCSLL) {
					this.vRetCSLL = vRetCSLL;
				}

				public String getVBCIRRF() {
					return this.vBCIRRF;
				}

				public void setVBCIRRF(String vBCIRRF) {
					this.vBCIRRF = vBCIRRF;
				}

				public String getVIRRF() {
					return this.vIRRF;
				}

				public void setVIRRF(String vIRRF) {
					this.vIRRF = vIRRF;
				}

				public String getVBCRetPrev() {
					return this.vBCRetPrev;
				}

				public void setVBCRetPrev(String vBCRetPrev) {
					this.vBCRetPrev = vBCRetPrev;
				}

				public String getVRetPrev() {
					return this.vRetPrev;
				}

				public void setVRetPrev(String vRetPrev) {
					this.vRetPrev = vRetPrev;
				}
			}

			public RetTrib getRetTrib() {
				return this.retTrib;
			}

			public void setRetTrib(RetTrib retTrib) {
				this.retTrib = retTrib;
			}
		}

		public Total getTotal() {
			return this.total;
		}

		public void setTotal(Total total) {
			this.total = total;
		}

		@Validation(choices = "[{\"items\":[\"veicTransp\",\"reboque\"]},{\"items\":[\"vagao\"]},{\"items\":[\"balsa\"]}]")
		@WXml
		@Order(elements = {"modFrete", "transporta", "retTransp", "veicTransp",
				"reboque", "vagao", "balsa", "vol"})
		@Element(name = "transp")
		public static class Transp {
			/**
			 * Modalidade do frete 0- Contratação do Frete por conta do
			 * Remetente (CIF); 1- Contratação do Frete por conta do
			 * destinatário/remetente (FOB); 2- Contratação do Frete por conta
			 * de terceiros; 3- Transporte próprio por conta do remetente; 4-
			 * Transporte próprio por conta do destinatário; 9- Sem Ocorrência
			 * de transporte.
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"0", "1", "2",
					"3", "4", "9"}, text = "Modalidade do frete\n0- Contrata\u00E7\u00E3o do Frete por conta do Remetente (CIF);\n1- Contrata\u00E7\u00E3o do Frete por conta do destinat\u00E1rio/remetente (FOB);\n2- Contrata\u00E7\u00E3o do Frete por conta de terceiros;\n3- Transporte pr\u00F3prio por conta do remetente;\n4- Transporte pr\u00F3prio por conta do destinat\u00E1rio;\n9- Sem Ocorr\u00EAncia de transporte.", required = true, minOccurs = "1")
			@Element(name = "modFrete")
			private String modFrete;
			/**
			 * Dados do transportador
			 */
			@Element(name = "transporta")
			@Validation(required = false, minOccurs = "0")
			private Transporta transporta;
			/**
			 * Dados da retenção ICMS do Transporte
			 */
			@Element(name = "retTransp")
			@Validation(required = false, minOccurs = "0")
			private RetTransp retTransp;
			/**
			 * Dados do veículo
			 */
			@Element(name = "veicTransp")
			@Validation(required = false, minOccurs = "0")
			private TVeiculo veicTransp;
			/**
			 * Dados do reboque/Dolly (v2.0)
			 */
			@ElementList(name = "reboque", inline = true)
			@Validation(required = false, minOccurs = "0")
			private List<TVeiculo> reboque = new ArrayList();
			/**
			 * Identificação do vagão (v2.0)
			 */
			@Validation(minLength = "1", maxLength = "20", text = "Identifica\u00E7\u00E3o do vag\u00E3o (v2.0)", required = false, minOccurs = "0")
			@Element(name = "vagao")
			private String vagao;
			/**
			 * Identificação da balsa (v2.0)
			 */
			@Validation(minLength = "1", maxLength = "20", text = "Identifica\u00E7\u00E3o da balsa (v2.0)", required = false, minOccurs = "0")
			@Element(name = "balsa")
			private String balsa;
			/**
			 * Dados dos volumes
			 */
			@ElementList(name = "vol", inline = true)
			@Validation(required = false, minOccurs = "0")
			private List<Vol> vol = new ArrayList();

			public String getModFrete() {
				return this.modFrete;
			}

			public void setModFrete(String modFrete) {
				this.modFrete = modFrete;
			}

			@Validation(choices = "[{\"minOccurs\":0,\"items\":[\"CNPJ\"]},{\"minOccurs\":0,\"items\":[\"CPF\"]}]")
			@WXml
			@Order(elements = {"CNPJ", "CPF", "xNome", "IE", "xEnder", "xMun",
					"UF"})
			@Element(name = "transporta")
			public static class Transporta {
				/**
				 * Tipo Número do CNPJ
				 */
				@Validation(whiteSpace = "preserve", maxLength = "14", pattern = "[0-9]{14}", text = "Tipo N\u00FAmero do CNPJ", required = false, minOccurs = "1")
				@Element(name = "CNPJ")
				private String CNPJ;
				/**
				 * Tipo Número do CPF
				 */
				@Validation(whiteSpace = "preserve", maxLength = "11", pattern = "[0-9]{11}", text = "Tipo N\u00FAmero do CPF", required = false, minOccurs = "1")
				@Element(name = "CPF")
				private String CPF;
				/**
				 * Razão Social ou nome do transportador
				 */
				@Validation(maxLength = "60", minLength = "2", text = "Raz\u00E3o Social ou nome do transportador", required = false, minOccurs = "0")
				@Element(name = "xNome")
				private String xNome;
				/**
				 * Tipo Inscrição Estadual do Destinatário // alterado para
				 * aceitar vazio ou ISENTO - maio/2010 v2.0
				 */
				@Validation(whiteSpace = "preserve", maxLength = "14", pattern = "ISENTO|[0-9]{2,14}", text = "Tipo Inscri\u00E7\u00E3o Estadual do Destinat\u00E1rio // alterado para aceitar vazio ou ISENTO - maio/2010 v2.0", required = false, minOccurs = "0")
				@Element(name = "IE")
				private String IE;
				/**
				 * Endereço completo
				 */
				@Validation(minLength = "1", maxLength = "60", text = "Endere\u00E7o completo", required = false, minOccurs = "0")
				@Element(name = "xEnder")
				private String xEnder;
				/**
				 * Nome do munícipio
				 */
				@Validation(maxLength = "60", minLength = "1", text = "Nome do mun\u00EDcipio", required = false, minOccurs = "0")
				@Element(name = "xMun")
				private String xMun;
				/**
				 * Tipo Sigla da UF
				 */
				@Validation(whiteSpace = "preserve", enumerations = {"AC",
						"AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA",
						"MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ",
						"RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO", "EX"}, text = "Tipo Sigla da UF", required = false, minOccurs = "0")
				@Element(name = "UF")
				private String UF;

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

				public String getXNome() {
					return this.xNome;
				}

				public void setXNome(String xNome) {
					this.xNome = xNome;
				}

				public String getIE() {
					return this.IE;
				}

				public void setIE(String IE) {
					this.IE = IE;
				}

				public String getXEnder() {
					return this.xEnder;
				}

				public void setXEnder(String xEnder) {
					this.xEnder = xEnder;
				}

				public String getXMun() {
					return this.xMun;
				}

				public void setXMun(String xMun) {
					this.xMun = xMun;
				}

				public String getUF() {
					return this.UF;
				}

				public void setUF(String UF) {
					this.UF = UF;
				}
			}

			public Transporta getTransporta() {
				return this.transporta;
			}

			public void setTransporta(Transporta transporta) {
				this.transporta = transporta;
			}

			@WXml
			@Order(elements = {"vServ", "vBCRet", "pICMSRet", "vICMSRet",
					"CFOP", "cMunFG"})
			@Element(name = "retTransp")
			public static class RetTransp {
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vServ")
				private String vServ;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vBCRet")
				private String vBCRet;
				/**
				 * Tipo Decimal com até 3 dígitos inteiros, podendo ter de 2 até
				 * 4 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = true, minOccurs = "1")
				@Element(name = "pICMSRet")
				private String pICMSRet;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vICMSRet")
				private String vICMSRet;
				/**
				 * Código Fiscal de Operações e Prestações
				 */
				@Validation(whiteSpace = "preserve", pattern = "[1,2,3,5,6,7]{1}[0-9]{3}", text = "C\u00F3digo Fiscal de Opera\u00E7\u00F5es e Presta\u00E7\u00F5es", required = true, minOccurs = "1")
				@Element(name = "CFOP")
				private String CFOP;
				/**
				 * Tipo Código do Município da tabela do IBGE
				 */
				@Validation(whiteSpace = "preserve", pattern = "[0-9]{7}", text = "Tipo C\u00F3digo do Munic\u00EDpio da tabela do IBGE", required = true, minOccurs = "1")
				@Element(name = "cMunFG")
				private String cMunFG;

				public String getVServ() {
					return this.vServ;
				}

				public void setVServ(String vServ) {
					this.vServ = vServ;
				}

				public String getVBCRet() {
					return this.vBCRet;
				}

				public void setVBCRet(String vBCRet) {
					this.vBCRet = vBCRet;
				}

				public String getPICMSRet() {
					return this.pICMSRet;
				}

				public void setPICMSRet(String pICMSRet) {
					this.pICMSRet = pICMSRet;
				}

				public String getVICMSRet() {
					return this.vICMSRet;
				}

				public void setVICMSRet(String vICMSRet) {
					this.vICMSRet = vICMSRet;
				}

				public String getCFOP() {
					return this.CFOP;
				}

				public void setCFOP(String CFOP) {
					this.CFOP = CFOP;
				}

				public String getCMunFG() {
					return this.cMunFG;
				}

				public void setCMunFG(String cMunFG) {
					this.cMunFG = cMunFG;
				}
			}

			public RetTransp getRetTransp() {
				return this.retTransp;
			}

			public void setRetTransp(RetTransp retTransp) {
				this.retTransp = retTransp;
			}

			public TVeiculo getVeicTransp() {
				return this.veicTransp;
			}

			public void setVeicTransp(TVeiculo veicTransp) {
				this.veicTransp = veicTransp;
			}

			public List<TVeiculo> getReboque() {
				return this.reboque;
			}

			public void setReboque(java.util.List<TVeiculo> reboque) {
				this.reboque = reboque;
			}

			public String getVagao() {
				return this.vagao;
			}

			public void setVagao(String vagao) {
				this.vagao = vagao;
			}

			public String getBalsa() {
				return this.balsa;
			}

			public void setBalsa(String balsa) {
				this.balsa = balsa;
			}

			@WXml
			@Order(elements = {"qVol", "esp", "marca", "nVol", "pesoL",
					"pesoB", "lacres"})
			@Element(name = "vol")
			public static class Vol {
				/**
				 * Quantidade de volumes transportados
				 */
				@Validation(whiteSpace = "preserve", pattern = "[0-9]{1,15}", text = "Quantidade de volumes transportados", required = false, minOccurs = "0")
				@Element(name = "qVol")
				private String qVol;
				/**
				 * Espécie dos volumes transportados
				 */
				@Validation(minLength = "1", maxLength = "60", text = "Esp\u00E9cie dos volumes transportados", required = false, minOccurs = "0")
				@Element(name = "esp")
				private String esp;
				/**
				 * Marca dos volumes transportados
				 */
				@Validation(minLength = "1", maxLength = "60", text = "Marca dos volumes transportados", required = false, minOccurs = "0")
				@Element(name = "marca")
				private String marca;
				/**
				 * Numeração dos volumes transportados
				 */
				@Validation(minLength = "1", maxLength = "60", text = "Numera\u00E7\u00E3o dos volumes transportados", required = false, minOccurs = "0")
				@Element(name = "nVol")
				private String nVol;
				/**
				 * Tipo Decimal com 12 inteiros, podendo ter 3 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{3}|[1-9]{1}[0-9]{0,11}(\\.[0-9]{3})?", text = "Tipo Decimal com 12 inteiros, podendo ter  3 decimais", required = false, minOccurs = "0")
				@Element(name = "pesoL")
				private String pesoL;
				/**
				 * Tipo Decimal com 12 inteiros, podendo ter 3 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{3}|[1-9]{1}[0-9]{0,11}(\\.[0-9]{3})?", text = "Tipo Decimal com 12 inteiros, podendo ter  3 decimais", required = false, minOccurs = "0")
				@Element(name = "pesoB")
				private String pesoB;
				@ElementList(name = "lacres", inline = true)
				@Validation(required = false, minOccurs = "0")
				private List<Lacres> lacres = new ArrayList();

				public String getQVol() {
					return this.qVol;
				}

				public void setQVol(String qVol) {
					this.qVol = qVol;
				}

				public String getEsp() {
					return this.esp;
				}

				public void setEsp(String esp) {
					this.esp = esp;
				}

				public String getMarca() {
					return this.marca;
				}

				public void setMarca(String marca) {
					this.marca = marca;
				}

				public String getNVol() {
					return this.nVol;
				}

				public void setNVol(String nVol) {
					this.nVol = nVol;
				}

				public String getPesoL() {
					return this.pesoL;
				}

				public void setPesoL(String pesoL) {
					this.pesoL = pesoL;
				}

				public String getPesoB() {
					return this.pesoB;
				}

				public void setPesoB(String pesoB) {
					this.pesoB = pesoB;
				}

				@WXml
				@Order(elements = "nLacre")
				@Element(name = "lacres")
				public static class Lacres {
					/**
					 * Número dos Lacres
					 */
					@Validation(minLength = "1", maxLength = "60", text = "N\u00FAmero dos Lacres", required = true, minOccurs = "1")
					@Element(name = "nLacre")
					private String nLacre;

					public String getNLacre() {
						return this.nLacre;
					}

					public void setNLacre(String nLacre) {
						this.nLacre = nLacre;
					}
				}

				public List<Lacres> getLacres() {
					return this.lacres;
				}

				public void setLacres(java.util.List<Lacres> lacres) {
					this.lacres = lacres;
				}
			}

			public List<Vol> getVol() {
				return this.vol;
			}

			public void setVol(java.util.List<Vol> vol) {
				this.vol = vol;
			}
		}

		public Transp getTransp() {
			return this.transp;
		}

		public void setTransp(Transp transp) {
			this.transp = transp;
		}

		@WXml
		@Order(elements = {"fat", "dup"})
		@Element(name = "cobr")
		public static class Cobr {
			/**
			 * Dados da fatura
			 */
			@Element(name = "fat")
			@Validation(required = false, minOccurs = "0")
			private Fat fat;
			/**
			 * Dados das duplicatas NT 2011/004
			 */
			@ElementList(name = "dup", inline = true)
			@Validation(required = false, minOccurs = "0")
			private List<Dup> dup = new ArrayList();

			@WXml
			@Order(elements = {"nFat", "vOrig", "vDesc", "vLiq"})
			@Element(name = "fat")
			public static class Fat {
				/**
				 * Número da fatura
				 */
				@Validation(minLength = "1", maxLength = "60", text = "N\u00FAmero da fatura", required = false, minOccurs = "0")
				@Element(name = "nFat")
				private String nFat;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vOrig")
				private String vOrig;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vDesc")
				private String vDesc;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = false, minOccurs = "0")
				@Element(name = "vLiq")
				private String vLiq;

				public String getNFat() {
					return this.nFat;
				}

				public void setNFat(String nFat) {
					this.nFat = nFat;
				}

				public String getVOrig() {
					return this.vOrig;
				}

				public void setVOrig(String vOrig) {
					this.vOrig = vOrig;
				}

				public String getVDesc() {
					return this.vDesc;
				}

				public void setVDesc(String vDesc) {
					this.vDesc = vDesc;
				}

				public String getVLiq() {
					return this.vLiq;
				}

				public void setVLiq(String vLiq) {
					this.vLiq = vLiq;
				}
			}

			public Fat getFat() {
				return this.fat;
			}

			public void setFat(Fat fat) {
				this.fat = fat;
			}

			@WXml
			@Order(elements = {"nDup", "dVenc", "vDup"})
			@Element(name = "dup")
			public static class Dup {
				/**
				 * Número da duplicata
				 */
				@Validation(maxLength = "60", minLength = "1", text = "N\u00FAmero da duplicata", required = false, minOccurs = "0")
				@Element(name = "nDup")
				private String nDup;
				/**
				 * Tipo data AAAA-MM-DD
				 */
				@Validation(whiteSpace = "preserve", pattern = "(((20(([02468][048])|([13579][26]))-02-29))|(20[0-9][0-9])-((((0[1-9])|(1[0-2]))-((0[1-9])|(1\\d)|(2[0-8])))|((((0[13578])|(1[02]))-31)|(((0[1,3-9])|(1[0-2]))-(29|30)))))", text = "Tipo data AAAA-MM-DD", required = false, minOccurs = "0")
				@Element(name = "dVenc")
				private String dVenc;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais,
				 * utilizado em tags opcionais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0\\.[0-9]{1}[1-9]{1}|0\\.[1-9]{1}[0-9]{1}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais, utilizado em tags opcionais", required = true, minOccurs = "1")
				@Element(name = "vDup")
				private String vDup;

				public String getNDup() {
					return this.nDup;
				}

				public void setNDup(String nDup) {
					this.nDup = nDup;
				}

				public String getDVenc() {
					return this.dVenc;
				}

				public void setDVenc(String dVenc) {
					this.dVenc = dVenc;
				}

				public String getVDup() {
					return this.vDup;
				}

				public void setVDup(String vDup) {
					this.vDup = vDup;
				}
			}

			public List<Dup> getDup() {
				return this.dup;
			}

			public void setDup(java.util.List<Dup> dup) {
				this.dup = dup;
			}
		}

		public Cobr getCobr() {
			return this.cobr;
		}

		public void setCobr(Cobr cobr) {
			this.cobr = cobr;
		}

		@WXml
		@Order(elements = {"detPag", "vTroco"})
		@Element(name = "pag")
		public static class Pag {
			/**
			 * Grupo de detalhamento da forma de pagamento.
			 */
			@ElementList(name = "detPag", inline = true)
			@Validation(required = true, minOccurs = "1")
			private List<DetPag> detPag = new ArrayList();
			/**
			 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
			 */
			@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "0")
			@Element(name = "vTroco")
			private String vTroco;

			@WXml
			@Order(elements = {"indPag", "tPag", "vPag", "card"})
			@Element(name = "detPag")
			public static class DetPag {
				/**
				 * Indicador da Forma de Pagamento:0-Pagamento à
				 * Vista;1-Pagamento à Prazo;
				 */
				@Validation(whiteSpace = "preserve", enumerations = {"0", "1"}, text = "Indicador da Forma de Pagamento:0-Pagamento \u00E0 Vista;1-Pagamento \u00E0 Prazo;", required = false, minOccurs = "0")
				@Element(name = "indPag")
				private String indPag;
				/**
				 * Forma de Pagamento:01-Dinheiro;02-Cheque;03-Cartão de
				 * Crédito;04-Cartão de Débito;05-Crédito Loja;10-Vale
				 * Alimentação;11-Vale Refeição;12-Vale Presente;13-Vale
				 * Combustível;14 - Duplicata Mercantil;15 - Boleto Bancario;90
				 * - Sem Pagamento;99 - Outros
				 */
				@Validation(whiteSpace = "preserve", enumerations = {"01",
						"02", "03", "04", "05", "10", "11", "12", "13", "14",
						"15", "90", "99"}, text = "Forma de Pagamento:01-Dinheiro;02-Cheque;03-Cart\u00E3o de Cr\u00E9dito;04-Cart\u00E3o de D\u00E9bito;05-Cr\u00E9dito Loja;10-Vale Alimenta\u00E7\u00E3o;11-Vale Refei\u00E7\u00E3o;12-Vale Presente;13-Vale Combust\u00EDvel;14 - Duplicata Mercantil;15 - Boleto Bancario;90 - Sem Pagamento;99 - Outros", required = true, minOccurs = "1")
				@Element(name = "tPag")
				private String tPag;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vPag")
				private String vPag;
				/**
				 * Grupo de Cartões
				 */
				@Element(name = "card")
				@Validation(required = false, minOccurs = "0")
				private Card card;

				public String getIndPag() {
					return this.indPag;
				}

				public void setIndPag(String indPag) {
					this.indPag = indPag;
				}

				public String getTPag() {
					return this.tPag;
				}

				public void setTPag(String tPag) {
					this.tPag = tPag;
				}

				public String getVPag() {
					return this.vPag;
				}

				public void setVPag(String vPag) {
					this.vPag = vPag;
				}

				@WXml
				@Order(elements = {"tpIntegra", "CNPJ", "tBand", "cAut"})
				@Element(name = "card")
				public static class Card {
					/**
					 * Tipo de Integração do processo de pagamento com o sistema
					 * de automação da empresa/ 1=Pagamento integrado com o
					 * sistema de automação da empresa Ex. equipamento TEF ,
					 * Comercio Eletronico 2=Pagamento não integrado com o
					 * sistema de automação da empresa Ex: equipamento POS
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"1",
							"2"}, text = "Tipo de Integra\u00E7\u00E3o do processo de pagamento com o sistema de automa\u00E7\u00E3o da empresa/ \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t1=Pagamento integrado com o sistema de automa\u00E7\u00E3o da empresa Ex. equipamento TEF , Comercio Eletronico\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t2=Pagamento n\u00E3o integrado com o sistema de automa\u00E7\u00E3o da empresa Ex: equipamento POS", required = true, minOccurs = "1")
					@Element(name = "tpIntegra")
					private String tpIntegra;
					/**
					 * Tipo Número do CNPJ
					 */
					@Validation(whiteSpace = "preserve", maxLength = "14", pattern = "[0-9]{14}", text = "Tipo N\u00FAmero do CNPJ", required = false, minOccurs = "0")
					@Element(name = "CNPJ")
					private String CNPJ;
					/**
					 * Bandeira da operadora de cartão de
					 * crédito/débito:01–Visa; 02–Mastercard; 03–American
					 * Express; 04–Sorocred;05-Diners
					 * Club;06-Elo;07-Hipercard;08-Aura;09-Cabal;99–Outros
					 */
					@Validation(whiteSpace = "preserve", enumerations = {"01",
							"02", "03", "04", "05", "06", "07", "08", "09",
							"99"}, text = "Bandeira da operadora de cart\u00E3o de cr\u00E9dito/d\u00E9bito:01\u2013Visa; 02\u2013Mastercard; 03\u2013American Express; 04\u2013Sorocred;05-Diners Club;06-Elo;07-Hipercard;08-Aura;09-Cabal;99\u2013Outros", required = false, minOccurs = "0")
					@Element(name = "tBand")
					private String tBand;
					/**
					 * Número de autorização da operação cartão de
					 * crédito/débito
					 */
					@Validation(minLength = "1", maxLength = "20", text = "N\u00FAmero de autoriza\u00E7\u00E3o da opera\u00E7\u00E3o cart\u00E3o de cr\u00E9dito/d\u00E9bito", required = false, minOccurs = "0")
					@Element(name = "cAut")
					private String cAut;

					public String getTpIntegra() {
						return this.tpIntegra;
					}

					public void setTpIntegra(String tpIntegra) {
						this.tpIntegra = tpIntegra;
					}

					public String getCNPJ() {
						return this.CNPJ;
					}

					public void setCNPJ(String CNPJ) {
						this.CNPJ = CNPJ;
					}

					public String getTBand() {
						return this.tBand;
					}

					public void setTBand(String tBand) {
						this.tBand = tBand;
					}

					public String getCAut() {
						return this.cAut;
					}

					public void setCAut(String cAut) {
						this.cAut = cAut;
					}
				}

				public Card getCard() {
					return this.card;
				}

				public void setCard(Card card) {
					this.card = card;
				}
			}

			public List<DetPag> getDetPag() {
				return this.detPag;
			}

			public void setDetPag(java.util.List<DetPag> detPag) {
				this.detPag = detPag;
			}

			public String getVTroco() {
				return this.vTroco;
			}

			public void setVTroco(String vTroco) {
				this.vTroco = vTroco;
			}
		}

		public Pag getPag() {
			return this.pag;
		}

		public void setPag(Pag pag) {
			this.pag = pag;
		}

		@WXml
		@Order(elements = {"infAdFisco", "infCpl", "obsCont", "obsFisco",
				"procRef"})
		@Element(name = "infAdic")
		public static class InfAdic {
			/**
			 * Informações adicionais de interesse do Fisco (v2.0)
			 */
			@Validation(maxLength = "2000", minLength = "1", text = "Informa\u00E7\u00F5es adicionais de interesse do Fisco (v2.0)", required = false, minOccurs = "0")
			@Element(name = "infAdFisco")
			private String infAdFisco;
			/**
			 * Informações complementares de interesse do Contribuinte
			 */
			@Validation(maxLength = "5000", minLength = "1", text = "Informa\u00E7\u00F5es complementares de interesse do Contribuinte", required = false, minOccurs = "0")
			@Element(name = "infCpl")
			private String infCpl;
			/**
			 * Campo de uso livre do contribuinte informar o nome do campo no
			 * atributo xCampo e o conteúdo do campo no xTexto
			 */
			@ElementList(name = "obsCont", inline = true)
			@Validation(required = false, minOccurs = "0")
			private List<ObsCont> obsCont = new ArrayList();
			/**
			 * Campo de uso exclusivo do Fisco informar o nome do campo no
			 * atributo xCampo e o conteúdo do campo no xTexto
			 */
			@ElementList(name = "obsFisco", inline = true)
			@Validation(required = false, minOccurs = "0")
			private List<ObsFisco> obsFisco = new ArrayList();
			/**
			 * Grupo de informações do processo referenciado
			 */
			@ElementList(name = "procRef", inline = true)
			@Validation(required = false, minOccurs = "0")
			private List<ProcRef> procRef = new ArrayList();

			public String getInfAdFisco() {
				return this.infAdFisco;
			}

			public void setInfAdFisco(String infAdFisco) {
				this.infAdFisco = infAdFisco;
			}

			public String getInfCpl() {
				return this.infCpl;
			}

			public void setInfCpl(String infCpl) {
				this.infCpl = infCpl;
			}

			@WXml
			@Order(elements = "xTexto")
			@Element(name = "obsCont")
			public static class ObsCont {
				/**
				 */
				@Validation(minLength = "1", maxLength = "60", text = "", required = true, minOccurs = "1")
				@Element(name = "xTexto")
				private String xTexto;
				/**
				 */
				@Validation(minLength = "1", maxLength = "20", text = "")
				@Attribute(name = "xCampo")
				private String xCampo;

				public String getXTexto() {
					return this.xTexto;
				}

				public void setXTexto(String xTexto) {
					this.xTexto = xTexto;
				}

				public String getXCampo() {
					return this.xCampo;
				}

				public void setXCampo(String xCampo) {
					this.xCampo = xCampo;
				}
			}

			public List<ObsCont> getObsCont() {
				return this.obsCont;
			}

			public void setObsCont(java.util.List<ObsCont> obsCont) {
				this.obsCont = obsCont;
			}

			@WXml
			@Order(elements = "xTexto")
			@Element(name = "obsFisco")
			public static class ObsFisco {
				/**
				 */
				@Validation(minLength = "1", maxLength = "60", text = "", required = true, minOccurs = "1")
				@Element(name = "xTexto")
				private String xTexto;
				/**
				 */
				@Validation(minLength = "1", maxLength = "20", text = "")
				@Attribute(name = "xCampo")
				private String xCampo;

				public String getXTexto() {
					return this.xTexto;
				}

				public void setXTexto(String xTexto) {
					this.xTexto = xTexto;
				}

				public String getXCampo() {
					return this.xCampo;
				}

				public void setXCampo(String xCampo) {
					this.xCampo = xCampo;
				}
			}

			public List<ObsFisco> getObsFisco() {
				return this.obsFisco;
			}

			public void setObsFisco(java.util.List<ObsFisco> obsFisco) {
				this.obsFisco = obsFisco;
			}

			@WXml
			@Order(elements = {"nProc", "indProc"})
			@Element(name = "procRef")
			public static class ProcRef {
				/**
				 * Indentificador do processo ou ato concessório
				 */
				@Validation(minLength = "1", maxLength = "60", text = "Indentificador do processo ou ato\nconcess\u00F3rio", required = true, minOccurs = "1")
				@Element(name = "nProc")
				private String nProc;
				/**
				 * Origem do processo, informar com: 0 - SEFAZ; 1 - Justiça
				 * Federal; 2 - Justiça Estadual; 3 - Secex/RFB; 9 - Outros
				 */
				@Validation(whiteSpace = "preserve", enumerations = {"0", "1",
						"2", "3", "9"}, text = "Origem do processo, informar com:\n0 - SEFAZ;\n1 - Justi\u00E7a Federal;\n2 - Justi\u00E7a Estadual;\n3 - Secex/RFB;\n9 - Outros", required = true, minOccurs = "1")
				@Element(name = "indProc")
				private String indProc;

				public String getNProc() {
					return this.nProc;
				}

				public void setNProc(String nProc) {
					this.nProc = nProc;
				}

				public String getIndProc() {
					return this.indProc;
				}

				public void setIndProc(String indProc) {
					this.indProc = indProc;
				}
			}

			public List<ProcRef> getProcRef() {
				return this.procRef;
			}

			public void setProcRef(java.util.List<ProcRef> procRef) {
				this.procRef = procRef;
			}
		}

		public InfAdic getInfAdic() {
			return this.infAdic;
		}

		public void setInfAdic(InfAdic infAdic) {
			this.infAdic = infAdic;
		}

		@WXml
		@Order(elements = {"UFSaidaPais", "xLocExporta", "xLocDespacho"})
		@Element(name = "exporta")
		public static class Exporta {
			/**
			 * Tipo Sigla da UF de emissor // acrescentado em 24/10/08
			 */
			@Validation(whiteSpace = "preserve", enumerations = {"AC", "AL",
					"AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS",
					"MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR",
					"RS", "SC", "SE", "SP", "TO"}, text = "Tipo Sigla da UF de emissor // acrescentado em 24/10/08", required = true, minOccurs = "1")
			@Element(name = "UFSaidaPais")
			private String UFSaidaPais;
			/**
			 * Local de Embarque ou de transposição de fronteira
			 */
			@Validation(minLength = "1", maxLength = "60", text = "Local de Embarque ou de transposi\u00E7\u00E3o de fronteira", required = true, minOccurs = "1")
			@Element(name = "xLocExporta")
			private String xLocExporta;
			/**
			 * Descrição do local de despacho
			 */
			@Validation(minLength = "1", maxLength = "60", text = "Descri\u00E7\u00E3o do local de despacho", required = false, minOccurs = "0")
			@Element(name = "xLocDespacho")
			private String xLocDespacho;

			public String getUFSaidaPais() {
				return this.UFSaidaPais;
			}

			public void setUFSaidaPais(String UFSaidaPais) {
				this.UFSaidaPais = UFSaidaPais;
			}

			public String getXLocExporta() {
				return this.xLocExporta;
			}

			public void setXLocExporta(String xLocExporta) {
				this.xLocExporta = xLocExporta;
			}

			public String getXLocDespacho() {
				return this.xLocDespacho;
			}

			public void setXLocDespacho(String xLocDespacho) {
				this.xLocDespacho = xLocDespacho;
			}
		}

		public Exporta getExporta() {
			return this.exporta;
		}

		public void setExporta(Exporta exporta) {
			this.exporta = exporta;
		}

		@WXml
		@Order(elements = {"xNEmp", "xPed", "xCont"})
		@Element(name = "compra")
		public static class Compra {
			/**
			 * Informação da Nota de Empenho de compras públicas (NT2011/004)
			 */
			@Validation(minLength = "1", maxLength = "22", text = "Informa\u00E7\u00E3o da Nota de Empenho de compras p\u00FAblicas (NT2011/004)", required = false, minOccurs = "0")
			@Element(name = "xNEmp")
			private String xNEmp;
			/**
			 * Informação do pedido
			 */
			@Validation(minLength = "1", maxLength = "60", text = "Informa\u00E7\u00E3o do pedido", required = false, minOccurs = "0")
			@Element(name = "xPed")
			private String xPed;
			/**
			 * Informação do contrato
			 */
			@Validation(minLength = "1", maxLength = "60", text = "Informa\u00E7\u00E3o do contrato", required = false, minOccurs = "0")
			@Element(name = "xCont")
			private String xCont;

			public String getXNEmp() {
				return this.xNEmp;
			}

			public void setXNEmp(String xNEmp) {
				this.xNEmp = xNEmp;
			}

			public String getXPed() {
				return this.xPed;
			}

			public void setXPed(String xPed) {
				this.xPed = xPed;
			}

			public String getXCont() {
				return this.xCont;
			}

			public void setXCont(String xCont) {
				this.xCont = xCont;
			}
		}

		public Compra getCompra() {
			return this.compra;
		}

		public void setCompra(Compra compra) {
			this.compra = compra;
		}

		@WXml
		@Order(elements = {"safra", "ref", "forDia", "qTotMes", "qTotAnt",
				"qTotGer", "deduc", "vFor", "vTotDed", "vLiqFor"})
		@Element(name = "cana")
		public static class Cana {
			/**
			 * Identificação da safra
			 */
			@Validation(minLength = "4", maxLength = "9", text = "Identifica\u00E7\u00E3o da safra", required = true, minOccurs = "1")
			@Element(name = "safra")
			private String safra;
			/**
			 * Mês e Ano de Referência, formato: MM/AAAA
			 */
			@Validation(whiteSpace = "preserve", pattern = "(0[1-9]|1[0-2])([/][2][0-9][0-9][0-9])", text = "M\u00EAs e Ano de Refer\u00EAncia, formato: MM/AAAA", required = true, minOccurs = "1")
			@Element(name = "ref")
			private String ref;
			/**
			 * Fornecimentos diários
			 */
			@ElementList(name = "forDia", inline = true)
			@Validation(required = true, minOccurs = "1")
			private List<ForDia> forDia = new ArrayList();
			/**
			 * Tipo Decimal com 11 inteiros, podendo ter de 1 até 10 decimais
			 */
			@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,10}|[1-9]{1}[0-9]{0,10}|[1-9]{1}[0-9]{0,10}(\\.[0-9]{1,10})?", text = "Tipo Decimal com 11 inteiros, podendo ter de 1 at\u00E9 10 decimais", required = true, minOccurs = "1")
			@Element(name = "qTotMes")
			private String qTotMes;
			/**
			 * Tipo Decimal com 11 inteiros, podendo ter de 1 até 10 decimais
			 */
			@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,10}|[1-9]{1}[0-9]{0,10}|[1-9]{1}[0-9]{0,10}(\\.[0-9]{1,10})?", text = "Tipo Decimal com 11 inteiros, podendo ter de 1 at\u00E9 10 decimais", required = true, minOccurs = "1")
			@Element(name = "qTotAnt")
			private String qTotAnt;
			/**
			 * Tipo Decimal com 11 inteiros, podendo ter de 1 até 10 decimais
			 */
			@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,10}|[1-9]{1}[0-9]{0,10}|[1-9]{1}[0-9]{0,10}(\\.[0-9]{1,10})?", text = "Tipo Decimal com 11 inteiros, podendo ter de 1 at\u00E9 10 decimais", required = true, minOccurs = "1")
			@Element(name = "qTotGer")
			private String qTotGer;
			/**
			 * Deduções - Taxas e Contribuições
			 */
			@ElementList(name = "deduc", inline = true)
			@Validation(required = false, minOccurs = "0")
			private List<Deduc> deduc = new ArrayList();
			/**
			 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
			 */
			@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
			@Element(name = "vFor")
			private String vFor;
			/**
			 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
			 */
			@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
			@Element(name = "vTotDed")
			private String vTotDed;
			/**
			 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
			 */
			@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
			@Element(name = "vLiqFor")
			private String vLiqFor;

			public String getSafra() {
				return this.safra;
			}

			public void setSafra(String safra) {
				this.safra = safra;
			}

			public String getRef() {
				return this.ref;
			}

			public void setRef(String ref) {
				this.ref = ref;
			}

			@WXml
			@Order(elements = "qtde")
			@Element(name = "forDia")
			public static class ForDia {
				/**
				 * Tipo Decimal com 11 inteiros, podendo ter de 1 até 10
				 * decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,10}|[1-9]{1}[0-9]{0,10}|[1-9]{1}[0-9]{0,10}(\\.[0-9]{1,10})?", text = "Tipo Decimal com 11 inteiros, podendo ter de 1 at\u00E9 10 decimais", required = true, minOccurs = "1")
				@Element(name = "qtde")
				private String qtde;
				/**
				 * Número do dia
				 */
				@Validation(whiteSpace = "preserve", pattern = "[1-9]|[1][0-9]|[2][0-9]|[3][0-1]", text = "N\u00FAmero do dia")
				@Attribute(name = "dia")
				private String dia;

				public String getQtde() {
					return this.qtde;
				}

				public void setQtde(String qtde) {
					this.qtde = qtde;
				}

				public String getDia() {
					return this.dia;
				}

				public void setDia(String dia) {
					this.dia = dia;
				}
			}

			public List<ForDia> getForDia() {
				return this.forDia;
			}

			public void setForDia(java.util.List<ForDia> forDia) {
				this.forDia = forDia;
			}

			public String getQTotMes() {
				return this.qTotMes;
			}

			public void setQTotMes(String qTotMes) {
				this.qTotMes = qTotMes;
			}

			public String getQTotAnt() {
				return this.qTotAnt;
			}

			public void setQTotAnt(String qTotAnt) {
				this.qTotAnt = qTotAnt;
			}

			public String getQTotGer() {
				return this.qTotGer;
			}

			public void setQTotGer(String qTotGer) {
				this.qTotGer = qTotGer;
			}

			@WXml
			@Order(elements = {"xDed", "vDed"})
			@Element(name = "deduc")
			public static class Deduc {
				/**
				 * Descrição da Dedução
				 */
				@Validation(minLength = "1", maxLength = "60", text = "Descri\u00E7\u00E3o da Dedu\u00E7\u00E3o", required = true, minOccurs = "1")
				@Element(name = "xDed")
				private String xDed;
				/**
				 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
				 */
				@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
				@Element(name = "vDed")
				private String vDed;

				public String getXDed() {
					return this.xDed;
				}

				public void setXDed(String xDed) {
					this.xDed = xDed;
				}

				public String getVDed() {
					return this.vDed;
				}

				public void setVDed(String vDed) {
					this.vDed = vDed;
				}
			}

			public List<Deduc> getDeduc() {
				return this.deduc;
			}

			public void setDeduc(java.util.List<Deduc> deduc) {
				this.deduc = deduc;
			}

			public String getVFor() {
				return this.vFor;
			}

			public void setVFor(String vFor) {
				this.vFor = vFor;
			}

			public String getVTotDed() {
				return this.vTotDed;
			}

			public void setVTotDed(String vTotDed) {
				this.vTotDed = vTotDed;
			}

			public String getVLiqFor() {
				return this.vLiqFor;
			}

			public void setVLiqFor(String vLiqFor) {
				this.vLiqFor = vLiqFor;
			}
		}

		public Cana getCana() {
			return this.cana;
		}

		public void setCana(Cana cana) {
			this.cana = cana;
		}

		public String getVersao() {
			return this.versao;
		}

		public void setVersao(String versao) {
			this.versao = versao;
		}

		public String getId() {
			return this.Id;
		}

		public void setId(String Id) {
			this.Id = Id;
		}
	}

	public InfNFe getInfNFe() {
		return this.infNFe;
	}

	public void setInfNFe(InfNFe infNFe) {
		this.infNFe = infNFe;
	}

	@WXml
	@Order(elements = {"qrCode", "urlChave"})
	@Element(name = "infNFeSupl")
	public static class InfNFeSupl {
		/**
		 * Texto com o QR-Code impresso no DANFE NFC-e
		 */
		@Validation(whiteSpace = "preserve", minLength = "100", maxLength = "600", pattern = "(((HTTPS?|https?)://.*\\?chNFe=[0-9]{44}&nVersao=[0-9]{3}&tpAmb=[1-2](&cDest=([A-Za-z0-9.:+-/)(]{0}|[A-Za-z0-9.:+-/)(]{5,20})?)?&dhEmi=[A-Fa-f0-9]{50}&vNF=(0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?)&vICMS=(0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?)&digVal=[A-Fa-f0-9]{56}&cIdToken=[0-9]{6}&cHashQRCode=[A-Fa-f0-9]{40})|((HTTPS?|https?)://.*\\?p=[0-9]{44}\\|[2]\\|[1-2]\\|(([0]{1}[1-9]{1}|[1-2]{1}[0-9]{1}|[3]{1}[0-1]{1})\\|(0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?)\\|[A-Fa-f0-9]{56}\\|)?(0|[1-9]{1}([0-9]{1,5})?)\\|[A-Fa-f0-9]{40}))", text = "Texto com o QR-Code impresso no DANFE NFC-e", required = true, minOccurs = "1")
		@Element(name = "qrCode")
		private String qrCode;
		/**
		 * Informar a URL da "Consulta por chave de acesso da NFC-e". A mesma
		 * URL que deve estar informada no DANFE NFC-e para consulta por chave
		 * de acesso.
		 */
		@Validation(minLength = "21", maxLength = "85", text = "Informar a URL da \"Consulta por chave de acesso da NFC-e\". A mesma URL que deve estar informada no DANFE NFC-e para consulta por chave de acesso.", required = true, minOccurs = "1")
		@Element(name = "urlChave")
		private String urlChave;

		public String getQrCode() {
			return this.qrCode;
		}

		public void setQrCode(String qrCode) {
			this.qrCode = qrCode;
		}

		public String getUrlChave() {
			return this.urlChave;
		}

		public void setUrlChave(String urlChave) {
			this.urlChave = urlChave;
		}
	}

	public InfNFeSupl getInfNFeSupl() {
		return this.infNFeSupl;
	}

	public void setInfNFeSupl(InfNFeSupl infNFeSupl) {
		this.infNFeSupl = infNFeSupl;
	}

	public SignatureType getSignature() {
		return this.signature;
	}

	public void setSignature(SignatureType signature) {
		this.signature = signature;
	}
}