package com.test.test.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    vpager.setCurrentItem(PAGE_ONE);
                    return true;
                case R.id.navigation_dashboard:
                    vpager.setCurrentItem(PAGE_TWO);
                    return true;
                case R.id.navigation_notifications:
                    vpager.setCurrentItem(PAGE_THREE);
                    return true;
                case R.id.navigation_nonono:
                    vpager.setCurrentItem(PAGE_FOUR);
                    return true;
            }
            return false;
        }
    };

    @BindView(R.id.viewpager_fragment)
    ViewPager vpager;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        vpager.setAdapter(adapter);
        vpager.setCurrentItem(0);
        vpager.addOnPageChangeListener(this);
        vpager.setOffscreenPageLimit(3);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == 2) {
            switch (vpager.getCurrentItem()) {
                case PAGE_ONE:
                    navigation.setSelectedItemId(R.id.navigation_home);
                    break;
                case PAGE_TWO:
                    navigation.setSelectedItemId(R.id.navigation_dashboard);
                    break;
                case PAGE_THREE:
                    navigation.setSelectedItemId(R.id.navigation_notifications);
                    break;
                case PAGE_FOUR:
                    navigation.setSelectedItemId(R.id.navigation_nonono);
                    break;

            }
        }
    }

}
