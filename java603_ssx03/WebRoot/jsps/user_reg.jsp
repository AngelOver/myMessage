<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title></title>

    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
     <link type="text/css" rel="stylesheet" href="css/style.css">
   	<link rel="stylesheet" type="text/css" href="css/ym1.css">
    <script type="text/javascript">
        function reg(form){
            if(form.elements["username"].value == ""){
                alert("用户名不能空！");
                return false;
            }
            if(form.elements["password"].value == ""){
                alert("密码不能空！");
                return false;
            }
            if(form.elements["repassword"].value == ""){
                alert("确认密码不能空！");
                return false;
            }
            if(form.elements["repassword"].value != form.elements["password"].value){
                alert("两次密码输入不一致！");
                return false;
            }
            if(form.elements["email"].value == ""){
                alert("电子邮件不能空！");
                return false;
            }
        }

    </script>
</head>
<body>
  <div class="bar1">
		<div class="barContentBox">
			<img class="logo" src="images/logo.png" alt=""/>
			<a href="http://www.wtu.edu.cn"><object class="logotext">武汉纺织大学<br/>wtu.edu.cn</object></a>
		</div>
	</div>
<div class="container">
    <div class="music">
        <h1>用户注册</h1>
        <form action="${pageContext.request.contextPath }/user/register.do" method="post">
            <input type="hidden" name="method" value="guestReg"/>
            <div class="from-group">
                <input type="text" name="username" class="from-control" placeholder="用户名"  style="width: 420px;height: 45px">
            </div>
            <div class="from-group">
                <input type="password" name="password" class="from-control" placeholder="密码(不少于6位)"  style="width: 420px;height: 45px">
               </div>
            <div class="from-group">
                <input type="password" name="repassword" class="from-control" placeholder="确定密码(不少于6位)"  style="width: 420px;height: 45px">
            </div>
            <div class="from-group">
                <input type="email" name="email" class="from-control" placeholder="邮箱"  style="width: 420px;height: 45px">
            </div>
            <div class="from-group">
                 <input class="btn btn-info btn-lg" type="submit" value="注册"/>
                <input class="btn btn-info btn-lg" type="reset" value="重置"/>
            </div>
             <div class="from-group1">
              <a  class="a1" href="#">手机号注册</a>
               <a  class="a2" href="user_login.jsp">已有账户？马上登陆</a>
            </div>

        </form>
    </div>
</div>
<div class="ym1">
    <footer>
    
       <div class="bar">
		<div class="barContentBox">
			<img class="logo" src="images/logo.png" alt=""/>
			<div class="logotext">武汉纺织大学<br/>wtu.edu.cn</div>
			<div id="info">联系地址：武汉纺织大学阳光校区 邮编：430200<br/>
			版权所有 © 2016-2017 武汉纺织大学数学与计算机学院</div>
		</div>
		</div>
	
    </footer>
    </div>
</body>
</html>