<%@ page language="java" contentType="text/html; charset = UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 

            "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"></meta>

<title></title>

<!-- CSS 영역 -->

<style type="text/css">
* {
	font-size: 9pt;
}

p {
	width: 600px;
	text-align: right;
}

table thead tr th {
	background-color: #85A0F2;
}
</style>

<!-- //CSS 영역 -->

<!-- 자바스크립트 영역 -->

<script type="text/javascript">
	function goUrl(url) {

		location.href = url;

	}
</script>

<!-- //자바스크립트 영역 -->

</head>

<body>

	<!-- 검색 폼 영역 -->

	<form name="searchForm" action="" method="get">




		<div style="align: center">
			<form action="adminMemberRemove.jsp" method="post" id="checkForm">
				<table align="center" cellspacing="0" width="750" class="t2"
					frame=void>

					<tr bgcolor="#85A0F2">
						<th width="100"><INPUT TYPE="TEXT" NAME="name" SIZE="20"></th>
						<th width="100"><select name='fruits'>
								<option value='' selected>-- 선택 --</option>
								<option value='apple'>제목</option>
								<option value='banana'>작성자</option>

						</select></th>
						<th width="100"><INPUT TYPE="TEXT" NAME="name" SIZE="30"></th>
						<th width="100"><input type='button' value='검색' /></th>
				</table>
			</form>
			<form action='login_page.php'></form>
		</div>

		<form action="adminMemberRemove.jsp" method="post" id="checkForm">
			<table align="center" cellspacing="0" width="800" class="t2">
				</br>


				</form>

				<!-- //검색 폼 영역 -->

				<!-- 게시판 목록 영역 -->

				<table border="1" summary="공지사항" align="center">

					<caption>공지사항</caption>

					<colgroup>

						<col width="50" />

						<col width="300" />

						<col width="80" />

						<col width="100" />

						<col width="70" />

					</colgroup>

					<thead>

						<tr>

							<th>번호</th>

							<th>제목</th>

							<th>작성자</th>

							<th>작성일</th>

							<th>조회수</th>

						</tr>

					</thead>

					<tbody>

						<tr>

							<td align="center" colspan="5"></td>

						</tr>

						<tr>

							<td align="center">001</td>

							<td><a href="boardView.jsp">치킨 먹자 </a></td>

							<td align="center">정소연</td>

							<td align="center">2019.10.09</td>

							<td align="center">10</td>




						</tr>

					</tbody>

					<tfoot>

						<tr>

							<td align="center" colspan="5">1</td>

						</tr>

					</tfoot>


				</table>
				<div align="right">
					<input type="button" value="목록" onclick="goUrl('boardList.jsp');" />
					<input type="button" value="글쓰기"
						onclick="goUrl('boardWriteForm.jsp');" />
				</div>
				<!-- //게시판 목록 영역 -->

				<!-- 버튼 영역 -->


				</p>
				<!-- 게시판 -->


				<div class="container">

					<div class="row">

						<form method="post" action="writeAction.jsp">

							<table class="table table-striped"
								style="text-align: center; border: 1px solid #dddddd">

								<thead>

									<tr>
										<table align="center">
											<th colspan="2"
												style="background-color: #eeeeee; text-align: center;">공지사항
												등록</th>

											</tr>

											</thead>

											<tbody>

												<tr>

													<td><input type="text" class="form-control"
														placeholder="글 제목" name="bbsTitle" maxlength="50" /></td>

												</tr>

												<tr>

													<td><textarea class="form-control" placeholder="글 내용"
															name="bbsContent" maxlength="2048" style="height: 200px;"></textarea></td>

												</tr>

											</tbody>

										</table>
										<div align="center">
											<input type="submit" class="btn btn-primary pull-right"
												value="저장" /> <input type="submit"
												class="btn btn-primary pull-right" value="닫기" />
										</div>
										</form>

										</div>

										</div>
</body>
</html>




