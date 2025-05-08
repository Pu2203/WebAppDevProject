<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
    <h1>Edit Bus ${bus.busNumber}</h1>
    <form action="${pageContext.request.contextPath}/admin/editbus?busId=${bus.id}" method="POST">
        <div class="form-row">
            <label for="bus_number" class="label2">Bus Number:</label>
            <input type="text" id="bus_number" class="input" name="bus_number" value="${bus.busNumber}" required>
        </div>

        <div class="form-row">
            <label for="route" class="label2">Route:</label>
            <input type="text" id="route" class="input" name="route" value="${bus.route}" required>
        </div>

        <div class="form-row">
            <label for="total_seats" class="label2">Total Seats:</label>
            <input type="number" id="total_seats" class="input" name="total_seats" value="${bus.totalSeats}" required>
        </div>

        <div class="form-row">
            <label for="available_seats" class="label2">Available Seats:</label>
            <input type="number" id="available_seats" class="input" name="available_seats" value="${bus.availableSeats}" required>
        </div>

        <div class="form-row">
            <label for="time" class="label2">Time:</label>
            <input type="text" id="time" class="input" name="time" value="${bus.time}" required>
        </div>

        <div class="form-row">
            <label for="price" class="label2">Price:</label>
            <input type="number" id="price" class="input" name="price" value="${bus.price}" step="0.01" required>
        </div>

        <div class="form-row">
            <button type="submit" class="button2">Update Bus</button>
        </div>
    </form>
    <form action="${pageContext.request.contextPath}/admin/deletebus?busId=${bus.id}" method="POST" onsubmit="return confirm('Are you sure you want to delete this bus?');">
        <div class="form-row">
            <button type="submit" class="buttonRed">Delete Bus</button>
        </div>
    </form>
    <a href="${pageContext.request.contextPath}/buses" class="buttonBack">Back to View Buses</a>
</div> 