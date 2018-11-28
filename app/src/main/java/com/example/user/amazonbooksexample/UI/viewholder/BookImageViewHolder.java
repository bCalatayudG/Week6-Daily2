package com.example.user.amazonbooksexample.UI.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.user.amazonbooksexample.R;

public class BookImageViewHolder extends RecyclerView.ViewHolder {

    public ImageView ivBook;
    public BookImageViewHolder(@NonNull View itemView){
        super (itemView);

        ivBook = itemView.findViewById(R.id.ivBook);
    }
}
