package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Book;
import model.Hall;

import java.net.URL;
import java.util.ResourceBundle;

public class HallController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnInsert;

    @FXML
    private TableColumn<Hall, String> colHall;

    @FXML
    private TableColumn<Hall, String> colLibraryName;

    @FXML
    private TableColumn<Hall, Integer> colNum;

    @FXML
    private TableColumn<Hall, Integer> colNumberSeats;

    @FXML
    private TableColumn<Hall, String> colSpecialization;

    @FXML
    private TextField tfHall;

    @FXML
    private TextField tfLibraryName;

    @FXML
    private TextField tfNumberSeats;

    @FXML
    private TextField tfSpecialization;

    @FXML
    private TableView<Hall> tvHall;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

