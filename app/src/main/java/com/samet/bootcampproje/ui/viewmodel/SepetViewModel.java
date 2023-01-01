package com.samet.bootcampproje.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.samet.bootcampproje.data.repo.YemeklerDaoRepo;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class SepetViewModel extends ViewModel {
   private YemeklerDaoRepo yrepo;

   @Inject
   public SepetViewModel(YemeklerDaoRepo yrepo) {
      this.yrepo = yrepo;
   }
}
