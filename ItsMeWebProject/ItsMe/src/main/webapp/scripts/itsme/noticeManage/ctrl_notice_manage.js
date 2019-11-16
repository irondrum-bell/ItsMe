app.controller("NoticeManageCtrl", function($scope, $http, $window, $location) {
//	$(document).ready(function() {
//		// 버튼의 이벤트 핸들러를 붙입니다.
//		$("#notice-dialog").button().on("click", function() {
//			// 다이얼로그 내용을 가져올 URL입니다.
//			var url = "templates/itsme/noticeManage/noticeaddmod.html";
//			// 다이얼로그를 생성합니다.
//			$('<div id="DialogDiv">').dialog({
//				// 커스텀 스타일을 줍니다.
//				dialogClass : 'custom-dialog-style',
//				// 모달 다이얼로그로 생성합니다.
//				modal : true,
//				// 다이얼로그 열기 콜백
//				open : function() {
//					// 모달 오버레이 설정
//					$(".ui-widget-overlay").css({
//						opacity : 0.5,
//						filter : "Alpha(Opacity=50)",
//						backgroundColor : "black"
//					});
//					// 내용을 불러 옵니다.
//					$(this).load(url);
//				},
//				// 닫기 콜백
//				close : function(e) {
//					$(this).empty();
//					$(this).dialog('destroy');
//				},
//				height : 700,
//
//				width : 600,
//
//				title : '공지사항 추가'
//			});
//		});
//	});
/*여기서부터*/
	$.datepicker.setDefaults({
		dateFormat : 'yy.mm.dd',
		prevText : '이전 달',
		nextText : '다음 달',
		monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월',
				'10월', '11월', '12월' ],
		monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
				'9월', '10월', '11월', '12월' ],
		dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
		showMonthAfterYear : true,
		yearSuffix : '년'
	});

	$(function() {
		$("#datepicker1, #datepicker2").datepicker();
	});
/*여기까지 데이트피커*/
	$scope.noticeManage = {
			obj : {
				noticeList : "",
				searchDate1 : "",
				searchDate2 : "",
				searchTitle : "",
				searchWriter : "",
				noticeSet : new Set(),
				noticeView : ""
			},
			func : {
				getNoticeList : function(){
					$scope.noticeManage.func.chkDateParam($("#datepicker1").datepicker().val(), 
							$("#datepicker2").datepicker().val());
					
					var param = {
							searchDate1 : $scope.noticeManage.obj.searchDate1,
							searchDate2 : $scope.noticeManage.obj.searchDate2,
							searchTitle : $scope.noticeManage.obj.searchTitle,
							searchWriter : $scope.noticeManage.obj.searchWriter	
					}
					
					/*req_http_rest_api.func.req_get_message($http, "/getView", param, function(response){
						$scope.noticeManage.obj.searchName = "bbbbb";
						if(response.data.code == 500){
							alert(response.data.msg);
						}else{
							$scope.noticeManage.obj.noticeList = response.data.value;
						}
						
					},*/
					req_http_rest_api.func.req_get_message($http, "/getNotice", param, function(response){
						/*$scope.noticeManage.obj.searchName = "bbbbb";*/
						if(response.data.code == 500){
							alert(response.data.msg);
						}else{
							$scope.noticeManage.obj.noticeList = response.data.value;
						}
						
					}, function(response){
						alert("서버와 연결을 할 수 없습니다.");
					})
				},
				chkDateParam : function(date1, date2){
					if(date1 != "" && date2 == "") {
						var date = new Date().toISOString();
						$scope.noticeManage.obj.searchDate1 = date1;
						$scope.noticeManage.obj.searchDate2 = date.slice(0,4) + "." + date.slice(5,7) + "." + date.slice(8,10);
					} else if(date1 == "" && date2 != "") {
						$scope.noticeManage.obj.searchDate1 = "1999.99.99";
						$scope.noticeManage.obj.searchDate2 = date2;
					} else {
						$scope.noticeManage.obj.searchDate1 = date1;
						$scope.noticeManage.obj.searchDate2 = date2;
					}
				},
				deleteNotice : function() {
					if($scope.noticeManage.obj.noticeSet.size == 0) {
						alert("선택된 공지사항이 없습니다.");
						return;
					} else if(!confirm("선택한 공지사항들을 삭제하시겠습니까?")) {
						return;
					} else {
						var chk = true;
						
						for (let item of $scope.noticeManage.obj.noticeSet) {
							var param = {
									deleteNotice : item
							}
							
							req_http_rest_api.func.req_post_message($http, "/deleteNotice", param, function(response){
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
							$scope.noticeManage.obj.noticeSet.clear();
							alert("공지사항이 삭제되었습니다.");
							$scope.noticeManage.func.getNoticeList();
						}
					}
				},
				checkValue : function(pnum) {
					if(!$scope.noticeManage.obj.noticeSet.has(pnum)) {
						$scope.noticeManage.obj.noticeSet.add(pnum);
					} else {
						$scope.noticeManage.obj.noticeSet.delete(pnum);
					}
					console.log($scope.noticeManage.obj.noticeSet);
				},
				clickValue : function(pnum) {
					$window.ScopeToShare = pnum;
					$location.path("/noticeView").replace();
				},
				
			}
	}
	
	$scope.registerBtn = function(){
		$window.ScopeToShare = "";
		$location.path("/noticeAddMod").replace();
	  }
	
	$scope.changeBtn = function(){
		if($scope.noticeManage.obj.noticeSet.size == 0) {
			alert("선택된 공지사항이 없습니다.");
			return;
		} else if($scope.noticeManage.obj.noticeSet.size > 1) {
			alert("한 개의 항목만 선택하세요.");
			return;
		} else if(!confirm("선택한 공지사항을 수정하시겠습니까?")) {
			return;
		} else {
			console.log($scope.noticeManage.obj.noticeSet.values().next().value);
			$window.ScopeToShare = $scope.noticeManage.obj.noticeSet.values().next().value;
			$location.path("/noticeAddMod").replace();
		}
	}
	
	$scope.noticeManage.func.getNoticeList();
});
