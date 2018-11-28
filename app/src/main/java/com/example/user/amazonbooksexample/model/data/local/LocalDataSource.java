package com.example.user.amazonbooksexample.model.data.local;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.user.amazonbooksexample.model.Book;
import com.example.user.amazonbooksexample.model.BookDAO;
import com.example.user.amazonbooksexample.model.data.remote.BookDataBase;
import com.example.user.amazonbooksexample.model.data.remote.DataCallback;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class LocalDataSource {

    Context context;
    BookDataBase bookDataBase;
    BookDAO bookDAO;

    public LocalDataSource(Context context) {
        this.context = context;

        bookDataBase = Room.databaseBuilder(context, BookDataBase.class, "Book Database").build();

        bookDAO = bookDataBase.bookDAO();
    }

    @SuppressLint("CheckResult")
    public void getBooks(final DataCallback callback) {
        bookDAO.getAllBook()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<Book>>() {
                    @Override
                    public void accept(List<Book> books) throws Exception {
                        callback.onSuccess(books);
                    }
                });
    }

    @SuppressLint("CheckResult")
    public void saveBook(final Book book) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                bookDAO.saveBook(book);
            }
        }).subscribeOn(Schedulers.io()).subscribe();
    }

    public void saveAllBook(final List<Book> bookList) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                bookDAO.saveAllBook(bookList);
            }
        }).subscribeOn(Schedulers.io()).subscribe(); //To do it asynchronous
    }

}
