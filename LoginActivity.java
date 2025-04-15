package com.example.finance_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Ініціалізація
        etEmail = findViewById(R.id.text1);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLoginSubmit);

        databaseHelper = new DatabaseHelper(this);

        // Обробка натискання кнопки "Вхід"
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                if (databaseHelper.checkUser(email, password)) {
                    Toast.makeText(LoginActivity.this, "Успішний вхід!", Toast.LENGTH_SHORT).show();
                    // Перехід на головну сторінку або інший екран
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Невірний email або пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}