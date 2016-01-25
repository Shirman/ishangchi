<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div data-role="header" data-theme="b">
	<c:choose>
		<c:when  test="${currentUser!=null}">
			<a href="/ishangchi/rest/logout" data-role="button" data-icon="home" data-transition="none">${ currentUser.username }</a>
		</c:when>
		<c:otherwise>
		    <a href="/ishangchi/rest/login" data-role="button" data-icon="home" data-transition="none">登录</a>
		</c:otherwise>
	</c:choose>
    <h1>心享</h1>
    <a href="#" data-role="button" data-icon="refresh">刷新</a>
 </div>