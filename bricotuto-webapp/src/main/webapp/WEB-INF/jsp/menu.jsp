<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<!-- css perso -->
<link rel="stylesheet" href="/css/style.css">


<!-- Menu -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="bg-dark">
	<div class="container">
	<nav class="navbar navbar-expand-lg  navbar-dark bg-dark navbar-fixed-top">
		
			<a class="navbar-brand" href="home"> <img src="images/logo.png"
				width="50" height="50" alt="Info Logo" /> Brico Tuto
			</a>

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarText" aria-controls="navbarText"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>


			<div class="collapse navbar-collapse" id="navbarText">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="home"><spring:message
								code="menu.home" /></a> 
								<span class="sr-only">(current)</span> </a></li>
					<li class="nav-item"><a class="nav-link" href="about"><spring:message
								code="menu.about" /></a></li>
					<li class="nav-item"><a class="nav-link" href="member"><spring:message
								code="menu.member" /></a></li>
					<li class="nav-item"><a class="nav-link" href="admin"><spring:message
								code="menu.admin" /></a></li>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="login"><spring:message
								code="menu.login" /></a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/en/home"><img src="images/iconeUK.png"
				width="20" height="20" /></a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/fr/home"><img src="images/iconeFR.png"
				width="20" height="20" /></a></li>
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/es/home"><img src="images/iconeES.png"
				width="20" height="20" /></a></li>
				</ul>
			</div>
		</nav>

	</div>
</div>






