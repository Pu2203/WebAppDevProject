<%-- 
    Document   : account
    Created on : Apr 29, 2025, 9:00:06 AM
    Author     : ductrungnguyen
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Đăng ký - Bus Ticket System</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/register.css">

    </head>
    <body>
        <%@ include file="/includes/header.jsp" %>


        <main class="container">
            <div class="register-container">
                <h2>Đăng ký tài khoản</h2>
                <form action="RegisterServlet" method="post" class="register-form">
                    <input type="hidden" name="action" value="REGISTER">

                    <div class="form-section">
                        
                        <h3>Thông tin cá nhân</h3>
                        <table>
                            <tr>
                                <div class="form-group">
                                    <td><label for="fullname">Họ và tên:</label></td>
                                    <td><input type="text" id="fullname" name="Fullname" required></td>
                                </div>
                            </tr>
                            
                            <tr>
                                <div class="form-group">
                                    <td><label>Giới tính:</label></td>
                                    <td>
                                        <div class="radio-group">
                                            <label><input type="radio" name="Gender" value="Male" required> Nam</label>
                                            <label><input type="radio" name="Gender" value="Female" required> Nữ</label>
                                        </div>
                                    </td>
                                </div>
                            </tr>

                            <tr>
                                <div class="form-group">
                                    <td><label for="dob">Ngày sinh:</label></td>
                                    <td><input type="date" id="dob" name="DoB" required></td>
                                </div>
                            </tr>
                            
                            <tr>
                                <div class="form-group">
                                    <td><label for="role">Loại tài khoản:</label></td>
                                    <td>
                                        <select id="role" name="Role" required>
                                            <option value="Student">Học sinh/Sinh viên</option>
                                            <option value="Elder">Người cao tuổi</option>
                                            <option value="Normal">Thường</option>
                                        </select>
                                    </td>
                                </div>
                            </tr>
                            
                        </table>
                    </div>

                    <div class="form-section">
                        <h3>Thông tin liên hệ</h3>
                        <table>
                            <tr>
                                <div class="form-group">
                                    <td><label for="email">Email:</label></td>
                                    <td><input type="email" id="email" name="Email" required></td>
                                </div>
                            </tr>


                            <tr>
                                <div class="form-group">
                                    <td><label for="phone">Số điện thoại:</label></td>
                                    <td><input type="text" id="phone" name="PhoneNum" required></td>
                                </div>
                            </tr>
                        </table>

                    </div>

                    <div class="form-section">
                        <h3>Thông tin tài khoản</h3>
                        <table>
                            <tr>
                                <div class="form-group">
                                    <td><label for="username">Tên đăng nhập:</label></td>
                                    <td><input type="text" id="username" name="Username" required></td>
                                </div>
                            </tr>

                            <tr>
                                <div class="form-group">
                                    <td><label for="password">Mật khẩu:</label></td>
                                    <td><input type="password" id="password" name="Password" required></td>
                                </div>
                            </tr>

                            <tr>
                                <div class="form-group">
                                    <td><label for="confirm-password">Xác nhận mật khẩu:</label></td>
                                    <td><input type="password" id="confirm-password" name="ConfirmPassword" required></td>
                                </div>
                            </tr>

                        </table>
                        
                    </div>

                    <div class="form-actions">
                        <button type="submit" class="btn-primary">Đăng ký</button>
                    </div>
                </form>
                
                <c:if test="${not empty requestScope.error}">
                    <div class="error-message">${requestScope.error}</div>
                </c:if>
                
                <div class="login-link">
                    <p>Đã có tài khoản? <a href="login.jsp">Đăng nhập ngay</a></p>
                </div>

                
            </div>
        </main>

        <footer>
            <p>&copy; 2025 Bus Ticket System. All rights reserved.</p>
        </footer>
    </body>
</html>