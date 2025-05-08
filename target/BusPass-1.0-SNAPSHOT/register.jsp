<%-- 
    Document   : account
    Created on : Apr 29, 2025, 9:00:06 AM
    Author     : ductrungnguyen
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<html>
    <head><title>Register Page</title></head>
    <body>
        <h2>Sign Up</h2>
        <form action="RegisterServlet" method="post">
            <input type="hidden" name="action" value="REGISTER">
            <table border="1" cellpadding="10" cellspacing="0">
                <tr>
                    <td>Full Name:</td>
                    <td><input type="text" name="Fullname" required></td>
                </tr>
                <tr>
                    <td>Gender:</td>
                    <td>
                        <input type="radio" name="Gender" value="Male" required> Male
                        <input type="radio" name="Gender" value="Female" required> Female
                    </td>
                </tr>
                <tr>
                    <td>Age:</td>
                    <td><input type="number" name="Age" required></td>
                </tr>
                <tr>
                    <td>Role:</td>
                    <td><input type="text" name="Role" required></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="Email" required></td>
                </tr>
                <tr>
                    <td>Phone Number:</td>
                    <td><input type="text" name="PhoneNum" required></td>
                </tr>
                <tr>
                    <td>Username:</td>
                    <td><input type="text" name="Username" required></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="Password" required></td>
                </tr>
                <tr>
                    <td>Confirm Password: </td>
                    <td><input type="password" name="ConfirmPassword" required></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="REGISTER">
                    </td>
                </tr>
            </table>
        </form>
        <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
        %>
        <div style='color:red;' class="error"><%= error %></div>
        <% } %>
    </body>
</html>