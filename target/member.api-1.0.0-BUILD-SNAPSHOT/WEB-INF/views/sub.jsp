<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
<title>엑셀 업/다운로드</title>
<script	src="http://code.jquery.com/jquery-1.11.3.js"/></script>
<script src="/resources/js/pop.js"></script>
</head>

<body>
<jsp:include page="menu.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>


<div style="width: 100%; height: 680px; background-color: lime;">

<button onclick="excelDownload()">엑셀 다운로드</button></br></br>

<!-- 엑셀 다운로드 소스코드 -->
<form name="frm1" method="post" action="excelUpload" enctype="multipart/form-data">
	<table border="0">
		<tr><td colspan="2"><B>**주의사항**</B></td></tr>
		<tr><td colspan="2">*엑셀 파일만 업로드 가능합니다.</td></tr>
		<tr><td colspan="2">*첫번째 시트에 데이터가 있어야 합니다.[시트명:sheet1]</td></tr>
		<tr><td colspan="2">*엑셀작성시 중간에 빈줄이 없어야 합니다.</td></tr>
		<tr>
			<td colspan="2">
				<a href="">양식다운로드
					<img src="">
				</a>
			</td>
		</tr>
		<tr height="5"><td></td></tr>
		<tr>
			<td>파일명</td>
			<td><input type="file" id="excelUpload" name="excelUpload" size="40"></td>
		</tr>
		<tr height="5"><td></td></tr>
		<tr>
			<td colspan="2" align="center">
				<button onclick="javascript:goInsert();"/>등록
			</td>
		</tr>
	</table>
</form>
<!-- 엑셀 다운로드 소스코드 -->
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>

<script>

function excelDownload(){
	location.href="excelDownload";
}

//등록
function goInsert() {
	var f = document.frm1;
	if(f.file1.value == ""){
		alert("파일을 선택해 주세요.");
		return;
	}
	var fileNameLen = f.file1.value.length;
	if(f.file1.value.substring(fileNameLen-3, fileNameLen) != "xls") {
		alert("확장자가 xls인 엑셀파일을 선택해 주세요");
		return;
	}
	f.submit();
}

</script>