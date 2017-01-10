<head th:fragment="common_header(title,links,script)">
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<title th:replace="${title}">Adcapsule Backend Sample</title>
	<!-- React -->
	<script src="https://fb.me/react-15.0.2.min.js"></script>
	<script src="https://fb.me/react-dom-15.0.2.min.js"></script>

	<!-- Bootstrap -->
	<link href="/static/font-awesome/css/font-awesome.css" rel="stylesheet" />
	<link href="/static/css/bootstrap.min.css" rel="stylesheet" />
	<link href="/static/css/animate.css" rel="stylesheet" />
	<link href="/static/css/style.css" rel="stylesheet" />
	<link href="/static/css/awesome-bootstrap-checkbox.css" rel="stylesheet" />
	<link href="/static/plugins/sweetalter/sweetalert.css" rel="stylesheet" />

	<th:block th:replace="${links} ?: ~{}" />

	<!-- javascript area -->
	<script type="text/javascript" src="/static/js/jquery-2.1.1.js"></script>
	<script type="text/javascript" src="/static/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/static/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script type="text/javascript" src="/static/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

	<!-- Custom and plugin javascript -->
	<script type="text/javascript" src="/static/js/inspinia.js"></script>
	<script type="text/javascript" src="/static/js/plugins/pace/pace.min.js"></script>
	<script type="text/javascript" src="/static/js/plugins/lodash.4.13.1.js"></script>

	<script type="text/javascript" src="/static/js/plugins/validate/jquery.validate.js"></script>
	<script type="text/javascript" src="/static/js/plugins/validate/localization/messages_ko.js"></script>

	<script type="text/javascript" src="/static/plugins/sweetalter/sweetalert.min.js"></script>

	<th:block th:replace="${script} ?: ~{}" />
</head>
