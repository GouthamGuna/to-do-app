<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title>Cerpsoft</title>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
		<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet" >
	</head>
	<body>
		<div class="container">
			<h1>Enter ToDo Details</h1>
			<form:form method="post" modelAttribute="todopojo">
			
				 <fieldset class="mb-3">
					 <form:label path="description">Description</form:label>
					 <form:input type="text" path="description" required="required"/>
					 <!-- <form:errors type="text" path="description"/> -->
				</fieldset> 
				
				 <fieldset class="mb-3">
					 <form:label path="date">Target Date</form:label>
					 <form:input type="text" path="date" required="required"/>
					 <!-- <form:errors type="text" path="description"/> -->
				</fieldset> 
				 
				<form:input type="hidden" path="id"/>
				
				<form:input type="hidden" path="done"/>
				
				<input type="submit" class="btn btn-success"/>
				
			</form:form>
		</div>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
		<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
		<script type="text/javascript">
			$('#date').datepicker({
			    format: 'yyyy-mm-dd',
			    startDate: '-3d'
			});
		</script>
	</body>
</html>