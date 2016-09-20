package com.e_steps.abraj2.utils;

import android.app.Activity;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.e_steps.abraj2.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

public class GetData {

    private TextView textView;
    private Activity activity;
    private int sec, row, col;

    public GetData(int sec, int row, int col) {
        this.sec = sec;
        this.row = row;
        this.col = col;
    }


    public void Getdata(final Activity activity, final DatabaseReference databaseReference,
                        final ProgressBar progressBar, final TextView textView) {
        this.activity = activity;
        this.textView = textView;

        textView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!NetworkUtil.getConnectivityStatus()) {
                    progressBar.setVisibility(View.GONE);
                    textView.setVisibility(View.VISIBLE);
                    if (get()== null)
                        textView.setText("No Internet Connection");
                    else {
                        textView.setText(get());
                        Toast.makeText(activity, "khara", Toast.LENGTH_LONG).show();
                    }

                } else {
                    databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            String value = dataSnapshot.getValue(String.class);
                            store(value);
                            progressBar.setVisibility(View.GONE);
                            textView.setVisibility(View.VISIBLE);
                            textView.setText(value);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                }

            }
        }, 1000);

    }

    public void store(String text) {
        MainActivity.getmInstance().store(text, sec, row, col);

    }

    public String get() {
        return MainActivity.getmInstance().getString(sec, row, col);
    }


}
