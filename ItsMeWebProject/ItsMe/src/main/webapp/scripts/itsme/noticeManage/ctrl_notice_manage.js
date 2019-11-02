app.controller("NoticeManageCtrl", function($scope, $http) {

	$(document).ready(function() {
		// 버튼의 이벤트 핸들러를 붙입니다.
		$("#notice-dialog").button().on("click", function() {
			// 다이얼로그 내용을 가져올 URL입니다.
			var url = "scripts/dialog/notice.html";
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
				height : 700,

				width : 600,

				title : '공지사항 추가'
			});
		});
	});

	$.datepicker.setDefaults({
		dateFormat : 'yy-mm-dd',
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

	
	$scope.noticeManage = {
			obj : {
				noticeList : "",
				searchName : ""
			},
			func : {
				getMemberList : function(){
					
					var param = {
							searchName : $scope.noticeManage.obj.searchName
					}
					
					req_http_rest_api.func.req_get_message($http, "/getNotice", param, function(response){
						$scope.noticeManage.obj.searchName = "bbbbb";
						if(response.data.code == 500){
							alert(response.data.msg);
						}else{
							$scope.noticeManage.obj.noticeList = response.data.value;
						}
						
					}, function(response){
						alert("서버와 연결을 할 수 없습니다.");
					})
				}
			}
	}
	
	$scope.noticeManage.func.getMemberList();
	
});
