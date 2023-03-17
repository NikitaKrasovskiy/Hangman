package com.example.hungman;

import com.example.hungman.model.Words;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

public class HangmanController  {

    @FXML
    public TextField TF1;

    @FXML
    public TextField TF2;

    @FXML
    public TextField TF3;

    @FXML
    public TextField TF4;

    @FXML
    public TextField TF5;

    @FXML
    public TextField TF6;

    @FXML
    public TextField TF7;

    @FXML
    public TextField TF8;
    @FXML
    ImageView image;


    Image IMAGE2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_1.png")));
    Image IMAGE0 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_0.png")));
    Image IMAGE3 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_2.png")));
    Image IMAGE4 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_3.png")));
    Image IMAGE5 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_4.png")));
    Image IMAGE6 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_5.png")));
    Image IMAGE7 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("picture_6.png")));

    @FXML
    public TextField textOne;
    @FXML
    public Label text_count;
    @FXML
    public Label letter_count;

    @FXML
    public TextField inputUser;

    @FXML
    public TextField Result;

    Words words = new Words();
    String letter = words.getRandomWords();

    int letter_size = letter.length();
    int life=6;
    int gameWin = 0;

    boolean lettering = false;

    boolean endGame = false;
    String resultGame;

    public HangmanController() throws FileNotFoundException {
    }

    @FXML
    void initialize() throws FileNotFoundException {
        resetWindow();
        initializetionValue();
        setHint();
        buttons.setDisable(false);
    }

    public void initializetionValue() throws FileNotFoundException {
        image.setImage(IMAGE0);
        words = new Words();
        letter = words.getRandomWords();
        letter_size = letter.length();
        life=6;
        gameWin = 0;
        lettering = false;
        endGame = false;
    }

    public void resetWindow() {
        test.clear();
        TF1.clear();
        TF2.clear();
        TF3.clear();
        TF4.clear();
        TF5.clear();
        TF6.clear();
        TF7.clear();
        TF8.clear();
    }

    @FXML
    public TextField test;

    public void checkResultGame() {
        if (gameWin == letter_size) {
            resultGame = "Выйграли";
            endGame = true;
            buttons.setDisable(true);
            modalWind();
        }
        if (life <= 0) {
            resultGame = "Проиграли";
            endGame = true;
            buttons.setDisable(true);
            modalWind();


        }
    }
    @FXML
    public FlowPane buttons;

    public void finishGame() {
        if (endGame) test.setText("Игра закончена!");
    }
@FXML
void OnClick(ActionEvent event) {
        lettering = false;
    checkInputUsers(event);
        checkResultGame();
        finishGame();
}

@FXML
public void checkInputUsers(ActionEvent event) {
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

    void modalWind() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Information");
        alert.setHeaderText(null);
//        alert.setContentText(resultGame);
        alert.setHeaderText("Вы " + resultGame + ", чтобы продолжить нажмите NewGame, чтобы покинуть игру нажмите leave");
        alert.showAndWait();
    }
    @FXML
    void newGame(ActionEvent event) throws IOException {
        for (int i = 0; i < 32; i++) {
            buttons.getChildren().get(i).setDisable(false);
        }
        initialize();
    }
}