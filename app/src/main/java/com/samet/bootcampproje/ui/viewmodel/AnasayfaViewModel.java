package com.samet.bootcampproje.ui.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.samet.bootcampproje.data.entity.Yemekler;
import com.samet.bootcampproje.data.repo.YemeklerDaoRepo;

import java.io.Closeable;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AnasayfaViewModel extends ViewModel {

    private YemeklerDaoRepo yRepo;
    public MutableLiveData<List<Yemekler>> tumYemekler = new MutableLiveData<>();

    @Inject
    public AnasayfaViewModel(YemeklerDaoRepo yRepo) {
        this.yRepo = yRepo;
        yemekleriGetir();
        this.tumYemekler = yRepo.getYemekListesi();
    }


    public void yemekleriGetir(){
        yRepo.yemekleriYukle();
    }


}
