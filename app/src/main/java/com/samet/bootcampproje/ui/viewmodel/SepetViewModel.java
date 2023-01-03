package com.samet.bootcampproje.ui.viewmodel;

import static com.samet.bootcampproje.retrofit.ApiUtils.KULLANICI_ADI;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.samet.bootcampproje.data.entity.SepetYemekler;
import com.samet.bootcampproje.data.entity.Yemekler;
import com.samet.bootcampproje.data.repo.YemeklerDaoRepo;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SepetViewModel extends ViewModel {
   private YemeklerDaoRepo yrepo;
   public MutableLiveData<List<SepetYemekler>> sepetYemekler = new MutableLiveData<>();


   @Inject
   public SepetViewModel(YemeklerDaoRepo yrepo) {
      this.yrepo = yrepo;
      sepetiGetir(KULLANICI_ADI);
      this.sepetYemekler = yrepo.getSepetYemekler();


   }

   public void sepetiGetir(String kullanici_adi){
      yrepo.sepetiGetir(kullanici_adi);

   }

   public void sepettenSil(int sepet_yemek_id ){
      yrepo.sepettenSil(sepet_yemek_id,KULLANICI_ADI);

      sepetiGetir(KULLANICI_ADI);
   }

}
