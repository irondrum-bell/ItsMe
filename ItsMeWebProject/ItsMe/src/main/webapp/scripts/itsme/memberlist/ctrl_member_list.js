app.controller("MemberListCtrl",function($scope, $http, $location, $window/*, $modal*/) {
	
	$scope.authorList= [
		{code : "", name : "-선택-"},
		{code : "1", name : "관리자"},
		{code : "2", name : "교수"},
		{code : "3", name : "학생"}
	]
	
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
	$scope.memberManage = {
			obj : {
				memberList : "",
// 				selectAuthor : "",
				selectAuthor : $scope.authorList[0],
				searchName : "",
				searchNumber : "",
// 				selectMajor : "",
				selectMajor : $scope.majorList[0],
				memberSet : new Set()
			},
			func : {
				getMemberList : function(){
					
					var param = {
							selectAuthor : $scope.memberManage.obj.selectAuthor['code'],
							searchName : $scope.memberManage.obj.searchName,
							searchNumber : $scope.memberManage.obj.searchNumber,
							selectMajor : $scope.memberManage.obj.selectMajor['code']
					}

					req_http_rest_api.func.req_get_message($http, "/getMemberList", param, function(response){
						/*$scope.memberManage.obj.searchName = ""
						 $scope.memberManage.obj.searchNumber = ""*/
						if(response.data.code == 500){
							alert(response.data.msg);
						}else{
							$scope.memberManage.obj.memberList = response.data.value;
							
						}
						
					}, function(response){
						alert("서버와 연결을 할 수 없습니다.");
					})
				},
				deleteMember : function() {
					if($scope.memberManage.obj.memberSet.size == 0) {
						alert("선택된 회원이 없습니다.");
						return;
					} else if(!confirm("선택한 회원들을 삭제하시겠습니까?")) {
						return;
					} else {
						var chk = true;
						
						for (let item of $scope.memberManage.obj.memberSet) {
							var param = {
									deleteMember : item
							}
							
							req_http_rest_api.func.req_post_message($http, "/deleteMember", param, function(response){
								/*$scope.classManage.obj.searchName = "bbbbb";*/
								if(response.data.code == 500){
									alert(response.data.msg);
								}else{
									chk = true;
								}
							}, function(response){
								alert("서버와 연결을 할 수 없습니다.");
								chk = false;
								return;
							})
						}
						if(chk) {
							$('input:checkbox').removeAttr('checked')
							$scope.memberManage.obj.memberSet.clear();
							alert("회원이 삭제되었습니다.");
							$scope.memberManage.func.getMemberList();
						}
					}
				},
				checkValue : function(num) {
					if(!$scope.memberManage.obj.memberSet.has(num)) {
						$scope.memberManage.obj.memberSet.add(num);
					} else {
						$scope.memberManage.obj.memberSet.delete(num);
					}
					console.log($scope.memberManage.obj.memberSet);
				}
			}
	}
	
	
	$scope.memberManage.func.getMemberList();
	
	
	
	
	
	/*
	 * $(document).ready(function() { // 버튼의 이벤트 핸들러를 붙입니다.
	 * $("#dynamic-dialog").button().on("click", function() { // 다이얼로그 내용을 가져올
	 * URL입니다. var url = "templates/itsme/memberlist/memberlist.html"; // 다이얼로그를
	 * 생성합니다. $('<div id="DialogDiv" ng-controller="memberAddCtrl">').dialog({ //
	 * 커스텀 스타일을 줍니다. dialogClass : 'custom-dialog-style', // 모달 다이얼로그로 생성합니다.
	 * modal : true, // 다이얼로그 열기 콜백 open : function() { // 모달 오버레이 설정
	 * $(".ui-widget-overlay").css({ opacity : 0.5, filter :
	 * "Alpha(Opacity=50)", backgroundColor : "black" }); // 내용을 불러 옵니다.
	 * $(this).load(url); }, // 닫기 콜백 close : function(e) { $(this).empty();
	 * $(this).dialog('destroy'); }, height : 900, width : 1000, title : '회원 등록'
	 * }); }); });
	 */
	
	$scope.registerBtn = function(){
		$window.ScopeToShare = "";
		$location.path("/memberManage").replace();
	      /*var modalInstance = $modal.open({
	         templateUrl : 'templates/itsme/memberlist/memberlist.html',
	         controller: 'memberAddCtrl',
	         size : 'sm'
	         //backdrop: false
	      });
	      
	      modalInstance.result.then(function(data) {
	         if(data == "safety close"){
	            req_common_re_process_list();
	         }
	      }, function(){
	      });*/
	  }
	
	$scope.changeBtn = function(){
		if($scope.memberManage.obj.memberSet.size == 0) {
			alert("선택된 회원이 없습니다.");
			return;
		} else if($scope.memberManage.obj.memberSet.size > 1) {
			alert("한 회원만 선택하세요.");
			return;
		} else if(!confirm("선택한 회원을 수정하시겠습니까?")) {
			return;
		} else {
			console.log($scope.memberManage.obj.memberSet.values().next().value);
			$window.ScopeToShare = $scope.memberManage.obj.memberSet.values().next().value;
			$location.path("/memberManage").replace();
		}
	}
	
	
	
/*	$scope.classNumber = "김정태";
	
	
	$scope.memberManageDlg = {
			func : {
				addMember : function(){
					alert("aaaaaaaaaaa");
				}
			}
	}*/
	
	
	//$("#editConfirm").confirm();
	
/*	function openZipSearch() {
		new daum.Postcode({
			oncomplete : function(data) {
				$('[name=zip]').val(data.zonecode); // 우편번호 (5자리)
				$('[name=addr1]').val(data.address);
				$('[name=addr2]').val(data.buildingName);
			}
		}).open();
	}*/
});
