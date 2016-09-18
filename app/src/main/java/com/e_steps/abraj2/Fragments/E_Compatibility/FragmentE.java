package com.e_steps.abraj2.Fragments.E_Compatibility;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.e_steps.abraj2.Dialogs.CompatibilityDialog;
import com.e_steps.abraj2.R;
import com.e_steps.abraj2.utils.AppController;
import com.e_steps.abraj2.utils.STATICS;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class FragmentE extends Fragment {
    ImageView img1, img2;
    private static FragmentE instance;
    private int iv1 = -1, iv2 = -1, res;
    TextView cardViewTitle, cardContentText;
    LinearLayout shareLinear;
    View card, view;
    int sec[] = {1, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};
    DatabaseReference databaseReference;
    String value;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_e, container, false);
        instance = this;
        Config();

        OnClick(img1, 1);
        OnClick(img2, 2);

        return view;
    }


    private void Config() {
        card = view.findViewById(R.id.cardView);

        cardViewTitle = (TextView) card.findViewById(R.id.card_view_title);
        cardViewTitle.setText("Compatibility");
        cardViewTitle.setTypeface(AppController.getInstance().getFont());
        cardViewTitle.setGravity(Gravity.CENTER);
        cardViewTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

        cardContentText = (TextView) card.findViewById(R.id.card_view_content);
        cardContentText.setTypeface(AppController.getInstance().getFont());
        cardContentText.setGravity(Gravity.LEFT);


        img1 = (ImageView) view.findViewById(R.id.firstHoro);
        img2 = (ImageView) view.findViewById(R.id.secondHoro);
        img1.setColorFilter(getResources().getColor(STATICS.COLORS_PRIMARY[AppController.getInstance().getColorNum()]));
        img2.setColorFilter(getResources().getColor(STATICS.COLORS_PRIMARY[AppController.getInstance().getColorNum()]));

        if (AppController.getInstance().getCompatibilityImg1() != 0)
            img1.setImageResource(STATICS.HOROSCOPE_LOGO_C[AppController.getInstance().getCompatibilityImg1()]);

        if (AppController.getInstance().getCompatibilityImg2() != 0)
            img2.setImageResource(STATICS.HOROSCOPE_LOGO_C[AppController.getInstance().getCompatibilityImg2()]);

        iv1 = AppController.getInstance().getCompatibilityImg1() - 1;
        iv2 = AppController.getInstance().getCompatibilityImg2() - 1;
        res = ((sec[iv1] * 13) % 77) * ((sec[iv2]) * 13 % 77);
        getHoro();
        ImageView imageView = (ImageView) card.findViewById(R.id.card_icon);
        imageView.setVisibility(View.GONE);

        shareLinear = (LinearLayout) card.findViewById(R.id.share_linear);
        shareLinear.setEnabled(false);


        shareLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareHoro();
            }
        });

    }

    private void getHoro() {

        databaseReference = FirebaseDatabase.getInstance().getReference().child("COMPATIBILITY").child(String.valueOf(res));
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value = dataSnapshot.getValue(String.class);
                cardContentText.setText(value);
                shareLinear.setEnabled(true);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    public static synchronized FragmentE getInstance() {
        return instance;
    }

    private void OnClick(ImageView imageView, final int pos) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CompatibilityDialog(getContext()).show();
                CompatibilityDialog.getInstance().setCompatibilityImg(pos);
            }
        });
    }

    public void calculatingRes(int x, int pos) {

        if (pos == 1) {
            img1.setImageResource(STATICS.HOROSCOPE_LOGO_C[x]);
            iv1 = x - 1;
        } else {
            iv2 = x - 1;
            img2.setImageResource(STATICS.HOROSCOPE_LOGO_C[x]);
        }


        cardViewTitle.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

        if (iv1 >= 0 && iv2 >= 0) {
            res = ((sec[iv1] * 13) % 77) * ((sec[iv2]) * 13 % 77);

            cardContentText.setText("Loading ...");


            getHoro();
        }
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
