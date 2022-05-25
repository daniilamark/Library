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

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class BookController implements Initializable {

    @FXML private TableColumn<Book, Integer> colNum;

    @FXML private Button btnDelete;

    @FXML private Button btnInsert;

    @FXML private TableColumn<Book, String> colAuthor;

    @FXML private TableColumn<Book, String> colDateIssue;

    @FXML private TableColumn<Book, String> colDatePublish;

    @FXML private TableColumn<Book, String> colDateReceiving;

    @FXML private TableColumn<Book, String> colName;

    @FXML private TableColumn<Book, Integer> colNumberCopies;

    @FXML private DatePicker dpDateIssue;

    @FXML private DatePicker dpDateReceiving;

    @FXML private TextField tfAuthor;

    @FXML private DatePicker tfDatePublish;

    @FXML private TextField tfName;

    @FXML private TextField tfNumberCopies;

    @FXML private TableView<Book> tvBook;

    DBHandler dbHandler = new DBHandler(); // объект класса помощника для работы с БД

    // обрабока событий
    @FXML
    void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnInsert){
            insertRecord(); // сделать запись
        } else if (event.getSource() == btnDelete){
            deleteButton(); // удалить запись
        }
    }


    // инициализация контроллера
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showBooks(); // показать книги
    }


    // получение списка книг из бд
    public ObservableList<Book> getBookList()  {
        ObservableList<Book> bookList = FXCollections.observableArrayList(); // лист книг
        Connection conn = null; // соединение
        try {
            conn = dbHandler.getDBConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        String query = "SELECT * FROM book"; // запрос - вывод всех записей из таблицы с книгами

        Statement st; // для выполнения запросов
        ResultSet rs; // результаты запроса
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            // формирование списка книг из бд в лист
            Book book;
            while(rs.next()) {
                book = new Book(rs.getInt("book_id"), rs.getString("book_name"), rs.getString("author"),
                        rs.getString("date_publish"), rs.getString("date_issue"), rs.getString("date_receiving"), rs.getInt("number_copies"));

                bookList.add(book);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return bookList;
    }


    // отображение данных из бд в таблице приложения
    public void showBooks() {
        ObservableList<Book> list = getBookList();
        colNum.setCellValueFactory(new PropertyValueFactory<>("book_id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("book_name"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colDatePublish.setCellValueFactory(new PropertyValueFactory<>("date_publish"));
        colDateIssue.setCellValueFactory(new PropertyValueFactory<>("date_issue"));
        colDateReceiving.setCellValueFactory(new PropertyValueFactory<>("date_receiving"));
        colNumberCopies.setCellValueFactory(new PropertyValueFactory<>("number_copies"));
        tvBook.setItems(list); // заполнение столбцов
    }


    // запись в БД
    private void insertRecord(){
        String query = "INSERT INTO book(book_name, author, date_publish, date_issue, date_receiving, number_copies) " +
                "VALUES (" + "'" + tfName.getText() + "'" + ",'" + tfAuthor.getText() + "','" + tfDatePublish.getValue() + "','"
                + dpDateIssue.getValue() + "','" + dpDateReceiving.getValue() + "'," + tfNumberCopies.getText()+ ")";
        System.out.println(query);

        dbHandler.executeQuery(query); // выполнеине запроса

        // очистить поля
        tfName.setText("");
        tfAuthor.setText("");
        tfDatePublish.setValue(null);
        dpDateIssue.setValue(null);
        dpDateReceiving.setValue(null);
        tfNumberCopies.setText("");
        showBooks(); // показать книги
    }

    // удаление из бд
    private void deleteButton(){
        String query = "DELETE FROM book WHERE book_name = '" + tfName.getText() + "'"+"";
        System.out.println(query);
        dbHandler.executeQuery(query); // выполнеине запроса
        // очистить поля
        tfName.setText("");
        tfAuthor.setText("");
        tfDatePublish.setPromptText("Дата издания");
        dpDateIssue.setPromptText("Дата выдачи");
        dpDateReceiving.setPromptText("Дата получения");
        tfNumberCopies.setText("");
        showBooks(); // показать книги
    }
}

