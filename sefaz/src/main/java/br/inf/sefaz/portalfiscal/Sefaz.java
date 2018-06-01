package br.inf.sefaz.portalfiscal;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

import org.dom4j.QName;

import br.inf.sefaz.portalfiscal.envelope.Envelope;
import br.inf.sefaz.portalfiscal.envelope.NfeDadosMsg;
import br.inf.sefaz.portalfiscal.model.consStatServ_v4_00.TConsStatServ;
import br.inf.sefaz.portalfiscal.model.consStatServ_v4_00.TRetConsStatServ;
import br.inf.sefaz.portalfiscal.model.nfe_v4.TEnviNFe;
import br.inf.sefaz.portalfiscal.model.nfe_v4.TNFe;
import br.inf.sefaz.portalfiscal.model.nfe_v4.TNfeProc;
import br.inf.sefaz.portalfiscal.model.nfe_v4.TRetEnviNFe;
import br.inf.sefaz.portalfiscal.model.xmldsig.SignatureType;
import br.inf.sefaz.portalfiscal.xml.NodeContentReader;
import br.inf.sefaz.portalfiscal.xml.NodeContentWriter;
import br.inf.sefaz.portalfiscal.xml.XmlSerializer;
import br.inf.sefaz.portalfiscal.xml.XmlValidator;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public abstract class Sefaz {
    private final Retrofit retrofit;
    private final SefazService sefazService;
    private final KeyManager[] keyManagers;
    private final XmlSerializer xmlSerializer;
    private InputStream webServicesNfe;
    private JSONObject webServicesNfeJSONObject = null;
    private KeyStore trustStore;
    private final KeyStore keyStore;
    private final PrivateKey privateKey;
    private final SefazAssinar sefazAssinar;
    private final X509Certificate x509Certificate;
    private InputStream certificado;
    private InputStream fileBKS;
    private String certificadoSenha = "1234";
    private String trustStoreSenha = "changeit";
    private WebServicesAmbiente ambiente = WebServicesAmbiente.PRODUCAO;
    private String verProc = "DamPdvMovel";

    public JSONObject getWebServicesNfeJSONObject() {
        return webServicesNfeJSONObject;
    }

    public void setWebServicesNfe(InputStream webServicesNfe) {
        this.webServicesNfe = webServicesNfe;
    }


    public interface Response {
        <T> T getData(Class<T> type, Map<String, QName> data) throws NoSuchMethodException, InstantiationException, IllegalAccessException, DocumentException, InvocationTargetException, IOException;
    }

    public String lpadTo(String input, int width, char ch) {
        String strPad = "";

        StringBuffer sb = new StringBuffer(input.trim());
        while (sb.length() < width)
            sb.insert(0, ch);
        strPad = sb.toString();

        if (strPad.length() > width) {
            strPad = strPad.substring(0, width);
        }
        return strPad;
    }


    public class Request {
        private Object data;
        private Map<String, QName> qNameMap = new HashMap<>();


        public void setData(Object data) {
            this.data = data;
        }

        public Map<String, QName> getQNameMap() {
            return qNameMap;
        }

        public void setQNameMap(Map<String, QName> qNameMap) {
            this.qNameMap = qNameMap;
        }

        public Object getData() {
            return data;
        }
    }

    static public class Call<T> {
        private CallBack<T> callBack;

        public void enqueue(CallBack<T> callBack) {
            this.callBack = callBack;
        }

        public CallBack<T> getCallBack() {
            return callBack;
        }

        public void setCallBack(CallBack<T> callBack) {
            this.callBack = callBack;
        }
    }


    static public interface CallBack<T> {
        void onResponse(T resposta, retrofit2.Response<ResponseBody> response);

        void onFailure(Throwable e, retrofit2.Response<ResponseBody> response);
    }


    public Sefaz() throws Exception {
        configure();
        keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(certificado, certificadoSenha.toCharArray());
        Enumeration aliases = keyStore.aliases();
        String keyAlias = "";
        while (aliases.hasMoreElements()) {
            keyAlias = (String) aliases.nextElement();
        }
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, certificadoSenha.toCharArray());
        keyManagers = kmf.getKeyManagers();
        final TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

        if (fileBKS != null) {
            trustStore = KeyStore.getInstance("BKS");
            trustStore.load(fileBKS, trustStoreSenha.toCharArray());
        }
        xmlSerializer = new XmlSerializer();
        trustManagerFactory.init(trustStore);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://nfe.svrs.rs.gov.br")
                .client(getUnsafeOkHttpClient())
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        sefazService = retrofit.create(SefazService.class);
        x509Certificate = (X509Certificate) keyStore.getCertificate(keyAlias);
        privateKey = (PrivateKey) keyStore.getKey(keyAlias, certificadoSenha.toCharArray());
        sefazAssinar = new SefazAssinar(this, xmlSerializer, x509Certificate, privateKey);
        ClassLoader classLoader = getClass().getClassLoader();

        String str = convertStreamToString(webServicesNfe);
        webServicesNfeJSONObject = new JSONObject(str);

    }

    public static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    public abstract void configure();
