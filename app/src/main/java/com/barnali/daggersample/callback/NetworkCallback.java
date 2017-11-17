package com.barnali.daggersample.callback;

import com.barnali.daggersample.model.DataModel;

import java.util.List;

/**
 * Created by Barnali on 11/14/17.
 */

public interface NetworkCallback {

    void onBookApiCallSuccess(List<DataModel> bookList);

    void onBookApiCallFailure();
}
