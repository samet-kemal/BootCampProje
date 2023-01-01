package com.samet.bootcampproje.ui.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.samet.bootcampproje.data.entity.Yemekler;
import com.samet.bootcampproje.data.repo.YemeklerDaoRepo;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;


@HiltViewModel
public class YemekDetayViewModel extends ViewModel {
    private YemeklerDaoRepo yrepo;
    @Inject
    public YemekDetayViewModel(YemeklerDaoRepo yrepo){
        this.yrepo=yrepo;
   }

   public void yemekEkle(String yemek_adi,String yemek_resim_adi,int yemek_fiyat,int yemek_siparis_adet){
        yrepo.yemekEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet);
   }

}

