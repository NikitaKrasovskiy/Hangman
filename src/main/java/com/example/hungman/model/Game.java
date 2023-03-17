package com.example.hungman.model;

import com.example.hungman.HangmanController;

import java.io.FileNotFoundException;

public class Game {
    private  Words words ;
    private  String letter;

    private int letter_size;
   private int life;
   private static int gameWin;

   private boolean lettering;

   private boolean endGame;
   private String str;
    private String resultGame;



    public Game() throws FileNotFoundException {
        words = new Words();
        letter = words.getRandomWords();
        letter_size = letter.length();
        life=6;
        gameWin = 0;
        lettering = false;
        endGame = false;

    }

    public void setLife(int life) {
        this.life = life;
    }

    public void minusLife() {
        life -= 1;
    }

    public void setLettering(boolean lettering) {
        this.lettering = lettering;
    }

    public static void setGameWin(int gameWin) {
        Game.gameWin = gameWin;
    }

    public void setEndGame(boolean endGame) {
        this.endGame = endGame;
    }

    public void setResultGame(String resultGame) {
        this.resultGame = resultGame;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Words getWords() {
        return words;
    }

    public String getLetter() {
        return letter;
    }

    public int getLetter_size() {
        return letter_size;
    }

    public int getLife() {
        return life;
    }

    public int getGameWin() {
        return gameWin;
    }

    public boolean isLettering() {
        return lettering;
    }

    public boolean isEndGame() {
        return endGame;
    }

    public String getResultGame() {
        return resultGame;
    }
}
