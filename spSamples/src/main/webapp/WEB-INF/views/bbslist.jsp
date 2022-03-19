<%@page import="mul.camp.a.dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!  /* ! 표시는 선언부다  */
// 답글의 depth와 image를 추가해 주는 함수
// depth 1 = ' ' 해주고 arrow image
// depth 2 = '  ' 해주고 arrow image
public String arrow(int depth) {
	String res = "<img src='image/arrow.png' width='20px' height='20px' />";	// 이미지
	String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";	// 여백
	
	String ts = "";
	for(int i=0; i<depth; i++) {
		ts += nbsp;
	}
	
	return depth==0? "":ts+res;
}

%>

<%
List<BbsDto> bbslist = (List<BbsDto>)request.getAttribute("bbslist");
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

<h1>게시판</h1>

<div align="center">

<hr>
<select id="choice">
	<option value="title">제목</option>
	<option value="content">내용</option>
	<option value="writer">작성자</option>
</select>

<input type="text" id="search" value="">

<button type="button" onclick="searchBbs()">검색</button>
<br><hr><br>

<table class="table table-hover" border="1" style="width:1000px">	<!--style-> attribute , width -> property  -->
<!-- <col width="30"><col width="200"><col width="80"> -->
<thead>
	<th>번호</th><th>제목</th><th>정보</th><th>작성자</th>
</thead>

<tbody>
<%
if(bbslist == null || bbslist.size() == 0) {
	%>
	<tr>
		<td colspan="4"> 작성된 글이 없습니다</td>
	</tr>
	<%
}else {
	for(int i=0; i<bbslist.size(); i++) {
		BbsDto bbs = bbslist.get(i);
	%>	
		<tr>
			<th><%=i+1 %></th>
			<td>
				<%= arrow(bbs.getDepth()) %>
				<a href="bbsdetail.do?seq=<%=bbs.getSeq() %>">		<!-- bbsdetail로 갈때 seq번호 가져가라 -->
					<%=bbs.getTitle() %>
				</a>
			</td>
			<td><%=bbs.getRef() %>-<%=bbs.getStep() %>-<%=bbs.getDepth() %></td>
			<td><%=bbs.getId() %></td>
		</tr>
	<%
	}
}
%>

	
</tbody>

</table>

</div>
<br>
<div align="center">
	<a href="bbswrite.do">글쓰기</a>
</div>

<script type="text/javascript">
function searchBbs() {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;
	
	location.href = "bbslist.do?choice=" + choice + "&search=" + search;	// choice는 choice대로 search는 search대로 넘어감.
}
</script>


</body>
</html>