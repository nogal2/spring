<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style type="text/css">
.center {
	margin: auto;
	width: 60%;
	border: 3px solid #0000ff;
	padding: 10px;
}

</style>
</head>
<body>
<h2>회원가입</h2>

<div class="center">
	<form id="frm" action="regiAf.do" method="post">
		<table border="1">
		<tr>
			<th>아이디</th>
			<td>
				<input type="text" name="id" id="id" size="20">&nbsp;<input type="button" id="btn" value="확인"><br>
				<p id="idcheck" style="font-size: 8px"></p>		
			</td>
		</tr>
		<tr>
			<th>패스워드</th>
			<td>
				<input type="text" name="pwd" id="pwd" size="20">
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="name" id="name" size="20">
			</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>
				<input type="text" name="email" id="email" size="20">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<!-- <input type="submit" value="회원가입"> -->
				<button type="button" onclick="account()">회원가입</button>
			</td>
		</tr>
		</table>
	</form>
</div>
<script type="text/javascript">
$(document).ready(function() {	// .ready() 는 문서가 디자인을 입히기 전에 시작하는 것.
	
	$("#btn").click(function() {
		let id = $('#id').val();
		$.ajax({
			url:"idcheck.do",
			type:"post",
			data:{"id":id},	// {id:$("#id").val()}
			success: function(rep) {
			//	alert('success');
				if(rep == "YES") {
					$("#idcheck").css("color", "#0000ff");
					$("#idcheck").html("사용할 수 있는 아이디입니다.");
				}else {
					$("#idcheck").css("color", "#ff0000");
					$("#idcheck").html("사용 중인 아이디입니다.");
					$("#id").val("");
				}
			},
			error:function(){
		        alert('error');

			}
		});
	});
});

function account() {
//	alert('account');
	if($('#id').val() == '') {
		alert('아이디를 입력해 주십시오');
	}
	else if($("#pwd").val() == '') {
		alert('패스워드를 입력해 주십시오');
	}
	else if($("#name").val() == '') {
		alert('이름을 입력해 주십시오');
	}
	else if($("#email").val() == '') {
		alert('이메일을 입력해 주십시오');
	}
	else {
		$("#frm").submit();
	}
// 자바스크립트 없이 form으로만 submit을 하면 전부 제출하기 때문에 null값 예외 에러가 뜬다. 그래서 이걸 자바스크립트에서 제어해줘야한다.
// 그걸 위해서 input대신 button에 button type 으로 해서 자바스크립트에서 제어 후 제출해주면 된다.
	
}

</script>

</html>