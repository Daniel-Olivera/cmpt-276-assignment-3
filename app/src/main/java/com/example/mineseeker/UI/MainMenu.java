package com.example.mineseeker.UI;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mineseeker.R;


public class MainMenu extends AppCompatActivity {

    public static Intent makeIntent(Context context){
        return new Intent(context, MainMenu.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        String message = "It Worked!";
        TextView txt = findViewById(R.id.midTxt);
        txt.setText(message);
    }



}
