<!DOCTYPE html>
<html data-ng-app="bottaAppModule">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../../resources/scripts/angular.min.js"></script>
<script type="text/javascript" src="../../resources/scripts/angular-route.min.js"></script>
<script type="text/javascript" src="../../resources/scripts/angular-resource.min.js"></script>
<script type="text/javascript" src="../../resources/controllers/singlePageControllers/testArrayController.js"></script>
</head>
<body>
<div data-ng-view=""></div>

<div data-ng-controller="userController">
	<ol>
		<li data-ng-repeat="user in users">{{user.name}}</li>
	</ol>
	<button data-ng-click="getUsers()">GetAllUsers</button>
</div>



</body>
</html>