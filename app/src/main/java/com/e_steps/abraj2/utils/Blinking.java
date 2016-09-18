package com.e_steps.abraj2.utils;


import android.os.Handler;
import android.widget.TextView;

public class Blinking {

    private int count;
    private Handler handler;
    private Runnable runnable;
    private TextView textView;

    public Blinking(TextView _textView) {

        this.textView = _textView;
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
                    count = 0;
                    startBlinking();
                }
            }
        };

    }

    public void startBlinking() {
        count = 0;
        handler.postDelayed(runnable, 500);
        handler.postDelayed(runnable, 1000);
        handler.postDelayed(runnable, 1500);
        handler.postDelayed(runnable, 2000);
    }

    public void stopBlinking() {
        handler.removeCallbacks(runnable);
    }


    public void stopBlinkingAndSetText(String text) {
        handler.removeCallbacks(runnable);
        textView.setText(text);
    }

}