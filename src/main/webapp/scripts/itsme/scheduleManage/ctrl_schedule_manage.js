app.controller("ScheduleManageCtrl", function($scope, $http) {
	
	$scope.scheduleManage = {
//		obj : {
//			scheduleList : ""
//		},
		func : {
			getScheduleList : function(){
//				var date = new Date().toISOString();
				
				var param = {
//						searchDate1 : date.slice(0,4) + "." + date.slice(5,7) + ".01",
//						searchDate2 : date.slice(0,4) + "." + date.slice(5,7) + ".31"
//						searchDate1 : "",
//						searchDate2 : "2020.11.11"
				}

				req_http_rest_api.func.req_get_message($http, "/getSchedule", param, function(response){
					if(response.data.code == 500){
						alert(response.data.msg);
					}else{
//						$scope.scheduleManage.obj.scheduleList = response.data.value;
						$scope.scheduleManage.func.drawSchedule(response.data.value);
					}
				}, function(response){
					alert("서버와 연결을 할 수 없습니다.");
				})
			},
			drawSchedule : function(list) {
				if (document.readyState !== 'loading') {
					console.log('document is already ready, just execute code here');
					var calendarEl = document.getElementById('calendar');

					for(i = 0; i < list.length; i++) {
						list[i]['start'] = list[i]['start'].split('.').join('-');
					}
					
					var calendar = new FullCalendar.Calendar(calendarEl, {
						plugins : [ 'dayGrid' ],
						timeZone : 'UTC',
						defaultView : 'dayGridMonth',
						header: {
					      center: 'addEventButton'
					    },
					    customButtons: {
					    	addEventButton: {
					    		text: '일정 추가',
					    		click: function() {
					    			var url = "templates/itsme/scheduleManage/model_content_addschedule.html";
									// 다이얼로그를 생성합니다.
									$('<div id="DialogDiv">').dialog({
										// 커스텀 스타일을 줍니다.
										dialogClass : 'custom-dialog-style',
										// 모달 다이얼로그로 생성합니다.
										modal : true,
									    buttons: {
									    	"추가": function() {
									    		param = $scope.scheduleManage.func.getScheduleParam();
												calendar.addEvent({
													title: param.split("|")[0],
													start: param.split("|")[1].split(".").join("-"),
													allDay: true
												});
									    		$(this).dialog( "close" );
									    	},
									    	"취소": function() {
									    		$(this).dialog( "close" );
									    	}
									    },
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
										height : 400,
										width : 700,
										title : '일정 추가'
									});
					    		}
					    	}
					    },
						events : list,
						eventClick: function(arg) {
							var url = "templates/itsme/scheduleManage/model_content_viewschedule.html";
							// 다이얼로그를 생성합니다.
							$('<div id="DialogDiv">').data('title', arg.event.title).data('start', arg.event.start).dialog({
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
								height : 400,
								width : 700,
								title : '일정 조회'
							});
					    }
				});

					calendar.render();
				} else {
					document.addEventListener('DOMContentLoaded', function() {
						var calendarEl = document.getElementById('calendar');
						
					});
				}
			},
			getScheduleParam : function(){
	        	var dateTitle = $("#title").val();
    			var dateStart = $("#date").val();

				if (dateStart.split(".").length == 3) { // valid?
					$scope.scheduleManage.func.addSchedule(dateTitle, dateStart);
				} else {
					alert('Invalid date.');
				}
				return dateTitle + "|" + dateStart;
			},
			addSchedule : function(title, start) {
				var param = {
						insertTitle : title,
						insertStart : start
				}

				req_http_rest_api.func.req_post_message($http, "/addSchedule", param, function(response){
					if(response.data.code == 500){
						alert(response.data.msg);
					}else{
//						$scope.scheduleManage.obj.scheduleList = response.data.value;
//						$scope.scheduleManage.func.drawSchedule(response.data.value);
    					alert('일정이 추가되었습니다.');
   					}
				}, function(response){
					alert("서버와 연결을 할 수 없습니다.");
				})
			}
		}
	}
	
	$scope.scheduleManage.func.getScheduleList();
});
