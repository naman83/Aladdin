package alladinmarket.com.alladinmarket.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import alladinmarket.com.alladinmarket.R;
import alladinmarket.com.alladinmarket.fragments.LandingFragment;
import alladinmarket.com.alladinmarket.fragments.LandingFragment_shopkeepr;
import alladinmarket.com.alladinmarket.fragments.OrdersFragment;
import alladinmarket.com.alladinmarket.fragments.SearchProductFragment;
import alladinmarket.com.alladinmarket.fragments.SearchShopsFragment;
import alladinmarket.com.alladinmarket.utils.MyApplication;

public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private Toolbar mToolbar;
    private ImageView mShuffle, mWindow, mSaveIcon;
    private NavigationView mNavigationView ;
    private TextView mTextView;
     DrawerLayout drawer ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        setUpUi();

        mSaveIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DrawerActivity.this,CartActivity.class);
                startActivity(i);
            }
        });

            drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();




        if (MyApplication.sShopkeeper_flag==true) {


            LandingFragment_shopkeepr fragment = new LandingFragment_shopkeepr();

            android.support.v4.app.FragmentTransaction  fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }

        else {


            LandingFragment fragment = new LandingFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.commit();
        }
    }

    private void setUpUi() {

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTextView = (TextView) findViewById(R.id.tv_main_toolbar_title);

        // mTextView.setTextSize(15);

        setSupportActionBar(mToolbar);
        mShuffle = (ImageView) findViewById(R.id.img_shuffle);
        mWindow = (ImageView) findViewById(R.id.img_window);
        mSaveIcon = (ImageView) findViewById(R.id.img_save_icon);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);

        if (MyApplication.sShopkeeper_flag==true) {

            mNavigationView.getMenu().clear();
            mNavigationView.inflateMenu(R.menu.activity_main_drawer_shopekeeper);
        }
        mNavigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        Fragment fragment ;
        android.support.v4.app.FragmentTransaction fragmentTransaction ;

        switch (item.getItemId()) {

            case R.id.products :

                fragment = new SearchProductFragment();

                fragmentTransaction =
                        getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();

                break;

            case R.id.Orders :
                fragment = new OrdersFragment();

                fragmentTransaction =
                        getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
                break;


            case R.id.home:

                if (MyApplication.sShopkeeper_flag==true) {


                    fragment = new LandingFragment_shopkeepr();

                    fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.commit();
                }

                else
                {
                    fragment = new LandingFragment();
                    fragmentTransaction =
                            getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.commit();
                }
                break;


            case R.id.notifications:
                fragment = new LandingFragment();
                 fragmentTransaction =
                        getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
               break;


            case R.id.rate_app :

                final String appPackageName = getPackageName();
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {

                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
                }
                break;

            case R.id.search_products :
                 fragment = new SearchProductFragment();
                fragmentTransaction =
                        getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
                break ;


            case R.id.search_shopkeepers :
                fragment = new SearchShopsFragment();
                fragmentTransaction =
                        getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
                break ;

        }

        drawer.closeDrawer(GravityCompat.START);
        return false;
    }


    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle("Exit")
                .setMessage("Are you sure? . You will be logged out from the current session ")
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                      /*  Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);*/
                        finish();
                    }
                }).setNegativeButton("no", null).show();
    }
}
