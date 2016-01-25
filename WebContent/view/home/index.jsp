<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html> 
<html> 
	<head> 
	<title>心享</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<c:import url="../common_js.jsp"></c:import>
	<script src="/ishangchi/public/js/home/index.js"></script>
</head> 
<body>
	<input type="hidden" id="pageNum" value="1">
 	<c:import url="../header.jsp"></c:import>
 	<c:forEach items="${ articles }" var="article">
 	<div data-role="content">
    	<ul data-role="listview" data-inset="true">
      		<li data-icon="false" data-theme="e">
      		<p><b>匿名</b></p>
        	<div class="ui-li-desc ui-li-no-toe" >${article.content }</div>
        	<p><span style="float:left;"></span>  <span style="float:right;">来自微信漂流瓶</span></p>
      		</li>
    	</ul>
  	</div>
 	</c:forEach>
	<c:import url="../footer.jsp"></c:import>
</body>
</html>