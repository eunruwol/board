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
.board_create_container {	
	box-sizing:border-box;
	width:70%;
	height:auto;
	float:left;
	margin-top:1px;	
}
.board_create_container > .titleDiv {
	width:100%;margin-left:20px;height:auto;padding:40px 0px 10px 0px;
	border-bottom:2px solid rgba(128, 128, 128, 0.5);
}
.board_create_container > .titleDiv > h3{display:block;font-size:30px;font-weight:400;}
.board_create_container > .titleDiv > h3 > span{color:#929191;font-size:17px;margin-left:10px;}
.board_create_table {
	margin: 20px 0px 25px 20px;
	border-collapse:collapse;
	width:100%;
}

.board_create_table > tbody > tr > td {
	border:1px solid rgba(128, 128, 128, 0.3);
	padding:10px;
}
.boardName{display:block;line-height:20px;font-size:18px;color:#333;}
.board_input{border:none;outline:none;font-size:18px;color:#333;}
.board_user_select {
	border:none;outline:none;font-size:15px;color:#333;
}
.boardCreateSubmit {
	width:100%;background-color:#4286f4;color:#fff;border:none;font-size:16px;
	letter-spacing:-1px;padding:15px;
}
.board_create_tables {
	margin: -1px 0px 0px 20px;
	border-collapse:collapse;
	width:100%;
}
.board_create_tables > tbody > tr > td {
	border:1px solid rgba(128, 128, 128, 0.3);
	padding:10px;
}
</style>
</head>

<body>
<%@ include file="../header.jsp" %>
<div class="all_container">
	<%@ include file="../left.jsp" %>
	<div class="board_create_container">
		<div class="titleDiv">
			<h3>게시판 생성<span>게시판을 정보를 생성할 수 있습니다.</span></h3>
		</div>
		
		<!-- 게시판 추가 -->
		<form action="/boardInsert" method="post">
			<input type="hidden" name="userId" value="${userVo.userId}" />
			<table border="1" class="board_create_table">
				<tr>
					<td><span class="boardName">게시판이름</span></td>
					<td><input type="text" name="board_name" class="board_input" /></td>
					<td>
						<select name="board_use" class="board_user_select">
							<option value="Y" name="Y">사용</option>
							<option value="N" name="N">미사용</option>
						</select>
					</td>
					<td style="padding:0px !important;">
						<input type="submit" value="생성" class="boardCreateSubmit" />
					</td>
				</tr>
			</table>
		</form>
		
		<!-- 게시판 목록 -->
		<c:forEach items="${boardList}" var="vo">
			<form action="/boardUpdate" method="post">
				<input type="hidden" name="userId" value="${userVo.userId}" />
				<table border="1" class="board_create_tables">
					<tr>
						<td>
							<span class="boardName">게시판이름</span>
							<input type="hidden" name="board_id" value="${vo.board_id}" />
						</td>
						<td>
							<input type="text" name="board_name" value="${vo.board_name}" class="board_input" />
						</td>
						<td>
							<select name="board_use" class="board_user_select">
								<option value="Y" ${vo.board_use == 'Y' ? 'selected' : ''}>사용</option>
								<option value="N" ${vo.board_use == 'N' ? 'selected' : ''}>미사용</option>
							</select>
						</td>
						<td style="padding:0px !important;">
							<input type="submit" value="수정" class="boardCreateSubmit" />
						</td>
					</tr>
				</table>
			</form>
		</c:forEach>
	</div>
</div>
</body>
</html>
