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

        if (bookList.get(position).getTitle().contains("Harry Potter")) return 0;
        else return 1;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();
        int currentLayout = 0;
        RecyclerView.ViewHolder viewHolder = null;
        View view;
        switch (i) {
            case 0:
                currentLayout = R.layout.item_book_list;
                view = LayoutInflater.from(viewGroup.getContext()).inflate(currentLayout, null);
                viewHolder = new BookViewHolder(view);
                break;
            case 1:
                currentLayout = R.layout.item_book_list_image;
                view = LayoutInflater.from(viewGroup.getContext()).inflate(currentLayout, null);
                viewHolder = new BookImageViewHolder(view);
                break;
        }
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        final Book book = bookList.get(i);
//        viewHolder.getItemViewType()
        switch (viewHolder.getItemViewType()) {
            case 0:

                BookViewHolder bookViewHolder = (BookViewHolder) viewHolder;
                Glide.with(context)
                        .load(book.getImageURL())
                        .into(bookViewHolder.ivBook);
                bookViewHolder.tvTitle.setText(book.getTitle());

                break;
            case 1:
                BookImageViewHolder bookImageViewHolder = (BookImageViewHolder) viewHolder;
                Glide.with(context)
                        .load(book.getImageURL())
                        .into(bookImageViewHolder.ivBook);
                break;
        }
    }


    @Override
    public int getItemCount() {
        return bookList.size();
    }


    public void addAll(List<Book> books) {
        this.bookList.clear();
        this.bookList.addAll(books);
        notifyDataSetChanged();
    }
}
