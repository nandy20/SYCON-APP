package com.example.nandhini.edc;

import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;

public class SyconTabsAdapter extends FragmentPagerAdapter {

    private Context mContext;

    int NoOfTabs;
    public SyconTabsAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        NoOfTabs = 3;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new SyconHomeFragment();
        } else if (position == 1) {
            return new SyconAboutFragment();
        } else if (position == 2) {
            return new SyconSpeakersFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.sycon_about);
        } else if (position == 1) {
            return mContext.getString(R.string.sycon_home);
        } else if (position == 2) {
            return mContext.getString(R.string.sycon_speakers);
        }
        else
                return mContext.getString(R.string.defaultstr);
    }
}
