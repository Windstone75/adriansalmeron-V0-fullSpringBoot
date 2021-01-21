<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Access Denied</title>
</head>

<body>
	<c:if test="${message != null}" var="variable">
		<h3 style="color: red;">
			<c:out value="${ message }">Valeur par défaut</c:out>
		</h3>
	</c:if>

	<c:if test="${userInfo != null}" var="variable">
		<c:out value="${ userInfo }">Valeur par défaut</c:out>
	</c:if>

</body>

</html>