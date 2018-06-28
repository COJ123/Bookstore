<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Book</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>BookStore</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Book</h3>

		<p>
			<a href="${pageContext.request.contextPath}/bookstoreEditor/list">Back to List</a>
		</p>

		<form:form action="saveBook" modelAttribute="book" method="POST">
			<form:hidden path="id"/>

			<table>
				<tbody>
					<tr>
						<td><label>Title:</label></td>
						<td><form:input path="title" /></td>
					</tr>
				
					<tr>
						<td><label>Description:</label></td>
						<td><form:input path="description" /></td>
					</tr>

					<tr>
						<td><label>Price:</label></td>
						<td><form:input path="price" /></td>
					</tr>

					<tr>
						<td><label>Genres:</label></td>

						<td><form:select path="genres" items="${genres}" multiple="true" itemValue="id" itemLabel="genre"/></td>


					</tr>

					<tr>
						<td><label>Authors:</label></td>

						<td><form:select path="authors" items="${authors}" multiple="true" itemValue="id" itemLabel="author"/></td>

					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style=""></div>
		

	
	</div>

</body>

</html>










