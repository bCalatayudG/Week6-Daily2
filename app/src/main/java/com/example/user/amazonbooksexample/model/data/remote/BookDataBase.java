package com.example.user.amazonbooksexample.model.data.remote;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.user.amazonbooksexample.model.Book;
import com.example.user.amazonbooksexample.model.BookDAO;

@Database(entities = Book.class, version = 1)
public abstract class BookDataBase extends RoomDatabase {
    public abstract BookDAO bookDAO();
}
