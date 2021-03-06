<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>BackOffice | Login</title>

	<link href="/static/css/bootstrap.min.css" rel="stylesheet">
	<link href="/static/font-awesome/css/font-awesome.css" rel="stylesheet">

	<link href="/static/css/animate.css" rel="stylesheet">
	<link href="/static/css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen animated fadeInDown">
	<div>
		<div>
			<h1 class="logo-name">ADC</h1>
		</div>
		<h3>Welcome to Adc BackOffice</h3>

		<p>
		</p>

		<p>Login in. To see it in action.</p>

		<form class="m-t" role="form" th:action="@{/login}" method="post">
			<div class="form-group">
				<input type="text" name="username" class="form-control" placeholder="Username" required="true">
			</div>
			<div class="form-group">
				<input type="password" name="password" class="form-control" placeholder="Password" required="true">
			</div>
			<button type="submit" class="btn btn-primary block full-width m-b">Login</button>

			<a href="#">
				<small>Forgot password?</small>
			</a>

			<p class="text-muted text-center">
				<small>Do not have an account?</small>
			</p>
			<a class="btn btn-sm btn-white btn-block" href="register.html">Create an account</a>
		</form>
		<p class="m-t">
			<small>Inspinia we app framework base on Bootstrap 3 &copy; 2014</small>
		</p>
	</div>
</div>

<!-- Mainly scripts -->
<script src="/static/js/jquery-2.1.1.js"></script>
<script src="/static/js/bootstrap.min.js"></script>

</body>

</html>
