app.controller("AttenModCtrl",function($scope, $http, $location, $window) {
	
	var parameter = $window.ScopeToShare;
	console.log("등록/수정 parameter : " + parameter);
	
	if(parameter != ""){
		$scope.titleName = "수정";
	}
//	else{
//		$scope.titleName = "등록";
//	}
	
	$scope.attenList = [
		{code : "", name : "-출석여부-"},
		{code : "Y", name : "Y"},
		{code : "N", name : "N"},	
	]

	$scope.attendanceMod = {
		obj : {	
			checkIn : "",
			checkOut : "",
			searchAtten : $scope.attenList[0]
		}, 
		func : {
			getAttendContent : function(){
				if(parameter == ""){
					return;
				}

				var param = {
						searchCcode : parameter[0],
						searchNum : parameter[1],
						searchAtdate : parameter[2]
				}

				req_http_rest_api.func.req_get_message($http, "/getAttendanceContent", param, function(response){
					if(response.data.code == 500){
						alert(response.data.msg);
					}else{
						$scope.attendanceMod.obj.attendContent = response.data.value;
						console.log(response.data.value);
						$scope.attendanceMod.obj.checkIn = $scope.attendanceMod.obj.attendContent['ckin'];
						$scope.attendanceMod.obj.checkOut = $scope.attendanceMod.obj.attendContent['ckout'];
						$scope.attendanceMod.obj.searchAtten = $scope.attendanceMod.obj.attendContent['atpre'];
						
						if($scope.attendanceMod.obj.searchAtten == "Y") {
							$scope.attendanceMod.obj.searchAtten = $scope.attenList[1];
						} else {
							$scope.attendanceMod.obj.searchAtten = $scope.attenList[0];
						}
					}
				}, function(response){
					alert("서버와 연결을 할 수 없습니다.");
				})
			},
			mod : function(){
				var param ={
						searchCcode : parameter[0],
						searchNum : parameter[1],
						searchAtdate : parameter[2],
						ckin : $scope.attendanceMod.obj.checkIn,
						ckout : $scope.attendanceMod.obj.checkOut,
						isAtten : $scope.attendanceMod.obj.searchAtten.code
						
				}
				
				if(param['ckin'] == "") {
					alert("입실 시간을 입력하세요.");
					return;
				}
				if(param['ckout'] == "") {
					alert("퇴실실 시간을 입력하세요.");
					return;
				}
				if(param['isAtten'] == "") {
					alert("출석여부를 선택하세요.");
					return;
				}
				
				req_http_rest_api.func.req_get_message($http, "/updateAttend", param, function(response){
					if(response.data.code == 500){
						alert(response.data.msg);
						return;
					}else{
						alert("출석 정보를 수정하였습니다.");
						$location.path("/attenManage").replace();
   					}
				}, function(response){
					alert("서버와 연결을 할 수 없습니다.");
				});
			},
			cancel : function(){
				$location.path("/attenManage").replace();
			}
		}
	}
	$scope.attendanceMod.func.getAttendContent();
});
