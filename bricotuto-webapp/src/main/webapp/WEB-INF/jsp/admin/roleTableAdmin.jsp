<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
<link href="../css/admin.css" rel="stylesheet" />

<title>Table Role</title>
</head>

<body>
	<div class="header-content">
		<%@ include file="../menu.jsp"%>
	</div>
	<div class="main-content">
		<!-- Main content body  -->

		<div class="maincontent-left">
			<%@ include file="menuAdmin.jsp"%>
		</div>

		<div class="maincontent-right">

			<div class="breadcrumb ">
				<h2>Table Role</h2>
			</div>

			<!-- Zone table -->
			<div style="overflow-x: auto;">
				<p>
					<input id="myInput" type="text" placeholder="Search..">
				</p>

				<table id="myTable">
					<thead>
						<tr>
							<th data-type="number">roleId <img
								src="/images/iconeSort.png" width="20" height="20" align="right" />
							</th>
							<th data-type="string">name<img src="/images/iconeSort.png"
								width="20" height="20" align="right" /></th>							
							<th data-type="string">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="role" items="${roles}">
							<tr>
								<td>${role.roleId}</td>
								<td>${role.name}</td>								
								<td>update / delete</td> 
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>

		</div>
	</div>

	<div class="footer-content">
		<%@ include file="../footer.jsp"%>
	</div>

	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>







