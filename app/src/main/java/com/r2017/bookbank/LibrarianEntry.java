package com.r2017.bookbank;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LibrarianEntry extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabaseObj;
    EditText editTextBookName, editTextAuthorName;
    String BookHolder, AuthorHolder, SQLiteDataBaseQueryHolder;
    Button EnterData;
    Boolean EditTextEmptyHold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_librarian_entry);

        EnterData = findViewById(R.id.btnAddBook);
        editTextBookName = findViewById(R.id.etBookName);
        editTextAuthorName = findViewById(R.id.etAuthorName);

        EnterData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                SQLiteDataBaseBuild();

                SQLiteTableBuild();

                CheckEditTextStatus();

                InsertDataIntoSQLiteDatabase();

                EmptyEditTextAfterDataInsert();


            }
        });


    }

    public void SQLiteDataBaseBuild(){

        sqLiteDatabaseObj = openOrCreateDatabase("AndroidJSonDataBase", Context.MODE_PRIVATE, null);

    }

    public void SQLiteTableBuild(){

        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS AndroidJSonTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Book_name VARCHAR, Author_name VARCHAR);");

    }

    public void CheckEditTextStatus(){

        BookHolder = editTextBookName.getText().toString() ;
        AuthorHolder = editTextAuthorName.getText().toString();

        EditTextEmptyHold = !TextUtils.isEmpty(BookHolder) && !TextUtils.isEmpty(AuthorHolder);
    }

    public void InsertDataIntoSQLiteDatabase(){

        if(EditTextEmptyHold)
        {

            SQLiteDataBaseQueryHolder = "INSERT INTO AndroidJSonTable (Book_name,Author_name) VALUES('"+BookHolder+"', '"+AuthorHolder+"');";

            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);

            Toast.makeText(LibrarianEntry.this,"Data Inserted Successfully", Toast.LENGTH_LONG).show();

        }
        else
            Toast.makeText(LibrarianEntry.this, "Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

    }

    public void EmptyEditTextAfterDataInsert(){

        editTextBookName.getText().clear();

        editTextAuthorName.getText().clear();

    }

}