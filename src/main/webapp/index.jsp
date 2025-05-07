<%@page import="DAO.DBConnection"%>
<%@ page import="java.sql.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        <input type="hidden" name="action" value="LOGIN">
        <table>
            <tr>
                <td>Username: </td>
                <td><input type="text" name="username" required /></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><input type="password" name="password" required /></td>
            </tr>
        </table>
        <input type="submit" value="Login" />
    </form>
    <form method="post" action="register.jsp">
        <input type="submit" value="Register" />
    </form>
    <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
    %>
        <p style="color:green;"><%= message %></p>
    <%
        }

        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
        <p style="color:red;"><%= error %></p>
    <%
        }
    %>
</body>
</html>