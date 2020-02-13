package com.example.mineseeker.UI;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.mineseeker.R;

public class GameWinFragment extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View winScreen = LayoutInflater.from(getActivity()).inflate(R.layout.game_win,null);

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    //Sends you back to the main menu
                    case DialogInterface.BUTTON_POSITIVE:{
                        Intent intent = MainMenu.makeIntent(getActivity());
                        startActivity(intent);
                        break;
                    }
                    //Creates a new game board to play with the same settings
                    case DialogInterface.BUTTON_NEGATIVE:{
                        Intent intent = Game.makeIntent(getActivity());
                        startActivity(intent);
                        break;
                    }

                }

            }
        };

        //Creates the Custom Title so that it can be centered
        TextView title = new TextView(getActivity());
        title.setText(R.string.you_win);
        title.setPadding(10,10,10,10);
        title.setTextColor(Color.BLACK);
        title.setGravity(Gravity.CENTER);
        title.setTextSize(24);

        //Essentially creates the dialog box
        return new AlertDialog.Builder(getActivity())
                .setCustomTitle(title)
                .setView(winScreen)
                .setPositiveButton(android.R.string.ok, listener)
                .setNegativeButton("Play again", listener)
                .create();
    }

    //Allows resizing of the dialog box
    @Override
    public void onResume(){
        super.onResume();
        Window window = getDialog().getWindow();
        if(window == null){
            return;
        }
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = 1200;
        params.height = 600;
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);

    }
}
