package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/main.fxml"));
        stage.setTitle("Библиотека");
        stage.setScene(new Scene(root, 800, 600));
        stage.getIcons().add(new Image("img/Book.png"));

        //stage.setMaximized(true);

        stage.show();
    }

    public static void exit(){
        System.exit(0);
    }

    public static void main(String[] args) {
        launch();
    }
}