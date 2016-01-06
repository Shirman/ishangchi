<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html> 
<html> 
	<head> 
	<title>心享</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="/ishangchi/release/jqueryMobile/jquery.mobile-1.4.0.min.css" />
	<script src="/ishangchi/release/jquery/jquery-1.7.1.min.js"></script>
	<script src="/ishangchi/release/jqueryMobile/jquery.mobile-1.4.0.min.js"></script>
</head> 
<body>
 	<c:import url="../header.jsp"></c:import>
	<div data-role="content" id="mainContent" style="padding:20px;text-align:center;">
	  <form method="post" action="demoform.asp">
      <div data-role="fieldcontain">
        <input type="text" name="username" id="username" placeholder="您的用户名" >       
        <input type="password" name="password" id="password" placeholder="请输入您的密码">
        <label for="isRemeber">记住密码</label>
        <input type="radio" name="isRemeber" id="isRemeber" value="0">
        <fieldset data-role="controlgroup" data-type="horizontal" >
        <label for="rigist">注册</label>
        <input type="radio" name="rigist" id="rigist" value="2">
        <label for="login">登录</label>
        <input type="radio" name="login" id="login" value="1">	
      </fieldset>
      </div>
    </form>
	</div>
	<c:import url="../footer.jsp"></c:import>
</body>
</html>