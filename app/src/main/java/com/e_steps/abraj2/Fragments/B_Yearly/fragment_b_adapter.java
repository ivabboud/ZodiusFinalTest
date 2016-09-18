package com.e_steps.abraj2.Fragments.B_Yearly;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;


import com.e_steps.abraj2.utils.STATICS;


public class fragment_b_adapter extends FragmentStatePagerAdapter {

    int tabCount = 5;
    private int value;
    private String[] titles = STATICS.YEARLY_TABS;

    public fragment_b_adapter(FragmentManager fm, int value ) {

        super(fm);
        this.value=value;
    }

    @Override
    public Fragment getItem(int position) {
        return fragment_b_child.newInstance(position , value);
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
