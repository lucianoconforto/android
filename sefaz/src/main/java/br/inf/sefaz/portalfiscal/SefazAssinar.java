package br.inf.sefaz.portalfiscal;

import android.util.Base64;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.json.JSONException;

import java.io.StringReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.X509Certificate;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.inf.sefaz.portalfiscal.model.nfe_v4.TNFe;
import br.inf.sefaz.portalfiscal.model.xmldsig.KeyInfoType;
import br.inf.sefaz.portalfiscal.model.xmldsig.ReferenceType;
import br.inf.sefaz.portalfiscal.model.xmldsig.SignatureType;
import br.inf.sefaz.portalfiscal.model.xmldsig.SignedInfoType;
import br.inf.sefaz.portalfiscal.model.xmldsig.TransformType;
import br.inf.sefaz.portalfiscal.model.xmldsig.TransformsType;
import br.inf.sefaz.portalfiscal.model.xmldsig.X509DataType;
import br.inf.sefaz.portalfiscal.xml.XmlOutput;
import br.inf.sefaz.portalfiscal.xml.XmlSerializer;
import br.inf.sefaz.portalfiscal.xml.XmlValidator;


public class SefazAssinar {

    private Sefaz sefaz;
    private XmlSerializer xmlSerializer;
    private X509Certificate x509Certificate;
    private PrivateKey privateKey;

    public SefazAssinar(Sefaz sefaz, XmlSerializer xmlSerializer, X509Certificate x509Certificate, PrivateKey privateKey) {
        this.sefaz = sefaz;
        this.xmlSerializer = xmlSerializer;
        this.x509Certificate = x509Certificate;
        this.privateKey = privateKey;
    }


    public static int modulo11(String chave) {
        int total = 0;
        int peso = 2;

        for (int i = 0; i < chave.length(); i++) {
            total += (chave.charAt((chave.length()-1) - i) - '0') * peso;
            peso ++;
            if (peso == 10)
                peso = 2;
        }
        int resto = total % 11;
        return (resto == 0 || resto == 1) ? 0 : (11 - resto);
    }

    public static final String DIGEST_ALGORITHM_NAME = "SHA-1";
    String xx = "<infNFe versao=\"3.10\" Id=\"NFe33180503508722000140656110000000341000000346\"><ide><cUF>33</cUF><cNF>00000034</cNF><natOp>VENDA NO ESTADO</natOp><indPag>0</indPag><mod>65</mod><serie>611</serie><nNF>34</nNF><dhEmi>2018-05-14T15:04:12-03:00</dhEmi><tpNF>1</tpNF><idDest>1</idDest><cMunFG>3302205</cMunFG><tpImp>4</tpImp><tpEmis>1</tpEmis><cDV>6</cDV><tpAmb>2</tpAmb><finNFe>1</finNFe><indFinal>1</indFinal><indPres>1</indPres><procEmi>0</procEmi><verProc>2.5.1.11</verProc></ide><emit><CNPJ>03508722000140</CNPJ><xNome>DAM 255 INFORMATICA LTDA ME - DAM.BOLINHA-FB25</xNome><xFant>DI HELENA</xFant><enderEmit><xLgr>AV PRESIDENTE ROOSEVELT</xLgr><nro>255</nro><xBairro>CIDADE NOVA</xBairro><cMun>3302205</cMun><xMun>ITAPERUNA</xMun><UF>RJ</UF><CEP>28300000</CEP><cPais>1058</cPais><xPais>BRASIL</xPais><fone>2238110660</fone></enderEmit><IE>78872942</IE><CRT>1</CRT></emit><dest><CNPJ>16741655000150</CNPJ><xNome>NF-E EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xNome><enderDest><xLgr>AVN CARDOSO MOREIRA</xLgr><nro>974</nro><xCpl>LOJA B</xCpl><xBairro>CENTRO</xBairro><cMun>3302205</cMun><xMun>ITAPERUNA</xMun><UF>RJ</UF><CEP>28300000</CEP><cPais>1058</cPais><xPais>BRASIL</xPais><fone>38242681</fone></enderDest><indIEDest>9</indIEDest></dest><det nItem=\"1\"><prod><cProd>11964</cProd><cEAN/><xProd>NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xProd><NCM>84719012</NCM><CEST>1007800</CEST><CFOP>5405</CFOP><uCom>UN</uCom><qCom>10.0000</qCom><vUnCom>850.0000000000</vUnCom><vProd>8500.00</vProd><cEANTrib/><uTrib>UN</uTrib><qTrib>10.0000</qTrib><vUnTrib>850.0000000000</vUnTrib><indTot>1</indTot></prod><imposto><ICMS><ICMSSN500><orig>1</orig><CSOSN>500</CSOSN></ICMSSN500></ICMS></imposto></det><total><ICMSTot><vBC>0.00</vBC><vICMS>0.00</vICMS><vICMSDeson>0.00</vICMSDeson><vBCST>0.00</vBCST><vST>0.00</vST><vProd>8500.00</vProd><vFrete>0.00</vFrete><vSeg>0.00</vSeg><vDesc>0.00</vDesc><vII>0.00</vII><vIPI>0.00</vIPI><vPIS>0.00</vPIS><vCOFINS>0.00</vCOFINS><vOutro>0.00</vOutro><vNF>8500.00</vNF></ICMSTot></total><transp><modFrete>9</modFrete></transp><pag><tPag>01</tPag><vPag>8500.00</vPag></pag></infNFe>";


