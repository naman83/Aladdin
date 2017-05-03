package alladinmarket.com.alladinmarket.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import alladinmarket.com.alladinmarket.fragments.LandingFragment;
import alladinmarket.com.alladinmarket.fragments.NewTrendsFragment;
import alladinmarket.com.alladinmarket.fragments.PromoterFragment;
import alladinmarket.com.alladinmarket.fragments.SearchFragment;
import alladinmarket.com.alladinmarket.fragments.SearchMarketFragment;
import alladinmarket.com.alladinmarket.fragments.SearchProductFragment;
import alladinmarket.com.alladinmarket.fragments.SearchShopsFragment;

/**
 * Created by nmn on 28/4/17.
 */

public class FragmentPager extends FragmentStatePagerAdapter {

    String[] tabTitles={"SEARCH MARKETS","PRODUCTS", "NEW TRENDS","PROMOTER"};
    public FragmentPager(FragmentManager fm) {
        super(fm);
    }

    public FragmentPager(FragmentManager fm, String[] tabTitles) {
        super(fm);
        this.tabTitles = tabTitles;
    }

    @Override
    public Fragment getItem(int position) {
        if (position==1)
        {
        return new SearchProductFragment();
        }
        else if (position == 2)
        {
            return new NewTrendsFragment();
        }
        else if (position == 3)
        {
            return new PromoterFragment();
        }

        return  new SearchMarketFragment();
    }


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
