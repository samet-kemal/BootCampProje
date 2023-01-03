package com.samet.bootcampproje.data.entity;

import com.google.gson.annotations.SerializedName;

public class CRUDResponse {

    @SerializedName("success")
    String success;
    @SerializedName("message")
    String message;

    public String getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public CRUDResponse(String success, String message) {
        this.success = success;
        this.message = message;
    }
}
