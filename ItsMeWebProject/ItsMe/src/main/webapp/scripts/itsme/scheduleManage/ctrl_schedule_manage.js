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
						searchDate1 : "",
						searchDate2 : "2020.11.11"
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
					    			var dateStart = prompt('일정을 추가할 날짜를 입력하세요.(YYYY.MM.DD)');
					    			var dateTitle = prompt('일정 내용을 입력하세요.');

				    				if (dateStart.split(".").length == 3) { // valid?
				    					$scope.scheduleManage.func.addSchedule(dateTitle, dateStart);
				    					calendar.addEvent({
				    						title: dateTitle,
				    						start: dateStart.split(".").join("-"),
				    						allDay: true
				    					});
				    				} else {
				    					alert('Invalid date.');
				    				}
					    		}
					    	}
					    },
						events : list,
						eventClick: function(arg) {
							alert(arg.event.start + " : " + arg.event.title);
					    }
				});

					calendar.render();
				} else {
					document.addEventListener('DOMContentLoaded', function() {
						var calendarEl = document.getElementById('calendar');
						
					});
				}
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
