<!DOCTYPE html>
<html lang="ko" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<head th:replace="includes/header :: common_header(~{::title},~{::link},~{::script})">
	<title>Sample 인덱스</title>
	<link href="/static/css/plugins/jsTree/style.min.css" rel="stylesheet">
	<script src="/static/js/plugins/jsTree/jstree.min.js"></script>
	<script type="text/javascript" charset="UTF-8">
		$(document).ready(function () {

			$('#divCodes').jstree({
				'core': {
					'data': [
						'Empty Folder',
						{
							'text': 'Resources',
							'state': {
								'opened': true
							},
							'children': [
								{
									'text': 'css',
									'children': [
										{
											'text': 'animate.css', 'icon': 'fa fa-folder'
										},
										{
											'text': 'bootstrap.css', 'icon': 'fa fa-folder'
										},
										{
											'text': 'main.css', 'icon': 'fa fa-folder'
										},
										{
											'text': 'style.css', 'icon': 'fa fa-folder'
										}
									],
									'state': {
										'opened': true
									}
								},
								{
									'text': 'js',
									'children': [
										{
											'text': 'bootstrap.js', 'icon': 'fa fa-folder'
										},
										{
											'text': 'inspinia.min.js', 'icon': 'fa fa-folder'
										},
										{
											'text': 'jquery.min.js', 'icon': 'fa fa-folder'
										},
										{
											'text': 'jsTree.min.js', 'icon': 'fa fa-folder'
										},
										{
											'text': 'custom.min.js', 'icon': 'fa fa-folder'
										}
									],
									'state': {
										'opened': true
									}
								},
								{
									'text': 'html',
									'children': [
										{
											'text': 'layout.html', 'icon': 'fa fa-folder'
										},
										{
											'text': 'navigation.html', 'icon': 'fa fa-folder'
										},
										{
											'text': 'navbar.html', 'icon': 'fa fa-folder'
										},
										{
											'text': 'footer.html', 'icon': 'fa fa-folder'
										},
										{
											'text': 'sidebar.html', 'icon': 'fa fa-folder'
										}
									],
									'state': {
										'opened': true
									}
								}
							]
						},
						'Fonts',
						'Images',
						'Scripts',
						'Templates',
					]
				}
			});
		});

	</script>
</head>
<body>
<div id="wrapper">
	<nav th:substituteby="includes/gnb :: gnb"/>
	<div id="page-wrapper" class="gray-bg">
		<div th:substituteby="includes/util :: util"/>
		<div class="wrapper wrapper-content animated fadeInRight">
			<div class="row">
				<div class="col-lg-6">
					<div class="ibox float-e-margins">
						<div class="ibox-title">
							<h5>Basic example
								<small>with custom Font Awesome icons.</small>
							</h5>
							<div class="ibox-tools">
								<a class="collapse-link">
									<i class="fa fa-chevron-up"></i>
								</a>
								<a class="close-link">
									<i class="fa fa-times"></i>
								</a>
							</div>
						</div>
						<div class="ibox-content">
							<div id="divCodes"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div th:substituteby="includes/footer :: footer"/>
	</div>
</div>
</body>
</html>