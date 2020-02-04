package com.example.mineseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mineseeker.UI.MainMenu;


/*
Creates the Welcome screen as well as heading to the main menu
***Images taken from Professor's gallery and http://clipart-library.com/clipart/284327.htm
 */
public class MainActivity extends AppCompatActivity {

    public static Intent makeIntent(Context context){
        return new Intent(context, MainActivity.class);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animateCookie();
        splashScreenTimer();

    }

    private void animateCookie(){
        ImageView cookie = findViewById(R.id.cookie);

        RotateAnimation rotate = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(5000);
        rotate.setInterpolator(new LinearInterpolator());
        cookie.startAnimation(rotate);
    }

    private void splashScreenTimer(){
        //taken from developer references https://developer.android.com/reference/android/os/CountDownTimer.html
        CountDownTimer start = new CountDownTimer(4000, 1000) {

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
