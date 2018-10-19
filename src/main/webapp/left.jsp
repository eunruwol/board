<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="leftcontainer">
	<div class="board_icon">
		<h3>BOARD LIST</h3>
	</div>
	<div class="board_list">
		<ul>
			<li class="leftListli"><a href="/boardList">게시판 생성</a></li>
			<c:forEach items="${boardList}" var="vo">
				<c:choose>
					<c:when test="${vo.board_use == 'Y'}">
						<li><a href="/postList?board_id=${vo.board_id}">${vo.board_name}</a></li>
					</c:when>
					<c:when test="${vo.board_use == 'N'}">
						<li class="close"><a href="/postList?board_id=${vo.board_id}">${vo.board_name}</a></li>
					</c:when>
				</c:choose>
			</c:forEach>
		</ul>
	</div>
</div>