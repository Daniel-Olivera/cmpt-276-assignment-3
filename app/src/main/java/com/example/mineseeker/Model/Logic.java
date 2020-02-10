package com.example.mineseeker.Model;

import java.util.Random;

public class Logic {

    private Settings settings = Settings.getInstance();
    private Random random;

    private int rows = settings.getRows();
    private int cols = settings.getCols();
    private int numCookies = settings.getCookies();

    private boolean[][] cookies = new boolean[rows][cols];

    public void placeCookies(){
        while(numCookies > 0) {
            boolean cookiePlaced = false;
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (!cookiePlaced) {
                        random = new Random();
                        cookies[row][col] = random.nextBoolean();
                        }
                    if(cookies[row][col]){
                            cookiePlaced = true;
                            numCookies--;
                        }
                    }
                }
            }
        }


    public boolean isCookie(int row, int col){
        return cookies[row][col];
    }




}
