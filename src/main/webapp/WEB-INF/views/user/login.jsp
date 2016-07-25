<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<jsp:useBean id="now" class="java.util.Date" />
<!DOCTYPE html>
<html>
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
</head>
<body class="gray-bg">
    <div class="loginColumns animated fadeInDown">
        <div class="row">

            <div class="col-md-6">
                <h2 class="font-bold">Welcome to IN+</h2>

                <p>
                    Perfectly designed and precisely prepared admin theme with over 50 pages with extra new web app views.
                </p>

                <p>
                    Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s.
                </p>

                <p>
                    When an unknown printer took a galley of type and scrambled it to make a type specimen book.
                </p>

                <p>
                    <small>It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</small>
                </p>

            </div>
            <div class="col-md-6">
                <div class="ibox-content">
                    <form class="m-t" role="form" action="index.html">
                        <div class="form-group">
                            <input type="text" id="id" class="form-control" placeholder="UserID">
                        </div>
                        <div class="form-group">
                            <input type="password" id="password" class="form-control" placeholder="Password">
                        </div>
                        <button type="submit" id="loginBtn" class="btn btn-primary block full-width m-b">Login</button>

                        <a href="#">
                            <small>Forgot password?</small>
                        </a>

                        <p class="text-muted text-center">
                            <small>Do not have an account?</small>
                        </p>
                        <a class="btn btn-sm btn-white btn-block" href="register.html">Create an account</a>
                    </form>
                    <p class="m-t">
                        <small>Inspinia we app framework base on Bootstrap 3 © 2014</small>
                    </p>
                </div>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-md-6">
                Copyright Example Company
            </div>
            <div class="col-md-6 text-right">
               <small>© 2014-2015</small>
            </div>
        </div>
    </div>
    
    <script type="text/javascript">
    	$("#loginBtn").click(function(e) {
			e.preventDefault();
			AjaxController.request({
				   options: {
				      url: 'rest/user/login',
				      data : {
		 		      	id : $("#id").val(),
		 			  	password : $("#password").val()
			 		  },
			 			type : 'post'
				   }, 
				   callbacks: {
					   
			         done: function (data, textStatus, jqXHR) {
				            location.href = "/layout/test"; // 로그인 성공 시 일로
				      }
				   },
				   	  show: {
				      progress: true,
				      failMessage: true
				   }
				});
		});
    </script>
</body>
</html>