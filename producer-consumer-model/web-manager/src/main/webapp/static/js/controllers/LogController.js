'use strict';
define(['controllers/controllers', 'restangular'], function(controllers, Restangular){
	return controllers.controller('LogController', ['$scope', 'Restangular', function($scope, Restangular){
		
		$scope.loadLogs = function(taskId){
							console.log("Request for task's logs for task id " + taskId);
				
							if(taskId !== undefined)
								$("#logLoading").attr('style', 'display: inline !important');
							
							Restangular.one('logs', taskId).get()
										.then(function(report){
												$scope.logs = report.logs;
												
												if(report.taskStatus != 'COMPLETED')
													setTimeout($scope.loadLogs(taskId),5000);
												else
													$("#logLoading").attr('style', 'display: none !important');
											});
						};
	}]);
});
