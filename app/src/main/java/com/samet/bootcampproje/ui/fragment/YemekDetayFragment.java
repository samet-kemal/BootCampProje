package com.samet.bootcampproje.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.samet.bootcampproje.R;
import com.samet.bootcampproje.data.entity.Yemekler;
import com.samet.bootcampproje.databinding.FragmentYemekDetayBinding;
import com.samet.bootcampproje.ui.viewmodel.YemekDetayViewModel;
import com.squareup.picasso.Picasso;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class YemekDetayFragment extends Fragment {

    private FragmentYemekDetayBinding binding;
    private YemekDetayViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_yemek_detay, container, false);

        YemekDetayFragmentArgs bundle = YemekDetayFragmentArgs.fromBundle(getArguments());
        Yemekler seciliYemek = bundle.getSecilenYemek();
        binding.setYemekNesnesi(seciliYemek);
        binding.setYemekDetayFragment(this);

        String url= "http://kasimadalan.pe.hu/yemekler/resimler/";
        resimGetir(url,seciliYemek,binding.imageViewYemekDetay);

        binding.fabDetay.setOnClickListener(view->{
            sepeteEkle(seciliYemek);
        });

        return binding.getRoot();
    }


    public void sepeteEkle(Yemekler eklenecekYemek){

        viewModel.yemekEkle(eklenecekYemek.getYemek_adi(),eklenecekYemek.getYemek_resim_adi(),eklenecekYemek.getYemek_fiyat(),1);

    }

    public void resimGetir(String url,Yemekler yemek, ImageView imageView){
        Picasso.get().load(url+yemek.getYemek_resim_adi()).into(imageView);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(YemekDetayViewModel.class);
    }
}