<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="menu.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>
<div style="width: 100%; height: 680px; background-color: lime;">

<button onclick="excelDownload()">엑셀 다운로드</button></t>
<button onclick="excelUpload()">엑셀 업로드</button>

</div>
<jsp:include page="footer.jsp"></jsp:include>

<script>

function excelDownload(){
	location.href="excelDownload";
}
function excelUpload(){
	location.href="excelUpload";
}

</script>