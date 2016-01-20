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
	<div data-role="content" id="mainContent" style="padding:20px;">
	  <form method="post" action="/ishangchi/rest/login">
      <div data-role="fieldcontain">
        <input type="text" name="username" id="username" placeholder="您的用户名" >       
        <input type="password" name="password" id="password" placeholder="请输入您的密码">
        <label for="isRemeber">记住密码</label>
        <input type="radio" name="isRemeber" id="isRemeber" value="0" checked="checked">
        
        <div data-role="fieldcontain" style="text-align:left;">
        <select name="switch" id="switch" data-role="slider" >
          <option value="regist" >注册</option>
          <option value="login" selected="selected">登录</option>
        </select>
      </div>
       <input type="submit" data-inline="true" value="提交">
      </div>
    </form>
	</div>
	<c:import url="../footer.jsp"></c:import>
</body>
</html>