<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>


<!-- menubar CSS -->
<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<!-- Our Custom CSS -->
<link rel="stylesheet" href="css/menubar/style2.css">


<!-- schedule CSS -->
<%-- <link rel="stylesheet"
	href="${ctx}/vendor/schedule/vendor/css/fullcalendar.min.css">
<link rel="stylesheet"
	href="${ctx}/vendor/schedule/vendor/css/bootstrap.min.css">
<link rel="stylesheet" href='${ctx}/vendor/schedule/vendor/css/select2.min.css'>
<link rel="stylesheet"
	href='${ctx}/vendor/schedule/vendor/css/bootstrap-datetimepicker.min.css'>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,500,600">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">

<link rel="stylesheet" href="${ctx}/css/schedule/main.css">
 --%>

<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
	integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
	integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
	crossorigin="anonymous"></script>

<script src="${ctx}/scripts/itsme/home/ctrl_home.js"
	type="text/javascript"></script>
<script src="${ctx}/scripts/itsme/attenManage/ctrl_atten_manage.js"
	type="text/javascript"></script>
<script src="${ctx}/scripts/itsme/classManage/ctrl_class_manage.js"
	type="text/javascript"></script>
<script src="${ctx}/scripts/itsme/memberlist/ctrl_member_list.js"
	type="text/javascript"></script>
<script src="${ctx}/scripts/itsme/noticeManage/ctrl_notice_manage.js"
	type="text/javascript"></script>
<script
	src="${ctx}/scripts/itsme/scheduleManage/ctrl_schedule_manage.js"
	type="text/javascript"></script>

<!-- datapicekr 사용 -->
<script type="text/javascript" src="${ctx}/scripts/jquery/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery/jquery-ui.js"></script>
<link rel="stylesheet" href="${ctx}/scripts/jquery/jquery-ui.css">

<!-- 회원등록 주소 API -->
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>

<!-- schedule js -->
<%-- <script src="${ctx}/vendor/schedule/vendor/js/jquery.min.js"></script>
	<script src="${ctx}/vendor/schedule/vendor/js/bootstrap.min.js"></script>
	<script src="${ctx}/vendor/schedule/vendor/js/moment.min.js"></script>
	<script src="${ctx}/vendor/schedule/vendor/js/fullcalendar.min.js"></script>
	<script src="${ctx}/vendor/schedule/vendor/js/ko.js"></script>
	<script src="${ctx}/vendor/schedule/vendor/js/select2.min.js"></script>
	<script
		src="${ctx}/vendor/schedule/vendor/js/bootstrap-datetimepicker.min.js"></script>
	<script src="${ctx}/js/schedule/js/main.js"></script>
	<script src="${ctx}/js/schedule/js/addEvent.js"></script>
	<script src="${ctx}/js/schedule/js/editEvent.js"></script>
	<script src="${ctx}/js/schedule/js/etcSetting.js"></script> --%>


<html ng-app="appHome">
<head>
<title>ItsMe</title>
</head>
<body ng-controller="appHomeCtrl">

	<div class="wrapper" style="width: 250px; height: 100%; float: left;">
		<!-- Sidebar  -->
		<nav id="sidebar">
			<div class="sidebar-header">
				<h3>It's Me !</h3>
			</div>

			<ul class="list-unstyled components" style="padding: 20px 0;border-bottom:1px solid #47748b;">
				<li ng-repeat="menu in routeContents"><a href="{{menu.url}}" style="padding: 10px;font-size: 1.1em;display: block;">{{menu.display}}</a></li>
			</ul>

			<ul class="list-unstyled CTAs">
				<li><a href="/j_spring_security_logout" class="download">로그아웃</a></li>
			</ul>
		</nav>

	</div>
	<div style="width: calc(100% - 250px); height: 100%; float: left;">
		<div ng-view></div>
	</div>
</body>
</html>
