package com.example.mineseeker.UI;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mineseeker.MainActivity;
import com.example.mineseeker.R;


public class MainMenu extends AppCompatActivity {

    public static Intent makeIntent(Context context){
        return new Intent(context, MainMenu.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        //play button goes to the Game Activity
        setupPlayButton();
        //Settings button goes to the Settings Activity
        setupSettingsButton();
        //Help button goes to the Help Activity
        setupHelpButton();
    }

    private void setupPlayButton() {
        Button play = findViewById(R.id.btnPlay);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  Game.makeIntent(MainMenu.this);
                startActivity(intent);
            }
        });
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

    private void setupHelpButton() {
        Button help = findViewById(R.id.btnHelp);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  HelpMenu.makeIntent(MainMenu.this);
                startActivity(intent);
            }
        });
    }

    //Exit the program from main menu when the back button is pressed
    //code pulled from https://stackoverflow.com/questions/14001963/finish-all-activities-at-a-time/32203016
    @Override
    public void onBackPressed(){
        Intent intent = MainActivity.makeIntent(this);
        //closes all other activities
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //sends the value 'true' to the first activity
        intent.putExtra("EXIT", true);
        startActivity(intent);
    }

}
