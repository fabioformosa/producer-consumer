'use strict';
define(['controllers/controllers', 'restangular'], function(controllers, Restangular){
	return controllers.controller('LogController', ['$scope', 'Restangular', function($scope, Restangular){
		
		$scope.load = function(){
						var logs = Restangular.all('logs');
						$scope.logs = logs.getList();
					};
	}]);
});
