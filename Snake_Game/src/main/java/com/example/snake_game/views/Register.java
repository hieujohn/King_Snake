package com.example.snake_game.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Register extends Application {


    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/snake_game/resources/fxml/register.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("snake");
        primaryStage.setScene(new Scene(root,1200,960));
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}
