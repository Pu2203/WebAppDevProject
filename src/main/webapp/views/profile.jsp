<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<div class="container">
    <h1>Edit Profile</h1>
    <form action="${pageContext.request.contextPath}/profile" method="POST">
        <div class="form-row">
            <label for="username" class="label2">Username:</label>
            <input type="text" id="username" class="input" name="username" value="${sessionScope.user.username}" required>
        </div>

        <div class="form-row">
            <label for="email" class="label2">Email:</label>
            <input type="email" id="email" class="input" name="email" value="${sessionScope.user.email}">
        </div>

        <div class="form-row">
            <label for="phone_number" class="label2">Phone Number:</label>
            <input type="text" id="phone_number" class="input" name="phone_number" value="${sessionScope.user.phoneNumber}">
        </div>

        <div class="form-row">
            <label for="gender" class="label2">Gender:</label>
            <select id="gender" class="input2" name="gender">
                <option value="male" ${sessionScope.user.gender eq 'male' ? 'selected' : ''}>Male</option>
                <option value="female" ${sessionScope.user.gender eq 'female' ? 'selected' : ''}>Female</option>
            </select>
        </div>

        <div class="form-row">
            <label for="name" class="label2">Name:</label>
            <input type="text" id="name" class="input" name="name" value="${sessionScope.user.name}">
        </div>
        
        <div class="form-row">
            <button type="submit" class="button2">Save</button>
        </div>
    </form>
    <a href="${pageContext.request.contextPath}/home" class="buttonBack">Back to Home</a>
</div> 