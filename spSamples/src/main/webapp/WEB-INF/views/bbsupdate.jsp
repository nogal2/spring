<%@page import="mul.camp.a.dto.MemberDto"%>
<%@page import="mul.camp.a.dto.BbsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
BbsDto bbs = (BbsDto)request.getAttribute("bbs");

MemberDto mem = (MemberDto)request.getSession().getAttribute("login");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<h1>부모글</h1>
<form action="updateAf.do" method="get">
<input type="hidden" name="seq" value="<%=bbs.getSeq() %>" >
	<table class="table table-bordered" style="width:1000px">

		<tr>
			<th>작성자</th>
			<td><%=mem.getId() %></td>
		</tr>
		
		<tr>
			<th>제목</th>
			<td ><input type="text" name="title" size="115" value="<%=bbs.getTitle() %>"></td>
		</tr>
		
		<tr>
			<th>작성일</th>
			<td><%=bbs.getWdate() %></td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td align="center">
			<textarea type="text" name="content" rows="15" cols="100" ><%=bbs.getContent() %></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="수정하기">
			</td>
		</tr>
		
	</table>
</form>
</body>
</html>