    private String getChave(TNFe.InfNFe infNFe) throws ParseException {

        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'-03:00'");
        SimpleDateFormat s2 = new SimpleDateFormat("yyMM");
        String cUF = infNFe.getIde().getCUF(); // Código da UF do emitente do Documento Fiscal.
        String dataAAMM = s2.format(s1.parse(infNFe.getIde().getDhEmi())); // Ano e Mês de emissão da NF-e.
        // CNPJ do emitente.
        String cnpjCpf;
        if (infNFe.getEmit().getCPF()==null)
            cnpjCpf = infNFe.getEmit().getCNPJ();
        else
            cnpjCpf = infNFe.getEmit().getCPF();
        String mod = infNFe.getIde().getMod();          // Modelo do Documento Fiscal.
        String serie = infNFe.getIde().getSerie();      // Série do Documento Fiscal.
        String tpEmis =  infNFe.getIde().getTpEmis();   // Forma de emissão da NF-e
        String nNF =   infNFe.getIde().getNNF();        // Número do Documento Fiscal.
        String cNF =   infNFe.getIde().getCNF();        // Código Numérico que compõe a Chave de Acesso.
        StringBuilder chave = new StringBuilder();
        chave.append(sefaz.lpadTo(cUF, 2, '0'));
        chave.append(sefaz.lpadTo(dataAAMM, 4, '0'));
        chave.append(sefaz.lpadTo(cnpjCpf.replaceAll("\\D",""), 14, '0'));
        chave.append(sefaz.lpadTo(mod, 2, '0'));
        chave.append(sefaz.lpadTo(serie, 3, '0'));
        chave.append(sefaz.lpadTo(String.valueOf(nNF), 9, '0'));
        chave.append(sefaz.lpadTo(tpEmis, 1, '0'));
        chave.append(sefaz.lpadTo(cNF, 8, '0'));
        int cDV;
        chave.append(cDV =modulo11(chave.toString()));
        infNFe.getIde().setCDV(cDV+"");
        return  chave.toString();
    }

    public  String getCodeQRCode(TNFe tnFe ,String  urlConsulta, String chave , String idToken , String CSC ) throws NoSuchAlgorithmException, JSONException {
        TNFe.InfNFe infNFe = tnFe.getInfNFe();
        String versao="100";
        String ambiente = infNFe.getIde().getTpAmb();
        String digVal=tnFe.getSignature().getSignedInfo().getReference().getDigestValue();
        String dhEmi= infNFe.getIde().getDhEmi();
        String valorNF  = infNFe.getTotal().getICMSTot().getVNF();
        String valorICMS = infNFe.getTotal().getICMSTot().getVICMS();
        String cHashQRCode;
        StringBuilder value = new StringBuilder();
        value.append("chNFe=").append(chave);
        value.append("&nVersao=").append(versao);
        value.append("&tpAmb=").append(ambiente);
        if (infNFe.getDest() != null) {

            String cpfCnpj;
            if (infNFe.getDest().getCPF()==null)
                cpfCnpj = infNFe.getDest().getCNPJ();
            else
                cpfCnpj = infNFe.getDest().getCPF();
            value.append("&cDest=" + cpfCnpj);
        }else {

        }
        value.append("&dhEmi=").append(getHexa(dhEmi));
        value.append("&vNF=").append(valorNF);
        value.append("&vICMS=").append(valorICMS);
        value.append("&digVal=").append(getHexa(digVal));
        value.append("&cIdToken=").append(idToken);
        cHashQRCode = getHexa(getHash(value.toString() + CSC, "SHA-1")).toUpperCase();
        StringBuilder ret = new StringBuilder();
        ret.append(urlConsulta).append("?");
        ret.append(value);
        ret.append("&cHashQRCode=").append(cHashQRCode);
        return ret.toString();
    }

