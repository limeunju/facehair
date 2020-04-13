<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>회원 정보 수정 및 탈퇴 Page</title>
<link rel="shortcut icon"
	href="${ pageContext.request.contextPath }/resources/images/logo/favicon-16x16.png"
	type="image/x-icon" />
<link rel="icon"
	href="${ pageContext.request.contextPath }/resources/images/logo/favicon-16x16.png"
	type="image/x-icon" />
<style>
@import url(https://fonts.googleapis.com/css?family=Roboto:300);

.Xcontent {
	min-height: calc(100vh - 20px);
	background-color: #FEDDDF;
}

.update-page {
	width: 360px;
}

.form {
	position: relative;
	z-index: 1;
	background: #FFFFFF;
	max-width: 360px;
	margin: 0 auto 10px;
	padding: 45px;
	text-align: center;
	box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0
		rgba(0, 0, 0, 0.24);
}

.form input {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f2f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form select {
	font-family: "Roboto", sans-serif;
	outline: 0;
	background: #f5f2f2;
	width: 100%;
	border: 0;
	margin: 0 0 15px;
	padding: 15px;
	box-sizing: border-box;
	font-size: 14px;
}

.form button {
	font-family: "Roboto", sans-serif;
	text-transform: uppercase;
	outline: 0;
	background: rgba(0, 128, 0, 0.575);
	width: 100%;
	border: 0;
	padding: 15px;
	color: #FFFFFF;
	font-size: 14px;
	-webkit-transition: all 0.3 ease;
	transition: all 0.3 ease;
	cursor: pointer;
}

.form button:hover, .form button:active, .form button:focus {
	background: green;
}

.form #deleteBtn {
	background: rgba(239, 58, 58, 0.562);
}

.form #deleteBtn:hover, .form #deleteBtn:active, .form #deleteBtn:focus
	{
	background: #EF3B3A;
}

.form .message {
	margin: 15px 0 0;
	color: #b3b3b3;
	font-size: 12px;
}

.form .message a {
	color: #ff666f;
	text-decoration: none;
}

.container {
	position: relative;
	z-index: 1;
	max-width: 300px;
	margin: 0 auto;
}

.container:before, .container:after {
	content: "";
	display: block;
	clear: both;
}

.container .info {
	margin: 50px auto;
	text-align: center;
}

.container .info h1 {
	margin: 0 0 15px;
	padding: 0;
	font-size: 36px;
	font-weight: 300;
	color: #1a1a1a;
}

.container .info span {
	color: #4d4d4d;
	font-size: 12px;
}

.container .info span a {
	color: #000000;
	text-decoration: none;
}

.container .info span .fa {
	color: #EF3B3A;
}

body {
	background: #FEDDDF;
	/* fallback for old browsers */
	background: -webkit-linear-gradient(right, #FEDDDF, #FFFFFF);
	background: -moz-linear-gradient(right, #FEDDDF, #FFFFFF);
	background: -o-linear-gradient(right, #FEDDDF, #FFFFFF);
	background: linear-gradient(to left, #FEDDDF, #FEDDDF);
	font-family: "Roboto", sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}

select:invalid {
	color: gray;
}

#headLine {
	font-family: 'Nanum Myeongjo', serif;
}

form #joinId, #dateOfBirth {
	background-color: darkgray;
}
</style>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.2.0/css/all.css">
<link
	href="https://fonts.googleapis.com/css?family=Nanum+Myeongjo&display=swap"
	rel="stylesheet">
<script
	src="${ pageContext.request.contextPath }/resources/js/jquery-3.4.1.min.js"></script>
<%@ include file="../common/headerUtil.jsp"%>
</head>

<body>
	<%@ include file="../common/header.jsp"%>
	
	<br /><br /><br /><br /><br />
	<br /><br /><br />

	<div class="Xcontent" align="center">
		<div">
			<div class="update-page">
				<h3 id="headLine">회원정보수정</h3>
				<div class="form">
					<form class="register-form"
						action="${pageContext.request.contextPath }/update.me"
						method="post">
						<input type="text" id="joinId" name="joinId"
							placeholder=${member.userId } readonly /> <input type="password"
							id="JoinPwd" name="JoinPwd" placeholder="비밀번호" required /> <input
							type="password" id="pwd_confirm" name="pwd_confirm"
							placeholder="비밀번호 확인" required /> <input type="text" id="name"
							name="name" placeholder="닉네임" value=${member.userName } required />
						<input type="email" id="email" name="email" placeholder="이메일"
							value=${member.email } required /> <input type="text"
							id="dateOfBirth" placeholder=${member.dateOfBirth } disabled />
						<select required name="gender" id="gender">
							<option value="" disabled selected hidden>성별</option>
							<option value="M">Male</option>
							<option value="F">Female</option>
						</select> <input type="tel" id="phone" name="phone"
							placeholder="00*-000*-0000" value=${member.phone } required
							pattern="[0-9]{2,3}-[0-9]{3,4}-[0-9]{4}" />
						<button type="submit">수정완료</button>
						&nbsp;
						<button type="button" id="deleteBtn">탈퇴하기</button>
				</div>
			</div>
		</div>

		<script>
			$(".register-form")
					.submit(
							function(event) {
								if ($("#joinPwd").val() == ""
										|| $("#name").val() == ""
										|| $("#email").val() == "")
									alert("양식을 모두 작성하지 않았습니다.");
								else if ($('#JoinPwd').val() != $(
										'#pwd_confirm').val())
									alert("비밀번호 확인 값이 일치하지 않습니다.");
								else
									return;
								event.preventDefault();
							});

			$("#deleteBtn")
					.click(
							function() {
								var result = window.confirm("정말로 탈퇴하십니까?")

								if (result) {
									location.href = "${pageContext.request.contextPath}/delete.me?mid=${member.userId}";
								}

							})

			$(
					'input[type="date"], input[type="datetime"], input[type="datetime-local"], input[type="month"], input[type="time"], input[type="week"]')
					.each(function() {
						var el = this, type = $(el).attr('type');
						if ($(el).val() == '')
							$(el).attr('type', 'text');
						$(el).focus(function() {
							$(el).attr('type', type);
							el.click();
						});
						$(el).blur(function() {
							if ($(el).val() == '')
								$(el).attr('type', 'text');
						});
					});
		</script>
	
	</div>
	
	<%@ include file="../common/footer.jsp"%>
	<%@ include file="../common/footerUtil.jsp"%>
</body>

</html>