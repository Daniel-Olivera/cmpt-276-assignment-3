package com.example.mineseeker.UI;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.mineseeker.Model.Logic;
import com.example.mineseeker.Model.Settings;
import com.example.mineseeker.R;

public class Game extends AppCompatActivity {

    public static Intent makeIntent(Context context){
        return new Intent(context, Game.class);
    }

    Settings settings = Settings.getInstance();
    Logic logic = new Logic();
    int cookieCount = 0; // used to display the number of cookies left
    int scanCount = 0;

    Button[][] buttons = new Button[settings.getRows()][settings.getCols()];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        logic.placeCookies();
        populateButtons();
        updateCookieCounter();
        updateScanCounter();
    }

    private void updateCookieCounter() {
        String numCookies;
        numCookies = "Found " + cookieCount + " of " + settings.getCookies() + " cookies.";
        TextView txt = findViewById(R.id.txtCookiesLeft);
        txt.setText(numCookies);
    }

    private void updateScanCounter(){
        String scanMessage;
        scanMessage = "# Scans used: " + scanCount;
        TextView txt = findViewById(R.id.txtScans);
        txt.setText(scanMessage);
    }

    private void getScanNumber(int row, int col, Button button){
        String scanNum;
        scanNum = "" + logic.getCookieScan(row,col);
        button.setText(scanNum);
    }

    private void updateScanNumber(int row, int col){
        //change the column
        for (int i = 0; i < settings.getRows(); i++) {
            if(logic.isScanned(i,col)){
                String num = "";
                num += logic.countUpdater(i,col);
                buttons[i][col].setText(num);
            }
        }
        //change the row
        for (int i = 0; i < settings.getCols(); i++) {
            if(logic.isScanned(row,i)) {
                String num = "";
                num += logic.countUpdater(row, i);
                buttons[row][i].setText(num);
            }
        }
    }

    private void populateButtons(){
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

                //keep text from clipping on smaller buttons
                button.setPadding(0,0,0,0);
                //change text size so it's easier to see
                button.setTextSize(24);

                final int COL_NUM = col;
                final int ROW_NUM = row;

                button.setOnClickListener(new View.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
                    @Override
                    public void onClick(View v){
                        gridButtonClicked(COL_NUM,ROW_NUM);
                    }
                });

                tableRow.addView(button);
                buttons[row][col] = button;
            }
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void gridButtonClicked(int col, int row) {
        Button button = buttons[row][col];

        //Lock the button size
        lockButtons();

        //scales the image to the button size and replaces the button with a cookie
        //if there is one
        if(logic.isCookie(row,col)){
            int newWidth = button.getWidth();
            int newHeight = button.getHeight();
            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cookie);
            Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true);
            Resources resource = getResources();
            button.setBackground(new BitmapDrawable(resource,scaledBitmap));


            //update the amount of cookies left in the counter [top left of game screen]
            if(!logic.isRevealed(row,col)){
            cookieCount++;
            logic.setRevealed(row,col);
            updateCookieCounter();
            updateScanNumber(row,col);
            }
            //if the cookie is revealed and the player scans the cookie itself
            else if(!logic.isScanned(row,col)){
                scanCount++;
                logic.setScanned(row,col);
                //Set the text on a cookie to white for readability
                button.setTextColor(Color.WHITE);
                updateScanCounter();
                getScanNumber(row,col,button);
            }
        }
        //if not a cookie button then scan it
        else{
            if(!logic.isScanned(row,col)){
                scanCount++;
                logic.setScanned(row,col);
                updateScanCounter();
                getScanNumber(row,col,button);
            }
        }
    }

    private void lockButtons() {
        for(int row = 0; row < settings.getRows(); row++){
            for(int col = 0; col < settings.getCols(); col++){
                Button button = buttons[row][col];

                int width = button.getWidth();
                button.setMinWidth(width);
                button.setMaxWidth(width);
                int height = button.getHeight();
                button.setMinHeight(height);
                button.setMaxHeight(height);
            }
        }
    }
}
