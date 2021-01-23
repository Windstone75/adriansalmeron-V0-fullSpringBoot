<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
<head>

<meta charset="UTF-8">

<title><spring:message code="login.title" /></title>
</head>
<body>
<%@ include file="menu.jsp" %>

	<c:if test="${not empty error}">
		<div>${error}</div>
	</c:if>
	<c:if test="${not empty message}">
		<div>${message}</div>
	</c:if>

	<form name='login' action="<c:url value='/login' />" method='post'>
		<table>
			<tr>
				<td>
					<strong> 
					<spring:message code="login.userName" />
					</strong>
				</td>
				<td>
					<input type='text' name='username' value=''>
				</td>
			</tr>
			<tr>
				<td>
					<strong> 
					<spring:message code="login.password" />
					</strong>
				</td>
				<td>
					<input type='password' name='password' />
				</td>
			</tr>
			<tr>
				<td colspan="2">
				<spring:message code="login.submit"	var="labelSubmit"></spring:message> 
				<input name="submit" type="submit" value="${labelSubmit}" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}"	value="${_csrf.token}" />
	</form>
</body>
</html>