var APP_NAME = "appHome";
var app = angular.module(APP_NAME, ["ui.bootstrap", "ngRoute", "date-picker"]);

var adminUrl = "";
var etcUrl = "";

if(isAdmin == "1"){
	adminUrl = "/";
	etcUrl = "/classManage";
} else if(isAdmin == "2"){
	adminUrl = "/memberlist";
	etcUrl = "/";
}else{
	adminUrl = "";
	etcUrl = "";
}

app.controller("appHomeCtrl", function($scope, $http, $location, $timeout, $route, $window){
	
	
	// 상단 메뉴를 위한 설정.
	$scope.routeContents = [ {
		url : "#" + adminUrl,
		display : "회원 관리",
		code : 1,
		disabled : false,
		selected : false
	},{
		url : "#" + etcUrl,
		display : "수업 관리",
		code : 2,
		disabled : false,
		selected : false
	},{
		url : ctx + "#/attenManage",
		display : "출석 관리",
		code : 3,
		disabled : false,
		selected : false
	},{
		url : ctx + "#/scheduleManage",
		display : "일정 조회",
		code : 4,
		disabled : false,
		selected : false
	},{
		url : ctx + "#/noticeManage",
		display : "공지사항",
		code : 5,
		disabled : false,
		selected : false
	},{
		url : ctx + "#/memberManage",
		display : "회원 등록/수정",
		code : 6,
		disabled : false,
		selected : false
	},{
		url : ctx + "#/classAddMod",
		display : "수업 등록/수정",
		code : 7,
		disabled : false,
		selected : false
	},{
		url : ctx + "#/attenMod",
		display : "출석 수정",
		code : 8,
		disabled : false,
		selected : false
	},{
		url : ctx + "#/noticeAddMod",
		display : "공지사항 등록/수정",
		code : 9,
		disabled : false,
		selected : false
	} ];

	if(isAdmin == "1"){
		$scope.routeContents[0].disabled = false;
		$scope.routeContents[1].disabled = false;
		$scope.routeContents[2].disabled = false;
		$scope.routeContents[3].disabled = false;
		$scope.routeContents[4].disabled = false;
		$scope.routeContents[5].disabled = false;
	} else if(isAdmin == "2"){
		$scope.routeContents[0].disabled = true;
		$scope.routeContents[1].disabled = false;
		$scope.routeContents[2].disabled = false;
		$scope.routeContents[3].disabled = true;
		$scope.routeContents[4].disabled = true;
		$scope.routeContents[5].disabled = true;
	}else{
		$scope.routeContents[0].disabled = true;
		$scope.routeContents[1].disabled = true;
		$scope.routeContents[2].disabled = true;
		$scope.routeContents[3].disabled = true;
		$scope.routeContents[4].disabled = true;
		$scope.routeContents[5].disabled = true;
	}

});


app.config(function($routeProvider, $locationProvider){
	$locationProvider.hashPrefix('');

	$routeProvider.when(ctx + adminUrl,{
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

	$routeProvider.when(ctx + etcUrl,{
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
		templateUrl : ctx + "/templates/itsme/classManage/class.html",
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