<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
    <link href="/resources/css/blog.css" rel="stylesheet">
    <script>
	    if("${sessionScope.user.name}"!="") {
	    	location.href = '/index';
	    } 
    </script>
    <title>로그인</title>
  </head>
<body>
	<div class="container">
		<div class="row justify-content-md-center">
			<form action="/login" method="post">
			  <div class="form-group row">
			    <label for="inputEmail3" class="col-sm-2 col-form-label">Email</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" id="userId" name="userId" placeholder="아이디">
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
			    <div class="col-sm-10">
			      <input type="password" class="form-control" id="passwd" name="passwd" placeholder="비밀번호">
			    </div>
			  </div>
			  <fieldset class="form-group">
			    <div class="row">
			      <legend class="col-form-label col-sm-2 pt-0">Radios</legend>
			      <div class="col-sm-10">
			        <div class="form-check">
			          <input class="form-check-input" type="radio" name="gridRadios" id="gridRadios1" value="option1" checked>
			          <label class="form-check-label" for="gridRadios1">
			            First radio
			          </label>
			        </div>
			      </div>
			    </div>
			  </fieldset>
			  <div class="form-group row">
			    <div class="col-sm-2">Checkbox</div>
			    <div class="col-sm-10">
			      <div class="form-check">
			        <input class="form-check-input" type="checkbox" id="gridCheck1">
			        <label class="form-check-label" for="gridCheck1">
			          Example checkbox
			        </label>
			      </div>
			    </div>
			  </div>
			  <div class="form-group row">
			    <div class="col-sm-10">
			      <button type="submit" class="btn btn-primary">Sign in</button>
			    </div>
			  </div>
			</form>
		</div>
	</div>
</body>
</html>