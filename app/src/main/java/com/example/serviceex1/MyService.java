package com.example.serviceex1;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        // If we get killed, after returning from here, restart
        for (int i = 0; i < 5; i++) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                }
            }, 5000);
            Toast.makeText(this, "Loop: "+i, Toast.LENGTH_LONG).show();
        }
        stopSelf(startId);
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Service Destroyed",Toast.LENGTH_LONG).show();
    }

}