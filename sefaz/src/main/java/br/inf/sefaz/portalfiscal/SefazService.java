package br.inf.sefaz.portalfiscal;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface SefazService {
    @POST
    Call<ResponseBody> nfeStatusServico2(@Url String url , @Body RequestBody body);
    @POST
    Call<ResponseBody>  nfeAutorizacao(@Url String url , @Body RequestBody body);
}
