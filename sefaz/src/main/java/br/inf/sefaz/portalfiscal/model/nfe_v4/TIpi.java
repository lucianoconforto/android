package br.inf.sefaz.portalfiscal.model.nfe_v4;

import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;

/**
 * Tipo: Dados do IPI
 */
@Validation(choices = "[{\"items\":[\"IPITrib\"]},{\"items\":[\"IPINT\"]}]")
@WXml
@Order(elements = {"CNPJProd", "cSelo", "qSelo", "cEnq", "IPITrib", "IPINT"})
public class TIpi {

	/**
	 * Tipo Número do CNPJ
	 */
	@Validation(whiteSpace = "preserve", maxLength = "14", pattern = "[0-9]{14}", text = "Tipo N\u00FAmero do CNPJ", required = false, minOccurs = "0")
	@Element(name = "CNPJProd")
	private String CNPJProd;
	/**
	 * Código do selo de controle do IPI
	 */
	@Validation(minLength = "1", maxLength = "60", text = "C\u00F3digo do selo de controle do IPI", required = false, minOccurs = "0")
	@Element(name = "cSelo")
	private String cSelo;
	/**
	 * Quantidade de selo de controle do IPI
	 */
	@Validation(whiteSpace = "preserve", pattern = "[0-9]{1,12}", text = "Quantidade de selo de controle do IPI", required = false, minOccurs = "0")
	@Element(name = "qSelo")
	private String qSelo;
	/**
	 * Código de Enquadramento Legal do IPI (tabela a ser criada pela RFB)
	 */
	@Validation(minLength = "1", maxLength = "3", text = "C\u00F3digo de Enquadramento Legal do IPI (tabela a ser criada pela RFB)", required = true, minOccurs = "1")
	@Element(name = "cEnq")
	private String cEnq;
	@Element(name = "IPITrib")
	@Validation(required = false, minOccurs = "1")
	private IPITrib IPITrib;
	@Element(name = "IPINT")
	@Validation(required = false, minOccurs = "1")
	private IPINT IPINT;

	public String getCNPJProd() {
		return this.CNPJProd;
	}

	public void setCNPJProd(String CNPJProd) {
		this.CNPJProd = CNPJProd;
	}

	public String getCSelo() {
		return this.cSelo;
	}

	public void setCSelo(String cSelo) {
		this.cSelo = cSelo;
	}

	public String getQSelo() {
		return this.qSelo;
	}

	public void setQSelo(String qSelo) {
		this.qSelo = qSelo;
	}

	public String getCEnq() {
		return this.cEnq;
	}

	public void setCEnq(String cEnq) {
		this.cEnq = cEnq;
	}

