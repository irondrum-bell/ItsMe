app.controller("AttenModCtrl",function($scope, $http, $location, $window) {
	
	var parameter = $window.ScopeToShare;
	console.log("등록/수정 parameter : " + parameter);
	
	if(parameter != ""){
		$scope.titleName = "수정";
	}else{
		$scope.titleName = "등록";
	}
	
	$scope.attenList = [
		{code : "", name : "-출석여부-"},
		{code : "0", name : "Y"},
		{code : "1", name : "N"},	
	]


	
	$scope.attendanceMod = {
		obj : {	
			checkIn : "",
			checkOut : "",
			searchAtten : $scope.attenList[0]
		}, 
		func : {
			getAttendanceContent : function(){
				if(parameter == ""){
					return;
				}
				
				var param = {
						searchNum : parameter
				}
				req_http_rest_api.func.req_get_message($http, "/getAttendanceContent", param, function(response){
					if(response.data.code == 500){
						alert(response.data.msg);
					}else{
						$scope.memberAddMod.obj.memberContent = response.data.value;
						console.log(response.data.value);
						$scope.memberAddMod.obj.memberBel = $scope.memberAddMod.obj.memberContent['belcode'];
						$scope.memberAddMod.obj.memberDep = $scope.memberAddMod.obj.memberContent['depcode'];
						$scope.memberAddMod.obj.memberName = $scope.memberAddMod.obj.memberContent['name'];
						$scope.memberAddMod.obj.memberNum = $scope.memberAddMod.obj.memberContent['num'];
						$scope.memberAddMod.obj.memberPw = $scope.memberAddMod.obj.memberContent['pw'];
						$scope.memberAddMod.obj.memberAuthor = $scope.memberAddMod.obj.memberContent['auth'];
						$scope.memberAddMod.obj.memberBirth = $scope.memberAddMod.obj.memberContent['birth'];
						$scope.memberAddMod.obj.memberPhone = $scope.memberAddMod.obj.memberContent['phone'];
						$scope.memberAddMod.obj.memberEmail = $scope.memberAddMod.obj.memberContent['email'];
						$scope.memberAddMod.obj.memberAddr = $scope.memberAddMod.obj.memberContent['address'];
						//사진 수정 필요
					}
				}, function(response){
					alert("서버와 연결을 할 수 없습니다.");
				})
		},
			add : function(){
				var param = $scope.memberAddMod.obj;
				param['memberDep'] = param['searchMajor'].code;
				param['memberBel'] = "0" + parseInt(parseInt(param['memberDep'])/100);
				param['memberAuthor'] = param['searchAuthor'].code;
				
				if(param['memberDep'] == "") {
					alert("소속/학과를 선택하세요.");
					return;
				}
				if(param['memberName'] == "") {
					alert("이름을 입력하세요.");
					return;
				}
				if(param['memberNum'] == "") {
					alert("학번/사번을 입력하세요.");
					return;
				}
				if(param['memberPw'] == "") {
					alert("비밀번호를 입력하세요.");
					return;
				}
				if(param['memberAuthor'] == "") {
					alert("구분을 선택하세요.");
					return;
				}
				if(param['memberBirth'] == "") {
					alert("생일을 입력하세요.");
					return;
				}
				
				var url = "";
				if(parameter == "")
//					url = "/addMember";
					url = "/isMember";
				else
					url = "/updateMember";

				req_http_rest_api.func.req_get_message($http, url, param, function(response){
					if(response.data.code == 500){
						alert(response.data.msg);
						return;
					}else{
						req_http_rest_api.func.req_post_message($http, "/addMember", param, function(response){
						if(response.data.code == 500){
							alert(response.data.msg);
						}else{
							if(parameter == "")
		    					alert('회원 정보가 추가되었습니다.');
							else
		    					alert('회원 정보가 수정되었습니다.');
							$location.path(adminUrl).replace();
	   					}
					}, function(response){
						alert("서버와 연결을 할 수 없습니다.");
					});
					/*$location.path("/memberlist").replace();*/
   					}
				}, function(response){
					alert("서버와 연결을 할 수 없습니다.");
				});
				
			},
			cancel : function(){
				//$location.path("/memberlist").replace();
				$location.path(adminUrl).replace();
			}
		}
	}
	$scope.memberAddMod.func.getMemberContent();
});
