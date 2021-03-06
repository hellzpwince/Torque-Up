package com.iammukesh.testnavi;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

import fragments.BatteryFragment;
import fragments.BlankFragment;
import fragments.GeoSettingFragement;
import fragments.RamFragment;
import fragments.SettingFragment;
import fragments.profile_fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    SharedPreferences sharedPreferences;
    public String test = "";
    public String game = "";
    public String business = "";
    public String develop = "";
    public String servicetest ="";
    public String background = "";
    public String screenKill ="";
    public String useGPStest="";
    public String optimizeAsILeavetest="";
    public String leaveNetOntest="";
    public Integer progressBar;
    CheckBox backgroundCheck;
    CheckBox screenOffKill;
    CheckBox leaveNetOn;
    CheckBox useGPS;
    CheckBox optimizeAsILeave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
         sharedPreferences = getSharedPreferences("com.iammukesh.testnavi.hellzpwince", Context.MODE_PRIVATE);
        test = sharedPreferences.getString("socialcheck", null);
        game = sharedPreferences.getString("gamecheck", null);
        progressBar=sharedPreferences.getInt("optimizelevel", 0);
        business = sharedPreferences.getString("businesscheck", null);
        develop = sharedPreferences.getString("developercheck", null);
        servicetest=sharedPreferences.getString("ServiceTest",null);
        background = sharedPreferences.getString("backgroundworking", null);
        screenKill=sharedPreferences.getString("screenoffkill", null);
        useGPStest=sharedPreferences.getString("useGPS", null);
        leaveNetOntest=sharedPreferences.getString("leaveNetOn", null);
        optimizeAsILeavetest=sharedPreferences.getString("optimizeAsILeave", null);


         Log.i("headerName",String.valueOf(game));
         Log.i("headerName",String.valueOf(develop));
         Log.i("headerName",String.valueOf(background));
         Log.i("headerName",String.valueOf(progressBar));
       // Toast.makeText(MainActivity.this, headerProfileName, Toast.LENGTH_LONG).show();
        startService();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        openFragment(new BlankFragment());
    }

    public void startService(){
    startService(new Intent(getBaseContext(),OptimizeService.class));
    }
public void changewifi(View view){
    WifiManager wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
    wifiManager.setWifiEnabled(true);
    boolean wifiEnabled = wifiManager.isWifiEnabled();
    Toast.makeText(MainActivity.this, wifiEnabled+ " " , Toast.LENGTH_SHORT).show();
    Toast.makeText(MainActivity.this, servicetest, Toast.LENGTH_SHORT).show();

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

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
    private void openFragment(final android.support.v4.app.Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment).commit();
    }
    public void closeSocialapps(View view){
        ActivityManager am = (ActivityManager) getSystemService(Activity.ACTIVITY_SERVICE);
        am.killBackgroundProcesses("com.facebook.katana");
        am.killBackgroundProcesses("com.facebook.orca");
        am.killBackgroundProcesses("com.whatsapp");
        Toast.makeText(MainActivity.this, "Major Social Apps has been closed", Toast.LENGTH_SHORT).show();
    }

    public void saveGeoSetting(View view){
        useGPS=(CheckBox)findViewById(R.id.GPScheckbox);
        optimizeAsILeave=(CheckBox)findViewById(R.id.leaveoptimize);
        leaveNetOn=(CheckBox)findViewById(R.id.networkCheckbox);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        if(useGPS.isChecked() == true) {

            editor.putString("useGPS","active");
            editor.commit();
            useGPStest = sharedPreferences.getString("useGPS",null);
        }
        else{
            sharedPreferences.edit().remove("useGPS").commit();
            useGPStest=null;
        }
        if(optimizeAsILeave.isChecked() == true) {
            editor.putString("optimizeAsILeave", "active");
            editor.commit();
            optimizeAsILeavetest = sharedPreferences.getString("optimizeAsILeave",null);
        }
        else{
            sharedPreferences.edit().remove("optimizeAsILeave").commit();
            optimizeAsILeavetest=null;
        }
        if(leaveNetOn.isChecked() == true) {
            editor.putString("leaveNetOn","active");
            editor.commit();
            leaveNetOntest = sharedPreferences.getString("leaveNetOn",null);
        }
        else{
            sharedPreferences.edit().remove("leaveNetOn").commit();
            leaveNetOntest=null;
        }
    }

    public void saveSettingPref(View view){

        backgroundCheck=(CheckBox)findViewById(R.id.remainInBackground);
        screenOffKill=(CheckBox)findViewById(R.id.screenOffKill);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        if(backgroundCheck.isChecked() == true) {
            editor.putString("backgroundworking","active");
            editor.commit();
        }
        else{
            sharedPreferences.edit().remove("backgroundworking").commit();
        }
        if(screenOffKill.isChecked()==true){
            editor.putString("screenoffkill", "active");
            editor.commit();
        }
        else{
            sharedPreferences.edit().remove("screenoffkill").commit();
        }

        Toast.makeText(this, "Setting has been saved.It will be applied after restart.", Toast.LENGTH_SHORT).show();

    }

    public void saveOptimizationProgress(View view){
        SeekBar optimizeseekbar = (SeekBar) findViewById(R.id.optimizationseekbar);

    }
    public void saveProfileOption(View view){



        CheckBox socialcheck = (CheckBox) findViewById(R.id.socialcheck);
        CheckBox gamecheck = (CheckBox) findViewById(R.id.gamecheck);
        CheckBox businesscheck = (CheckBox) findViewById(R.id.businesscheck);
        CheckBox developercheck = (CheckBox) findViewById(R.id.developercheck);
        if (socialcheck.isChecked()==true){

            SharedPreferences.Editor editor = sharedPreferences.edit();
           editor.putString("socialcheck", "active");
            editor.commit();
             test = sharedPreferences.getString("socialcheck",null);
        }
        else{
           sharedPreferences.edit().remove("socialcheck").commit();
            //sharedPreferences.edit().putString("socialcheck", null).apply();
             test = null;
        }
        if(gamecheck.isChecked()==true){

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("gamecheck", "active");
            editor.commit();

             game = sharedPreferences.getString("gamecheck",null);
        }
        else{
            sharedPreferences.edit().remove("gamecheck").commit();
            //sharedPreferences.edit().putString("socialcheck", null).apply();\
            game = null;
        }
        if(businesscheck.isChecked()==true){

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("businesscheck", "active");
            editor.commit();

             business = sharedPreferences.getString("businesscheck",null);
        }
        else{
            sharedPreferences.edit().remove("businesscheck").commit();
            //sharedPreferences.edit().putString("socialcheck", null).apply();
            business = null;
        }
        if(developercheck.isChecked()==true){

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("developercheck", "active");
            editor.commit();

             develop = sharedPreferences.getString("developercheck",null);
        }
        else{
            sharedPreferences.edit().remove("developercheck").commit();
            //sharedPreferences.edit().putString("socialcheck", null).apply();
            develop = null;
        }

        Toast.makeText(getApplicationContext(), "Profile has been updated", Toast.LENGTH_SHORT).show();
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profile) {
            openFragment(new profile_fragment());
        } else if (id == R.id.optimization) {
            openFragment(new BlankFragment());
        } else if (id == R.id.geosetting) {

            openFragment(new GeoSettingFragement());

        } else if (id == R.id.setting) {

            openFragment(new SettingFragment());

        }
        else if (id == R.id.restartservice) {

            Toast.makeText(MainActivity.this, "Restarting Service", Toast.LENGTH_SHORT).show();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
