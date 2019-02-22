package com.fox.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Lesson2 extends AppCompatActivity implements View.OnClickListener{

    private Button btnAll;
    private Button btnDoraemon;
    private Button btnNobita;
    private Button btnSuneo;
    private Button btnJaian;
    private Button btnShizuka;
    private ImageView imgAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);
        initViews();
        btnAll.setOnClickListener(this);
        btnDoraemon.setOnClickListener(this);
        btnNobita.setOnClickListener(this);
        btnSuneo.setOnClickListener(this);
        btnJaian.setOnClickListener(this);
        btnShizuka.setOnClickListener(this);
    }

    private void initViews(){
        btnAll = findViewById(R.id.btnAll);
        btnDoraemon = findViewById(R.id.btnDoraemon);
        btnNobita = findViewById(R.id.btnNobita);
        btnSuneo = findViewById(R.id.btnSuneo);
        btnJaian = findViewById(R.id.btnJaian);
        btnShizuka = findViewById(R.id.btnShizuka);
        imgAll = findViewById(R.id.imgAll);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnAll:
                showImage("All");
                break;
            case R.id.btnDoraemon:
                showImage("Doraemon");
                break;
            case R.id.btnNobita:
                showImage("Nobita");
                break;
            case R.id.btnSuneo:
                showImage("Suneo");
                break;
            case R.id.btnJaian:
                showImage("Jaian");
                break;
            case R.id.btnShizuka:
                showImage("Shizuka");
                break;
        }
    }

    private void showImage(String img){
        //Hide image
        ObjectAnimator animator = ObjectAnimator.ofFloat(imgAll,"translationX",0f,500f);
        animator.setDuration(2000);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imgAll,"alpha",1f,0f);
        animator1.setDuration(2000);
        //Show image
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imgAll,"translationX",-500f,0f);
        animator2.setDuration(2000);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(imgAll,"alpha",0f,1f);
        animator3.setDuration(2000);
        //Config slideshow process to show next image
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator2).with(animator3).after(animator).after(animator1);
        animatorSet.start();
        final String imgName = img;
        //Set listener for determine when animation finished
        animator1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                //Change source of ImageView
                switch (imgName){
                    case "All":
                        imgAll.setImageResource(R.drawable.all);
                        break;
                    case "Doraemon":
                        imgAll.setImageResource(R.drawable.doraemon);
                        break;
                    case "Nobita":
                        imgAll.setImageResource(R.drawable.nobita);
                        break;
                    case "Suneo":
                        imgAll.setImageResource(R.drawable.suneo);
                        break;
                    case "Jaian":
                        imgAll.setImageResource(R.drawable.jaian);
                        break;
                    case "Shizuka":
                        imgAll.setImageResource(R.drawable.shizuka);
                        break;
                }
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }
        });
    }

}
