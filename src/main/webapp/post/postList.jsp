<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../header.jsp" %>
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
.table_responsive {
	margin: 20px 0px 25px 20px;
	border-collapse:collapse;
	width:100%;
}

.table_responsive > .table_striped > thead > tr > td {
	border:1px solid rgba(128, 128, 128, 0.3);
	padding:5px;
}
.table_responsive > .table_striped > tbody > tr > td {
	border:1px solid rgba(128, 128, 128, 0.3);
	padding:5px;
}
</style>

<div class="all_container">
	<%@ include file="../left.jsp" %>
	<div class="board_create_container">
		<div class="titleDiv">
			<h3>${boardVo.board_name}</h3>
		</div>
		
		<div class="table_responsive">
			<table id="postListTable" class="table_striped" cellspacing="0">
				<colgroup>
					<col width="10%">
					<col width="60%">
					<col width="10%">
					<col width="20%">
				</colgroup>
				<thead>
					<tr>
						<td>NO</td>
						<td>제목</td>
						<td>작성자</td>
						<td>작성일시</td>
					</tr>
				</thead>
				<tbody>
					<% request.setAttribute("nbsp", " "); %>
					<c:forEach items="${postList}" var="post" varStatus="status">
						<c:choose>
							<c:when test="${post.post_del == 'N'}">
								<tr data-id="${post.post_no}">
									<td>${status.index+1}</td>
									<td>${fn:replace(post.post_tit, nbsp, '&nbsp;')}</td>
									<td>${post.userId}</td>
									<td><fmt:formatDate value="${post.post_date}" pattern="yyyy-MM-dd" /></td>
								</tr>
							</c:when>
							<c:when test="${post.post_del == 'Y'}">
								<tr class="table_close">
									<td>${status.index+1}</td>
									<td>삭제된 게시글 입니다.</td>
									<td>${post.userId}</td>
									<td><fmt:formatDate value="${post.post_date}" pattern="yyyy-MM-dd" /></td>
								</tr>
							</c:when>
						</c:choose>
					</c:forEach>
				</tbody>
			</table>
			
			<!-- 게시글 상세보기 -->
			<form id="postListForm" action="/postDetail" method="get">
				<input type="hidden" id="post_no" name="post_no" />
			</form>
			<script type="text/javascript">
			$(function(){
				$("#postListTable tbody tr[data-id]").on("click", function(){
					$("#post_no").val($(this).data("id"));
					$("#postListForm").submit();
				});
			});
			</script>
		</div>
		
		<form id="postInsertBtn" action="/postInsert" method="get">
			<input type="hidden" name="board_id" value="${boardVo.board_id}" />
			<input type="hidden" name="userId" value="${userVo.userId}" />
			<button type="submit">새글쓰기</button>
		</form>
		
		<div class="textCenter">
			<ul class="pagination">
				<%=request.getAttribute("pageNavi") %>
			</ul>
		</div>
	</div>
</div>
</body>
</html>