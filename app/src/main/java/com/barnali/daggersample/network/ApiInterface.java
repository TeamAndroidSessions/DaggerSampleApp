package com.barnali.daggersample.network;

import com.barnali.daggersample.model.DataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Barnali on 11/2/17.
 */

public interface ApiInterface {

    @GET("/bins/g79w7")
    Call<List<DataModel>> bookInfoApiCall();

}
