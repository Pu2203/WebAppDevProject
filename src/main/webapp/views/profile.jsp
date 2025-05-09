<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/jsp/header.jsp">
    <jsp:param name="title" value="Profile" />
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
                                <h5>${sessionScope.user.username}</h5>
                                <p class="text-muted mb-1">${sessionScope.user.gender}</p>
                            </div>
                        </div>
                        <div class="list-group">
                            <a href="${pageContext.request.contextPath}/views/profile" class="list-group-item list-group-item-action active">
                                <i class="bi bi-person-circle me-2"></i> Profile
                            </a>
                            <a href="${pageContext.request.contextPath}/views/my-tickets" class="list-group-item list-group-item-action">
                                <i class="bi bi-ticket-perforated me-2"></i> My Tickets
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
                        <h5 class="mb-0"><i class="bi bi-person-vcard me-2"></i> Edit Profile</h5>
                    </div>
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/UpdateProfileServlet" method="post">
                            <input type="hidden" name="action" value="UPDATE_PROFILE">
                            
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="username" class="form-label">Username</label>
                                    <input type="text" class="form-control" id="username" name="username" value="${sessionScope.user.username}" readonly>
                                    <small class="text-muted">Username cannot be changed</small>
                                </div>
                                
                                <div class="col-md-6 mb-3">
                                    <label for="name" class="form-label">Full Name</label>
                                    <input type="text" class="form-control" id="name" name="name" value="${sessionScope.user.name}" required>
                                </div>
                                
                                <div class="col-md-6 mb-3">
                                    <label for="email" class="form-label">Email</label>
                                    <div class="input-group">
                                        <span class="input-group-text"><i class="bi bi-envelope"></i></span>
                                        <input type="email" class="form-control" id="email" name="email" value="${sessionScope.user.email}" required>
                                    </div>
                                </div>
                                
                                <div class="col-md-6 mb-3">
                                    <label for="phone_number" class="form-label">Phone Number</label>
                                    <div class="input-group">
                                        <span class="input-group-text"><i class="bi bi-telephone"></i></span>
                                        <input type="text" class="form-control" id="phone_number" name="phone_number" value="${sessionScope.user.phoneNumber}">
                                    </div>
                                </div>
                                
                                <div class="col-md-6 mb-3">
                                    <label for="gender" class="form-label">Gender</label>
                                    <select class="form-select" id="gender" name="gender">
                                        <option value="male" ${sessionScope.user.gender eq 'male' ? 'selected' : ''}>Male</option>
                                        <option value="female" ${sessionScope.user.gender eq 'female' ? 'selected' : ''}>Female</option>
                                    </select>
                                </div>
                            </div>
                            
                            <div class="d-flex justify-content-between mt-3">
                                <a href="${pageContext.request.contextPath}/home" class="btn btn-outline-secondary">
                                    <i class="bi bi-arrow-left me-2"></i> Back to Home
                                </a>
                                <button type="submit" class="btn btn-primary">
                                    <i class="bi bi-save me-2"></i> Save Changes
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/jsp/footer.jsp" /> 