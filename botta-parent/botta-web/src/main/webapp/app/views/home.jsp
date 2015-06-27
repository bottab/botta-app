<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="../resources/css/base.css" type="text/css">
<link rel="stylesheet" href="../resources/css/bootstrap/bootstrap.css"
	type="text/css">
<script type="text/javascript" src="../resources/scripts/angular.min.js"></script>
<script type="text/javascript"
	src="../resources/scripts/angular-route.min.js"></script>
<script type="text/javascript" src="../resources/angular/modules/app.js"></script>
<script type="text/javascript"
	src="../resources/angular/routing/routes.js"></script>
<meta charset="ISO-8859-1">
<title>Base</title>
</head>
<body>
	<div ng-app="bottaAppModule" />
	<div ng-include="'templates/header.html'"></div>

	<div class="wrapper">Navigation</div>
	<div class="wrapper">
		<div class="mainContent">
			Maincontent
			<div ng-cloak class="ng-cloak">
				<!-- View Placeholder, loads all views defined in the route provider -->
				<ng-view></ng-view>
			</div>
		</div>
		<div class="sideBarRight">Side Bar Right</div>
	</div>
	<div class="wrapper">footer</div>


</body>
</html>