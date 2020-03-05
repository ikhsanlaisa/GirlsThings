package com.example.girlsthings.view.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.girlsthings.R;
import com.example.girlsthings.view.home.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }

    public void onBackPressed(View view) {
        finish();
    }

    public void loginIn(View view) {
//        startActivity(new Intent(this, VerificationActivity.class));
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
