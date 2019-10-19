<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp" %>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<!-- Our Custom CSS -->
<link rel="stylesheet" href="css/menubar/style2.css">

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
<script src="${ctx}/scripts/itsme/attenManage/ctrl_atten_manage.js" type="text/javascript"></script>
<script src="${ctx}/scripts/itsme/classManage/ctrl_class_manage.js" type="text/javascript"></script>
<script src="${ctx}/scripts/itsme/memberlist/ctrl_member_list.js" type="text/javascript"></script>
<script src="${ctx}/scripts/itsme/noticeManage/ctrl_notice_manage.js" type="text/javascript"></script>
<script src="${ctx}/scripts/itsme/scheduleManage/ctrl_schedule_manage.js" type="text/javascript"></script>




<html ng-app="appHome">
<head>
	<title>ItsMe</title>
</head>
<body ng-controller="appHomeCtrl">

	<div class="wrapper" style="width:250px;height:100%;float:left;">
		<!-- Sidebar  -->
		<nav id="sidebar">
			<div class="sidebar-header">
				<h3>It's Me !</h3>
			</div>

			<ul class="list-unstyled components">
				<li ng-repeat="menu in routeContents"><a href="{{menu.url}}">{{menu.display}}</a></li> 
			</ul>

			 <ul class="list-unstyled CTAs">
				<li><a href="https://bootstrapious.com/tutorial/files/sidebar.zip" class="download">로그아웃</a></li>
			</ul>
		</nav>

	</div>
	<div style="width:calc(100% - 250px);height:100%;float:left;">
		<div ng-view></div>
	</div>
</body>
</html>
