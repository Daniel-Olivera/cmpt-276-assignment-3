package com.example.mineseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mineseeker.UI.MainMenu;


/*
Creates the Welcome screen as well as heading to the main menu
***Images taken from Professor's gallery and http://clipart-library.com/clipart/284327.htm
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animateCookie();
        splashScreenTimer();
    }



    private void animateCookie(){
        ImageView cookie = findViewById(R.id.cookie);

        //next 5 lines taken from tutorialspoint https://www.tutorialspoint.com/how-to-make-a-smooth-image-rotation-in-android
        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(4000);
        rotate.setInterpolator(new LinearInterpolator());
        cookie.startAnimation(rotate);
    }

    private void splashScreenTimer(){
        //taken from developer references https://developer.android.com/reference/android/os/CountDownTimer.html
        final CountDownTimer timer = new CountDownTimer(8000, 1000) {



            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                Intent intent = MainMenu.makeIntent(MainActivity.this);
                startActivity(intent);
            }


        };

        //setup the button so skip the welcome screen
        ImageButton skip = findViewById(R.id.btnSkip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                Intent intent =  MainMenu.makeIntent(MainActivity.this);
                startActivity(intent);
            }
        });

        timer.start();



    }
}
