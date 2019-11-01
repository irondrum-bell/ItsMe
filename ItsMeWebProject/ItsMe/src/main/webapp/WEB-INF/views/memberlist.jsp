<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%-- member 테이블에 저장된 전체 회원정보를 검색하여 출력하는 페이지 --%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- 메뉴 바 -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<!-- Our Custom CSS -->
<link rel="stylesheet" href="resources/css/menubar/style2.css">

<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
	integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
	integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
	crossorigin="anonymous"></script>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 페이지 - 회원관리</title>
<link rel="stylesheet" type="text/css" href="common.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#allCheck").change(function() {
			if (this.checked) {
				$(".check").prop("checked", true);
			} else {
				$(".check").prop("checked", false);
			}
		});

		$("#checkForm").submit(function() {
			if ($(".check").filter(":checked").size() == 0) {
				alert("회원을 한 명도 선택하지 않았습니다.");
				return false;
			}
		});
	});

	function changeUserLevel(id, level) {
		location.href = 'adminChangeUserLevel.jsp?id=' + id + "&level=" + level;
	}
</script>
<!-- Bootstrap CSS CDN -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<!-- Our Custom CSS -->
<link rel="stylesheet" href="resources/css/menubar/style2.css">

<!-- Font Awesome JS -->
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
	integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
	integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
	crossorigin="anonymous"></script>
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
	<div class="wrapper">
		<!-- Sidebar  -->
		<nav id="sidebar">
		<div class="sidebar-header">
			<h3>It's Me !</h3>
		</div>

		<ul class="list-unstyled components">

			<li><a href="memberlist">회원목록</a></li>
			<li><a href="수업(?)">수업</a></li>
			<li><a href="출석(?)">출석</a></li>
			<li><a href="schedule">일정</a></li>
			<li><a href="notice">공지사항</a></li>
		</ul>

		<ul class="list-unstyled CTAs">
			<li><a
				href="https://bootstrapious.com/tutorial/files/sidebar.zip"
				class="download">로그아웃</a></li>
			<!--<li><a href="https://bootstrapious.com/p/bootstrap-sidebar"
					class="article">Back to article</a></li>
			</ul> -->
		</nav>

	</div>


	<div id="menubar">

		<hr color="#7B7EDD" width=90%>



		<table width="90%" cellpadding="5" cellspacing="0">

			<tr>
				<td rowspan="5">회원검색</td>
			</tr>
			<tr>
				<td>구 분 : <select>

						<option>선택</option>
						<option>------</option>
						<option>학생</option>
						<option>교수</option>

				</select></td>

			</tr>



			<tr>

				<td>이 름 : <input type="text"></td>

			</tr>

			<tr>

				<td>학 번/사 번 : <input type="text"></td>

			</tr>

			<tr>

				<td>소 속/학 과 : <select>

						<option>선택</option>
						<option>--------------------------</option>

						<option>인문예술대학/국어국문학과</option>
						<option>인문예술대학/중어중문학과</option>
						<option>인문예술대학/유럽문화 관광학과</option>
						<option>인문예술대학/한문학과</option>
						<option>인문예술대학/민속학과</option>
						<option>인문예술대학/동양철학과</option>
						<option>인문예술대학/사학과</option>
						<option>인문예술대학/의류학과</option>
						<option>인문예술대학/음악과</option>
						<option>인문예술대학/미술학과</option>

						<option>사회과학대학/경재무역학부/경제학전공</option>
						<option>사회과학대학/경재무역학부/무역학전공</option>
						<option>사회과학대학/경영회계학부/경영학전공</option>
						<option>사회과학대학/경영회계학부/회계학전공</option>
						<option>사회과학대학/법학과</option>
						<option>사회과학대학/행정학과</option>
						<option>사회과학대학/생활복지학과</option>

						<option>사범대학/국어교육과</option>
						<option>사범대학/윤리교육과</option>
						<option>사범대학/영어교육과</option>
						<option>사범대학/교육교육과</option>
						<option>사범대학/수학교육과</option>
						<option>사범대학/컴퓨터교육과</option>
						<option>사범대학/전자공학교육과</option>
						<option>사범대학/기계교육과</option>

						<option>자연과학대학/물리학과</option>
						<option>자연과학대학/응용화학과</option>
						<option>자연과학대학/지구환경과학과</option>
						<option>자연과학대학/정보통계학과</option>
						<option>자연과학대학/체육학과</option>

						<option>생명과학대학/생명공학부/생명과학전공</option>
						<option>생명과학대학/생명공학부/생명백신공학전공</option>
						<option>생명과학대학/원예 생양융합학부</option>
						<option>생명과학대학/식품생명공학과</option>
						<option>생명과학대학/식품영양학과</option>
						<option>생명과학대학/식물의학과</option>
						<option>생명과학대학/간호학과</option>

						<option>공과대학/신소재공학부/응용신소재공학전공</option>
						<option>공과대학/신소재공학부/금속신소재공학전공</option>
						<option>공과대학/멀티미디어공학과</option>
						<option>공과대학/건축공학과</option>
						<option>공과대학/기계공학과</option>
						<option>공과대학/기계로봇공학과</option>
						<option>공과대학/정보통신공학과</option>
						<option>공과대학/토목공학과</option>
						<option>공과대학/기계자동차공학과</option>
						<option>공과대학/전자공학과</option>
						<option>공과대학/컴퓨터공학과</option>
						<option>공과대학/컴퓨터공학과</option>

						<option>창의융합학부/창의융합학부</option>

				</select></td>

				<td><button type="button" class="button"
						style="color: #fff; background: black; font-size: 1em; border-radius: 0.5em; padding: 5px 20px;">검
						색</button></td>
			</tr>

		</table>
	</div>
	<hr color="#7B7EDD" width=100%>


	● 회원목록
	<center>
		<table width=50% border="0" cellpadding="0" cellspacing="0">
			<tr align="center" valign="middle">
				<td colspan="4">MVC 게시판</td>
				<td align=right><font size=2>글 개수 : </font></td>
			</tr>

			<tr align="center" valign="middle" bordercolor="#333333">
				<td style="font-family: Tahoma; font-size: 8pt;" width="8%"
					height="26">
					<div align="center">번호</div>
				</td>
				<td style="font-family: Tahoma; font-size: 8pt;" width="50%">
					<div align="center">제목</div>
				</td>
				<td style="font-family: Tahoma; font-size: 8pt;" width="14%">
					<div align="center">작성자</div>
				</td>
				<td style="font-family: Tahoma; font-size: 8pt;" width="17%">
					<div align="center">날짜</div>
				</td>
				<td style="font-family: Tahoma; font-size: 8pt;" width="11%">
					<div align="center">조회수</div>
				</td>
			</tr>
			<%-- 
	<%
		for(int i=0;i<boardList.size();i++){
			BoardBean bl=(BoardBean)boardList.get(i);
	%> --%>
			<tr align="center" valign="middle" bordercolor="#333333"
				onmouseover="this.style.backgroundColor='F8F8F8'"
				onmouseout="this.style.backgroundColor=''">
				<td height="23" style="font-family: Tahoma; font-size: 10pt;">
					<%--=bl.getBOARD_NUM()--%>88
				</td>

				<td style="font-family: Tahoma; font-size: 10pt;">
					<div align="left">
						<%--if(bl.getBOARD_RE_LEV()!=0){ --%>
						<%--for(int a=0;a<=bl.getBOARD_RE_LEV()*2;a++){ --%>
						&nbsp;
						<%--} --%>
						<%--}else{ --%>

						<%--} --%>
						<a href="./BoardDetailAction.bo?num=<%--=bl.getBOARD_NUM()--%>">
							<%--=bl.getBOARD_SUBJECT()--%>제목
						</a>
					</div>
				</td>

				<td style="font-family: Tahoma; font-size: 10pt;">
					<div align="center">
						99ㅎㅎ
						<%--=bl.getBOARD_NAME()--%>
					</div>
				</td>
				<td style="font-family: Tahoma; font-size: 10pt;">
					<div align="center">
						00ㅎㅎ
						<%--=bl.getBOARD_DATE() --%>
					</div>
				</td>
				<td style="font-family: Tahoma; font-size: 10pt;">
					<div align="center">
						ㄹㄹ==
						<%--=bl.getBOARD_READCOUNT() --%>
					</div>
				</td>
			</tr>

			<%--} --%>
			<tr align=center height=20>
				<td colspan=7 style="font-family: Tahoma; font-size: 10pt;">
					<%--if(nowpage<=1){ --%> [이전]&nbsp; <%--}else{ --%> <a
					href="./BoardList.bo?page=<%--=nowpage-1 --%>">[이전]</a>&nbsp; <%--} --%>

					<%--for(int a=startpage;a<=endpage;a++){
				if(a==nowpage){--%> [<%--=a --%>] <%--}else{ --%> <a
					href="./BoardList.bo?page=<%--=a --%>">[<%--=a --%>]
				</a>&nbsp; <%--} --%> <%--} --%> <%--if(nowpage>=maxpage){ --%> [다음] <%--}else{ --%>
					<a href="./BoardList.bo?page=<%--=nowpage+1 --%>">[다음]</a> <%--} --%>
				</td>
			</tr>
			<tr align="right">
				<td colspan="5"><a href="./BoardWrite.bo">[글쓰기]</a></td>
			</tr>
		</table>
	</center>
	</form>
</body>
</html>