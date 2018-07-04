<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta http-equiv="cache-control" content="max-age=0" />
	<meta http-equiv="cache-control" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	<meta http-equiv="expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
	<meta http-equiv="pragma" content="no-cache" />
	
	<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request" />
	<c:set var="resourcePath" value="${contextPath}/resources" scope="request" />
	<c:set var="inspiniaPath" value="${resourcePath}/lib/inspinia" scope="request" />
	
	<!-- Style Sheet -->
	<link rel="stylesheet" href="${inspiniaPath}/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${inspiniaPath}/font-awesome/css/font-awesome.css" />
	<link rel="stylesheet" href="${inspiniaPath}/css/animate.css" />
	<link rel="stylesheet" href="${inspiniaPath}/css/style.css" />
	<link rel="stylesheet" href="${resourcePath}/lib/sweetalert/sweetalert.css" />
	
	<link rel="stylesheet" href="${resourcePath}/css/layouts/layout_normal.css" />
	
	<!-- Script -->
	<script src="${inspiniaPath}/js/jquery-2.1.1.js"></script>
	<script src="${inspiniaPath}/js/bootstrap.min.js"></script>
	<script src="${inspiniaPath}/js/plugins/metisMenu/jquery.metisMenu.js"></script>
	<script src="${inspiniaPath}/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	
	<script src="${inspiniaPath}/js/inspinia.js"></script>
	
	<!-- Custom and plugin javascript -->
	<script src="${inspiniaPath}/js/plugins/pace/pace.min.js"></script>

	<script src="${resourcePath}/lib/sweetalert/sweetalert.min.js"></script>
	<script src="${resourcePath}/js/ajax-controller.js"></script>
	
	<!-- naver smarteditor -->
	<script type="text/javascript" src="${resourcePath}/smarteditor/js/HuskyEZCreator.js" charset="UTF-8"></script>
	
	<title>플라시스템</title>
</head>

<body id="tilesBody">
	<div id="wrapper">
		<nav class="navbar navbar-static-top white-bg" role="navigation">
			<tiles:insertAttribute name="header" />
		</nav>
		<nav class="navbar-default navbar-static-side" role="navigation">
			<tiles:insertAttribute name="side" />
		</nav>
		<div id="page-wrapper" class="gray-bg dashbard-1">
			<div class="layout-body">
				<tiles:insertAttribute name="body" />
			</div>
			<div class="layout-footer">
				<tiles:insertAttribute name="footer" />
			</div>
		</div>
	</div>
</body>
</html>