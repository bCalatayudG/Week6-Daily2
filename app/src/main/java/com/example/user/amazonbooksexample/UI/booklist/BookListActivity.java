package com.example.user.amazonbooksexample.UI.booklist;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.user.amazonbooksexample.R;
import com.example.user.amazonbooksexample.model.Book;

import java.util.List;

public class BookListActivity extends AppCompatActivity {

    RecyclerView rvMain;
    List<Book> bookList;

    private static final String TAG = BookListActivity.class.getSimpleName() + "_TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BookListViewModel viewModel = ViewModelProviders.of(this).get(BookListViewModel.class);

        rvMain = findViewById(R.id.rvMain);
        viewModel.getBooks().observe(this, new Observer<List<Book>>() {

            @Override
            public void onChanged(@Nullable List<Book> books) {
                bookList = books;
                for(Book book:books) {
                    Log.d(TAG, "onChanged: " + book.toString());
                }
                BookListAdapter bookListAdapter = new BookListAdapter(bookList);
                rvMain.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                rvMain.setAdapter(bookListAdapter);
            }
        });

        //BookListAdapter bookListAdapter = new BookListAdapter(bookList);
        //rvMain.setLayoutManager(new LinearLayoutManager(this));
        //rvMain.setAdapter(bookListAdapter);

    }
}
