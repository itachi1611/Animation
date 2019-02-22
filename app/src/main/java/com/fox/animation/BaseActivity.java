package com.fox.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    public void navigateActivity(Class target){
        Intent intent = new Intent(this,target);
        startActivity(intent);
    }

}
