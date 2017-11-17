package com.barnali.daggersample.annotations;

import android.support.v7.widget.LinearLayoutManager;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by Barnali on 11/13/17.
 */

@Component(modules = {NetworkModule.class})
public interface BookComponent {

    Retrofit retrofit();

}
