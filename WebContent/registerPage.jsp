<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
  <section>
    <div class="container"> 
      <div class="row justify-content-center">
        <div class="col-12 col-md-8 col-lg-8 col-xl-6">
          <div class="row">
            <div class="col text-center">
              <h1>Register</h1>
              <p class="text-h3">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia. </p>
            </div>
          </div>
          <form action="RegisterAdminServlet" method="post">
	          <div class="row align-items-center">
	            <div class="col mt-4">
	              <input type="text" class="form-control" id="username" name="username" placeholder="Username">
	            </div>
	          </div>
	          <div class="row align-items-center mt-4">
	            <div class="col">
	              <input type="password" id="pws" name="pws" class="form-control" placeholder="Password">
	            </div>
	          </div>
	          <div class="row align-items-center mt-4">
	            <div class="col">
	              <input type="text" class="form-control" id="firstName" name="firstName" placeholder="First Name">
	            </div>
	            <div class="col">
	              <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Last Name">
	            </div>
	          </div>
	          <div class="row justify-content-start mt-4">
	            <div class="col">
	              <button class="btn btn-primary mt-4">Register</button>
	            </div>
            </form>
          </div>
        </div>
      </div>
    </div>
 </section>
</body>
</html>