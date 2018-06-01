package br.inf.sefaz.portalfiscal.model.nfe_v4;

import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;

/**
 * Tipo Dados do Local de Retirada ou Entrega // 24/10/08 - tamanho mínimo //
 * v2.0
 */
@Validation(choices = "[{\"items\":[\"CNPJ\"]},{\"items\":[\"CPF\"]}]")
@WXml
@Order(elements = {"CNPJ", "CPF", "xLgr", "nro", "xCpl", "xBairro", "cMun",
		"xMun", "UF"})
public class TLocal {

	/**
	 * Tipo Número do CNPJ Opcional
	 */
	@Validation(whiteSpace = "preserve", maxLength = "14", pattern = "[0-9]{0}|[0-9]{14}", text = "Tipo N\u00FAmero do CNPJ Opcional", required = false, minOccurs = "1")
	@Element(name = "CNPJ")
	private String CNPJ;
	/**
	 * Tipo Número do CPF
	 */
	@Validation(whiteSpace = "preserve", maxLength = "11", pattern = "[0-9]{11}", text = "Tipo N\u00FAmero do CPF", required = false, minOccurs = "1")
	@Element(name = "CPF")
	private String CPF;
	/**
	 * Logradouro
	 */
	@Validation(maxLength = "60", minLength = "2", text = "Logradouro", required = true, minOccurs = "1")
	@Element(name = "xLgr")
	private String xLgr;
	/**
	 * Número
	 */
	@Validation(maxLength = "60", minLength = "1", text = "N\u00FAmero", required = true, minOccurs = "1")
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
	@Validation(maxLength = "60", minLength = "2", text = "Bairro", required = true, minOccurs = "1")
	@Element(name = "xBairro")
	private String xBairro;
	/**
	 * Tipo Código do Município da tabela do IBGE
	 */
	@Validation(whiteSpace = "preserve", pattern = "[0-9]{7}", text = "Tipo C\u00F3digo do Munic\u00EDpio da tabela do IBGE", required = true, minOccurs = "1")
	@Element(name = "cMun")
	private String cMun;
	/**
	 * Nome do município
	 */
	@Validation(maxLength = "60", minLength = "2", text = "Nome do munic\u00EDpio", required = true, minOccurs = "1")
	@Element(name = "xMun")
	private String xMun;
	/**
	 * Tipo Sigla da UF
	 */
	@Validation(whiteSpace = "preserve", enumerations = {"AC", "AL", "AM",
			"AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA",
			"PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE",
			"SP", "TO", "EX"}, text = "Tipo Sigla da UF", required = true, minOccurs = "1")
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

	public String getUF() {
		return this.UF;
	}

	public void setUF(String UF) {
		this.UF = UF;
	}
}