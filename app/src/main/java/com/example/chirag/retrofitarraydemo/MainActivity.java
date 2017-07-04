package com.example.chirag.retrofitarraydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.chirag.retrofitarraydemo.model.Example;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private String message;
    private ArrayList<Example> exampleArrayList = new ArrayList<>();
    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DataInterface dataInterface = retrofit.create(DataInterface.class);
        Call<ArrayList<Example>> arrayListCall = dataInterface.ARRAY_LIST_CALL();
        arrayListCall.enqueue(new Callback<ArrayList<Example>>() {
            @Override
            public void onResponse(Call<ArrayList<Example>> call, Response<ArrayList<Example>> response) {
                if (response.isSuccessful()) {
                    exampleArrayList =  response.body();
                    if (exampleArrayList != null) {
                        for (int i = 0; i < exampleArrayList.size(); i++) {
                            message = exampleArrayList.get(i).getTitle();
                            Log.d("tag", "onResponse: " + message);
                        }


                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Example>> call, Throwable t) {

            }
        });
    }
}



