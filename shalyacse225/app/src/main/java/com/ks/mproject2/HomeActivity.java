package com.ks.mproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv1 = findViewById(R.id.tv22);
        tv2 = findViewById(R.id.tv23);

        Intent in = getIntent();
        String email = in.getStringExtra("email");
        String password = in.getStringExtra("password");
        tv1.setText(email);
        tv2.setText(password);

        Button clear = findViewById(R.id.button21);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(HomeActivity.this, "Shared Preferences REMOVED!", Toast.LENGTH_LONG).show();
                SharedPreferences settings = getSharedPreferences("loginref", MODE_PRIVATE);
                settings.edit().clear().apply();
            }
        });
    }
}
