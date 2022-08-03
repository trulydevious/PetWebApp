<%--
  Created by IntelliJ IDEA.
  User: weran
  Date: 11.04.2022
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*,database.Groomer" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Update</title>
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
</head>

    <section>
        <div class="container px-5 my-5 px-5">
            <div class="text-center mb-5">
                <img src="img/blue2.png" height="50" width="50">
                <div class="">&nbsp;</div>
                <h2 class="fw-bolder">Update info!</h2>
                <p class="lead mb-0"></p>
            </div>
        </div>

        <section>
            <div class="container px-5 my-5 px-5">
                <div class="row gx-5 justify-content-center">
                    <div class="col-lg-6">
                                <form action="AdminServlet" method="get">
                                    <input type="hidden" name="command" value="UPDATE"/>
                                    <input type="hidden" name="groomerID" value="${GROOMER.id}"/>
                                    <div class="form-group">
                                        <label for="Name" class="lead mb-0">Name</label>
                                        <input type="text" class="form-control" name="nameInput" value="${GROOMER.name}"/>
                                    </div>
                                    <div class="">&nbsp;</div>
                                    <div class="form-group">
                                        <label for="Website" class="lead mb-0">Website</label>
                                        <input type="text" class="form-control" name="websiteInput" value="${GROOMER.website}"/>
                                    </div>
                                    <div class="">&nbsp;</div>
                                    <div class="form-group">
                                        <label for="City" class="lead mb-0">City</label>
                                        <input type="text" class="form-control" name="cityInput" value="${GROOMER.city}"/>
                                    </div>
                                    <div class="">&nbsp;</div>
                                    <div class="form-group">
                                        <label for="OpenDays" class="lead mb-0">Open days</label>
                                        <input type="text" class="form-control" name="openDaysInput" value="${GROOMER.openDays}"/>
                                    </div>
                                    <div class="">&nbsp;</div>
                                    <div class="form-group">
                                        <label for="Pets" class="lead mb-0">Pets</label>
                                        <input type="text" class="form-control" name="petsInput" value="${GROOMER.pets}"/>
                                    </div>
                                    <div class="">&nbsp;</div>
                                    <div class="d-grid"><button class="btn btn-primary" id="submitButton" type="submit">Update</button></div>
                                    <div class="">&nbsp;</div>
                                    <div class="d-grid"><button class="btn btn-primary" href="AdminServlet" id="back" type="submit">Back</button></div>
                                </form>
                            </div>
                        </div>
                            <div class="">&nbsp;</div>
                            <div style="text-align: center">
                                <img src="img/dog2.png" height="363" width="300">
                            </div>
                        </form>
                    </div>
        </section>
    </section>
</form>
<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container px-5"><p class="m-0 text-center text-white">Copyright &copy; Weronika Najda 2022</p></div>
</footer>
</body>
</html>