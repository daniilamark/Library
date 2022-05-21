package main;

import java.sql.*;

public class DBHandler extends ConfigsDb{
    Connection dbConnection;
    public int id;

    public Connection getDBConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        // System.out.println(Class.forName("com.mysql.jdbc.Driver"));

        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);

        return dbConnection;
    }



    public void executeQuery(String query) {
        Connection conn = null;
        try {
            conn = getDBConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Statement st;
        try{
            st = conn.createStatement();
            st.executeUpdate(query);
            System.out.println("всё гуд");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
