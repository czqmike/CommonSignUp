<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, cn.edu.hbue.dao.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>报名系统index页面</title>
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
      height: 380px;
      background-color: #fff;   /* 没有图片填充的地方，使用白色来填充。*/
  }
  #carousel-example-generic {
      text-align: center;
      /* width: 492.8px; */
      width:100%;
      height: 380px;
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
  </style>
</head>
<body>
    <img src="https://raw.githubusercontent.com/czqmike/CommonSignUp/master/WebContent/image/logo1.jpg" class="col-centered"style="width: auto; height: 115px;">

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

	<div class="row row-centered">
	  <div class="col-md-3 col-centered">
		<select class="form-control input-md" name="subject_title" id="subject_title">
	    <% for (int i = 0; i < subject_titles.size(); ++i ) { %> 	
		<option><%=subject_titles.get(i) %></option>
	    <% } %>
		</select>
      </div>
      <br/>

	  <div class="col-md-6 col-centered">
		<button class="btn btn-primary" type="submit" style="width: 380px">选择此报名</button>
	  </div>
	</div>
	
	</form>	
</body>
</html>