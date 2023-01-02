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

import com.samet.bootcampproje.R;
import com.samet.bootcampproje.databinding.FragmentAnasayfaBinding;
import com.samet.bootcampproje.ui.adapter.YemekListeAdapter;
import com.samet.bootcampproje.ui.viewmodel.AnasayfaViewModel;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class AnasayfaFragment extends Fragment {

    private FragmentAnasayfaBinding binding;
    private AnasayfaViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false);
        binding.setAnasayfaFragmentTitle("YemekUygulamassı");
        ((AppCompatActivity)getActivity()).setSupportActionBar(binding.toolbarAnasayfaFragment);



        viewModel.tumYemekler.observe(getViewLifecycleOwner(),yemeklers -> {
            YemekListeAdapter adapter = new YemekListeAdapter(requireContext(),yemeklers,viewModel);
            binding.setYemeklerAdapter(adapter);
        });

        binding.fabAnasayfaSepet.setOnClickListener(view->{
            Navigation.findNavController(view).navigate(R.id.action_anasayfaFragment_to_sepetFragment);
        });



        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AnasayfaViewModel.class);

    }
}