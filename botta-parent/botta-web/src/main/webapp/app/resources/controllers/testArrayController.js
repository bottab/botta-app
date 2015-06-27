/**
 * 
 */

angular.module('bottaAppModule', ['ngRoute', 'ngResource']);

angular.module('bottaAppModule').controller('userController', userController);

function userController($scope, userFactory) {
	$scope.status;
	$scope.users;

	//GET
	$scope.getUsers = function () {
		userFactory.getUsers()
	        .success(function (users) {
	            $scope.users = users;
	        })
	        .error(function (error) {
	            $scope.status = 'Unable to load user data: ' + error.message;
	        });
	}

	//PUT
	$scope.updateUser = function (id) {
	    var user;
	    for (var i = 0; i < $scope.users.length; i++) {
	        var currUser = $scope.users[i];
	        if (currUser.ID === id) {
	            user = currUser;
	            break;
	        }
	    }

	    userFactory.updateUser(user)
	      .success(function () {
	          $scope.status = 'Updated user! Refreshing user list.';
	      })
	      .error(function (error) {
	          $scope.status = 'Unable to update user: ' + error.message;
	      });
	};

	//POST
	$scope.createUser = function () {
	    userFactory.createUser(user)
	        .success(function () {
	            $scope.status = 'Inserted user! Refreshing user list.';
	            $scope.users.push(user);
	        }).
	        error(function(error) {
	            $scope.status = 'Unable to insert user: ' + error.message;
	        });
	};

	//DELETE
	$scope.deleteUser = function (id) {
	    userFactory.deleteUser(id)
	    .success(function () {
	        $scope.status = 'Deleted user! Refreshing user list.';
	        for (var i = 0; i < $scope.users.length; i++) {
	            var user = $scope.users[i];
	            if (user.ID === id) {
	                $scope.users.splice(i, 1);
	                break;
	            }
	        }
	    })
	    .error(function (error) {
	        $scope.status = 'Unable to delete user: ' + error.message;
	    });
	};
	}

	/*bottaApp.config(function($routeProvider){
		$routeProvider
		.when('/',
				{
					controller: 'bottaAppController', 
					templateUrl: 'View1.html'
				})
		.otherwise({redirectTo: '/'});
	});*/


	// UserFactory
	angular.module('bottaAppModule').factory('userFactory', ['$http', function($http) {
	var urlBase = 'http://localhost:8081/botta-web/rest/users';
	var userFactory = {};

	userFactory.getUsers = function () {
		return $http.get(urlBase);
	};

	userFactory.getUser = function (id) {
	    return $http.get(urlBase + '/' + id);
	};

	userFactory.createUser = function (user) {
	    return $http.post(urlBase, user);
	};

	userFactory.updateUser = function (user) {
	    return $http.put(urlBase + '/' + user.ID, user)
	};

	userFactory.deleteUser = function (id) {
	    return $http.delete(urlBase + '/' + id);
	};

	return userFactory;
	}]);