//    public Call<ResponseBody> nfeStatusServico2(String xml) {
//       MediaType xmlMediaType  = MediaType.parse("text/xml; charset=utf-8");
//       final RequestBody p= RequestBody.create(xmlMediaType, xml);
//       return  sefazService.nfeStatusServico2("https://nfe.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx", p);
//    }
//    public Call<Envelope<TRetConsStatServ>> nfeStatusServico2(SefazUF sefazUF , String versao) {
//        Envelope<TConsStatServ> rq = new Envelope<TConsStatServ>();
//        rq.setNameSpaceEnvelope(new QName("http://www.w3.org/2003/05/soap-envelope" ,"soap:Envelope"));
//        rq.setNameSpaceNfeCabecMsg(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NfeStatusServico2","nfeCabecMsg"));
//        rq.setNameSpaceNfeDadosMsg(new QName("http://www.portalfiscal.inf.br/nfe/wsdl/NfeStatusServico2","nfeDadosMsg"));
//        rq.setVersao(versao);
//        rq.setCUF(sefazUF.getCodigoIbge());
//        TConsStatServ consStatServ =new TConsStatServ();
//        consStatServ.setTpAmb(ambiente.getCodigo());
//        consStatServ.setVersao( rq.getVersao());
//        consStatServ.setXServ("STATUS");
//        consStatServ.setCUF(sefazUF.getCodigoIbge());
//        rq.setData(consStatServ);
//        String url = "https://nfe.svrs.rs.gov.br/ws/NfeStatusServico/NfeStatusServico2.asmx";
//        return  sefazService.nfeStatusServico2(url,  rq);
//    }

    public String toXml(TEnviNFe tEnviNFe) throws Exception {
        XmlValidator validator = new XmlValidator(tEnviNFe, TEnviNFe.class);
        validator.validate();
        Element xml = xmlSerializer.encode(tEnviNFe, getTEnviNFeQNameMap());
        return xml.asXML();
    }


    public List<TNfeProc> getProtNFeLista(String xml, TRetEnviNFe resposta) throws NoSuchMethodException, InstantiationException, IllegalAccessException, DocumentException, InvocationTargetException {
        return getProtNFeLista(xmlSerializer.decode(xml, TEnviNFe.class, getTEnviNFeQNameMap()), resposta);
    }

    public List<TNfeProc> getProtNFeLista(TEnviNFe tEnviNFe, TRetEnviNFe resposta) {
        List<TNfeProc> tNfeProcs = new ArrayList<>();
        for (TNFe nfe : tEnviNFe.getNFe()) {
            TNfeProc tNfeProc = new TNfeProc();
            tNfeProc.setNFe(nfe);
            tNfeProc.setProtNFe(resposta.getProtNFe());
            tNfeProc.setVersao(nfe.getInfNFe().getVersao());
            tNfeProcs.add(tNfeProc);
        }
        return tNfeProcs;
    }

    public String toXml(TNfeProc tNfeProc) throws Exception {
        Element xml = xmlSerializer.encode(tNfeProc, getTEnviNFeQNameMap());
        return xml.asXML();
    }


    public Call<TRetEnviNFe> nfeAutorizacao(String xml) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new StringReader(xml));
        NfeDadosMsg nfeDadosMsg = new NfeDadosMsg();
        NodeContentReader nodeContentReader = new NodeContentReader(document.getRootElement());
        nfeDadosMsg.setContent(nodeContentReader);
        TEnviNFe tEnviNFe = nodeContentReader.readEntity(xmlSerializer, TEnviNFe.class, getTEnviNFeQNameMap());
        String url = getWebServicesURl(tEnviNFe.getNFe().get(0), WebServicesServico.NFeAutorizacao_400);
        return nfeAutorizacao(url, nfeDadosMsg);
    }

    public Call<TRetEnviNFe> nfeAutorizacao(TEnviNFe tEnviNFe) throws Exception {
        XmlValidator validator = new XmlValidator(tEnviNFe, TEnviNFe.class);
        validator.validate();
        NfeDadosMsg nfeDadosMsg = new NfeDadosMsg();
        nfeDadosMsg.setContent(new NodeContentWriter(tEnviNFe));
        String url = getWebServicesURl(tEnviNFe.getNFe().get(0), WebServicesServico.NFeAutorizacao_400);
        return nfeAutorizacao(url, nfeDadosMsg);
    }

    private Call<TRetEnviNFe> nfeAutorizacao(String url, NfeDadosMsg nfeDadosMsg) throws Exception {
        Envelope rq = new Envelope();
        Envelope.Body body = new Envelope.Body();
        body.setContent(new NodeContentWriter(nfeDadosMsg));
        rq.setBody(body);
        Request sefazData = new Request();
        sefazData.setData(rq);
        sefazData.setQNameMap(getTEnviNFeQNameMap());
        Element xml = xmlSerializer.encode(sefazData.getData(), sefazData.getQNameMap());
        MediaType xmlMediaType = MediaType.parse("text/xml; charset=utf-8");
        String v = xml.asXML();
        RequestBody b = RequestBody.create(xmlMediaType, v);
        retrofit2.Call<ResponseBody> q = sefazService.nfeAutorizacao(url, b);
        final Call<TRetEnviNFe> c = new Call<TRetEnviNFe>();
        final Sefaz me = this;
        q.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    ResponseBody responseBody = response.body();
                    String xmlR = responseBody.string();
                    Envelope envelope = xmlSerializer.decode(xmlR, Envelope.class, me.getTEnviNFeQNameMap());
                    TRetEnviNFe d = envelope.getBody().getContent()
                            .readEntity(me.xmlSerializer, NfeDadosMsg.class, me.getTEnviNFeQNameMap())
                            .getContent()
                            .readEntity(me.xmlSerializer, TRetEnviNFe.class, me.getTEnviNFeQNameMap());
                    c.getCallBack().onResponse(d, response);

                } catch (Throwable e) {
                    c.getCallBack().onFailure(e, response);
                }
            }

            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        c.getCallBack().onFailure(t, null);
                    }
                }).start();
            }
        });
        return c;

    }
