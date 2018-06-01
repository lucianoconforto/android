package br.inf.sefaz.portalfiscal.model.nfe_v4;

import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;

/**
 * Tipo Dados do Veículo
 */
@WXml
@Order(elements = {"placa", "UF", "RNTC"})
public class TVeiculo {

	/**
	 * Placa do veículo (NT2011/004)
	 */
	@Validation(whiteSpace = "preserve", pattern = "[A-Z]{2,3}[0-9]{4}|[A-Z]{3,4}[0-9]{3}", text = "Placa do ve\u00EDculo (NT2011/004)", required = true, minOccurs = "1")
	@Element(name = "placa")
	private String placa;
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
	 * Registro Nacional de Transportador de Carga (ANTT)
	 */
	@Validation(minLength = "1", maxLength = "20", text = "Registro Nacional de Transportador de Carga (ANTT)", required = false, minOccurs = "0")
	@Element(name = "RNTC")
	private String RNTC;

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getUF() {
		return this.UF;
	}

	public void setUF(String UF) {
		this.UF = UF;
	}

	public String getRNTC() {
		return this.RNTC;
	}

	public void setRNTC(String RNTC) {
		this.RNTC = RNTC;
	}
}