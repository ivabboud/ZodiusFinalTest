package com.e_steps.abraj2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.e_steps.abraj2.Fragments.A_Daily.FragmentA;
import com.e_steps.abraj2.Fragments.B_Yearly.FragmentB;
import com.e_steps.abraj2.Fragments.C_Chinese.FragmentC;
import com.e_steps.abraj2.Fragments.D_Characters.FragmentD;
import com.e_steps.abraj2.Fragments.E_Compatibility.FragmentE;
import com.e_steps.abraj2.utils.AppController;
import com.e_steps.abraj2.utils.Blinking;
import com.e_steps.abraj2.utils.STATICS;
import com.e_steps.abraj2.utils.Wifi_Blinking;

@SuppressWarnings("ConstantConditions")
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private static MainActivity mInstance;
    ImageView wifi;
    private TextView toolbar_title;
    private Wifi_Blinking wifi_blinking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

mInstance = this;




        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        toolbar_title = (TextView) findViewById(R.id.toolbar_title);
        toolbar_title.setTypeface(AppController.getInstance().getFont(), Typeface.BOLD);


        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.nav_a);
            showFragment(0);
        }

         wifi = (ImageView) findViewById(R.id.toolbar_icon);

        wifi_blinking = new Wifi_Blinking(this, wifi);
        wifi_blinking.startBlinking();

    }

    public Wifi_Blinking get_wifi()
    {
        return wifi_blinking;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_a) {
            showFragment(0);
        } else if (id == R.id.nav_b) {
            showFragment(1);
        } else if (id == R.id.nav_c) {
            showFragment(2);
        } else if (id == R.id.nav_d) {
            showFragment(3);
        } else if (id == R.id.nav_e) {
            showFragment(4);

        } else if (id == R.id.nav_setting) {

        } else if (id == R.id.nav_moreapps) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragment(int position) {

        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new FragmentA();
                break;
            case 1:
                fragment = new FragmentB();
                break;

            case 2:
                fragment = new FragmentC();
                break;
            case 3:
                fragment = new FragmentD();
                break;
            case 4:
                fragment=new FragmentE();
                break;

            default:
                fragment = new FragmentA();
                break;
        }

        toolbar_title.setText(STATICS.TOOLBAR_TITLE[position]);


        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.commit();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    public static synchronized MainActivity getmInstance()
    {return mInstance;}

}
