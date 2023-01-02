package com.samet.bootcampproje.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.samet.bootcampproje.R;
import com.samet.bootcampproje.data.entity.Yemekler;
import com.samet.bootcampproje.databinding.AnasayfaCardTasarimBinding;
import com.samet.bootcampproje.databinding.SepetCardTasarimBinding;
import com.samet.bootcampproje.ui.viewmodel.AnasayfaViewModel;
import com.samet.bootcampproje.ui.viewmodel.SepetViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SepetAdapter extends RecyclerView.Adapter<SepetAdapter.SepetCardViewHolder> {
    private Context mContext;
    private List<Yemekler> sepetYemekler;
    private SepetViewModel viewModel;

    public SepetAdapter(Context mContext, List<Yemekler> sepetYemekler, SepetViewModel viewModel) {
        this.mContext = mContext;
        this.sepetYemekler = sepetYemekler;
        this.viewModel = viewModel;
    }
    public class SepetCardViewHolder extends RecyclerView.ViewHolder {
        private SepetCardTasarimBinding binding;

        public SepetCardViewHolder(SepetCardTasarimBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
    @NonNull
    @Override
    public SepetCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SepetCardTasarimBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.sepet_card_tasarim,parent,false);
        return new SepetCardViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SepetCardViewHolder holder, int position) {

        Yemekler sepetYemek = sepetYemekler.get(position);
        SepetCardTasarimBinding t = holder.binding;

        t.setSepetYemekNesnesi(sepetYemek);

        String url= "http://kasimadalan.pe.hu/yemekler/resimler/";
        resimGetir(url,sepetYemek,t.imageViewSepetResim);

    }

    @Override
    public int getItemCount() {
        return sepetYemekler.size();
    }




    public void resimGetir(String url, Yemekler yemek, ImageView imageView){
        Picasso.get().load(url+yemek.getYemek_resim_adi()).into(imageView);
    }
}
