<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="/jsp/logo.jsp"></jsp:include>

<jsp:include page="/jsp/header.jsp">
    <jsp:param name="title" value="My Tickets" />
    <jsp:param name="page" value="tickets" />
</jsp:include>

<section class="py-5">
    <div class="container">
        <div class="row mb-4">
            <div class="col">
                <div class="d-flex justify-content-between align-items-center">
                    <h2><i class="bi bi-people"></i> Manage User</h2>
                    <a href="${pageContext.request.contextPath}/home" class="btn btn-outline-secondary">
                        <i class="bi bi-arrow-left"></i> Back to Home
                    </a>
                </div>
            </div>
        </div>

        <div class="card shadow-sm">
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead class="table-primary">
                            <tr>
                                <th>User</th>
                                <th>Balance</th>
                                <th>Role</th>
                                <th>Tickets count</th>
                                <th>Pass check</th>
                                <th>Delete</th>
                                
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${accountList}" var="account">
                                <tr>
                                    <td><span class="badge bg-primary">${account.id}</span></td>
                                    <td>
                                        ${account.balance}
                                        <span>VND</span>
                                        <form action="${pageContext.request.contextPath}/UpdateBalanceServlet" method="post" class="d-inline">
                                            <input type="hidden" name="accountId" value="${account.id}">
                                            <div class="input-group input-group-sm mt-2">
                                                <input type="number" name="newBalance" class="form-control" placeholder="New Balance" required>
                                                <button type="submit" class="btn btn-success btn-sm">
                                                    <i class="bi bi-check"></i> Update
                                                </button>
                                            </div>

                                        </form>
                                    </td>
                                    <td>${account.role}</td>
                                    <td>${account.ticketCount}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${account.passId == 1}">
                                                <span class="badge bg-warning">Monthly</span>
                                                
                                            </c:when>
                                            <c:when test="${account.passId == 2}">
                                                <span class="badge bg-success">Yearly</span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="badge bg-danger">No Pass</span>
                                            </c:otherwise>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <form action="${pageContext.request.contextPath}/DeleteAccountServlet" method="post" onsubmit="return confirm('Are you sure you want to delete this user?');">
                                            <input type="hidden" name="accountId" value="${account.id}">
                                            
                                            <button type="submit" class="btn btn-danger btn-sm">
                                                <i class="bi bi-trash"></i> Delete
                                            </button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>

                <c:if test="${empty accountList}">
                    <div class="alert alert-info text-center" role="alert">
                        <i class="bi bi-info-circle me-2"></i> <b>Empty Users.</b>
                    </div>
                </c:if>
            </div>
        </div>
        <c:if test="${not empty sessionScope.message}">
            <div class="alert ${sessionScope.message.contains('success') ? 'alert-success' : 'alert-danger'} text-center"
                role="alert">
                ${sessionScope.message}
            </div>
            <c:remove var="message" scope="session" />
        </c:if>


        


    </div>
</section>

<jsp:include page="/jsp/footer.jsp" /> 