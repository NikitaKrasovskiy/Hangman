package com.example.hungman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HangmanApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HangmanApplication.class.getResource("Menu.fxml"));
        stage.setTitle("Hangman");
        stage.setScene(new Scene(fxmlLoader.load(), 800, 650));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}