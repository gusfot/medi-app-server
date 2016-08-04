<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div style="background-color: green; width: 150px; height: 950px; float: left;">
<div style="text-align: center">
<h1>MENU</h1>
<button onclick="main()">Main</button><br/><br/>
<button onclick="excel()">엑셀관련</button><br/><br/>
</div>
</div>
<script type="text/javascript">
function main() {
	location.href = "/main";
}

function excel() {
	location.href = "/sub";
}
</script>
