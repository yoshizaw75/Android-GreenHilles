package com.greenhilles.com.app001;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomNavigation();

        if (savedInstanceState == null) {
            createFragment();
        }
    }

    private void setupBottomNavigation() {

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        loadHomeFragment();
                        return true;
                    case R.id.navigation_dashboard:
                        loadReservationfragment();
                        return true;
                    case R.id.navigation_notifications:
                        loadBlogfragment();
                        return true;
                }
                return false;
            }
        });
    }

    private HomeFragment homeFragment;
    private ReservationFragment reserveFragment;
    private BlogFragment blogFragment;
    private FragmentTransaction ft;

    private  void createFragment(){
        homeFragment = HomeFragment.newInstance();
        reserveFragment = ReservationFragment.newInstance();
        blogFragment = BlogFragment.newInstance();

    }

    private void loadHomeFragment() {
        getFragmentManager().beginTransaction().replace(R.id.fragment_frame, homeFragment).commit();
    }

    private void loadReservationfragment() {
        getFragmentManager().beginTransaction().replace(R.id.fragment_frame, reserveFragment).commit();
    }

    private void loadBlogfragment() {
        getFragmentManager().beginTransaction().replace(R.id.fragment_frame, blogFragment).commit();
    }
}
