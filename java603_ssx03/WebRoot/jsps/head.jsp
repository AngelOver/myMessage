<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>
<style>
	.t1{
		font-size: 10pt;
		font-weight: bold;
		color: red;
	}
	div.title{font-size: 12px}
	div.title a:LINK {text-decoration: underline; color: red}
	div.title a:visited {text-decoration: underline; color: red}
	div.title a:active {text-decoration: underline; color: red}
	div.title a:hover {text-decoration: underline; color: red}
	div.top{font-size: 12px;margin-top: 5; position: relative;}
	.gg{font-size: 13px;color: red;}
</style>
<table border="0" align="center" cellpadding="0" cellspacing="0" width="1200">
 	<br><br>
 	<tr bgcolor="#FFFFFF">
 		<td width="10%" align="center">
 			<img src="images/gg.jpg">
 		</td>
 		<td width="60%">
 			<marquee behavior="scroll" direction="left" scrolldelay="200"  >
 			<font class="gg">公告：在这里可以发表信息，写下祝福，留下与青春有关的美好回忆...</font>
 			</marquee> 
 		</td>
 		<td align="center" height="40" class="t1" width="30%">
 			<div class="title">
	 			<a href="${pageContext.request.contextPath }/theme/themeList.do" class="title">首页</a>
	 			<a href="${pageContext.request.contextPath }/jsps/addTheme.jsp" class="title">写留言</a>
	 			
	 			<c:choose>
	 				<c:when test="${empty user}">
	 					<a href="${pageContext.request.contextPath }/jsps/user_reg.jsp">注册</a>
	 					<a href="${pageContext.request.contextPath }/jsps/user_login.jsp">登录</a>
	 				</c:when>
	 				<c:when test="${!empty admin}">
	 					<a href="${pageContext.request.contextPath }/user/logout.do">退出</a>
	 					管理员：${user.username}
	 				</c:when>
	 				<c:otherwise>
	 					<a href="${pageContext.request.contextPath }/user/logout.do">退出</a>
	 					用户名：${user.username}
	 				</c:otherwise>
	 			</c:choose>
	 	
 			</div>
 		</td>
 	</tr>
</table>
