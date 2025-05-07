<%-- 
    Document   : account
    Created on : Apr 29, 2025, 9:00:06 AM
    Author     : ductrungnguyen
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<html>
    <head><title>Login Page</title></head>
    <body>
        <h2>Please provide your account information</h2>
        <form action="BusServlet" method="post">
            <table>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name"/></td>
                </tr>
                <tr>
                    <td>VISA Card Number:</td>
                    <td><input type="text" name="visa"/></td>
                </tr>
                <tr>
                    <td>Address </td>
                    <td><input type="text" name="address"/></td>
                </tr>
            </table>
            <input type="hidden" name="action" value="ACCOUNT"/>
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>