	@Validation(choices = "[{\"items\":[\"vBC\",\"pIPI\"]},{\"items\":[\"qUnid\",\"vUnid\"]}]")
	@WXml
	@Order(elements = {"CST", "vBC", "pIPI", "qUnid", "vUnid", "vIPI"})
	@Element(name = "IPITrib")
	public static class IPITrib {
		/**
		 * Código da Situação Tributária do IPI: 00-Entrada com recuperação de
		 * crédito 49 - Outras entradas 50-Saída tributada 99-Outras saídas
		 */
		@Validation(whiteSpace = "preserve", enumerations = {"00", "49", "50",
				"99"}, text = "C\u00F3digo da Situa\u00E7\u00E3o Tribut\u00E1ria do IPI:\n00-Entrada com recupera\u00E7\u00E3o de cr\u00E9dito\n49 - Outras entradas\n50-Sa\u00EDda tributada\n99-Outras sa\u00EDdas", required = true, minOccurs = "1")
		@Element(name = "CST")
		private String CST;
		/**
		 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
		 */
		@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = false, minOccurs = "1")
		@Element(name = "vBC")
		private String vBC;
		/**
		 * Tipo Decimal com até 3 dígitos inteiros, podendo ter de 2 até 4
		 * decimais
		 */
		@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2,4}|[1-9]{1}[0-9]{0,2}(\\.[0-9]{2,4})?", text = "Tipo Decimal com at\u00E9 3 d\u00EDgitos inteiros, podendo ter de 2 at\u00E9 4 decimais", required = false, minOccurs = "1")
		@Element(name = "pIPI")
		private String pIPI;
		/**
		 * Tipo Decimal com 12 inteiros de 1 até 4 decimais
		 */
		@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{1,4}|[1-9]{1}[0-9]{0,11}|[1-9]{1}[0-9]{0,11}(\\.[0-9]{1,4})?", text = "Tipo Decimal com 12 inteiros de 1 at\u00E9 4 decimais", required = false, minOccurs = "1")
		@Element(name = "qUnid")
		private String qUnid;
		/**
		 * Tipo Decimal com 11 inteiros, podendo ter 4 decimais
		 */
		@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{4}|[1-9]{1}[0-9]{0,10}(\\.[0-9]{4})?", text = "Tipo Decimal com 11 inteiros, podendo ter 4 decimais", required = false, minOccurs = "1")
		@Element(name = "vUnid")
		private String vUnid;
		/**
		 * Tipo Decimal com 15 dígitos, sendo 13 de corpo e 2 decimais
		 */
		@Validation(whiteSpace = "preserve", pattern = "0|0\\.[0-9]{2}|[1-9]{1}[0-9]{0,12}(\\.[0-9]{2})?", text = "Tipo Decimal com 15 d\u00EDgitos, sendo 13 de corpo e 2 decimais", required = true, minOccurs = "1")
		@Element(name = "vIPI")
		private String vIPI;

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

		public String getPIPI() {
			return this.pIPI;
		}

		public void setPIPI(String pIPI) {
			this.pIPI = pIPI;
		}

		public String getQUnid() {
			return this.qUnid;
		}

		public void setQUnid(String qUnid) {
			this.qUnid = qUnid;
		}

		public String getVUnid() {
			return this.vUnid;
		}

		public void setVUnid(String vUnid) {
			this.vUnid = vUnid;
		}

		public String getVIPI() {
			return this.vIPI;
		}

		public void setVIPI(String vIPI) {
			this.vIPI = vIPI;
		}
	}

	public IPITrib getIPITrib() {
		return this.IPITrib;
	}

	public void setIPITrib(IPITrib IPITrib) {
		this.IPITrib = IPITrib;
	}

	@WXml
	@Order(elements = "CST")
	@Element(name = "IPINT")
	public static class IPINT {
		/**
		 * Código da Situação Tributária do IPI: 01-Entrada tributada com
		 * alíquota zero 02-Entrada isenta 03-Entrada não-tributada 04-Entrada
		 * imune 05-Entrada com suspensão 51-Saída tributada com alíquota zero
		 * 52-Saída isenta 53-Saída não-tributada 54-Saída imune 55-Saída com
		 * suspensão
		 */
		@Validation(whiteSpace = "preserve", enumerations = {"01", "02", "03",
				"04", "05", "51", "52", "53", "54", "55"}, text = "C\u00F3digo da Situa\u00E7\u00E3o Tribut\u00E1ria do IPI:\n01-Entrada tributada com al\u00EDquota zero\n02-Entrada isenta\n03-Entrada n\u00E3o-tributada\n04-Entrada imune\n05-Entrada com suspens\u00E3o\n51-Sa\u00EDda tributada com al\u00EDquota zero\n52-Sa\u00EDda isenta\n53-Sa\u00EDda n\u00E3o-tributada\n54-Sa\u00EDda imune\n55-Sa\u00EDda com suspens\u00E3o", required = true, minOccurs = "1")
		@Element(name = "CST")
		private String CST;

		public String getCST() {
			return this.CST;
		}

		public void setCST(String CST) {
			this.CST = CST;
		}
	}

	public IPINT getIPINT() {
		return this.IPINT;
	}

	public void setIPINT(IPINT IPINT) {
		this.IPINT = IPINT;
	}
}