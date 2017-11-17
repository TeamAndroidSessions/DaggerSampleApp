package com.barnali.daggersample.network;

import android.content.Context;
import com.barnali.daggersample.activity.MainActivity;
import com.barnali.daggersample.annotations.BookComponent;
import com.barnali.daggersample.annotations.DaggerBookComponent;
import com.barnali.daggersample.model.DataModel;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by Barnali on 11/7/17.
 */

public class ApiClient {

    //https://api.myjson.com/bins/g79w7

    private static ApiClient apiClient;
    private BookComponent component;

    private ApiClient(){}

    public static ApiClient getInstance(){
        if(apiClient == null)
            apiClient  = new ApiClient();
        return apiClient;
    }


    public void executeBookInfoApi(final Context context){

        component = DaggerBookComponent.builder().build();
        Retrofit retrofit = component.retrofit();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<DataModel>> call = apiInterface.bookInfoApiCall();

        call.enqueue(new Callback<List<DataModel>>() {
            @Override
            public void onResponse(Call<List<DataModel>> call, Response<List<DataModel>> response) {
                System.out.println("response is success");
                List<DataModel> bookList = response.body();
                ((MainActivity)context).onBookApiCallSuccess(bookList);
            }

            @Override
            public void onFailure(Call<List<DataModel>> call, Throwable t) {
                System.out.println("response is failed");
                ((MainActivity)context).onBookApiCallFailure();
            }
        });
    }

}
