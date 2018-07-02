package com.test.test.myapplication;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.fragment_viewpager)
    ViewPager vpager;

    public AFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        ButterKnife.bind(this, view);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getActivity().getSupportFragmentManager());
        vpager.setAdapter(mSectionsPagerAdapter);

        vpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(vpager));

        return view;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    public static class PlaceholderFragment extends Fragment {
        private RecyclerView recyclerView;

        private static final String ARG_SECTION_NUMBER = "section_number";

        private String[] text = {"这是1", "这是2", "这是3", "这是4", "这是5"};
        private int[] type = {1, 3, 2, 2, 1};

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View a1view = inflater.inflate(R.layout.fragment_a1, container, false);
            View a2view = inflater.inflate(R.layout.fragment_a2, container, false);
            View a3view = inflater.inflate(R.layout.fragment_a3, container, false);


            recyclerView = a1view.findViewById(R.id.rv);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            recyclerView.setLayoutManager(layoutManager);

            ArrayList<MyItem> myItems = initData();
            ItemAdapter adapter = new ItemAdapter(myItems);
            recyclerView.setAdapter(adapter);

            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                return a1view;
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                return a2view;
            } else {
                return a3view;
            }
        }

        private ArrayList<MyItem> initData() {
            ArrayList<MyItem> myItems = new ArrayList<>();
            for (int i = 0; i < type.length; i++) {
                if (type[i] == 1) {
                    MyItem myItem = new MyItem(1);
                    myItem.setText(text[i]);
                    myItems.add(myItem);
                } else if (type[i] == 2) {
                    MyItem myItem = new MyItem(2);
                    myItems.add(myItem);
                } else if (type[i] == 3) {
                    MyItem myItem = new MyItem(3);
                    myItem.setText(text[i]);
                    myItems.add(myItem);
                }
            }
            return myItems;
        }
    }

}
