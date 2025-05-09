<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/jsp/header.jsp">
    <jsp:param name="title" value="Register" />
    <jsp:param name="page" value="register" />
</jsp:include>
<section class="py-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8">
                <div class="card shadow-sm">
                    <div class="card-header bg-primary text-white text-center py-3">
                        <h4 class="mb-0"><i class="bi bi-person-plus-fill"></i> Register Account</h4>
                    </div>
                    <div class="card-body p-4">
                        <form action="RegisterServlet" method="post">
                            <input type="hidden" name="action" value="REGISTER">
                            
                            <!-- Personal Information -->
                            <div class="mb-4">
                                <h5 class="border-bottom pb-2 mb-3"><i class="bi bi-person-vcard"></i> Personal Information</h5>
                                <div class="row g-3">
                                    <div class="col-md-6">
                                        <label for="fullname" class="form-label">Full Name</label>
                                        <input type="text" class="form-control" id="fullname" name="Fullname" required>
                                    </div>
                                    
                                    <div class="col-md-6">
                                        <label class="form-label">Gender</label>
                                        <div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="Gender" id="male" value="Male" required>
                                                <label class="form-check-label" for="male">Male</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="Gender" id="female" value="Female" required>
                                                <label class="form-check-label" for="female">Female</label>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-6">
                                        <label for="dob" class="form-label">Date of Birth</label>
                                        <input type="date" class="form-control" id="dob" name="DoB" required>
                                    </div>
                                    
                                    <div class="col-md-6">
                                        <label for="role" class="form-label">Account Type</label>
                                        <select class="form-select" id="role" name="Role" required>
                                            <option value="Student">Student</option>
                                            <option value="Elder">Senior Citizen</option>
                                            <option value="Normal">Regular</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Contact Information -->
                            <div class="mb-4">
                                <h5 class="border-bottom pb-2 mb-3"><i class="bi bi-envelope-at"></i> Contact Information</h5>
                                <div class="row g-3">
                                    <div class="col-md-6">
                                        <label for="email" class="form-label">Email</label>
                                        <div class="input-group">
                                            <span class="input-group-text"><i class="bi bi-envelope"></i></span>
                                            <input type="email" class="form-control" id="email" name="Email" required>
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-6">
                                        <label for="phone" class="form-label">Phone Number</label>
                                        <div class="input-group">
                                            <span class="input-group-text"><i class="bi bi-telephone"></i></span>
                                            <input type="text" class="form-control" id="phone" name="PhoneNum" required>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <!-- Account Information -->
                            <div class="mb-4">
                                <h5 class="border-bottom pb-2 mb-3"><i class="bi bi-shield-lock"></i> Account Information</h5>
                                <div class="row g-3">
                                    <div class="col-md-6">
                                        <label for="username" class="form-label">Username</label>
                                        <div class="input-group">
                                            <span class="input-group-text"><i class="bi bi-person"></i></span>
                                            <input type="text" class="form-control" id="username" name="Username" required>
                                        </div>
                                    </div>
                                    
                                    <div class="col-12"></div>
                                    
                                    <div class="col-md-6">
                                        <label for="password" class="form-label">Password</label>
                                        <div class="input-group">
                                            <span class="input-group-text"><i class="bi bi-lock"></i></span>
                                            <input type="password" class="form-control" id="password" name="Password" required>
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-6">
                                        <label for="confirm-password" class="form-label">Confirm Password</label>
                                        <div class="input-group">
                                            <span class="input-group-text"><i class="bi bi-lock-fill"></i></span>
                                            <input type="password" class="form-control" id="confirm-password" name="ConfirmPassword" required>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="form-check mb-3">
                                <input class="form-check-input" type="checkbox" id="terms" required>
                                <label class="form-check-label" for="terms">
                                    I agree to the <a href="#" class="text-decoration-none">Terms of Service</a> and <a href="#" class="text-decoration-none">Privacy Policy</a>
                                </label>
                            </div>
                            
                            <div class="d-grid gap-2">
                                <button type="submit" class="btn btn-primary py-2">
                                    <i class="bi bi-person-plus"></i> Register
                                </button>
                            </div>
                        </form>
                        
                        <c:if test="${not empty requestScope.error}">
                            <div class="alert alert-danger mt-3" role="alert">
                                <i class="bi bi-exclamation-triangle-fill me-2"></i> ${requestScope.error}
                            </div>
                        </c:if>
                        
                        <div class="text-center mt-3">
                            <p>Already have an account? <a href="${pageContext.request.contextPath}/login" class="text-decoration-none">Login now</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/jsp/footer.jsp" />