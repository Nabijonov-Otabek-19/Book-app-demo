package com.example.exam1bookapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout no_book, yes_book;
    private TextView bookName1, bookName2, bookName3;
    private TextView bookAuthor1, bookAuthor2, bookAuthor3;
    private CardView book1, book2, book3;
    private BookBase bookBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadView();
        launchScreen();
    }

    private void loadView() {
        no_book = findViewById(R.id.ll_no_book);
        yes_book = findViewById(R.id.ll_yes_book);

        bookName1 = findViewById(R.id.txt_book_name1);
        bookName2 = findViewById(R.id.txt_book_name2);
        bookName3 = findViewById(R.id.txt_book_name3);

        bookAuthor1 = findViewById(R.id.txt_book_author1);
        bookAuthor2 = findViewById(R.id.txt_book_author2);
        bookAuthor3 = findViewById(R.id.txt_book_author3);

        book1 = findViewById(R.id.book_1);
        book2 = findViewById(R.id.book_2);
        book3 = findViewById(R.id.book_3);

        bookBase = new BookBase(this);

        findViewById(R.id.btn_add_no).setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, AddBookActivity.class)));

        findViewById(R.id.btn_add_yes).setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, AddBookActivity.class)));

        findViewById(R.id.book_1).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, BookReadActivity.class);

            intent.putExtra("bookName", bookName1.getText().toString());
            intent.putExtra("bookAuthor", bookAuthor1.getText().toString());
            intent.putExtra("bookDesc", bookBase.getBookDesc1());
            startActivity(intent);
        });

        findViewById(R.id.book_2).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, BookReadActivity.class);

            intent.putExtra("bookName", bookName2.getText().toString());
            intent.putExtra("bookAuthor", bookAuthor2.getText().toString());
            intent.putExtra("bookDesc", bookBase.getBookDesc2());
            startActivity(intent);
        });

        findViewById(R.id.book_3).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, BookReadActivity.class);

            intent.putExtra("bookName", bookName3.getText().toString());
            intent.putExtra("bookAuthor", bookAuthor3.getText().toString());
            intent.putExtra("bookDesc", bookBase.getBookDesc3());
            startActivity(intent);
        });
    }

    private void launchScreen() {

        if (bookBase.getCountBooks() == 0) {
            no_book.setVisibility(View.VISIBLE);
            yes_book.setVisibility(View.INVISIBLE);

        } else if (bookBase.getCountBooks() == 1) {
            no_book.setVisibility(View.INVISIBLE);
            yes_book.setVisibility(View.VISIBLE);
            setBook1();

        } else if (bookBase.getCountBooks() == 2) {
            no_book.setVisibility(View.INVISIBLE);
            yes_book.setVisibility(View.VISIBLE);
            setBook1();
            setBook2();

        } else if (bookBase.getCountBooks() == 3) {
            no_book.setVisibility(View.INVISIBLE);
            yes_book.setVisibility(View.VISIBLE);

            setBook1();
            setBook2();
            setBook3();
        }
    }

    private void setBook1() {
        book1.setVisibility(View.VISIBLE);
        bookName1.setText(bookBase.getBookName1());
        bookAuthor1.setText(bookBase.getBookAuthor1());

        book2.setVisibility(View.INVISIBLE);
        book3.setVisibility(View.INVISIBLE);
    }

    private void setBook2() {
        book2.setVisibility(View.VISIBLE);
        bookName2.setText(bookBase.getBookName2());
        bookAuthor2.setText(bookBase.getBookAuthor2());

        book3.setVisibility(View.INVISIBLE);
    }

    private void setBook3() {
        book3.setVisibility(View.VISIBLE);
        bookName3.setText(bookBase.getBookName3());
        bookAuthor3.setText(bookBase.getBookAuthor3());
    }
}