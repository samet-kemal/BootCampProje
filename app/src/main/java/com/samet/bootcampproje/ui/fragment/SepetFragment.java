package com.samet.bootcampproje.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.samet.bootcampproje.R;
import com.samet.bootcampproje.data.entity.Yemekler;
import com.samet.bootcampproje.databinding.FragmentSepetBinding;
import com.samet.bootcampproje.databinding.FragmentSepetBindingImpl;
import com.samet.bootcampproje.ui.adapter.SepetAdapter;
import com.samet.bootcampproje.ui.viewmodel.SepetViewModel;
import com.squareup.picasso.Picasso;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class SepetFragment extends Fragment {

    private FragmentSepetBinding binding;
    private SepetViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_sepet, container, false);


        viewModelGetir();




        binding.setSepetFragment(this);

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    public void viewModelGetir(){
        viewModel.sepetYemekler.observe(getViewLifecycleOwner(),sepetYemekler ->{

            SepetAdapter adapter = new SepetAdapter(requireContext(),sepetYemekler,viewModel);

            binding.setSepetAdapter(adapter);
        });
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SepetViewModel.class);
    }




}