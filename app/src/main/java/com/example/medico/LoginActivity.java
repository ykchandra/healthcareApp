package com.example.medico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText edUsername;
    EditText edPassword;
    TextView tv;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername=findViewById(R.id.editTextLTBFullname);
        edPassword=findViewById(R.id.editTextLoginPassword);
        btn= findViewById(R.id.buttonBMCartBack);
        tv=findViewById(R.id.textViewExistingUser);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                String username=edUsername.getText().toString();
                String password=edPassword.getText().toString();
                Database db=new Database(getApplicationContext(),"healthcare", null, 1);

                if (username.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(), "Incorrect Username or password", Toast.LENGTH_SHORT).show();
                }else {
                    if (db.login(username,password)==1){
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();

                        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor= sharedPreferences.edit();
                        editor.putString("username", username);
                        editor.apply();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                }else {
                        Toast.makeText(getApplicationContext(),"Invalid Username and password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }
}