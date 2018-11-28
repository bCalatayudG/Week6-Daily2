package com.example.user.amazonbooksexample.model.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.user.amazonbooksexample.model.Book;
import com.example.user.amazonbooksexample.model.data.local.LocalDataSource;
import com.example.user.amazonbooksexample.model.data.remote.RemoteDataSource;

import java.util.List;

public class BookRepository {

    MutableLiveData<List<Book>> listLiveData;
    RemoteDataSource remoteDataSource;
    LocalDataSource localDataSource;

    private static final String TAG = BookRepository.class.getSimpleName() + "_TAG";

    public BookRepository(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;

        listLiveData = new MutableLiveData<>();
    }

    public LiveData<List<Book>> getBooks(){
        // TODO: 11/27/2018 check for the time. Use user preferences to get the time.
        // Everytime you make a call.
        remoteDataSource.getBooks(new DataCallback() {
            @Override
            public void onSuccess(List<Book> bookList) {
                Log.d(TAG, "onSuccess: ");
                listLiveData.setValue(bookList);
            }

            @Override
            public void onFailure(String error) {
                Log.d(TAG, "onFailure: " +error);
            }
        });
        return listLiveData;
    }

}
