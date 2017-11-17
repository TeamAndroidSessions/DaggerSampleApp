package com.barnali.daggersample.annotations;

import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;

import com.barnali.daggersample.adapter.BookListRecyclerAdapter;

import dagger.Component;

/**
 * Created by Barnali on 11/14/17.
 */

@Component(modules = ActivityModule.class)
public interface AdapterComponent {

    LinearLayoutManager layoutMangerInstance();

    BookListRecyclerAdapter bookAdapterInstance();

    SharedPreferences getSharedInstance();
}
