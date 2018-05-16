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
            loadHomeFragment(true);
            loadBlogfragment(true);
            loadReservationfragment(true);
            loadHomeFragment(false);
        }

    }



    private void setupBottomNavigation() {

        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        loadHomeFragment(false);
                        return true;
                    case R.id.navigation_dashboard:
                        loadReservationfragment(false);
                        return true;
                    case R.id.navigation_notifications:
                        loadBlogfragment(false);
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

    private void loadHomeFragment(boolean isInit) {
        if(isInit){
            homeFragment = HomeFragment.newInstance();

        }else{
            ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_frame, homeFragment);
            ft.commit();
        }
    }

    private void loadReservationfragment(boolean isInit) {
        if(isInit){
            reserveFragment = ReservationFragment.newInstance();
        }else{
            ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_frame, reserveFragment);
            ft.commit();
        }
    }

    private void loadBlogfragment(boolean isInit) {
        if(isInit){
            blogFragment = BlogFragment.newInstance();
        }else{
            ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_frame, blogFragment);
            ft.commit();
        }
    }
}
