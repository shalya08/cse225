package com.ks.mproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button signin;
    Boolean saveLogin;
    SharedPreferences mSharedPreferences;
    SharedPreferences.Editor editor;
    CheckBox rememberMe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        signin = findViewById(R.id.button1);
        rememberMe = findViewById(R.id.checkbox1);

        mSharedPreferences = getSharedPreferences("loginref", MODE_PRIVATE);
        editor = mSharedPreferences.edit();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();
                if (email1.equals("test@gmail.com") && password1.equals("test123")){
                    Toast.makeText(MainActivity.this, "LogIn success!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,HomeActivity.class).putExtra("email", email1).putExtra("password", password1));
                    if(rememberMe.isChecked()){
                        editor.putBoolean("saveLogin1", true);
                        editor.putString("email", email1);
                        editor.putString("password",password1);
                        editor.apply();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Error! TRY AGAIN", Toast.LENGTH_LONG).show();
                }
            }
        });
        saveLogin = mSharedPreferences.getBoolean("saveLogin1",false);

        if(saveLogin){
            startActivity(new Intent(MainActivity.this,HomeActivity.class));
        }
    }
}
