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
			<a href="${pageContext.request.contextPath}/bookstore/list">Back to List</a>
		</p>

		<form:form action="saveOrder" modelAttribute="order" method="POST">
			<form:hidden path="id"/>

			<table>
				<tbody>
					<tr>
						<td><label>First Name:</label></td>
						<td><form:input path="firstName" /></td>
					</tr>
				
					<tr>
						<td><label>Last Name:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>

					<tr>
						<td><label>Address:</label></td>
						<td><form:input path="address" /></td>
					</tr>

					<tr>
						<td><label>Book:</label></td>
						<td><form:select path="book" items="${books}" multiple="false" itemValue="title" itemLabel="title"/></td>
					</tr>

					<tr>
						<td><label>Quantity:</label></td>
						<td><form:input path="quantity" /></td>
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










