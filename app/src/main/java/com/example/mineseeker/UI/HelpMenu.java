package com.example.mineseeker.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.example.mineseeker.R;

public class HelpMenu extends AppCompatActivity {

    public static Intent makeIntent(Context context){
        return new Intent(context, HelpMenu.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_menu);

        TextView courseLink = findViewById(R.id.txtCourseLink);
        courseLink.setMovementMethod(LinkMovementMethod.getInstance());

        TextView cookieLink = findViewById(R.id.txtClipArt);
        cookieLink.setMovementMethod(LinkMovementMethod.getInstance());

        TextView backgroundLink = findViewById(R.id.txtBackgroundArt);
        backgroundLink.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
