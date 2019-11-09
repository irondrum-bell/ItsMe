app.controller("ClassManageCtrl", function($scope, $http, $modal, $window, $location) {

	$(document).ready(function() {
		// 버튼의 이벤트 핸들러를 붙입니다.
		$("#class-dialog").button().on("click", function() {
			// 다이얼로그 내용을 가져올 URL입니다.
			var url = "templates/itsme/classManage/class.html";
			// 다이얼로그를 생성합니다.
			$('<div id="DialogDiv">').dialog({
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
				height : 800,

				width : 900,

				title : '수업추가'
			});
		});
	});
	
	$scope.majorList = [
		{code : "", name : "-소속/학과-"},
		{code : "101", name : "인문예술대학/국어국문학과"},
		{code : "102", name : "인문예술대학/중어중문학과"},
		{code : "103", name : "인문예술대학/유럽문화 관광학과"},
		{code : "104", name : "인문예술대학/한문학과"},
		{code : "105", name : "인문예술대학/민속학과"},
		{code : "106", name : "인문예술대학/동양철학과"},
		{code : "107", name : "인문예술대학/사학과"},
		{code : "108", name : "인문예술대학/의류학과"},
		{code : "109", name : "인문예술대학/음악과"},
		{code : "110", name : "인문예술대학/미술학과"},
		{code : "111", name : "사회과학대학/경제학전공"},
		{code : "112", name : "사회과학대학/무역학전공"},
		{code : "113", name : "사회과학대학/경영학전공"},
		{code : "114", name : "사회과학대학/회계학전공"},
		{code : "115", name : "사회과학대학/법학과"},
		{code : "116", name : "사회과학대학/행정학과"},
		{code : "117", name : "사회과학대학/생활복지학과"},
		{code : "121", name : "사범대학/국어교육과"},
		{code : "122", name : "사범대학/윤리교육과"},
		{code : "123", name : "사범대학/영어교육과"},
		{code : "124", name : "사범대학/교육교육과"},
		{code : "125", name : "사범대학/수학교육과"},
		{code : "126", name : "사범대학/컴퓨터교육과"},
		{code : "127", name : "사범대학/전자공학교육과"},
		{code : "128", name : "사범대학/기계교육과"},
		{code : "131", name : "자연과학대학/물리학과"},
		{code : "132", name : "자연과학대학/응용화학과"},
		{code : "133", name : "자연과학대학/지구환경과학과"},
		{code : "134", name : "자연과학대학/정보통계학과"},
		{code : "135", name : "자연과학대학/체육학과"},
		{code : "141", name : "생명과학대학/생명과학전공"},
		{code : "142", name : "생명과학대학/생명백신공학전공"},
		{code : "143", name : "생명과학대학/원예 생양융합학부"},
		{code : "144", name : "생명과학대학/식품생명공학과"},
		{code : "145", name : "생명과학대학/식품영양학과"},
		{code : "146", name : "생명과학대학/식물의학과"},
		{code : "147", name : "생명과학대학/간호학과"},
		{code : "151", name : "공과대학/응용신소재공학전공"},
		{code : "152", name : "공과대학/금속신소재공학전공"},
		{code : "153", name : "공과대학/멀티미디어공학과"},
		{code : "155", name : "공과대학/기계공학과"},
		{code : "156", name : "공과대학/기계로봇공학과"},
		{code : "157", name : "공과대학/정보통신공학과"},
		{code : "158", name : "공과대학/토목공학과"},
		{code : "159", name : "공과대학/기계자동차공학과"},
		{code : "160", name : "공과대학/전자공학과"},
		{code : "161", name : "공과대학/컴퓨터공학과"},
		{code : "162", name : "공과대학/환경공학과"},
		{code : "163", name : "공과대학/건축공학과"},
		{code : "171", name : "창의융합학부/창의융합학부"}		
	]
	
	$scope.classManage = {
			obj : {
				classList : "",
				selectMajor : $scope.majorList[0],
				searchProName : "",
				searchSubject : "",
				deleteClassSet : new Set()
			},
			func : {
				getClassList : function(){
					
					var param = {
							selectMajor : $scope.classManage.obj.selectMajor['code'],
							searchProName : $scope.classManage.obj.searchProName,
							searchSubject : $scope.classManage.obj.searchSubject
					}
					
					req_http_rest_api.func.req_get_message($http, "/getClassList", param, function(response){
						/*$scope.classManage.obj.searchName = "bbbbb";*/
						if(response.data.code == 500){
							alert(response.data.msg);
						}else{
							$scope.classManage.obj.classList = response.data.value;
						}
						
					}, function(response){
						alert("서버와 연결을 할 수 없습니다.");
					})
				},
				deleteClass : function() {
					if($scope.classManage.obj.deleteClassSet.size == 0) {
						alert("선택된 과목이 업습니다.");
						return;
					} else if(!confirm("선택한 과목들을 삭제하시겠습니까?")) {
						return;
					} else {
						var chk = true;
						
						for (let item of $scope.classManage.obj.deleteClassSet) {
							var param = {
									deleteMajor : item
							}
							
							req_http_rest_api.func.req_post_message($http, "/deleteClass", param, function(response){
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
							$scope.classManage.obj.deleteClassSet.clear();
							alert("과목이 삭제되었습니다.");
							$scope.classManage.func.getClassList();
						}
					}
				},
				checkValue : function(ccode) {
					if(!$scope.classManage.obj.deleteClassSet.has(ccode)) {
						$scope.classManage.obj.deleteClassSet.add(ccode);
					} else {
						$scope.classManage.obj.deleteClassSet.delete(ccode);
					}
					console.log($scope.classManage.obj.deleteClassSet);
				}
			}
	}
	
	$scope.classManage.func.getClassList();
	
	$scope.registerBtn = function(){
		$window.ScopeToShare = "";
		$location.path("/classAddMod").replace();
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
		$window.ScopeToShare = "aaaaa";
		$location.path("/classAddMod").replace();
	}

});
/*function openZipSearch() {
	new daum.Postcode({
		oncomplete : function(data) {
			$('[name=zip]').val(data.zonecode); // 우편번호 (5자리)
			$('[name=addr1]').val(data.address);
			$('[name=addr2]').val(data.buildingName);
		}
	}).open();
}*/

	