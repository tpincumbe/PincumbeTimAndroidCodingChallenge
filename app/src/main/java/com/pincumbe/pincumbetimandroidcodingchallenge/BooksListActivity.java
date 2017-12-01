package com.pincumbe.pincumbetimandroidcodingchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.reflect.TypeToken;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.pincumbe.pincumbetimandroidcodingchallenge.models.BookModel;
import com.pincumbe.pincumbetimandroidcodingchallenge.util.BooksRecyclerAdapter;

import java.util.Collections;
import java.util.List;

public class BooksListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        final RecyclerView recyclerView = findViewById(R.id.recycler_books);

        List<BookModel> books = Ion.with(getApplicationContext())
                .load("http://de-coding-test.s3.amazonaws.com/books.json")
                .as(new TypeToken<List<BookModel>>() {
                })
                .setCallback(new FutureCallback<List<BookModel>>() {
                    @Override
                    public void onCompleted(Exception e, List<BookModel> result) {
                        if (e != null) {
                            //TODO handle error
                        }else {
                            BooksRecyclerAdapter booksRecyclerAdapter = new BooksRecyclerAdapter(getApplicationContext(), result);
                            Collections.sort(result);
                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setAdapter(booksRecyclerAdapter);
                        }
                    }
                }).tryGet();

    }
}
