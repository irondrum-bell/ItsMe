<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset = UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>




<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="common.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<style>
table {
	border-right: none;
	border-left: none;
	border-top: none;
	border-bottom:;
}
</style>
<body>


	<div>
		<form action="adminMemberRemove.jsp" method="post" id="checkForm">
			<table align="center" cellspacing="0" width="750" class="t2"
				frame=void>

				<tr bgcolor="#85A0F2">
					<th width="100"><INPUT TYPE="TEXT" NAME="name" SIZE="20"></th>
					<th width="100"><select name='fruits'>
							<option value='' selected>-- 선택 --</option>
							<option value='apple'>과목</option>
							<option value='banana'>이름</option>
							<option value='lemon'>학과</option>
					</select></th>
					<th width="100"><INPUT TYPE="TEXT" NAME="name" SIZE="30"></th>
					<th width="100"><input type='button' value='검색' /></th>
			</table>
		</form>
		<form action='login_page.php'></form>
	</div>
	<br>
	<br>
	<form action="adminMemberRemove.jsp" method="post" id="checkForm">
		<table align="center" cellspacing="0" width="800" class="t2">

			<tr bgcolor="#85A0F2">
				<th width="100"><input type="checkbox" id="allCheck"></th>
				<th width="150" style="color: white">학번</th>
				<th width="300" style="color: white">학과</th>
				<th width="250" style="color: white">과목</th>
				<th width="100" style="color: white">날짜</th>
				<th width="100" style="color: white">이름</th>
				<th width="100" style="color: white">퇴실</th>
				<th width="100" style="color: white">입실</th>

				<%-- 회원정보 출력 => 반복문 시작 --%>
			<tr>
				<td width="80" align="center">
					<%-- 관리자(userLevel=>9)인 경우 삭제할 수 없도록 작성 --%> <input type="checkbox"
					name="checkId" class="check">


				</td>
				<td width="80" align="center">20140000</td>
				<td width="80" align="center">기계자동차공학과</td>
				<td width="140" align="center">프로그래밍</td>
				<td width="140" align="center">2019.10.09</td>
				<td width="140" align="center">박용석</td>
				<td width="140" align="center">12:00</td>
				<td width="140" align="center">18:00</td>
			<tr>
				<td width="80" align="center">
					<%-- 관리자(userLevel=>9)인 경우 삭제할 수 없도록 작성 --%> <input type="checkbox"
					name="checkId" class="check">


				</td>
				<td width="80" align="center">20140000</td>
				<td width="80" align="center">멀티미디어공학과</td>
				<td width="140" align="center">프로그래밍</td>
				<td width="140" align="center">2019.10.09</td>
				<td width="140" align="center">이종원</td>
				<td width="140" align="center">10:00</td>
				<td width="140" align="center">15:00</td>
			<tr>
				<td width="80" align="center">
					<%-- 관리자(userLevel=>9)인 경우 삭제할 수 없도록 작성 --%> <input type="checkbox"
					name="checkId" class="check">


				</td>
				<td width="80" align="center">20140000</td>
				<td width="80" align="center">컴퓨터공학과</td>
				<td width="140" align="center">프로그래밍</td>
				<td width="140" align="center">2019.10.09</td>
				<td width="140" align="center">남길우</td>
				<td width="140" align="center">10:00</td>
				<td width="140" align="center">15:00</td>
			<tr>
				<td width="80" align="center">
					<%-- 관리자(userLevel=>9)인 경우 삭제할 수 없도록 작성 --%> <input type="checkbox"
					name="checkId" class="check">


				</td>
				<td width="80" align="center">20140000</td>
				<td width="80" align="center">전자공학과</td>
				<td width="140" align="center">프로그래밍</td>
				<td width="140" align="center">2019.10.09</td>
				<td width="140" align="center">김정태</td>
				<td width="140" align="center">10:00</td>
				<td width="140" align="center">15:00</td>
			<tr>
				<td width="80" align="center">
					<%-- 관리자(userLevel=>9)인 경우 삭제할 수 없도록 작성 --%> <input type="checkbox"
					name="checkId" class="check">


				</td>
				<td width="80" align="center">20150685</td>
				<td width="80" align="center">정보통계학과</td>
				<td width="140" align="center">프로그래밍</td>
				<td width="140" align="center">2019.10.09</td>
				<td width="140" align="center">정소연</td>
				<td width="140" align="center">10:00</td>
				<td width="140" align="center">15:00</td>
			<tr>

				<%-- 반복문 종료 --%>
		</table>
		<table align="right">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>

					<button type="submit">회원삭제</button>&nbsp;&nbsp;

				</td>
			</tr>
		</table>
	</form>
</body>
</html>