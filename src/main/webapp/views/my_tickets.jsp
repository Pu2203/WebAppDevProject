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
                            <c:forEach items="${tickets}" var="ticket">
                            <tr>
                                <td><span class="badge bg-primary">${ticket.id}</span></td>
                                <td>${ticket.busNumber}</td>
                                <td>${ticket.route}</td>
                                <td>${ticket.customerName}</td>
                                <td><span class="badge bg-info">${ticket.seatsReserved}</span></td>
                                <td><i class="bi bi-clock me-1"></i>${ticket.time}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${ticket.plan eq 'block'}">
                                            <span class="text-success fw-bold">$150</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="text-success fw-bold">$${ticket.seatsReserved * ticket.price}</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <c:choose>
                                        <c:when test="${ticket.status eq 'active'}">
                                            <span class="badge bg-success">Active</span>
                                        </c:when>
                                        <c:when test="${ticket.status eq 'used'}">
                                            <span class="badge bg-secondary">Used</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="badge bg-secondary">${ticket.status}</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                                <td>
                                    <img src="${pageContext.request.contextPath}/qrcode?busId=${ticket.id}&customerName=${ticket.customerName}&seatsReserved=${ticket.seatsReserved}" 
                                         alt="QR Code" class="img-thumbnail" width="80" height="80">
                                </td>
                                <td>
                                    <div class="btn-group btn-group-sm">
                                        <a href="${pageContext.request.contextPath}/qrcode?busId=${ticket.id}&customerName=${ticket.customerName}&seatsReserved=${ticket.seatsReserved}" 
                                           download="ticket_qr.png" class="btn btn-outline-primary">
                                            <i class="bi bi-download"></i> QR
                                        </a>
                                        
                                        <c:if test="${sessionScope.user.username eq 'admin'}">
                                            <form action="${pageContext.request.contextPath}/admin/updateTicketStatus?ticketId=${ticket.id}" method="POST" class="d-inline">
                                                <button type="submit" class="btn btn-outline-success">
                                                    <i class="bi bi-qr-code-scan"></i> Scan
                                                </button>
                                            </form>
                                            <form action="${pageContext.request.contextPath}/admin/removeTicket?ticketId=${ticket.id}" method="POST" class="d-inline">
                                                <button type="submit" class="btn btn-outline-danger" onclick="return confirm('Are you sure you want to remove this ticket?')">
                                                    <i class="bi bi-trash"></i>
                                                </button>
                                            </form>
                                        </c:if>
                                    </div>
                                </td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
                
                <c:if test="${empty tickets}">
                    <div class="alert alert-info text-center" role="alert">
                        <i class="bi bi-info-circle me-2"></i> You don't have any tickets yet.
                        <a href="${pageContext.request.contextPath}/views/buy-ticket" class="alert-link">Buy your first ticket</a>
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
                
                <c:if test="${empty tickets}">
                    <div class="alert alert-info text-center" role="alert">
                        <i class="bi bi-info-circle me-2"></i> You don't have BusPass yet.
                        <a href="${pageContext.request.contextPath}/views/buy-ticket" class="alert-link">Buy your Pass</a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/jsp/footer.jsp" /> 