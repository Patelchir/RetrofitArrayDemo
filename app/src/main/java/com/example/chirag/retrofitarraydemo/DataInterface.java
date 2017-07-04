package com.example.chirag.retrofitarraydemo;

import com.example.chirag.retrofitarraydemo.model.Example;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by chirag on 28-Jun-17.
 */

public interface DataInterface {

    @GET("/posts")
    Call<ArrayList<Example>> ARRAY_LIST_CALL();
}
