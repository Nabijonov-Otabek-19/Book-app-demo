package com.example.exam1bookapp;

import android.content.Context;
import android.content.SharedPreferences;

public class BookBase {
    public static final String SHARED_PREF = "sharedPref";

    public static final String BOOK_NAME_1 = "bookName1";
    public static final String BOOK_NAME_2 = "bookName2";
    public static final String BOOK_NAME_3 = "bookName3";

    public static final String BOOK_AUTHOR_1 = "bookAuthor1";
    public static final String BOOK_AUTHOR_2 = "bookAuthor2";
    public static final String BOOK_AUTHOR_3 = "bookAuthor3";

    public static final String BOOK_DESC_1 = "bookDesc1";
    public static final String BOOK_DESC_2 = "bookDesc2";
    public static final String BOOK_DESC_3 = "bookDesc3";

    private static final String COUNT = "countBooks";

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    public BookBase(Context context) {
        pref = context.getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public void setBook(BookData bookData) {
        if (getCountBooks() == 0) {
            editor.putString(BOOK_NAME_1, bookData.getName()).apply();
            editor.putString(BOOK_AUTHOR_1, bookData.getAuthor()).apply();
            editor.putString(BOOK_DESC_1, bookData.getDescription()).apply();
            editor.putInt(COUNT, 1).apply();

        } else if (getCountBooks() == 1) {
            editor.putString(BOOK_NAME_2, bookData.getName()).apply();
            editor.putString(BOOK_AUTHOR_2, bookData.getAuthor()).apply();
            editor.putString(BOOK_DESC_2, bookData.getDescription()).apply();
            editor.putInt(COUNT, 2).apply();

        } else if (getCountBooks() == 2) {
            editor.putString(BOOK_NAME_3, bookData.getName()).apply();
            editor.putString(BOOK_AUTHOR_3, bookData.getAuthor()).apply();
            editor.putString(BOOK_DESC_3, bookData.getDescription()).apply();
            editor.putInt(COUNT, 3).apply();

        }
    }

    public int getCountBooks() {
        return pref.getInt(COUNT, 0);
    }

    // Barcha book name larini olish
    public String getBookName1() {
        return pref.getString(BOOK_NAME_1, "...");
    }

    public String getBookName2() {
        return pref.getString(BOOK_NAME_2, "...");
    }

    public String getBookName3() {
        return pref.getString(BOOK_NAME_3, "...");
    }


    // Barcha book Author larini olish
    public String getBookAuthor1() {
        return pref.getString(BOOK_AUTHOR_1, "...");
    }

    public String getBookAuthor2() {
        return pref.getString(BOOK_AUTHOR_2, "...");
    }

    public String getBookAuthor3() {
        return pref.getString(BOOK_AUTHOR_3, "...");
    }


    // Barcha book description larini olish
    public String getBookDesc1() {
        return pref.getString(BOOK_DESC_1, "...");
    }

    public String getBookDesc2() {
        return pref.getString(BOOK_DESC_2, "...");
    }

    public String getBookDesc3() {
        return pref.getString(BOOK_DESC_3, "...");
    }
}
