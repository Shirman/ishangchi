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
	<div data-role="content" id="mainContent" >
	  <ul data-role="listview" data-inset="true" >
      <li data-role="list-divider" data-theme="a">技术</li>
      <li>
        <a href="#">
        <img src="http://www.w3school.com.cn/i/chrome.png">
        <h2>Google Chrome</h2>
        <p>Google Chrome is a free, open-source web browser. Released in 2008.</p>
        </a>
      </li>
      <li>
        <a href="#">
        <img src="http://www.w3school.com.cn/i/firefox.png">
        <h2>Mozilla Firefox</h2>
        <p>Firefox is a web browser from Mozilla. Released in 2004.</p>
        </a>
      </li>
    </ul>
    <ul data-role="listview" data-inset="true">
      <li data-role="list-divider">旅行</li>
      <li>
        <a href="#">
        <img src="http://www.w3school.com.cn/i/chrome.png">
        <h2>Google Chrome</h2>
        <p>Google Chrome is a free, open-source web browser. Released in 2008.</p>
        </a>
      </li>
      <li>
        <a href="#">
        <img src="http://www.w3school.com.cn/i/firefox.png">
        <h2>Mozilla Firefox</h2>
        <p>Firefox is a web browser from Mozilla. Released in 2004.</p>
        </a>
      </li>
    </ul>
    <ul data-role="listview" data-inset="true">
      <li data-role="list-divider">美食</li>
      <li>
        <a href="#">
        <img src="http://www.w3school.com.cn/i/chrome.png">
        <h2>Google Chrome</h2>
        <p>Google Chrome is a free, open-source web browser. Released in 2008.</p>
        </a>
      </li>
      <li>
        <a href="#">
        <img src="http://www.w3school.com.cn/i/firefox.png">
        <h2>Mozilla Firefox</h2>
        <p>Firefox is a web browser from Mozilla. Released in 2004.</p>
        </a>
      </li>
    </ul>
	</div>
	<c:import url="../footer.jsp"></c:import>
</body>
</html>