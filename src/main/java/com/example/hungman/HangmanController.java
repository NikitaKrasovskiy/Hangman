package com.example.hungman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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


    Image image2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_1.png")));
    Image image3 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_2.png")));
    Image image4 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_3.png")));
    Image image5 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_4.png")));
    Image image6 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_5.png")));
    Image image7 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_6.png")));


    @FXML
    private TextField textOne;
    @FXML
    private Label text_count;

    public HangmanController() throws FileNotFoundException {
    }

    @FXML
    void initialize() {
        setHint();
    }

    @FXML
    void Check(ActionEvent event) {
        String str = inputUser.getText();
        System.out.println(inputUser.getText());
        if (letter.contains(str)) {
            int index = 0;
            for(int i=0; i<letter.length(); i++) {
                char c = letter.charAt(i);
                if (String.valueOf(c).equals(str)) {
                    setLetter(index, Character.toString(c));
                }
                index++;
            }
        }
        else {
            setImage();
            System.out.println("image");
        }
    }
@FXML
private TextField inputUser;
    Words words = new Words();
    String letter = words.getRandomWords();

    int letter_size = letter.length();

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
    int life=6;

    public void setImage(){
        if(life==6)
            image.setImage(image2);
        else if(life==5)
            image.setImage(image3);
        else if(life==4)
            image.setImage(image4);
        else if(life==3)
            image.setImage(image5);
        else if(life==2)
            image.setImage(image6);
        else if(life==1)
            image.setImage(image7);
        life--;
    }
}