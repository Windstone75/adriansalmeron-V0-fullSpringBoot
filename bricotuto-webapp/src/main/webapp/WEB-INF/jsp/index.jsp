<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">
<head>
<link href="/css/style.css" rel="stylesheet" />
<title>Accueil</title>
<!-- metas, link and scripts -->
</head>
<body>


		<h2>Bienvenu ${name}!</h2>
		
		<a href="/login"> login page </a> 
		
		 <c:if test="${ !empty sessionScope.login }">
        <p>Vous êtes ${ sessionScope.login } !</p>
    	</c:if>
    	 <c:if test="${ !empty userForm.login }"><p><c:out value="${ resultat}" /></p></c:if>
</body>
</html>