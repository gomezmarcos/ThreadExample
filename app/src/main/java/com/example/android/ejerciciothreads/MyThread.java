package com.example.android.ejerciciothreads;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.UiThread;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by android on 08/10/15.
 */
public class MyThread extends Thread{

    private final Handler handler;

    public MyThread(Handler handler){
        this.handler = handler;
    }

    @Override
    public void run() {
        for (int i = 0; i<10; i++){
            try {
                sleep(2000l);
                Log.d("MyThread", "escribiendo..");

                Message message = new Message();
                message.obj = "modificado desde el thread "+String.valueOf(i);
                handler.sendMessage(message);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
