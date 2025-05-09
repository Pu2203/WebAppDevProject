<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/jsp/header.jsp">
    <jsp:param name="title" value="Buy Ticket" />
    <jsp:param name="page" value="buy" />
</jsp:include>

<section class="py-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <div class="card shadow-sm">
                    <div class="card-header bg-primary text-white py-3">
                        <h5 class="mb-0"><i class="bi bi-ticket-perforated"></i> Buy Ticket</h5>
                    </div>
                    <div class="card-body p-4">
                        <c:if test="${not empty bus}">
                            <div class="alert alert-info mb-4">
                                <div class="d-flex align-items-center mb-2">
                                    <i class="bi bi-info-circle-fill me-2"></i>
                                    <strong>Bus Information:</strong>
                                </div>
                                <ul class="list-unstyled mb-0">
                                    <li><strong>Route:</strong> ${bus.route}</li>
                                    <li><strong>Bus Number:</strong> ${bus.busNumber}</li>
                                    <li><strong>Available Seats:</strong> ${bus.availableSeats}</li>
                                    <li><strong>Price per Seat:</strong> $${bus.price}</li>
                                </ul>
                            </div>
                        </c:if>
                        
                        <form action="${pageContext.request.contextPath}/buyticket?busId=${bus.id}" method="POST">
                            <div class="row g-3">
                                <div class="col-md-6 mb-3">
                                    <label for="customer_name" class="form-label">Customer Name</label>
                                    <div class="input-group">
                                        <span class="input-group-text"><i class="bi bi-person"></i></span>
                                        <input type="text" class="form-control" id="customer_name" name="customer_name" required placeholder="Enter your full name">
                                    </div>
                                </div>
                                
                                <div class="col-md-6 mb-3">
                                    <label for="seats_reserved" class="form-label">Seats Reserved</label>
                                    <div class="input-group">
                                        <span class="input-group-text"><i class="bi bi-person-fill"></i></span>
                                        <input type="number" class="form-control" id="seats_reserved" name="seats_reserved" min="1" max="${bus.availableSeats}" required>
                                    </div>
                                    <small class="text-muted">Maximum: ${bus.availableSeats} seats</small>
                                </div>
                                
                                <div class="col-md-12 mb-3">
                                    <label for="plan" class="form-label">Ticket Plan</label>
                                    <select class="form-select" id="plan" name="plan" required>
                                        <option value="one_time">One-Time Trip ($${bus.price} per seat)</option>
                                        <option value="block">Block Ticket (Flat $150 for multiple trips)</option>
                                    </select>
                                </div>
                                
                                <div class="col-12 mt-3">
                                    <div class="d-flex justify-content-between">
                                        <a href="${pageContext.request.contextPath}/views/view-buses" class="btn btn-outline-secondary">
                                            <i class="bi bi-arrow-left"></i> Back to Buses
                                        </a>
                                        <button type="submit" class="btn btn-primary">
                                            <i class="bi bi-cart-check"></i> Complete Purchase
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/jsp/footer.jsp" /> 