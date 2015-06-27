<!DOCTYPE html>
<html ng-app="mainapp">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../resources/scripts/angular.min.js"></script>
<script type="text/javascript" src="../resources/scripts/angular-resource.min.js"></script>
<script type="text/javascript" src="../resources/scripts/angular-route.min.js"></script>
<script type="text/javascript" src="../resources/controllers/mainapp.js"></script>

</head>
<body>
<div>
	<!-- View Placeholder, loads all views defined in the route provider -->
	<ng-view></ng-view>
</div>

<a href="#crud">Benutzer erfassen</a>
<a href="#search">Benutzer suchen</a>






</body>
</html>