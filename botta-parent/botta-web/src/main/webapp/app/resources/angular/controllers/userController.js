angular.module('bottaAppModule').controller('userController', userController);

function userController($scope, userFactory) {
	$scope.status;
	$scope.users;
	$scope.user;
	
	$scope.login = function(){
		$scope.authenticatedUser($scope.credentials.username, $scope.credentials.password);
	}

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
	
	//GET
	$scope.authenticatedUser = function (username, password) {
		userFactory.isAuthenticatedUser(username, password)
	        .success(function (user) {
	            $scope.user = user;
	        })
	        .error(function (error) {
	            $scope.status = 'Authentication failure: ' + error.message;
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

	// UserFactory
	angular.module('bottaAppModule').factory('userFactory', ['$http', function($http) {
	var urlBase = 'https://localhost:8443/botta-web/rest/';
	var userFactory = {};

	userFactory.getUsers = function () {
		return $http.get(urlBase + '/users');
	};

	userFactory.getUser = function (id) {
	    return $http.get(urlBase + 'user/' + id);
	};
	
	userFactory.isAuthenticatedUser = function (username, password) {
	    return $http.get(urlBase + 'user/' + username + '/' + password);
	};

	userFactory.createUser = function (user) {
	    return $http.post(urlBase, user);
	};

	userFactory.updateUser = function (user) {
	    return $http.put(urlBase + 'user/' + user.ID, user)
	};

	userFactory.deleteUser = function (id) {
	    return $http.delete(urlBase + 'user/' + id);
	};

	return userFactory;
	}]);