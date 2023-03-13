package com.example.hungman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Words {

    private ArrayList<String> words;

    Words() throws FileNotFoundException {
        words = new ArrayList<>();
        Scanner textScanner = null;
            textScanner = new Scanner(new File("/Users/cherigra/Java/Hungman/src/main/resources/test.txt")); // заменить на обсолютный путь

        while (textScanner.hasNextLine())
            words.add(textScanner.nextLine());
    }

    public String getRandomWords() {
        return words.get((int) (Math.random() * words.size()));
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }
}
