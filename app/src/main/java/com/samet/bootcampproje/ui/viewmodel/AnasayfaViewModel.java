package com.samet.bootcampproje.ui.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.samet.bootcampproje.data.entity.Yemekler;
import com.samet.bootcampproje.data.repo.YemeklerDaoRepo;

import java.io.Closeable;
import java.util.List;

public class AnasayfaViewModel extends ViewModel {

    private YemeklerDaoRepo yRepo;
    public MutableLiveData<List<Yemekler>> tumYemekler = new MutableLiveData<>();

    public AnasayfaViewModel(YemeklerDaoRepo yRepo, MutableLiveData<List<Yemekler>> tumYemekler) {
        this.yRepo = yRepo;
        yemekleriGetir();
        this.tumYemekler = tumYemekler;
    }

    public AnasayfaViewModel(YemeklerDaoRepo yRepo, MutableLiveData<List<Yemekler>> tumYemekler, @NonNull Closeable... closeables) {
        super(closeables);
        this.yRepo = yRepo;
        this.tumYemekler = tumYemekler;
    }


    public void yemekleriGetir(){
        yRepo.yemekleriYukle();
    }


}
