/**
 * 
 */

var mainapp = angular.module('mainapp', ['ngRoute','ngResource']);



mainapp.config(function ($routeProvider){
	$routeProvider
	.when('/crud',
		{
			controller: 'userController',
			templateUrl: 'partials/crud.html'
		})
	.when('/search',
		{
			controller: 'searchController',
			templateUrl: 'partials/search.html'
		})
	.otherwise({ redirectTo: '/'});
});

mainapp.factory('userFactory', ['$resource', function($resource){
	return $resource('/botta-web/rest/users', {}, {
		getUserById: { method: 'GET', params: {id: '@id' } },
        updateUser: { method: 'PUT', params: {userData: '@userData'} },
        deleteUser: { method: 'DELETE', params: {id: '@id'} },
        findAllUsers: { method: 'GET', isArray: true },
        createUser: { method: 'POST', params: {userData: '@userData'} }
	})
}]);

mainapp.controller('userController', ['$scope', 'userFactory', function($scope, userFactory){
	$scope.update = function(){
		userFactory.updateUser($scope.userData);
	}
	$scope.findAllUsers = function(){
		userFactory.findAllUsers();
	}
	$scope.deleteUser = function(){
		userFactory.deleteUser($scope.userData.id);
	}
	$scope.getUserById = function(){
		userFactory.getUserById($scope.userId);
	}
	$scope.createUser = function(){
		userFactory.createUser($scope.userData);
	}
}]);





