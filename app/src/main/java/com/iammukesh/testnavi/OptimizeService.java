package com.iammukesh.testnavi;

import android.app.ActivityManager;
import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;
import java.util.List;
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
    private int interval=1000;
    private String returnType="";
    SharedPreferences sharedPreferences;
    private String test = "";
    private String game = "";
    private String business = "";
    private String develop = "";
    public String servicetest ="";
    private int optimizeLevel=0;
    public String background = "";
    public String screenKill ="";
    public Integer progressBar;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId) {
        boolean screenOn = intent.getBooleanExtra("screen_state", false);
        if (!screenOn) {
            Log.i("service","Screen On");
            optimizeApps();
        } else {
            Log.i("service","Screen OFF");
        }
    /*Fetching all the stored values from SharedPreferences*/

        sharedPreferences = getSharedPreferences("com.iammukesh.testnavi.hellzpwince", Context.MODE_PRIVATE);
        test = sharedPreferences.getString("socialcheck", null);
        game = sharedPreferences.getString("gamecheck", null);
        business = sharedPreferences.getString("businesscheck", null);
        develop = sharedPreferences.getString("developercheck", null);
        returnType = sharedPreferences.getString("backgroundworking", null);
        optimizeLevel=sharedPreferences.getInt("optimizelevel", 0);
        background = sharedPreferences.getString("backgroundworking", null);
        /*rValue variable defines whether background service will stick in background or not.*/
        /*Using Timer to perform background job*/
        /*Timer's interval time is based on serveral factors like Optimization level and GEO location*/

        interval=interval_For_Service(optimizeLevel);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                test = sharedPreferences.getString("socialcheck", null);
                game = sharedPreferences.getString("gamecheck", null);
                progressBar=sharedPreferences.getInt("optimizelevel", 0);
                business = sharedPreferences.getString("businesscheck", null);
                develop = sharedPreferences.getString("developercheck", null);
                servicetest=sharedPreferences.getString("ServiceTest",null);
                background = sharedPreferences.getString("backgroundworking", null);
                screenKill=sharedPreferences.getString("screenoffkill", null);
                optimizeApps();
                Log.i("background", String.valueOf(interval));
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
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_ON);
        filter.addAction(Intent.ACTION_SCREEN_OFF);
        BroadcastReceiver mReceiver = new ScreenReceiver();
        registerReceiver(mReceiver, filter);
      //  Toast.makeText(OptimizeService.this, "Helloasdas", Toast.LENGTH_SHORT).show();
    }

    private void optimizeApps(){

         String[] SocialAppList={
                 "com.whatsapp",
                 "com.facebook.orca",
                 "com.facebook.katana",
                 "com.facebook.lite",
                 "com.tencent.mm",
                 "com.twitter.android",
                 "com.snapchat.android",
                 "co.vine.android",
                 "com.instagram.android",
                 "com.tumblr",
                 "com.yik.yak",
                 "com.timehop",
                 "kik.android",
                 "com.pinterest",
                 "com.linkedin.android"
        };
        String[] gamesApps={
                "com.kiloo.subwaysurf",
                "com.imangi.templerun2",
                "com.ffgames.racingincar",
                "com.outfit7.mytalkingtomfree",
                "com.skgames.trafficrider",
                "com.king.candycrushjellysaga",
                "com.fingersoft.hillclimb",
                "com.wb.goog.injustice",
                "com.wb.goog.bvs.www",
                "com.wb.goog.lbbg",
                "com.lego.superheroes.dccomicsmightymicros",
                "com.wb.goog.legobdc",
                "com.gameloft.android.ANMP.GloftA8HM",
                "com.outfit7.talkingtom2free",
                "com.rovio.angrybirds",
                "ppl.unity.JuiceCubesBeta",
                "com.bigduckgames.flow",
                "com.zapak.worldcup.t20.cricket",
                "org.cocos2dx.NautilusCricket2014",
                "com.games2win.powercrickett20",
                "com.cmplay.tiles2",
                "com.ketchapp.stack",
                "com.supercell.clashroyale",
                "com.supercell.clashofclans",
                "com.king.candycrushsaga",
                "software.simplicial.nebulous",
                "com.mojang.minecraftpe",
                "com.halfbrick.jetpackjoyride",
                "com.netmarble.mherosgb",
                "com.ea.game.pvz2_row",
                "com.supercell.hayday",
                "com.kabam.marvelbattle",
                "com.halfbrick.monsterdash",
                "com.omgpop.dstfree",
                "com.estoty.game2048",
                "com.nekki.shadowfight",
                "com.gameloft.android.ANMP.GloftM5HM",
                "com.activision.callofduty.heroes",
                "com.squareenixmontreal.hitmansniperandroid",
                "com.glu.deerhunt2",
                "com.gameloft.android.ANMP.GloftM5HM",
                "air.StickSquad3Android",
                "com.rolocule.projectz",
                "com.dreamsky.DiabloLOL",
                "com.jumpgames.RealSteel",
                "com.gameloft.android.ANMP.GloftASHM",
                "com.rockstargames.gtasa",
                "com.jumpgames.pacificrim"
        };
        String[] businessApps={
                "com.google.android.apps.docs.editors.docs",
                "com.microsoft.office.word",
                "com.adobe.reader",
                "com.microsoft.office.excel",
                "com.google.android.apps.docs.editors.sheets",
                "com.google.android.calendar",
                "com.aadhk.woinvoice",
                "com.invoice2go.invoice2goplus",
                "com.zoho.invoice",
                "com.freelancer.android.messenger",
                "com.evernote",
                "com.dropbox.android",
                "com.microsoft.skydrive",
                "com.google.android.apps.docs",
        };


        String[] developerApps={

        };
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningAppProcessInfo = am.getRunningAppProcesses();

        if(test==null || game==null || develop==null || business==null){
            for (int i = 0; i < runningAppProcessInfo.size(); i++) {
                            am.killBackgroundProcesses(runningAppProcessInfo.get(i).processName);
                        }
                    }
        else {
            for (int i = 0; i < runningAppProcessInfo.size(); i++) {
                if (test == null) {
                    for (int j = 0; j < SocialAppList.length; j++) {
                        if (runningAppProcessInfo.get(i).processName.equals(SocialAppList[j])) {
                            am.killBackgroundProcesses(SocialAppList[j]);
                        }
                    }

                }
                if (game == null) {
                    for (int j = 0; j < gamesApps.length; j++) {
                        if (runningAppProcessInfo.get(i).processName.equals(gamesApps[j])) {
                            am.killBackgroundProcesses(gamesApps[j]);
                        }
                    }

                }

                if (develop == null) {
                    for (int j = 0; j < developerApps.length; j++) {
                        if (runningAppProcessInfo.get(i).processName.equals(developerApps[j])) {
                            am.killBackgroundProcesses(developerApps[j]);
                        }
                    }

                }

                if (business == null) {
                    for (int j = 0; j < businessApps.length; j++) {
                        if (runningAppProcessInfo.get(i).processName.equals(businessApps[j])) {
                            am.killBackgroundProcesses(businessApps[j]);
                        }
                    }

                }

            }
        }
    }


    private int interval_For_Service(int optimizeLevel){
        if(optimizeLevel==100){
            return 5000*12*30;
        }//30 minutes
       else if(optimizeLevel>80){
            return 5000*12*60;
        }//60 minutes
        else if(optimizeLevel>50){
            return 5000*12*120;
        }//2 Hr
        else if(optimizeLevel>30){
            return 5000*12*180;
        }//3 hr
        else{
            return 5000*12*240;
        }//4 hr
    }
}