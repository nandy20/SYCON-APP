package com.example.nandhini.edc;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SyconActivity extends AppCompatActivity implements SyconAboutFragment.OnFragmentInteractionListener,SyconSpeakersFragment.OnFragmentInteractionListener,SyconHomeFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sycon);

        ViewPager SyconPager = (ViewPager) findViewById(R.id.viewpager);

        SyconTabsAdapter adapter = new SyconTabsAdapter(this, getSupportFragmentManager());

        SyconPager.setAdapter(adapter);

        TabLayout sycontab = (TabLayout) findViewById(R.id.tabs);

        sycontab.setupWithViewPager(SyconPager);

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
