<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<jsp:include page="/jsp/header.jsp">
    <jsp:param name="title" value="View Buses" />
    <jsp:param name="page" value="buses" />
</jsp:include>

<section class="py-5">
    <div class="container">
        <!-- Search and Sort Section -->
        <div class="row mb-4">
            <div class="col-lg-8">
                <div class="card shadow-sm">
                    <div class="card-header bg-primary text-white">
                        <h4 class="mb-0"><i class="bi bi-search"></i> Search Buses</h4>
                    </div>
                    <div class="card-body">
                        <form method="POST" action="${pageContext.request.contextPath}/buses" class="row g-3">
                            <div class="col-md-6">
                                <div class="input-group">
                                    <span class="input-group-text"><i class="bi bi-search"></i></span>
                                    <input type="text" id="search_query" name="search_query" placeholder="Search by route" class="form-control" onkeyup="autocomplete()">
                                </div>
                                <div id="suggestions" class="dropdown-menu"></div>
                            </div>
                            <div class="col-md-3">
                                <select id="sort_by" name="sort_by" class="form-select" onchange="this.form.submit()">
                                    <option value="" disabled ${empty param.sort_by ? 'selected' : ''}>Sort by</option>
                                    <option value="time" ${param.sort_by eq 'time' ? 'selected' : ''}>Time</option>
                                    <option value="bus_number" ${param.sort_by eq 'bus_number' ? 'selected' : ''}>Bus Number</option>
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
            
            <div class="col-lg-4">
                <c:if test="${sessionScope.account.username eq 'admin'}">
                    <div class="d-grid">
                        <a href="${pageContext.request.contextPath}/views/add-bus" class="btn btn-success btn-lg">
                            <i class="bi bi-plus-circle"></i> Add New Bus
                        </a>
                    </div>
                </c:if>
            </div>
        </div>
        
        <!-- Bus Listings -->
        <h2 class="mb-4"><i class="bi bi-bus-front"></i> Available Buses</h2>
        <div class="row">
            <c:forEach items="${buses}" var="bus">
                <div class="col-lg-4 col-md-6 mb-4">
                    <div class="card h-100 shadow-sm hover-effect">
                        <div class="position-relative">
                            <img src="${pageContext.request.contextPath}/static/images/bus_image.jpg" alt="Bus Image" class="card-img-top">
                            <div class="position-absolute top-0 end-0 bg-primary text-white p-2 m-2 rounded">
                                <strong>${bus.busNumber}</strong>
                            </div>
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">${bus.route}</h5>
                            <div class="d-flex align-items-center mb-2">
                                <i class="bi bi-clock text-primary me-2"></i>
                                <span>${bus.time}</span>
                            </div>
                            <div class="d-flex align-items-center mb-2">
                                <i class="bi bi-people text-primary me-2"></i>
                                <span>Available Seats: ${bus.availableSeats}</span>
                            </div>
                            <div class="d-flex align-items-center mb-3">
                                <i class="bi bi-currency-dollar text-success me-2"></i>
                                <span class="fw-bold">VND ${bus.price}</span>
                            </div>
                        </div>
                        <div class="card-footer bg-white border-top-0 d-flex justify-content-between">
                            <a href="${pageContext.request.contextPath}/views/buy-ticket?busId=${bus.id}" class="btn btn-primary">
                                <i class="bi bi-ticket-perforated"></i> Buy Ticket
                            </a>
                            <c:if test="${sessionScope.account.username eq 'admin'}">
                                <a href="${pageContext.request.contextPath}/views/edit-bus?busId=${bus.id}" class="btn btn-outline-secondary">
                                    <i class="bi bi-pencil"></i> Edit
                                </a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </c:forEach>
            
            <c:if test="${empty buses}">
                <div class="col-12">
                    <div class="alert alert-info text-center" role="alert">
                        <i class="bi bi-info-circle me-2"></i> No buses found matching your criteria.
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</section>

<jsp:include page="/jsp/footer.jsp" /> 