<%@ page import="DAO.DBConnection" %>
<%@ page import="java.sql.Connection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Database Connection Test</title>
</head>
<body>
    <h2>Database Connection Test</h2>

    <%
        Connection conn = null;
        try {
            conn = DBConnection.getConnection();
            out.println("<p style='color:green;'>✅ Connection successful!</p>");
        } catch (Exception e) {
            out.println("<p style='color:red;'>❌ Connection failed: " + e.getMessage() + "</p>");
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (Exception e) {
                out.println("<p>Error closing connection: " + e.getMessage() + "</p>");
            }
        }
    %>

    <p><a href="index.jsp">Back to Home</a></p>
</body>
</html>