//
//    String xml =
//            "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
//                    "<soap12:Envelope xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">" +
//                    "<soap12:Header>" +
//                    "<nfeCabecMsg xmlns=\"http://www.portalfiscal.inf.br/nfe/wsdl/NfeStatusServico2\">" +
//                    "<cUF>33</cUF>" +
//                    "<versaoDados>3.10</versaoDados>" +
//                    "</nfeCabecMsg>" +
//                    "</soap12:Header>" +
//                    "<soap12:Body>" +
//                    "<nfeDadosMsg xmlns=\"http://www.portalfiscal.inf.br/nfe/wsdl/NfeStatusServico2\">" +
//                    "<consStatServ xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"3.10\">" +
//                    "<tpAmb>1</tpAmb>" +
//                    "<cUF>33</cUF>" +
//                    "<xServ>STATUS</xServ>" +
//                    "</consStatServ>" +
//                    "</nfeDadosMsg>" +
//                    "</soap12:Body>" +
//                    "</soap12:Envelope>";

    public Call<TRetConsStatServ> nfeStatusServico(TConsStatServ tConsStatServ) throws Exception {
        Envelope rq = new Envelope();
        Envelope.Body body = new Envelope.Body();


        NfeDadosMsg nfeDadosMsg = new NfeDadosMsg();
        nfeDadosMsg.setContent(new NodeContentWriter(tConsStatServ));
        body.setContent(new NodeContentWriter(nfeDadosMsg));
        rq.setBody(body);
        Request sefazData = new Request();
        sefazData.setData(rq);
        sefazData.setQNameMap(getTConsStatServQNameMap());
        Element xml = xmlSerializer.encode(sefazData.getData(), sefazData.getQNameMap());
        MediaType xmlMediaType = MediaType.parse("text/xml; charset=utf-8");
        String v = xml.asXML();
        RequestBody b = RequestBody.create(xmlMediaType, v);
        String url = getWebServicesURl(tConsStatServ.getCUF(),WebServicesServico.NfeStatusServico_400);
        retrofit2.Call<ResponseBody> q = sefazService.nfeStatusServico2(url, b);
        final Call<TRetConsStatServ> c = new Call<>();
        final Sefaz me = this;
        q.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    ResponseBody responseBody = response.body();
                    String xmlR = responseBody.string();
                    Envelope envelope = xmlSerializer.decode(xmlR, Envelope.class, me.getTConsStatServQNameMap());
                    TRetConsStatServ d = envelope.getBody().getContent()
                            .readEntity(me.xmlSerializer, NfeDadosMsg.class, me.getTConsStatServQNameMap())
                            .getContent()
                            .readEntity(me.xmlSerializer, TRetConsStatServ.class, me.getTConsStatServQNameMap());
                    c.getCallBack().onResponse(d, response);

                } catch (Throwable e) {
                    c.getCallBack().onFailure(e, response);
                }
            }
            @Override
            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        c.getCallBack().onFailure(t, null);
                    }
                }).start();
            }
        });
        return c;

    }

    public HashMap getTEnviNFeQNameMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(Envelope.class.getCanonicalName(), QName.get("Envelope", "soap", "http://www.w3.org/2003/05/soap-envelope"));
        map.put(SignatureType.class.getCanonicalName(), QName.get("Signature", "", "http://www.w3.org/2000/09/xmldsig#"));
        map.put(NfeDadosMsg.class.getCanonicalName(), QName.get("nfeDadosMsg", "", "http://www.portalfiscal.inf.br/nfe/wsdl/NFeAutorizacao4"));
        map.put(TEnviNFe.class.getCanonicalName(), QName.get("enviNFe", "", "http://www.portalfiscal.inf.br/nfe"));
        map.put(TNFe.InfNFe.class.getCanonicalName(), QName.get("infNFe", "", "http://www.portalfiscal.inf.br/nfe"));
        map.put(TNFe.class.getCanonicalName(), QName.get("NFe", "", "http://www.portalfiscal.inf.br/nfe"));
        map.put(TNfeProc.class.getCanonicalName(), QName.get("nfeProc", "", "http://www.portalfiscal.inf.br/nfe"));
        map.put(TConsStatServ.class.getCanonicalName(), QName.get("consStatServ", "", "http://www.portalfiscal.inf.br/nfe"));
        return map;
    }
    public HashMap getTConsStatServQNameMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put(Envelope.class.getCanonicalName(), QName.get("Envelope", "soap", "http://www.w3.org/2003/05/soap-envelope"));
        map.put(SignatureType.class.getCanonicalName(), QName.get("Signature", "", "http://www.w3.org/2000/09/xmldsig#"));
        map.put(NfeDadosMsg.class.getCanonicalName(), QName.get("nfeDadosMsg", "", "http://www.portalfiscal.inf.br/nfe/wsdl/NFeStatusServico4"));
        map.put(TEnviNFe.class.getCanonicalName(), QName.get("enviNFe", "", "http://www.portalfiscal.inf.br/nfe"));
        map.put(TNFe.InfNFe.class.getCanonicalName(), QName.get("infNFe", "", "http://www.portalfiscal.inf.br/nfe"));
        map.put(TNFe.class.getCanonicalName(), QName.get("NFe", "", "http://www.portalfiscal.inf.br/nfe"));
        map.put(TNfeProc.class.getCanonicalName(), QName.get("nfeProc", "", "http://www.portalfiscal.inf.br/nfe"));
        map.put(TConsStatServ.class.getCanonicalName(), QName.get("consStatServ", "", "http://www.portalfiscal.inf.br/nfe"));
        return map;
    }

    public OkHttpClient getUnsafeOkHttpClient() throws KeyManagementException, NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, IOException, CertificateException {
        final X509Certificate x509Certificate = (java.security.cert.X509Certificate) keyStore.getCertificate(keyStore.aliases().nextElement());
        final TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                    }

                    @Override
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[]{x509Certificate};
                    }
                }
        };
        SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
        sslContext.init(keyManagers, trustAllCerts, null);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.sslSocketFactory(sslContext.getSocketFactory());
        return builder.build();
    }

    public String getWebServicesURl(TNFe nfe, WebServicesServico webServicesServico) throws JSONException {
        String UF = nfe.getInfNFe().getIde().getCUF();
        String modelo = nfe.getInfNFe().getIde().getMod().contentEquals("55") ? "NFE" : "NFCE";
        return getWebServicesURl(UF, webServicesServico, modelo);
    }

    public String getWebServicesURl(String CUF, WebServicesServico webServicesServico) throws JSONException {
        return getWebServicesURl(CUF, webServicesServico, null);
    }

    public String getWebServicesURl(String CUF, WebServicesServico webServicesServico, String modelo) throws JSONException {
        String UF = SefazUF.byCode(CUF).name().toUpperCase();
        String ambiente = getAmbiente().ordinal() == WebServicesAmbiente.PRODUCAO.ordinal() ? "_P" : "_H";
        JSONObject obj = getWebServicesNfeJSONObject();
        Iterator<String> keys = obj.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            String KEY = key.toUpperCase();
            if (
                    KEY.indexOf(UF) > -1 &&
                    (modelo==null||KEY.indexOf(modelo) > -1) &&
                     KEY.indexOf(ambiente) > -1
            ) {
                JSONObject oo = obj.getJSONObject(key);
                if (oo.has("Usar")) {
                    JSONObject o1 = obj.getJSONObject(oo.getString("Usar"));
                    Iterator<String> _keys = o1.keys();
                    while (_keys.hasNext()) {
                        String _key = _keys.next();
                        oo.put(_key, o1.getString(_key));
                    }
                }
                if (oo.has(webServicesServico.name())) {
                    String v = oo.getString(webServicesServico.name());
                    return v;
                }
                ;
            }
        }

        return null;
    }

    public void setCertificado(InputStream certificado) {
        this.certificado = certificado;
    }

    public void setCertificadoSenha(String certificadoSenha) {
        this.certificadoSenha = certificadoSenha;
    }

    public void setFileBKS(InputStream fileBKS) {
        this.fileBKS = fileBKS;
    }

    public void setTrustStoreSenha(String senha) {
        this.trustStoreSenha = senha;
    }

    public void setAmbiente(WebServicesAmbiente ambiente) {
        this.ambiente = ambiente;
    }

    public WebServicesAmbiente getAmbiente() {
        return this.ambiente;
    }

    public TNFe assinarNfce(TNFe tnFe, String idToken, String CSC) throws Exception {
        return this.sefazAssinar.assinarNfce(tnFe, idToken, CSC);
    }
}
