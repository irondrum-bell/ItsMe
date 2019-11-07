app.controller("ScheduleManageCtrl", function($scope, $http) {
	
	$scope.scheduleManage = {
//		obj : {
//			scheduleList : ""
//		},
		func : {
			getScheduleList : function(){
				var date = new Date().toISOString();
				
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
						events : list,
						eventClick: function(arg) {
							alert(arg.event.start + " : " + arg.event.title);
					    }
				});

					calendar.render();
				} else {
					document.addEventListener('DOMContentLoaded', function() {
						console.log("gg");
						var calendarEl = document.getElementById('calendar');

						var calendar = new FullCalendar.Calendar(calendarEl, {
							plugins : [ 'interaction', 'dayGrid', 'timeGrid' ],
							header : {
								left : 'prev,next today',
								center : 'title',
								right : 'dayGridMonth,timeGridWeek,timeGridDay'
							},
							defaultDate : '2019-08-12',
							navLinks : true, // can click day/week names to navigate views
							selectable : true,
							selectMirror : true,
							select : function(arg) {
								var title = prompt('Event Title:');
								if (title) {
									calendar.addEvent({
										title : title,
										start : arg.start,
										end : arg.end,
										allDay : arg.allDay
									})
								}
								calendar.unselect()
							},
							editable : true,
							eventLimit : true, // allow "more" link when too many events
							events : [ {
								title : 'All Day Event',
								start : '2019-08-01'
							}, {
								title : 'Long Event',
								start : '2019-08-07',
								end : '2019-08-10'
							}, {
								groupId : 999,
								title : 'Repeating Event',
								start : '2019-08-09T16:00:00'
							}, {
								groupId : 999,
								title : 'Repeating Event',
								start : '2019-08-16T16:00:00'
							}, {
								title : 'Conference',
								start : '2019-08-11',
								end : '2019-08-13'
							}, {
								title : 'Meeting',
								start : '2019-08-12T10:30:00',
								end : '2019-08-12T12:30:00'
							}, {
								title : 'Lunch',
								start : '2019-08-12T12:00:00'
							}, {
								title : 'Meeting',
								start : '2019-08-12T14:30:00'
							}, {
								title : 'Happy Hour',
								start : '2019-08-12T17:30:00'
							}, {
								title : 'Dinner',
								start : '2019-08-12T20:00:00'
							}, {
								title : 'Birthday Party',
								start : '2019-08-13T07:00:00'
							}, {
								title : 'Click for Google',
								url : 'http://google.com/',
								start : '2019-08-28'
							} ]
						});

						calendar.render();
					});
				}
			}
		}
	}
	
	$scope.scheduleManage.func.getScheduleList();
});
