package com.r2017.bookbank;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RequestActivity extends AppCompatActivity {
    TextView bookName, authorName;
    Button reqBook;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        bookName = findViewById(R.id.etReqBook);
        authorName = findViewById(R.id.etReqAuthor);
        reqBook = findViewById(R.id.btnRequest);

        reqBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Added to request List", Toast.LENGTH_LONG).show();
            }
        });
    }
}
