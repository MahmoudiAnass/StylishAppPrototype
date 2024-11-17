
package com.example.prototypestylish;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

public class HomeActivity extends AppCompatActivity {

    private int[] images = {R.drawable.rectangle48,R.drawable.rectangle48,R.drawable.rectangle48};
    String[] texts = {"50-40% OFF", "50-40% OFF", "50-40% OFF"};
    private ViewPager2 viewPager;
    private LinearLayout indicatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(getWindow().getDecorView(), (v, insets) -> {

            Insets systemInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars());

            v.setPadding(v.getPaddingLeft(),
                    v.getPaddingTop(),
                    v.getPaddingRight(),
                    v.getPaddingBottom() - systemInsets.bottom); // subtract the insets from the bottom padding
            return insets;
        });

        viewPager = findViewById(R.id.viewPager);
        indicatorLayout = findViewById(R.id.indicatorLayout);
        imageSliderAdapter adapter = new imageSliderAdapter(images, texts, this);
        viewPager.setAdapter(adapter);

        for (int i = 0; i < images.length; i++) {
            View indicator = new View(this);

            indicator.setLayoutParams(new LinearLayout.LayoutParams(20, 20));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    dpToPx(20), // Width of the indicator
                    dpToPx(20)  // Height of the indicator
            );

            // Set margins for each indicator
            int margin = dpToPx(8); // Adjust margin value as needed
            params.setMargins(margin, margin, margin, margin);
            indicator.setBackgroundResource(R.drawable.imageindicatorinactive);
            indicatorLayout.addView(indicator);
        }


        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                updateIndicators(position);
            }
        });


        updateIndicators(0);
    }

    private int dpToPx(int dp) {
        return Math.round(dp * getResources().getDisplayMetrics().density);

    }

    private void updateIndicators(int position) {

        for (int i = 0; i < indicatorLayout.getChildCount(); i++) {
            View indicator = indicatorLayout.getChildAt(i);
            if (i == position) {
                indicator.setBackgroundResource(R.drawable.imageindicatoractive); // Active state drawable
            } else {
                indicator.setBackgroundResource(R.drawable.imageindicatorinactive); // Inactive state drawable
            }
        }
    }
}