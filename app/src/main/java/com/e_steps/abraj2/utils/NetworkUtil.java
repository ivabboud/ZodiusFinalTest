package com.e_steps.abraj2.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NetworkUtil {

    private static boolean FLAG = false;


    public static boolean getConnectivityStatus() {

        DatabaseReference networkTest = FirebaseDatabase.getInstance().getReference().child("networkTest");
        networkTest.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                if (value.contains("true"))
                    FLAG = true;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return FLAG;
    }
}