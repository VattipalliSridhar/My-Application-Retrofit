package com.example.myapplicationretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.myapplicationretrofit.model_class.Register_Pojo_Post_Response;
import com.example.myapplicationretrofit.pojo.ExampleFinal;
import com.example.myapplicationretrofit.pojo.Restaurant;
import com.example.myapplicationretrofit.recycler_click_listener.ClickListener;
import com.example.myapplicationretrofit.recycler_click_listener.RecyclerTouchListener;
import com.example.myapplicationretrofit.recycleradapter.RecyclerViewAdapter;
import com.example.myapplicationretrofit.retrofit_service.APIClient;
import com.example.myapplicationretrofit.retrofit_service.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;

    public static List<ExampleFinal.Restaurant> restaurantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = APIClient.getClient().create(ApiInterface.class);


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        LinearLayoutManager mLManager_efct1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLManager_efct1);
        recyclerView.setHasFixedSize(true);

        // Register_Post_Response();

        Restaurant_Details();

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(MainActivity.this,
                recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {

                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

    }

    private void Restaurant_Details() {
        // Use default converter factory, so parse response body text to okhttp3.ResponseBody object.
        Call<ExampleFinal> exampleFinalCall = apiInterface.getRestaurantDetails();
        // Create a Callback object, because we do not set JSON converter, so the return object is ResponseBody be default.
        exampleFinalCall.enqueue(new Callback<ExampleFinal>() {
            /* When server response. */
            @Override
            public void onResponse(Call<ExampleFinal> call, Response<ExampleFinal> response) {
                ExampleFinal exampleFinal = response.body();
                restaurantList = exampleFinal.getRestaurants();
                Log.e("msg", "   " + restaurantList.size() + "  " + restaurantList.get(0).getLocation().getFormattedAddress().get(0));
                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, restaurantList);
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<ExampleFinal> call, Throwable t) {

            }
        });
    }

    private void Register_Post_Response() {

        Call<Register_Pojo_Post_Response> register_pojo_post_responseCall = apiInterface.getResigterfrom("sydney@fife", "pistol");
        register_pojo_post_responseCall.enqueue(new Callback<Register_Pojo_Post_Response>() {
            @Override
            public void onResponse(Call<Register_Pojo_Post_Response> call, Response<Register_Pojo_Post_Response> response) {
                Register_Pojo_Post_Response register_pojo_post_response = response.body();
                Log.e("msg ", "" + register_pojo_post_response.getToken());

            }

            @Override
            public void onFailure(Call<Register_Pojo_Post_Response> call, Throwable t) {

            }
        });
    }
}
