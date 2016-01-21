<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html> 
<html> 
	<head> 
	<title>心享-登录</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<c:import url="../common_js.jsp"></c:import>
</head> 
<body>
 	<c:import url="../header.jsp"></c:import>
	<div data-role="content" id="mainContent" style="padding:20px;">
	  <form method="post" action="/ishangchi/rest/login">
      <div data-role="fieldcontain" >
        <input type="text" name="username" id="username" placeholder="您的用户名" >       
        <input type="password" name="password" id="password" placeholder="请输入您的密码">
        <label for="isRemeber">记住密码</label>
        <input type="checkbox" name="isRemeber" id="isRemeber" >
        <input type="submit" value="点击登录" data-inline="true" style="float:left;">
        <a href="#" data-role="button" data-inline="true" data-shadow="true" style="float:right;">立即注册</a>
      </div>
    </form>
	</div>
	<c:import url="../footer.jsp"></c:import>
</body>
</html>