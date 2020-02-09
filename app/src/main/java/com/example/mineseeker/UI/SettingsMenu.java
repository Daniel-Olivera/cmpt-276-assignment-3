package com.example.mineseeker.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.mineseeker.R;

public class SettingsMenu extends AppCompatActivity {

    public static Intent makeIntent(Context context){
        return new Intent(context, SettingsMenu.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_menu);
    }
}
