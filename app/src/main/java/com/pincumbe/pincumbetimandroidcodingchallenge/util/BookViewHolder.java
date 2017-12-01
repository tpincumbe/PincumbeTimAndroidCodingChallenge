package com.pincumbe.pincumbetimandroidcodingchallenge.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pincumbe.pincumbetimandroidcodingchallenge.R;

/**
 * ViewHolder for a book
 */
class BookViewHolder extends RecyclerView.ViewHolder {
    ImageView thumbnailImage;
    TextView titleText, authorText;

    BookViewHolder(View view) {
        super(view);
        this.thumbnailImage = view.findViewById(R.id.image_book);
        this.titleText = view.findViewById(R.id.text_title);
        this.authorText = view.findViewById(R.id.text_author);
    }
}
