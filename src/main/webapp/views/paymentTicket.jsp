<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/jsp/header.jsp">
    <jsp:param name="title" value="Ticket Payment Confirmation" />
</jsp:include>

<section class="py-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-6">
                <div class="card shadow-sm">
                    <div class="card-header bg-primary text-white">
                        <h4 class="mb-0"><i class="bi bi-credit-card"></i> Ticket Payment Confirmation</h4>
                    </div>
                    <div class="card-body">
                        <p><strong>Route:</strong> ${param.route}</p>
                        <p><strong>Origin:</strong> ${param.origin}</p>
                        <p><strong>Destination:</strong> ${param.destination}</p>
                        <p><strong>Price:</strong> VND ${param.price}</p>
                        <form action="${pageContext.request.contextPath}/PaymentTicketServlet" method="post">
                            <input type="hidden" name="price" value="${param.price}" />
                            <input type="hidden" name="ticketId" value="${param.ticketId}" />
                            <button type="submit" class="btn btn-success w-100">
                                <i class="bi bi-cash"></i> Confirm Payment
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/jsp/footer.jsp" />