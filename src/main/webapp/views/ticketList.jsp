<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="/jsp/header.jsp">
    <jsp:param name="title" value="Ticket List" />
</jsp:include>

<section class="py-5">
    <div class="container">
        <h2 class="mb-4"><i class="bi bi-ticket-perforated"></i> Ticket List</h2>
        <div class="row">
            <!-- Iterate over the ticketList -->
            <c:forEach var="ticket" items="${ticketList}">
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card shadow-sm h-100">
                        <div class="card-header bg-primary text-white">
                            <strong>Bus #${ticket.busNumber}</strong>
                        </div>
                        <div class="card-body">
                            <p><strong>Route:</strong> ${ticket.route}</p>
                            <p><strong>Price:</strong> VND ${ticket.price}</p>
                            <p><strong>Type:</strong> ${ticket.type}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>

            <!-- If no tickets are available -->
            <c:if test="${empty ticketList}">
                <div class="col-12">
                    <div class="alert alert-warning text-center">
                        No ticket information found.
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</section>

<jsp:include page="/jsp/footer.jsp" />