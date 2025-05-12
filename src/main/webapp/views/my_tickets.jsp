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


        <br>
        <hr>   


        <div class="row mb-4">
            <div class="col">
                <div class="d-flex justify-content-between align-items-center">
                    <h2><i class="bi bi-ticket-perforated"></i> My Pass</h2>
                </div>
            </div>
        </div>

        <div class="card shadow-sm">
            <div class="card-header bg-success text-white py-3">
                <h5 class="mb-0"><i class="bi bi-person-vcard me-2"></i> Premium Pass</h5>
            </div>
            <div class="card-body">
                <c:if test="${ not empty getPass}">
                    <div class="row" >
                        <div class="col-md-4 d-flex flex-column align-items-center text-center mb-4">
                            <img src="https://bootdey.com/img/Content/avatar/avatar7.png" class="rounded-circle shadow-sm" width="120">
                            <div class="mt-3">
                                <h5>${sessionScope.getPass.fname}</h5>
                                <h5>${sessionScope.getPass.cartType}</h5>
                                <p class="text-muted mb-1">Expired Date: ${sessionScope.getPass.expiredDate}</p>
                            </div>
                        </div>
                        <div class="row col-md-8 d-flex flex-row align-items-center " >
                            <div class="col-md-6 mb-3">
                                <label for="name" class="form-label">Role</label>
                                <div class="input-group">
                                    <span class="input-group-text"><i class="bi bi-person"></i></span>
                                    <input type="text" class="form-control" id="name" name="name" value="${sessionScope.getPass.accountType}" readonly>

                                </div>
                            </div>

                            <div class="col-md-6 mb-3">
                                <label for="Date" class="form-label">Registration Date </label>
                                <div class="input-group">
                                    <span class="input-group-text"><i class="bi bi-calendar"></i></span>
                                    <input type="text" class="form-control" id="username" name="username" value="${sessionScope.getPass.date}" readonly>
                                </div>
                            </div>
                            <c:choose>
                                <c:when test="${getPass.cartStatus == 'Valid'}">
                                    <style>
                                        .bg-field {
                                            background-color: green;
                                        }
                                    </style>
                                </c:when>
                                <c:otherwise>
                                    <style>
                                        .bg-field {
                                            background-color: red;
                                        }
                                    </style>
                                </c:otherwise>
                            </c:choose>
                            <div class="col-md-6 mb-3">
                                <label for="email" class="form-label">Validation check:</label>
                                <div class="input-group">
                                    <span class="input-group-text"><i class="bi bi-key"></i></span>
                                    <input type="text" class="form-control bg-field" id="email" name="email" value="${sessionScope.getPass.cartStatus}" readonly>
                                </div>
                            </div>

                            <div class="col-md-6 mb-3">
                                <label for="phone_number" class="form-label">Phone Number</label>
                                <div class="input-group">
                                    <span class="input-group-text"><i class="bi bi-telephone"></i></span>
                                    <input type="text" class="form-control" id="phone_number" name="phone_number" value="${sessionScope.user.phone}" readonly>
                                </div>
                            </div>

                        </div>
                    </div>

                </c:if>

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