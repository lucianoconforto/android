package br.inf.sefaz.portalfiscal.model.xmldsig;

import java.util.List;
import java.util.ArrayList;
import br.inf.sefaz.portalfiscal.xml.annotation.ElementList;
import br.inf.sefaz.portalfiscal.xml.annotation.Validation;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;
import br.inf.sefaz.portalfiscal.xml.annotation.Order;

@WXml
@Order(elements = "Transform")
public class TransformsType {

	@ElementList(name = "Transform", inline = true)
	@Validation(required = true, minOccurs = "2")
	private List<TransformType> Transform = new ArrayList();

	public List<TransformType> getTransform() {
		return this.Transform;
	}

	public void setTransform(java.util.List<TransformType> Transform) {
		this.Transform = Transform;
	}
}