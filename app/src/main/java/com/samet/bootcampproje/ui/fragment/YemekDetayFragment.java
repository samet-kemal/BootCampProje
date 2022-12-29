package com.samet.bootcampproje.ui.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.samet.bootcampproje.R;
import com.samet.bootcampproje.data.entity.Yemekler;
import com.samet.bootcampproje.databinding.FragmentYemekDetayBinding;


public class YemekDetayFragment extends Fragment {

    private FragmentYemekDetayBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_yemek_detay, container, false);

        YemekDetayFragmentArgs bundle = YemekDetayFragmentArgs.fromBundle(getArguments());
        Yemekler seciliYemek = bundle.getSecilenYemek();
        binding.setYemekNesnesi(seciliYemek);

        return binding.getRoot();
    }


    public void sepeteEkle(Yemekler eklenecekYemek){

    }

}