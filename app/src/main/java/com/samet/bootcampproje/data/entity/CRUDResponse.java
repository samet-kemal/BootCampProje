package com.samet.bootcampproje.data.entity;

import com.google.gson.annotations.SerializedName;

public class CRUDResponse {

    public int getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public CRUDResponse(int success, String message) {
        this.success = success;
        this.message = message;
    }

    @SerializedName("success")
    int success;
    @SerializedName("message")
    String message;


}
