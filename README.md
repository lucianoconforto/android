### Projetos

#### sefaz
disponibiliza os metodos de comunicação com a sefaz 
#### sefaz-xsd 
cria a traveis dos arquivos  xsd  as classes modelos para comunicação com a sefaz 
#### sefaz-xml
cuida da interpretação dos modelos para a serialização e desserialização em xml 
  
### Sefaz Android
 StatusServico
 
 Autorizacao
 
 Testado em Android 6.0 Marshmallow ou superior
 
### Donwload 
https://github.com/brsefaz/android/raw/master/sefaz.jar
 
### Dependencias Gradle
```gradle
    implementation group: 'com.squareup.retrofit2', name: 'retrofit', version: '2.0.2'
    implementation group: 'com.squareup.okhttp', name: 'okhttp', version: '2.7.5'
    implementation group: 'org.dom4j', name: 'dom4j', version: '2.1.0'
    implementation 'com.squareup.retrofit2:converter-scalars:2.1.0'
    implementation files("libs/sefaz.jar")
```

### Exemplo
```java
package br.inf.sefaz.portalfiscal.test;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.inf.sefaz.portalfiscal.test.R;
import br.inf.sefaz.portalfiscal.Sefaz;
import br.inf.sefaz.portalfiscal.SefazUF;
import br.inf.sefaz.portalfiscal.WebServicesAmbiente;
import br.inf.sefaz.portalfiscal.model.consStatServ_v4_00.TConsStatServ;
import br.inf.sefaz.portalfiscal.model.consStatServ_v4_00.TRetConsStatServ;
import br.inf.sefaz.portalfiscal.model.nfe_v4.TEnderEmi;
import br.inf.sefaz.portalfiscal.model.nfe_v4.TEnviNFe;
import br.inf.sefaz.portalfiscal.model.nfe_v4.TNFe;
import br.inf.sefaz.portalfiscal.model.nfe_v4.TNfeProc;
import br.inf.sefaz.portalfiscal.model.nfe_v4.TRetEnviNFe;
import okhttp3.ResponseBody;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Sefaz genSefaz(final  String certificado ,final  String certificadoSenha, final WebServicesAmbiente ambiente  ) throws Exception {
        final AssetManager assetManager = getAssets();
        return new Sefaz() {
            public void configure() {
                try {
                    BufferedInputStream certificadoStream = new BufferedInputStream(assetManager.open(certificado));
                    BufferedInputStream fileCacerts = new BufferedInputStream(assetManager.open("Cacert.bks"));
                    BufferedInputStream webServicesNfe = new BufferedInputStream(assetManager.open("WebServicesNfe.json"));
                    setCertificado(certificadoStream);
                    setFileBKS(fileCacerts);
                    setAmbiente(ambiente);
                    setCertificadoSenha(certificadoSenha);
                    setWebServicesNfe(webServicesNfe);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        Sefaz _sefaz= null;
        try {
             _sefaz = genSefaz("teste.pfx","1234",WebServicesAmbiente.HOMOLOGACAO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        final  Sefaz sefaz = _sefaz;

        nfeStatusServico21Test(sefaz);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nfeAutorizacao2Test(sefaz);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static String lpadTo(String input, int width, char ch) {
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


    public void nfeAutorizacao2Test(Sefaz sefaz) {
        try {
            String idToken = "xxxxxxx";
            String csc = "xxxxxxx";

            // Ambiente   (1 - produção ,2 - homologacao)
            String tpAmb = sefaz.getAmbiente().getCodigo();
            String versao = "xxxxxxx";
            // modelo da Nota 65 nfce / 55 nfe
            String mod = "xxxxxxx";
            // Série do Documento Fiscal
            String serie = "xxxxxxx";
            // Número do Documento Fiscal
            String numeroNota = "xxxxxxx";
            // natureza de Operação
            String cNF = sefaz.lpadTo(numeroNota, 8, '0');
            String natOp = "xxxxxxx";
            SimpleDateFormat sdf = new SimpleDateFormat("xxxxxxx");
            String tpNF = "xxxxxxx";
            //  Identificador de local de destino da operação   **** 1 - Operação interna
            String idDest = "xxxxxxx";

            // Código do município de ocorrência do fato gerador do ICMS do transporte
            String cMunFG = "xxxxxxx";
            // Formato de Impressão do DANFE
            String tpImp = "xxxxxxx";
            // Tipo de Emissão da NF-e
            String tpEmis = "xxxxxxx";
            //Dígito Verificador da Chave de Acesso
            //String cDV = "xxxxxxx";
            // codigo  CodigoIbge do Estado
            SefazUF estado = SefazUF.RJ;

            String cUf = estado.getCodigoIbge();
            // Finalidade de emissão da NF-e
            String finNFe = "xxxxxxx";
            // Versão do Processo de emissão da NF-e
            String verProc = "xxxxxxx";
            // é obrigatoria se for contingencia
            String xJust ="xxxxxxx";
            // é obrigatoria se for contingencia
            String dhEmi =sdf.format(new Date());
            String dhCont =dhEmi;

            // Indica operação com Consumidor final
            String indFinal = "xxxxxxx";
            // Indicador de presença do comprador no estabelecimento comercial no momento da operação
            String indPres = "xxxxxxx";
            // Processo de emissão da NF-e
            String procEmi = "xxxxxxx";

            /**
             *       Dados empresa
             *
             * */
            String CNPJ = "xxxxxxx";
            String xNome = "xxxxxxx";
            String xFant = "xxxxxxx";
            String IE = "xxxxxxx";
            String CRT = "xxxxxxx";
            String enderEmitXLgr = "xxxxxxx";
            String enderEmitNro = "xxxxxxx";
            String enderEmitXCpl = "xxxxxxx";
            String enderEmitXBairro = "xxxxxxx";
            String enderEmitCMun = "xxxxxxx";
            String enderEmitXMun = "xxxxxxx";
            String enderEmitUF = estado.name();
            String enderEmitCEP = "xxxxxxx";
            String enderEmitCPais = "xxxxxxx";
            String enderEmitXPais = "xxxxxxx";
            String enderEmitFone = "xxxxxxx";

            /**
             *       Dados produto1
             *
             * */
            String produto1NItem = "xxxxxxx";
            String produto1CProd = "xxxxxxx";
            String produto1CEAN = "xxxxxxx";
            String produto1XProd = "xxxxxxx";
            String produto1NCM = "xxxxxxx";
            String produto1CEST = "xxxxxxx";
            String produto1CFOP = "xxxxxxx";
            String produto1UCom = "xxxxxxx";
            String produto1QCom = "xxxxxxx";
            String produto1QTrib = "xxxxxxx";
            String produto1VUnCom = "xxxxxxx";
            String produto1VUnTrib = "xxxxxxx";
            String produto1VProd = "xxxxxxx";
            String produto1CEANTrib = "xxxxxxx";
            String produto1UTrib = "xxxxxxx";
            String produto1IndTot = "xxxxxxx";
            String produto1ImpostoICMSSN500Orig = "xxxxxxx";
            String produto1ImpostoICMSSN500CSOSN = "xxxxxxx";

            /**
             *       totais
             *
             * */

            String totalICMSVBC = "xxxxxxx";
            String totalICMSVICMS = "xxxxxxx";
            String totalICMSVICMSDeson = "xxxxxxx";
            String totalICMSVFCPUFDest = "xxxxxxx";
            String totalICMSVICMSUFDest = "xxxxxxx";
            String totalICMSVICMSUFRemet = "xxxxxxx";
            String totalICMSVBCST = "xxxxxxx";
            String totalICMSVST = "xxxxxxx";
            String totalICMSVProd = "xxxxxxx";
            String totalICMSVFrete = "xxxxxxx";
            String totalICMSVSeg = "xxxxxxx";
            String totalICMSVDesc = "xxxxxxx";
            String totalICMSVII = "xxxxxxx";
            String totalICMSVIPI = "xxxxxxx";
            String totalICMSVPIS = "xxxxxxx";
            String totalICMSVFCP = "xxxxxxx";
            String totalICMSVCOFINS = "xxxxxxx";
            String totalICMSVFCPSTRet = "xxxxxxx";
            String totalICMSVOutro = "xxxxxxx";
            String totalICMSVFCPST = "xxxxxxx";
            String totalICMSVIPIDevol = "xxxxxxx";
            String totalICMSVNF = "xxxxxxx";

            /**
             *       transp
             *
             * */
            String transpModFrete = "xxxxxxx";
            /**
             *       pag
             *
             * */
            String pagDetTPag = "xxxxxxx";
            String pagDetVPag = "xxxxxxx";

            /**
             *       pag
             *
             * */
            String chave = "xxxxxxx";
            String id = "xxxxxxx" + chave;

            TEnviNFe tEnviNFe = new TEnviNFe();
            tEnviNFe.setIdLote("xxxxxxx");
            tEnviNFe.setIndSinc("xxxxxxx"); // 0 Assíncrono e 1 Síncrono.
            tEnviNFe.setVersao(versao);
            TNFe nfe = new TNFe();
            {
                TNFe.InfNFe infNFe = new TNFe.InfNFe();
                infNFe.setVersao(versao);
                infNFe.setId(id);
                {
                    TNFe.InfNFe.Ide ide = new TNFe.InfNFe.Ide();
                    ide.setCUF(cUf);
                    ide.setXJust(xJust);
                    ide.setDhCont(dhCont);
                    ide.setCNF(cNF);
                    ide.setNNF(numeroNota);
                    ide.setNatOp(natOp);
                    ide.setMod(mod);
                    ide.setDhEmi(dhEmi);
                    ide.setSerie(serie);
                    ide.setTpNF(tpNF);
                    ide.setIdDest(idDest);
                    ide.setCMunFG(cMunFG);
                    ide.setTpEmis(tpEmis);
                    ide.setTpImp(tpImp);
                    ide.setTpAmb(tpAmb);
                    ide.setFinNFe(finNFe);
                    ide.setIndFinal(indFinal);
                    ide.setIndPres(indPres);
                    ide.setVerProc(verProc);
                    ide.setProcEmi(procEmi);
                    infNFe.setIde(ide);
                }
                {
                    TNFe.InfNFe.Emit emit = new TNFe.InfNFe.Emit();
                    emit.setCRT(CRT);
                    emit.setXFant(xFant);
                    emit.setXNome(xNome);
                    emit.setCNPJ(CNPJ);
                    emit.setIE(IE);
                    {
                        TEnderEmi enderEmit = new TEnderEmi();
                        enderEmit.setXLgr(enderEmitXLgr);
                        enderEmit.setNro(enderEmitNro);
                        enderEmit.setXCpl(enderEmitXCpl);
                        enderEmit.setXBairro(enderEmitXBairro);
                        enderEmit.setCMun(enderEmitCMun);
                        enderEmit.setXMun(enderEmitXMun);
                        enderEmit.setUF(enderEmitUF);
                        enderEmit.setCEP(enderEmitCEP);
                        enderEmit.setCPais(enderEmitCPais);
                        enderEmit.setXPais(enderEmitXPais);
                        enderEmit.setFone(enderEmitFone);
                        emit.setEnderEmit(enderEmit);
                    }
                    infNFe.setEmit(emit);
                }

                {
                    TNFe.InfNFe.Det det = new TNFe.InfNFe.Det();
                    det.setNItem(produto1NItem);
                    {
                        TNFe.InfNFe.Det.Prod prod = new TNFe.InfNFe.Det.Prod();
                        prod.setCProd(produto1CProd);
                        prod.setCEAN(produto1CEAN);
                        prod.setXProd(produto1XProd);
                        prod.setNCM(produto1NCM);
                        prod.setCEST(produto1CEST);
                        prod.setCFOP(produto1CFOP);
                        prod.setUCom(produto1UCom);
                        prod.setQCom(produto1QCom);
                        prod.setVUnCom(produto1VUnCom);
                        prod.setVProd(produto1VProd);
                        prod.setCEANTrib(produto1CEANTrib);
                        prod.setUTrib(produto1UTrib);
                        prod.setQTrib(produto1QTrib);
                        prod.setVUnTrib(produto1VUnTrib);
                        prod.setIndTot(produto1IndTot);
                        det.setProd(prod);
                    }
                    {

                        TNFe.InfNFe.Det.Imposto imposto = new TNFe.InfNFe.Det.Imposto();
                        TNFe.InfNFe.Det.Imposto.ICMS icms = new TNFe.InfNFe.Det.Imposto.ICMS();
                        TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN500 icmssn500 = new TNFe.InfNFe.Det.Imposto.ICMS.ICMSSN500();
                        icmssn500.setOrig(produto1ImpostoICMSSN500Orig);
                        icmssn500.setCSOSN(produto1ImpostoICMSSN500CSOSN);
                        icms.setICMSSN500(icmssn500);
                        imposto.setICMS(icms);
                        det.setImposto(imposto);
                    }
                    infNFe.getDet().add(det);
                }
                {
                    TNFe.InfNFe.Total total = new TNFe.InfNFe.Total();
                    {
                        TNFe.InfNFe.Total.ICMSTot icmsTot = new TNFe.InfNFe.Total.ICMSTot();
                        icmsTot.setVBC(totalICMSVBC);
                        icmsTot.setVICMS(totalICMSVICMS);
                        icmsTot.setVICMSDeson(totalICMSVICMSDeson);
                        icmsTot.setVFCPUFDest(totalICMSVFCPUFDest);
                        icmsTot.setVICMSUFDest(totalICMSVICMSUFDest);
                        icmsTot.setVICMSUFRemet(totalICMSVICMSUFRemet);
                        icmsTot.setVBCST(totalICMSVBCST);
                        icmsTot.setVST(totalICMSVST);
                        icmsTot.setVProd(totalICMSVProd);
                        icmsTot.setVFrete(totalICMSVFrete);
                        icmsTot.setVSeg(totalICMSVSeg);
                        icmsTot.setVDesc(totalICMSVDesc);
                        icmsTot.setVII(totalICMSVII);
                        icmsTot.setVIPI(totalICMSVIPI);
                        icmsTot.setVPIS(totalICMSVPIS);
                        icmsTot.setVCOFINS(totalICMSVCOFINS);
                        icmsTot.setVOutro(totalICMSVOutro);
                        icmsTot.setVNF(totalICMSVNF);
                        icmsTot.setVFCP(totalICMSVFCP);
                        icmsTot.setVFCPST(totalICMSVFCPST);
                        icmsTot.setVFCPSTRet(totalICMSVFCPSTRet);
                        icmsTot.setVIPIDevol(totalICMSVIPIDevol);
                        total.setICMSTot(icmsTot);
                    }
                    infNFe.setTotal(total);
                }
                {
                    TNFe.InfNFe.Transp transp = new TNFe.InfNFe.Transp();
                    transp.setModFrete(transpModFrete);
                    infNFe.setTransp(transp);
                }
                {
                    TNFe.InfNFe.Pag pag = new TNFe.InfNFe.Pag();
                    {
                        TNFe.InfNFe.Pag.DetPag detPag = new TNFe.InfNFe.Pag.DetPag();
                        detPag.setTPag(pagDetTPag);
                        detPag.setVPag(pagDetVPag);
                        pag.getDetPag().add(detPag);
                    }
                    infNFe.setPag(pag);
                }

                nfe.setInfNFe(infNFe);
                nfe = sefaz.assinarNfce( nfe, idToken, csc);
                tEnviNFe.getNFe().add(nfe);
            }
            String urlQrCode = tEnviNFe.getNFe().get(0).getInfNFeSupl().getQrCode();
            // Duas maneiras de enviar 
            if (true){
                String xml = sefaz.toXml(tEnviNFe);
                Sefaz.Call<TRetEnviNFe> response = sefaz.nfeAutorizacao(xml);
                response.enqueue(new Sefaz.CallBack<TRetEnviNFe>() {
                    @Override
                    public void onResponse(TRetEnviNFe resposta, Response<ResponseBody> r) {
                        try {
                            if ( resposta.getProtNFe().getInfProt().getCStat().contentEquals("xxxxxxx")){

                                    List<TNfeProc> protNFeLista = sefaz.getProtNFeLista(xml, resposta);
                                    TNfeProc tNfeProc = protNFeLista.get(0);
                                    String tNfeProcXml = sefaz.toXml(tNfeProc);
                                    tNfeProcXml.toString();
                            }else {
                                String xMotivo = resposta.getProtNFe().getInfProt().getXMotivo();
                                System.out.println(xMotivo);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(Throwable e, Response<ResponseBody> r) {
                        e.printStackTrace();
                    }
                });
            }else {
                Sefaz.Call<TRetEnviNFe> response = sefaz.nfeAutorizacao(tEnviNFe);
                response.enqueue(new Sefaz.CallBack<TRetEnviNFe>() {
                    @Override
                    public void onResponse(TRetEnviNFe resposta, Response<ResponseBody> r) {
                        resposta.getProtNFe();
                        try {
                            List<TNfeProc> protNFeLista = sefaz.getProtNFeLista(tEnviNFe, resposta);
                            TNfeProc tNfeProc = protNFeLista.get(0);
                            String tNfeProcXml = sefaz.toXml(tNfeProc);
                            tNfeProcXml.toString();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Throwable e, Response<ResponseBody> r) {
                        e.printStackTrace();
                    }
                });


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void nfeStatusServico21Test(Sefaz sefaz){
        try {
            TConsStatServ tConsStatServ =new TConsStatServ();
            tConsStatServ.setCUF("33");
            tConsStatServ.setTpAmb(sefaz.getAmbiente().getCodigo());
            tConsStatServ.setXServ("STATUS");
            tConsStatServ.setVersao("4.00");
            Sefaz.Call<TRetConsStatServ> response = sefaz.nfeStatusServico(tConsStatServ);
            response.enqueue(new Sefaz.CallBack<TRetConsStatServ>() {
                @Override
                public void onResponse(TRetConsStatServ resposta, Response<ResponseBody> response) {
                    resposta.getCStat();
                }

                @Override
                public void onFailure(Throwable e, Response<ResponseBody> response) {
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```
