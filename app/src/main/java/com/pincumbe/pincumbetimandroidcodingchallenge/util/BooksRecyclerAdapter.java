package com.pincumbe.pincumbetimandroidcodingchallenge.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koushikdutta.ion.Ion;
import com.pincumbe.pincumbetimandroidcodingchallenge.R;
import com.pincumbe.pincumbetimandroidcodingchallenge.models.BookModel;

import java.util.List;

/**
 * Recycler View Adapter for the Ebay Books
 */

public class BooksRecyclerAdapter extends RecyclerView.Adapter<BookViewHolder> {
    private Context context;
    private List<BookModel> books;

    /**
     * Default constructor
     */
    public BooksRecyclerAdapter() {
    }

    /**
     * Main Constructor
     * @param context - Context needed to load the image with Ion
     * @param books - List of book objects
     */
    public BooksRecyclerAdapter(Context context, List<BookModel> books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        BookModel book = books.get(position);
        if (book.getImageURL() != null && !book.getImageURL().isEmpty()) {
            Ion.with(context)
                    .load(book.getImageURL())
                    .withBitmap()
                    .intoImageView(holder.thumbnailImage);
        }

        if (book.getTitle() != null && !book.getTitle().isEmpty()) {
            holder.titleText.setText(book.getTitle());
        }

        if (book.getAuthor() != null && !book.getAuthor().isEmpty()) {
            holder.authorText.setText(book.getAuthor());
        }
    }

    @Override
    public int getItemCount() {
        if (books != null) {
            return books.size();
        }
        return 0;
    }
}
