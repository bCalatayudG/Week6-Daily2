package com.example.user.amazonbooksexample.UI.booklist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.user.amazonbooksexample.model.Book;
import com.example.user.amazonbooksexample.model.data.BookRepository;
import com.example.user.amazonbooksexample.model.data.local.LocalDataSource;
import com.example.user.amazonbooksexample.model.data.remote.RemoteDataSource;

import java.util.List;

public class BookListViewModel extends ViewModel {

    BookRepository bookRepository;

    public BookListViewModel(){
        bookRepository = new BookRepository(new RemoteDataSource(), new LocalDataSource());
    }

    public LiveData <List<Book>> getBooks(){
        return bookRepository.getBooks();
    }

}
