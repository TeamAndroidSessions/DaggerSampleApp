package com.barnali.daggersample.activity;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.barnali.daggersample.annotations.ActivityModule;
import com.barnali.daggersample.annotations.AdapterComponent;
import com.barnali.daggersample.annotations.BookComponent;
import com.barnali.daggersample.annotations.ContextModule;
import com.barnali.daggersample.annotations.DaggerAdapterComponent;
import com.barnali.daggersample.annotations.DaggerBookComponent;
import com.barnali.daggersample.callback.NetworkCallback;
import com.barnali.daggersample.R;
import com.barnali.daggersample.adapter.BookListRecyclerAdapter;
import com.barnali.daggersample.model.DataModel;
import com.barnali.daggersample.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NetworkCallback{

    private List<DataModel> mBookList;
    RecyclerView bookRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize view
        bookRecyclerView = (RecyclerView) findViewById(R.id.activity_main_bookList_RecyclerView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        ApiClient.getInstance().executeBookInfoApi(this);
    }

    @Override
    public void onBookApiCallFailure() {
        Toast.makeText(MainActivity.this, "Api request failed", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBookApiCallSuccess(List<DataModel> bookList) {
        this.mBookList = bookList;
        setBookListAdapter();
    }

    private void setBookListAdapter() {

        AdapterComponent component = DaggerAdapterComponent.builder()
                .contextModule(new ContextModule(this))
                .activityModule(new ActivityModule(mBookList))
                .build();

        SharedPreferences pref = component.getSharedInstance();
        SharedPreferences.Editor editor = pref.edit().putString("Data", "HELLO");
        editor.commit();

        bookRecyclerView.setLayoutManager(component.layoutMangerInstance());
        bookRecyclerView.setAdapter(component.bookAdapterInstance());

    }
}
