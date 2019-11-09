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

<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
	integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
	integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
	crossorigin="anonymous"></script>

<script src="${ctx}/scripts/itsme/home/ctrl_home.js" type="text/javascript"></script>
<script src="${ctx}/scripts/itsme/attenManage/ctrl_atten_manage.js"	type="text/javascript"></script>
<script src="${ctx}/scripts/itsme/classManage/ctrl_class_manage.js" type="text/javascript"></script>
<script src="${ctx}/scripts/itsme/classManage/ctrl_class_add.js" type="text/javascript"></script>
<script src="${ctx}/scripts/itsme/memberlist/ctrl_member_list.js" type="text/javascript"></script>
<script src="${ctx}/scripts/itsme/memberlist/ctrl_member_add.js" type="text/javascript"></script>
<script src="${ctx}/scripts/itsme/noticeManage/ctrl_notice_manage.js" type="text/javascript"></script>
<script src="${ctx}/scripts/itsme/noticeManage/ctrl_notice_addmod.js" type="text/javascript"></script>
<script src="${ctx}/scripts/itsme/scheduleManage/ctrl_schedule_manage.js" type="text/javascript"></script>

<!-- datapicekr 사용 -->
<script type="text/javascript" src="${ctx}/scripts/jquery/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="${ctx}/scripts/jquery/jquery-ui.js"></script>
<link rel="stylesheet" href="${ctx}/scripts/jquery/jquery-ui.css">

<!-- 회원등록 주소 API -->
<!-- <script src="http://code.jquery.com/jquery-latest.min.js"></script> -->

<%-- <!-- schedule js -->
<link href='schedule_latest/core/main.css' rel='stylesheet' />
<link href='schedule_latest/daygrid/main.css' rel='stylesheet' />
<link href='schedule_latest/timegrid/main.css' rel='stylesheet' />
<script src='${ctx}/schedule_latest/core/main.js'></script>
<script src='${ctx}/schedule_latest/interaction/main.js'></script>
<script src='${ctx}/schedule_latest/daygrid/main.js'></script>
<script src='${ctx}/schedule_latest/timegrid/main.js'></script>
 --%>
 <link rel="stylesheet" href="https://unpkg.com/@fullcalendar/core@4.3.1/main.min.css">
 <link rel="stylesheet" href="https://unpkg.com/@fullcalendar/daygrid@4.3.0/main.min.css">
 <script src='https://unpkg.com/@fullcalendar/core@4.3.1/main.min.js'></script>
 <script src='https://unpkg.com/@fullcalendar/daygrid@4.3.0/main.min.js'></script>


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
				<li ng-repeat="menu in routeContents"><a ng-if="menu.code < 6 && menu.disabled == false" href="{{menu.url}}" style="padding: 10px;font-size: 1.1em;display: block;">{{menu.display}}</a></li>
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
