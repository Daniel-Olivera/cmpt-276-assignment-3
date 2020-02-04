package com.example.mineseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.example.mineseeker.UI.MainMenu;

public class MainActivity extends AppCompatActivity {

    public static Intent makeIntent(Context context){
        return new Intent(context, MainActivity.class);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //taken from developer references https://developer.android.com/reference/android/os/CountDownTimer.html
        new CountDownTimer(4000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = MainMenu.makeIntent(MainActivity.this);
                startActivity(intent);
            }
        }.start();

    }
}
