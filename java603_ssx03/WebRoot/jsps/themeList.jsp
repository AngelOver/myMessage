<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>留言版</title>
		<link rel="stylesheet" type="text/css" href="css/ym1.css">
		<style type="text/css">
		body{
		background-image:url(images/1.jpg);
		}
		</style>
	</head>

	<body background="./images/bg1.jpg">

		
		
		<div align="center">
		<div class="bar1">
		
    <div class="bar1">
		<div class="barContentBox">
			<img  class="logo" src="images/logo.png" alt=""/>
			<a href="http://www.wtu.edu.cn"><object class="logotext">武汉纺织大学<br/>wtu.edu.cn</object></a>
		</div>
	
<br><br>
<jsp:include page="head.jsp" />
  <div class="container1">
	</div>
			<div align="center" class="div2">
				<c:forEach items="${sessionScope.themeList}" var="p" varStatus="vs">
				<table align="center" width="1200" border="0" bgcolor="#C1C1C1"
					cellpadding="1" cellspacing="1">
					<tr >
						<td colspan="4" align="center" width="100" height="30" bgcolor="#D6E0E8">
							<font class="title2">${p.user.username}的留言</font>
						</td>
					</tr>
					<tr bgcolor="#FAFAFA">
						<td  width="20%" align="center">
							<b>标 题：</b>
						</td>
						<td colspan="3">
						&nbsp;${p.title}
						</td>
					</tr>
					<tr bgcolor="#FAFAFA">
						<td width="20%" align="center">
							<b>内 容：</b>
						</td>
						<td>&nbsp;${p.content}</td>
					</tr>
					<tr bgcolor="#FAFAFA">
						
						<td width="20%" align="center">
							<b><a href="${pageContext.request.contextPath }/theme/setTheme.do?id=${p.id}">查看</a></b>
						</td>
						<td>
							&nbsp;&nbsp;&nbsp;&nbsp;<b><a href="${pageContext.request.contextPath }/theme/setTheme.do?id=${p.id}">回复</a></b>
						</td>
										
				</table>
				</c:forEach>
			</div>
		</div>
		<br/>
		
		<jsp:include page="bottom.jsp"></jsp:include>
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
