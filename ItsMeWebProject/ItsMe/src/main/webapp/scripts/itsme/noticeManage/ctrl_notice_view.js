app.controller("NoticeViewCtrl",function($scope, $http, $location, $window) {
	$scope.titleName = "";
	var parameter = $window.ScopeToShare;
	console.log("보기 parameter : " + parameter);
	
	$scope.noticeView = {
		obj : {
			noticeView : "",
			searchTitle : "",
			searchMsg : "",
			searchDate : "",
			searchWrt : ""
		},
		func : {
			getNoticeView : function() {
				if(parameter == "") {
					return;
				}
				
				var param = {
						searchPnum : parameter
				}

				req_http_rest_api.func.req_get_message($http, "/getView", param, function(response){
					if(response.data.code == 500){
						alert(response.data.msg);
					}else{
						$scope.noticeView.obj.noticeView = response.data.value;
						$scope.noticeView.obj.searchTitle = $scope.noticeView.obj.noticeView['title'];
						$scope.noticeView.obj.searchDate = $scope.noticeView.obj.noticeView['wdate'];
						$scope.noticeView.obj.searchWrt = $scope.noticeView.obj.noticeView['wrt'];
						$scope.noticeView.obj.searchMsg = $scope.noticeView.obj.noticeView['msg'];
					}
				}, function(response){
					alert("서버와 연결을 할 수 없습니다.");
				})
			},
			cancel : function(){
				$location.path("/noticeManage").replace();
			}
		}
	}

	$scope.noticeView.func.getNoticeView();
});
