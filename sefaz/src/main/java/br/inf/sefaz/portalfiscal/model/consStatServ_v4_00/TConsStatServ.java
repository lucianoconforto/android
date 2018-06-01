package br.inf.sefaz.portalfiscal.model.consStatServ_v4_00;

import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.Attribute;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;

/**
 * Tipo Pedido de Consulta do Status do Serviço
 */
@WXml
@Order(elements = {"tpAmb", "cUF", "xServ"})
public class TConsStatServ {

	/**
	 * Tipo Ambiente
	 */
	@Validation(whiteSpace = "preserve", enumerations = {"1", "2"}, text = "Tipo Ambiente", required = true, minOccurs = "1")
	@Element(name = "tpAmb")
	private String tpAmb;
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
	 * Serviço Solicitado
	 */
	@Validation(enumerations = "STATUS", text = "Servi\u00E7o Solicitado", required = true, minOccurs = "1")
	@Element(name = "xServ")
	private String xServ;
	/**
	 * Tipo versão do leiuate da Consulta Status do Serviço 4.00
	 */
	@Validation(pattern = "4\\.00", text = "Tipo vers\u00E3o do leiuate da Consulta Status do Servi\u00E7o 4.00")
	@Attribute(name = "versao")
	private String versao;

	public String getTpAmb() {
		return this.tpAmb;
	}

	public void setTpAmb(String tpAmb) {
		this.tpAmb = tpAmb;
	}

	public String getCUF() {
		return this.cUF;
	}

	public void setCUF(String cUF) {
		this.cUF = cUF;
	}

	public String getXServ() {
		return this.xServ;
	}

	public void setXServ(String xServ) {
		this.xServ = xServ;
	}

	public String getVersao() {
		return this.versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}
}