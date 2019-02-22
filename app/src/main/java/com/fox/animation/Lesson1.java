package com.fox.animation;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Lesson1 extends AppCompatActivity implements View.OnClickListener{

    private ImageView imgAll;
    private Button btnRotate;
    private Button btnMove;
    private Button btnZoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);
        initViews();
        btnRotate.setOnClickListener(this);
        btnMove.setOnClickListener(this);
        btnZoom.setOnClickListener(this);
    }

    private void initViews(){
        imgAll = findViewById(R.id.imgAll);
        btnRotate = findViewById(R.id.btnRotate);
        btnMove = findViewById(R.id.btnMove);
        btnZoom = findViewById(R.id.btnZoom);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnRotate:
                setRotate();
                break;
            case R.id.btnMove:
                setMove();
                break;
            case R.id.btnZoom:
                setZoom();
                break;
        }
    }

    private void setRotate(){
        int dest = 360;
        if(imgAll.getRotation() == 360){
            System.out.println(imgAll.getAlpha());
            dest = 0;
        }
        ObjectAnimator animator = ObjectAnimator.ofFloat(imgAll,"rotation",dest);
        animator.setDuration(2000);
        animator.start();
    }

    private void setMove(){
        Animation animation = AnimationUtils.loadAnimation(Lesson1.this, R.anim.move);
        imgAll.startAnimation(animation);
    }

    private void setZoom(){
        Animation animation = AnimationUtils.loadAnimation(Lesson1.this, R.anim.zoom);
        imgAll.startAnimation(animation);
    }

}
