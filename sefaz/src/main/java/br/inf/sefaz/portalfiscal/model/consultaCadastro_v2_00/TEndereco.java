package br.inf.sefaz.portalfiscal.model.consultaCadastro_v2_00;

import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;

/**
 * Tipo Dados do Endereço
 */
@WXml
@Order(elements = {"xLgr", "nro", "xCpl", "xBairro", "cMun", "xMun", "CEP"})
public class TEndereco {

	/**
	 * Logradouro
	 */
	@Validation(minLength = "1", maxLength = "255", text = "Logradouro", required = false, minOccurs = "0")
	@Element(name = "xLgr")
	private String xLgr;
	/**
	 * Número
	 */
	@Validation(maxLength = "60", minLength = "1", text = "N\u00FAmero", required = false, minOccurs = "0")
	@Element(name = "nro")
	private String nro;
	/**
	 * Complemento
	 */
	@Validation(maxLength = "60", minLength = "1", text = "Complemento", required = false, minOccurs = "0")
	@Element(name = "xCpl")
	private String xCpl;
	/**
	 * Bairro
	 */
	@Validation(maxLength = "60", minLength = "1", text = "Bairro", required = false, minOccurs = "0")
	@Element(name = "xBairro")
	private String xBairro;
	/**
	 * Tipo Código do Município da tabela do IBGE
	 */
	@Validation(whiteSpace = "preserve", pattern = "[0-9]{7}", text = "Tipo C\u00F3digo do Munic\u00EDpio da tabela do IBGE", required = false, minOccurs = "0")
	@Element(name = "cMun")
	private String cMun;
	/**
	 * Nome do município
	 */
	@Validation(maxLength = "60", minLength = "1", text = "Nome do munic\u00EDpio", required = false, minOccurs = "0")
	@Element(name = "xMun")
	private String xMun;
	/**
	 * CEP
	 */
	@Validation(pattern = "[0-9]{7,8}", text = "CEP", required = false, minOccurs = "0")
	@Element(name = "CEP")
	private String CEP;

	public String getXLgr() {
		return this.xLgr;
	}

	public void setXLgr(String xLgr) {
		this.xLgr = xLgr;
	}

	public String getNro() {
		return this.nro;
	}

	public void setNro(String nro) {
		this.nro = nro;
	}

	public String getXCpl() {
		return this.xCpl;
	}

	public void setXCpl(String xCpl) {
		this.xCpl = xCpl;
	}

	public String getXBairro() {
		return this.xBairro;
	}

	public void setXBairro(String xBairro) {
		this.xBairro = xBairro;
	}

	public String getCMun() {
		return this.cMun;
	}

	public void setCMun(String cMun) {
		this.cMun = cMun;
	}

	public String getXMun() {
		return this.xMun;
	}

	public void setXMun(String xMun) {
		this.xMun = xMun;
	}

	public String getCEP() {
		return this.CEP;
	}

	public void setCEP(String CEP) {
		this.CEP = CEP;
	}
}