<%@page import="DAO.DBConnection"%>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập - Bus Ticket System</title>
    <link rel="stylesheet" href="static/styles.css">
    <link rel="stylesheet" href="static/login.css">
</head>
<body>
    <%@ include file="/includes/header.jsp" %>

    <main class="container">
        <div class="login-container">
            <h2>Đăng nhập</h2>
            <form action="LoginServlet" method="post" class="login-form">
                <input type="hidden" name="action" value="LOGIN">
                <table>
                    <tr>
                        <div class="form-group">
                            <td><label for="username">Tên đăng nhập:</label></td>
                            <td><input type="text" id="username" name="username" required /></td>
                        </div>
                    </tr>
                    
                    <tr>
                        <div class="form-group">
                            <td><label for="password">Mật khẩu:</label></td>
                            <td><input type="password" id="password" name="password" required /></td>
                        </div>
                    </tr>
                </table>
                
                
                <div class="form-actions">
                    <button type="submit" class="btn-primary">Đăng nhập</button>
                </div>
            </form>
            
            <div class="register-link">
                <p>Chưa có tài khoản? <a href="register.jsp">Đăng ký ngay</a></p>
            </div>
            
            <c:if test="${not empty requestScope.message}">
                <div class="success-message">${requestScope.message}</div>
            </c:if>
            
            <c:if test="${not empty requestScope.error}">
                <div class="error-message">${requestScope.error}</div>
            </c:if>
        </div>
    </main>
    
    <%@ include file="/includes/footer.jsp" %>

</body>
</html>