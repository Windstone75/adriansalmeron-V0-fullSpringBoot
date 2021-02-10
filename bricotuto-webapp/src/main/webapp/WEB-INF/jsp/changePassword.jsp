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

<title>Home</title>
</head>

<body>
	<div class="header-content">
		<%@ include file="menu.jsp"%>
	</div>
	<div class="main-content">

		<div class="login-form">

			<form:form name='changePassword' modelAttribute="user" action="changePassword"
				method="post">
				<h2 class="text-center">change passsword</h2>
				
				<div class="form-group row">
					<div class="col-sm-4">
						<form:label path="password">password</form:label>
					</div>
					<div class="col-sm-8">
						<form:password path="password" class="form-control"
							placeholder="Password" />
						<form:errors path="password" cssClass="error" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-4">
						<form:label path="password">Confirm password</form:label>
					</div>
					<div class="col-sm-8">
						<form:password path="matchingPassword" class="form-control"
							placeholder="confirm Password" />
						<span class="error">${errorPasswordMatches}</span>
					</div>
				</div>

				<div class="form-group">
					<button type="submit" value="" class="btn btn-primary btn-block">
						change Password
					</button>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</div>
			</form:form>
		</div>
	</div>
</body>
</html>