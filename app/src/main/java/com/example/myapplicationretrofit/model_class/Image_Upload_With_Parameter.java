package com.example.myapplicationretrofit.model_class;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image_Upload_With_Parameter {

    @SerializedName("status_code")
    @Expose
    private Integer statusCode;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
