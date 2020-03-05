package com.example.girlsthings.view.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.girlsthings.R;
import com.example.girlsthings.view.authentication.LoginRegisterActivity;
import com.example.girlsthings.view.onboarding.OnBoardingActivity;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        Thread myThread = new Thread() {
            @Override
            public void run() {
                try{
                    sleep(2000);
                    startActivity(new Intent(getApplicationContext(), OnBoardingActivity.class));
                    finish();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}
