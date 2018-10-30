<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp" %>

<style type="text/css">
html{position:relative;min-height:100%;}
body{min-height:100%;}
.alls_container{width:1300px;min-width:1000px;padding-top:50px;height:1200px;}
.replyContainers{width:1200px;margin-left:215px;}
.detail_title{width:1000px;margin-left:20px;margin-top:50px;}
.detail_title > h2{font-size:30px;font-weight:100;color:#000;}

.detail_information{width:1000px;height:60px;border-bottom:1px solid rgba(128,128,128,0.3);margin-left:20px;margin-top:20px;}
.detail_profile{float:left;}
.detail_profile > img {border-radius:100%;width:50px;height:50px;}
.detail_user{float:left;height:50px;line-height:20px;font-size:17px;}
.detail_user > ul {display:block;margin-top:6px;margin-left:10px;}
.detail_user > ul > li:first-child{font-weight:bold;}
.listlifontcolor{color:#929191;font-weight:100;}
.detail_content{width:1000px;height:auto;border-bottom:1px solid rgba(128,128,128,0.3);margin-top:20px;margin-left:20px;font-weight:100;padding:20px 0px 20px 0px}
.detailReplyContainer{width:1000px;height:auto;margin-left:20px;margin-top:50px;}
.detailReplyContainer > .reply_detail_profile{float:left;width:50px;height:50px;}
.detailReplyContainer > .reply_detail_profile > img{border-radius:100%;width:50px;height:50px;}
.detailReplyContainer > .reply_detail_user{float:left;heihgt:50px;line-height:50px;}
.detailReplyContainer > .reply_detail_user > .replayInputLineGo {
	display:block;box-sizing:border-box;width:930px;height:50px;margin-left:20px;
	border:none;border-bottom:1px solid rgba(128,128,128,0.3);font-size:17px;outline:none;transition:0.5s;
}
.detailReplyContainer > .reply_detail_user > .replayInputLineGo:focus{border-bottom:1px solid #000;transition:0.5s;}
.reply_detail_submitButton{float:right;height:50px;margin-top:10px;}
.replyButtons{width:70px;height:40px;background-color:#4286f4;color:#fff;border:none;font-size:17px;border-radius:5px;cursor:pointer;}
.viewReplyContainer{width:1000px;height:50px;margin-left:20px;margin-top:140px;}
.viewReplyProfile {float:left;width:50px;height:50px;}
.viewReplyProfile > img{border-radius:100%;width:50px;height:50px;}
.viewReplyContainer > .reply_detail_user {float:left;}
.viewReplyContainer > .reply_detail_user > ul {display:block;heihgt:50px;}
.viewReplyContainer > .reply_detail_user > ul > li:first-child{font-weight:bold;}
.viewReplyContainer > .reply_detail_user > ul > li:last-child{color:#ccc;}
.viewReplyProfileList > ul > li{display:block;font-size:17px;margin-top:30px;}
.bold{font-weight:bold;}
.commentuserids{padding-top:10px;text-indent:20px;}
.dates{padding-left:20px;color:#929191;font-weight:100;}
.comment_contents{padding-left:70px;text-indent:80px;}
.replyDelBtn {
	border:none;background-color:#fff;color:#000;cursor:pointer;outline:none;
	margin-top:5px;margin-left:70px;
}
.detail_buttonss{float:left;height:50px;}
.detail_buttonss > ul > li{display:inline-block;padding:21.5px 5px 0px 5px;font-size:17px;}
.detail_buttonss > ul > li:first-child{margin-left:20px;}
.detail_buttonss > ul > li > a{text-decoration:none;color:#000;}
.viewReplyDeleteProfile{width:50px;height:50px;}
.viewReplyDeleteProfile > img{width:50px;height:50px;border-radius:100%;float:left;}
.deletermf{float:left;margin-left:20px;}
.deletermf > span{position:relative;top:-30px;left:50px;}
.btnDeletesa{border:none;background-color:#fff;font-size:17px;cursor:pointer;}
.filedivs{width:1000px;padding:10px 0px 5px 10px;margin-left:20px;border:1px solid rgba(128,128,128,0.3);margin-top:20px;}
.filedivs > ul > li > a{font-size:17px;color:#4286f4;}
.filedivs > h2{font-size:17px;padding:10px 0px 10px 0px;}
.notfound{font-size:17px;padding:10px 0px 10px 0px;}
</style>

<div class="all_container">
	<%@ include file="../left.jsp" %>
	<div class="replyContainers">
		<div class="detail_title">
			<h2>${postVo.post_tit}</h2>
		</div>
		
		<div class="detail_information">
			<div class="detail_profile">
				<img src="../images/default_profile.png" />
			</div>
			<div class="detail_user">
				<ul>
					<li>${postVo.userId}</li>
					<li class="listlifontcolor">${boardVo.board_name} <fmt:formatDate value="${postVo.post_date}" pattern="yyyy.MM.dd aa hh:mm" /></li>
				</ul>
			</div>
			<div class="detail_buttonss">
				<ul>
					<c:if test="${postVo.userId == userVo.userId}">
						<li><a href="/postUpdate">수정</a></li>
						<li><input type="button" class="btnDeletesa" value="지우기" /></li>
					</c:if>
					<li><a href="/postAnswer">답글</a></li>
					<li><a href="/postList?board_id=${boardVo.board_id}">목록</a></li>
				</ul>
			</div>
		</div>
		
		
		<div class="detail_content">
			<h3>${postVo.post_con}</h3>
		</div>
		
		<div class="filedivs">
			<h2>첨부파일 리스트</h2>
			<c:forEach items="${fileList}" var="file">
				<c:if test="${file.file_no == null}">
					<ul>
						<li class="notfound">첨부파일이 없습니다</li>
					</ul>
				</c:if>
				<c:if test="${file.file_no != null}">
					<ul>
						<li data-id="${file.file_no}"><a href="/fileDownload?fileName=${file.file_name}"><i></i> ${file.file_name}</a></li>
					</ul>
				</c:if>
			</c:forEach>
		</div>
		
		
		<form id="replyInsertForm" action="/commentInsert" method="post">
			<input type="hidden" name="post_no" value="${postVo.post_no}">
			<input type="hidden" name="userId" value="${userVo.userId}">
			<div class="detailReplyContainer">
				<div class="reply_detail_profile">
					<img src="../images/default_profile.png" />
				</div>
				<div class="reply_detail_user">
					<input type="text" name="re_con" class="replayInputLineGo" placeholder="댓글을 입력해주세요" />
				</div>
				<div class="reply_detail_submitButton">
					<button type="submit" class="replyButtons">댓글</button>
				</div>				
			</div>
		</form>
		
		<div class="viewReplyContainer">		
			<div class="viewReplyProfileList">
				<ul>
					<c:forEach items="${commentList}" var="comment">
					<li data-id="${comment.comment_id}">
						<c:choose>
							<c:when test="${comment.re_del == 'N'}">
								<div class="viewReplyProfile">
									<img src="../images/default_profile.png" />
								</div>
								<div class="commentuserids">
									<span class="bold">${comment.userId}</span><br>
									<span class="dates"><fmt:formatDate value="${comment.re_date}" pattern="yyyy-MM-dd aa hh:mm" /></span><br><br>
									<span class="comment_contents">${comment.re_con}</span><br>
								</div>							
								<c:if test="${comment.userId == userVo.userId}">
									<button type="button" class="replyDelBtn">지우기</button>
								</c:if>
							</c:when>
							<c:when test="${comment.re_del == 'Y'}">
								<div class="viewReplyDeleteProfile">
									<img src="../images/default_profile.png" />
								</div>
								<div class="deletermf">
									<span>삭제된 댓글입니다.</span>
								</div>									
							</c:when>
						</c:choose>
					</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		
		
		
	</div>
	
	
	
	

		
		<!-- 댓글 삭제 //-->
		<form id="replyDelForm" action="/commentDelete" method="post">
			<input type="hidden" id="coNo" name="comment_id">
			<input type="hidden" id="postNo" name="post_no" value="${postVo.post_no}">
		</form>
		<script type="text/javascript">
			$(function(){
				$(".replyDelBtn").on("click", function(){
					$("#coNo").val($(this).parent().data("id"));
					$("#replyDelForm").submit();
				});
			});
		</script>


	<form id="postDelForm" action="/postDelete" method="post">
		<input type="hidden" name="post_no" value="${postVo.post_no}" />
		<input type="hidden" name="board_id" value="${postVo.board_id}" />
	</form>
	<script type="text/javascript">
	$(function(){
		$(".btnDeletesa").click(function(){
			$("#postDelForm").submit();
		});
	});
	</script>
</div>
<%@ include file="../bottom.jsp" %>