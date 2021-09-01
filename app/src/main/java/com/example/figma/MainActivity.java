package com.example.figma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import com.google.android.material.progressindicator.LinearProgressIndicator;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    LinearProgressIndicator progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        load_app();
    }

    public void load_app(){
        Intent intent = new Intent(this, MainActivity2.class);
        progressBar = (LinearProgressIndicator) findViewById(R.id.progressBar);
        final Timer t = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                counter += 2;
                progressBar.setProgressCompat(counter, true);

                if(counter==100) {
                    t.cancel();
                    startActivity(intent);
                }
            }
        };
        t.schedule(timerTask, 0, 10);
    }
}