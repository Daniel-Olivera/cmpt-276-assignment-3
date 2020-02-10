package com.example.mineseeker.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.mineseeker.Model.Settings;
import com.example.mineseeker.R;

public class Game extends AppCompatActivity {

    public static Intent makeIntent(Context context){
        return new Intent(context, Game.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        populateButtons();

    }

    private void populateButtons(){

        Settings settings = Settings.getInstance();



        TableLayout table = findViewById(R.id.buttonTable);
        for(int row = 0; row < settings.getRows(); row++){
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f));
            table.addView(tableRow);
            for(int col = 0; col < settings.getCols(); col++){
                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f));

                button.setBackgroundResource(android.R.drawable.btn_default);
                button.setText("" + row + ", " + col);
                button.setPadding(0,0,0,0);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v){
                        gridButtonClicked();
                    }
                });

                tableRow.addView(button);
            }
        }
    }

    private void gridButtonClicked() {


    }
}
