package com.example.self;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class stepcounter extends AppCompatActivity implements SensorEventListener {
    private TextView textViewStepCounter, textViewStepDetector;
    private SensorManager sensorManager;
    private Sensor mStepCounter, mStepDetector;
    boolean isCounterSensorPresent, isDetectorSensorPresent;

    int stepCount=0, stepDetect=0;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepcounter);

        if(ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACTIVITY_RECOGNITION) == PackageManager.PERMISSION_DENIED){ //ask for permission
            requestPermissions(new String[]{Manifest.permission.ACTIVITY_RECOGNITION}, 0);
        }


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        textViewStepCounter = findViewById(R.id.textViewStepCounter);
        textViewStepDetector = findViewById(R.id.textViewStepDetector);


        sensorManager= (SensorManager) getSystemService(SENSOR_SERVICE);


        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) !=null) {
            mStepCounter = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            isCounterSensorPresent = true;
        }
        else{
            textViewStepCounter.setText("Counter Sensor is not Present");
            isCounterSensorPresent = false;
        }
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR)!=null){
            mStepDetector= sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
            isDetectorSensorPresent= true;
        }else{
            textViewStepDetector.setText("Detector Sensor is not Present");
            isDetectorSensorPresent= false;
        }

    }



    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
       if(sensorEvent.sensor ==mStepCounter) {
           stepCount= (int) sensorEvent.values[0];
           textViewStepCounter.setText(String.valueOf(stepCount));
       }else if(sensorEvent.sensor == mStepDetector)
           stepDetect= (int) (stepDetect+sensorEvent.values[0]);
       textViewStepDetector.setText(String.valueOf(stepDetect));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) !=null)
            sensorManager.registerListener(this,mStepCounter,SensorManager.SENSOR_DELAY_NORMAL);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) !=null)
            sensorManager.registerListener(this,mStepDetector,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER) !=null)
            sensorManager.unregisterListener(this,mStepCounter);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR) !=null)
            sensorManager.unregisterListener(this,mStepDetector);

    }
}