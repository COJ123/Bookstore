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

        <input type="button" value="Listed By Authors"
               onclick="window.location.href='listByAuthors'; return false;"
               class="add-button"
        />

        <input type="button" value="Listed By Genres"
               onclick="window.location.href='listByGenres'; return false;"
               class="add-button"
        />

        <input type="button" value="Buy"
               onclick="window.location.href='purchase'; return false;"
               class="add-button"
        />


        <input type="button" value="Admin Interface"
               onclick="window.location.href='${pageContext.request.contextPath}/bookstoreEditor/list'; return false;"
               class="add-button"
        />

        <table>
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Price</th>
                <th>Genre</th>
                <th>Author</th>
            </tr>

            <!-- loop over and print our customers -->
            <c:forEach var="tempBook" items="${books}">

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
                </tr>

            </c:forEach>

        </table>

    </div>

</div>


</body>

</html>
