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
    protected   int rValue=START_NOT_STICKY;
    private String returnType="";
    SharedPreferences sharedPreferences;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startId){

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                Log.i("username", "hello");
                System.out.println(sharedPreferences.getAll());
                //Toast.makeText(OptimizeService.this, sharedPreferences.getString("username","failed"), Toast.LENGTH_SHORT).show();
            }

        }, 0, 4000);
        return rValue;
    }
    @Override
    public void onCreate() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        returnType = sharedPreferences.getString("backgroundworking", null);
        if(returnType=="active"){
            rValue=START_STICKY;

        }
      //  Toast.makeText(OptimizeService.this, "Helloasdas", Toast.LENGTH_SHORT).show();
    }
}