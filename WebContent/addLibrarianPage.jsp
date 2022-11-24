<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- CSS only -->
<script src="//cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
<script src=https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js></script>
<link href=https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script type="text/javascript" src=https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.21/js/jquery.dataTables.min.js></script>
<script type="text/javascript" src="functions.js"></script>
<title>Insert title here</title>
</head>
<body>
	<section class="vh-100 bg-image"
  style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
  <div class="mask d-flex align-items-center h-100 gradient-custom-3">
    <div class="container h-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6">
          <div class="card" style="border-radius: 15px;">
            <div class="card-body p-5">
            <button type="button" class="btn btn-warning" onclick="backToMainPage()">Main Page</button>
              <h2 class="text-uppercase text-center mb-5">Add Librarian</h2>

              <form id="addLibForm" method="post">
                <div class="form-outline mb-4">
                  <input type="text" id="firstName" name="firstName" class="form-control form-control-lg" required/>
                  <label class="form-label" for="firstName">Librarian First Name</label>
                </div>

                <div class="form-outline mb-4">
                  <input type="text" id="lastName" name="lastName" class="form-control form-control-lg" required/>
                  <label class="form-label" for="lastName">Librarian Last Name</label>
                </div>

                <div class="form-outline mb-4">
                  <input type="email" id="em" name="em" class="form-control form-control-lg" required/>
                  <label class="form-label" for="em">Email</label>
                </div>

                <div class="form-outline mb-4">
                  <input type="text" id="country" name="country" class="form-control form-control-lg" required/>
                  <label class="form-label" for="country">Country</label>
                </div>
                             
                <div class="d-flex justify-content-center">
                  <button class="btn btn-success" onclick="addLibrarian()">Add</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>