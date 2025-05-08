<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/viewbus.css">
<div class="container">
    <!-- Search and Sort Section -->
    <div class="search-sort-container">
        <!-- Search Form -->
        <form method="POST" action="${pageContext.request.contextPath}/buses" class="controls">
            <input type="text" id="search_query" name="search_query" placeholder="Search by route" class="input1" onkeyup="autocomplete()">
            <div id="suggestions"></div>
            <button type="submit" class="buttonBack">Search</button>
        </form>

        <!-- Sort Buttons -->
        <form method="GET" action="${pageContext.request.contextPath}/buses" class="controls">
            <label for="sort_by" class="label">Sort by:</label>
            <select id="sort_by" name="sort_by" class="input2" onchange="this.form.submit()">
                <option value="" disabled ${empty param.sort_by ? 'selected' : ''}>Select an option</option>
                <option value="time" ${param.sort_by eq 'time' ? 'selected' : ''}>Time</option>
                <option value="bus_number" ${param.sort_by eq 'bus_number' ? 'selected' : ''}>Bus Number</option>
            </select>
        </form>
    </div>
    <!-- Bus Containers -->
    <div class="buses-container">
        <c:forEach items="${buses}" var="bus">
        <div class="bus-container">
            <!-- Bus Image and Number Overlay -->
            <div class="bus-image">
                <img src="${pageContext.request.contextPath}/static/images/bus_image.jpg" alt="Bus Image">
                <div class="text-overlay">${bus.busNumber}</div> <!-- Bus Number on image -->
            </div>

            <div class="bus-info">
                <p><strong>Bus Number:</strong> ${bus.busNumber}</p>
                <p><strong>Route:</strong> ${bus.route}</p>
                <p><strong>Available Seats:</strong> ${bus.availableSeats}</p>
                <p><strong>Time:</strong> ${bus.time}</p>
                <p><strong>Price:</strong> VND ${bus.price}</p>
            </div>

            <a href="${pageContext.request.contextPath}/buyticket?busId=${bus.id}" class="button2">Buy Ticket</a>
            <c:if test="${sessionScope.user.username eq 'admin'}">
            <a href="${pageContext.request.contextPath}/admin/editbus?busId=${bus.id}" class="button2">Edit</a>
            </c:if>
        </div>
        </c:forEach>
    </div>
</div> 