package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import main.DBHandler;
import model.Hall;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HallController implements Initializable {

    @FXML private Button btnDelete;

    @FXML private Button btnInsert;

    @FXML private TableColumn<Hall, String> colHall;

    @FXML private TableColumn<Hall, String> colLibraryName;

    @FXML private TableColumn<Hall, Integer> colNum;

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
        showHalls();
    }


    public ObservableList<Hall> getHallList()  {
        ObservableList<Hall> hallList = FXCollections.observableArrayList();
        Connection conn = null;
        try {
            conn = dbHandler.getDBConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        String query = "SELECT * FROM hall";

        Statement st;
        ResultSet rs;
        try {
            assert conn != null;
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Hall hall;
            while(rs.next()) {
                hall = new Hall(rs.getInt("hall_id"), rs.getString("library_name"), rs.getString("hall_name"), rs.getString("specialization"), rs.getInt("number_seats"));

                hallList.add(hall);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        return hallList;
    }


    public void showHalls() {
        ObservableList<Hall> list = getHallList();

        colNum.setCellValueFactory(new PropertyValueFactory<>("hall_id"));
        colLibraryName.setCellValueFactory(new PropertyValueFactory<>("library_name"));
        colHall.setCellValueFactory(new PropertyValueFactory<>("hall_name"));
        colSpecialization.setCellValueFactory(new PropertyValueFactory<>("specialization"));
        colNumberSeats.setCellValueFactory(new PropertyValueFactory<>("number_seats"));

        tvHall.setItems(list);
    }


    private void insertRecord(){
        String query = "INSERT INTO hall(library_name, hall_name, specialization, number_seats) VALUES (" + "'" + tfLibraryName.getText() + "'" + ",'" + tfHall.getText() + "','" + tfSpecialization.getText() + "',"
                + tfNumberSeats.getText() + ")";
        System.out.println(query);
        dbHandler.executeQuery(query);
        tfLibraryName.setText("");
        tfHall.setText("");
        tfNumberSeats.setText("");
        tfSpecialization.setText("");
        showHalls();
    }

    private void deleteButton(){
        String query = "DELETE FROM hall WHERE hall_name = '" + tfHall.getText() + "'";
        System.out.println(query);
        dbHandler.executeQuery(query);
        tfLibraryName.setText("");
        tfHall.setText("");
        tfNumberSeats.setText("");
        tfSpecialization.setText("");
        showHalls();
    }
}

