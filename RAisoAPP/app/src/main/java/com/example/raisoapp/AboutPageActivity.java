package com.example.raisoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AboutPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);
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
