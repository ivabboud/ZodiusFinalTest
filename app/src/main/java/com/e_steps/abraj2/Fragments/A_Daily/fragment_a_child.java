package com.e_steps.abraj2.Fragments.A_Daily;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.e_steps.abraj2.R;
import com.e_steps.abraj2.utils.AppController;
import com.e_steps.abraj2.utils.STATICS;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class fragment_a_child extends Fragment {
    public static final String ARG_TAB = "ARG_TAB";
    public int mTab;
    private TextView child_text;
    private String str;
    DatabaseReference databaseReference;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a_child, container, false);

        ((TextView)view.findViewById(R.id.horo)).setTypeface(AppController.getInstance().getFont());
        ((TextView)view.findViewById(R.id.from_to_text)).setTypeface(AppController.getInstance().getFont());
        ((TextView)view.findViewById(R.id.alias)).setTypeface(AppController.getInstance().getFont());
        ((TextView)view.findViewById(R.id.child_text)).setTypeface(AppController.getInstance().getFont());


        child_text = (TextView)view.findViewById(R.id.child_text);
        ((TextView)view.findViewById(R.id.from_to_text)).setText(STATICS.HOROSCOPE_EN_FROM_TO[mTab]);
        ((TextView)view.findViewById(R.id.horo)).setText(STATICS.HOROSCOPE_EN[mTab]);
        ((TextView)view.findViewById(R.id.alias)).setText( STATICS.HOROSCOPE_TYPES_EN[mTab]);
        ((ImageView)view.findViewById(R.id.type_logo)).setImageResource(STATICS.HOROSCOPE_TYPES_LOGO[mTab]);
        ((ImageView)view.findViewById(R.id.horo_icon)).setImageResource(STATICS.HOROSCOPE_LOGO[mTab]);


        getHoro(mTab);
        return view;
    }

    private void getHoro(int mTab) {
        str=STATICS.HOROSCOPE_EN[mTab];
        databaseReference = FirebaseDatabase.getInstance().getReference().child("COMPATIBILITY").child("546");
    }

    public static fragment_a_child newInstance(int tab) {
        Bundle args = new Bundle();
        args.putInt(ARG_TAB, tab);
        fragment_a_child fragment = new fragment_a_child();
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


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                child_text.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                child_text.setText(databaseError.toString());

            }
        });




    }
}
