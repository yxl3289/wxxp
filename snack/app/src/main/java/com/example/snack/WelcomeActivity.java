package com.example.snack;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getActionBar().hide();
        setContentView(R.layout.activity_welcome);

        Thread myThread = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                    Intent it=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(it);
                    finish();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}

