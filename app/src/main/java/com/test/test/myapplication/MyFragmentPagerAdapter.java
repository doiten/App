package com.test.test.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;


public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private AFragment myFragment1 = null;
    private BFragment myFragment2 = null;
    private CFragment myFragment3 = null;
    private DFragment myFragment4 = null;


    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new AFragment();
        myFragment2 = new BFragment();
        myFragment3 = new CFragment();
        myFragment4 = new DFragment();
    }


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainActivity.PAGE_ONE:
                fragment = myFragment1;
                break;
            case MainActivity.PAGE_TWO:
                fragment = myFragment2;
                break;
            case MainActivity.PAGE_THREE:
                fragment = myFragment3;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = myFragment4;
                break;
        }
        return fragment;
    }

}

