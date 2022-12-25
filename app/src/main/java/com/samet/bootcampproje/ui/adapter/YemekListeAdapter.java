package com.samet.bootcampproje.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.samet.bootcampproje.R;
import com.samet.bootcampproje.data.entity.Yemekler;
import com.samet.bootcampproje.databinding.AnasayfaCardTasarimBinding;
import com.samet.bootcampproje.ui.viewmodel.AnasayfaViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class YemekListeAdapter extends RecyclerView.Adapter<YemekListeAdapter.CardViewHolder>  {
    private Context mContext;
    private List<Yemekler> tumYemekler;
    private AnasayfaViewModel viewModel;

    public YemekListeAdapter(Context mContext, List<Yemekler> tumYemekler,AnasayfaViewModel viewModel) {
        this.mContext = mContext;
        this.tumYemekler = tumYemekler;
        this.viewModel=viewModel;
    }
    public class CardViewHolder extends RecyclerView.ViewHolder{

        private AnasayfaCardTasarimBinding binding;

        public CardViewHolder(AnasayfaCardTasarimBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        AnasayfaCardTasarimBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.anasayfa_card_tasarim,parent,false);



        return new CardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {

        Yemekler yemek = tumYemekler.get(position);
        AnasayfaCardTasarimBinding t = holder.binding;
        t.setYemekNesnesi(yemek);
        String url= "http://kasimadalan.pe.hu/yemekler/resimler/";
        Picasso.get().load(url+yemek.getYemek_resim_adi()).into(t.imageViewYemekResim);


        t.yemekCard.setOnClickListener(view->{



        });



    }

    @Override
    public int getItemCount() {
        return tumYemekler.size();
    }

}


