<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/jsp/header.jsp">
    <jsp:param name="title" value="View Buses" />
    <jsp:param name="page" value="buses" />
</jsp:include>

<section class="py-5">
    <div class="container">
        <!-- Bus Pass Section -->
        <div class="row justify-content-center mb-5">
            <div class="col-lg-10">
                <div class="card shadow-sm">
                    <div class="card-header bg-success text-white py-3">
                        <h5 class="mb-0"><i class="bi bi-card-heading"></i> Bus Pass Options</h5>
                    </div>
                    <div class="card-body">
                        <p>Get unlimited access to rides on your chosen route. Ideal for regular travelers!</p>
                        <div class="row">
                            <!-- One Month Pass -->
                            <div class="col-md-6">
                                <h6><strong>One Month Pass:</strong></h6>
                                <p>Price: VND 150,000</p>
                                <a href="${pageContext.request.contextPath}/views/payment.jsp?type=OneMonth&price=150000" 
                                class="btn btn-success mt-3">
                                    <i class="bi bi-card-checklist"></i> Purchase One Month Pass
                                </a>
                            </div>
                            <!-- One Year Pass -->
                            <div class="col-md-6">
                                <h6><strong>One Year Pass:</strong></h6>
                                <p>Price: VND 1,500,000</p>
                                <a href="${pageContext.request.contextPath}/views/payment.jsp?type=OneYear&price=1500000" 
                                class="btn btn-success mt-3">
                                    <i class="bi bi-card-checklist"></i> Purchase One Year Pass
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Separator -->
        <hr class="my-4" />

        <div class="container">
            <!-- Search and Sort Section -->
            <div class="row mb-4 justify-content-center">
                <div class="col-lg-10">
                    <div class="card shadow-sm">
                        <div class="card-header bg-primary text-white">
                            <h4 class="mb-0"><i class="bi bi-search"></i> Search Buses</h4>
                        </div>
                        <div class="card-body">
                            <form method="POST" action="${pageContext.request.contextPath}/SearchServlet" class="row g-3">
                                <div class="col-md-6">
                                    <div class="input-group">
                                        <span class="input-group-text"><i class="bi bi-search"></i></span>
                                        <input type="text" id="search_query" name="search_query" placeholder="Search" class="form-control" onkeyup="autocomplete()">
                                    </div>
                                    <div id="suggestions" class="dropdown-menu"></div>
                                </div>
                                <div class="col-md-3">
                                    <select id="sort_by" name="sort_by" class="form-select" >
                                        <option value="" disabled ${empty param.sort_by ? 'selected' : ''}>Search by</option>
                                        <option value="time" ${param.sort_by eq 'OnD' ? 'selected' : ''}>Origin - Destination</option>
                                        <option value="bus_number" ${param.sort_by eq 'Route' ? 'selected' : ''}>Route</option>
                                    </select>
                                </div>
                                <div class="col-md-3">
                                    <button type="submit" class="btn btn-primary w-100">
                                        <i class="bi bi-search"></i> Search
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

            <hr class="my-4" />

            <!-- Bus Listings -->
            <h2 class="mb-4"><i class="bi bi-bus-front"></i> Available Buses</h2>
            <div class="row">
                <!-- Iterate over the ticketList -->
                <c:forEach var="ticket" items="${sessionScope.ticketList}">
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="card shadow-sm h-100">
                            <div class="card-header bg-info text-white">
                                ${ticket.routeNumber}
                            </div>
                            <div class="card-body">
                                <p><strong>Origin:</strong> ${ticket.origin}</p>
                                <p><strong>Destination:</strong> ${ticket.destination}</p>
                                <p><strong>Price:</strong> VND ${ticket.price}</p>
                                <a href="${pageContext.request.contextPath}/views/buy-ticket" class="btn btn-success mt-3">
                                    <i class="bi bi-card-checklist"></i> Purchase Ticket
                                </a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <c:if test="${empty sessionScope.ticketList}">
                    <div class="col-12">
                        <div class="alert alert-warning text-center">
                            No ticket information found.
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/jsp/footer.jsp" /> 