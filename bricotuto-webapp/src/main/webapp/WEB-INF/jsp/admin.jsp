<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<a href="${pageContext.request.contextPath}/user">JD User</a> | <a href="${pageContext.request.contextPath}/admin">JD Admin</a> | <a href="javascript:document.getElementById('logout').submit()">Logout</a>
	
<h3>Welcome to JournalDEV Tutorials</h3>
<h3>Admin Page</h3>

<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<a href="javascript:document.getElementById('logout').submit()">Logout</a>
</c:if>