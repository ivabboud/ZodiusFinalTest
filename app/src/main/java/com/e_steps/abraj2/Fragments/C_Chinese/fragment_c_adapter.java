package com.e_steps.abraj2.Fragments.C_Chinese;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.e_steps.abraj2.Fragments.A_Daily.fragment_a_child;
import com.e_steps.abraj2.utils.STATICS;


public class fragment_c_adapter extends FragmentStatePagerAdapter {

    int tabCount = 12;
    private String[] titles = STATICS.HOROSCOPE_CHINESE_EN;

    public fragment_c_adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragment_c_child.newInstance(position);
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
