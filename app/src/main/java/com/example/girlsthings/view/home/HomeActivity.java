package com.example.girlsthings.view.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.girlsthings.R;
import com.example.girlsthings.fragment.cart.CartFragment;
import com.example.girlsthings.fragment.home.HomeFragment;
import com.example.girlsthings.fragment.inbox.InboxFragment;
import com.example.girlsthings.fragment.profile.ProfileFragment;
import com.example.girlsthings.fragment.transaction.TransactionFragment;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);


    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment fragmentHome = new HomeFragment();
                    FragmentTransaction fTHome = getSupportFragmentManager().beginTransaction();
                    fTHome.replace(R.id.content, fragmentHome, "FragmentName");
                    fTHome.commit();
                    return true;
                case R.id.navigation_inbox:
                    InboxFragment fragmentInbox = new InboxFragment();
                    FragmentTransaction fTInbox = getSupportFragmentManager().beginTransaction();
                    fTInbox.replace(R.id.content, fragmentInbox, "FragmentName");
                    fTInbox.commit();
                    return true;
                case R.id.navigation_cart:
                    CartFragment fragmentCart = new CartFragment();
                    FragmentTransaction fTCart = getSupportFragmentManager().beginTransaction();
                    fTCart.replace(R.id.content, fragmentCart, "FragmentName");
                    fTCart.commit();
                    return true;
                case R.id.navigation_transaction:
                    TransactionFragment fragmentTransaction = new TransactionFragment();
                    FragmentTransaction fTTransaction = getSupportFragmentManager().beginTransaction();
                    fTTransaction.replace(R.id.content, fragmentTransaction, "FragmentName");
                    fTTransaction.commit();
                    return true;
                case R.id.navigation_profile:
                    ProfileFragment fragmentProfile = new ProfileFragment();
                    FragmentTransaction fTProfile = getSupportFragmentManager().beginTransaction();
                    fTProfile.replace(R.id.content, fragmentProfile, "FragmentName");
                    fTProfile.commit();
                    return true;
            }
            return false;
        }
    };
}
