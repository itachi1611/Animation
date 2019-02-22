package com.fox.animation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button btnLs1;
    private Button btnLs2;
    private Button btnLs3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        btnLs1.setOnClickListener(this);
        btnLs2.setOnClickListener(this);
        btnLs3.setOnClickListener(this);
    }

    private void initViews(){
        btnLs1 = findViewById(R.id.btnLs1);
        btnLs2 = findViewById(R.id.btnLs2);
        btnLs3 = findViewById(R.id.btnLs3);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnLs1:
                navigateActivity(Lesson1.class);
                break;
            case R.id.btnLs2:
                navigateActivity(Lesson2.class);
                break;
            case R.id.btnLs3:
                navigateActivity(Lesson3.class);
                break;
        }
    }
}
