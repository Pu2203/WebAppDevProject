<%-- 
    Document   : test-connection
    Created on : May 4, 2025, 8:31:19?PM
    Author     : ADMIN
--%>

<%@ page import="controller.DBConnectionTest" %>
<%@ page language="java" %>
<html>
<head><title>DB Connection Test</title></head>
<body>
    <h2>Database Connection Test</h2>
    <%
        boolean success = DBConnectionTest.testConnection();
        if (success) {
            out.println("<p style='color:green;'>Connection Successful!</p>");
        } else {
            out.println("<p style='color:red;'>Connection Failed. Check console for details.</p>");
        }
    %>
</body>
</html>