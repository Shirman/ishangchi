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
	<script src="/ishangchi/release/jqueryMobile/jquery.mobile.css.helper.js"></script>
</head> 
<body>
 	<c:import url="../header.jsp"></c:import>
	<div data-role="content">
    	<ul data-role="listview" data-inset="true">
      		<li data-icon="false" data-theme="e">
      		<p><b>Shirman</b></p>
        	<div class="ui-li-desc ui-li-no-toe" >应怜屐齿印苍苔，小扣柴扉久不开。春色满园关不住，一枝红杏出墙来。</div>
        	<p><span style="float:left;">赞</span>  <span style="float:right;">2016/01/20</span></p>
      		</li>
    	</ul>
  	</div>
  	
  	<div data-role="content">
    	<ul data-role="listview" data-inset="true">
      		<li data-icon="false" data-theme="e">
      		<p><b>管理员</b></p>
        	<div class="ui-li-desc ui-li-no-toe" >首页展示的是来自网友们的漂流瓶，漂流瓶可以通过关注微信号：weixiao_kuaile_1314</div>
        	<p><span style="float:left;">赞</span>  <span style="float:right;">2016/01/20</span></p>
      		</li>
    	</ul>
  	</div>
	<c:import url="../footer.jsp"></c:import>
</body>
</html>