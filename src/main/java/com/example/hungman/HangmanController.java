package com.example.hungman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileNotFoundException;
import java.util.Objects;

public class HangmanController  {

    @FXML
    private TextField TF1;

    @FXML
    private TextField TF2;

    @FXML
    private TextField TF3;

    @FXML
    private TextField TF4;

    @FXML
    private TextField TF5;

    @FXML
    private TextField TF6;

    @FXML
    private TextField TF7;

    @FXML
    private TextField TF8;
    @FXML
    ImageView image;


    Image IMAGE2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_1.png")));
    Image IMAGE3 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_2.png")));
    Image IMAGE4 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_3.png")));
    Image IMAGE5 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_4.png")));
    Image IMAGE6 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_5.png")));
    Image IMAGE7 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_6.png")));

    @FXML
    private TextField textOne;
    @FXML
    private Label text_count;

    @FXML
    private TextField inputUser;

    @FXML
    private TextField Result;

    public HangmanController() throws FileNotFoundException {
    }
    Words words = new Words();
    String letter = words.getRandomWords();

    int letter_size = letter.length();
    int life=6;
    int gameWin = 0;

    boolean lettering = false;

    boolean endGame = false;

    @FXML
    void initialize() {
        setHint();
    }
    @FXML
    private TextField test;

    private void checkResultGame() {
        if (gameWin == letter_size) {
            Result.setText("WIN");
            endGame = true;
        }
        if (life <= 0) {
            Result.setText("lost");
            endGame = true;
        }
    }

    private void finishGame() {
        if (endGame) test.setText("Игра закончена!");
    }
@FXML
void OnClick(ActionEvent event) {
        lettering = false;
        OnClicks(event);
        checkResultGame();
        finishGame();
}

@FXML
private void OnClicks(ActionEvent event) {
    String str = ((Button)event.getSource()).getText(); // считывание введенных букв
    System.out.println(str);
    ((Button)event.getSource()).setDisable(true); // выключение нажатых букв (чтобы пользователь не мог больше взаимодейтсоввать с ними)
    if (letter.contains(str)) {
        gameWin += 1;
        int index = 0;
        for (int i = 0; i < letter.length(); i++) {
            char c = letter.charAt(i);
            System.out.println(c);
            if (String.valueOf(c).equals(str)) {
                System.out.println("test");
                setLetter(index, Character.toString(c));
            }
            index++;
        }
    } else {
        setImage();
    }
}
    public void setLetter(int index,String str){
        if(index==0)
            TF1.setText(str);
        else if(index==1)
            TF2.setText(str);
        else if(index==2)
            TF3.setText(str);
        else if(index==3)
            TF4.setText(str);
        else if(index==4)
            TF5.setText(str);
        else if(index==5)
            TF6.setText(str);
        else if(index==6)
            TF7.setText(str);
        else if(index==7)
            TF8.setText(str);
    }
    @FXML
    private Label letter_count;


    public void setHint(){
//        hint.setText(hint_str);
        letter_count.setText(letter_size+" Letters");

        if(letter_size==7){
            TF8.setVisible(false);
        }
        if(letter_size==6){
            TF7.setVisible(false);
            TF8.setVisible(false);
        }
        if(letter_size==5){
            TF6.setVisible(false);
            TF7.setVisible(false);
            TF8.setVisible(false);
        }
        if(letter_size==4){
            TF5.setVisible(false);
            TF6.setVisible(false);
            TF7.setVisible(false);
            TF8.setVisible(false);
        }
    }

    public void setImage(){
        if(life==6)
            image.setImage(IMAGE2);
        else if(life==5)
            image.setImage(IMAGE3);
        else if(life==4)
            image.setImage(IMAGE4);
        else if(life==3)
            image.setImage(IMAGE5);
        else if(life==2)
            image.setImage(IMAGE6);
        else if(life==1)
            image.setImage(IMAGE7);
        life--;
    }
}