'use strict';

require.config({
	paths : {
		angular : 'lib/angular.min',
		twitter : 'lib/bootstrap.min',
		jquery : 'lib/jquery',
		jqueryUI : 'lib/jquery-ui-1.9.2.custom.min',
		domReady : 'lib/requirejs/domReady',
		lodash : 'lib/lodash',
		restangular : 'lib/restangular',
		respond : 'lib/respond.min',
	},
	shim : {
		twitter: {
			deps: ['jquery'],
		},
		respond: {
			deps: ['jquery'],
		},
		lodash : {
			exports: 'lodash'
		},
		jqueryUI: {
			deps: ['jquery'],
			exports: 'jqueryUI',
		},
		angular : {
			deps : [ 'jquery', 'twitter' ],
			exports : 'angular',
		},
		restangular:{
			deps : ['angular', 'lodash'],
			exports : 'restangular', 
		},
		enforceDefine: true
	},
	priority: [
	      "angular", "restangular"
	     ]
});

require(['jquery', 'jqueryUI', 'domReady!' ],	
		function ($, domReady) {
				$( "#producerNumber" ).spinner({
					spin : function(event ,ui, scope){
						$("#producerNumber").attr('value', ui.value);
						}
				});
				
				$( "#consumerNumber" ).spinner();
				$( "#prodCycleNumber" ).spinner();
		}
 );

require(['angular','app', 'controllers/LogController'], function (angular, app, LogController) {
	'use strict';
	angular.bootstrap(document, ['myapp']);
	
//	app.directive('ffValidationSpinner',
//		function() {
//			return {
//				restrict: 'A',
//				link: function(scope, element, attrs) {
//					console.log("spinner value changed!");
//					}
//				};
//		});
	
	
	//$("#logControllerDiv").scope.load();
});

//require(['jquery', 'domReady!' ],function($){
//	$("#logControllerDiv").scope.load();
//});
