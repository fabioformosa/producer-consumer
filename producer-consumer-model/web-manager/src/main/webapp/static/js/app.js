'use strict';
define(['angular', 'controllers/controllers', 'directives/directives', 'restangular'], 
		function (angular, controllers, directives, restangular) {
	        return angular.module('prodconsApp', ['controllers', 'directives', 'restangular'])
	        	.config(function(RestangularProvider) {
	        			RestangularProvider.setBaseUrl('/prodcons');
	        	});
        
});