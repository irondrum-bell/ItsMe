app.controller("ClassAddModCtrl",function($scope, $http, $location, $window) {
	
	var parameter = $window.ScopeToShare;
	console.log("등록/수정 parameter : " + parameter);
	
	$scope.majorList = [
		{code : "", name : "-소속/학과-"},
		{code : "101", name : "인문예술대학/국어국문학과"},
		{code : "102", name : "인문예술대학/중어중문학과"},
		{code : "103", name : "인문예술대학/한문학과"},
		{code : "111", name : "인문예술대학/유럽문화 관광학과"},
		{code : "112", name : "인문예술대학/민속학과"},
		{code : "113", name : "인문예술대학/동양철학과"},
		{code : "114", name : "인문예술대학/사학과"},
		{code : "121", name : "인문예술대학/의류학과"},
		{code : "131", name : "인문예술대학/음악과"},
		{code : "132", name : "인문예술대학/미술학과"},
		{code : "201", name : "사회과학대학/경제학전공"},
		{code : "202", name : "사회과학대학/무역학전공"},
		{code : "211", name : "사회과학대학/경영학전공"},
		{code : "212", name : "사회과학대학/회계학전공"},
		{code : "221", name : "사회과학대학/법학과"},
		{code : "222", name : "사회과학대학/행정학과"},
		{code : "231", name : "사회과학대학/생활복지학과"},
		{code : "301", name : "사범대학/국어교육과"},
		{code : "302", name : "사범대학/윤리교육과"},
		{code : "303", name : "사범대학/영어교육과"},
		{code : "304", name : "사범대학/교육교육과"},
		{code : "305", name : "사범대학/수학교육과"},
		{code : "306", name : "사범대학/컴퓨터교육과"},
		{code : "307", name : "사범대학/전자공학교육과"},
		{code : "308", name : "사범대학/기계교육과"},
		{code : "401", name : "자연과학대학/물리학과"},
		{code : "411", name : "자연과학대학/응용화학과"},
		{code : "421", name : "자연과학대학/지구환경과학과"},
		{code : "431", name : "자연과학대학/정보통계학과"},
		{code : "441", name : "자연과학대학/체육학과"},
		{code : "501", name : "생명과학대학/생명과학전공"},
		{code : "502", name : "생명과학대학/생명백신공학전공"},
		{code : "511", name : "생명과학대학/원예 생양융합학부"},
		{code : "521", name : "생명과학대학/식품생명공학과"},
		{code : "522", name : "생명과학대학/식품영양학과"},
		{code : "531", name : "생명과학대학/식물의학과"},
		{code : "541", name : "생명과학대학/간호학과"},
		{code : "601", name : "공과대학/응용신소재공학전공"},
		{code : "602", name : "공과대학/금속신소재공학전공"},
		{code : "611", name : "공과대학/컴퓨터공학과"},
		{code : "612", name : "공과대학/정보통신공학과"},
		{code : "613", name : "공과대학/멀티미디어공학과"},
		{code : "621", name : "공과대학/기계공학과"},
		{code : "622", name : "공과대학/기계자동차공학과"},
		{code : "623", name : "공과대학/기계로봇공학과"},
		{code : "631", name : "공과대학/토목공학과"},
		{code : "632", name : "공과대학/건축공학과"},
		{code : "641", name : "공과대학/전자공학과"},
		{code : "651", name : "공과대학/환경공학과"},
		{code : "701", name : "창의융합학부/창의융합학부"}		
	]
	
	$scope.classAddMod = {
			obj : {
				searchMajor : $scope.majorList[0],
				classDep : "",
				classCName : "",
				classCCode : "",
				classProf : "",
				classScore : "",
				classCTime : "",
				classRCode : ""
			},
			func : {
				getClassContent : function() {
					if(parameter == "") {
						return;
					}
					
					var param = {
							classCCode : parameter
					}

					req_http_rest_api.func.req_get_message($http, "/getClassContent", param, function(response){
						if(response.data.code == 500){
							alert(response.data.msg);
						}else{
							$scope.classAddMod.obj.classContent = response.data.value;
							$scope.classAddMod.obj.classDep = $scope.classAddMod.obj.classContent['depcode'];
							$scope.classAddMod.obj.classCName = $scope.classAddMod.obj.classContent['cname'];
							$scope.classAddMod.obj.classCCode = $scope.classAddMod.obj.classContent['ccode'];
							$scope.classAddMod.obj.classProf = $scope.classAddMod.obj.classContent['prof'];
							$scope.classAddMod.obj.classScore = $scope.classAddMod.obj.classContent['scr'];
							$scope.classAddMod.obj.classCTime = $scope.classAddMod.obj.classContent['ctime'];
							$scope.classAddMod.obj.classRCode = $scope.classAddMod.obj.classContent['lrcode'];
							
							for (var i = 0; i < $scope.majorList.length; i++) {
								if($scope.majorList[i].code == $scope.classAddMod.obj.classDep) {
									$scope.classAddMod.obj.searchMajor = $scope.majorList[i]
									break;
								}
							}
						}
					}, function(response){
						alert("서버와 연결을 할 수 없습니다.");
					})
				},
				add : function(){
					var param = $scope.classAddMod.obj;
					param['classDep'] = param['searchMajor'].code;
					
					if(param['classDep'] == "") {
						alert("소속/학과를 선택하세요.");
						return;
					}
					if(param['classCName'] == "") {
						alert("강의명을 입력하세요.");
						return;
					}
					if(param['classCCode'] == "") {
						alert("강의코드를 입력하세요.");
						return;
					}
					if(param['classProf'] == "") {
						alert("담당 교수를 입력하세요.");
						return;
					}
					if(param['classScore'] == "") {
						alert("학점을 입력하세요.");
						return;
					}
					if(param['classCTiem'] == "") {
						alert("강의 시간을 선택하세요.");
						return;
					}
					if(param['classRCode'] == "") {
						alert("강의실을 입력하세요.");
						return;
					}

					var url = "";
					if(parameter == "")
						url = "/addClass";
					else
						url = "/updateClass";

					req_http_rest_api.func.req_get_message($http, "/getClassContent", param, function(response){
						if(response.data.code == 500 && parameter == ""){
							req_http_rest_api.func.req_post_message($http, url, param, function(response){
								if(response.data.code == 500){
									alert(response.data.msg);
								}else{
			    					alert('강의 정보가 추가되었습니다.');
									$location.path(etcUrl).replace();
			   					}
							}, function(response){
								alert("서버와 연결을 할 수 없습니다.");
							});
						} else if(response.data.code == 200 && parameter != "") {
							req_http_rest_api.func.req_post_message($http, url, param, function(response){
								if(response.data.code == 500){
									alert(response.data.msg);
								}else{
			    					alert('강의 정보가 수정되었습니다.');
									$location.path(etcUrl).replace();
			   					}
							}, function(response){
								alert("서버와 연결을 할 수 없습니다.");
							});
	   					} else {
	   						alert("중복된 강의 코드가 존재합니다.");
	   					}
					}, function(response){
						alert("서버와 연결을 할 수 없습니다.");
					});
				},
				cancel : function(){
					$location.path(etcUrl).replace();
				}
			}
	}

	$scope.classAddMod.func.getClassContent();
});
