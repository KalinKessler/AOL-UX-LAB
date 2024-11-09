package com.example.raisoapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ItemDetailsActivityPenggaris extends AppCompatActivity {

    private TextView itemName, itemPrice, itemStock, buyErrorMsg;
    private ImageView itemImage;
    private EditText quantityTextField;
    private Button buyButton;
    private String price = "Rp. 10000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_detail_penggaris);

        itemName = findViewById(R.id.itemName);
        itemPrice = findViewById(R.id.itemPrice);
        itemStock = findViewById(R.id.itemStock);
        itemImage = findViewById(R.id.itemImage);
        quantityTextField = findViewById(R.id.quantityTextField);
        buyErrorMsg = findViewById(R.id.buyErrorMsg);
        buyButton = findViewById(R.id.buyButton);

        itemName.setText("Penggaris Besi");
        itemPrice.setText(price);
        itemStock.setText("Tersedia, 100 stock lagi");
        itemImage.setImageResource(R.drawable.image2);

        buyButton.setOnClickListener(v -> buyItem());

        buyButton.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    buyButton.setBackgroundColor(0xFF02A7F0);
                    break;
                case MotionEvent.ACTION_UP:
                    buyButton.setBackgroundColor(0xFFF59A23);
                    break;
            }
            return false;
        });

        findViewById(R.id.backLabel).setOnClickListener(view -> navigateToItemsPage());
        findViewById(R.id.backIcon).setOnClickListener(v -> navigateToItemsPage());
    }

    private void buyItem() {
        String quantityStr = quantityTextField.getText().toString();

        if (TextUtils.isEmpty(quantityStr)) {
            showErrorMsg("Jumlah pembelian harus diisi.");
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            showErrorMsg("Jumlah pembelian harus berupa angka.");
            return;
        }

        if (quantity <= 0) {
            showErrorMsg("Jumlah pembelian harus lebih dari 0.");
            return;
        }


        Toast.makeText(this, "Transaksi berhasil! Mengarahkan ke halaman item...", Toast.LENGTH_LONG).show();

        showSuccessDialog();

        navigateToItemsPage();
    }

    private void showErrorMsg(String msg) {
        buyErrorMsg.setText(msg);
        buyErrorMsg.setVisibility(View.VISIBLE);
    }

    private void showSuccessDialog() {
        new AlertDialog.Builder(this)
                .setTitle("Transaction Success!")
                .setMessage("Your purchase was successful.")
                .setPositiveButton("OK", (dialog, which) -> {
                    dialog.dismiss();
                })
                .show();
    }

    public void navigateToItemsPage() {
        Intent intent = new Intent(this, ItemsPageActivity.class);
        startActivity(intent);
        finish();
    }
}
