app.controller("NoticeAddModCtrl",function($scope, $http, $location, $window) {
	$scope.titleName = "";
	var parameter = $window.ScopeToShare;
	console.log("등록/수정 parameter : " + parameter);
	
	if(parameter != ""){
		$scope.titleName = "수정";
	}else{
		$scope.titleName = "등록";
	}
	
	$scope.noticeAddMod = {
		obj : {
			noticeContent : "",
			searchTitle : "",
			searchMsg : ""
		},
		func : {
			getNoticeContent : function() {
				if(parameter == "") {
					return;
				}
				
				var param = {
						searchPnum : parameter
				}

				req_http_rest_api.func.req_get_message($http, "/getContent", param, function(response){
					if(response.data.code == 500){
						alert(response.data.msg);
					}else{
						$scope.noticeAddMod.obj.noticeContent = response.data.value;
						$scope.noticeAddMod.obj.searchTitle = $scope.noticeAddMod.obj.noticeContent['title'];
						$scope.noticeAddMod.obj.searchMsg = $scope.noticeAddMod.obj.noticeContent['msg'];
					}
				}, function(response){
					alert("서버와 연결을 할 수 없습니다.");
				})
			},
			add : function(){
				var param = {
						insertTitle : $scope.noticeAddMod.obj.searchTitle,
						insertMsg : $scope.noticeAddMod.obj.searchMsg,
						searchPnum : parameter
				}
				
				if(param['insertTitle'] == "") {
					alert("제목을 입력하세요.");
					return;
				}
				if(param['insertMsg'] == "") {
					alert("제목을 입력하세요.");
					return;
				}
				
				var url = "";
				if(parameter == "")
					url = "/addNotice";
				else
					url = "/updateNotice";

				req_http_rest_api.func.req_post_message($http, url, param, function(response){
					if(response.data.code == 500){
						alert(response.data.msg);
					}else{
						if(parameter == "")
	    					alert('공지사항이이 추가되었습니다.');
						else
	    					alert('공지사항이이 수정되었습니다.');
    					$location.path("/noticeManage").replace();
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

	$scope.noticeAddMod.func.getNoticeContent();
});
