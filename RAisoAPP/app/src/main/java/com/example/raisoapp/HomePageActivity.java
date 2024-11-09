package com.example.raisoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomePageActivity extends AppCompatActivity {

    private TextView userEmailLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        userEmailLabel = findViewById(R.id.userEmailLabel);

        String userEmail = LoginActivity.userEmail;
        userEmailLabel.setText(userEmail);
    }


    public void navigateToHomePage(View view) {
        Intent intent = new Intent(this, HomePageActivity.class);
        startActivity(intent);
    }

    public void navigateToItemsPage(View view) {
        Intent intent = new Intent(this, ItemsPageActivity.class);
        startActivity(intent);
    }

    public void navigateToAboutPage(View view) {
        Intent intent = new Intent(this, AboutPageActivity.class);
        startActivity(intent);
    }

    public void navigateToLoginPage(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
