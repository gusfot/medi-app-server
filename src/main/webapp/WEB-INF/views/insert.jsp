<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
	<title>화원가입</title>
	<script src="http://code.jquery.com/jquery-1.11.3.js"></script>
</head>

<body>
<form action="insertOk" method="post" enctype="multipart/form-data">
<table border="1" align="center">
	<thead>
		<h1 style="text-align: center;">화원가입</h1>
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
			<input type="file" id="pFile" name="multipartFile"/>
		</td>
	</tr>
	<!-- <tr>
		<td><label>배경사진</label></td>
		<td>
			<div id="row">
				<input type="file" id="bFile" name="multipartFile"/>
			</div>
		</td>

		<td><input type="button" id="btn-add-row" value="행추가" /></td>
		<td colspan="3"><input type="button" id="btn-delete-row" value="삭제" /></td>
	</tr> -->
	<tr>
		<td colspan="6" style="text-align: center;">
			<input type="submit" id="submit" value="가입하기"/>
			<input type="button" id="cancle" value="닫기" onclick="window.close()"/>
		</td>
	</tr>
</table>
</form>

	<!-- <script>
		$(function() {
			$('#btn-add-row')
					.click(
							function() {
								$('#row')
										.append(
												'<div><input type="file" name="multipartFile" size="60" class="text"/></div>');
							});
			$('#btn-delete-row').click(function() {
				$('#row > div:last').remove();//마지막 div 보다 row 가 크면 ??제거
			});
		});
	</script> -->

</body>
</html>
