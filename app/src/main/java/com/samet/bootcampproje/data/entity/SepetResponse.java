package com.samet.bootcampproje.data.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class SepetResponse implements Serializable {

    public List<SepetYemekler> getYemekler() {
        return yemekler;
    }

    public void setYemekler(List<SepetYemekler> yemekler) {
        this.yemekler = yemekler;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public SepetResponse(List<SepetYemekler> yemekler, String success) {
        this.yemekler = yemekler;
        this.success = success;
    }

    @SerializedName("sepet_yemekler")
    private List<SepetYemekler> yemekler;
    @SerializedName("success")
    private String success ;
}
