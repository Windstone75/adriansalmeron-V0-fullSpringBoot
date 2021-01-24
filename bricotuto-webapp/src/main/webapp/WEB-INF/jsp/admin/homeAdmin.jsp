<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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

<title>Admin - Dashboard</title>
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
			<h1 class="mt-4">Dashboard</h1>
			<div style="text-align: center">
				<img src="/images/underconstruction.png" alt="Info Logo" />
			</div>

		</div>
	</div>

	<div class="footer-content">
		<%@ include file="../footer.jsp"%>
	</div>
</body>
</html>


