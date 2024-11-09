package com.example.raisoapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText emailTextField;
    private EditText passwordTextField;
    private TextView emailErrorMsg;
    private TextView passwordErrorMsg;
    public static String userEmail;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailTextField = findViewById(R.id.emailTextField);
        passwordTextField = findViewById(R.id.passwordTextField);
        emailErrorMsg = findViewById(R.id.emailErrorMsg);
        passwordErrorMsg = findViewById(R.id.passwordErrorMsg);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(v -> validateLogin());

        loginButton.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case android.view.MotionEvent.ACTION_DOWN:
                    loginButton.setBackgroundColor(0xFF02A7F0);
                    break;
                case android.view.MotionEvent.ACTION_UP:
                    loginButton.setBackgroundColor(0xFFF59A23);
                    break;
            }
            return false;
        });
    }

    private void validateLogin() {
        boolean isValid = true;
        String email = emailTextField.getText().toString();
        String password = passwordTextField.getText().toString();

        if (TextUtils.isEmpty(email) || !email.contains(".")) {
            emailErrorMsg.setVisibility(View.VISIBLE);
            isValid = false;
        } else {
            emailErrorMsg.setVisibility(View.GONE);
        }

        if (TextUtils.isEmpty(password)) {
            passwordErrorMsg.setVisibility(View.VISIBLE);
            isValid = false;
        } else {
            passwordErrorMsg.setVisibility(View.GONE);
        }

        if (isValid) {
            userEmail = email;
            Toast.makeText(this, "Login successful! Redirecting to home page...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
            intent.putExtra("USER_EMAIL", userEmail);
            startActivity(intent);
        }

    }
}
