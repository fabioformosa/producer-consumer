'use strict';
define(['directives/directives'], function(directives){
	return directives.directive('ngSpinnerCustom', ['$rootScope', function($rootScope) {
		return{
			restrict: 'A',
			link: function (scope, element, attr, ctrl) {

				console.log(element);
				
				$('#' + attr['name']).spinner({
					spin : function(event ,ui){
						scope[attr['ngModel']] = ui.value;
						scope.$apply();
					}
				});
			},
		};
	}]);
});