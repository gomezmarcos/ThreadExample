package com.example.android.ejerciciothreads;

import android.util.Log;

/**
 * Created by android on 08/10/15.
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        while (true){
            try {
                sleep(6000l);
                Log.d("MyThread", "escribiendo..");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
