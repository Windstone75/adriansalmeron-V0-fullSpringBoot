<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<a href="${pageContext.request.contextPath}/user">JD User</a> | <a href="${pageContext.request.contextPath}/admin">JD Admin</a> | <a href="javascript:document.getElementById('logout').submit()">Logout</a>

<h3>Welcome to JournalDEV Tutorials</h3>

<p>
      Hello <b><c:out value="${pageContext.request.remoteUser}"/></b><br>
      Roles: <b><sec:authentication property="principal.authorities" /></b>
    </p>
 <spring:message code="label.title" />
<ul>
   <li>Java 8 tutorial</li>
   <li>Spring tutorial</li>
   <li>Gradle tutorial</li>
   <li>BigData tutorial</li>
</ul>

<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
