package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Book;

import java.net.URL;
import java.util.ResourceBundle;

public class BookController implements Initializable {

    @FXML
    private TableColumn<Book, Integer> colNum;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnInsert;

    @FXML
    private TableColumn<Book, String> colAuthor;

    @FXML
    private TableColumn<Book, String> colDateIssue;

    @FXML
    private TableColumn<Book, String> colDatePublish;

    @FXML
    private TableColumn<Book, String> colDateReceiving;

    @FXML
    private TableColumn<Book, String> colName;

    @FXML
    private TableColumn<Book, Integer> colNumberCopies;

    @FXML
    private DatePicker dpDateIssue;

    @FXML
    private DatePicker dpDateReceiving;

    @FXML
    private TextField tfAuthor;

    @FXML
    private DatePicker tfDatePublish;

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfNumberCopies;

    @FXML
    private TableView<Book> tvBook;

    @FXML
    void handleButtonAction(ActionEvent event) {

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}

