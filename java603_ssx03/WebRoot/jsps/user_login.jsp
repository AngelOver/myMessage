<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head >
    <title></title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
    <link type="text/css" rel="stylesheet" href="css/style1.css">
    <link rel="stylesheet" type="text/css" href="css/ym1.css">
    <script type="text/javascript">
    // JavaScript Document
    function login(form){
            if(form.elements["username"].value == ""){
                alert("用户名不能空！");
                return false;
            }
            if(form.elements["password"].value == ""){
                alert("密码不能空！");
                return false;
            }
        }
        function message(form){
            if(form.elements["title"].value == ""){
                alert("留言标题不能为空！");
                return false;
            }
            if(form.elements["content"].value == ""){
                alert("留言内容不能空！");
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
            <h1>用户登陆</h1>
            <form action="${pageContext.request.contextPath }/user/login.do" method="post" onsubmit="">
             <input type="hidden" name="method" value="userLogin">
                <div class="from-group">
                    <input type="text" name="username" class="from-control" placeholder="用户名"  style="width: 420px;height: 55px">
                </div>
                <div class="from-group">
                    <input type="password" name="password" class="from-control" placeholder="密码"  style="width: 420px;height: 55px">
                </div>

                <div class="from-group1">
                    <a  class="a1" href="#"><input type="checkbox"/>记住我</a>
                    <a  class="a2" href="#">忘记密码</a>
                </div>
                <div class="from-group">
                    <input class="btn btn-info btn-lg" type="submit" value="登录" />
                    <input class="btn btn-info btn-lg" type="reset" value="重置"/>
                </div>
                <div class="from-group1">
                    <a  class="a3" href="user_reg.jsp">还没账户，马上注册</a>

                </div>
            </form>
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