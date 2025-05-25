<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/jsp/logo.jsp"></jsp:include>

<jsp:include page="/jsp/header.jsp">
    <jsp:param name="title" value="Home" />
    <jsp:param name="page" value="home" />
</jsp:include>

<!-- Hero Section -->
<section class="py-5 bg-light text-center">
    <div class="container px-5">
        <h1 class="display-4 fw-bold">Welcome to Digital Bus Pass System</h1>
        <p class="lead mb-4">Book bus tickets quickly, conveniently and safely</p>
        <img src="${pageContext.request.contextPath}/img/img.png" alt="Logo" style="width: 250px; height: 250px;">
        <br>
        <a href="${pageContext.request.contextPath}/TicketInfoServlet" class="btn btn-primary btn-lg">
            <i class="bi bi-ticket-perforated"></i> Book Now
        </a>
    </div>
</section>

<!-- Search Section -->
<!--<section class="py-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <div class="card shadow-sm">
                    <div class="card-header bg-primary text-white">
                        <h4 class="mb-0"><i class="bi bi-search"></i> Search Routes</h4>
                    </div>
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/BusServlet" method="get">
                            <input type="hidden" name="action" value="SEARCH">
                            <div class="row g-3">
                                <div class="col-md-4">
                                    <label for="departure" class="form-label">Departure Point:</label>
                                    <div class="input-group">
                                        <span class="input-group-text"><i class="bi bi-geo-alt"></i></span>
                                        <input type="text" class="form-control" id="departure" name="departure" required>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <label for="destination" class="form-label">Destination:</label>
                                    <div class="input-group">
                                        <span class="input-group-text"><i class="bi bi-geo-alt-fill"></i></span>
                                        <input type="text" class="form-control" id="destination" name="destination" required>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <label for="date" class="form-label">Departure Date:</label>
                                    <div class="input-group">
                                        <span class="input-group-text"><i class="bi bi-calendar3"></i></span>
                                        <input type="date" class="form-control" id="date" name="date" required>
                                    </div>
                                </div>
                                <div class="col-12 text-center mt-4">
                                    <button type="submit" class="btn btn-primary px-4">
                                        <i class="bi bi-search"></i> Search
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section><!--

<!-- Popular Routes Section -->
<!--<section class="py-5 bg-light">
    <div class="container">
        <h2 class="text-center mb-5">Popular Routes</h2>
        <div class="row">
            <div class="col-lg-4 mb-4">
                <div class="card h-100 shadow-sm hover-effect">
                    <div class="card-body">
                        <h5 class="card-title">Hanoi - Ho Chi Minh City</h5>
                        <div class="d-flex align-items-center mb-3">
                            <i class="bi bi-currency-dollar text-success me-2"></i>
                            <span>From 500,000 VND</span>
                        </div>
                        <div class="d-flex align-items-center mb-3">
                            <i class="bi bi-clock me-2"></i>
                            <span>Duration: 36-48 hours</span>
                        </div>
                        <div class="d-flex align-items-center mb-3">
                            <i class="bi bi-calendar3 me-2"></i>
                            <span>Daily</span>
                        </div>
                    </div>
                    <div class="card-footer bg-white border-top-0 text-center">
                        <a href="${pageContext.request.contextPath}/views/buy-ticket?from=hanoi&to=hcm" class="btn btn-outline-primary">
                            <i class="bi bi-ticket-perforated"></i> Book Now
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 mb-4">
                <div class="card h-100 shadow-sm hover-effect">
                    <div class="card-body">
                        <h5 class="card-title">Da Nang - Hue</h5>
                        <div class="d-flex align-items-center mb-3">
                            <i class="bi bi-currency-dollar text-success me-2"></i>
                            <span>From 150,000 VND</span>
                        </div>
                        <div class="d-flex align-items-center mb-3">
                            <i class="bi bi-clock me-2"></i>
                            <span>Duration: 2-3 hours</span>
                        </div>
                        <div class="d-flex align-items-center mb-3">
                            <i class="bi bi-calendar3 me-2"></i>
                            <span>Daily</span>
                        </div>
                    </div>
                    <div class="card-footer bg-white border-top-0 text-center">
                        <a href="${pageContext.request.contextPath}/views/buy-ticket?from=danang&to=hue" class="btn btn-outline-primary">
                            <i class="bi bi-ticket-perforated"></i> Book Now
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 mb-4">
                <div class="card h-100 shadow-sm hover-effect">
                    <div class="card-body">
                        <h5 class="card-title">Nha Trang - Da Lat</h5>
                        <div class="d-flex align-items-center mb-3">
                            <i class="bi bi-currency-dollar text-success me-2"></i>
                            <span>From 200,000 VND</span>
                        </div>
                        <div class="d-flex align-items-center mb-3">
                            <i class="bi bi-clock me-2"></i>
                            <span>Duration: 3-4 hours</span>
                        </div>
                        <div class="d-flex align-items-center mb-3">
                            <i class="bi bi-calendar3 me-2"></i>
                            <span>Daily</span>
                        </div>
                    </div>
                    <div class="card-footer bg-white border-top-0 text-center">
                        <a href="${pageContext.request.contextPath}/views/buy-ticket?from=nhatrang&to=dalat" class="btn btn-outline-primary">
                            <i class="bi bi-ticket-perforated"></i> Book Now
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>--!>

<jsp:include page="/jsp/footer.jsp" />
