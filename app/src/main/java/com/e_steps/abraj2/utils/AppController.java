package com.e_steps.abraj2.utils;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;

public class AppController extends Application {
    private static AppController mInstance;
    private Typeface flat;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        sharedPreferences = mInstance.getSharedPreferences("db", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        flat = Typeface.createFromAsset(this.getResources().getAssets(), "flat.ttf");

    }

    public void setSymbolsTypes(boolean bool) {
        editor.putBoolean("symbol_type", bool).commit();
    }

    public boolean getSymbolsTypes() {
        return sharedPreferences.getBoolean("symbol_type", false);
    }

    public void setColorNum(int color_num) {
        editor.putInt("color_num", color_num).commit();
    }

    public int getColorNum() {
        return sharedPreferences.getInt("color_num", 0);
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public Typeface getFont() {
        return flat;
    }

    public void setCompatibilityImg1(int first) {editor.putInt("first"  , first).commit();}
    public void setCompatibilityImg2(int second) {editor.putInt("second"  , second).commit();}

    public int getCompatibilityImg1(){return sharedPreferences.getInt("first" , 0);}
    public int getCompatibilityImg2(){return sharedPreferences.getInt("second" , 0);}

}
