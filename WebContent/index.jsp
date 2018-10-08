<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, cn.edu.hbue.dao.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>湖北经济学院比赛报名系统</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
  <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .row-centered {
      text-align:center;
  }
  .col-centered {
      float: none;
      display: block;
      margin-left: auto;
      margin-right: auto;
  }
  .carousel .item{
      height: 420px;
      background-color: #fff;   /* 没有图片填充的地方，使用白色来填充。*/
  }
  #carousel-example-generic {
      text-align: center;
      /* width: 492.8px; */
      width:100%;
      height: 420px;
  }
  #item1 {
    background: url("https://raw.githubusercontent.com/czqmike/CommonSignUp/master/WebContent/image/banner1.png") center center no-repeat;
  }
  #item2 {
    background: url("https://raw.githubusercontent.com/czqmike/CommonSignUp/master/WebContent/image/banner2.png") center center no-repeat;
  }
  #item3 {
    background: url("https://raw.githubusercontent.com/czqmike/CommonSignUp/master/WebContent/image/banner3.png") center center no-repeat;
  }
  #item4 {
    background: url("https://raw.githubusercontent.com/czqmike/CommonSignUp/master/WebContent/image/banner4.png") center center no-repeat;
  }
  #item5 {
    background: url("https://raw.githubusercontent.com/czqmike/CommonSignUp/master/WebContent/image/banner5.png") center center no-repeat;
  }
  #item6 {
    background: url("https://raw.githubusercontent.com/czqmike/CommonSignUp/master/WebContent/image/banner6.png") center center no-repeat;
  }
 #large-header{
      position: absolute; 
      left: 0px; 
      top: 0px; 
      z-index: -2147483645; 
      background: none 0% 0% / auto repeat scroll padding-box border-box rgba(0, 0, 0, 0);    
      height:469px;
  } 
  body {
        background-color: #2a2a2a;  
  }
  </style>
</head>
<body>
    <img src="https://raw.githubusercontent.com/czqmike/CommonSignUp/master/WebContent/image/logo1.png" class="img-responsive center-block"style="width: auto; height: 115px;">

    <!-- 轮播 -->
    <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                <li data-target="#carousel-example-generic" data-slide-to="4"></li>
                <li data-target="#carousel-example-generic" data-slide-to="5"></li>
            </ol>
    
            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox" id="carousel">
                <div class="item active" id="item1"></div>
                <div class="item" id="item2"></div>
                <div class="item" id="item3"></div>
                <div class="item" id="item4"></div>
                <div class="item" id="item5"></div>
                <div class="item" id="item6"></div>
                <!-- <div class="item active" id="item1">
                    <img src="https://raw.githubusercontent.com/czqmike/CommonSignUp/master/WebContent/image/banner1.png" alt="banner1">
                    <div class="carousel-caption">
                    </div>
                </div> -->
            </div>
    
            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
    </div>
    <br/>
    
    <!-- 选择报名标题 -->
	<% ArrayList<String> subject_titles = TitleToIdDao.selectName(); %>
	<form action="GetIndexServlet" method="GET">

	<!-- <div class="row row-centered"> -->
	  <!-- <div class="col-md-3 col-centered"> -->
        <select class="form-control input-md row-centered col-centered" name="subject_title" id="subject_title" 
            style="width: 380px; text-align: center; ">
	    <% for (int i = 0; i < subject_titles.size(); ++i ) { %> 	
		<option><%=subject_titles.get(i) %></option>
	    <% } %>
		</select>
      <!-- </div> -->
      <br/>

	  <!-- <div class="col-md-6 col-centered"> -->
		<button class="btn btn-primary center-block" type="submit" style="width: 380px;">选择此报名</button>
	  <!-- </div> -->
	<!-- </div> -->
	
	</form>	
	<br/>

    <p style="text-align: center;"><a href="https://czqmike-server.cn/AdminLogIn.html" style="color: #fff;">管理员登录</a></p>

	  <div id="large-header">
		<canvas id="demo-canvas" width="1680" height="469">
		</canvas>
	  </div>
	  <!-- <script src="net.js"></script> -->  
	  <!-- 網狀特效1 -->
	  <script src="js/EasePack.min.js"></script>
	  <script src="js/TweenLite.min.js"></script>
	  <script src="js/helloweb.js"></script> 
	  <!-- 網狀特效2 -->
</body>
</html>