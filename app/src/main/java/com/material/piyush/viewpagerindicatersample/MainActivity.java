package com.material.piyush.viewpagerindicatersample;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.material.piyush.pagerindicatorlibrary.PagerIndicator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PagerIndicator pagerIndicator = (PagerIndicator) findViewById(R.id.pager);

        pagerIndicator.setPagerIndicatorCount(10);
        pagerIndicator.setSolidColor(Color.LTGRAY);
        pagerIndicator.setStrokeColor(Color.BLUE);
        pagerIndicator.setSelectedStrokeColor(Color.CYAN);
        pagerIndicator.setSelectedSolidColor(Color.YELLOW);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        CustomPagerAdapter pager = new CustomPagerAdapter();
        viewPager.setAdapter(pager);
        pagerIndicator.setPagerIndicatorCount(pager.getCount());
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pagerIndicator.setSelectedIndex(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public class CustomPagerAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            ColorModel modelObject = ColorModel.values()[position];
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            ViewGroup layout = (ViewGroup) inflater.inflate(modelObject.getLayoutResId(), collection, false);
            collection.addView(layout);
            return layout;
        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }

        @Override
        public int getCount() {
            return ColorModel.values().length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            ColorModel customPagerEnum = ColorModel.values()[position];
            return getString(customPagerEnum.getTitleResId());
        }

    }
}
