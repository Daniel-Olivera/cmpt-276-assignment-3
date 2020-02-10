package com.example.mineseeker.Model;

public class Settings {

    private int rows = 4;
    private int cols = 6;

    private static Settings instance;

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
}
