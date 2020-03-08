package com.r2017.bookbank;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LibrarianLogin extends AppCompatActivity {

    EditText Name;
    EditText Password;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_librarian_login);
        Name = findViewById(R.id.etLibUserName);
        Password = findViewById(R.id.etLibPass);
        Login = findViewById(R.id.btnLibLogin);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LibrarianLogin.this.validate(Name.getText().toString(), Password.getText().toString());
            }
        });


    }

    public void validate(String id, String pass) {
        if ((id.equals("admin")) && (pass.equals("aec@123"))) {
            Intent intent = new Intent(LibrarianLogin.this, LibrarianEntry.class);
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            startActivity(intent);

        } else {
            Toast.makeText(this, "Username or password incorrect", Toast.LENGTH_SHORT).show();
        }
    }

}
