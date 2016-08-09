<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<title>미리보기</title>
<script	src="http://code.jquery.com/jquery-1.11.3.js"/></script>
</head>

<body>
<h1 style="text-align: center;">사진 미리보기</h1>

	아이디 : ${user }<br/>
	사진이름 : ${img }<br/><br/>
	<img src='resources/uploadImg/${img }' style="height:500px; width:400px;"/>

</body>
