package com.e_steps.abraj2.Fragments.D_Characters;

import android.animation.LayoutTransition;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.e_steps.abraj2.R;
import com.e_steps.abraj2.utils.STATICS;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class fragment_d_child extends Fragment {
    public static final String ARG_TAB = "ARG_TAB";
    public int mTab;
    private TextView main_text, love_text, work_text, family_text, celeb_text;
    private LinearLayout card_linrae1, card_linrae2, card_linrae3, card_linrae4, card1_linear_content, card2_linear_content, card3_linear_content, card4_linear_content, card5_linear_content;
    private TextView card1_title, card2_title, card3_title, card4_title, card5_title;
    private View card1, card2, card3, card4, card5, view;
    private ImageView card_icon1, card_icon2, card_icon3, card_icon4, card_icon5;
    private LinearLayout share1, share2, share3, share4, share5;
    private String s[] = {null};

    DatabaseReference databaseReference, databaseReference2, databaseReference3, databaseReference4, databaseReference5;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_d_child, container, false);

        ((ImageView) view.findViewById(R.id.horo_icon)).setImageResource(STATICS.HOROSCOPE_LOGO[mTab]);
        ((ImageView) view.findViewById(R.id.horo_icon)).setColorFilter(getResources().getColor(R.color.colorPrimary));


        findView();
        closeAll();
        OnClick(card1_title, card1_linear_content, card_linrae1);
        OnClick(card2_title, card2_linear_content, card_linrae2);
        OnClick(card3_title, card3_linear_content, card_linrae3);
        OnClick(card4_title, card4_linear_content, card_linrae4);
        OnClick(card5_title, card5_linear_content, card_linrae1);
        share_click(share1, 0);
        share_click(share2, 1);
        share_click(share3, 2);
        share_click(share4, 3);
        share_click(share5, 4);


        getHoro(mTab);
        return view;
    }


    private void getHoro(int mTab) {

        databaseReference = FirebaseDatabase.getInstance().getReference().child("CHARACTER").child(STATICS.HOROSCOPE_EN[mTab].toLowerCase()).child("general");
        databaseReference2 = FirebaseDatabase.getInstance().getReference().child("CHARACTER").child(STATICS.HOROSCOPE_EN[mTab].toLowerCase()).child("love");
        databaseReference3 = FirebaseDatabase.getInstance().getReference().child("CHARACTER").child(STATICS.HOROSCOPE_EN[mTab].toLowerCase()).child("career");
        databaseReference4 = FirebaseDatabase.getInstance().getReference().child("CHARACTER").child(STATICS.HOROSCOPE_EN[mTab].toLowerCase()).child("family");
        databaseReference5 = FirebaseDatabase.getInstance().getReference().child("CHARACTER").child(STATICS.HOROSCOPE_EN[mTab].toLowerCase()).child("celebrities");
    }


    private void findView() {
        card1 = view.findViewById(R.id.first_card);
        card2 = view.findViewById(R.id.second_card);
        card3 = view.findViewById(R.id.third_card);
        card4 = view.findViewById(R.id.fourth_card);
        card5 = view.findViewById(R.id.fifth_card);


        main_text = (TextView) card1.findViewById(R.id.card_view_content);
        love_text = (TextView) card2.findViewById(R.id.card_view_content);
        work_text = (TextView) card3.findViewById(R.id.card_view_content);
        family_text = (TextView) card4.findViewById(R.id.card_view_content);
        celeb_text = (TextView) card5.findViewById(R.id.card_view_content);

        card_icon1 = (ImageView) card1.findViewById(R.id.card_icon);
        card_icon2 = (ImageView) card2.findViewById(R.id.card_icon);
        card_icon3 = (ImageView) card3.findViewById(R.id.card_icon);
        card_icon4 = (ImageView) card4.findViewById(R.id.card_icon);
        card_icon5 = (ImageView) card5.findViewById(R.id.card_icon);

        card1_title = (TextView) card1.findViewById(R.id.card_view_title);
        card2_title = (TextView) card2.findViewById(R.id.card_view_title);
        card3_title = (TextView) card3.findViewById(R.id.card_view_title);
        card4_title = (TextView) card4.findViewById(R.id.card_view_title);
        card5_title = (TextView) card5.findViewById(R.id.card_view_title);

        card_linrae1 = (LinearLayout) card1.findViewById(R.id.card_linear);
        card_linrae2 = (LinearLayout) card2.findViewById(R.id.card_linear);
        card_linrae3 = (LinearLayout) card3.findViewById(R.id.card_linear);
        card_linrae4 = (LinearLayout) card4.findViewById(R.id.card_linear);


        card1_linear_content = (LinearLayout) card1.findViewById(R.id.card_linear_content);
        card2_linear_content = (LinearLayout) card2.findViewById(R.id.card_linear_content);
        card3_linear_content = (LinearLayout) card3.findViewById(R.id.card_linear_content);
        card4_linear_content = (LinearLayout) card4.findViewById(R.id.card_linear_content);
        card5_linear_content = (LinearLayout) card5.findViewById(R.id.card_linear_content);

        card1_title.setText(STATICS.HOROSCOPE_EN[mTab] + " main character");
        card2_title.setText(STATICS.HOROSCOPE_EN[mTab] + " in love");
        card3_title.setText(STATICS.HOROSCOPE_EN[mTab] + " in work");
        card4_title.setText(STATICS.HOROSCOPE_EN[mTab] + " family and frienship");
        card5_title.setText(STATICS.HOROSCOPE_EN[mTab] + " celebrities");


        card_icon1.setImageResource(R.drawable.businessman);
        card_icon2.setImageResource(R.drawable.heart);
        card_icon3.setImageResource(R.drawable.money_bag);
        card_icon4.setImageResource(R.drawable.team);
        card_icon5.setImageResource(R.drawable.tuxedo);


        share1 = (LinearLayout) card1.findViewById(R.id.share_linear);
        share2 = (LinearLayout) card2.findViewById(R.id.share_linear);
        share3 = (LinearLayout) card3.findViewById(R.id.share_linear);
        share4 = (LinearLayout) card4.findViewById(R.id.share_linear);
        share5 = (LinearLayout) card5.findViewById(R.id.share_linear);


        ProgressBar progressBar = (ProgressBar) card1.findViewById(R.id.progressBar);






    }

    private void OnClick(final TextView textView, final LinearLayout linearLayout2, final LinearLayout linearLayout) {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggle_card(linearLayout2, textView, linearLayout);
            }
        });

    }

    public static fragment_d_child newInstance(int tab) {
        Bundle args = new Bundle();
        args.putInt(ARG_TAB, tab);
        fragment_d_child fragment = new fragment_d_child();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTab = getArguments().getInt(ARG_TAB);

    }

    @Override
    public void onStart() {
        super.onStart();


        text_listener(databaseReference, main_text);
        text_listener(databaseReference2, love_text);
        text_listener(databaseReference3, work_text);
        text_listener(databaseReference4, family_text);
        text_listener(databaseReference5, celeb_text);


    }

    private void text_listener(DatabaseReference databaseReference, final TextView textView) {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                textView.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {


            }
        });

    }


    private void toggle_card(LinearLayout linearLayout, TextView textView, LinearLayout linearLayout2) {

        LayoutTransition layoutTransition = new LayoutTransition();

        if (linearLayout.getVisibility() == View.GONE) {


            closeAll();
            linearLayout2.setLayoutTransition(layoutTransition);
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_arrow_down, 0, 0, 0);

            linearLayout.setVisibility(View.VISIBLE);
        } else {
            linearLayout.clearAnimation();
            textView.clearAnimation();
            linearLayout2.setLayoutTransition(null);
            linearLayout.setVisibility(View.GONE);
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_arrow_right, 0, 0, 0);
        }

    }

    private void closeAll() {

        card1_linear_content.setVisibility(View.GONE);
        card1_title.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_arrow_right, 0, 0, 0);
        card2_linear_content.setVisibility(View.GONE);
        card2_title.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_arrow_right, 0, 0, 0);
        card3_linear_content.setVisibility(View.GONE);
        card3_title.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_arrow_right, 0, 0, 0);
        card4_linear_content.setVisibility(View.GONE);
        card4_title.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_arrow_right, 0, 0, 0);

        card5_linear_content.setVisibility(View.GONE);
        card5_title.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_arrow_right, 0, 0, 0);

    }

    private void share_click(LinearLayout linearLayout, final int x) {
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareHoro(getS()[x]);
            }
        });

    }

    private String[] getS() {
        return new String[]{main_text.getText().toString(), love_text.getText().toString(), work_text.getText().toString()
                , family_text.getText().toString(), celeb_text.getText().toString()};
    }


    private void shareHoro(String string) {

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = null;

        shareBody = " You can download " +
                getResources().getString(R.string.app_name) + string + "\n";

        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, getResources().getString(R.string.app_name) + " App");

        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }


}
