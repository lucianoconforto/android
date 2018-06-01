package br.inf.sefaz.portalfiscal.xsd;

import java.io.File;

public class BuildSchemas {

    static public void main(String[] args) {
        File dd = new File("F:\\desenvolvimento\\multifuncao\\damsefaz\\sefaz");
        WXmlXsd.Xsd[] files = new WXmlXsd.Xsd[]{
                new WXmlXsd.Xsd(new File(dd, "schemas/NFe/xmldsig-core-schema_v1.01.xsd"), "br.inf.sefaz.portalfiscal.model.xmldsig"),
                new WXmlXsd.Xsd(new File(dd, "schemas/NFe/leiauteNFe_v4.00.xsd"), "br.inf.sefaz.portalfiscal.model.nfe_v4"),
                new WXmlXsd.Xsd(new File(dd, "schemas/NFe/leiauteConsStatServ_v4.00.xsd"), "br.inf.sefaz.portalfiscal.model.consStatServ_v4_00"),
                new WXmlXsd.Xsd(new File(dd, "schemas/NFe/leiauteConsultaCadastro_v2.00.xsd"), "br.inf.sefaz.portalfiscal.model.consultaCadastro_v2_00"),
        };
        WXmlXsd sefazShemas = new WXmlXsd(
                new File(dd, "src/main/java"),
                files

        );
        try {
            sefazShemas.buildSchemas();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
