package com.samet.bootcampproje.data.repo;

import static com.samet.bootcampproje.retrofit.ApiUtils.KULLANICI_ADI;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.samet.bootcampproje.data.entity.SepetResponse;
import com.samet.bootcampproje.data.entity.Yemekler;
import com.samet.bootcampproje.data.entity.YemeklerResponse;
import com.samet.bootcampproje.retrofit.YemeklerDao;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class YemeklerDaoRepo {

    private MutableLiveData<List<Yemekler>> yemekListesi;
    private YemeklerDao yDao;
    private MutableLiveData<List<Yemekler>> sepetYemekler;

    public YemeklerDaoRepo(YemeklerDao yDao) {
        this.yDao = yDao;
        yemekListesi = new MutableLiveData();
        sepetYemekler=new MutableLiveData<>();

    }


    public MutableLiveData<List<Yemekler>> getSepetYemekler() {
        return sepetYemekler;
    }

    public MutableLiveData<List<Yemekler>> getYemekListesi() {
        return yemekListesi;
    }

    public YemeklerDao getyDao() {
        return yDao;
    }

    public void yemekleriYukle(){
        yDao.yemekleriGetir().enqueue(new Callback<YemeklerResponse>() {
            @Override
            public void onResponse(Call<YemeklerResponse> call, Response<YemeklerResponse> response) {
                Log.e("Yemekler",response.body().getYemekler().toString());
                List<Yemekler> tumYemekler = response.body().getYemekler();
                yemekListesi.setValue(tumYemekler);
            }

            @Override
            public void onFailure(Call<YemeklerResponse> call, Throwable t) {


            }
        });
    }

    public void yemekEkle(String yemek_adi,String yemek_resim_adi,int yemek_fiyat,int yemek_siparis_adet){
        yDao.yemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,KULLANICI_ADI).enqueue(new Callback<SepetResponse>() {
            @Override
            public void onResponse(Call<SepetResponse> call, Response<SepetResponse> response) {

                Log.e("YemekEkleCevap","Eklendi");

            }

            @Override
            public void onFailure(Call<SepetResponse> call, Throwable t) {
                Log.e("YemekEkleCevap","HATA VAR");

            }
        });
    }


    public void sepetiGetir(String kullanici_adi){

        yDao.sepetiGetir(kullanici_adi).enqueue(new Callback<SepetResponse>() {
            @Override
            public void onResponse(Call<SepetResponse> call, Response<SepetResponse> response) {
                Log.e("SepetYemekler",response.body().getYemekler().toString());
                List<Yemekler> sepetYemekler = response.body().getYemekler();
                yemekListesi.setValue(sepetYemekler);
            }

            @Override
            public void onFailure(Call<SepetResponse> call, Throwable t) {
                Log.e("SepetYemeklerHata",call.toString());

            }
        });
    }




}
