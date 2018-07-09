<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display:700,900" rel="stylesheet">
    
<title>회원가입</title>
</head>
<body>
	<div class="container">
		<form action="/signUp" method="post">
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="email">아이디</label>
		      <input type="text" class="form-control" id="id" name="id" maxlength="20" placeholder="Email">
		    </div>
		    <div class="form-group col-md-6">
		      <label for="passwd">비밀번호</label>
		      <input type="password" class="form-control" id="passwd" name="passwd" maxlength="20" placeholder="비밀번호">
		    </div>
		  </div>
		  <div class="form-group">
		    <label for="name">이름</label>
		    <input type="text" class="form-control" id="name" name="name" maxlength="20" placeholder="이름">
		  </div>
		  <div class="form-group">
		    <label for="cellPhone">휴대폰번호</label>
		    <input type="text" class="form-control" id="cellPhone" name="cellPhone" maxlength="13" placeholder="휴대폰번호">
		  </div>
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="inputCity">생년월일</label>
		      <input type="date" class="form-control" name="birthday">
		    </div>
		    <div class="form-group col-md-6">
		      <label for="inputState">양/음력</label>
		      <select name="birthday_solar" class="form-control">
		        <option value="Y" selected>양력</option>
		        <option value="N">음력</option>
		      </select>
		    </div>
		  </div>
		  <!-- 
		  <div class="form-group">
		    <div class="form-check">
		      <input class="form-check-input" type="checkbox" id="gridCheck">
		      <label class="form-check-label" for="gridCheck">
		        Check me out
		      </label>
		    </div>
		  </div>
		   -->
		  <button type="submit" class="btn btn-primary">회원 가입</button>
		</form>
	</div>
</body>
</html>