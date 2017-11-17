package com.barnali.daggersample.annotations;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Barnali on 11/13/17.
 */

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @Provides
    public Context getContextInstance(){
        return context;
    }
}
