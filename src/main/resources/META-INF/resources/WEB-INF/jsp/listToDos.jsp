<%@include file="common/header.jspf" %>
<%@include file="common/navigation.jspf" %>

<div class="container">
	<h1>Your ToDo's</h1>
	<!-- <hr> -->
	<table class="table">
		<thead>
			<tr>
				<!-- <th>ID</th> -->
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
				<th>Delete</th>
				<th>Update</th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach items="${showList}" var="todo">
				<tr>
					<%-- <td>${todo.id}</td> --%>
					<td>${todo.description}</td>
					<td>${todo.date}</td>
					<td>${todo.done}</td>
					<td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
					<td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/add-todo" class="btn btn-success">Add ToDo</a>
</div>

<%@include file="common/footer.jspf" %>
		