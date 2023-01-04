package com.samet.bootcampproje.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

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

        binding.setDetayFragmentTitle("Yemekler Detay");
        binding.toolbarDetayFragment.setTitleTextAppearance(getContext(),R.style.titleFont);
        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.toolbarDetayFragment);

        YemekDetayFragmentArgs bundle = YemekDetayFragmentArgs.fromBundle(getArguments());
        Yemekler seciliYemek = bundle.getSecilenYemek();
        binding.setYemekNesnesi(seciliYemek);
        binding.setYemekDetayFragment(this);
        adetGetir(1);

        String url= "http://kasimadalan.pe.hu/yemekler/resimler/";
        resimGetir(url,seciliYemek,binding.imageViewYemekDetay);

        binding.fabDetay.setOnClickListener(view->{
            sepeteEkle(seciliYemek);
        });

        binding.fabDetaySepet.setOnClickListener(view->{
            Navigation.findNavController(view).navigate(R.id.action_yemekDetayFragment_to_sepetFragment);

        });

        return binding.getRoot();
    }


    public void sepeteEkle(Yemekler eklenecekYemek){

        viewModel.yemekEkle(eklenecekYemek.getYemek_adi(),eklenecekYemek.getYemek_resim_adi(),eklenecekYemek.getYemek_fiyat(),Integer.parseInt(binding.textViewYemekAdet.getText().toString()));
        Toast.makeText(getContext(), eklenecekYemek.getYemek_adi()+"Sepetinize Eklendi" , Toast.LENGTH_SHORT).show();


    }

    public void resimGetir(String url,Yemekler yemek, ImageView imageView){
        Picasso.get().load(url+yemek.getYemek_resim_adi()).into(imageView);
    }

    public void adetArttir(String  currentValue){
        int currentInt=Integer.parseInt(currentValue);
        currentInt++;
        adetGetir(currentInt);

    }
    public void adetEksilt(String currentValue){
        int currentInt=Integer.parseInt(currentValue);
        if (currentInt>0){
            currentInt--;
        }else {
            currentInt=1;
        }
        adetGetir(currentInt);

    }

    public void adetGetir(int adet){
        binding.textViewYemekAdet.setText(String.valueOf(adet));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(YemekDetayViewModel.class);
    }
}