package com.barnali.daggersample.annotations;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Barnali on 11/13/17.
 */

@Module
public class NetworkModule {

    @Provides HttpLoggingInterceptor getInterceptor(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    @Provides
    public OkHttpClient getOkHttpClientInstance(HttpLoggingInterceptor interceptor){
        return new OkHttpClient.Builder().
                addInterceptor(interceptor)
                .build();
    }

    @Provides
    public Retrofit getRetrofitInstance(OkHttpClient okHttpClient, Gson gson){
       return new Retrofit.Builder()
               .addConverterFactory(GsonConverterFactory.create(gson))
               .client(okHttpClient)
               .baseUrl("https://api.myjson.com")
               .build();
    }

    @Provides
    public Gson getGsonInstance(){
        return new GsonBuilder().create();
    }

}
