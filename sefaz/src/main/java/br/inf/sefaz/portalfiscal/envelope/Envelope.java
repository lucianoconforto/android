package br.inf.sefaz.portalfiscal.envelope;

import br.inf.sefaz.portalfiscal.xml.NodeContent;
import br.inf.sefaz.portalfiscal.xml.annotation.Element;
import br.inf.sefaz.portalfiscal.xml.annotation.Value;
import br.inf.sefaz.portalfiscal.xml.annotation.WXml;

@WXml
@Element( name = "Envelope" ,prefix = "soap")
public class Envelope {
    private Header header;
    private Body body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }


    @WXml
    @Element(name = "Header" ,prefix = "soap")
    public static class Header {
        @Value
        private NodeContent content;

        public NodeContent getContent() {
            return content;
        }

        public void setContent(NodeContent content) {
            this.content = content;
        }
    }

    @WXml
    @Element(name = "Body" ,prefix = "soap")
    public static class Body {
        @Value
        private NodeContent content;

        public NodeContent getContent() {
            return content;
        }

        public void setContent(NodeContent content) {
            this.content = content;
        }
    }
}
