<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IKS BOARD</title>
<style type="text/css">
img.wp-smiley,img.emoji {
	display:inline !important;border:none !important;box-shadow:none !important;height:1em !important;
	width:1em !important;margin:0 .07em !important;vertical-align:-0.1em !important;background:none !important;padding:0 !important;
}
</style>
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumSquare@1.0/nanumsquare.css">
<link rel='stylesheet' id='cocoon-bootstrap-css-css'  href='http://cocoon.co.il/wp-content/themes/cocoon/css/bootstrap.min.css' type='text/css' media='all' />
<link rel='stylesheet' id='cocoon-bootstrap-rtl-css-css'  href='http://cocoon.co.il/wp-content/themes/cocoon/css/bootstrap-rtl.min.css' type='text/css' media='all' />
<link rel='stylesheet' id='cocoon-fontawesome-css'  href='http://cocoon.co.il/wp-content/themes/cocoon/css/fontawesome.min.css' type='text/css' media='all' />
<link rel='stylesheet' id='cocoon-slick-css-css'  href='http://cocoon.co.il/wp-content/themes/cocoon/css/slick.css' type='text/css' media='all' />
<link rel='stylesheet' id='cocoon-fancybox-css-css'  href='http://cocoon.co.il/wp-content/themes/cocoon/css/fancybox.min.css' type='text/css' media='all' />
<link rel='stylesheet' id='cocoon-style-css'  href='css/style.css' type='text/css' media='all' />
<link rel="stylesheet" href="http://cocoon.co.il/wp-content/themes/cocoon/rtl.css" type="text/css" media="screen" />
<meta name="generator" content="WordPress 4.9.8" />
<style type="text/css">
.recentcomments a{display:inline !important;padding:0 !important;margin:0 !important;}
</style>
</head>

