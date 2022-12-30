package com.samet.bootcampproje.retrofit;

import com.samet.bootcampproje.data.entity.YemeklerResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface YemeklerDao {

    @GET("yemekler/tumYemekleriGetir.php")
    Call<YemeklerResponse> yemekleriGetir();





}
