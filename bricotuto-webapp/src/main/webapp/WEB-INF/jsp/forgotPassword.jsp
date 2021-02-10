<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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

<title>Forgot Password</title>
</head>

<body>
	<div class="header-content">
		<%@ include file="menu.jsp"%>
	</div>
	<div class="main-content">

		<div class="login-form">

			<form:form name='forgotPassword' modelAttribute="user" action="forgotPassword"
				method="post">
				<h2 class="text-center">reset Password</h2>
		
				<div class="form-group row">
				<c:if test="${not empty error}">
					<div>${error}</div>
				</c:if>
					<div class="col-sm-4">
						<form:label path="email">email</form:label>
					</div>
					<div class="col-sm-8">
						<form:input path="email" class="form-control" />
					</div>
				</div>
			
				<div class="form-group">
					<button type="submit" value="" class="btn btn-primary btn-block">
						Reset Password
					</button>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>