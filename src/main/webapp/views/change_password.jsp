<%@page import="DAO.DBConnection"%>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/jsp/logo.jsp"></jsp:include>

<jsp:include page="/jsp/header.jsp">
    <jsp:param name="title" value="changePassword" />
    <jsp:param name="page" value="changePassword" />
</jsp:include>

<section class="py-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-5">
                <div class="card shadow-sm">
                    <div class="card-header bg-primary text-white text-center py-3">
                        <h4 class="mb-0"><i class="bi bi-person-circle"></i> Change Password</h4>
                    </div>
                    <div class="card-body p-4">
                        <form action="${pageContext.request.contextPath}/ChangePasswordServlet" method="post">
                            <input type="hidden" name="action" value="LOGIN">
                            
                            <div class="mb-3">
                                <label for="password" class="form-label">Current Password</label>
                                <div class="input-group">
                                    <span class="input-group-text"><i class="bi bi-person"></i></span>
                                    <input type="password" class="form-control" id="currentPass" name="currentPass" required placeholder="Enter current password">
                                </div>
                            </div>
                            
                            <div class="mb-3">
                                <label for="password" class="form-label">New Password</label>
                                <div class="input-group">
                                    <span class="input-group-text"><i class="bi bi-lock"></i></span>
                                    <input type="password" class="form-control" id="newPass" name="newPass" required placeholder="Enter new password">
                                </div>
                            </div>
                            
                            <div class="mb-3">
                                <label for="password" class="form-label">Confirm Password</label>
                                <div class="input-group">
                                    <span class="input-group-text"><i class="bi bi-lock"></i></span>
                                    <input type="password" class="form-control" id="confPass" name="confPass" required placeholder="Confirm password">
                                </div>
                            </div>
                            
                            <div class="mb-3 form-check">
                                <input type="checkbox" class="form-check-input" id="remember" name="remember">
                                <label class="form-check-label" for="remember">Remember me</label>
                            </div>
                            
                            <div class="d-grid gap-2">
                                <button type="submit" class="btn btn-primary py-2">
                                    <i class="bi bi-box-arrow-in-right"></i> Change Password
                                </button>
                            </div>
                        </form>
                                           
                        <c:if test="${not empty requestScope.message}">
                            <div class="alert alert-success mt-3" role="alert">
                                <i class="bi bi-check-circle-fill me-2"></i> ${requestScope.message}
                            </div>
                        </c:if>
                        
                        <c:if test="${not empty requestScope.error}">
                            <div class="alert alert-danger mt-3" role="alert">
                                <i class="bi bi-exclamation-triangle-fill me-2"></i> ${requestScope.error}
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/jsp/footer.jsp" />

