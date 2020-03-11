package com.example.girlsthings.fragment.home;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.girlsthings.R;
import com.example.girlsthings.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;
    private List<String> slider = new ArrayList<>();
    private TabLayout tabLayout;
    private Activity activity;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        showSlider();
    }

    private void showSlider() {
        slider.add("https://cdn2.tstatic.net/kaltim/foto/bank/images/promo-guardian.jpg");
        slider.add("https://cf.shopee.co.id/file/55250dc317f63f9b4f6f96915b2980d3");

        viewPagerAdapter = new ViewPagerAdapter(getActivity(), slider);
        viewPager = getActivity().findViewById(R.id.slider);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = getActivity().findViewById(R.id.viewPagerIndicator);
        tabLayout.setupWithViewPager(viewPager, true);
        viewPager.setCurrentItem(slider.size() - 1);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (viewPager.getCurrentItem() < slider.size() - 1) {
                            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                        } else {
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        }, 4000, 6000);
    }
}
