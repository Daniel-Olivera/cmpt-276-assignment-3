package com.example.mineseeker.Model;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mineseeker.UI.Game;
import com.example.mineseeker.UI.SettingsMenu;

public class Settings {

    private int rows = 4;
    private int cols = 6;
    private int cookies = 6;

    private static Settings instance;

    //singleton used for sharing the settings between activities
    public static Settings getInstance(){
        if(instance == null){
            instance = new Settings();
        }
        return instance;
    }

    public void setRows(int x){
        rows = x;
    }

    public void setCols(int x){
        cols = x;
    }

    public int getRows(){
        return rows;
    }

    public int getCols(){
        return cols;
    }

    public void setCookies(int x){
        cookies = x;
    }

    public int getCookies(){
        return cookies;
    }
}
