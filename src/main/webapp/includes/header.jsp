<%-- 
    Document   : header
    Created on : May 9, 2025, 5:49:45 PM
    Author     : ductr
--%>
<link rel="stylesheet" href="static/header.css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<header>
    <ul class="nav-links">
        <li><a href="home.jsp">Trang chủ</a></li>
        <li><a href="views/view_buses.jsp">Xe bus</a></li>
        <li><a href="views/buy_ticket.jsp">Mua vé</a></li>
            <%
                String username = (String) session.getAttribute("username");
                if (username == null){
            %>
        <li><a href="login.jsp">Đăng nhập</a></li>
        <li><a href="register.jsp">Đăng ký</a></li>
        <%}else{%>
        <li><a href="views/my_tickets.jsp">Vé của tôi</a></li>
        <li><a href="views/profile.jsp"><%=username%></a></li>
        <li><a href="LogoutServlet">Đăng xuất</a></li>
        <%}%>
        
    </ul>

</header>