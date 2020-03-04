package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MY_PREF_FILENAME = "com.example.sharedpreferences.Names";

    EditText mName;
    TextView mWelcome;
    Button mSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = findViewById(R.id.etName);
        mSubmit = findViewById(R.id.btnSubmit);
        mWelcome = findViewById(R.id.textWelcome);

        SharedPreferences preferences = getSharedPreferences("MY_PREF_FILENAME", MODE_PRIVATE);
        String username = preferences.getString("user","");
        mWelcome.setText("Welcome to my app " + username +"!");

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mName.getText().toString();
                mWelcome.setText("Welcome to my app " + name +"!");

                SharedPreferences.Editor editor = getSharedPreferences("MY_PREF_FILENAME",MODE_PRIVATE).edit();
                editor.putString("user", name);
                editor.commit();
            }
        });
    }
}
