package com.example.snack;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    static ViewPager vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testViewPager();
    }

    public void testViewPager() {
        final List<Fragment> list = new ArrayList<Fragment>();
        list.add(new Fragment1());
        list.add(new Fragment2());
        list.add(new Fragment3());
        list.add(new Fragment4());
        //ViewPager vp=findViewById(R.id.viewpager);
        vp = (ViewPager) findViewById(R.id.viewpager);

        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public void finishUpdate(ViewGroup container) {
                super.finishUpdate(container);
                if (vp.getCurrentItem() == 0) {
                    Cartcount.sumprice = 0;
                } else if (vp.getCurrentItem() == 1) {
                } else if (vp.getCurrentItem() == 2) {
                } else if (vp.getCurrentItem() == 3) {
                }
            }
        };
        vp.setAdapter(adapter);
    }

    public void btn1(View view) {
        vp.setCurrentItem(0, true);
    }

    public void btn2(View view) {
        vp.setCurrentItem(1, true);
    }

    public void btn3(View view) {
        testViewPager();
        vp.setCurrentItem(2, true);
    }

    public void btn8(View view) {
        vp.setCurrentItem(3, true);
    }
}
