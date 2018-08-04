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
  </style>
</head>
<body>
	<h1 class="text-center">index页面title</h1>
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

	  <div class="col-md-6 col-centered">
		<button class="btn btn-primary" type="submit">提交</button>
	  </div>
	</div>
	
	</form>	
</body>
</html>