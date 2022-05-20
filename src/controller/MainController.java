package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import main.Const;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private BorderPane borderpane;

    @FXML
    private Button btnBook;

    @FXML
    private Button btnHall;

    @FXML
    private Button btnReader;

    @FXML
    void handleButtonAction(ActionEvent event) {
        if (event.getSource() == btnBook) {
            loadUI("../views/book");
        } else if (event.getSource() == btnReader) {
            loadUI("../views/reader");
        } else if (event.getSource() == btnHall) {
            loadUI("../views/hall");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



    private void loadUI(String ui) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource(ui + ".fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        borderpane.setCenter(root);
    }

}
