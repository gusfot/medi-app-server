<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Login</title>
<script src="http://code.jquery.com/jquery-1.11.3.js"></script>
<script src="/resources/js/ajax-controller.js"></script>
<script src="/resources/js/pop.js"></script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<script>

$(document).ready(function(){
	
	$("#loginBtn").click(function(e) {
        e.preventDefault();
        AjaxController.request({
               options: {
                  url: '/jsonLogin',
                  data : {
                       id : $("#id").val(),
                       password : $("#password").val()
                   },
                     type : 'post'
               }, 
               callbacks: {
                   
                 done: function (data, textStatus, jqXHR) {
                       location.href='/loginOk';
                  },
                  fail: function (jqXHR, textStatus, errorThrown) {
                	  console.log(jqXHR);
                	  console.log(textStatus);
                	  console.log(errorThrown);
                		alert(2);  
                  }
               },
                     show: {
                  progress: false,
                  failMessage: true
               }
            });
        });
	
});

</script>

</head>

<body>
<div class="container">



  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">id</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="id" name="id" value="admin" placeholder="id">
    </div>
  </div>
  
  <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="password" name="password" value="1234" placeholder="Password">
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
          <input type="checkbox"> Remember me
        </label>
      </div>
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button id="loginBtn" type="button" class="btn btn-default">로그인</button>
      <button class="btn btn-default" onclick="insertPop()">화원가입</button>
    </div>
  </div>
  


</div>
</body>
</html>