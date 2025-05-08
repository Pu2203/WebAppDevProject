<%@page import="DAO.DBConnection"%>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập - Bus Ticket System</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/login.css">
</head>
<body>
    <header>
        <nav class="navbar">
            <div class="logo">Bus Ticket System</div>
            <ul class="nav-links">
                <li><a href="${pageContext.request.contextPath}/home.jsp">Trang chủ</a></li>
                <li><a href="${pageContext.request.contextPath}/views/view_buses.jsp">Xe bus</a></li>
                <li><a href="${pageContext.request.contextPath}/views/buy_ticket.jsp">Mua vé</a></li>
                <li><a href="${pageContext.request.contextPath}/login.jsp" class="active">Đăng nhập</a></li>
                <li><a href="${pageContext.request.contextPath}/register.jsp">Đăng ký</a></li>
            </ul>
        </nav>
    </header>

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
    
    <footer>
        <p>&copy; 2025 Bus Ticket System. All rights reserved.</p>
    </footer>
</body>
</html>