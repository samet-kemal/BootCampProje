package com.samet.bootcampproje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.samet.bootcampproje.databinding.ActivityMainBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());



    }
}