<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<%@page import="java.util.*" %>
<%@page import="java.text.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<script src="/application/lib/jquery.js"></script>
		<script src="/application/lib/popper.js"></script>
		
		<!-- bootstrap -->
		<link rel="stylesheet" href="/application/lib/bootstrap/css/bootstrap.min.css">
		<script src="/application/lib/bootstrap/js/bootstrap.min.js"></script>
		
		<!-- font-awesome -->
		<link rel="stylesheet" href="/application/lib/font-awesome/css/font-awesome.css">

		<!-- alertifyjs -->
		<script src="/application/lib/alertify/alertify.js"></script>
		<link rel="stylesheet" href="/application/lib/alertify/css/alertify.min.css">
		<link rel="stylesheet" href="/application/lib/alertify/css/themes/default.min.css">

		<!-- bootstrap-datetimepicker -->
		<link rel="stylesheet" href="/application/lib/bootstrap-datepicker/css/bootstrap-datepicker.css" rel="stylesheet">
		<script src="/application/lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	
		<!-- chartjs -->
		<script src="/application/lib/Chart.js/Chart.js"></script>

		<!--  core -->
		<link rel="stylesheet" href="/application/application.css">
		<script src="/application/application.js"></script>
		
		<!-- global -->
		<script type="text/javascript">
		</script>
		<style type="text/css">
		</style>
	</head>
	<script type="text/javascript">
	</script>
	<style type="text/css">
	main {
		padding-top:10px;
	}
	</style>
	<body>

		<!-- start of header -->
		<header>
		
			<!--  start of navigation -->
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<a class="navbar-brand" href="#">
					<img src="/application/img/logo_core.png"/>
			      	&nbsp; &nbsp;
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item">	
							<a class="nav-link" href="/application/monitor/Monitor">
								<img src="/application/img/icon_monitor.png"/>
								Monitor
							</a>
						</li>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<img src="/application/img/icon_user.png"/>
								User
							</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/application/user/User">
									<img src="/application/img/dot_user.png"/>
									User Manage
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#">
									<img src="/application/img/dot_group.png"/>
									Group Manage
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#">
									<img src="/application/img/dot_id_card.png"/>
									Role Manage
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="#">
									<img src="/application/img/dot_barcode.png"/>
									Privilege Manage
								</a>
							</div>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/application/menu/Menu">
								<img src="/application/img/icon_menu.png"/>
								Menu
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/application/code/Code">
								<img src="/application/img/icon_code.png"/>
								Code
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/application/board/Board">
								<img src="/application/img/icon_board.png"/>
								Board
							</a>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
	      				<li class="nav-item">
	      					<a class="nav-link" href="/application/Logout">
	      						<img src="/application/img/icon_power.png"/>
	      						Logout 
	      					</a>
	      				</li>
					</ul>
				</div>
			</nav>
			<!--  ends of navigation -->
			
		</header>
		<!-- end and header -->

		<!-- start of body -->
		<main>
			<div class="container-fluid">
				<tiles:insertAttribute name="body"/>
			</div>
		</main>
		<!-- end of body -->
		
		<!-- start of footer -->
		<footer>
			<p></p>
		</footer>
		<!-- end of footer -->		
	</body>
</html>