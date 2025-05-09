<%-- 
    Document   : home
    Created on : May 8, 2025, 10:05:35 AM
    Author     : ductrungnguyen
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bus Ticket System - Home</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles.css">
    </head>
    <body>
        <%@ include file="/includes/header.jsp" %>

        <main class="container">
            <section class="hero">
                <h1>Chào mừng đến với Hệ thống Đặt vé Xe Bus</h1>
                <p>Đặt vé xe bus nhanh chóng, tiện lợi và an toàn</p>
                <a href="${pageContext.request.contextPath}/views/buy_ticket.jsp" class="btn-primary">Đặt vé ngay</a>
            </section>

            <section class="search-section">
                <h2>Tìm kiếm tuyến xe</h2>
                <form action="${pageContext.request.contextPath}/BusServlet" method="get" class="search-form">
                    <input type="hidden" name="action" value="SEARCH">
                    <div class="form-group">
                        <label for="departure">Điểm khởi hành:</label>
                        <input type="text" id="departure" name="departure" required>
                    </div>
                    <div class="form-group">
                        <label for="destination">Điểm đến:</label>
                        <input type="text" id="destination" name="destination" required>
                    </div>
                    <div class="form-group">
                        <label for="date">Ngày đi:</label>
                        <input type="date" id="date" name="date" required>
                    </div>
                    <button type="submit" class="btn-search">Tìm kiếm</button>
                </form>
            </section>

            <section class="popular-routes">
                <h2>Tuyến phổ biến</h2>
                <div class="route-cards">
                    <div class="route-card">
                        <h3>Hà Nội - Hồ Chí Minh</h3>
                        <p>Từ 500.000 VND</p>
                        <a href="${pageContext.request.contextPath}/views/buy_ticket.jsp?from=hanoi&to=hcm" class="btn-secondary">Đặt ngay</a>
                    </div>
                    <div class="route-card">
                        <h3>Đà Nẵng - Huế</h3>
                        <p>Từ 150.000 VND</p>
                        <a href="${pageContext.request.contextPath}/views/buy_ticket.jsp?from=danang&to=hue" class="btn-secondary">Đặt ngay</a>
                    </div>
                    <div class="route-card">
                        <h3>Nha Trang - Đà Lạt</h3>
                        <p>Từ 200.000 VND</p>
                        <a href="${pageContext.request.contextPath}/views/buy_ticket.jsp?from=nhatrang&to=dalat" class="btn-secondary">Đặt ngay</a>
                    </div>
                </div>
            </section>
        </main>

        <%@ include file="/includes/footer.jsp" %>
    </body>
</html>
