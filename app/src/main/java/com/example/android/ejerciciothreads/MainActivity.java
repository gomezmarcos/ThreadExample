package com.example.android.ejerciciothreads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread thread = new MyThread();
        thread.start();

        int i = 0;
        while (true){
            try {
                Thread.sleep(3000l);
                Log.e("MainAcitivity", String.valueOf(i++));
            } catch (InterruptedException e) {
                e.printStackTrace();
                return; //para forzar que se salga del while
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        thread = Thread.currentThread();
        if (thread.isAlive()){
            thread.interrupt();
        }
    }
}
