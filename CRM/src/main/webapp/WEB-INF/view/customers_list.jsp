<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Customers List</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous"/>

</head>
<body>
<nav id="mainNav" class="navbar navbar-expand-lg navbar-light bg-dark fixed-top justify-content-center">
    <a class="navbar-brand text-danger" href="${pageContext.request.contextPath}">Customer Relationship Manager</a>
    </div>
</nav>
<section class="container jumbotron bg-dark text-white justify-content-around">
    <div class="justify-content-around">
        <form action="${pageContext.request.contextPath}/search" method="GET" class="form-inline d-flex justify-content-between mb-2">
            <a href="${pageContext.request.contextPath}/add" class="btn btn-info">New Customer</a>
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search" name="searchItem"/>
                <div class="input-group-append">
                    <input type="submit" class="btn btn-info" value="Search"/>
                </div>
            </div>
        </form>
    </div>
    <table class="table table-striped table-dark ">
        <thead>
        <tr>
            <th scope="col" class="text-danger text-center">ID</th>
            <th scope="col" class="text-info text-center">First Name</th>
            <th scope="col" class="text-info text-center">Last Name</th>
            <th scope="col" class="text-info text-center">Email</th>
            <th colspan="2" scope="col" class="text-info text-center">Operation</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="customer" items="${customers}">
            <c:url var="updateLink" value="/update">
                <c:param name="id" value="${customer.id}"/>
            </c:url>
            <c:url var="deleteLink" value="/delete">
                <c:param name="id" value="${customer.id}"/>
            </c:url>
            <tr>
                <td class="text-center text-danger">${customer.id}</td>
                <td class="text-center">${customer.firstName}</td>
                <td class="text-center">${customer.lastName}</td>
                <td class="text-center">${customer.email}</td>
                <td class="text-center"><a href="${updateLink}" class="btn btn-sm btn-info">Update</a></td>
                <td class="text-center"><a href="${deleteLink}" class="btn btn-sm btn-danger" onclick="return confirm('Are you sure you want to delete this customer?');">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</section>
</body>
</html>
