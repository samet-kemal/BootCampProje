package com.samet.bootcampproje.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

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

    public YemeklerDaoRepo(YemeklerDao yDao) {
        this.yDao = yDao;
        yemekListesi = new MutableLiveData();
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



}
