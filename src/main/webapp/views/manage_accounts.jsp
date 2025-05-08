<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
    <h1>Manage Accounts</h1>
    <table class="tickets-table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Name</th>
                <th>Phone Number</th>
                <th>Balance</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.username}</td>
                <td>${user.name}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.balance}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/admin/manageAccounts" method="POST" style="display:inline;">
                        <input type="hidden" name="user_id" value="${user.id}">
                        <input type="hidden" name="action" value="update_balance">
                        <input type="number" name="amount" class="input" placeholder="Amount" required>
                        <button type="submit" class="button2">Update Balance</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/admin/manageAccounts" method="POST" style="display:inline;">
                        <input type="hidden" name="user_id" value="${user.id}">
                        <input type="hidden" name="action" value="update_password">
                        <input type="password" name="new_password" class="input" placeholder="New Password" required>
                        <button type="submit" class="button2">Update Password</button>
                    </form>
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div> 