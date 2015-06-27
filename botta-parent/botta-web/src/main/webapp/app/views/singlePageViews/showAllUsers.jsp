<!DOCTYPE html>
<html ng-app>
<head>
<script type="text/javascript" src="../../resources/scripts/angular.min.js"></script>
<script type="text/javascript" src="../../resources/controllers/singlePageControllers/testUserAppController.js"></script>

<meta charset="ISO-8859-1">
<title>Shoe All Users</title>


</head>
<body>
<div ng-controller="testUserAppController">
 
 <ul ng-repeat="user in users | orderBy: 'name' ">
      <li>{{user.name}} {{user.firstname}} {{user.birthdate}}</li>
  </ul>
 


</div>
</body>
</html>