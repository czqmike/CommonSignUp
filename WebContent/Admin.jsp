<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, cn.edu.hbue.dao.*" %>
<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>管理员登录</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">  
  <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    body{
      /* 优先使用本地的背景图片，如果未找到则使用外链加载图片 */
      /* background-image: url('/image/bgpictrue.jpg'), url(https://raw.githubusercontent.com/czqmike/LanqiaoSignup/master/WebContent/image/bgpictrue.jpg);  */
      /* background-image: url('/image/bgpictrue.jpg') ; /*需要设置虚拟路径（/image 对应磁盘上的 .../WebContent/image) */ 
      background-size: 100%;
      
      /*background-color: #8080c0;  /*图片未加载成功时的备用背景色*/
      background-color: #2a2a2a;
      color:white;   
    }
   #large-header{
      position: absolute; 
      left: 0px; 
      top: 0px; 
      z-index: -2147483645; 
      background: none 0% 0% / auto repeat scroll padding-box border-box rgba(0, 0, 0, 0);    
      height:469px;
  } 
  </style>
  <script> 
  function getSelectAndVisit(url_without_param) {
        var selected = "";
        selected = $('input:radio[name="selected"]:checked').val(); // 获取被选中radio的value
        if (selected == undefined) {
            alert("请选择某一项");
        } else {
            // window.location.href = url_without_param + selected;
            url = url_without_param + selected;
            $.get(url);           // 发送Ajax Get请求
            location.reload();    // 刷新页面 
        }
  }

  $(document).ready(function() {
      $("#post").click(function() {
      });
      $("#modify").click(function() {
        alert("尽情期待！");
      });
      $("#delete").click(function() {
        if (window.confirm("确定要删除这项报名吗？")) {
            var url_without_param = "/CommonSignUp/DeleteSubjectServlet?title=";
            getSelectAndVisit(url_without_param);
        }
      });
      $("#export").click(function() { 
        var selected = "";
        selected = $('input:radio[name="selected"]:checked').val(); // 获取被选中radio的value
        if (selected == undefined) {
            alert("请选择某一项");
        } else {
            window.location.href = "/CommonSignUp/GiveExcelServlet?title=" + selected;
        }
      });
    });
  </script>
</head>
  
<body>	
  <div class="container">
    <div class="row">
      <div class="col col-md-9">
        <h1 style="text-align:center; ">报名系统管理页面</h1>

        <table class="table table-bordered">
          <thead>
            <tr>
              <th>报名标题</th>
              <th>已报名人数</th>
              <th>选择</th>
            </tr>
          </thead>

		<%-- 获取报名标题列表--%>
		<% HashMap<String, Integer> ov = TitleToIdDao.selectOverview(); %>

          <tbody>
          	<% Iterator it = ov.entrySet().iterator(); %>
          	<% while (it.hasNext()) { %>
          	  <% Map.Entry entry = (Map.Entry)it.next(); %>
          	  	 <tr>
          	  	   <td><%=entry.getKey() %></td>
          	  	   <td><%=entry.getValue() %></td>
          	  	   <td><input type="radio" name="selected" value='<%=entry.getKey()%>'> </td>
          	  	 </tr>
          	<% } %>
          </tbody>
        </table>

        <div class="row">
          <div class="col col-md-3">
                <a href="/CreateAddItems.html" style="text-decoration:none;"><button class="btn btn-info btn-block" id="post">发布报名</button></a>
            <br />
          </div>
          <div class="col col-md-3">
            <button class="btn btn-primary btn-block" id="modify">修改报名</button>
            <br />
          </div>
          <div class="col col-md-3">
            <button class="btn btn-danger btn-block" id="delete">删除报名</button>
            <br />
          </div>
          <div class="col col-md-3">
            <button class="btn btn-success btn-block" id="export">导出为excel</button>
          </div>
        </div>
        </div>
      </div>

    </div>
  </div>

  <div id="large-header">
    <canvas id="demo-canvas" width="1680" height="469">
    </canvas>
  </div>
  <!-- 網狀特效1 -->
  <script src="js/EasePack.min.js"></script>
  <script src="js/TweenLite.min.js"></script>
  <script src="js/helloweb.js"></script> 
  <!-- 網狀特效2 -->
</body>

<footer>
</footer>
</html>