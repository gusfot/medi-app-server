<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!doctype html>
<html lang="en">
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

	<link rel="stylesheet" href="${resourcePath}/css/user/login.css" />
	
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
	
	<title>플라시스템</title>

<!-- 	세션에 값이 있는 상태에서 url로 로그인 페이지 접근 시 첫 화면으로 가게 한다.  -->
	<script type="text/javascript">
    	var isLogged = function() {
    		if('${sessionScope.sessionUserVO}' != '') {
    			location.href="/layout/test";
    		}
    	}();
    </script>
</head>
<body class="gray-bg">
    <div class="loginColumns animated fadeInDown">
    	<div class="row">
            <div class="col-md-7">
                <div class="logoDiv">
					<img src="" alt="가로 300 세로 60 전국플라워센터" class="logoImg" />
				</div>
            </div>
        </div>
        <div class="row"> 
            <div class="col-md-7">
            	<img src="" alt="가로 566 세로 350 메인이미지" class="mainImg" />
            </div>
            <div class="col-md-5 loginFrmDiv">
                <div class="ibox-content">
                	<img src="" alt="가로 340 세로 55 로그인 이미지" class="loginImg"/>
                    <form class="m-t" role="form" action="index.html"> 
                    	<div class="loginRadioDiv">
                    		<input type="radio" name="manager" value="화원사" checked="checked">화원사&nbsp;&nbsp;&nbsp; 
                    		<input type="radio" name="manager" value="관리자">관리자
                        </div>
                        <div class="loginInputDiv">
                        	<div class="inputDiv">
		                        <div class="input-group input-group-sm">
		                        	<span class=" input-group-addon">ID</span>
		                        	<input type="text" class="form-control inputId" id="id" placeholder="" >
		                        </div>
		                        <div class="input-group input-group-sm" style="margin-top: 5px;">
		                        	<span class="input-group-addon">PW</span>
		                        	<input type="text" class="form-control inputPwd" id="password" placeholder="" >
		                        </div>
		                        <div class="input-group input-group-sm" style="margin-top: 5px;">
		                        	<span class="input-group-addon">KEY</span>
		                        	<input type="text" class="form-control inputKey" id="key" placeholder="" >
		                        </div>
	                        </div>
	                        <div class="loginBtnDiv">
	                        	<button class="btn btn-primary m-b loginBtn" id="loginBtn">Login</button>
                        	</div>
                        </div>
                        <div class="loginChkBoxDiv">
                        	<input type="checkbox" name="idSave">ID저장&nbsp;
                        	<input type="checkbox" name="pwdSave">PWD저장&nbsp;
                        	<input type="checkbox" name="keySave">KEY저장&nbsp;
                        </div>
						<div class="loginInfoDiv">
							<p>· 개인컴퓨터가 아닐 경우 저장 체크 시 개인 정보가 타인에게 노출 될 수 있습니다.</p>
							<p>· 인트라넷 사용 시 에러나 기타문의 는 고객센터로 연락주세요.</p>
						</div>
                    </form>
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="col-md-12">
                <div class="midImgDiv">
					<img src="" alt="가로 278 세로 145 고객센터" class="midImg1"/>
					<img src="" alt="가로 278 세로 145 업무시간" class="midImg2"/>
					<img src="" alt="가로 190 세로 145 가맹점 가입신청" class="midImg3"/>
					<img src="" alt="가로 190 세로 145 가맹종료 화원사 계산서 확인" class="midImg4"/>
				</div>
            </div>
        </div>
        
        <div class="row">
            <div class="col-md-12">
                <div class="certiCooperDiv">
                	<img src="" alt="가로 660 세로 70" class="certiImg"/>
					<div class="cooperDiv">
						<div id="myCarousel" class="carousel slide" data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
								<li data-target="#myCarousel" data-slide-to="1"></li>
								<li data-target="#myCarousel" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner" role="listbox">
								<div class="item active">
									<div class="bannerDiv">
										<img src="" alt="협력사 배너1" class="bannerImg">
									</div>
									<div class="bannerDiv">
										<img src="" alt="협력사 배너2" class="bannerImg">
									</div>
								</div>

								<div class="item">
									<div class="bannerDiv">
										<img src="" alt="협력사 배너3" class="bannerImg">
									</div>
									<div class="bannerDiv">
										<img src="" alt="협력사 배너4" class="bannerImg">
									</div>
								</div>

								<div class="item" style="float: left;">
									<div class="bannerDiv">
										<img src="" alt="협력사 배너5" class="bannerImg">
									</div>
									<div class="bannerDiv">
										<img src="" alt="협력사 배너6" class="bannerImg">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
        	</div>
        </div>
        
        <div class="row">
            <div class="col-md-12">
                <div class="loginFooterDiv">
					<img src="" alt="가로 560 세로 70" class="footerImg1" />
					<img src="" alt="가로 150 세로 70" class="footerImg2" />
				</div>
            </div>
        </div>
    </div>
    
<script type="text/javascript">
    $("#loginBtn").click(function(e) {
		e.preventDefault();
		AjaxController.request({
			options : {
				url : '/rest/admin/login',
				data : {
					id : $("#id").val(),
					password : $("#password").val()
				},
				type : 'post'
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
</script>
</body>
</html>
