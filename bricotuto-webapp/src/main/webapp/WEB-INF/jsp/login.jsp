<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- css perso -->
<link rel="stylesheet" href="/css/style.css">

<title>Home</title>
</head>

<body>
	<div class="header-content">
		<%@ include file="menu.jsp"%>
	</div>
	<div class="main-content">

		<!-- Main content body  -->


		<div class="login-form">
			<form name='login' action="<c:url value='/login' />" method='post'>
				<h2 class="text-center">
					<spring:message code="menu.login" />
				</h2>

				<c:if test="${not empty error}">
					<div>${error}</div>
				</c:if>

				<div class="form-group">
					<input type="text" name='email' class="form-control"
						placeholder="<spring:message code="login.email" />"
						required="required">
				</div>
				<div class="form-group">
					<input type="password" name='password' class="form-control"
						placeholder="<spring:message code="login.password" />"
						required="required">
				</div>
				<div class="form-group">
					<button type="submit" value="" class="btn btn-primary btn-block">
						<spring:message code="login.submit" />
					</button>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</div>

				<div class="clearfix">
					<a href="/signup" class="float-left text-center">Create an Account</a>
					 <a href="/forgotPassword" class="float-right text-center">Forgot Password?</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>