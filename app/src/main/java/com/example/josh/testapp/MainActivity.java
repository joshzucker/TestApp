package com.example.josh.testapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener  {
    TextView AccelX;
    TextView AccelY;
    TextView AccelZ;
    private SensorManager sManager;
    private Sensor sAccel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AccelX = (TextView)findViewById(R.id.textView4);
        AccelY = (TextView)findViewById(R.id.textView5);
        AccelZ = (TextView)findViewById(R.id.textView6);



        sManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sAccel = sManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sManager.registerListener(this, sAccel, SensorManager.SENSOR_DELAY_NORMAL);



    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if (sAccel.getType() == Sensor.TYPE_ACCELEROMETER) {

            String x = Float.toString(event.values[0]);
            AccelX.setText(x);
            String y = Float.toString(event.values[1]);
            AccelY.setText(y);
            String Z = Float.toString(event.values[2]);
            AccelY.setText(Z);

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    protected void onPause() {
        super.onPause();
        sManager.unregisterListener(this);
    }



    protected void onResume() {
        super.onResume();
        sManager.registerListener(this, sAccel, SensorManager.SENSOR_DELAY_NORMAL);
    }
}
