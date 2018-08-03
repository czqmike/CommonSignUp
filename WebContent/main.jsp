<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% String page_title="test"; %>
<% String[] item_arr = {"栏目1","栏目2","栏目3"};  %>

<html>
<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title><%=page_title %></title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
  <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    body{
      /* 优先使用本地的背景图片，如果未找到则使用外链加载图片 */
      background-image: url('/image/bgpictrue.jpg'), url(https://raw.githubusercontent.com/czqmike/LanqiaoSignup/master/WebContent/image/bgpictrue.jpg); 
      /* background-image: url('/image/bgpictrue.jpg') ; /*需要设置虚拟路径（/image 对应磁盘上的 .../WebContent/image) */ 
      background-size: 100%;
      
      background-color: #8080c0;  /*图片未加载成功时的备用背景色*/
    }
  </style>
<meta charset="UTF-8">
</head>

<body>
<form action="GetSignInfo" method="POST">
  <div class="container">
	<br/>
	<div class="jumbotron">
	  <!-- 用jumbotron整体包含这一行 -->
	  <div class="row">
		<!-- 这一行分为3列，比例为3:5:4，只用比例为5的那部分,其余部分用来挤压排版 -->
		<div class="col-md-3"></div> <!--不使用-->

		<!-- 每个[name]对应数据库表中的字段名（把-改成_) -->
		<div class="col-md-5">
		  <h2 class="text-center"><%=page_title %></h2>
		  <div class="input-group input-group-md">
			<span class="input-group-addon">姓名</span>
			<input type="text" class="form-control" placeholder="请输入姓名" aria-describedby="sizing-addon1" name="name" id="name" required>
		  </div>
		  <br/>

		  <div class="input-group input-group-md">
			<span class="input-group-addon">学号</span>
			<input type="text" class="form-control" placeholder="请输入学号" aria-describedby="sizing-addon1" name="student-no" id="student-no" required>
		  </div>
		  <br/>

		  <div class="input-group input-group-md">
			<span class="input-group-addon">班级</span>
			<select class="form-control input-md" name="class" id="class">
			  <option>请选择班级</option>
			  <option>计科</option>
			  <option>软件</option>
			  <option>物联</option>
			  <option>电子</option>
			  <option>其他</option>
			</select>
		  </div>
		  <br/>

		  <div class="input-group input-group-md">
			<span class="input-group-addon">入学年份</span>
			<select class="form-control input-md" name="report-year" id="report-year">
			  <option>请选择入学年份</option>
			  <option>2015</option>
			  <option>2016</option>
			  <option>2017</option>
			  <option>2018</option>
			</select>
		  </div>
		  <br/>
		 
		  <% for (int i = 0; i < item_arr.length; ++i) { %> 
			  <div class="input-group input-group-md"> 
			  <span class="input-group-addon"> <%=item_arr[i] %>  </span> 
			  <input type="text" class="form-control" placeholder="请输入<%=item_arr[i] %>" name="<%=item_arr[i] %>" id="<%=item_arr[i]%>"> 
			  </div>
			  <br/>  
		  <% } %>

		  <button class="btn btn-primary  btn-block" type="submit" name="sign-up">立即报名</button>
		</div>

		<div class="col-md-4"><p></p></div> <!--不使用-->

	  </div>
	  <hr/>
	  <footer class="text-center">
		<p>powered by <a href="mailto:czqmike@foxmail.com?Subject=报名系统反馈">czqmike</a>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
	  </footer>
	</div>
  </div>
</form>
</body>
</html>