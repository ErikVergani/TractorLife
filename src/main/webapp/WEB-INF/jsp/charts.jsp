<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Menu</title>
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400|Roboto:300,400,700">
    <link rel="stylesheet" href="/assets/css/Banner-Heading-Image-images.css">
    <link rel="stylesheet" href="/assets/css/Black-Navbar.css">
    <style>
        .chartBox{
            width: 90%;
        }
    </style>
</head>

<body style="color: rgb(19,24,30);background: linear-gradient(68deg, #634100 13%, rgb(183,124,37) 51%, #634100 84%), rgba(255,255,255,0.21);">
<nav class="navbar navbar-light navbar-expand-md navbar-fixed-top navigation-clean-button" style="background: rgb(184,100,0);border-radius: 20;border-top-left-radius: 20;border-top-right-radius: 20;border-bottom-right-radius: 20;border-bottom-left-radius: 20;border-style: none;padding-top: 0;padding-bottom: 10px;">
    <div class="container"><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div><a class="navbar-brand" href="#"><span style="color: rgb(255,255,255);">TractorLife</span> </a></div>
        <div class="collapse navbar-collapse" id="navcol-1" style="color: rgb(255,255,255);width: 1252.7px;margin-right: -277px;padding-right: 39px;">
            <ul class="navbar-nav nav-right">
                <li class="nav-item"><a class="nav-link active" href="/index" style="color: rgba(0,0,0,0.9);font-family: Roboto, sans-serif;">Home</a></li>
            </ul>
            <ul class="navbar-nav nav-right">
                <li class="nav-item"><a class="nav-link active" href="/so" style="color: rgba(0,0,0,0.9);font-family: Roboto, sans-serif;">Ordens de serviço</a></li>
            </ul>
            <ul class="navbar-nav nav-right">
                <li class="nav-item"><a class="nav-link active" href="/customer" style="color: rgba(0,0,0,0.9);font-family: Roboto, sans-serif;">Clientes</a></li>
            </ul>
            <ul class="navbar-nav nav-right">
                <li class="nav-item"><a class="nav-link active" href="/employee" style="color: rgba(0,0,0,0.9);font-family: Roboto, sans-serif;">Funcionários</a></li>
            </ul>
            <ul class="navbar-nav nav-right">
                <li class="nav-item"><a class="nav-link active" href="/charts" style="color: rgba(0,0,0,0.9);font-family: Roboto, sans-serif;">Chart</a></li>
            </ul>
            <p class="ms-auto navbar-text actions" style="width: 132.922px;text-align: right;padding-left: 60px;"> <a class="btn btn-light action-button" role="button" href="/logout" style="color: rgba(0,0,0,0.9);background: var(--bs-danger);border-radius: 10px;border-style: solid;border-color: rgba(0,0,0,0.9);font-size: 16px;padding: 5px 8px;text-align: center;">Logout</a></p>
        </div>
    </div>
</nav>

<div class="chartBox">
    <canvas id="myChart" ></canvas>
</div>

<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="/assets/js/chart.js"></script>

</body>
</html>