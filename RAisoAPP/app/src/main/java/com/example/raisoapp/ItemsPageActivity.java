package com.example.raisoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ItemsPageActivity extends AppCompatActivity {

    private TextView tabHotSeller, tabAllStationery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_page);

        tabHotSeller = findViewById(R.id.tabHotSeller);
        tabAllStationery = findViewById(R.id.tabAllStationery);

        showHotSellerStationeryTab(null);
    }

    public void showHotSellerStationeryTab(View view) {
        tabHotSeller.setTextColor(getResources().getColor(R.color.colorAccent));
        tabAllStationery.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

        Fragment hotSellerFragment = new HotSellerStationeryFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.tabContent, hotSellerFragment);
        transaction.commit();
    }

    public void showAllStationeryTab(View view) {
        tabAllStationery.setTextColor(getResources().getColor(R.color.colorAccent));
        tabHotSeller.setTextColor(getResources().getColor(R.color.colorPrimaryDark));

        Fragment allStationeryFragment = new AllStationeryFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.tabContent, allStationeryFragment);
        transaction.commit();
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
