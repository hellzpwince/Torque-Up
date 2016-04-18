package com.iammukesh.testnavi;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mukeshjoshi on 02/03/16.
 */
public class OptimizeService extends Service{

    /*Variable declaration
    *
    * Optimize Service is responsible for all background work
    *
    * We are using SharedPreferences to store our Key values
    *
    * */
    private int interval=4000;
    private String returnType="";
    SharedPreferences sharedPreferences;
    public String test = "";
    public String game = "";
    public String business = "";
    public String develop = "";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId) {



    /*Fetching all the stored values from SharedPreferences*/

        sharedPreferences = getSharedPreferences("com.iammukesh.testnavi.hellzpwince", Context.MODE_PRIVATE);
        test = sharedPreferences.getString("socialcheck", null);
        game = sharedPreferences.getString("gamecheck", null);
        business = sharedPreferences.getString("businesscheck", null);
        develop = sharedPreferences.getString("developercheck", null);
        returnType = sharedPreferences.getString("backgroundworking", null);

        /*rValue variable defines whether background service will stick in background or not.*/
        /*Using Timer to perform background job*/
        /*Timer's interval time is based on serveral factors like Optimization level and GEO location*/


        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                test = sharedPreferences.getString("socialcheck", null);
                game = sharedPreferences.getString("gamecheck", null);
                business = sharedPreferences.getString("businesscheck", null);
                develop = sharedPreferences.getString("developercheck", null);
                returnType = sharedPreferences.getString("backgroundworking", null);
              if(returnType==null){
                Log.i("username", "mukesh");}
                else{
                  Log.i("Username","Joshi");
              }
                /*Log.i("background", returnType);*/
            }

        }, 0, interval);
        if (returnType == null) {
            return START_NOT_STICKY;

        } else {
            return START_STICKY;
        }
    }
    @Override
    public void onCreate() {

        /*This function will run as service activity is created*/
        /*We are assigning sharedprefernce object*/
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

      //  Toast.makeText(OptimizeService.this, "Helloasdas", Toast.LENGTH_SHORT).show();
    }
}