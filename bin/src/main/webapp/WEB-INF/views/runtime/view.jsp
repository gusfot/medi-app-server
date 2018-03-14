<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request" />

	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
	<title>플라시스템</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	
	<link rel="stylesheet" href="${contextPath}/resources/lib/sweetalert/sweetalert.css">
	
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="${contextPath}/resources/lib/sweetalert/sweetalert.min.js"></script>
	<script src="${contextPath}/resources/js/ajax-controller.js"></script>
</head>
<body>
<div>
	<h1>런타임 체크</h1>
	<button type="button" onclick="onClickCheck();">check</button>
</div>
<script type="text/javascript">
	var contextPath = '${pageContext.request.contextPath}';
	
	function onClickCheck() {
		AjaxController.request({
			options: {
				url: contextPath + '/runtime/check'
			}
		})
	}
</script>
</body>
</html>