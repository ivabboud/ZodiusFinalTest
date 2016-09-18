package com.e_steps.abraj2.utils;


import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.e_steps.abraj2.R;

public class Wifi_Blinking {

    private int count;
    private int []wifi = {R.drawable.wifi1 , R.drawable.wifi2 , R.drawable.wifi3 , R.drawable.wifi};
    private Handler handler;
    private Runnable runnable;
    private ImageView imageView;
    private Activity activity;
    private int res=0;

    public Wifi_Blinking(Activity _activity , ImageView _imageview) {

        this.imageView = _imageview;
        this.activity = _activity;
        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                imageView.setColorFilter(activity.getResources().getColor(R.color.colorAccent));

                if (count == 0) {
                    imageView.setImageResource(wifi[0]);

                    count++;
                } else if (count == 1) {
                    imageView.setImageResource(wifi[1]);

                    count++;
                } else if (count == 2) {
                    imageView.setImageResource(wifi[2]);


                    count++;
                } else if (count == 3) {
                    imageView.setImageResource(wifi[3]);

                    count = 0;
                    startBlinking();

                    res++;
                }
            }
        };

    }

    public void startBlinking() {


        count = 0;
        if(res==2)
        {
            res=0;
            if(NetworkUtil.getConnectivityStatus(activity) == 0)
            {
                stopBlinking();
                imageView.setImageResource(wifi[3]);
                imageView.setColorFilter(activity.getResources().getColor(R.color.colorPrimaryDark));
            }
            else
            {
                stopBlinking();
                imageView.setImageResource(R.drawable.wifi);
                imageView.setColorFilter(activity.getResources().getColor(R.color.white_f5));
            }
        }
        else {
            handler.postDelayed(runnable, 500);
            handler.postDelayed(runnable, 1000);
            handler.postDelayed(runnable, 1500);
            handler.postDelayed(runnable, 2000);

        }
    }

    public void stopBlinking() {
        handler.removeCallbacks(runnable);
    }



}