<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="header.jsp" %>
<link href="../css/swiper.min.css" rel="stylesheet" />
<link href="../css/main.css" rel="stylesheet" />
<style type="text/css">
.swiper-container {
  box-sizing:border-box !important;
  width: 1000px;
  height: 100%;
  float:left;
  margin-top:5px;
  margin-left:30px;
}
.swiper-slide {
  text-align: center;
  font-size: 18px;
  background: #fff;
  /* Center slide text vertically */
  display: -webkit-box;
  display: -ms-flexbox;
  display: -webkit-flex;
  display: flex;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  -webkit-justify-content: center;
  justify-content: center;
  -webkit-box-align: center;
  -ms-flex-align: center;
  -webkit-align-items: center;
  align-items: center;
}
.mainpage {
	display:block;margin-top:30px;margin-left:250px;font-size:55px;font-weight:100;
	margin-bottom:20px;
}
</style>
<div class="all_container">
	<%@ include file="left.jsp" %>
	<h2 class="mainpage">MAIN PAGE</h2>
	<div class="swiper-container">
	    <div class="swiper-wrapper">
	      <div class="swiper-slide">
	      	<img src="http://placehold.it/1000x500" />
	      </div>
	      <div class="swiper-slide">
	      	<img src="http://placehold.it/1000x500" />
	      </div>
	      <div class="swiper-slide">
	      	<img src="http://placehold.it/1000x500" />
	      </div>
	    </div>
	    <!-- Add Pagination -->
	    <div class="swiper-pagination"></div>
	  </div>
	
	  <!-- Swiper JS -->
	  <script src="../js/swiper.min.js"></script>
	
	  <!-- Initialize Swiper -->
	  <script>
	    var swiper = new Swiper('.swiper-container', {
	    	autoplay: {
	    		delay: 2500,
	    		disableOnInteraction: false,
	    	},
	    	loop: true,
	    	pagination: {
	        	el: '.swiper-pagination',
	      	},
	    });
	  </script>
</div>
<%@ include file="bottom.jsp" %>