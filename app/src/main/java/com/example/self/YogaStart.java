package com.example.self;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import pl.droidsonroids.gif.GifImageView;

public class YogaStart extends AppCompatActivity {
    Dialog dialog;
    TextView desc;
    GifImageView gifImageView;
    private final long start_time_in_miilis=300000;
    private TextView time_countdown;
    private Button start_stop,reset,start_stop_done;
    private CountDownTimer countDownTimer;
    private boolean timerRunning;
    private long time_left_in_millis=start_time_in_miilis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga_start);
        dialog=new Dialog(YogaStart.this);
        dialog.setContentView(R.layout.activity_custom_disalog);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background1));
        }

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.style.animation;

        Button okay =dialog.findViewById(R.id.btn_okay);
        Button cancel =dialog.findViewById(R.id.btn_cancel);
        okay.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast.makeText(YogaStart.this, "Okay", Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                    }
                                });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(YogaStart.this, "Cancel", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });


        start_stop_done = findViewById(R.id.start_stop_done);
        start_stop_done.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.show();

                    }
                });
        time_countdown=findViewById(R.id.timer);
        start_stop=findViewById(R.id.start_stop);
        reset=findViewById(R.id.reset);
        gifImageView=findViewById(R.id.Gif);
       // desc=findViewById(R.id.description);
        Intent intent=getIntent();
        String EXCERCISE_DESCRIPTION;
        EXCERCISE_DESCRIPTION = intent.getStringExtra(Physical1_5.EXTRAS);
        //Toast.makeText(this, ""+EXCERCISE_DESCRIPTION, Toast.LENGTH_SHORT).show();
       // desc.setText(EXCERCISE_DESCRIPTION);
        if(EXCERCISE_DESCRIPTION.equalsIgnoreCase("Siddhasana")){
            gifImageView.setImageResource(R.drawable.siddhasana1);
        }
        if(EXCERCISE_DESCRIPTION.equalsIgnoreCase("Padmasana")){
            gifImageView.setImageResource(R.drawable.padmasana1);
        }
        if(EXCERCISE_DESCRIPTION.equalsIgnoreCase("Vajrasana")){
            gifImageView.setImageResource(R.drawable.vajrasana1);
        }
        if(EXCERCISE_DESCRIPTION.equalsIgnoreCase("Sukhasana")){
            gifImageView.setImageResource(R.drawable.sukhasana1);
        }
        if(EXCERCISE_DESCRIPTION.equalsIgnoreCase("Bhujangasana")){
            gifImageView.setImageResource(R.drawable.bhujanasana1);
        }
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
