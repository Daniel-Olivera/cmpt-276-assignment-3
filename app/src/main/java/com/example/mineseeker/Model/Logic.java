package com.example.mineseeker.Model;

import java.util.Random;

public class Logic {

    private Settings settings = Settings.getInstance();
    private Random random;

    private int rows = settings.getRows();
    private int cols = settings.getCols();
    private int numCookies = settings.getCookies();

    //where the cookies are
    private boolean[][] cookies = new boolean[rows][cols];
    //flag for if a cookie has been found or not
    private boolean[][] cookiesFound = new boolean[rows][cols];
    //flag for if a button or cookie has been scanned yet
    private boolean[][] scanned = new boolean[rows][cols];
    //storage for the scanned numbers for later manipulation
    private int[][] scanNumber = new int[rows][cols];

    //used to randomly place a set number of cookies in the grid

    //while there are still cookies to place...
    //iterate through all the rows and columns
    //if there isn't a cookie there yet and there are still cookies left...
    //set the current spot to true or false at random
    //if what we just placed was a cookie, then decrement cookies left
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

    //when the player scans a position
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

        //also save the number for later use
        scanNumber[row][col] = count;
        return count;

    }

    public boolean isCookie(int row, int col){
        return cookies[row][col];
    }
    //sets the flag to true if you find a cookie
    public void setRevealed(int row, int col){
        cookiesFound[row][col] = true;
    }

    public boolean isRevealed(int row, int col){
        return cookiesFound[row][col];
    }

    //sets the flag to true if you have scanned this position
    public void setScanned(int row, int col){
        scanned[row][col] = true;
    }

    public boolean isScanned(int row, int col){
        return scanned[row][col];
    }

    //returns the scan number
    //see updateScanNumber() in Game.Java
    public int scanUpdater(int row, int col) {

        //stops the number from going below 0
        if(scanNumber[row][col] > 0){
            scanNumber[row][col]--;
        }
        return scanNumber[row][col];
    }
}
