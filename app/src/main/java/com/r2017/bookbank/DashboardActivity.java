package com.r2017.bookbank;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    String NameHolder;
    TextView Name;
    Button LogOUT, GetStarted;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Name = findViewById(R.id.tvHello);
        LogOUT = findViewById(R.id.logout);
        GetStarted = findViewById(R.id.btnGetStarted);

        Intent intent = getIntent();

        // Receiving User Email Send By MainActivity.
        NameHolder = intent.getStringExtra(MainActivity.userName);

        // Setting up received email to TextView.
        Name.setText(Name.getText().toString() + NameHolder);

        // Adding click listener to Log Out button.
        LogOUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                finish();

                Toast.makeText(DashboardActivity.this, "Log Out Successful", Toast.LENGTH_LONG).show();

            }
        });
        GetStarted.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              Intent intent1=new Intent(DashboardActivity.this,HomeActivity.class);
                                              startActivity(intent1);

                                          }
                                      }
        );


    }

}