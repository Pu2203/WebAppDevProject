<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/jsp/header.jsp">
    <jsp:param name="title" value="Payment Confirmation" />
</jsp:include>

<section class="py-5">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-6">
                <div class="card shadow-sm">
                    <div class="card-header bg-primary text-white">
                        <h4 class="mb-0"><i class="bi bi-credit-card"></i> Payment Confirmation</h4>
                    </div>
                    <div class="card-body">
                        <p><strong>Type of Bus Pass:</strong> ${param.type}</p>
                        <p><strong>Price:</strong> VND ${param.price}</p>
                        <p><strong>Expiration Date:</strong> 
                            <c:choose>
                                <c:when test="${param.type == 'Monthly'}">
                                    This pass will expire in 1 month from the date of purchase.
                                </c:when>
                                <c:when test="${param.type == 'Annually'}">
                                    This pass will expire in 1 year from the date of purchase.
                                </c:when>
                                <c:otherwise>
                                    Invalid bus pass type.
                                </c:otherwise>
                            </c:choose>
                        </p>
                        <form action="${pageContext.request.contextPath}/PaymentServlet" method="post">
                            <input type="hidden" name="type" value="${param.type}" />
                            <input type="hidden" name="price" value="${param.price}" />
                            <button type="submit" class="btn btn-success w-100">
                                <i class="bi bi-cash"></i> Make Payment
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/jsp/footer.jsp" />