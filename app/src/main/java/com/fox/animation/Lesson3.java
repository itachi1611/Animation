package com.fox.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Lesson3 extends AppCompatActivity {

    private ImageView imgBg;
    private ImageView imgHour;
    private ImageView imgMinute;
    private ImageView imgSecond;
    private Button btnRun;
    private Animation hour,minute,second;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3);
        initViews();
//        hour = AnimationUtils.loadAnimation(Lesson3.this, R.anim.hours_rotation);
//        minute = AnimationUtils.loadAnimation(Lesson3.this, R.anim.minutes_rotation);
//        second = AnimationUtils.loadAnimation(Lesson3.this, R.anim.seconds_rotation);
        final ObjectAnimator second = ObjectAnimator.ofFloat(imgSecond,"rotation",0f,360f);
        final ObjectAnimator minute = ObjectAnimator.ofFloat(imgMinute,"rotation",0f,360f);
        final ObjectAnimator hour = ObjectAnimator.ofFloat(imgHour,"rotation",0f,360f);
        second.setDuration(1000);
        second.setRepeatCount(ValueAnimator.INFINITE);
//        minute.setStartDelay(1000);
        minute.setDuration(33333);
        minute.setRepeatCount(ValueAnimator.INFINITE);
        hour.setDuration(200000);
        hour.setRepeatCount(ValueAnimator.INFINITE);
        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                imgHour.startAnimation(hour);
//                imgMinute.startAnimation(minute);
//                imgSecond.startAnimation(second);
                second.start();
                minute.start();
                hour.start();
            }
        });
    }

    private void initViews(){
        imgBg = findViewById(R.id.imgBg);
        imgHour = findViewById(R.id.imgHour);
        imgMinute = findViewById(R.id.imgMinute);
        imgSecond = findViewById(R.id.imgSecond);
        btnRun = findViewById(R.id.btnRun);
    }
}
