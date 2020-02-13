package com.example.mineseeker.UI;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

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
                    case DialogInterface.BUTTON_POSITIVE:{
                        Intent intent = MainMenu.makeIntent(getActivity());
                        startActivity(intent);
                        break;
                    }
                    case DialogInterface.BUTTON_NEGATIVE:{
                        Intent intent = Game.makeIntent(getActivity());
                        startActivity(intent);
                        break;
                    }

                }

            }
        };

        return new AlertDialog.Builder(getActivity())
                .setTitle("")
                .setView(winScreen)
                .setPositiveButton(android.R.string.ok, listener)
                .setNegativeButton("Play again", listener)
                .create();
    }
}
