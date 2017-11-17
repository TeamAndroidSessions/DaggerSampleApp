package com.barnali.daggersample.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Barnali on 11/13/17.
 */

public class DataModel {

    @SerializedName("bookname")
    private String bookName;

    @SerializedName("authorname")
    private String authorName;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
