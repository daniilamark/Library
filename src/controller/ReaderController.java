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
import model.Reader;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        showReaders();
    }


    public ObservableList<Reader> getReaderList()  {
        ObservableList<Reader> readerList = FXCollections.observableArrayList();
        Connection conn = null;
        try {
            conn = dbHandler.getDBConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        String query = "SELECT * FROM reader";

        Statement st;
        ResultSet rs;
        try {
            assert conn != null;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Reader reader;
            while(rs.next()) {
                reader = new Reader(rs.getInt("reader_id"), rs.getString("fio"),
                        rs.getInt("ticket_number"), rs.getString("birthday"),
                        rs.getInt("phone"), rs.getString("education"),
                        rs.getInt("hall_id"), rs.getInt("book_id"));

                readerList.add(reader);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return readerList;
    }


    public void showReaders() {
        ObservableList<Reader> list = getReaderList();

        colNum.setCellValueFactory(new PropertyValueFactory<>("reader_id"));
        colFio.setCellValueFactory(new PropertyValueFactory<>("fio"));
        colTicketNumber.setCellValueFactory(new PropertyValueFactory<>("ticket_number"));
        colBirthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colEducation.setCellValueFactory(new PropertyValueFactory<>("education"));
        colHall.setCellValueFactory(new PropertyValueFactory<>("hall_id"));
        colBook.setCellValueFactory(new PropertyValueFactory<>("book_id"));

        tvReader.setItems(list);
    }


    private void insertRecord(){
        String query = "INSERT INTO reader(fio , ticket_number, birthday, phone, education, hall_id, book_id) VALUES (" + "'" + tfFio.getText() + "'" + "," + tfTicketNumber.getText() + ",'" + tfBirthday.getValue() + "',"
                + tfPhone.getText() + ",'"+ tfEducation.getText() + "'," +tfHall.getText() + "," + tfBook.getText() + ")";
        System.out.println(query);
        dbHandler.executeQuery(query);
        tfFio.setText("");
        tfTicketNumber.setText("");
        tfBirthday.setValue(null);
        tfPhone.setText("");
        tfEducation.setText("");
        tfHall.setText("");
        tfBook.setText("");
        showReaders();
    }

    private void deleteButton(){
        String query = "DELETE FROM reader WHERE ticket_number = '" + tfTicketNumber.getText() + "'";
        System.out.println(query);
        dbHandler.executeQuery(query);
        tfFio.setText("");
        tfTicketNumber.setText("");
        tfBirthday.setValue(null);
        tfPhone.setText("");
        tfEducation.setText("");
        tfHall.setText("");
        tfBook.setText("");
        showReaders();
    }
}

