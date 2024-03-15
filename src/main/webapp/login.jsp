<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="Css/login.css">
</head>
<body>
<jsp:include page="/head.jsp"></jsp:include>
    <form action="login" method="post">
        <div class="form-container">
  <h2>Login for New Home</h2>

  <label for="username">Username:</label>
  <input type="text" id="username" name="email" placeholder="Enter your username" required>

  <label for="password">Password:</label>
  <input type="password" id="password" name="password" placeholder="Enter your password" required>

  <button onclick="submitLoginForm()">Login</button>

  <div class="register-link">
    <p>If you are new, <a href="register.jsp">register here</a>.</p>
  </div>
</div>
        
	</form>
<div class="footInclude">
<jsp:include page="/foot.jsp"></jsp:include>
</div>
</body>
</html>