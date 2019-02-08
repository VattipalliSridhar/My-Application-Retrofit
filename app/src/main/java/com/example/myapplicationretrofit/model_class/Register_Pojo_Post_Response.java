package com.example.myapplicationretrofit.model_class;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Register_Pojo_Post_Response {

    @SerializedName("token")
    @Expose
    public String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
