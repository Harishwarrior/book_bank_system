package com.r2017.bookbank;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

    static final String TABLE_NAME = "UserTable";
    static final String Table_Column_ID = "id";
    static final String Table_Column_1_Name = "name";
    static final String Table_Column_2_Email = "email";
    static final String Table_Column_3_Password = "password";
    static String DATABASE_NAME = "UserDataBase";

    SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " (" + Table_Column_ID + " INTEGER PRIMARY KEY, " + Table_Column_1_Name + " VARCHAR, " + Table_Column_2_Email + " VARCHAR, " + Table_Column_3_Password + " VARCHAR)";
        database.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

}