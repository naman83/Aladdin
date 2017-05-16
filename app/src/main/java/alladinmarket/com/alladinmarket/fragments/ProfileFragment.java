package alladinmarket.com.alladinmarket.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import alladinmarket.com.alladinmarket.R;
import alladinmarket.com.alladinmarket.adapters.FragmentPager;
import alladinmarket.com.alladinmarket.adapters.ImageAdapter;

/**
 * Created by nmn on 3/4/17.
 */

public class ProfileFragment extends Fragment{

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
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        // Set title bar


      //  mTabLayout.setupWithViewPager(mViewPagerFragments);

        return v;
    }





}
