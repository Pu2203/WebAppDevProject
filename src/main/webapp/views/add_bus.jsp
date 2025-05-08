<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
    <h1>Add Bus</h1>
    <form action="${pageContext.request.contextPath}/admin/addBus" method="POST">
        <div class="form-row">
            <label for="bus_number" class="label2">Bus Number:</label>
            <input type="text" id="bus_number" class="input" name="bus_number" required>
        </div>

        <div class="form-row">
            <label for="route" class="label2">Route:</label>
            <input type="text" id="route" class="input" name="route" required>
        </div>

        <div class="form-row">
            <label for="total_seats" class="label2">Total Seats:</label>
            <input type="number" id="total_seats" class="input" name="total_seats" required>
        </div>
        
        <div class="form-row">
            <label for="time" class="label2">Time:</label>
            <input type="text" id="time" class="input" name="time" required>
        </div>

        <div class="form-row">
            <label for="price" class="label2">Price:</label>
            <input type="number" id="price" class="input" name="price" required>
        </div>

        <div class="form-row">
            <button type="submit" class="button2">Add Bus</button>
        </div>
    </form>
    <a href="${pageContext.request.contextPath}/buses" class="buttonBack">Back to Buses</a>
</div> 