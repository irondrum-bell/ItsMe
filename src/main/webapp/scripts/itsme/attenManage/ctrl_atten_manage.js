app.controller("AttenManageCtrl", function($scope, $http){	
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
	
	
	$scope.attendanceManage = {
			obj : {
				attendanceList : "",
				searchName : ""
			},
			func : {
				getMemberList : function(){
					
					var param = {
							searchName : $scope.attendanceManage.obj.searchName
					}
					
					req_http_rest_api.func.req_get_message($http, "/getattendance", param, function(response){
						$scope.attendanceManage.obj.searchName = "bbbbb";0
						if(response.data.code == 500){
							alert(response.data.msg);
						}else{
							$scope.attendanceManage.obj.attendanceList = response.data.value;
						}
						
					}, function(response){
						alert("서버와 연결을 할 수 없습니다.");
					})
				}
			}
	}
	
	
	$scope.attendanceManage.func.getMemberList();
	
	
});


