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
	
<!-- **************CSS & JS**************** -->
<!-- jQuery JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<!-- Bootstrap JS -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<!-- css perso -->
<link href="../css/admin.css" rel="stylesheet" />
<!-- JS perso -->
<script src="../js/table.js"></script>

<title>Table User</title>
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
				<h2>Table User</h2>
			</div>

			<!-- Zone table -->
			<div style="overflow-x: auto;">
				<p>
					<input id="myInput" type="text" placeholder="Search..">
				</p>

				<table id="myTable">
					<thead>
						<tr>
							<th data-type="number">userId <img
								src="/images/iconeSort.png" width="20" height="20" align="right" />
							</th>
							<th data-type="string">firstname<img
								src="/images/iconeSort.png" width="20" height="20" align="right" /></th>
							<th data-type="string">lastname<img
								src="/images/iconeSort.png" width="20" height="20" align="right" /></th>
							<th data-type="string">email<img src="/images/iconeSort.png"
								width="20" height="20" align="right" /></th>
							<th data-type="boolean">enabled<img
								src="/images/iconeSort.png" width="20" height="20" align="right" /></th>
							<th data-type="string">inscriptionDt<img
								src="/images/iconeSort.png" width="20" height="20" align="right" /></th>
							<th data-type="string">updateDt <img
								src="/images/iconeSort.png" width="20" height="20" align="right" />
							</th>
							<th data-type="string">Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${users}">
							<tr>
								<td>${user.userId}</td>
								<td>${user.firstname}</td>
								<td>${user.lastname}</td>
								<td>${user.email}</td>
								<td>${user.enabled}</td>
								<td>${user.inscriptionDt}</td>
								<td>${user.updateDt}</td>
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

</body>
</html>







