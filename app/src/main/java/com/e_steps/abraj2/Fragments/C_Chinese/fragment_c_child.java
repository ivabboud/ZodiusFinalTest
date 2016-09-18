package com.e_steps.abraj2.Fragments.C_Chinese;

import android.graphics.Color;
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


public class fragment_c_child extends Fragment {
    public static final String ARG_TAB = "ARG_TAB";
    public int mTab;
    private TextView child_text;

    DatabaseReference databaseReference;
    private int[]icon = {R.drawable.rat ,R.drawable.ox,R.drawable.tiger,R.drawable.rabbit , R.drawable.dragon
            ,R.drawable.snake , R.drawable.horse , R.drawable.goat , R.drawable.monkey,R.drawable.rooster
            ,R.drawable.dog,R.drawable.pig};


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_c_child, container, false);


        ((ImageView)view.findViewById(R.id.horo_icon)).setImageResource(icon[mTab]);
        ((ImageView)view.findViewById(R.id.horo_icon)).setColorFilter(getResources().getColor(R.color.Blue_Dark));





        getHoro(mTab);
        return view;
    }

    private void getHoro(int mTab) {

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Cancer").child("Today");
    }

    public static fragment_c_child newInstance(int tab) {
        Bundle args = new Bundle();
        args.putInt(ARG_TAB, tab);
        fragment_c_child fragment = new fragment_c_child();
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

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                child_text.setText(databaseError.toString());

            }
        });




    }
}
