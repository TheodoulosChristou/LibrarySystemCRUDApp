<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<%@include file="index.jsp"%>
	<form action="LoginAdminServlet" method="post">
	  <div class="mb-3">
	    <label for="username" class="form-label">Username</label>
	    <input type="text" class="form-control" id="username" name="username">
	  </div>
	  <div class="mb-3">
	    <label for="pws" class="form-label">Password</label>
	    <input type="password" class="form-control" id="pws" name="pws">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>

</body>
</html>