package com.samet.bootcampproje.ui.adapter;

import static com.samet.bootcampproje.retrofit.ApiUtils.KULLANICI_ADI;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.samet.bootcampproje.R;
import com.samet.bootcampproje.data.entity.SepetYemekler;
import com.samet.bootcampproje.data.entity.Yemekler;
import com.samet.bootcampproje.databinding.AnasayfaCardTasarimBinding;
import com.samet.bootcampproje.databinding.SepetCardTasarimBinding;
import com.samet.bootcampproje.ui.viewmodel.AnasayfaViewModel;
import com.samet.bootcampproje.ui.viewmodel.SepetViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SepetAdapter extends RecyclerView.Adapter<SepetAdapter.SepetCardViewHolder> {
    private Context mContext;
    private List<SepetYemekler> sepetYemekler;
    private SepetViewModel viewModel;

    public SepetAdapter(Context mContext, List<SepetYemekler> sepetYemekler, SepetViewModel viewModel) {
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
        LayoutInflater layoutInflater=LayoutInflater.from(mContext);

        SepetCardTasarimBinding binding =
                DataBindingUtil.inflate(layoutInflater,R.layout.sepet_card_tasarim,parent,false);

        if (sepetYemekler.isEmpty()){
            Toast.makeText(mContext, "Sepetinizde ??r??n Bulunmamaktat??d", Toast.LENGTH_LONG).show();
        }
        return new SepetCardViewHolder(binding);
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onBindViewHolder(@NonNull SepetCardViewHolder holder, int position) {

        SepetYemekler sepetYemek = sepetYemekler.get(position);
        SepetCardTasarimBinding t = holder.binding;

        if (sepetYemekler.isEmpty()){

            Toast.makeText(mContext, "Sepetinizde ??r??n Bulunmamaktat??d", Toast.LENGTH_LONG).show();
        }else{
            t.setSepetYemekNesnesi(sepetYemek);

        }

        String url= "http://kasimadalan.pe.hu/yemekler/resimler/";
        resimGetir(url,sepetYemek,t.imageViewSepetResim);


        t.imageViewSepetSil.setOnClickListener(view ->{


                Snackbar.make(view,sepetYemek.getYemek_adi()+"Sepetten Silinsin mi?",Snackbar.LENGTH_LONG)
                        .setAction("EVET",view1->{

                            viewModel.sepettenSil(sepetYemek.getSepet_yemek_id());
                            notifyItemRemoved(sepetYemek.getSepet_yemek_id());

                            if (sepetYemekler.size()==1){
                                sepetYemekler.clear();
                                viewModel.sepetiGetir(KULLANICI_ADI);
                                int mevcutAdet=sepetYemek.getYemek_siparis_adet();
                                mevcutAdet=mevcutAdet-1;
                                t.textViewSepetAdet.setText(String.valueOf(mevcutAdet));

                                if (mevcutAdet <=0){
                                    sepetYemekler.clear();
                                    viewModel.sepetiGetir(KULLANICI_ADI);
                                }
                            }

                        }).show();






        });

    }

    @Override
    public int getItemCount() {
        return sepetYemekler.size();
    }




    public void resimGetir(String url, SepetYemekler yemek, ImageView imageView){
        Picasso.get().load(url+yemek.getYemek_resim_adi()).into(imageView);
    }
}
