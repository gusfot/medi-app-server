<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<title>정보수정</title>
<script	src="http://code.jquery.com/jquery-1.11.3.js"/></script>
<script src="/resources/js/pop.js"></script>
</head>

<body>
<form action="updateOk" method="post" enctype="multipart/form-data">
<table border="1" align="center">
	<thead>
		<h1 style="text-align: center;">정보수정</h1>
	</thead>
	<tr>
		<td>user_id</td>
		<td colspan="5"><input type="text" id="id" name="userId" value="admin"/></td>
	</tr>
	<tr>
		<td>user_id</td>
		<td>user_seq</td>
		<td>user_name</td>
		<td>reg_dt</td>
		<td>password</td>
		<td>addr</td>
	</tr>
	<tr>
		<td>cell_phone</td>
		<td>home_phone</td>
		<td>job</td>
		<td>gender</td>
		<td>birth</td>
		<td>email</td>
	</tr>
	<tr>
		<td>dept_seq</td>
		<td>reg_time</td>
		<td>role_seq</td>
		<td>flag</td>
		<td>academic</td>
		<td>magor</td>
	</tr>
	<tr>
		<td>profileImg</td>
		<td colspan="5">
			<input type="file" id="pFile" name="multipartFile" value="사진등록"/>
			<button type="button" style="width:33px;height:33px; border:0px; background:URL('/resources/img/preImg.png');" onclick="imgPop('preImg','미리보기')"></button>미리보기
		</td>
	</tr>
	<tr>
		<td colspan="6" style="text-align: center;">
			<input type="submit" id="submit" value="수정하기"/>
			<input type="button" id="cancle" value="닫기" onclick="window.close()"/>
		</td>
	</tr>
</table>
</form>
</body>