<%@page import="data.DBConnection"%>
<%@ page import="java.sql.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Login</h2>
    <form method="post">
        Username: <input type="text" name="username" required /><br/><br/>
        Password: <input type="password" name="password" required /><br/><br/>
        <input type="submit" value="Login" />
    </form>
    <form method="post" action="register.jsp">
        
        <input type="submit" value="Register" />
    </form>
    <%
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            Connection conn = null;
            PreparedStatement stmt = null;
            ResultSet rs = null;

            try {
                conn = DBConnection.getConnection();

                String sql = "SELECT * FROM Account WHERE Username = ? AND Password = ?";
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, username);
                stmt.setString(2, password);

                rs = stmt.executeQuery();

                if (rs.next()) {
                    out.println("<p style='color:green;'>Login successful! Welcome, " + username + ".</p>");
                } else {
                    out.println("<p style='color:red;'>Invalid username or password.</p>");
                }

            } catch (Exception e) {
                out.println("<p style='color:red;'>Error: " + e.getMessage() + "</p>");
            } finally {
                try { if (rs != null) rs.close(); } catch (SQLException e) {}
                try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
                try { if (conn != null) conn.close(); } catch (SQLException e) {}
            }
        }
    %>
</body>
</html>