package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import main.DBHandler;
import model.Book;
import model.Hall;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
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

    DBHandler dbHandler = new DBHandler();

    @FXML
    void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnInsert){
            insertRecord();
        } else if (event.getSource() == btnDelete){
            deleteButton();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showBooks();
    }


    public ObservableList<Book> getBookList()  {
        ObservableList<Book> bookList = FXCollections.observableArrayList();
        Connection conn = null;
        try {
            conn = dbHandler.getDBConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = "SELECT * FROM book";

        Statement st;
        ResultSet rs;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Book book;
            while(rs.next()) {
                book = new Book(rs.getInt("book_id"), rs.getString("name"), rs.getString("author"),
                        rs.getString("date_publish"), rs.getString("date_issue"), rs.getString("date_receiving"), rs.getInt("number_copies"));

                bookList.add(book);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return bookList;
    }


    public void showBooks() {
        ObservableList<Book> list = getBookList();

        colNum.setCellValueFactory(new PropertyValueFactory<Book, Integer>("book_id"));
        colName.setCellValueFactory(new PropertyValueFactory<Book, String>("name"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        colDatePublish.setCellValueFactory(new PropertyValueFactory<Book, String>("date_publish"));
        colDateIssue.setCellValueFactory(new PropertyValueFactory<Book, String>("date_issue"));
        colDateReceiving.setCellValueFactory(new PropertyValueFactory<Book, String>("date_receiving"));
        colNumberCopies.setCellValueFactory(new PropertyValueFactory<Book, Integer>("number_copies"));

        tvBook.setItems(list);
    }


    private void insertRecord(){
        String query = "INSERT INTO book(name, author, date_publish, date_issue, date_receiving, number_copies) " +
                "VALUES (" + "'" + tfName.getText() + "'" + ",'" + tfAuthor.getText() + "','" + tfDatePublish.getValue() + "','"
                + dpDateIssue.getValue() + "','" + dpDateReceiving.getValue()+ "'," + tfNumberCopies.getText()+ ")";
        System.out.println(query);
        dbHandler.executeQuery(query);
        tfName.setText("");
        tfAuthor.setText("");
        tfDatePublish.setValue(null);
        dpDateIssue.setValue(null);
        dpDateReceiving.setValue(null);
        tfNumberCopies.setText("");
        showBooks();
    }

    private void deleteButton(){
        String query = "DELETE FROM book WHERE name = '" + tfName.getText() + "'";
        System.out.println(query);
        dbHandler.executeQuery(query);
        tfName.setText("");
        tfAuthor.setText("");
        tfDatePublish.setPromptText("Дата издания");
        dpDateIssue.setPromptText("Дата выдачи");
        dpDateReceiving.setPromptText("Дата получения");
        tfNumberCopies.setText("");
        showBooks();
    }
}

