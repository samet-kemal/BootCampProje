package com.samet.bootcampproje.retrofit;

import com.samet.bootcampproje.data.entity.SepetResponse;
import com.samet.bootcampproje.data.entity.YemeklerResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface YemeklerDao {

    @GET("yemekler/tumYemekleriGetir.php")
    Call<YemeklerResponse> yemekleriGetir();

    @POST("http://kasimadalan.pe.hu/yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    Call<SepetResponse> yemekEkle(@Field("yemek_adi") String yemek_adi,
                                  @Field("yemek_resim_adi") String yemek_resim_adi,
                                  @Field("yemek_fiyat") int yemek_fiyat,
                                  @Field("yemek_siparis_adet") int yemek_siparis_adet,
                                  @Field("kullanici_adi") String kullanici_adi);

    @POST("http://kasimadalan.pe.hu/yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    Call<SepetResponse> sepetiGetir(@Field("kullanici_adi") String kullanici_adi);







}
