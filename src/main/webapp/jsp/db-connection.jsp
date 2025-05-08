<%-- 
    Document   : db-connection
    Created on : May 4, 2025, 8:22:54?PM
    Author     : ADMIN
--%>

<%@ page import="java.sql.*" %>

<%!
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.4:3306/digital_bus_pass";
    private static final String JDBC_USER = "root"; 
    private static final String JDBC_PASSWORD = "Skynet1250";  
    
    // Method to get connection
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }
    
    // Method to close resources
    public static void closeResources(Connection conn, Statement stmt, ResultSet rs) {
        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (stmt != null) stmt.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
%>