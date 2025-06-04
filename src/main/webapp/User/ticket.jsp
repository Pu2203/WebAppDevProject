<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="container">
    <h1>Ticket for Bus ${ticket.busNumber}</h1>
    <p>Customer Name: ${ticket.customerName}</p>
    <p>Seats Reserved: ${ticket.seatsReserved}</p>
    <img src="${pageContext.request.contextPath}/qrcode?busId=${ticket.id}&customerName=${ticket.customerName}&seatsReserved=${ticket.seatsReserved}" alt="QR Code">
    <a href="${pageContext.request.contextPath}/buses" class="buttonBack">Back to View Buses</a>
</div> 