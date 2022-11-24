<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<script src="//cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src=https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js></script>
<link href=https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script type="text/javascript" src=https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.21/js/jquery.dataTables.min.js></script>
<script type="text/javascript" src="functions.js"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Link</a>
        </li>
        <li class="nav-item">
        	<a class="nav-link" href="#">Welcome</a><%=session.getAttribute("adminFirstName")%>
        </li>
        <li class="nav-item">
        	<a class="nav-link" href="logOutPage.jsp">Logout</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

  <div class="panel-body">
  	<table id="t-librarians" class="table table-bordered" cellpadding="0" cellspacing="0" width="100%">
  		<thead>
  			<tr>
  				<th></th>
  				<th></th>
  				<th></th>
  				<th></th>
  				<th></th>
  				<th></th>
  				<th></th>
  			</tr>
  		</thead>		
  	</table>
  </div>
  
  <br></br>
 
  
  <div>
  	<button class="btn btn-primary" onclick="viewLibrarianAddPage()">Add Librarian</button>
  </div>
  
  
</body>
</html>