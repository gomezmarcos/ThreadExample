package com.example.android.ejerciciothreads;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Handler.Callback{
    Thread thread;
    Handler handler = new Handler(this);
    TextView txt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = (TextView) findViewById(R.id.text);

        Thread thread = new MyThread(this.handler);
        thread.start();

    }

    @Override
    protected void onStop() {
        super.onStop();
        thread = Thread.currentThread();
        if (thread.isAlive()){
            thread.interrupt();
        }
    }

    @Override
    public boolean handleMessage(Message msg) {
        //txt.setText(String.valueOf(msg.obj));
        TextView txt1 = (TextView) findViewById(R.id.text);
        txt1.setText(String.valueOf(msg.obj));
        return true;
    }
}
