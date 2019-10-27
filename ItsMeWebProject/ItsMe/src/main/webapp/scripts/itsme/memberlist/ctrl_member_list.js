app.controller("MemberListCtrl",function($scope, $http) {
	
	$scope.memberManage = {
			obj : {
				memberList : "",
				searchName : ""
			},
			func : {
				getMemberList : function(){
					
					var param = {
							searchName : $scope.memberManage.obj.searchName
					}
					
					req_http_rest_api.func.req_get_message($http, "/getMemberList", param, function(response){
						$scope.memberManage.obj.searchName = "bbbbb";0
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
	
	
	
	
	
	$(document).ready(function() {
		// 버튼의 이벤트 핸들러를 붙입니다.
		$("#dynamic-dialog").button().on("click", function() {
			// 다이얼로그 내용을 가져올 URL입니다.
			var url = "scripts/dialog/memberlist.html";
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
				height : 900,
				width : 1000,
				title : '회원 등록'
			});
		});
	});
		
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
