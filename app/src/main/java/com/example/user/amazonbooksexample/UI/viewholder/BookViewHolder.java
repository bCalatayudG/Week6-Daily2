package com.example.user.amazonbooksexample.UI.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.amazonbooksexample.R;

public class BookViewHolder extends RecyclerView.ViewHolder {

    public ImageView ivBook;
    public TextView tvTitle;

    public BookViewHolder(@NonNull View itemView){
        super (itemView);

        ivBook = itemView.findViewById(R.id.ivBook);
        tvTitle = itemView.findViewById(R.id.tvTitle);
    }

}
