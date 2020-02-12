package com.example.mineseeker.Model;

import java.util.Random;

public class Logic {

    private Settings settings = Settings.getInstance();
    private Random random;

    private int rows = settings.getRows();
    private int cols = settings.getCols();
    private int numCookies = settings.getCookies();

    private boolean[][] cookies = new boolean[rows][cols];
    private boolean[][] cookiesFound = new boolean[rows][cols];
    private boolean[][] scanned = new boolean[rows][cols];
    private int[][] scanNumber = new int[rows][cols];

    //used to randomly place a set number of cookies in the grid
    public void placeCookies(){
        while(numCookies > 0) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if(!isCookie(row,col) && numCookies > 0){
                        random = new Random();
                        cookies[row][col] = random.nextBoolean();
                        if(isCookie(row,col)){
                            numCookies--;
                        }
                    }
                }
            }
        }
    }

    //stores the number of cookies in the column and row into that position
    public int getCookieScan(int row, int col){
        int count = 0;

        //check the column
        for (int i = 0; i < rows; i++) {
            if (isCookie(i, col) && !isRevealed(i,col)) {
                count++;
            }
        }
        //check the row
        for (int i = 0; i < cols; i++) {
            if (isCookie(row, i) && !isRevealed(row,i)) {
                count++;
            }
        }

        scanNumber[row][col] = count;
        return count;

    }




    public boolean isCookie(int row, int col){
        return cookies[row][col];
    }

    public void setRevealed(int row, int col){
        cookiesFound[row][col] = true;
    }

    public boolean isRevealed(int row, int col){
        return cookiesFound[row][col];
    }

    public void setScanned(int row, int col){
        scanned[row][col] = true;
    }

    public boolean isScanned(int row, int col){
        return scanned[row][col];
    }

    //updates the number on the buttons when a cookie is revealed
    public int countUpdater(int row, int col) {

        if(scanNumber[row][col] > 0){
            scanNumber[row][col]--;
        }
        return scanNumber[row][col];
    }
}
