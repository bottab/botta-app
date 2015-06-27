<html data-ng-app="bottaAppModule">
<head>
<link rel="stylesheet" href="../resources/css/base.css" type="text/css">
<link rel="stylesheet" href="../resources/css/bootstrap/bootstrap.css"
	type="text/css">
	<script type="text/javascript" src="../resources/scripts/angular.min.js"></script>
	<script type="text/javascript" src="../resources/scripts/angular-route.min.js"></script>
	<script type="text/javascript" src="../resources/scripts/angular-resource.min.js"></script>
	<script type="text/javascript" src="../resources/angular/modules/app.js"></script>
	<script type="text/javascript" src="../resources/angular/routing/routes.js"></script>
	<script type="text/javascript" src="../resources/angular/controllers/userController.js"></script>
</head>
<body>
	<!-- <div data-ng-include="'../views/templates/header.html'"></div> -->
	<div class="alert alert-danger" data-ng-show="error">{{status}}</div>
	<form role="form" data-ng-submit="login()" data-ng-controller="userController">
		<div class="form-group">
			<label for="username">Username:</label> <input type="text"
				class="form-control" id="username" name="username"
				data-ng-model="credentials.username" />
		</div>
		<div class="form-group">
			<label for="password">Password:</label> <input type="password"
				class="form-control" id="password" name="password"
				data-ng-model="credentials.password" />
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>


</body>
</html>

