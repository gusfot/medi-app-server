<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="${resourcePath}/js/map-controller.js"></script>
<form action="">
<input type="text" id="searchKeyword" value="" />
</form>

<button id="naver">네이버 지도로 검색</button>
<button id="google">구글 지도로 검색</button>
<button id="daum">다음 지도로 검색</button>

<script type="text/javascript">

	$('#naver').click(function() {
		var searchKeyword = $('#searchKeyword').val();
		mapModule.findByNaver(searchKeyword);
	});
	$('#google').click(function() {
		var searchKeyword = $('#searchKeyword').val();
		mapModule.findByGoogle(searchKeyword);
	});
	$('#daum').click(function() {
		var searchKeyword = $('#searchKeyword').val();
		mapModule.findByDaum(searchKeyword);
	});
</script>

