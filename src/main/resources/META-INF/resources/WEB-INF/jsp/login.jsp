<html>
	<head>
		<title>Cerpsoft</title>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" />
		<script type = "text/javascript"  src = "https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>	
	</head>
	<body>
		<div class="container">
			<form method="post" class="row g-3">
					<h1>Please sign in</h1>
				  <div class="mb-3 row">
				    <label for="staticEmail" class="col-sm-2 col-form-label">username</label>
				    <div class="col-sm-7">
				      <input type="text" class="form-control" name="name" placeholder="email@domine.com" required="required">
				    </div>
				  </div>
				  <div class="mb-3 row">
				    <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
				    <div class="col-sm-7">
				      <input type="password" class="form-control" name="password" required="required">
				    </div>
  				 </div>
  				 <br>
  				 <div class="col-sm-10">
  				 	<button type="submit" class="btn btn-outline-success">Login</button>
  				 </div>
			</form>
			<br>
			<div class="alert alert-danger alert-dismissible fade show" role="alert">
				${error}
				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
			</div>
		</div>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
		<script type="text/javascript">
				$(".alert-dismissible").fade();
		</script>
	</body>
</html>