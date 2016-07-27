<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<jsp:useBean id="now" class="java.util.Date" />
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<div class="logo-wrapper">
		<img class="img-logo" src="" alt="logo" />
	</div>
	<div class="collapse-toggle">
		<a class="navbar-minimalize" href="#"><i class="fa fa-angle-left"></i> </a>
	</div>
	<div class="sidebar-collapse">
		<ul class="nav metismenu" id="side-menu">
			<li id="test1">
				<a href="#"><i class="fa fa-diamond"></i> <span class="nav-label">본부발주</span></a>
			</li>
			<li id="test2">
				<a href="#"><i class="fa fa-diamond"></i> <span class="nav-label">회원간직발주</span></a>
			</li>
			<li>
				<a href="#"><i class="fa fa-diamond"></i> <span class="nav-label">금일발주</span></a>
			</li>
			<li class="active">
				<a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">관리자 수발주</span></a>
				<ul class="nav nav-second-level">
					<li class="active"><a href="#">협회 전체 수발주</a></li>
					<li><a href="#">본부중계창</a></li>
					<li><a href="#">취소주문List</a></li>
					<li><a href="#">직접발주List</a></li>
					<li><a href="#">미확인List</a></li>
					<li><a href="#">클레임List</a></li>
					<li><a href="#">주문거절List</a></li>
					<li><a href="#">배송사진미등록List</a></li>
					<li><a href="#">지정주문통계</a></li>
					<li><a href="#">취약지역발주통계</a></li>
					<li><a href="#">전국파트너발주통계</a></li>
					<li><a href="#">본부발주물량통계</a></li>
				</ul>
			</li>
			<li>
				<a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">관리자</span></a>
				<ul class="nav nav-second-level">
					<li><a href="#">sample1</a></li>
					<li><a href="#">sample2</a></li>
				</ul>
			</li>
			<li>
				<a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">수발주</span></a>
				<ul class="nav nav-second-level">
					<li><a href="#">sample1</a></li>
					<li><a href="#">sample2</a></li>
				</ul>
			</li>
			<li>
				<a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">통계</span></a>
				<ul class="nav nav-second-level">
					<li><a href="#">sample1</a></li>
					<li><a href="#">sample2</a></li>
				</ul>
			</li>
			<li id="board">
				<a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">게시판</span></a>
				<ul class="nav nav-second-level">
					<li><a href="#">sample1</a></li>
					<li><a href="#">sample2</a></li>
				</ul>
			</li>
			<li>
				<a href="#"><i class="fa fa-th-large"></i> <span class="nav-label">기타</span></a>
				<ul class="nav nav-second-level">
					<li><a href="#">sample1</a></li>
					<li><a href="#">sample2</a></li>
				</ul>
			</li>
			<li class="side-lnb">
				<div class="side-lnb-btn-wrapper profile-element">
					<button type="button" class="btn btn-sm btn-default btn-block">발신번호 사전등록</button>
				</div>
				<div class="logo-element">+</div>
			</li>
			<li>
				<div class="side-lnb-btn-wrapper profile-element">
					<button type="button" class="btn btn-sm btn-default btn-block">리본에 그림넣기</button>
				</div>
				<div class="logo-element">+</div>
			</li>
			<li>
				<div class="side-lnb-btn-wrapper profile-element">
					<button type="button" class="btn btn-sm btn-default btn-block">도움말</button>
				</div>
				<div class="logo-element">+</div>
			</li>
		</ul>
	</div>
	
	<script type="text/javascript">
		$("#test1").click(function(e) {
			e.preventDefault();
			AjaxController.request({
				options : {
					url : '/rest/user/test1',
				},
				callbacks : {
					done : function(data, textStatus, jqXHR) {
						if (data.success === true) {
							location.href = "/layout/test";
						}
					}
				},
				show : {
					progress : true,
					failMessage : true
				}
			});
		});
		
		$("#test2").click(function(e) {
			e.preventDefault();
			AjaxController.request({
				options : {
					url : '/rest/user/test2',
				},
				callbacks : {
					done : function(data, textStatus, jqXHR) {
						if (data.success === true) {
							location.href = "/layout/test";
						}
					}
				},
				show : {
					progress : true,
					failMessage : true
				}
			});
		});
		
		$("#board").click(function(e) {
			e.preventDefault();
			location.href = "/layout/smarteditor";
		});
	</script>
	
</body>
</html>