    /**
     * @param valor
     * @param algoritmo "SHA-256", "SHA-1", "MD5"
     * @return
     */
    private static byte[] getHash(String valor, String algoritmo) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance(algoritmo);
        md.update(valor.getBytes());
        return md.digest();
    }

    private static String getHexa(String valor) {
        return getHexa(valor.getBytes());
    }

    private static String getHexa(byte[] bytes) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            int parteAlta = ((bytes[i] >> 4) & 0xf) << 4;
            int parteBaixa = bytes[i] & 0xf;
            if (parteAlta == 0) {
                s.append('0');
            }
            s.append(Integer.toHexString(parteAlta | parteBaixa));
        }
        return s.toString();
    }


    public TNFe assinarNfce(TNFe nfe,String idToken , String CSC) throws Exception {
        TNFe.InfNFe infNFe = nfe.getInfNFe();
        infNFe.getIde().setMod("65");
        String chNFe = getChave(infNFe);
        infNFe.setId("NFe"+chNFe);
        XmlValidator validator = new XmlValidator(infNFe,TNFe.InfNFe.class);
        validator.validate();
        nfe.setInfNFe(infNFe);
        {
            Element el = xmlSerializer.encode(infNFe , sefaz.getTEnviNFeQNameMap());
            String url = "#" + infNFe.getId();
            String digestValue;
            {
                byte[] digestValueCanon = XmlOutput.canonicalize(el, XmlOutput.CANONICAL_XML);
                MessageDigest md = MessageDigest.getInstance(DIGEST_ALGORITHM_NAME);
                digestValue = Base64.encodeToString( md.digest(digestValueCanon), Base64.DEFAULT).replaceAll("\n", "");
            }
            String signatureValue;
            {
                String signedInfoXml = "" +
                        "<SignedInfo xmlns=\"http://www.w3.org/2000/09/xmldsig#\">" +
                            "<CanonicalizationMethod Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/>" +
                            "<SignatureMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#rsa-sha1\"/>" +
                            "<Reference URI=\"" + url + "\">" +
                                "<Transforms>" +
                                    "<Transform Algorithm=\"http://www.w3.org/2000/09/xmldsig#enveloped-signature\"/>" +
                                    "<Transform Algorithm=\"http://www.w3.org/TR/2001/REC-xml-c14n-20010315\"/>" +
                                "</Transforms>" +
                                "<DigestMethod Algorithm=\"http://www.w3.org/2000/09/xmldsig#sha1\"/>" +
                                "<DigestValue>" + digestValue + "</DigestValue>" +
                            "</Reference>" +
                        "</SignedInfo>";
                SAXReader reader = new SAXReader();
                Document document = reader.read(new StringReader(signedInfoXml));
                byte[] signedInfoXmlCanon = XmlOutput.canonicalize((Element) document.getRootElement(), XmlOutput.CANONICAL_XML);
                Signature instance = Signature.getInstance("SHA1withRSA");
                instance.initSign(privateKey);
                instance.update(signedInfoXmlCanon);
                signatureValue = Base64.encodeToString(instance.sign(), Base64.DEFAULT).replaceAll("\n", "");
            }
            String x509Certificate = Base64.encodeToString(this.x509Certificate.getEncoded(), Base64.DEFAULT).replaceAll("\n", "");
            SignatureType signatureType = new SignatureType();
            {
                {
                    SignedInfoType signedInfo = new SignedInfoType();
                    {
                        {
                            ReferenceType reference = new ReferenceType();
                            reference.setURI(url);
                            {
                                TransformsType transforms = new TransformsType();
                                {
                                    TransformType transform = new TransformType();
                                    transform.setAlgorithm("http://www.w3.org/2000/09/xmldsig#enveloped-signature");
                                    transforms.getTransform().add(transform);
                                }
                                {
                                    TransformType transform = new TransformType();
                                    transform.setAlgorithm("http://www.w3.org/TR/2001/REC-xml-c14n-20010315");
                                    transforms.getTransform().add(transform);
                                }
                                reference.setTransforms(transforms);
                            }
                            {
                                ReferenceType.DigestMethod digestMethod = new ReferenceType.DigestMethod();
                                digestMethod.setAlgorithm("http://www.w3.org/2000/09/xmldsig#sha1");
                                reference.setDigestMethod(digestMethod);
                            }
                            {
                                ReferenceType.DigestMethod digestMethod = new ReferenceType.DigestMethod();
                                digestMethod.setAlgorithm("http://www.w3.org/2000/09/xmldsig#sha1");
                                reference.setDigestValue(digestValue);
                            }
                            signedInfo.setReference(reference);
                        }
                        {
                            SignedInfoType.CanonicalizationMethod canonicalizationMethod = new SignedInfoType.CanonicalizationMethod();
                            canonicalizationMethod.setAlgorithm("http://www.w3.org/TR/2001/REC-xml-c14n-20010315");
                            signedInfo.setCanonicalizationMethod(canonicalizationMethod);
                        }
                        {
                            SignedInfoType.SignatureMethod signatureMethod = new SignedInfoType.SignatureMethod();
                            signatureMethod.setAlgorithm("http://www.w3.org/2000/09/xmldsig#rsa-sha1");
                            signedInfo.setSignatureMethod(signatureMethod);
                        }
                    }
                    signatureType.setSignedInfo(signedInfo);
                }
                {
                    signatureType.setSignatureValue(signatureValue);
                }
                {
                    KeyInfoType keyInfo = new KeyInfoType();
                    {
                        X509DataType x509Data = new X509DataType();
                        keyInfo.setX509Data(x509Data);
                        x509Data.setX509Certificate(x509Certificate);
                    }
                    signatureType.setKeyInfo(keyInfo);
                }
            }
            nfe.setSignature(signatureType);
        }
        {
                String urlConsulta = sefaz.getWebServicesURl(nfe, WebServicesServico.URL_QRCode);
                if (urlConsulta==null){
                    urlConsulta = sefaz.getWebServicesURl(nfe, WebServicesServico.URL_QRCode_400);
                }

                String urlChave = sefaz.getWebServicesURl(nfe, WebServicesServico.URL_ConsultaNFCe);
                if (urlChave==null){
                    urlChave = sefaz.getWebServicesURl(nfe, WebServicesServico.URL_ConsultaNFCe_400);
                }

                TNFe.InfNFeSupl infNFeSupl = new  TNFe.InfNFeSupl();
                String qrCode = getCodeQRCode(nfe,urlConsulta, chNFe, idToken, CSC);
                infNFeSupl.setUrlChave(urlChave);
                infNFeSupl.setQrCode(qrCode);
                //dhEmi=323031382D30352D31345431353A30343A31322D30333A3030&vNF=8500.00&vICMS=0.00&digVal=4E4D54546266636E717752356D3245646642766C346D39564D45303D&cIdToken=000003&cHashQRCode=DD3C83D0F6E04E49D8C8C6E376A1AAD07B3DED59
                nfe.setInfNFeSupl(infNFeSupl);
        }
        XmlValidator validator2 = new XmlValidator(nfe,TNFe.class);
        validator2.validate();
        return nfe;
    }
