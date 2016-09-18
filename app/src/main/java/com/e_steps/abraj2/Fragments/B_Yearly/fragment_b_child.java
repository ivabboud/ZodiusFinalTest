package com.e_steps.abraj2.Fragments.B_Yearly;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.e_steps.abraj2.MainActivity;
import com.e_steps.abraj2.R;
import com.e_steps.abraj2.utils.AppController;
import com.e_steps.abraj2.utils.Blinking;
import com.e_steps.abraj2.utils.STATICS;
import com.e_steps.abraj2.utils.Wifi_Blinking;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class fragment_b_child extends Fragment {
    public static final String ARG_TAB = "ARG_TAB";
    public static final String ARG_HORO = "ARG_HORO";

    public int mTab, mHoro;
    private TextView child_text;
    DatabaseReference databaseReference;
    private String value=null;
    LinearLayout share;
    private String[] part = {"general", "love", "health", "family", "career"};
    private int[] icons = {R.drawable.general_ic, R.drawable.love_couple, R.drawable.doctor, R.drawable.family
            , R.drawable.career};


    private double[][] rating_float = {{4.5, 3.5, 2, 1.5, 4},
            {4, 3.5, 2, 1.5, 4},
            {4, 3.5, 2, 1.5, 4},
            {4.5, 3.5, 2, 1.5, 4},
            {3.5, 3.5, 2.5, 1.5, 4},
            {4.5, 3.5, 2, 3.5, 4}, {4.5, 3.5, 2, 1.5, 4}, {5, 3.5, 2, 0.5, 4},
            {4, 3.5, 2, 1, 3}, {4.5, 3.5, 2, 1.5, 4},
            {4.5, 3.5, 2, 1.5, 4}, {4.5, 3.5, 2, 1.5, 4}};

    private Blinking blinking;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b_child, container, false);


        ((TextView) view.findViewById(R.id.from_to_text)).setTypeface(AppController.getInstance().getFont());
        ((TextView) view.findViewById(R.id.alias)).setTypeface(AppController.getInstance().getFont());
        ((TextView) view.findViewById(R.id.child_text)).setTypeface(AppController.getInstance().getFont());


        child_text = (TextView) view.findViewById(R.id.child_text);
        ((TextView) view.findViewById(R.id.from_to_text)).setText(STATICS.HOROSCOPE_EN[mHoro] + " and " + part[mTab]);
        ((ImageView) view.findViewById(R.id.horo_icon)).setImageResource(icons[mTab]);
        share = (LinearLayout) view.findViewById(R.id.share_linear);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareHoro();
            }
        });




        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.rating);
        setRatingBarStart(ratingBar);

        blinking = new Blinking(child_text);
        blinking.startBlinking();





        getHoro(mTab, mHoro);
        return view;
    }

    private void setRatingBarStart(RatingBar rating_bar) {
        LayerDrawable stars = (LayerDrawable) rating_bar.getProgressDrawable();
        stars.getDrawable(2)
                .setColorFilter(Color.parseColor("#FFD600"),
                        PorterDuff.Mode.SRC_ATOP); // for filled stars
        stars.getDrawable(1)
                .setColorFilter(Color.parseColor("#bdbdbd"),
                        PorterDuff.Mode.SRC_ATOP); // for half filled stars
        stars.getDrawable(0)
                .setColorFilter(Color.parseColor("#bdbdbd"),
                        PorterDuff.Mode.SRC_ATOP); // for empty stars

        rating_bar.setRating((float) rating_float[mHoro][mTab]);
    }

    private void getHoro(int mTab, int mHoro) {

        databaseReference = FirebaseDatabase.getInstance().getReference().child("YEARLY").child(STATICS.HOROSCOPE_EN[mHoro].toLowerCase()).child(part[mTab]);
    }


    public static fragment_b_child newInstance(int tab, int horo) {
        Bundle args = new Bundle();
        args.putInt(ARG_TAB, tab);
        args.putInt(ARG_HORO, horo);
        fragment_b_child fragment = new fragment_b_child();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTab = getArguments().getInt(ARG_TAB);
        mHoro = getArguments().getInt(ARG_HORO);

    }

    @Override
    public void onStart() {
        super.onStart();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value = dataSnapshot.getValue(String.class);
                blinking.stopBlinking();
                child_text.setText(value);
                child_text.setGravity(Gravity.LEFT);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                child_text.setText(databaseError.toString());

            }
        });


    }

    private void shareHoro() {

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = null;

        shareBody = " You can download " +
                getResources().getString(R.string.app_name) + " App from Google Play :" + "\n" +

                "http://play.google.com/store/apps/details?id=com.esteps.tie";

        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name) + " App");

        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }
}
