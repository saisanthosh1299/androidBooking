package com.anurag.androidbooking;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class FinalViewActivity extends AppCompatActivity {
    Button logout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_view);

        logout = findViewById(R.id.logOutButton);
        logoutPressed();
    }
    public void logoutPressed() {
        System.out.println("log OUt pressed");
    }
}

