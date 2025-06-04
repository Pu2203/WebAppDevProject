<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<jsp:include page="/jsp/logo.jsp"></jsp:include>

<jsp:include page="/jsp/header.jsp">
    <jsp:param name="title" value="Payment Success" />
</jsp:include>

<section class="py-5 text-center">
    <div class="container">
        <h1 class="text-success"><i class="bi bi-check-circle"></i> Payment Successful!</h1>
        <p>${sessionScope.message}</p>
        <a href="${pageContext.request.contextPath}/home" class="btn btn-primary mt-3">Go to Home</a>
    </div>
</section>
<script>
    if (performance.navigation.type === 1) {
        window.location.href = "${pageContext.request.contextPath}/CartServlet";
    }
</script>
<jsp:include page="/jsp/footer.jsp" />