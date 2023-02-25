package com.example.exam1bookapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddBookActivity extends AppCompatActivity {

    private EditText bookName, bookAuthor, bookDesc;
    private BookBase bookBase;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        findViewById(R.id.btn_save).setOnClickListener(view -> {
            addBook();
            startActivity(new Intent(AddBookActivity.this, MainActivity.class));
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    private void addBook() {
        bookName = findViewById(R.id.edt_bookName);
        bookAuthor = findViewById(R.id.edt_bookAuthor);
        bookDesc = findViewById(R.id.edt_bookDesc);

        String name = bookName.getText().toString();
        String author = bookAuthor.getText().toString();
        String desc = bookDesc.getText().toString();

        bookBase = new BookBase(this);

        bookBase.setBook(new BookData(name, author, desc));
    }
}