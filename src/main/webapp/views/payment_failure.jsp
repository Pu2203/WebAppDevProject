<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="/jsp/logo.jsp"></jsp:include>

<jsp:include page="/jsp/header.jsp">
    <jsp:param name="title" value="Payment Failure" />
</jsp:include>

<section class="py-5 text-center">
    <div class="container">
        <h1 class="text-danger"><i class="bi bi-x-circle"></i> Payment Failed!</h1>
        <p>${requestScope.message}</p>
        <a href="${pageContext.request.contextPath}/home" class="btn btn-primary mt-3">Go to Home</a>
    </div>
</section>

<jsp:include page="/jsp/footer.jsp" />