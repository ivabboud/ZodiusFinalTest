package com.e_steps.abraj2.Fragments.B_Yearly;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.e_steps.abraj2.R;
import com.e_steps.abraj2.utils.AppController;

public class FragmentB extends Fragment {

    private LinearLayout h1, h2, h3, h4, h5, h6, h7, h8, h9, h10, h11, h12;
    private ImageView a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12;
    private ImageView i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12;


    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_b, container, false);


        frag(0);
        findById(view);
        setAlphatoZero();
        a1.setColorFilter(getResources().getColor(R.color.white_f5));
        i1.setColorFilter(getResources().getColor(R.color.white_f5));


        OnClick(h1, a1, i1, 0);
        OnClick(h2, a2, i2, 1);
        OnClick(h3, a3, i3, 2);
        OnClick(h4, a4, i4, 3);
        OnClick(h5, a5, i5, 4);
        OnClick(h6, a6, i6, 5);
        OnClick(h7, a7, i7, 6);
        OnClick(h8, a8, i8, 7);
        OnClick(h9, a9, i9, 8);
        OnClick(h10, a10, i10, 9);
        OnClick(h11, a11, i11, 10);
        OnClick(h12, a12, i12, 11);


        return view;

    }


    private void OnClick(final LinearLayout linearLayout, final ImageView imageView,
                         final ImageView imageView2, final int x) {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlphatoZero();
                imageView.setColorFilter(getResources().getColor(R.color.white_f5));
                imageView2.setColorFilter(getResources().getColor(R.color.white_f5));

                frag(x);

            }
        });
    }

    private void frag(int x) {
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        fragment_b_adapter fragment_b_adapter = new fragment_b_adapter(getActivity().getSupportFragmentManager(), x);
        viewPager.setAdapter(fragment_b_adapter);
        fragment_b_adapter.notifyDataSetChanged();
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
        changeTabsFont(tabLayout);
    }


    private void findById(View view) {
        h1 = (LinearLayout) view.findViewById(R.id.horo1);
        h2 = (LinearLayout) view.findViewById(R.id.horo2);
        h3 = (LinearLayout) view.findViewById(R.id.horo3);
        h4 = (LinearLayout) view.findViewById(R.id.horo4);
        h5 = (LinearLayout) view.findViewById(R.id.horo5);
        h6 = (LinearLayout) view.findViewById(R.id.horo6);
        h7 = (LinearLayout) view.findViewById(R.id.horo7);
        h8 = (LinearLayout) view.findViewById(R.id.horo8);
        h9 = (LinearLayout) view.findViewById(R.id.horo9);
        h10 = (LinearLayout) view.findViewById(R.id.horo10);
        h11 = (LinearLayout) view.findViewById(R.id.horo11);
        h12 = (LinearLayout) view.findViewById(R.id.horo12);

        a1 = (ImageView) view.findViewById(R.id.arrow1);
        a2 = (ImageView) view.findViewById(R.id.arrow2);
        a3 = (ImageView) view.findViewById(R.id.arrow3);
        a4 = (ImageView) view.findViewById(R.id.arrow4);
        a5 = (ImageView) view.findViewById(R.id.arrow5);
        a6 = (ImageView) view.findViewById(R.id.arrow6);
        a7 = (ImageView) view.findViewById(R.id.arrow7);
        a8 = (ImageView) view.findViewById(R.id.arrow8);
        a9 = (ImageView) view.findViewById(R.id.arrow9);
        a10 = (ImageView) view.findViewById(R.id.arrow10);
        a11 = (ImageView) view.findViewById(R.id.arrow11);
        a12 = (ImageView) view.findViewById(R.id.arrow12);


        i1 = (ImageView) view.findViewById(R.id.icon1);
        i2 = (ImageView) view.findViewById(R.id.icon2);
        i3 = (ImageView) view.findViewById(R.id.icon3);
        i4 = (ImageView) view.findViewById(R.id.icon4);
        i5 = (ImageView) view.findViewById(R.id.icon5);
        i6 = (ImageView) view.findViewById(R.id.icon6);
        i7 = (ImageView) view.findViewById(R.id.icon7);
        i8 = (ImageView) view.findViewById(R.id.icon8);
        i9 = (ImageView) view.findViewById(R.id.icon9);
        i10 = (ImageView) view.findViewById(R.id.icon10);
        i11 = (ImageView) view.findViewById(R.id.icon11);
        i12 = (ImageView) view.findViewById(R.id.icon12);


    }

    private void setAlphatoZero() {



        a1.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
        a2.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
        a3.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
        a4.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
        a5.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
        a6.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
        a7.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
        a8.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
        a9.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
        a10.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
        a11.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));
        a12.setColorFilter(getResources().getColor(R.color.colorPrimaryDark));


        i1.setColorFilter(getResources().getColor(R.color.colorAccent));
        i2.setColorFilter(getResources().getColor(R.color.colorAccent));
        i3.setColorFilter(getResources().getColor(R.color.colorAccent));
        i4.setColorFilter(getResources().getColor(R.color.colorAccent));
        i5.setColorFilter(getResources().getColor(R.color.colorAccent));
        i6.setColorFilter(getResources().getColor(R.color.colorAccent));
        i7.setColorFilter(getResources().getColor(R.color.colorAccent));
        i8.setColorFilter(getResources().getColor(R.color.colorAccent));
        i9.setColorFilter(getResources().getColor(R.color.colorAccent));
        i10.setColorFilter(getResources().getColor(R.color.colorAccent));
        i11.setColorFilter(getResources().getColor(R.color.colorAccent));
        i12.setColorFilter(getResources().getColor(R.color.colorAccent));


    }

    private void changeTabsFont(TabLayout tabLayout) {

        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(AppController.getInstance().getFont());
                }
            }
        }
    }
}
