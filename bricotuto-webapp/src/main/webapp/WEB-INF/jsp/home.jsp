<!doctype html>
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
<link rel="stylesheet" href="/css/style.css">

<title>Home</title>
</head>

<body>
	<div class="header-content">
		<%@ include file="menu.jsp"%>
	</div>

	<div class="main-content">
	<!-- Main content body  -->
		<div class="container">
			<div class="row mb-4">
				<div class="col">
					<div id="carouselControls" class="carousel slide"
						data-ride="carousel">
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img src="images/carousel/apprenant.jpg" class="d-block w-100"
									alt="Apprenant">
							</div>
							<div class="carousel-item">
								<img src="images/carousel/apprenant2.jpg" class="d-block w-100"
									alt="Apprenante">
							</div>
						</div>
						<a class="carousel-control-prev" href="#carouselControls"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Pr�c�dent</span>
						</a> <a class="carousel-control-next" href="#carouselControls"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="sr-only">Suivant</span>
						</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12 col-lg-4">
					<div class="card mb-4 mb-lg-0">
						<img src="images/home/certificate.png" alt="certificate"
							class="card-img-top">
						<div class="card-body">
							<h5 class="card-title">Devenez dipl�m�</h5>
							<p class="card-text">De z�ro � h�ros, obtenez un dipl�me en
								informatique.</p>
						</div>
					</div>
				</div>
				<div class="col-12 col-lg-4">
					<div class="card mb-4 mb-lg-0">
						<img src="images/home/instruction.png" alt="instructor"
							class="card-img-top">
						<div class="card-body">
							<h5 class="card-title">Formateurs de qualit�s</h5>
							<p class="card-text">Tous nos cours sont r�alis�s par les
								meilleurs informaticiens.</p>
						</div>
					</div>
				</div>
				<div class="col-12 col-lg-4">
					<div class="card mb-4 mb-lg-0">
						<img src="images/home/job.png" alt="job search"
							class="card-img-top">
						<div class="card-body">
							<h5 class="card-title">Un travail graranti</h5>
							<p class="card-text">Nous vous garantissons un emploi �
								l'issue de votre formation.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>

	<div class="footer-content">
		<%@ include file="footer.jsp"%>
	</div>

	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
