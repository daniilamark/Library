package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

// главный класс
public class Main extends Application {

    // запуск главного окна
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/main.fxml"));
        stage.setTitle("Библиотека"); // изменение заголовка
        stage.setScene(new Scene(root, 800, 600)); // установка размеров окна
        stage.getIcons().add(new Image("img/Book.png")); // установка иконки
        stage.show(); // отображение сцены
    }

    public static void main(String[] args) {
        launch();
    }
}