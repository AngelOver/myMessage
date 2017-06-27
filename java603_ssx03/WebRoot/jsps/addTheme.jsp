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
</head>
<body>
	

    <div class="bar1">
		<div class="barContentBox">
			<img class="logo" src="images/logo.png" alt=""/>
			<a href="http://www.wtu.edu.cn"><object class="logotext">武汉纺织大学<br/>wtu.edu.cn</object></a>
		</div>
	

  <div class="container1">

&nbsp&nbsp;<a href="${pageContext.request.contextPath }/theme/themeList.do">首页</a>;&raquo;&nbsp&nbsp;<a href="#">留言</a>

    <div class="message">
        <h1>打个招呼吧</h1>
        <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;那些现实中不曾发出的声音<br/>请把它留在这里</p>
        <form action="${pageContext.request.contextPath }/theme/addTheme.do" method="post" >
        <input type="hidden" name="method" value="save">
            <div class="from-group20">
                <input type="text" name="title" class="from-control3" placeholder="标题"  style="width: 360px;height: 55px">
            </div>
            <div class="from-group20">
                   <textarea name="content" class="from-control3" cols=50 rows=6  >留言
             </textarea>
            </div>
            <div class="from-group10">
                <input class="btn btn-info btn-lg" type="submit" value="发布"/>
                <input class="btn btn-info btn-lg" type="reset" value="重置"/>
            </div>
        </form>
    </div>
</div>

 <br>

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