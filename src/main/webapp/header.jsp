<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="https://ssl.gstatic.com/docs/documents/images/kix-favicon6.ico">
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumSquare@1.0/nanumsquare.css">
<link href="css/reset.css" rel="stylesheet">
<link href="css/main.css" rel="stylesheet">
<style type="text/css">
.all_container {
	width:100%;
	height:auto;
	padding-top:50px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
</head>

<body>
<div class="header">
	<div class="header_left">
		<h4><a href="main.jsp">IKS BOARD</a></h4>
	</div>
	<div class="header_right">
		<h4>
			<c:if test="${userVo.name != null}">
				<span class="highright">${userVo.name}</span> 님 안녕하세요
			</c:if>
		</h4>
		<div class="logout">
			<a href="/logout">LOGOUT</a>
		</div>
	</div>
</div>