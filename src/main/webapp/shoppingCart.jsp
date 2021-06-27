<%--
  Created by IntelliJ IDEA.
  User: apple
  Date: 2021/6/26
  Time: 2:32 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="icon" href="assets/image/logo.png" type="image/png">
    <link rel="stylesheet" href="assets/csc/background3.css">
    <style>

        .bd-placeholder-img {
            font-size: 10rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        main > .container {
            padding: 60px 15px 0;
        }

        .quote {
            margin: 0;
            background: #b3b9ff;
            padding: 0.75em;
            border-radius: 0;
        }

        .quote figcaption,
        .quote blockquote {
            margin: 1.5em;
        }
    </style>
    <title>BOOK RADAR</title>
</head>
<body class="d-flex flex-column h-110">

<header>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-secondary">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">BOOK RADAR</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse"
                    aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">
                    <li class="nav-item">
                        <a class="nav-link" href="index">Back to Home</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<!-- Begin page content -->
<body class="flex-shrink-0">
<main class="container">
    <div class="card mb-3" style="margin-top: 100px">
        <c:forEach var="song" items="${results}">
        <div class="row g-0">
                <div class="col-md-4">
                    <img src="${song.imageURL}" height="144">
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <p class="card-text">
                            <mark>Title:</mark>
                                ${song.title}</p>
                        <p class="card-text">
                            <mark>Writer:</mark>
                                ${song.singer}</p>
                        <a class="btn btn-primary" name="cart" href="song.jsp">See more details</a>
                    </div>
                </div>
        </div>
        </c:forEach>
    </div>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf"
        crossorigin="anonymous"></script>
</body>
</body>
</html>