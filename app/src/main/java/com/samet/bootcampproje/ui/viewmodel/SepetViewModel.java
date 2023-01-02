package com.samet.bootcampproje.ui.viewmodel;

import static com.samet.bootcampproje.retrofit.ApiUtils.KULLANICI_ADI;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.samet.bootcampproje.data.entity.Yemekler;
import com.samet.bootcampproje.data.repo.YemeklerDaoRepo;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SepetViewModel extends ViewModel {
   private YemeklerDaoRepo yrepo;
   public MutableLiveData<List<Yemekler>> sepetYemekler = new MutableLiveData<>();


   @Inject
   public SepetViewModel(YemeklerDaoRepo yrepo) {
      this.yrepo = yrepo;
      String kullanici_adi=KULLANICI_ADI;
      sepetiGetir(kullanici_adi);
      this.sepetYemekler = yrepo.getSepetYemekler();


   }

   public void sepetiGetir(String kullanici_adi){
      yrepo.sepetiGetir(kullanici_adi);

   }

}
