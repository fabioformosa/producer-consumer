'use strict';
define(['angular', 'controllers/controllers', 'restangular'], function (angular, controllers, restangular) {
        return angular.module('prodconsApp', ['controllers', 'restangular'])
        	.config(function(RestangularProvider) {
        			RestangularProvider.setBaseUrl('/web-manager');
        	});
        
});