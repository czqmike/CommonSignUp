<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, cn.edu.hbue.dao.*, cn.edu.hbue.model.*" %>
<!DOCTYPE html>

<% String page_title = new String(request.getParameter("subject_title").getBytes("ISO8859-1"),"UTF-8"); %>

<%-- 先用page_title在title_to_id中选出id，然后用id查出addon_item[id]中的各项 --%>
<% ArrayList<AddonItem> items = AddonItemDao.selectAddonItemsById(
									TitleToIdDao.selectId(page_title));  %>

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
	<script>
		// 检测是否有未选择的下拉菜单，若有，则弹出警告，阻止用户提交
		$(document).ready(function() {
			$("#submitbtn").click(function() {
				$("select").each(function() {
					var sindex = $(this).get(0).selectedIndex;
					var stext = $(this).val();
					console.log(sindex);
					console.log(stext);
					if (sindex == 0) {	// sindex为0时表示未进行选择
						alert(stext);		// 告诉用户哪一项未选择（内容等同于第一个select选项）
						event.preventDefault();			// 有未选择的下拉菜单，阻止用户继续提交表单
						return false;		// 结束each循环
					}
				})
			})
		})
  </script>
	<script>
		var isCommitted = false;
		function dosubmit(){
			if (isCommitted==false) {
					isCommitted = true;//提交表单后，将表单是否已经提交标识设置为true
					var btn = document.getElementById("submitbtn");	
					btn.disabled="disabled";// 将提交按钮设置为不可击
					return true;//返回true让表单正常提交
			} else {
					return false;//返回false那么表单将不提交
			}
		}
	</script>
</head>

<body>
<%-- <form action="404" method="POST"> --%>
<form action="GetMainServlet" onsubmit="return dosubmit()" method="POST">
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
		  
		  <!--  隐藏的输入框，用来传递page_title以方便后续处理 -->
		  <input type="hidden" name="page-title" value="<%=page_title %>">
			<%-- 使用EL表达式取出存储在session中的token --%>
		  <input type="hidden" name="token" value="${token}"/> 
		  
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
			<span class="input-group-addon">专业</span>
			<select class="form-control input-md" name="major" id="major">
			  <option>请选择专业</option>
			  <option>计算机科学与技术</option>
			  <option>软件工程</option>
			  <option>数字媒体技术</option>
			  <option>网络工程</option>
			  <option>电子信息工程</option>
			  <option>电子信息工程（嵌入式系统及应用方向）</option>
			  <option>电子信息工程（通信工程方向）</option>
			  <option>物联网工程</option>
			  <option>软件工程（虚拟现实软件开发方向）</option>
			  <option>其他</option>
			</select>
		  </div>
		  <br/>
		  
		  <div class="input-group input-group-md">
			<span class="input-group-addon">班级</span>
			<select class="form-control input-md" name="class" id="class">
			  <option>请选择班级</option>
			  <option>1班</option>
			  <option>2班</option>
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
			
		<!-- TODO: 修改此项，使其能够插入下拉菜单以及图片选择区域 --> 
		  <% for (int i = 0; i < items.size(); ++i) { %> 
		  	<% if ("文本框".equals(items.get(i).getType())) { %>
			  <div class="input-group input-group-md"> 
			  <span class="input-group-addon"> <%=items.get(i).getAddon_name() %>  </span> 
			  <input type="text" class="form-control" placeholder="请输入<%=items.get(i).getAddon_name() %>" 
			  		 name="<%=items.get(i).getAddon_name() %>" id="<%=items.get(i).getAddon_name() %>"> 
			  </div>
			  <br/>  
		    <% } else if ("下拉菜单".equals(items.get(i).getType())) { %>
			  <div class="input-group input-group-md">  
              <span class="input-group-addon"> <%=items.get(i).getAddon_name() %> </span> 
              <select class="form-control input-md" name=<%=items.get(i).getAddon_name() %> id=<%=items.get(i).getAddon_name() %>>  
                <option>请选择<%=items.get(i).getAddon_name() %></option> 
                <% String[] ops = items.get(i).getOption().split("`"); %>
                <% for (int j = 0; j < ops.length; ++j) { %>
                	<option><%=ops[j] %></option>
				<% } %>
                </select> 
              </div> <br/> 
			<% } else if ("复选按钮".equals(items.get(i).getType())) { %>
			<% } else if ("图片上传区域".equals(items.get(i).getType())) { %>
		    <% } %>
		  <% } %>

		  <button id="submitbtn" class="btn btn-primary  btn-block" type="submit">立即报名</button>
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