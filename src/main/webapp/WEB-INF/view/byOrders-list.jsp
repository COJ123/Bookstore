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
        <h2>Book Store - By Orders</h2>
    </div>
</div>

<div id="container">
    <p>
        <a href="${pageContext.request.contextPath}/bookstore/list">Back to List</a>
    </p>
    <div id="content">
        <c:forEach var="tempOrder" items="${orders}">
            <h2>${tempOrder.author}</h2>
            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last name</th>
                    <th>Book</th>
                    <th>Quantity</th>
                </tr>
                <c:forEach var="tempBook" items="${tempAuthor.books}">
                    <tr>
                        <td> ${tempBook.title} </td>
                        <td> ${tempBook.description} </td>
                        <td> ${tempBook.price} </td>
                        <td>
                            <c:forEach var="tempGenre" items="${tempBook.genres}">
                                ${tempGenre.genre}
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:forEach>
    </div>

</div>
</body>
</html>
