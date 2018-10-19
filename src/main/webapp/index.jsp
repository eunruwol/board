<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
<link href="css/reset.css" rel="stylesheet">
<link rel="shortcut icon" href="https://ssl.gstatic.com/docs/documents/images/kix-favicon6.ico">
<style type="text/css">
body{background-color:#f2f2f2;font-family:'Lato', sans-serif}
.wrap{width:500px;height:800px;margin:100px auto;}
.title{width:500px;height:100px;margin:0 auto;}
.title > h2 {
	font-size:30px;letter-spacing:1px;font-weight:normal;text-align:center;
	line-height:100px;color:#4286f4;
}
.loginchk {
	display:block;float:left;width:30px;height:30px;
	outline:none;border:none;border:1px solid #4286f4;
	margin-top:10px;
}
.remember {
	display:block;width:300px;height:30px;line-height:30px;color:#4284f4;
	margin-top:10px;text-indent:10px;font-size:20px;
}
.idinput {
	box-sizing:border-box;outline:none;width:500px;height:50px;
	text-indent:10px;font-size:16px;border:1px solid #4286f4;
	border-radius:5px 5px 0px 0px;
}
.pwinput {
	box-sizing:border-box;outline:none;width:500px;height:50px;
	text-indent:10px;font-size:16px;border:1px solid #4286f4;
	margin-top:-1px;border-radius:0px 0px 5px 5px;
}
.signin {
	box-sizing:border-box;outline:none;width:500px;height:60px;
	background-color:#4286f4;color:#fff;border:none;margin-top:40px;
	font-size:20px;cursor:pointer;
	border-radius:10px 0px 10px 0px;
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>
<script type="text/javascript">
function getCookie(cookieName){
	var cookies = document.cookie.split("; ");
	
	var cookieValue = "";
	for(var i=0; i<cookies.length; i++){
		var str = cookies[i];
		if(str.startsWith(cookieName + "=")){
			var str = cookies[i];
			cookieValue = str.substring((cookieName + "=").length);
		}
	}
	return cookieValue;
}

$(document).ready(function(){
	if(getCookie("remember") == "Y"){
		$("#rememberMe").attr("checked", true);
		$("#userId").val(getCookie("userId"));
	}
	if(getCookie("remember") == "Y"){
		document.getElementById("rememberMe").checked = true;
	}
});
</script>
</head>

<body>
<form action="/iksLogin" method="post">
<div class="wrap">
	<div class="title">
		<h2>IKS BOARD</h2>
	</div>
	
	<div class="container">
		<input type="text" id="userId" name="userId" class="idinput" value="brown" placeholder="INPUT USER ID" />
		<input type="password" id="password" name="password" class="pwinput" value="brownpass" placeholder="INPUT USER PASSWORD" />
		<input type="checkbox" id="rememberMe" name="rememberMe" value="rememberMe" class="loginchk" /><span class="remember">REMEMBER ID</span>
		<input type="submit" class="signin" value="SIGN IN" />
	</div>
</div>
</form>
</body>
</html>