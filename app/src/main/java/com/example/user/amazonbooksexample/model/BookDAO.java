package com.example.user.amazonbooksexample.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.user.amazonbooksexample.model.Book;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface BookDAO {

    @Insert
    void saveBook(Book book);

    @Insert
    void saveAllBook(List<Book> book);

    @Query("Select * from Book")
    Flowable<List<Book>> getAllBook ();

    // TODO: 11/28/2018 Delate table 
}
