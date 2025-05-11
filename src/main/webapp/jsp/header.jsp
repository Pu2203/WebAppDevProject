<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${param.title} - Bus Ticket System</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles.css">
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/home">Bus Ticket System</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" 
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link ${param.page eq 'home' ? 'active' : ''}" href="${pageContext.request.contextPath}/home">
                                <i class="bi bi-house-door"></i> Home
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link ${param.page eq 'buses' ? 'active' : ''}" href="TicketInfoServlet">
                                <i class="bi bi-bus-front"></i> Buses
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link ${param.page eq 'buy' ? 'active' : ''}" href="${pageContext.request.contextPath}/views/buy-ticket">
                                <i class="bi bi-ticket-perforated"></i> Buy Tickets
                            </a>
                        </li>
                    </ul>
                    <ul class="navbar-nav">
                        <c:if test="${not empty sessionScope.account.username}">
                            <li class="nav-item">
                                <a class="nav-link ${param.page eq 'tickets' ? 'active' : ''}" href="${pageContext.request.contextPath}/views/my-tickets">
                                    <i class="bi bi-journal-check"></i> My Tickets
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link ${param.page eq 'profile' ? 'active' : ''}" href="${pageContext.request.contextPath}/views/profile">
                                    <i class="bi bi-person-circle"></i> Profile
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="${pageContext.request.contextPath}/LogoutServlet?action=LOGOUT">
                                    <i class="bi bi-box-arrow-right"></i> Logout
                                </a>
                            </li>
                        </c:if>
                        <c:if test="${empty sessionScope.account.username}">
                            <li class="nav-item">
                                <a class="nav-link ${param.page eq 'login' ? 'active' : ''}" href="${pageContext.request.contextPath}/login">
                                    <i class="bi bi-box-arrow-in-right"></i> Login
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link ${param.page eq 'register' ? 'active' : ''}" href="${pageContext.request.contextPath}/register">
                                    <i class="bi bi-person-plus"></i> Register
                                </a>
                            </li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <!-- Main content starts after this -->
    <main class="container py-4"> 