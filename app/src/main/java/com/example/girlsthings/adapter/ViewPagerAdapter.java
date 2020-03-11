package com.example.girlsthings.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.girlsthings.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    Context context;
    List<String> slider;
    LayoutInflater layoutInflater;

    public ViewPagerAdapter(Context context, List<String> slider) {
        this.context = context;
        this.slider = slider;
    }

    @Override
    public int getCount() {
        return slider.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.viewpager_image, null);
        final ProgressBar progressBar = view.findViewById(R.id.viewPagerProgressBar);
        final ImageView image = view.findViewById(R.id.viewPagerImage);
        final ImageView imageBackground = view.findViewById(R.id.viewPagerBackground);

        container.addView(view);

        try {
            Picasso.get().load(slider.get(position).trim())
                    .error(R.drawable.upload)
                    .into(image);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }
}