//
//      public String signXml() throws Exception {
//          org.w3c.dom.Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xx.getBytes("UTF-8")));
//          Init.init();
//          ElementProxy.setDefaultPrefix(Constants.SignatureSpecNS, "");
//          XMLSignature xmlSignature = createSignature(doc);
//          final Transforms transforms = new Transforms(doc);
//          transforms.addTransform(Transforms.TRANSFORM.ENVELOPED.SIGNATURE);
//          transforms.addTransform(Transforms.TRANSFORM.C14N.OMIT.COMMENTS);
//          xmlSignature.addDocument("", transforms, Constants.ALGO.ID.DIGEST.SHA1);
//          xmlSignature.addKeyInfo(x509Certificate);
//          xmlSignature.addKeyInfo(x509Certificate.getPublicKey());
//          xmlSignature.sign(privateKey);
//          doc.getDocumentElement().appendChild(xmlSignature.getElement());
//          byte[] d = org.apache.xml.security.c14n.Canonicalizer.getInstance(org.apache.xml.security.c14n.Canonicalizer.ALGO.ID.C14N.OMIT.COMMENTS).canonicalizeSubtree(doc);
//          return new String(d);
//      }
//      private XMLSignature createSignature(  org.w3c.dom.Document doc) throws XMLSecurityException {
//          XMLSignature xmlSignature = null;
//          String uri = "#NFe13140782373077000171650290000030531000030538";
//          xmlSignature = new XMLSignature(doc, uri, XMLSignature.ALGO.ID.SIGNATURE.RSA);
//          return xmlSignature;
//      }


}
