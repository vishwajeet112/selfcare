package com.example.self;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class physical1_5_start extends AppCompatActivity {
    TextView desc;
 private final long start_time_in_miilis=300000;
 private TextView time_countdown;
 private Button start_stop,reset;
 private CountDownTimer countDownTimer;
 private boolean timerRunning;
 private long time_left_in_millis=start_time_in_miilis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physical15_start);
        time_countdown=findViewById(R.id.timer);
        start_stop=findViewById(R.id.start_stop);
        reset=findViewById(R.id.reset);
        desc=findViewById(R.id.description);
        Intent intent=getIntent();
        String EXCERCISE_DESCRIPTION;
        EXCERCISE_DESCRIPTION = intent.getStringExtra(Physical1_5.EXTRAS);
        desc.setText(EXCERCISE_DESCRIPTION);
        start_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(timerRunning){
                    stopTimer();
                } else{
                    startTimer();
                }

            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetTimer();
            }
        });
        updateTimerText();
    }
            private void startTimer(){
            countDownTimer=new CountDownTimer(time_left_in_millis,1000) {
                @Override
                public void onTick(long l) {
                 time_left_in_millis=l;
                 updateTimerText();
                }

                @Override
                public void onFinish() {
                timerRunning=false;
                start_stop.setText("Start");
                start_stop.setVisibility(View.INVISIBLE);
                reset.setVisibility(View.VISIBLE);
                }
            }.start();
            timerRunning=true;
            start_stop.setText("Stop");
            reset.setVisibility(View.INVISIBLE);
            }
    private void stopTimer(){
    countDownTimer.cancel();
    timerRunning=false;
    start_stop.setText("Start");
    reset.setVisibility(View.VISIBLE);
    }
    private void resetTimer(){
        time_left_in_millis=start_time_in_miilis;
        updateTimerText();
        reset.setVisibility(View.INVISIBLE);
        start_stop.setVisibility(View.VISIBLE);

    }
    private void updateTimerText(){
        int minutes=(int)(time_left_in_millis/1000)/60;
        int seconds=(int)(time_left_in_millis/1000)%60;
        String timeLeftFormatted=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        time_countdown.setText(timeLeftFormatted);
    }
}