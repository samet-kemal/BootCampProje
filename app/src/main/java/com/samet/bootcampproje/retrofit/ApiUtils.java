package com.samet.bootcampproje.retrofit;

public class ApiUtils {
   public static final String BASE_URL="http://kasimadalan.pe.hu/";
   public static final String KULLANICI_ADI="samet_kemal_asik";

   public static YemeklerDao getYemeklerDao(){
      return RetrofitClient.getClient(BASE_URL).create(YemeklerDao.class);
   }
}
