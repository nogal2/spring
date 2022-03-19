<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<form action="insertAf.jsp">
아이디:<input type="text" id="id" name="id" ><br>
패스워드:<input type="text" id="pwd" name="pwd">
<br><br>

취미<br>
<label><input type="checkbox" id="sleep" name="hobby" value="잠자기">잠자기</label>
<label><input type="checkbox" id="game" name="hobby" value="게임하기">게임하기</label>
<label><input type="checkbox" id="sing" name="hobby" value="노래하기">노래하기</label>
<br><br>
연령대<br>
<label><input type="radio" name="age" value="10대">10대</label>
<label><input type="radio" name="age" value="20대">20대</label>
<label><input type="radio" name="age" value="30대">30대</label>
<label><input type="radio" name="age" value="40대">40대</label>
<label><input type="radio" name="age" value="50대">50대</label>
<label><input type="radio" name="age" value="60대 이상">60대 이상</label>
<br><br>
기타 하고싶은말<br>
<textarea rows="5" cols="60" name="comment"></textarea>
<br>
<input type="submit" value="전송">
<input type="button" id="cancel" value="취소">
</form>
<script type="text/javascript">
$("#cancel").click(function () {
	$("#id").val("");
	$("#pwd").val("");
	$("input:checkbox[name='hobby']").prop("checked", false);
	$("input:radio[name='age']").prop("checked", false);
})
</script>

</body>
</html>