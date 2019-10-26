<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="datePattern">
	<fmt:message key="date.format" />
</c:set>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<script type="text/javascript">
	// context for 'Global Use'
	var ctx = "${ctx}";
</script>

<script src="${ctx}/scripts/angularjs/angular.js" type="text/javascript"></script>
<script src="${ctx}/scripts/angularjs/angular-route.js"
	type="text/javascript"></script>
<script src="${ctx}/scripts/angularjs/angular-resource.js"
	type="text/javascript"></script>

<script src="${ctx}/scripts/jquery/jquery-1.11.3.min.js"
	type="text/javascript"></script>
<script src="${ctx}/scripts/jquery/jquery-ui.js" type="text/javascript"></script>
<script src="${ctx}/scripts/jquery/jquery.easing.1.3.js"
	type="text/javascript"></script>

<script src="${ctx}/scripts/bootstrap/bootstrap.min.js"
	type="text/javascript"></script>

<script src="${ctx}/scripts/itsme/util/datepicker.js"
	type="text/javascript"></script>

<link rel="stylesheet" href="${ctx}/css/datepicker.css" />

<link rel="stylesheet" href="${ctx}/css/bootstrap/bootstrap.css" />


<!-- 일정부분 -->
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
<script src="${ctx}/js/schedule/js/etcSetting.js"></script>

<link rel="stylesheet"
	href="vendor/schedule/vendor/css/fullcalendar.min.css">
<link rel="stylesheet"
	href="vendor/schedule/vendor/css/bootstrap.min.css">
<link rel="stylesheet"
	href='vendor/schedule/vendor/css/select2.min.css'>
<link rel="stylesheet"
	href='vendor/schedule/vendor/css/bootstrap-datetimepicker.min.css'>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,500,600">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="css/schedule/main.css">
 --%>