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
                saveNumRows(4);
                saveNumCols(6);
                settings.setRows(4);
                settings.setCols(6);
            }
        });

        btn5x10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNumRows(5);
                saveNumCols(10);
                settings.setRows(5);
                settings.setCols(10);
            }
        });

        btn6x15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNumRows(6);
                saveNumCols(15);
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
                saveNumCookies(6);
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings.setCookies(10);
                saveNumCookies(10);
            }
        });

        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings.setCookies(15);
                saveNumCookies(15);
            }
        });

        btn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings.setCookies(20);
                saveNumCookies(20);
            }
        });
    }

    //Allows user to save the number of cookies between app runs
    public void saveNumCookies(int numCookies){
        SharedPreferences prefs = this.getSharedPreferences("cookiePrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("Num cookies", numCookies);
        editor.apply();
    }

    //Allows application to get the saved number whenever it needs it
    public static int getNumCookies(Context context){
        SharedPreferences prefs = context.getSharedPreferences("cookiePrefs", MODE_PRIVATE);
        return prefs.getInt("Num cookies", 6);
    }

    //Allows user to save the number of Rows between app runs
    public void saveNumRows(int numRows){
        SharedPreferences prefs = this.getSharedPreferences("rowPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("Num Rows", numRows);
        editor.apply();
    }

    //Allows application to get the saved number whenever it needs it
    public static int getNumRows(Context context){
        SharedPreferences prefs = context.getSharedPreferences("rowPrefs", MODE_PRIVATE);
        return prefs.getInt("Num Rows", 4);
    }

    //Allows user to save the number of Columns between app runs
    public void saveNumCols(int numCols){
        SharedPreferences prefs = this.getSharedPreferences("colPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("Num Cols", numCols);
        editor.apply();
    }

    //Allows application to get the saved number whenever it needs it
    public static int getNumCols(Context context){
        SharedPreferences prefs = context.getSharedPreferences("colPrefs", MODE_PRIVATE);
        return prefs.getInt("Num Cols", 6);
    }





}



