package com.example.travelloggedin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class track extends AppCompatActivity //implements LocationListener
{
    //public LocationManager locationManager;
    //protected LocationListener locationListener;
    //TextView txtLat;
    TextView timerset;
    Button start,end;
    CountDownTimer time;
    EditText minutes;
    int min = 120000; // 2 Minutes
    boolean timerstat = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        minutes = findViewById(R.id.minutes);
        timerset = findViewById(R.id.timer);
        start = findViewById(R.id.button6);
        end = findViewById(R.id.button7);
        minutes = findViewById(R.id.minutes);



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    min = Integer.parseInt(minutes.getText().toString())*60*1000;
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"Enter digits !",Toast.LENGTH_LONG).show();
                }
                if(timerstat == true){
                    Toast.makeText(getApplicationContext(),"Timer already running !",Toast.LENGTH_LONG).show();
                }
                else {
                    time = new CountDownTimer(min, 1000) {
                        public void onTick(long millisUntilFinished) {
                            // Used for formatting digit to be in 2 digits only
                            NumberFormat f = new DecimalFormat("00");
                            long hour = (millisUntilFinished / 3600000) % 24;
                            long min = (millisUntilFinished / 60000) % 60;
                            long sec = (millisUntilFinished / 1000) % 60;
                            timerset.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));
                        }

                        // When the task is over it will print 00:00:00 there
                        public void onFinish() {
                            timerset.setText("00:00:00");
                            Toast.makeText(getApplicationContext(), "Alert sent to your immediate contacts !", Toast.LENGTH_LONG).show();
                        }
                    };
                    time.start();
                    timerstat = true;
                }

            }
        });

        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    time.cancel();
                    timerset.setText("00:00:00");
                    timerstat = false;
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"Tracking stopped",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}