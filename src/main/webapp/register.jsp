<%-- 
    Document   : account
    Created on : Apr 29, 2025, 9:00:06 AM
    Author     : ductrungnguyen
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Đăng ký - Bus Ticket System</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles.css">
    </head>
    <body>
        <header>
            <nav class="navbar">
                <div class="logo">Bus Ticket System</div>
                <ul class="nav-links">
                    <li><a href="${pageContext.request.contextPath}/home">Trang chủ</a></li>
                    <li><a href="${pageContext.request.contextPath}/views/view_buses.jsp">Xe bus</a></li>
                    <li><a href="${pageContext.request.contextPath}/views/buy_ticket.jsp">Mua vé</a></li>
                    <li><a href="${pageContext.request.contextPath}/login.jsp">Đăng nhập</a></li>
                    <li><a href="${pageContext.request.contextPath}/register.jsp" class="active">Đăng ký</a></li>
                </ul>
            </nav>
        </header>

        <main class="container">
            <div class="register-container">
                <h2>Đăng ký tài khoản</h2>
                <form action="RegisterServlet" method="post" class="register-form">
                    <input type="hidden" name="action" value="REGISTER">
                    
                    <div class="form-section">
                        <h3>Thông tin cá nhân</h3>
                        <div class="form-group">
                            <label for="fullname">Họ và tên:</label>
                            <input type="text" id="fullname" name="Fullname" required>
                        </div>
                        
                        <div class="form-group">
                            <label>Giới tính:</label>
                            <div class="radio-group">
                                <label><input type="radio" name="Gender" value="Male" required> Nam</label>
                                <label><input type="radio" name="Gender" value="Female" required> Nữ</label>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label for="dob">Ngày sinh:</label>
                            <input type="date" id="dob" name="DoB" required>
                        </div>
                        
                        <div class="form-group">
                            <label for="role">Loại tài khoản:</label>
                            <select id="role" name="Role" required>
                                <option value="Student">Học sinh/Sinh viên</option>
                                <option value="Elder">Người cao tuổi</option>
                                <option value="Normal">Thường</option>
                            </select>
                        </div>
                    </div>
                    
                    <div class="form-section">
                        <h3>Thông tin liên hệ</h3>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="email" id="email" name="Email" required>
                        </div>
                        
                        <div class="form-group">
                            <label for="phone">Số điện thoại:</label>
                            <input type="text" id="phone" name="PhoneNum" required>
                        </div>
                    </div>
                    
                    <div class="form-section">
                        <h3>Thông tin tài khoản</h3>
                        <div class="form-group">
                            <label for="username">Tên đăng nhập:</label>
                            <input type="text" id="username" name="Username" required>
                        </div>
                        
                        <div class="form-group">
                            <label for="password">Mật khẩu:</label>
                            <input type="password" id="password" name="Password" required>
                        </div>
                        
                        <div class="form-group">
                            <label for="confirm-password">Xác nhận mật khẩu:</label>
                            <input type="password" id="confirm-password" name="ConfirmPassword" required>
                        </div>
                    </div>
                    
                    <div class="form-actions">
                        <button type="submit" class="btn-primary">Đăng ký</button>
                    </div>
                </form>
                
                <div class="login-link">
                    <p>Đã có tài khoản? <a href="login.jsp">Đăng nhập ngay</a></p>
                </div>
                
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