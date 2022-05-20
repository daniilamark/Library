package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Book;
import model.Reader;

import java.net.URL;
import java.util.ResourceBundle;

public class ReaderController implements Initializable {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnInsert;

    @FXML
    private TableColumn<Reader, String> colBirthday;

    @FXML
    private TableColumn<Reader, String> colBook;

    @FXML
    private TableColumn<Reader, String> colEducation;

    @FXML
    private TableColumn<Reader, String> colFio;

    @FXML
    private TableColumn<Reader, String> colHall;

    @FXML
    private TableColumn<Reader, Integer> colNum;

    @FXML
    private TableColumn<Reader, Integer> colPhone;

    @FXML
    private TableColumn<Reader, Integer> colTicketNumber;

    @FXML
    private DatePicker tfBirthday;

    @FXML
    private TextField tfBook;

    @FXML
    private TextField tfEducation;

    @FXML
    private TextField tfFio;

    @FXML
    private TextField tfHall;

    @FXML
    private TextField tfPhone;

    @FXML
    private TextField tfTicketNumber;

    @FXML
    private TableView<Reader> tvReader;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