<body class="rtl home blog hfeed">
<div id="page" class="site">
	<header id="masthead" class="site-header">
		<div class="row no-gutters align-items-center">
			<div class="col">
				<button class="hamburger"><span></span></button>
				<div class="menu-wrapper">
					<div class="menu-wrapper-logo">
						<img src="http://placehold.it/1200x500" />						
					</div>
					<div class="d-flex fullheight flex-column justify-content-center text-center">
						<div>
							<nav id="site-navigation" class="main-navigation">
								<div class="menu-primary-container">
									<ul id="primary-menu" class="menu">
										<li id="menu-item-198" class="menu-item menu-item-type-custom menu-item-object-custom current-menu-item current_page_item menu-item-home menu-item-198">
											<a href="/boardList">게시판생성</a>
										</li>
										<c:forEach items="${boardList}" var="vo">
											<c:choose>
												<c:when test="${vo.board_use == 'Y'}">
													<li id="menu-item-200" class="menu-item menu-item-type-post_type menu-item-object-page menu-item-200"><a href="/postList?board_id=${vo.board_id}">${vo.board_name}</a></li>
												</c:when>
												<c:when test="${vo.board_use == 'N'}">
													<li><a href="/postList?board_id=${vo.board_id}">${vo.board_name}</a></li>
												</c:when>
											</c:choose>
										</c:forEach>
									</ul>
								</div>
							</nav>
						</div>
					</div>
				</div>
			</div>
			<div class="col text-center">
				<div class="logo headerlogo">
					<a href="#" rel="home" title="iks" class="iksTitleLogo">
						IKS BOARD
					</a>
				</div>
			</div>
			<div class="col text-left"></div>
		</div>
	</header><!-- #masthead -->

	<div id="content" class="site-content">
		<div id="primary" class="content-area">
			<main id="main" class="site-main">
				<div class="opening">
					<div class="opening-video">
						<div class="opening-video-background bgi" style="background-image: url('http://cocoon.co.il/wp-content/uploads/2018/07/opening-background.jpg');"></div>
						<div class="opening-video-player"></div>
					</div>
					<div class="opening-preview">
						<div class="opening-preview-coworking bgi" style="background-image: url('http://cocoon.co.il/wp-content/uploads/2018/08/bgoffice.jpg');" data-link="http://cocoon.co.il/coworking/">
							<div class="fullheight" style="opacity: 0.5;"></div>
						</div>
						<div class="opening-preview-coffee bgi" style="background-image: url('http://cocoon.co.il/wp-content/uploads/2018/08/coffee-image-1.jpg');" data-link="http://cocoon.co.il/coffee/">
							<div class="fullheight" style="opacity: 0.5;"></div>
						</div>
					</div>
					<div class="opening-content fullheight">
						<div class="d-flex fullheight flex-column justify-content-center text-center">
							<div>
								<div class="opening-content-paragraph">
									<c:if test="${userVo.name != null}">
										<span>${userVo.name}</span> 님 안녕하세요
									</c:if>
								</div>
								<div class="opening-content-title supertitle">MAIN</div>								
							</div>
						</div>
					</div>
				</div>
			</main><!-- #main -->
		</div><!-- #primary -->
	</div><!-- #content -->

	<div class="social">
		<a href="#">
			<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 238.61 512">
			<path class="a" d="M295.46,167.76V123.65a97.12,97.12,0,0,1,.93-15.38,29.67,29.67,0,0,1,4.2-10.72q3.26-5.28,10.56-7.3t19.42-2h44.11V0H304.16q-61.21,0-87.93,29t-26.71,85.6v53.12H136.7V256h52.81V512h106V256H366l9.32-88.24Z" transform="translate(-136.7 0)"/></svg>
		</a>
		<a href="#">
			<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 511.99 512">
			<path class="a" d="M384,0H128C57.61,0,0,57.6,0,128V384c0,70.38,57.6,128,128,128H384c70.39,0,128-57.62,128-128V128C512,57.6,454.39,0,384,0Zm85.33,384A85.43,85.43,0,0,1,384,469.33H128A85.44,85.44,0,0,1,42.67,384V128A85.43,85.43,0,0,1,128,42.67H384A85.42,85.42,0,0,1,469.33,128V384Z" transform="translate(-0.01 0)"/><circle class="a" cx="394.68" cy="117.33" r="32"/><path class="a" d="M256,128A128,128,0,1,0,384,256,128,128,0,0,0,256,128Zm0,213.34A85.34,85.34,0,1,1,341.33,256,85.34,85.34,0,0,1,256,341.34Z" transform="translate(-0.01 0)"/></svg>
		</a>
		<a href="#">
			<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 489.25">
			<path class="a" d="M512,311.33V500.62H402.26V324c0-44.37-15.87-74.64-55.59-74.64-30.32,0-48.37,20.4-56.31,40.14-2.89,7.06-3.64,16.88-3.64,26.76V500.62H177s1.48-299.12,0-330.11H286.71V217.3c-.22.35-.51.73-.72,1.07h.72V217.3c14.58-22.46,40.63-54.55,98.92-54.55C457.86,162.75,512,209.94,512,311.33ZM62.12,11.38C24.56,11.38,0,36,0,68.4c0,31.69,23.85,57.07,60.66,57.07h.73c38.28,0,62.09-25.38,62.09-57.07C122.76,36,99.67,11.38,62.12,11.38ZM6.52,500.62H116.25V170.51H6.52Z" transform="translate(0 -11.38)"/></svg>
		</a>
	</div>
	
	<div class="music off active">
		<button class="music-icon">
			<span></span>
			<span></span>
			<span></span>
			<span></span>
			<span></span>
			<span></span>
		</button>
		<div class="music-text">
			MUSIC
			<span>STOP</span>
			<span>START</span>
		</div>
		<audio loop>
			<source src="http://cocoon.co.il/wp-content/themes/cocoon/music/background.mp3" type="audio/mpeg">
		</audio>
	</div>

	<div class="credits">
		<span>Powered by</span>
		<a href="#" target="_blank">IKS</a>
	</div>
</div><!-- #page -->

<script type='text/javascript' src='https://code.jquery.com/jquery-3.2.1.min.js'></script>
<script type='text/javascript' src='http://cocoon.co.il/wp-content/themes/cocoon/js/tether.min.js'></script>
<script type='text/javascript' src='http://cocoon.co.il/wp-content/themes/cocoon/js/bootstrap.min.js'></script>
<script type='text/javascript' src='http://cocoon.co.il/wp-content/themes/cocoon/js/slick.min.js'></script>
<script type='text/javascript' src='http://cocoon.co.il/wp-content/themes/cocoon/js/fancybox.min.js'></script>
<script type='text/javascript' src='http://cocoon.co.il/wp-content/themes/cocoon/js/lottie.js'></script>
<script type='text/javascript' src='js/scripts.js'></script>
<script type='text/javascript' src='http://cocoon.co.il/wp-includes/js/wp-embed.min.js?ver=4.9.8'></script>
</body>
</html>