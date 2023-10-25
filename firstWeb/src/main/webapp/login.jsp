<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login page</title>
<link rel="stylesheet" href="style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

</head>
<body>
	<section class="container" >
		<div class="row content d-flex justify-content-center align-items-center">
			<div class="col-md-5 cardclass">
				<div class="card shadow bg-white p-4">
					<h3 class="mb-4 text-center fs-1">Sign In</h3>
					<h4 class="text-danger text-center"><%if(null!=request.getAttribute("nameMessage") || null!=request.getAttribute("passMessage"))
    {
        out.println("Login failed");
    } %> </h4>
					<form action="login" method="post" class="mb-3">
						<div class="form-floating mb-3">
							<input name="name" type="text" id="name" class="form-control rounded-0" id="floatingInput" /> 
							<label for="floatingInput">Username</label> 
							<div class="text-danger warning"> <%
    if(null!=request.getAttribute("nameMessage") && (request.getAttribute("nameMessage").toString().length())<=4)
    {
        out.println("Name cannot be less than 4 chars");
    }
   
%> </div>
							
							</div>
							
							<div class="form-floating mb-3">
							 
							<input name="pass" type="password" id="floatingPassword" class="form-control rounded-0" id="password" />
							<label for="floatingPassword">Password</label>
							<div class="text-danger warning"><%
    if(null!=request.getAttribute("passMessage") && (request.getAttribute("passMessage").toString().length())<=8)
    {
        out.println("Password cannot be less than 4 chars");
    }
%></div>
							</div>
							<div class="d-grid gap-2 mb-3">
							<button class="btn btn-dark btn-lg border-0 rounded-0" type="submit">Login</button>
							</div>
						
					</form>
				</div>
			</div>
		</div>
	</section>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
		integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
		crossorigin="anonymous"></script>

</body>
</html>