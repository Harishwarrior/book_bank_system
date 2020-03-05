package com.r2017.bookbank;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

class BookDatabase extends SQLiteAssetHelper {

    private static final String DB_NAME = "AndroidJSonDataBase";
    private static final int DB_VER = 1;


    BookDatabase(Context context) {
        super(context, DB_NAME, null, DB_VER);

    }

    List<Book> getBook() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"id", "Book_name", "Author_name"};
        String tableName = "AndroidJSonTable";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<Book> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setId(cursor.getInt(cursor.getColumnIndex("id")));
                book.setBookName(cursor.getString(cursor.getColumnIndex("Book_name")));
                book.setAuthorName(cursor.getString(cursor.getColumnIndex("Author_name")));
                result.add(book);
            } while (cursor.moveToNext());
        }
        return result;
    }

    List<String> getNames() {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"Book_name"};
        String tableName = "AndroidJSonTable";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<String> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                result.add(cursor.getString(cursor.getColumnIndex("Book_name")));
            } while (cursor.moveToNext());
        }
        return result;

    }

    List<Book> getBookByName(String name) {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"id", "Book_name", "Author_name"};
        String tableName = "AndroidJSonTable";

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, "Book_name LIKE ?", new String[]{"%" + name + "%"}, null, null, null);
        List<Book> result = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                Book book = new Book();
                book.setId(cursor.getInt(cursor.getColumnIndex("id")));
                book.setBookName(cursor.getString(cursor.getColumnIndex("Book_name")));
                book.setAuthorName(cursor.getString(cursor.getColumnIndex("Author_name")));
                result.add(book);
            } while (cursor.moveToNext());
        }
        return result;


    }
}
