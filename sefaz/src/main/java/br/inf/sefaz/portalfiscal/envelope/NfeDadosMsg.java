package br.inf.sefaz.portalfiscal.envelope;

import br.inf.sefaz.portalfiscal.xml.NodeContent;
import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.Value;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;

@WXml
@Element(name="nfeDadosMsg")
public     class NfeDadosMsg{
    @Value
    private NodeContent content;
    public NodeContent getContent() {
        return content;
    }

    public void setContent(NodeContent content) {
        this.content = content;
    }

}