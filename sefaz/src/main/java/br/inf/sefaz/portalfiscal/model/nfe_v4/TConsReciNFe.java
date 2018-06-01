package br.inf.sefaz.portalfiscal.model.nfe_v4;

import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.Attribute;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;

/**
 * Tipo Pedido de Consulta do Recido do Lote de Notas Fiscais Eletrônicas
 */
@WXml
@Order(elements = {"tpAmb", "nRec"})
public class TConsReciNFe {

	/**
	 * Tipo Ambiente
	 */
	@Validation(whiteSpace = "preserve", enumerations = {"1", "2"}, text = "Tipo Ambiente", required = true, minOccurs = "1")
	@Element(name = "tpAmb")
	private String tpAmb;
	/**
	 * Tipo Número do Recibo do envio de lote de NF-e
	 */
	@Validation(whiteSpace = "preserve", maxLength = "15", pattern = "[0-9]{15}", text = "Tipo N\u00FAmero do Recibo do envio de lote de NF-e", required = true, minOccurs = "1")
	@Element(name = "nRec")
	private String nRec;
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

	public String getNRec() {
		return this.nRec;
	}

	public void setNRec(String nRec) {
		this.nRec = nRec;
	}

	public String getVersao() {
		return this.versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}
}