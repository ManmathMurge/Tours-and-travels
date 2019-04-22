package com.example.sachin.giristourstravels;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.sachin.giristourstravels.comman.Commans;
import com.example.sachin.giristourstravels.comman.SharedPreferencesUtility;

import java.util.ArrayList;
import java.util.List;

public class Home_Activity extends AppCompatActivity implements Tab1.OnFragmentInteractionListner,Tab2.OnFragmentInteractionListner {
    private DrawerLayout drawerLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        drawerLayout = findViewById(R.id.drawerLayout);

        //Toolbar
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TravelGiri");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        //Navigation Drawer
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.mybooking){
                    Intent intent=new Intent(Home_Activity.this,MapsActivity.class);
                    startActivity(intent);
                    drawerLayout.closeDrawers();
                }
                if(menuItem.getItemId()==R.id.payment){
                    Toast.makeText(getApplicationContext(),"Display Payment ",Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawers();
                }
                if(menuItem.getItemId()==R.id.servises){
                    Intent intent=new Intent(Home_Activity.this,SpecialServices.class);
                    startActivity(intent);
                    drawerLayout.closeDrawers();
                }
                if(menuItem.getItemId()==R.id.enquiry){
                    Intent intent=new Intent(Home_Activity.this,Enquiry.class);
                    startActivity(intent);
                    drawerLayout.closeDrawers();
                }

                if(menuItem.getItemId()==R.id.feedback){
                    Intent intent=new Intent(Home_Activity.this,Fedback.class);
                    startActivity(intent);
                    drawerLayout.closeDrawers();
                }
                if(menuItem.getItemId()==R.id.contact_us){
                    Intent intent=new Intent(Home_Activity.this,contact_us.class);
                    startActivity(intent);
                    drawerLayout.closeDrawers();
                }
                if(menuItem.getItemId()==R.id.sign_out){
                    SharedPreferencesUtility.savePrefBoolean(Home_Activity.this, Commans.LOGIN_STATUS, false);
                    Intent intent = new Intent(Home_Activity.this,Login_Activity.class);
                    startActivity(intent);
                    finish();
                    drawerLayout.closeDrawers();
                }



                return true;
            }
        });
            viewPager = (ViewPager) findViewById(R.id.pager);
            setupViewPager(viewPager);

            tabLayout = (TabLayout) findViewById(R.id.tablayout);
            tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1(), "Daily Shared");
        adapter.addFragment(new Tab2(), "Rental");
        viewPager.setAdapter(adapter);
    }
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}

