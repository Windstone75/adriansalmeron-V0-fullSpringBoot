<!DOCTYPE html>
<html lang="en">
<head>

<title>Accueil</title>
<!-- metas, link and scripts -->
</head>
<body>
	<div class="container">

		<h2>Bienvenu ${name}!</h2>

		<h3>Connexion :</h3>
		<form method="post" action="login">
			<p>
				<label for="login">login : </label> <input type="text" name="login"
					id="login" />
			</p>

			<p>
				<label for="pass">Mot de passe : </label> <input type="password"
					name="pass" id="pass" />
			</p>
			<input type="submit" />
		</form>



	</div>
</body>
</html>