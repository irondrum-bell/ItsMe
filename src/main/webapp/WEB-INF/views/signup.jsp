<%@ page language="java" contentType="text/html; charset = UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<title>회원등록</title>
<!-- 다음 주소 API 사용 -->
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>


<!-- 여기까지 주소 API -->
<!-- Bootstrap -->
<link href="resources/css/signup/bootstrap.min.css" rel="stylesheet">
<!-- font awesome -->
<link rel="stylesheet" href="resources/css/signup/font-awesome.min.css"
	media="screen" title="no title" charset="utf-8">
<!-- Custom style -->
<link rel="stylesheet" href="resources/css/signup/style.css"
	media="screen" title="no title" charset="utf-8">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>


	<article class="container">
		<div class="page-header">
			<h1>회원 등록</h1>
		</div>
		<div class="col-md-6 col-md-offset-3">

			<table class="form-group">
				<label for="InputId">학번/사번</label>

				<td><input type="text" class="form-control" id="Id"
					placeholder="학번/사번"></td>
				<td><button type="submit" class="btn btn-info">
						중복확인<i class="fa fa-times spaceLeft"></i>
					</button></td>

			</table>

			<div class="form-group">
				<label for="InputAuthor">구분</label> <select class="form-control">
					<option>선택</option>
					<option>학생</option>
					<option>교수</option>
				</select>
			</div>

			<div class="form-group">
				<label for="InputBirth">생년월일</label> <input type="text"
					class="form-control" id="Birth" placeholder="생년월일">
				<p class="help-block">ex.ㅇㅇㅇㅇ-ㅇㅇ-ㅇㅇ</p>
			</div>

			<div class="form-group">
				<label for="username">이름</label> <input type="text"
					class="form-control" id="Name" placeholder="이름을 입력해 주세요">
			</div>

			<div class="form-group">
				<label for="InputNumber">전화 번호</label> <input type="text"
					class="form-control" id="PhoneNum" placeholder="전화 번호를 입력해 주세요">
				<p class="help-block">'-' 없이 입력해 주세요.</p>
			</div>

			<div class="form-group">
				<label for="InputAdress">주소</label>
				<table>
					<tr>
						<td><input type="text" name="zip" class="form-control" readonly></td>
						<td><button type="button" class="btn btn-info"
								onclick="openZipSearch()">검색</button></td>
					</tr>
				</table>
				<br> <input type="text" name="addr1" class="form-control"
					readonly /> <br> <input type="text" name="addr2"
					class="form-control" />


				<div class="form-group">
					<label for="InputAuthor">소속/학과</label> <select class="form-control">
						<option>선택</option>

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
					</select>
				</div>

				<div class="form-group">
					<label for="InputBirth">파일첨부</label> <input type="file"
						id="ex_file" class="form-control">
				</div>


				<div class="form-group text-center">
					<button type="submit" class="btn btn-info">
						회원등록<i class="fa fa-check spaceLeft"></i>
					</button>
					<button type="reset" class="btn btn-warning">
						초기화<i class="fa fa-times spaceLeft"></i>
					</button>
				</div>
			</div>
	</article>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>

<script type="text/javascript">
<!-- 주소 api 사용 -->
	function openZipSearch() {
		new daum.Postcode({
			oncomplete : function(data) {
				$('[name=zip]').val(data.zonecode); // 우편번호 (5자리)
				$('[name=addr1]').val(data.address);
				$('[name=addr2]').val(data.buildingName);
			}
		}).open();
	}
</script>
