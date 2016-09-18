package com.e_steps.abraj2.Dialogs;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.e_steps.abraj2.Fragments.E_Compatibility.FragmentE;
import com.e_steps.abraj2.R;
import com.e_steps.abraj2.utils.AppController;
import com.e_steps.abraj2.utils.STATICS;

@SuppressWarnings("ConstantConditions")
public class CompatibilityDialog extends AlertDialog {
    private Context context;
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12;
    private View view1, view2, view3, view4;


    private static CompatibilityDialog cInstance;


    public CompatibilityDialog(Context context) {
        super(context);
        this.context = context;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cInstance = this;
        setContentView(R.layout.dialog_compatibility);
        findView();
    }

    public static synchronized CompatibilityDialog getInstance() {
        return cInstance;
    }


    public void setCompatibilityImg(int pos) {

        OnClick(img1, pos, 1);
        OnClick(img2, pos, 2);
        OnClick(img3, pos, 3);
        OnClick(img4, pos, 4);
        OnClick(img5, pos, 5);
        OnClick(img6, pos, 6);
        OnClick(img7, pos, 7);
        OnClick(img8, pos, 8);
        OnClick(img9, pos, 9);
        OnClick(img10, pos, 10);
        OnClick(img11, pos, 11);
        OnClick(img12, pos, 12);
    }


    private void findView() {

        TextView cancel = (TextView) findViewById(R.id.cancel_text);
        view1 = findViewById(R.id.linear1);
        view2 = findViewById(R.id.linear2);
        view3 = findViewById(R.id.linear3);
        view4 = findViewById(R.id.linear4);

        img1 = (ImageView) view1.findViewById(R.id.img1);
        img2 = (ImageView) view1.findViewById(R.id.img2);
        img3 = (ImageView) view1.findViewById(R.id.img3);


        img4 = (ImageView) view2.findViewById(R.id.img1);
        img5 = (ImageView) view2.findViewById(R.id.img2);
        img6 = (ImageView) view2.findViewById(R.id.img3);


        img7 = (ImageView) view3.findViewById(R.id.img1);
        img8 = (ImageView) view3.findViewById(R.id.img2);
        img9 = (ImageView) view3.findViewById(R.id.img3);


        img10 = (ImageView) view4.findViewById(R.id.img1);
        img11 = (ImageView) view4.findViewById(R.id.img2);
        img12 = (ImageView) view4.findViewById(R.id.img3);


        img1.setImageResource(R.drawable.aries_c);
        img2.setImageResource(R.drawable.taurus_c);
        img3.setImageResource(R.drawable.gemini_c);
        img4.setImageResource(R.drawable.cancer_c);
        img5.setImageResource(R.drawable.leo_c);
        img6.setImageResource(R.drawable.virgo_c);
        img7.setImageResource(R.drawable.libra_c);
        img8.setImageResource(R.drawable.scorpio_c);
        img9.setImageResource(R.drawable.sagittarius_c);
        img10.setImageResource(R.drawable.capricorn_c);
        img11.setImageResource(R.drawable.aquarius_c);
        img12.setImageResource(R.drawable.pisces_c);


        img1.setColorFilter(context.getResources().getColor(STATICS.COLORS_PRIMARY[AppController.getInstance().getColorNum()]));
        img2.setColorFilter(context.getResources().getColor(STATICS.COLORS_PRIMARY[AppController.getInstance().getColorNum()]));
        img3.setColorFilter(context.getResources().getColor(STATICS.COLORS_PRIMARY[AppController.getInstance().getColorNum()]));
        img4.setColorFilter(context.getResources().getColor(STATICS.COLORS_PRIMARY[AppController.getInstance().getColorNum()]));
        img5.setColorFilter(context.getResources().getColor(STATICS.COLORS_PRIMARY[AppController.getInstance().getColorNum()]));
        img6.setColorFilter(context.getResources().getColor(STATICS.COLORS_PRIMARY[AppController.getInstance().getColorNum()]));
        img7.setColorFilter(context.getResources().getColor(STATICS.COLORS_PRIMARY[AppController.getInstance().getColorNum()]));
        img8.setColorFilter(context.getResources().getColor(STATICS.COLORS_PRIMARY[AppController.getInstance().getColorNum()]));
        img9.setColorFilter(context.getResources().getColor(STATICS.COLORS_PRIMARY[AppController.getInstance().getColorNum()]));
        img10.setColorFilter(context.getResources().getColor(STATICS.COLORS_PRIMARY[AppController.getInstance().getColorNum()]));
        img11.setColorFilter(context.getResources().getColor(STATICS.COLORS_PRIMARY[AppController.getInstance().getColorNum()]));
        img12.setColorFilter(context.getResources().getColor(STATICS.COLORS_PRIMARY[AppController.getInstance().getColorNum()]));


    }


    private void OnClick(ImageView imageView, final int pos, final int x) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(pos==1)
                    AppController.getInstance().setCompatibilityImg1(x);
                else
                    AppController.getInstance().setCompatibilityImg2(x);


                FragmentE.getInstance().calculatingRes(x, pos);
                CompatibilityDialog.getInstance().dismiss();

            }
        });

    }

}
