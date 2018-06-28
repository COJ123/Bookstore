<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
    <title>List of Books</title>

    <!-- reference our style sheet -->

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

<div id="wrapper">
    <div id="header">
        <h2>Book Store</h2>
    </div>
</div>

<div id="container">

    <div id="content">

        <p>
            <a href="${pageContext.request.contextPath}/bookstoreEditor/list">Back to List</a>
        </p>

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Address</th>
                <th>Book</th>
                <th>Quantity</th>
            </tr>

            <!-- loop over and print our customers -->
            <c:forEach var="tempOrder" items="${orders}">

                <tr>
                    <td> ${tempOrder.firstName} </td>
                    <td> ${tempOrder.lastName} </td>
                    <td> ${tempOrder.address} </td>
                    <td> ${tempOrder.book} </td>
                    <td> ${tempOrder.quantity} </td>
                </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

</html>
