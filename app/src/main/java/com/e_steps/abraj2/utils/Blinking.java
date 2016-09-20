package com.e_steps.abraj2.utils;


import android.app.Activity;
import android.os.Handler;
import android.widget.TextView;

public class Blinking {

    private Activity activity;
    private int count, retry;
    private Handler handler;
    private Runnable runnable;
    private TextView textView;

    public Blinking(Activity _activity, TextView _textView) {

        this.textView = _textView;
        this.activity = _activity;

        retry = 0;
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {

                if (count == 0) {
                    textView.setText("Loading    ");
                    count++;
                } else if (count == 1) {
                    textView.setText("Loading .  ");
                    count++;
                } else if (count == 2) {
                    textView.setText("Loading .. ");
                    count++;
                } else if (count == 3) {
                    textView.setText("Loading ...");
                    startBlinking();
                    retry++;
                }
            }
        };

    }

    public void startBlinking() {
        count = 0;
        if (retry == 2) {
            retry = 0;
            if (NetworkUtil.getConnectivityStatus() ) {
                stopBlinkingAndSetText("No Internet Connection");
            } else {
                startBlinking();
            }
        } else {
            handler.postDelayed(runnable, 500);
            handler.postDelayed(runnable, 1000);
            handler.postDelayed(runnable, 1500);
            handler.postDelayed(runnable, 2000);
        }
    }

    public void stopBlinking() {
        handler.removeCallbacks(runnable);
    }

    public void startOver() {
        retry = 0;
        startBlinking();
    }

    public void stopBlinkingAndSetText(String text) {
        handler.removeCallbacks(runnable);
        textView.setText(text);
    }
}