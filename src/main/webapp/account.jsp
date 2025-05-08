<%-- 
    Document   : payment
    Created on : Apr 29, 2025, 9:00:06 AM
    Author     : ductrungnguyen
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Thanh toán - Bus Ticket System</title>
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
                    <c:if test="${not empty sessionScope.user}">
                        <li><a href="${pageContext.request.contextPath}/views/my_tickets.jsp">Vé của tôi</a></li>
                        <li><a href="${pageContext.request.contextPath}/views/profile.jsp">Hồ sơ</a></li>
                        <li><a href="${pageContext.request.contextPath}/LoginServlet?action=LOGOUT">Đăng xuất</a></li>
                    </c:if>
                    <c:if test="${empty sessionScope.user}">
                        <li><a href="${pageContext.request.contextPath}/login.jsp">Đăng nhập</a></li>
                        <li><a href="${pageContext.request.contextPath}/register.jsp">Đăng ký</a></li>
                    </c:if>
                </ul>
            </nav>
        </header>
        
        <main class="container">
            <div class="payment-container">
                <h2>Thanh toán vé xe</h2>
                
                <div class="ticket-summary">
                    <h3>Thông tin vé</h3>
                    <c:if test="${not empty sessionScope.cart}">
                        <table class="ticket-table">
                            <thead>
                                <tr>
                                    <th>Tuyến xe</th>
                                    <th>Ngày đi</th>
                                    <th>Giờ</th>
                                    <th>Số lượng</th>
                                    <th>Giá</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="item" items="${sessionScope.cart}">
                                    <tr>
                                        <td>${item.key}</td>
                                        <td>${item.value}</td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <td colspan="4">Tổng cộng:</td>
                                    <td>0 VND</td>
                                </tr>
                            </tfoot>
                        </table>
                    </c:if>
                </div>
                
                <form action="BusServlet" method="post" class="payment-form">
                    <input type="hidden" name="action" value="PAYMENT"/>
                    
                    <div class="form-section">
                        <h3>Thông tin thanh toán</h3>
                        
                        <div class="form-group">
                            <label for="name">Họ tên chủ thẻ:</label>
                            <input type="text" id="name" name="name" required/>
                        </div>
                        
                        <div class="form-group">
                            <label for="visa">Số thẻ:</label>
                            <input type="text" id="visa" name="visa" required placeholder="XXXX-XXXX-XXXX-XXXX"/>
                        </div>
                        
                        <div class="card-details">
                            <div class="form-group expiry">
                                <label for="expiry">Ngày hết hạn:</label>
                                <input type="text" id="expiry" name="expiry" required placeholder="MM/YY"/>
                            </div>
                            
                            <div class="form-group cvv">
                                <label for="cvv">CVV:</label>
                                <input type="text" id="cvv" name="cvv" required placeholder="XXX"/>
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label for="address">Địa chỉ thanh toán:</label>
                            <input type="text" id="address" name="address" required/>
                        </div>
                    </div>
                    
                    <div class="form-actions">
                        <button type="submit" class="btn-primary">Xác nhận thanh toán</button>
                        <a href="${pageContext.request.contextPath}/views/buy_ticket.jsp" class="btn-secondary">Quay lại</a>
                    </div>
                </form>
            </div>
        </main>
        
        <footer>
            <p>&copy; 2025 Bus Ticket System. All rights reserved.</p>
        </footer>
    </body>
</html>