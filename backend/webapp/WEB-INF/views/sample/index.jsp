<!DOCTYPE html>
<html lang="ko" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<head th:replace="includes/header :: common_header(~{::title},~{::link},~{::script})">
	<title>Sample 인덱스</title>
</head>
<body>
<div id="wrapper">
	<nav th:substituteby="includes/gnb :: gnb" />
	<div id="page-wrapper" class="gray-bg">
		<div th:substituteby="includes/util :: util" />
		<div class="wrapper wrapper-content animated fadeInRight">
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
		<div th:substituteby="includes/footer :: footer" />
	</div>
</div>
</body>
</html>