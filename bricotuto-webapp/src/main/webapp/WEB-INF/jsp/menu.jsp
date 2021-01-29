<!-- core -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- i18n -->
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- Security -->
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- css perso -->
<link rel="stylesheet" href="/css/style.css">

<!-- Menu -->
<header class="header">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">

		<a class="navbar-brand" href="home"> <img src="images/logo.png"
			width="30" height="30" /> Brico Tuto
		</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarText" aria-controls="navbarText"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarText">
			<!-- left zone -->
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/home"><spring:message
							code="menu.home" /></a> <span class="sr-only">(current)</span></li>
				<li class="nav-item"><a class="nav-link" href="about"><spring:message
							code="menu.about" /></a></li>
				<li class="nav-item"><a class="nav-link" href="member"><spring:message
							code="menu.member" /></a></li>

				<!-- Admin link enable -->
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li class="nav-item"><a class="nav-link" href="admin"><spring:message
								code="menu.admin" /></a></li>
				</sec:authorize>
			</ul>
			<!-- right zone -->
			<ul class="navbar-nav ml-auto">

				<!-- Config log in/log off -->
				<li class="nav-item"><c:choose>
						<c:when test="${pageContext.request.userPrincipal.name != null}">
							<c:url value="/logout" var="logoutUrl" />
							<form id="logout" action="${logoutUrl}" method="post">
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</form>
							<a class="nav-link" href="javascript:document.getElementById('logout').submit()">Logout</a>
						</c:when>
						<c:otherwise>
							<a class="nav-link" href="/login"><spring:message code="menu.login" /></a>
						</c:otherwise>
					</c:choose></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/en/home"><img
						src="/images/iconeUK.png" width="20" height="20" /></a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/fr/home"><img
						src="/images/iconeFR.png" width="20" height="20" /></a></li>
				<li class="nav-item"><a class="nav-link"
					href="${pageContext.request.contextPath}/es/home"><img
						src="/images/iconeES.png" width="20" height="20" /></a></li>
			</ul>
		</div>

	</nav>
</header>






