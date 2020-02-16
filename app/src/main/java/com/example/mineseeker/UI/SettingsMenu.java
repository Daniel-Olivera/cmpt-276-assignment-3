package com.example.mineseeker.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.mineseeker.Model.Settings;
import com.example.mineseeker.R;

public class SettingsMenu extends AppCompatActivity {


    public static Intent makeIntent(Context context) {
        return new Intent(context, SettingsMenu.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_menu);

        Settings settings = Settings.getInstance();

        //setup the buttons to change the grid size
        setupGridButtons(settings);
        //setup the buttons to change the amount of cookies
        setupCookieButtons(settings);
    }

    private void setupGridButtons(final Settings settings) {

        Button btn4x6 = findViewById(R.id.btn4x6);
        Button btn5x10 = findViewById(R.id.btn5x10);
        Button btn6x15 = findViewById(R.id.btn6x15);

        btn4x6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings.setRows(4);
                settings.setCols(6);
            }
        });

        btn5x10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings.setRows(5);
                settings.setCols(10);
            }
        });

        btn6x15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings.setRows(6);
                settings.setCols(15);
            }
        });

    }

    private void setupCookieButtons(final Settings settings) {
        Button btn6 = findViewById(R.id.btn6);
        Button btn10 = findViewById(R.id.btn10);
        Button btn15 = findViewById(R.id.btn15);
        Button btn20 = findViewById(R.id.btn20);

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings.setCookies(6);
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings.setCookies(10);
            }
        });

        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings.setCookies(15);
            }
        });

        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings.setCookies(20);
            }
        });
    }

    private void saveNumCookies(int numCookies){
        SharedPreferences prefs = this.getSharedPreferences("AppPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("Num cookies", numCookies);
        editor.apply();
    }

    public static int getNumCookies(Context context){
        SharedPreferences prefs = context.getSharedPreferences("AppPrefs", MODE_PRIVATE);
        return prefs.getInt("Num cookies", 0);
    }
}



