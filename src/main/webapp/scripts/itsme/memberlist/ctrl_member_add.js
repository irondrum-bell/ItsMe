app.controller("MemberManageCtrl",function($scope, $http, $location, $window) {
	
	var parameter = $window.ScopeToShare;
	console.log("등록/수정 parameter : " + parameter);
	
	$scope.add = function(){
		$location.path("/memberlist").replace();
	}
	
	$scope.cancel = function(){
		$location.path("/memberlist").replace();
	}
});
