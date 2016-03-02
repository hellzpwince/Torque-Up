package com.iammukesh.testnavi;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mukeshjoshi on 02/03/16.
 */
public class OptimizeService extends Service{
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
                Log.i("username","hello");
                //Toast.makeText(OptimizeService.this, "Hello", Toast.LENGTH_SHORT).show();
            }

        }, 0, 4000);

        return START_STICKY;
    }
}