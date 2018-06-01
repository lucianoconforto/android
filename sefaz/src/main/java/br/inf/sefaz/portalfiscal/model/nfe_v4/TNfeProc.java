package br.inf.sefaz.portalfiscal.model.nfe_v4;

import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Attribute;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;

/**
 * Tipo da NF-e processada
 */
@WXml
@Order(elements = {"NFe", "protNFe"})
public class TNfeProc {

	@Element(name = "NFe")
	@Validation(required = true, minOccurs = "1")
	private TNFe NFe;
	@Element(name = "protNFe")
	@Validation(required = true, minOccurs = "1")
	private TProtNFe protNFe;
	/**
	 * Tipo Versão da NF-e - 4.00
	 */
	@Validation(whiteSpace = "preserve", pattern = "4\\.00", text = "Tipo Vers\u00E3o da NF-e - 4.00")
	@Attribute(name = "versao")
	private String versao;

	public TNFe getNFe() {
		return this.NFe;
	}

	public void setNFe(TNFe NFe) {
		this.NFe = NFe;
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