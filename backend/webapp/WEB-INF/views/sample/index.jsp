<!DOCTYPE html>
<html lang="ko" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<title>제목</title>

	<!-- React -->
	<script src="https://fb.me/react-15.0.2.min.js"></script>
	<script src="https://fb.me/react-dom-15.0.2.min.js"></script>

	<!-- Bootstrap -->
	<link href="/static/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link href="/static/css/bootstrap.min.css" rel="stylesheet" />
	<link href="/static/css/animate.css" rel="stylesheet" />
	<link href="/static/css/style.css" rel="stylesheet" />

	<!-- javascript area -->
	<script type="text/javascript" src="/static/js/jquery-2.1.1.js"></script>
	<script type="text/javascript" src="/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script type="text/javascript" src="/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- Custom and plugin javascript -->
	<script type="text/javascript" src="/static/js/inspinia.js"></script>
	<script type="text/javascript" src="/static/js/plugins/pace/pace.min.js"></script>
</head>
<body>
	<div id="wrapper">
		<nav th:substituteby="includes/gnb :: gnb" />
		<div id="page-wrapper" class="gray-bg">
			<div th:substituteby="includes/head :: head" />

			<div class="wrapper wrapper-content animated fadeInRight">
				멍멍

				Logged user: <span sec:authentication="name">Bob</span>,
				Roles: <span sec:authentication="principal.authorities">[ROLE_USER, ROLE_ADMIN]</span>
				<table>
					<tbody>
					<tr th:each="data: ${result}">
						<td th:text="${data.subject}">Oranges</td>
						<td th:text="${data.sampleId}">0.99</td>
					</tr>
					</tbody>
				</table>
			</div>

			<div class="footer">
				<div class="pull-right">

				</div>
				<div>
					<strong>Copyright</strong> 2015 adcapsule technical group
				</div>
			</div>
		</div>
	</div>
</body>
</html>