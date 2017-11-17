package com.barnali.daggersample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.barnali.daggersample.R;
import com.barnali.daggersample.model.DataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Barnali on 11/2/17.
 */

public class BookListRecyclerAdapter extends RecyclerView.Adapter<BookListRecyclerAdapter.CustomViewHolder>{

    private Context context;
    private List<DataModel> dataList;

    public BookListRecyclerAdapter(Context context, List<DataModel> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.bookNameTextView.setText(dataList.get(position).getBookName());
        holder.authorNameTextView.setText(dataList.get(position).getAuthorName());
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(rowView);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CustomViewHolder extends RecyclerView.ViewHolder{

        public TextView bookNameTextView, authorNameTextView;

        public CustomViewHolder(View view){
            super(view);
            bookNameTextView = view.findViewById(R.id.book_name);
            authorNameTextView = view.findViewById(R.id.author_name);
        }
    }
}
