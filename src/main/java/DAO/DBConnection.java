package DAO;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://truntrun.ddns.net:3306/digital_bus_pass";
    private static final String USER = "truntruntramcam";
    private static final String PASSWORD = "TrunTrun_TramCam3004";

    static {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
        
    }
    
}