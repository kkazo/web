<!DOCTYPE html>
<html lang="ko" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity4">
<head/>
<body>
<nav class="navbar-default navbar-static-side" role="navigation" th:fragment="gnb">
	<div class="sidebar-collapse">
		<ul class="nav metismenu" id="side-menu">
			<li class="nav-header">
				<div class="dropdown profile-element">
					<a data-toggle="dropdown" class="dropdown-toggle" href="#">
						<span class="clear">
							<span class="block m-t-xs">
								<strong class="font-bold" sec:authentication="name">Kwangyo Cho</strong>
							</span>
							<span class="text-muted text-xs block" sec:authentication="principal.authorities">Art Director <b
								class="caret"></b></span>
						</span>
					</a>
					<ul class="dropdown-menu animated fadeInRight m-t-xs">
						<li><a href="#">Logout</a></li>
					</ul>
				</div>
				<div class="logo-element">
					ADC
				</div>
			</li>
			<li class="active">
				<a href="index.html"><i class="fa fa-th-large"></i> <span class="nav-label">Main view</span></a>
			</li>
			<li>
				<a href="minor.html"><i class="fa fa-th-large"></i> <span class="nav-label">Minor view</span> </a>
			</li>
		</ul>
	</div>
</nav>
</body>
</html>