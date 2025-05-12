<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/jsp/header.jsp">
    <jsp:param name="title" value="My Tickets" />
    <jsp:param name="page" value="tickets" />
</jsp:include>

<section class="py-5">
    <div class="container">
        <div class="row mb-4">
            <div class="col">
                <div class="d-flex justify-content-between align-items-center">
                    <h2><i class="bi bi-ticket-perforated"></i> My Tickets</h2>
                    <a href="${pageContext.request.contextPath}/home" class="btn btn-outline-secondary">
                        <i class="bi bi-arrow-left"></i> Back to Home
                    </a>
                </div>
            </div>
        </div>
        
        <div class="card shadow-sm">
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead class="table-primary">
                            <tr>
                                <th>Ticket Number</th>
                                <th>Payment Number</th>
                                <th>Route</th>
                                <th>Origin Bus Stop</th>
                                <th>Destination Bus Stop</th>
                                <th>QR Code</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${getTickets}" var="ticket">
                            <tr>
                                <td><span class="badge bg-primary">${ticket.cartId}</span></td>
                                <td><span class="badge bg-primary">${ticket.paymentId}</span></td>
                                <td>${ticket.route}</td>
                                <td>${ticket.origin}</td>
                                <td>${ticket.destination}</td>
                                
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                
                <c:if test="${empty getTickets}">
                    <div class="alert alert-info text-center" role="alert">
                        <i class="bi bi-info-circle me-2"></i> You don't have any tickets yet.
                        <a href="${pageContext.request.contextPath}/TicketInfoServlet" class="alert-link">Buy your first ticket</a>
                    </div>
                </c:if>
            </div>
        </div>
        <hr>   
        <div class="row mb-4">
            <div class="col">
                <div class="d-flex justify-content-between align-items-center">
                    <h2><i class="bi bi-ticket-perforated"></i> My Pass</h2>
                    
                </div>
            </div>
        </div>
        
        <div class="card shadow-sm">
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead class="table-primary">
                            <tr>
                                <th>Ticket ID</th>
                                <th>Bus Number</th>
                                <th>Route</th>
                                <th>Customer Name</th>
                                <th>Seats</th>
                                <th>Time</th>
                                <th>Total Price</th>
                                <th>Status</th>
                                <th>QR Code</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            
                        </tbody>
                    </table>
                </div>
                
                <c:if test="${empty getPass}">
                    <div class="alert alert-info text-center" role="alert">
                        <i class="bi bi-info-circle me-2"></i> You don't have BusPass yet.
                        <a href="${pageContext.request.contextPath}/TicketInfoServlet" class="alert-link">Buy your Pass</a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/jsp/footer.jsp" /> 