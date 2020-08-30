package com.example.clock_spider;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

public class AlertReciever extends BroadcastReceiver {
    public static MediaPlayer mediaPlayer;
    @Override
    public void onReceive(Context context, Intent intent) {
        int ringtone  = intent.getIntExtra("ringtone",0);
        int intentwhich = intent.getIntExtra("intentwhich",0);
        String label = intent.getStringExtra("alarmlabel");
//        Log.i("label",label);
        switch (ringtone){
            case 0:
                mediaPlayer= MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
                break;
            case 1:
                mediaPlayer= MediaPlayer.create(context, R.raw.alarmclock01);
                break;
            case 2:
                mediaPlayer= MediaPlayer.create(context, R.raw.alarm);
                break;
            case 3:
                mediaPlayer= MediaPlayer.create(context, R.raw.leopard3);
                break;
            case 4:
                mediaPlayer= MediaPlayer.create(context, R.raw.duck_audio);
                break;
            case 5:
                mediaPlayer= MediaPlayer.create(context, R.raw.alarm);
                break;
            case 6:
                mediaPlayer= MediaPlayer.create(context, R.raw.alarmclock01);
                break;
            case 7:
                mediaPlayer= MediaPlayer.create(context, R.raw.leopard3);
                break;
            default:
                mediaPlayer= MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        }

        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        Log.i("currenttime",Long.toString(System.currentTimeMillis()));


        if(intentwhich==0) {

            NotificationHelper notificationHelper = new NotificationHelper(context);
            NotificationCompat.Builder nb = notificationHelper.getChannelNotifiaction("Alarmer", label);
            notificationHelper.getManager().notify(1, nb.build());
        }else{
            Intent intent1 = new Intent(context,AlarmService.class);
            intent1.putExtra("labelname",label);
            ContextCompat.startForegroundService(context,intent1);
        }

    }
}
