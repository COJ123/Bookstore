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

        <input type="button" value="Add Book"
               onclick="window.location.href='AddForm'; return false;"
               class="add-button"
        />

        <input type="button" value="Add Author"
               onclick="window.location.href='AddAuthor'; return false;"
               class="add-button"
        />

        <input type="button" value="Add Genre"
               onclick="window.location.href='AddGenre'; return false;"
               class="add-button"
        />

        <input type="button" value="Show Purchases"
               onclick="window.location.href='list-orders'; return false;"
               class="add-button"
        />

        <p>
            <a href="${pageContext.request.contextPath}/bookstore/list">Back to List</a>
        </p>

        <table>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Price</th>
                <th>Genre</th>
                <th>Author</th>
                <th>Upd|Del</th>
            </tr>

            <!-- loop over and print our customers -->
            <c:forEach var="tempBook" items="${books}">

                <c:url var="updateLink" value="/bookstoreEditor/updateForm">
                    <c:param name="bookTitle" value="${tempBook.title}"/>   <!-- bookId-->
                </c:url>

                <c:url var="deleteLink" value="/bookstoreEditor/deleteBook">
                    <c:param name="bookId" value="${tempBook.id}"/>
                </c:url>

                <tr>
                    <td> ${tempBook.title} </td>
                    <td> ${tempBook.description} </td>
                    <td> ${tempBook.price} </td>
                    <td>
                        <c:forEach var="tempGenre" items="${tempBook.genres}">
                            ${tempGenre.genre}
                        </c:forEach>
                    </td>
                    <td>
                        <c:forEach var="tempAuthor" items="${tempBook.authors}">
                            ${tempAuthor.author}
                        </c:forEach>
                    </td>
                    <td>
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Are you sure about that?'))) return false">Delete</a>
                    </td>
                </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

</html>