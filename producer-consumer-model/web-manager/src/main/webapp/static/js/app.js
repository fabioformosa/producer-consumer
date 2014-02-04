'use strict';
define(['angular', 'controllers/controllers', 'directives/directives', 'restangular', 'smartTable'], 
		function (angular, controllers, directives, restangular, smartTable) {
	        return angular.module('prodconsApp', ['controllers', 'directives', 'restangular', 'smartTable.table'])
	        	.config(function(RestangularProvider) {
	        			RestangularProvider.setBaseUrl('/prodcons');
	        	});
        
});