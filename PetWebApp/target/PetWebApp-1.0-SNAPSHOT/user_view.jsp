<%--
  Created by IntelliJ IDEA.
  User: weran
  Date: 06.04.2022
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*,database.Groomer" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Groomers list</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="img/blue2.png" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
</head>

<body>

<!-- Responsive navbar-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container px-5">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="home.html">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="admin_log.html">Admin</a></li>
            </ul>
        </div>
    </div>
</nav>

<!-- Header-->
<header class="bg-dark py-5">
    <div class="container px-5">
        <div class="row gx-5 justify-content-center">
            <div class="col-lg-6">
                <div class="text-center my-5">
                    <h1 class="display-5 fw-bolder text-white mb-2">PetGroom</h1>
                    <p class="lead text-white-50 mb-4">Find the best groomer for your dear pupil!</p>
                </div>
            </div>
        </div>
    </div>
</header>

<div class="container px-5 my-5 px-5">
    <div class="text-center mb-5">
        <img src="img/blue2.png" height="50" width="50">
        <div class="">&nbsp;</div>
        <h2 class="fw-bolder">List of groomers</h2>
        <p class="lead mb-0"></p>
        <div class="">&nbsp;</div>
    </div>
</div>

<section>
    <div class="container px-5 my-5 px-5">
        <div class="row gx-5 justify-content-center">

    <table class="table table-striped">
    <tr>
        <th scope="col" class="lead mb-0">#</th>
        <th scope="col" class="lead mb-0">Name</th>
        <th scope="col" class="lead mb-0">Website</th>
        <th scope="col" class="lead mb-0">City</th>
        <th scope="col" class="lead mb-0">Open days</th>
        <th scope="col" class="lead mb-0">Pets</th>
    </tr>
    <tbody>

    <c:forEach var="tmpGroomer" items="${GROOMERS_LIST}">

        <tr>
            <th scope="row">${tmpGroomer.id}</th>
            <td>${tmpGroomer.name}</td>
            <td>${tmpGroomer.website}</td>
            <td>${tmpGroomer.city}</td>
            <td>${tmpGroomer.openDays}</td>
            <td>${tmpGroomer.pets}</td>
        </tr>


    </c:forEach>
    </tbody>

</table>

        </div>
    </div>
</section>

<div class="">&nbsp;</div>
<div style="text-align: right">
    <img src="img/dog1.png" height="350" width="350">
</div>
<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container px-5"><p class="m-0 text-center text-white">Copyright &copy; Weronika Najda 2022</p></div>
</footer>
</body>
</html>
