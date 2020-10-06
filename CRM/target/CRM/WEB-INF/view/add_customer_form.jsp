<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Customer</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous"/>
</head>
<body>
<nav id="mainNav" class="navbar navbar-expand-lg navbar-light bg-dark fixed-top justify-content-center">
    <a class="navbar-brand text-danger" href="${pageContext.request.contextPath}">Customer Relationship Manager</a>
</nav>
<section class="container jumbotron bg-dark text-white mt-5">
        <h1 id="addHead"class="display-4 mb-5">Add A New Customer</h1>
        <h1 id="updateHead" class="display-4 mb-5">Update An Existing Customer</h1>
    <form:form method="POST" action="${pageContext.request.contextPath}/add" modelAttribute="customer" style="width: 50%">
        <form:hidden path="id" />
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text text-info">First Name</span>
            </div>
            <form:input path="firstName" class="form-control"/>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text text-info">Last Name</span>
            </div>
            <form:input path="lastName" class="form-control"/>
        </div>
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <span class="input-group-text text-info pr-5">Email</span>
            </div>
            <form:input path="email" class="form-control"/>
        </div>
        <div style="width: 50%">
            <input type="submit" value="Save" class="btn btn-danger btn-block"/>
        </div>
        <div style="width: 50%" class="mt-3">
            <a href="${pageContext.request.contextPath}" class="btn btn-info btn-block">Back</a>
        </div>
    </form:form>
</section>
<script type="text/javascript">
    // Get URL
    const url = window.location.href;
    // Get DIV
    const msg1 = document.getElementById("addHead");
    const msg2 = document.getElementById("updateHead");
    // Check if URL contains the keyword
    if( url.search( 'update' ) > 0 ) {
        // Display the message
        msg1.style.display = "none";
    }
    else {
        msg2.style.display = "none";
    }
</script>
</body>
</html>











