var APP_NAME = "appHome";
var app = angular.module(APP_NAME, ["ui.bootstrap", "ngRoute", "date-picker"]);

app.controller("appHomeCtrl", function($scope, $http, $location, $timeout, $route, $window){

	// 상단 메뉴를 위한 설정.
	$scope.routeContents = [ {
		url : ctx + "#/memberlist",
		display : "회원 관리",
		code : 1,
		disabled : false,
		selected : false,
		disabled : false
	},{
		url : ctx + "#/classManage",
		display : "수업 관리",
		code : 2,
		disabled : false,
		selected : false,
		disabled : false
	},{
		url : ctx + "#/attenManage",
		display : "출석 관리",
		code : 3,
		disabled : false,
		selected : false,
		disabled : false
	},{
		url : ctx + "#/scheduleManage",
		display : "일정 조회",
		code : 4,
		disabled : false,
		selected : false,
		disabled : false
	},{
		url : ctx + "#/noticeManage",
		display : "공지사항",
		code : 5,
		disabled : false,
		selected : false,
		disabled : false
	},{
		url : ctx + "#/memberManage",
		display : "회원 등록/수정",
		code : 6,
		disabled : false,
		selected : false,
		disabled : false
	},{
		url : ctx + "#/classAddMod",
		display : "수업 등록/수정",
		code : 7,
		disabled : false,
		selected : false,
		disabled : false
	},{
		url : ctx + "#/attenMod",
		display : "출석 수정",
		code : 8,
		disabled : false,
		selected : false,
		disabled : false
	},{
		url : ctx + "#/noticeAddMod",
		display : "공지사항 등록/수정",
		code : 9,
		disabled : false,
		selected : false,
		disabled : false
	} ];
});


app.config(function($routeProvider, $locationProvider){
	$locationProvider.hashPrefix('');

	$routeProvider.when(ctx + "/memberlist",{
		templateUrl : ctx + "/templates/itsme/memberlist/tpl_content_memberlist.html",
		controller : "MemberListCtrl",
		resolve : {
			content : function() {
				return {
				};
			}
		},
		redirectTo : null
	});
	
	$routeProvider.when(ctx + "/memberManage",{
		templateUrl : ctx + "/templates/itsme/memberlist/memberlist.html",
		controller : "MemberManageCtrl",
		resolve : {
			content : function() {
				return {
				};
			}
		},
		redirectTo : null
	});

	$routeProvider.when(ctx + "/classManage",{
		templateUrl : ctx + "/templates/itsme/classManage/tpl_content_classmanage.html",
		controller : "ClassManageCtrl",
		resolve : {
			content : function() {
				return {
				};
			}
		},
		redirectTo : null
	});

	$routeProvider.when(ctx + "/classAddMod",{
		templateUrl : ctx + "/templates/itsme/classManage/classaddmod.html",
		controller : "ClassAddModCtrl",
		resolve : {
			content : function() {
				return {
				};
			}
		},
		redirectTo : null
	});

	$routeProvider.when(ctx + "/attenManage",{
		templateUrl : ctx + "/templates/itsme/attenManage/tpl_content_attenmanage.html",
		controller : "AttenManageCtrl",
		resolve : {
			content : function() {
				return {
				};
			}
		},
		redirectTo : null
	});

	$routeProvider.when(ctx + "/attenMod",{
		templateUrl : ctx + "/templates/itsme/attenManage/attenmod.html",
		controller : "AttenModCtrl",
		resolve : {
			content : function() {
				return {
				};
			}
		},
		redirectTo : null
	});
	
	$routeProvider.when(ctx + "/scheduleManage",{
		templateUrl : ctx + "/templates/itsme/scheduleManage/tpl_content_schedulemanage.html",
		controller : "ScheduleManageCtrl",
		resolve : {
			content : function() {
				return {
				};
			}
		},
		redirectTo : null
	});
	
	$routeProvider.when(ctx + "/noticeManage",{
		templateUrl : ctx + "/templates/itsme/noticeManage/tpl_content_noticemanage.html",
		controller : "NoticeManageCtrl",
		resolve : {
			content : function() {
				return {
				};
			}
		},
		redirectTo : null
	});
	
	$routeProvider.when(ctx + "/noticeAddMod",{
		templateUrl : ctx + "/templates/itsme/noticeManage/noticeaddmod.html",
		controller : "NoticeAddModCtrl",
		resolve : {
			content : function() {
				return {
				};
			}
		},
		redirectTo : null
	});
});