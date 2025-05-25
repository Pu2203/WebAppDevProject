<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/jsp/logo.jsp"></jsp:include>

<jsp:include page="/jsp/header.jsp">
    <jsp:param name="title" value="Account" />
    <jsp:param name="page" value="profile" />
</jsp:include>

<section class="py-5">
    <div class="container">
        <div class="row">
            <!-- Sidebar -->
            <div class="col-lg-3 mb-4">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <div class="d-flex flex-column align-items-center text-center mb-4">
                            <img src="https://bootdey.com/img/Content/avatar/avatar7.png" class="rounded-circle shadow-sm" width="120">
                            <div class="mt-3">
                                <h5>${sessionScope.user.fullname}</h5>
                                <p class="text-muted mb-1">${sessionScope.user.role}</p>
                                <p class="text-muted mb-1">${sessionScope.user.username}</p>
                            </div>
                        </div>
                        <div class="list-group">
                            <a href="${pageContext.request.contextPath}/views/profile" class="list-group-item list-group-item-action active">
                                <i class="bi bi-person-circle me-2"></i> Account Information
                            </a>
                            <a href="${pageContext.request.contextPath}/views/my-tickets" class="list-group-item list-group-item-action">
                                <i class="bi bi-ticket-perforated me-2"></i> My Tickets
                            </a>
                            <a href="${pageContext.request.contextPath}/views/purchase-history" class="list-group-item list-group-item-action">
                                <i class="bi bi-clock-history me-2"></i> Purchase History
                            </a>
                            <a href="${pageContext.request.contextPath}/views/change-password" class="list-group-item list-group-item-action">
                                <i class="bi bi-shield-lock me-2"></i> Change Password
                            </a>
                            <a href="${pageContext.request.contextPath}/LoginServlet?action=LOGOUT" class="list-group-item list-group-item-action text-danger">
                                <i class="bi bi-box-arrow-right me-2"></i> Logout
                            </a>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- Main content -->
            <div class="col-lg-9">
                <div class="card shadow-sm">
                    <div class="card-header bg-primary text-white py-3">
                        <h5 class="mb-0"><i class="bi bi-person-vcard me-2"></i> Account Information</h5>
                    </div>
                    <div class="card-body">
                        <c:if test="${not empty sessionScope.user}">
                            <form action="${pageContext.request.contextPath}/UpdateProfileServlet" method="post">
                                <input type="hidden" name="action" value="UPDATE_PROFILE">
                                
                                <div class="row mb-4">
                                    <div class="col-md-6 mb-3">
                                        <label class="form-label">Full Name</label>
                                        <input type="text" class="form-control" name="Fullname" value="${sessionScope.user.fullname}" required>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label class="form-label">Gender</label>
                                        <div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="Gender" id="male" value="Male" 
                                                    ${sessionScope.user.gender eq 'Male' ? 'checked' : ''}>
                                                <label class="form-check-label" for="male">Male</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="Gender" id="female" value="Female" 
                                                    ${sessionScope.user.gender eq 'Female' ? 'checked' : ''}>
                                                <label class="form-check-label" for="female">Female</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label class="form-label">Email</label>
                                        <input type="email" class="form-control" name="Email" value="${sessionScope.user.email}" required>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label class="form-label">Phone Number</label>
                                        <input type="text" class="form-control" name="PhoneNum" value="${sessionScope.user.phoneNum}" required>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <label class="form-label">Date of Birth</label>
                                        <input type="date" class="form-control" name="DoB" value="${sessionScope.user.dob}" required>
                                    </div>
                                    <div class="col-md-6">
                                        <label class="form-label">Account Type</label>
                                        <select class="form-select" name="Role" required>
                                            <option value="Student" ${sessionScope.user.role eq 'Student' ? 'selected' : ''}>Student</option>
                                            <option value="Elder" ${sessionScope.user.role eq 'Elder' ? 'selected' : ''}>Senior Citizen</option>
                                            <option value="Normal" ${sessionScope.user.role eq 'Normal' ? 'selected' : ''}>Regular</option>
                                        </select>
                                    </div>
                                </div>
                                
                                <button type="submit" class="btn btn-primary">
                                    <i class="bi bi-save me-2"></i> Save Changes
                                </button>
                            </form>
                        </c:if>
                        
                        <c:if test="${empty sessionScope.user}">
                            <div class="alert alert-warning" role="alert">
                                <i class="bi bi-exclamation-triangle-fill me-2"></i>
                                You need to login to view your account information.
                                <a href="${pageContext.request.contextPath}/login" class="alert-link">Login now</a>.
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/jsp/footer.jsp" />
