angular.module('bottaAppModule').config(function($routeProvider){
		$routeProvider
		.when('/',
				{
					controller: 'homeController', 
					templateUrl: '../../views/home.jsp'
				})
		.when('/login',
				{
					controller: 'userController', 
					templateUrl: '../../login/login.jsp'
				})
		.otherwise('/');
	});