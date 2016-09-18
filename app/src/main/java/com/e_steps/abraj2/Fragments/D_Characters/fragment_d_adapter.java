package com.e_steps.abraj2.Fragments.D_Characters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.e_steps.abraj2.Fragments.C_Chinese.fragment_c_child;
import com.e_steps.abraj2.utils.STATICS;


public class fragment_d_adapter extends FragmentStatePagerAdapter {

    int tabCount = 12;
    private String[] titles = STATICS.HOROSCOPE_EN;

    public fragment_d_adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragment_d_child.newInstance(position);
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
