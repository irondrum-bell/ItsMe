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
	$scope.attendanceManage = {
			obj : {
				attendanceList : "",
				searchName : "",
				searchSubject : "",
				selectMajor : $scope.majorList[0]
			},
			func : {
				getAttendanceList : function(){
					
					var param = {
							searchName : $scope.attendanceManage.obj.searchName,
							searchSubject : $scope.attendanceManage.obj.searchSubject,
							selectMajor : $scope.attendanceManage.obj.selectMajor['code']
					}
					
					req_http_rest_api.func.req_get_message($http, "/getattendance", param, function(response){
						/*$scope.attendanceManage.obj.searchName = "bbbbb";*/
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
	
	
	$scope.attendanceManage.func.getAttendanceList();
	
	
});


