<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


<style type="text/css">
.center {
	margin: auto;
	width: 60%;
	border: 3px solid #0000ff;
	padding: 10px;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>
</head>
<body>

<h2>login page</h2>

<div class="center">
	<form id="frm" action="loginAf.do" method="post" >
	<table border="1">
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" id="id" name="id" size="20"><br>
					<input type="checkbox" id="chk_save_id">아이디 저장
				</td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td>
					<input type="password" id="pwd" name="pwd" size="20">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<!-- <input type="button" id="login" value="로그인"> -->
					<button type="button" onclick="login()">로그인</button>
					<a href="regi.do">회원가입</a>
				</td>
			</tr>
	</table>
	</form>

</div>
<script type="text/javascript">
function login() {

	if($('#id').val().trim() == '') {
		alert('아이디를 입력해 주십시오');
	}
	else if($("#pwd").val().trim() == '') {
		alert('패스워드를 입력해 주십시오');
	}else {
		alert('submit');
		$("#frm").submit();
	}
	
	
};

/*
	web 저장공간
		session: web server의 저장공간.		java		사용자정보 -> object
		cookie: web client의 저장공간.		javascript	id, pw, 방문횟수 -> String
		
*/

let user_id = $.cookie("user_id");	// cookie에서 데이터를 산출
									// model.addattribute("list", list)
if(user_id != null) {	// cookie에 저장된 값이 있음
	$("#id").val(user_id);	
//	$("#chk_save_id").attr("checked", "checked"); //attr("키값", "속성값")
	$("#chk_save_id").prop("checked", true);
}	
$("#chk_save_id").click(function () {
//	alert("click");
	if($("#chk_save_id").is(":checked")) { // 체크 되었을 경우.
		if($("#id").val().trim() == "") {	// .trim() -> 앞 뒤 공백제거(중간은 안해줌)
			alert("id를 입력해 주십시오");
			$("#chk_save_id").prop("checked", false);
			$("#id").val("");
		}else {
			//쿠키에 저장
			$.cookie("user_id", $("#id").val().trim(), {expires:7, path:'./'})	//{expires:7, path:'./'} -> 7일간 저장하고 어떠한 경로에서든 가져와라.
		}
	}else {
	//	alert("체크무효");
		$.removeCookie("user_id", {path:'./'});	// expires를 안해주면 지워진다.
	}
});

</script>
</body>
</html>