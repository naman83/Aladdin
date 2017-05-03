package alladinmarket.com.alladinmarket.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import alladinmarket.com.alladinmarket.activities.DrawerActivity;
import alladinmarket.com.alladinmarket.R;
import alladinmarket.com.alladinmarket.adapters.FragmentPager;
import alladinmarket.com.alladinmarket.adapters.ImageAdapter;
import alladinmarket.com.alladinmarket.adapters.MarketAdaper;

/**
 * Created by nmn on 3/4/17.
 */

public class LandingFragment extends Fragment{

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    FragmentPager adapter ;

    CirclePageIndicator indicator ;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ViewPager mViewPagerFragments ;
    TabLayout mTabLayout ;

    private static final Integer[] IMAGES= {R.drawable.tyu,R.drawable.tyu,R.drawable.tyu,R.drawable.tyu};
    String[] tabTitles={"BEST OFFERS","CATEGORIES", "TOP STORIES"};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_landingfragment, container, false);
        // Set title bar
        mPager = (ViewPager)v. findViewById(R.id.pager);
         indicator = (CirclePageIndicator)v.
                findViewById(R.id.indicator);

        mViewPagerFragments = (ViewPager)v.findViewById(R.id.vp_fragments);
        mTabLayout = (TabLayout)v.findViewById(R.id.tabs_sliding);



        init();



//        mRecyclerView.setLayoutManager(mLayoutManager);
        mTabLayout.setupWithViewPager(mViewPagerFragments);

        // specify an adapter (see also next example)

        adapter = new FragmentPager(getFragmentManager());


        //mRecyclerView.setAdapter(mAdapter);

        mViewPagerFragments.setAdapter(adapter);

      //  mTabLayout.setupWithViewPager(mViewPagerFragments);

        return v;
    }


    private void init() {
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);




        mPager.setAdapter(new ImageAdapter(getContext(),ImagesArray));




        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =IMAGES.length;

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }


}
