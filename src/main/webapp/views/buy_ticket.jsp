<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="container">
    <h1>Buy Ticket</h1>
    <form action="${pageContext.request.contextPath}/buyticket?busId=${bus.id}" method="POST">
        <div class="form-row">
            <label for="customer_name" class="label2">Customer Name:</label>
            <input type="text" id="customer_name" class="input" name="customer_name" required>
        </div>

        <div class="form-row">
            <label for="seats_reserved" class="label2">Seats Reserved:</label>
            <input type="number" id="seats_reserved" class="input" name="seats_reserved" required>
        </div>

        <div class="form-row">
            <label for="plan" class="label2">Plan:</label>
            <select id="plan" class="input2" name="plan" required>
                <option value="one_time">One-Time</option>
                <option value="block">Block</option>
            </select>
        </div>

        <div class="form-row">
            <button type="submit" class="button2">Buy Ticket</button>
        </div>
    </form>

    <a href="${pageContext.request.contextPath}/buses" class="buttonBack">Back to Buses</a>
</div> 