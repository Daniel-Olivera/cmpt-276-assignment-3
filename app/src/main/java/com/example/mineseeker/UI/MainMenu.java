package com.example.mineseeker.UI;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mineseeker.R;


public class MainMenu extends AppCompatActivity {

    public static Intent makeIntent(Context context){
        return new Intent(context, MainMenu.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        setupPlayButton();
        setupSettingsButton();


    }

    private void setupSettingsButton() {
        ImageButton skip = findViewById(R.id.btnSettings);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  SettingsMenu.makeIntent(MainMenu.this);
                startActivity(intent);
            }
        });
    }

    private void setupPlayButton() {
        Button skip = findViewById(R.id.btnPlay);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  Game.makeIntent(MainMenu.this);
                startActivity(intent);
            }
        });
    }


}
