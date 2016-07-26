<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/resources/js/pop.js"></script>
</head>
<body>
<div style="background-color: yellow; width: 100%; height: 150px;">Header<br/>

<h3 align="right">${user}님
<button onclick="updatePop()" class="btn btn-default">정보수정</button>
<button onclick="location.href='logout'">로그아웃</button></h3>
</div>


<script type="text/javascript">

	var logoutModule = (function() {
		var logoutTerm = 500000;
		var log = '';
		
		var logout = function() {
			log = window.setTimeout('alert("로그아웃"); location.href="logout"', logoutTerm);
		}
		
		var reset = function() {
			window.clearTimeout(log);
			logout();
		}
		
		document.onmousemove = function() { 
				reset(); 
		}
		
		return {
			logout : function() {
				logout();
			}
		}
	})();
	
	logoutModule.logout();
	
</script>