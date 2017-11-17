package com.barnali.daggersample.annotations;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;

import com.barnali.daggersample.adapter.BookListRecyclerAdapter;
import com.barnali.daggersample.model.DataModel;

import java.util.List;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Barnali on 11/14/17.
 */

@Module(includes = ContextModule.class)
public class ActivityModule {

    private List<DataModel> dataModelList;

    public ActivityModule(List<DataModel> dataModelList){
        this.dataModelList = dataModelList;
    }

    @Provides
    LinearLayoutManager getLayoutManger(Context context){
        return new LinearLayoutManager(context);
    }

    @Provides
    BookListRecyclerAdapter getBookAdapter(Context context){
       return new BookListRecyclerAdapter(context, dataModelList);
    }

    @Provides
    SharedPreferences getSharedInsObj(Context context){
        return context.getSharedPreferences("share", Context.MODE_PRIVATE);
    }
}
