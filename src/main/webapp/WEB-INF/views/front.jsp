<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="request" />

	<meta http-equiv="Content-Type" content="text/html;charset=euc-kr" />
	<title>플라시스템</title>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<link rel="stylesheet" href="${contextPath}/resources/lib/sweetalert/sweetalert.css">

	<!-- jQuery Customize -->
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="${contextPath}/resources/lib/sweetalert/sweetalert.min.js"></script>
	<script src="${contextPath}/resources/js/ajax-controller.js"></script>
</head>
<body>
<div>
	<h1>Ajax 테스트 페이지</h1>
	<button type="button" onclick="onClickAlertTest();">alert</button>
	<button type="button" onclick="onClickAjaxTest();">ajax</button>
</div>
<script type="text/javascript">
	function onClickAlertTest() {
		swal({
			title: "Are you sure?",
			text: "You will not be able to recover this imaginary file!",
			type: "warning",
			showCancelButton: false,
			confirmButtonColor: "#DD6B55",
			confirmButtonText: "Yes, delete it!",
			closeOnConfirm: false,
			html: false
		}, function(){
			swal("Deleted!",
					"Your imaginary file has been deleted.",
					"success");
		});
	}

	function onClickAjaxTest() {
		AjaxController.request({
			options: {
				url: 'test'
			}, callbacks: {
				warningAlertCallback: function() {
					alert('after process');
				}
			}
		})
	}
</script>
</body>

</html>