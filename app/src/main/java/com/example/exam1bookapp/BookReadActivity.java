package com.example.exam1bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BookReadActivity extends AppCompatActivity {

    private TextView bookName, bookAuthor, bookDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_read);

        loadBookDatas();
    }

    private void loadBookDatas() {
        bookName = findViewById(R.id.txt_bookName);
        bookAuthor = findViewById(R.id.txt_bookAuthor);
        bookDesc = findViewById(R.id.txt_bookDesc);

        Intent intent = getIntent();

        String name = intent.getStringExtra("bookName");
        String author = intent.getStringExtra("bookAuthor");
        String desc = intent.getStringExtra("bookDesc");

        bookName.setText(name);
        bookAuthor.setText(author);
        bookDesc.setText(desc);

        findViewById(R.id.btn_back).setOnClickListener(view -> BookReadActivity.this.finish());
    }
}