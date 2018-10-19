<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../header.jsp" %>
<style type="text/css">
.insertList {
	float:left;
	width:70%;
	height:auto;
	margin-top:10px;
}
.insertList > .titleDiv {
	width:100%;margin-left:20px;height:auto;padding:40px 0px 10px 0px;
	border-bottom:2px solid rgba(128, 128, 128, 0.5);
}
.insertList > .titleDiv > h3{display:block;font-size:30px;font-weight:400;}
.insertList > .titleDiv > h3 > span{color:#929191;font-size:17px;margin-left:10px;}
.secondTitle > h3{margin:40px 0px 0px 20px;font-weight:500;font-size:22px;}
.insertTable {width:100%;margin:5px 0px 0px 20px;}
.insertTable {border-top:1px solid #333;}
.insertTable > tbody > tr > td {padding:10px 10px 10px 10px;}
.insertTable > tbody > tr > .insertTableTitles {
	text-indent:10px;background-color:#f6f6f6;font-size:18px;font-weight:bold;
}
.insertTables {width:100%;margin:5px 0px 0px 20px;}
.insertTables {border-top:1px solid #333;}
.insertTables > tbody > tr > td {padding:10px 10px 10px 10px;}
.insertTables > tbody > tr > .insertTableTitles {
	text-indent:10px;background-color:#f6f6f6;font-size:18px;font-weight:bold;
}

.width-md{width:150px !important;}
.width-xl{width:250px !important;}

.insertInputs {
	outline:none;border:1px solid #ccc;padding:5px 0px 5px 0px;
	color:#000;text-indent:10px;font-size:18px;
}
.pwspan{margin-left:20px;}

.listAndSubmitButton {
	width:100%;height:50px;margin:20px 0px 0px 20px;
}
.listAndSubmitButton > .listGoMok {
	text-decoration:none;text-align:center;line-height:40px;font-size:18px;
	display:block;width:90px;height:40px;background-color:#4286f4;color:#fff;
	float:left;border-radius:5px;font-weight:400;cursor:pointer;
}
.listAndSubmitButton > .listGoSubmitButton {
	font-family:'NanumSquare', sans-serif;
	width:90px;height:40px;background-color:#4286f4;color:#fff;border:none;
	float:right;font-size:18px;border-radius:5px;cursor:pointer;
}
.removeFileButton {
	border:none;background-color:#4286f4;color:#fff;width:40px;height:40px;
	font-size:18px;float:right;margin-left:10px;
}
.addFileButton {
	border:none;background-color:#4286f4;color:#fff;width:40px;height:40px;
	font-size:18px;float:right;
}
.h3file > span {color:#929191;font-size:17px;margin-left:10px;}
</style>
</head>

<body>
<div class="all_container">
	<%@ include file="../left.jsp" %>
	<div class="insertList">
		<div class="titleDiv">
			<h3>${boardVo.board_name}</h3>
		</div>
		
		<form action="/postInsert" method="post" enctype="multipart/form-data">
			<input type="hidden" name="board_id" value="${boardVo.board_id}" />
			<div class="secondTitle">
				<h3>기본 정보</h3>
				<table cellspacing="0" cellpadding="0" class="insertTable">
					<colgroup>
						<col class="width-md" />
						<col class="width-xl" />
						<col class="width-md" />
					</colgroup>
					<tr>
						<td class="insertTableTitles">작성자</td>
						<td>
							<input type="text" name="userId" value="${userVo.userId}" class="insertInputs" placeholder="작성자 입력" readonly />
						</td>
						<td class="insertTableTitles">제목</td>
						<td>
							<input type="text" name="post_tit" class="insertInputs" placeholder="제목 입력" />
						</td>
					</tr>
				</table>
				
				<h3>내용</h3>
				<table cellspacing="0" cellpadding="0" class="insertTable">
					<colgroup>
						<col class="width-md" />
					</colgroup>
					<tr>
						<td class="insertTableTitles">게시물 내용</td>
						<td>
							<textarea name="post_con" id="smarteditor" rows="30" cols="100"></textarea>
						</td>
					</tr>
				</table>
				
				<script src="/SE2/js/HuskyEZCreator.js"></script>
				<script type="text/javascript">
				var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.
				
				$(document).ready(function() {
					// Editor Setting
					nhn.husky.EZCreator.createInIFrame({
						oAppRef : oEditors, // 전역변수 명과 동일해야 함.
						elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
						sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
						fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
						htParams : {
							// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
							bUseToolbar : true,
							// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
							bUseVerticalResizer : true,
							// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
							bUseModeChanger : true, 
						}
					});
				
					// 전송버튼 클릭이벤트
					$("button[type=submit]").click(function(){
						if(confirm("저장하시겠습니까?")) {
							// id가 smarteditor인 textarea에 에디터에서 대입
							oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
						}
					});
				});
				
				// 필수값 Check
				function validation(){
					var contents = $.trim(oEditors[0].getContents());
					if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
						alert("내용을 입력하세요.");
						oEditors.getById['smarteditor'].exec('FOCUS');
						return false;
					}
				
					return true;
				}
				
				</script>
				
				<h3 class="h3file">파일 업로드<span>파일 첨부는 총 5개까지 가능합니다.</span></h3>
				<table cellspacing="0" cellpadding="0" class="insertTables">
					<colgroup>
						<col class="width-md" />
					</colgroup>
					<tr>
						<td class="insertTableTitles" rowspan="5">파일 첨부</td>
						<td class="fileList">
							<input type="file" name="file-1" />
						</td>
						<td>
							<input type="button" id="removeFile" class="removeFileButton" value="-" />
							<input type="button" id="addFile" class="addFileButton" value="+" />							
						</td>
					</tr>
				</table>
				
				<input type="hidden" name="listSize" id="listSize" />
				<script type="text/javascript">
					$(function(){
						var listSize = $(".insertTables").length;
						var fileName = 2;
						
						$("#listSize").val(listSize);
						
						$("#addFile").click(function(){
							if(listSize < 5){
								$("table.insertTables").append("<tr><td><input type=\"file\" name=\"file-" + fileName + "\"></td></tr>");
								listSize++;
								fileName++;
								
								$("#listSize").val(listSize);
							}else{
								alert("첨부파일은 5개까지만 추가 가능합니다.");
							}
						});
						
						$("#removeFile").click(function(){
							if(listSize > 1){
								$("table.insertTables tr:last-child").remove();
								listSize--;
								fileName--;
								
								$("#listSize").val(listSize);
							}
						});
					});
				</script>
				
				<div class="listAndSubmitButton">
					<a href="javascript:history.back()" class="listGoMok">목록</a>
					<button type="submit" class="listGoSubmitButton">등록</button>
				</div>
			</div>
		</form>
	</div>
</div>
</body>
</html>