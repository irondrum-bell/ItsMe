app.controller("MemberListCtrl",function($scope, $http, $modal) {
	$scope.majorList = [
		{code : "", name : ""},
		{code : 0, name : "인문예술대학/국어국문학과"},
		{code : 1, name : "인문예술대학/중어중문학과"},
		{code : 2, name : "인문예술대학/유럽문화 관광학과"},
		{code : 3, name : "인문예술대학/한문학과"},
		{code : 4, name : "인문예술대학/민속학과"},
		{code : 5, name : "인문예술대학/동양철학과"},
		{code : 6, name : "인문예술대학/사학과"},
		{code : 7, name : "인문예술대학/의류학과"},
		{code : 8, name : "인문예술대학/음악과"},
		{code : 9, name : "인문예술대학/미술학과"},
		{code : 10, name : "사회과학대학/경제학전공"},
		{code : 11, name : "사회과학대학/무역학전공"},
		{code : 12, name : "사회과학대학/경영학전공"},
		{code : 13, name : "사회과학대학/회계학전공"},
		{code : 14, name : "사회과학대학/법학과"},
		{code : 15, name : "사회과학대학/행정학과"},
		{code : 16, name : "사회과학대학/생활복지학과"},
		{code : 17, name : "사범대학/국어교육과"},
		{code : 18, name : "사범대학/윤리교육과"},
		{code : 19, name : "사범대학/영어교육과"},
		{code : 20, name : "사범대학/교육교육과"},
		{code : 21, name : "사범대학/수학교육과"},
		{code : 22, name : "사범대학/컴퓨터교육과"},
		{code : 23, name : "사범대학/전자공학교육과"},
		{code : 24, name : "사범대학/기계교육과"},
		{code : 25, name : "자연과학대학/물리학과"},
		{code : 26, name : "자연과학대학/응용화학과"},
		{code : 27, name : "자연과학대학/지구환경과학과"},
		{code : 28, name : "자연과학대학/정보통계학과"},
		{code : 29, name : "자연과학대학/체육학과"},
		{code : 30, name : "생명과학대학/생명과학전공"},
		{code : 31, name : "생명과학대학/생명백신공학전공"},
		{code : 32, name : "생명과학대학/원예 생양융합학부"},
		{code : 33, name : "생명과학대학/식품생명공학과"},
		{code : 34, name : "생명과학대학/식품영양학과"},
		{code : 35, name : "생명과학대학/식물의학과"},
		{code : 36, name : "생명과학대학/간호학과"},
		{code : 37, name : "공과대학/응용신소재공학전공"},
		{code : 38, name : "공과대학/금속신소재공학전공"},
		{code : 39, name : "공과대학/멀티미디어공학과"},
		{code : 40, name : "공과대학/건축공학과"},
		{code : 41, name : "공과대학/기계공학과"},
		{code : 42, name : "공과대학/기계로봇공학과"},
		{code : 43, name : "공과대학/정보통신공학과"},
		{code : 44, name : "공과대학/토목공학과"},
		{code : 45, name : "공과대학/기계자동차공학과"},
		{code : 46, name : "공과대학/전자공학과"},
		{code : 47, name : "공과대학/컴퓨터공학과"},
		{code : 48, name : "공과대학/환경공학과"},
		{code : 49, name : "창의융합학부/창의융합학부"}		
	]
	
	$scope.authorList= [
		
		{code : "", name : ""},
		{code : 0, name : "학생"},
		{code : 1, name : "교수"}
	]
		
		
	
	$scope.memberManage = {
			obj : {
				memberList : "",
				/*selectAuthor : "",*/
				selectAuthor : $scope.authorList[0],
				searchName : "",
				searchNumber : "",
				/*selectMajor : ""*/
				selectMajor : $scope.majorList[0]
				
				
			},
			func : {
				getMemberList : function(){
					
					var param = {
							selectAuthor : $scope.memberManage.obj.selectAuthor.code,
							searchName : $scope.memberManage.obj.searchName,
							searchNumber : $scope.memberManage.obj.searchNumber,
							selectMajor : $scope.memberManage.obj.selectMajor.name
							
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
				}
			}
	}
	
	
	$scope.memberManage.func.getMemberList();
	
	
	
	
	
	/*$(document).ready(function() {
		// 버튼의 이벤트 핸들러를 붙입니다.
		$("#dynamic-dialog").button().on("click", function() {
			// 다이얼로그 내용을 가져올 URL입니다.
			var url = "templates/itsme/memberlist/memberlist.html";
			// 다이얼로그를 생성합니다.
			$('<div id="DialogDiv" ng-controller="memberAddCtrl">').dialog({
				// 커스텀 스타일을 줍니다.
				dialogClass : 'custom-dialog-style',
				// 모달 다이얼로그로 생성합니다.
				modal : true,
				// 다이얼로그 열기 콜백
				open : function() {
						// 모달 오버레이 설정
					$(".ui-widget-overlay").css({
					opacity : 0.5,
					filter : "Alpha(Opacity=50)",
					backgroundColor : "black"
					});
					// 내용을 불러 옵니다.
					$(this).load(url);
				},
				// 닫기 콜백
				close : function(e) {
					$(this).empty();
					$(this).dialog('destroy');
				},
				height : 900,
				width : 1000,
				title : '회원 등록'
			});
		});
	});*/
	
	$scope.registerBtn = function(){
	      var modalInstance = $modal.open({
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
	      });
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
