package com.example.hungman.model;

import javafx.event.ActionEvent;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private  Words words ;
    private  String letter;

    private int letter_size;
   private int life;
   private static int gameWin;

   private boolean lettering;

   private String str;
   private String resultGame;

   private Map<Integer, String> map = new HashMap<>();


    public Game() throws FileNotFoundException {
        words = new Words();
        letter = words.getRandomWords();
        letter_size = letter.length();
        life=6;
        gameWin = 0;
        lettering = false;
    }


    public boolean CheckInputUsers(String str) throws FileNotFoundException {
        boolean isFlag = false;
        String letter = this.letter;
        if (letter.contains(str)) {
            gameWin++;
            int index = 0;
            for (int i = 0; i <letter.length(); i++) {
                char c = letter.charAt(i);
                if (String.valueOf(c).equals(str)) {
                    map.put(i, Character.toString(c));
                    isFlag = true;
                }
                index++;
            }
        }
        return isFlag;
    }

    public boolean getCheckResultGame() {
        boolean endGame = false;
        System.out.println(gameWin);
        if (gameWin == letter_size) {
            resultGame = "Выйграли";
            endGame = true;
        }
        if (life <= 0) {
            resultGame = "Проиграли";
            endGame = true;
        }
        return  endGame;
    }

    public  int getGameWin() {
        return gameWin = 0; // заменить
    }

    public Map<Integer, String> getMap() {
        return map;
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


    public boolean isLettering() {
        return lettering;
    }

    public String getResultGame() {
        return resultGame;
    }
}
