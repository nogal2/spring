<%@page import="java.io.IOException"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<% 
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String hobby[] = request.getParameterValues("hobby");
	String hob = "없음";
	try{
		if (hobby.length == 1){
			hob = hobby[0];
		} else if (hobby.length == 2) {
			hob = hobby[0] + ", " + hobby[1];
		} else if (hobby.length == 3) {
			hob = hobby[0] + ", " + hobby[1] + ", " + hobby[2];
		} 
	} catch (NullPointerException e) {} 
	String age = request.getParameter("age");
	String comment = request.getParameter("comment");
%>

<p>아이디: <%=id %></p>
<p>패스워드: <%=pwd %></p>
<p>취미: <%=hob %></p>
<p>나이: <%=age %></p>
<p>상세내역: <%=comment %></p>
</body>
</html>