package com.example.user.amazonbooksexample.UI.booklist;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.user.amazonbooksexample.R;
import com.example.user.amazonbooksexample.UI.viewholder.BookImageViewHolder;
import com.example.user.amazonbooksexample.UI.viewholder.BookViewHolder;
import com.example.user.amazonbooksexample.model.Book;

import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Book> bookList;
    Context context;

    public BookListAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public int getItemViewType(int position) {
        // Just as an example, return 0 or 2 depending on position
        // Note that unlike in ListView adapters, types don't have to be contiguous
        return position % 2 * 2;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_book_list, null);
        this.context = viewGroup.getContext();
        if (i == 0)
            return new BookImageViewHolder(view);
        else
            return new BookViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final Book book = bookList.get(i);
//        viewHolder.getItemViewType()
        switch (viewHolder.getItemViewType()) {
            case 0:
                BookImageViewHolder bookImageViewHolder = (BookImageViewHolder) viewHolder;
                Glide.with(context)
                        .load(book.getImageURL())
                        .into(bookImageViewHolder.ivBook);
                break;
            case 2:
                BookViewHolder bookViewHolder = (BookViewHolder) viewHolder;
                Glide.with(context)
                        .load(book.getImageURL())
                        .into(bookViewHolder.ivBook);
                bookViewHolder.tvTitle.setText(book.getTitle());
                break;
        }


    }


    @Override
    public int getItemCount() {
        return bookList.size();
    }

    //Depending on the data that we are receiving, if the title Doesn't have HARRY POTTER
    //ViewModelProvider.AndroidViewModelFactory use this
    //Local Data source (ROOM) Limit of five minutes, more than that make a call.
}
