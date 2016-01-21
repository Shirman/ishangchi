<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html> 
<html> 
	<head> 
	<title>心享</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<c:import url="../common_js.jsp"></c:import>
</head> 
<body>
 	<c:import url="../header.jsp"></c:import>
	<div data-role="content" id="mainContent" >
	    <ul data-role="listview" data-inset="true">
		      <li>
		        <a href="/ishangchi/rest/game/numberBoom"  data-transition="pop">
		        <img src="/ishangchi/public/images/game/number-boom/boom-icon.png">
		        <h2>数字炸弹</h2>
		        <p>系统随机给出一个1-100的数字，参与者根据提示依次猜数字直到猜中，游戏结束。</p>
		        </a>
		      </li>
		      <li>
		        <a href="#">
		        <img src="/ishangchi/public/images/game/who/who.png">
		        <h2>谁是卧底</h2>
		        <p>用户设定角色之后，系统随机分配给游戏参与人员</p>
		        </a>
		      </li>
		      <li>
		        <a href="#">
		        <img src="/ishangchi/public/images/game/trueHeart/trueHeart.jpg">
		        <h2>真心话大冒险</h2>
		        <p>Firefox is a web browser from Mozilla. Released in 2004.</p>
		        </a>
		      </li>
		      <li>
		        <a href="#">
		        <img src="/ishangchi/public/images/game/kill/kill.jpg">
		        <h2>杀人游戏</h2>
		        <p>Firefox is a web browser from Mozilla. Released in 2004.</p>
		        </a>
		      </li>
		      <li>
		        <a href="#">
		        <img src="/ishangchi/public/images/game/luck/luck.png">
		        <h2>最佳幸运者</h2>
		        <p>Firefox is a web browser from Mozilla. Released in 2004.</p>
		        </a>
		      </li>
	    </ul>
	</div>
	<c:import url="../footer.jsp"></c:import>
</body>
</html>