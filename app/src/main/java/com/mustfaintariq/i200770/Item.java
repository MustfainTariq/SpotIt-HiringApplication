package com.mustfaintariq.i200770;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Item extends AppCompatActivity {

    ImageButton arrow;

    Button report;

    private ViewPager viewPager;
    private int[] images = {R.drawable.tinted_square, R.drawable.tinted_square1, R.drawable.tinted_square, R.drawable.tinted_square1}; // Replace with your image resources
    private LinearLayout dotLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);




        report = (Button) findViewById(R.id.reporttext);
        arrow = (ImageButton) findViewById(R.id.arrow);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Login.class);
                startActivity(intent);
            }
        });

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Report.class);
                startActivity(intent);
            }
        });


        viewPager = findViewById(R.id.viewPager);
        dotLayout = findViewById(R.id.dotLayout);

        // Create and set up the ViewPager adapter
        CustomPagerAdapter pagerAdapter = new CustomPagerAdapter(this, images);
        viewPager.setAdapter(pagerAdapter);

        // Add page change listener to update the dot indicator
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                updateDotIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        // Initialize dot indicator
        addDots(0);
    }

    // Add dots to the dotLayout
    private void addDots(int currentPage) {
        ImageView[] dots = new ImageView[images.length];

        dotLayout.removeAllViews(); // Clear existing dots

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(this);
            int drawableId = (i == currentPage) ? R.drawable.dot_selected : R.drawable.dot_unselected;
            dots[i].setImageDrawable(getResources().getDrawable(drawableId));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(8, 0, 8, 0); // Adjust margin as needed
            dots[i].setLayoutParams(params);
            dotLayout.addView(dots[i]);
        }
    }

    // Update dot indicator when ViewPager page changes
    private void updateDotIndicator(int position) {
        addDots(position);
    }
}