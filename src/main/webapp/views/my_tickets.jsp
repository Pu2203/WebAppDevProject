<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
    <h1>My Tickets</h1>
    <table class="tickets-table">
        <thead>
            <tr>
                <th>Ticket ID</th>
                <th>Bus Number</th>
                <th>Route</th>
                <th>Username</th>
                <th>Customer Name</th>
                <th>Seats Reserved</th>
                <th>Time</th>
                <th>Total Price</th>
                <th>Status</th>
                <th>QR Code</th>
                <th>Download</th>
                <c:if test="${sessionScope.user.username eq 'admin'}">
                <th>Scan</th>
                <th>Delete</th>
                </c:if>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${tickets}" var="ticket">
            <tr>
                <td>${ticket.id}</td>
                <td>${ticket.busNumber}</td>
                <td>${ticket.route}</td>
                <td>${ticket.username}</td>
                <td>${ticket.customerName}</td>
                <td>${ticket.seatsReserved}</td>
                <td>${ticket.time}</td>
                <td>
                    <c:choose>
                        <c:when test="${ticket.plan eq 'block'}">
                            $150
                        </c:when>
                        <c:otherwise>
                            $${ticket.seatsReserved * ticket.price}
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${ticket.status}</td>
                <td>
                    <img src="${pageContext.request.contextPath}/qrcode?busId=${ticket.id}&customerName=${ticket.customerName}&seatsReserved=${ticket.seatsReserved}" alt="QR Code" width="100" height="100">
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/qrcode?busId=${ticket.id}&customerName=${ticket.customerName}&seatsReserved=${ticket.seatsReserved}" download="ticket_qr.png" class="button2">Download QR</a>
                </td>
                <c:if test="${sessionScope.user.username eq 'admin'}">
                <td>
                    <form action="${pageContext.request.contextPath}/admin/updateTicketStatus?ticketId=${ticket.id}" method="POST" style="display:inline;">
                        <button type="submit" class="button2">Scan the Ticket</button>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin/removeTicket?ticketId=${ticket.id}" method="POST" style="display:inline;">
                        <button type="submit" class="buttonRed">Remove Ticket</button>
                    </form>
                </td>
                </c:if>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/home" class="buttonBack">Back to Home</a>
</div> 