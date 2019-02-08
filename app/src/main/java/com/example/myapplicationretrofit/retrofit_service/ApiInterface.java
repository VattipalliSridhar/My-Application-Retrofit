package com.example.myapplicationretrofit.retrofit_service;

import com.example.myapplicationretrofit.model_class.Image_Upload_With_Parameter;
import com.example.myapplicationretrofit.model_class.Register_Pojo_Post_Response;
import com.example.myapplicationretrofit.pojo.ExampleFinal;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface ApiInterface {


    @FormUrlEncoded
    @POST("api/register")
    Call<Register_Pojo_Post_Response> getResigterfrom(@Field("email") String email,
                                                      @Field("password") String password);

    @GET("BR_iOS_CodingExam_2015_Server/restaurants.json")
    Call<ExampleFinal> getRestaurantDetails();

    @Multipart
    @POST("completion_cirtificate.php?")
    Call<Image_Upload_With_Parameter> uploadFileWithOtherParamss(
            @Part("user_id") RequestBody description,
            @Part MultipartBody.Part image,
            @Part("form_id") RequestBody fid,
            @Part("ulb") RequestBody uid,
            @Part("time_submission_date") RequestBody tid,
            @Part("lattitude") RequestBody latt,
            @Part("langitude") RequestBody lgn

    );


}
