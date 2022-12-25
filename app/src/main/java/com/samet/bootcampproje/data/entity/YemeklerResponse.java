package com.samet.bootcampproje.data.entity;

import com.google.gson.annotations.SerializedName;
import com.samet.bootcampproje.data.entity.Yemekler;

import java.util.List;

public class YemeklerResponse {

   @SerializedName("yemekler")
   private List<Yemekler> yemekler;
   @SerializedName("success")
   private String success ;

   public YemeklerResponse(List<Yemekler> yemekler, String success) {
      this.yemekler = yemekler;
      this.success = success;
   }

   public YemeklerResponse() {
   }

   public List<Yemekler> getYemekler() {
      return yemekler;
   }

   public void setYemekler(List<Yemekler> yemekler) {
      this.yemekler = yemekler;
   }

   public String getSuccess() {
      return success;
   }

   public void setSuccess(String success) {
      this.success = success;
   }
}
