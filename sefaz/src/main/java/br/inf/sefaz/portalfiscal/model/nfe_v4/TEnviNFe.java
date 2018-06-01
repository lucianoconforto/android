package br.inf.sefaz.portalfiscal.model.nfe_v4;

import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import java.util.List;
import java.util.ArrayList;
import br.inf.sefaz.portalfiscal.xml.annotation.ElementList;
import br.inf.sefaz.portalfiscal.xml.annotation.Attribute;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;

/**
 * Tipo Pedido de Concessão de Autorização da Nota Fiscal Eletrônica
 */
@WXml
@Order(elements = {"idLote", "indSinc", "NFe"})
public class TEnviNFe {

	/**
	 * Tipo Identificação de Lote
	 */
	@Validation(whiteSpace = "preserve", pattern = "[0-9]{1,15}", text = "Tipo Identifica\u00E7\u00E3o de Lote", required = true, minOccurs = "1")
	@Element(name = "idLote")
	private String idLote;
	/**
	 * Indicador de processamento síncrono. 0=NÃO; 1=SIM=Síncrono
	 */
	@Validation(whiteSpace = "preserve", enumerations = {"0", "1"}, text = "Indicador de processamento s\u00EDncrono. 0=N\u00C3O; 1=SIM=S\u00EDncrono", required = true, minOccurs = "1")
	@Element(name = "indSinc")
	private String indSinc;
	@ElementList(name = "NFe", inline = true)
	@Validation(required = true, minOccurs = "1")
	private List<TNFe> NFe = new ArrayList();
	/**
	 * Tipo Versão da NF-e - 4.00
	 */
	@Validation(whiteSpace = "preserve", pattern = "4\\.00", text = "Tipo Vers\u00E3o da NF-e - 4.00")
	@Attribute(name = "versao")
	private String versao;

	public String getIdLote() {
		return this.idLote;
	}

	public void setIdLote(String idLote) {
		this.idLote = idLote;
	}

	public String getIndSinc() {
		return this.indSinc;
	}

	public void setIndSinc(String indSinc) {
		this.indSinc = indSinc;
	}

	public List<TNFe> getNFe() {
		return this.NFe;
	}

	public void setNFe(java.util.List<TNFe> NFe) {
		this.NFe = NFe;
	}

	public String getVersao() {
		return this.versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}
}