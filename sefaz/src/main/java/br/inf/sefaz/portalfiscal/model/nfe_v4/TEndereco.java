package br.inf.sefaz.portalfiscal.model.nfe_v4;

import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;

/**
 * Tipo Dados do Endereço // 24/10/08 - tamanho mínimo
 */
@WXml
@Order(elements = {"xLgr", "nro", "xCpl", "xBairro", "cMun", "xMun", "UF",
		"CEP", "cPais", "xPais", "fone"})
public class TEndereco {

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
	 * Nome do município, informar EXTERIOR para operações com o exterior.
	 */
	@Validation(maxLength = "60", minLength = "2", text = "Nome do munic\u00EDpio, informar EXTERIOR para opera\u00E7\u00F5es com o exterior.", required = true, minOccurs = "1")
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
	/**
	 * CEP
	 */
	@Validation(whiteSpace = "preserve", pattern = "[0-9]{8}", text = "CEP", required = false, minOccurs = "0")
	@Element(name = "CEP")
	private String CEP;
	/**
	 * Código de Pais
	 */
	@Validation(whiteSpace = "preserve", pattern = "[0-9]{1,4}", text = "C\u00F3digo de Pais", required = false, minOccurs = "0")
	@Element(name = "cPais")
	private String cPais;
	/**
	 * Nome do país
	 */
	@Validation(maxLength = "60", minLength = "2", text = "Nome do pa\u00EDs", required = false, minOccurs = "0")
	@Element(name = "xPais")
	private String xPais;
	/**
	 * Telefone, preencher com Código DDD + número do telefone , nas operações
	 * com exterior é permtido informar o código do país + código da localidade
	 * + número do telefone
	 */
	@Validation(whiteSpace = "preserve", pattern = "[0-9]{6,14}", text = "Telefone, preencher com C\u00F3digo DDD + n\u00FAmero do telefone , nas opera\u00E7\u00F5es com exterior \u00E9 permtido informar o c\u00F3digo do pa\u00EDs + c\u00F3digo da localidade + n\u00FAmero do telefone", required = false, minOccurs = "0")
	@Element(name = "fone")
	private String fone;

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

	public String getCEP() {
		return this.CEP;
	}

	public void setCEP(String CEP) {
		this.CEP = CEP;
	}

	public String getCPais() {
		return this.cPais;
	}

	public void setCPais(String cPais) {
		this.cPais = cPais;
	}

	public String getXPais() {
		return this.xPais;
	}

	public void setXPais(String xPais) {
		this.xPais = xPais;
	}

	public String getFone() {
		return this.fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}
}