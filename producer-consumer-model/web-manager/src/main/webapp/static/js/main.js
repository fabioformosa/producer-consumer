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
	
				$("#logLoading").css("display", "none !important");
				
//				$('[name="producerNumber"]').spinner();
//				
//				$('[name="consumerNumber"]').spinner();
//				
//				$('[name="prodCycleNumber"]').spinner();
//				
//				$('[name="producerNumber"]').spinner({
//					spin : function(event ,ui, scope){
//						$('input[name="producerNumber"]').val(ui.value);
//					}
//				});
//				
//				$('[name="consumerNumber"]').spinner({
//					spin : function(event ,ui, scope){
//						$('[name="consumerNumber"]').attr("value",ui.value);
//					}
//				});
//				
//				$('[name="prodCycleNumber"]').spinner({
//					spin : function(event ,ui, scope){
//						$('[name="prodCycleNumber"]').attr("value",ui.value);
//					}
//				});
		}
 );

require(['angular','app', 'controllers/LogController', 'directives/CustomSpinnerDirective'], 
		function (angular, app, LogController, CustomSpinnerDirective) {
	'use strict';
	angular.bootstrap(document, ['prodconsApp']);
	
});