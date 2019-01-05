package com.example.ocean.yawza;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Tapper extends AppCompatActivity {

    int count = 0;
    //int timeCount = 20;
    int score = 0;

    CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tapper);

        final TextView countDisplay = findViewById(R.id.countText);
        final TextView timerDisplay = findViewById(R.id.timer_text);
        final TextView hiScore = findViewById(R.id.hi_score_text);
        final ImageView refresh = findViewById(R.id.refresh_btn);
        final Button btn = findViewById(R.id.count_btn);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                btn.setEnabled(true);
                countDisplay.setText("0");
                timerDisplay.setText("20");
                hiScore.setText("HiScore: "+score);
                countDownTimer.start();

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    count++;
                    if (count % 25 == 0 ) {
                        //Toast.makeText(getApplicationContext().getApplicationContext(), "score: "+count,Toast.LENGTH_SHORT).show();
                        if (count == 25) {
                            Toast.makeText(getApplicationContext().getApplicationContext(), "Nice: "+count,Toast.LENGTH_SHORT).show();
                        } else if (count == 50) {
                            Toast.makeText(getApplicationContext().getApplicationContext(), "Good: "+count,Toast.LENGTH_SHORT).show();
                        } else if (count == 75) {
                            Toast.makeText(getApplicationContext().getApplicationContext(), "Solid: "+count,Toast.LENGTH_SHORT).show();
                        } else if (count == 100) {
                            Toast.makeText(getApplicationContext().getApplicationContext(), "Super: "+count+"!",Toast.LENGTH_SHORT).show();
                        }else {}

                    }
                     countDisplay.setText(Integer.toString(count));
            }
        });

         countDownTimer = new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {
                timerDisplay.setText(""+millisUntilFinished / 1000);
            }

            public void onFinish() {
                btn.setEnabled(false);
                timerDisplay.setText("Time's Up!");
                Toast.makeText(getApplicationContext().getApplicationContext(), "You scored: "+count+"!", Toast.LENGTH_LONG).show();
                if(count > score) {
                    score = count;
                    hiScore.setText("HiScore: " + score);
                }
            }
        }.start();
    } // on create
} // end of tapper class