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

			<form:form name='signup' modelAttribute="user" action="signup"
				method="post">
				<h2 class="text-center">Sign up</h2>
				<div class="form-group row">
					<div class="col-sm-4">
						<form:label path="firstname">firstname</form:label>
					</div>
					<div class="col-sm-8">
						<form:input path="firstname" class="form-control"
							placeholder="First Name" />
						<form:errors path="firstname" cssClass="error" />
					</div>
				</div>

				<div class="form-group row">
					<div class="col-sm-4">
						<form:label path="lastname">lastname</form:label>
					</div>
					<div class="col-sm-8">
						<form:input path="lastname" class="form-control"
							placeholder="Last Name" />
						<form:errors path="lastname" cssClass="error" />
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-4">
						<form:label path="email">email</form:label>
					</div>
					<div class="col-sm-8">
						<form:input path="email" class="form-control"
							placeholder="exemple@mail.com" />
						<form:errors path="email" cssClass="error" />
					</div>
				</div>
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
						<spring:message code="login.submit" />
					</button>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</div>
			</form:form>



		</div>
	</div>
</body>
</html>