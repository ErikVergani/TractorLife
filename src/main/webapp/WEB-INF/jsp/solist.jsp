<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" style="height: 935px;font-family: Roboto, sans-serif;">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Menu</title>
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto+Slab:300,400|Roboto:300,400,700">
    <link rel="stylesheet" href="/assets/css/Banner-Heading-Image-images.css">
    <link rel="stylesheet" href="/assets/css/Black-Navbar.css">
    <link rel="stylesheet" href="/assets/css/table.css">
</head>

<body style="color: rgb(19,24,30);background: linear-gradient(68deg, #634100 13%, rgb(183,124,37) 51%, #634100 84%), rgba(255,255,255,0.21);height: 850px;">
    <section>
        <nav class="navbar navbar-light navbar-expand-md navbar-fixed-top navigation-clean-button" style="background: rgb(184,100,0);border-radius: 20;border-top-left-radius: 20;border-top-right-radius: 20;border-bottom-right-radius: 20;border-bottom-left-radius: 20;border-style: none;padding-top: 0;padding-bottom: 10px;width: 1920px;height: 60px;color: rgb(255,255,255);">
            <div class="container"><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div><a class="navbar-brand" href="#"><span style="font-family: Roboto, sans-serif;">TractorLife</span> </a></div>
                <div class="collapse navbar-collapse" id="navcol-1" style="color: rgb(255,255,255);width: 1252.7px;margin-right: -277px;padding-right: 39px;">
                    <ul class="navbar-nav nav-right">
                        <li class="nav-item"><a class="nav-link active" href="/index" style="color: #000000;font-family: Roboto, sans-serif;">Home</a></li>
                    </ul>
                    <ul class="navbar-nav nav-right">
                        <li class="nav-item"><a class="nav-link active" href="/so" style="color: #000000;font-family: Roboto, sans-serif;">Ordens de serviço</a></li>
                    </ul>
                    <ul class="navbar-nav nav-right">
                        <li class="nav-item"><a class="nav-link active" href="/employee" style="color: #000000;font-family: Roboto, sans-serif;">Funcionários</a></li>
                    </ul>
                    <ul class="navbar-nav nav-right">
                        <li class="nav-item"><a class="nav-link active" href="/index" style="color: #000000;font-family: Roboto, sans-serif;">Configurações</a></li>
                    </ul>
                    <p class="ms-auto navbar-text actions" style="width: 132.922px;text-align: right;padding-left: 60px;"> <a class="btn btn-light action-button" role="button" href="/logout" style="color: rgba(0,0,0,0.9);background: var(--bs-danger);border-radius: 10px;border-style: solid;border-color: rgba(0,0,0,0.9);font-size: 16px;padding: 5px 8px;text-align: center;">Logout</a></p>
                </div>
            </div>
        </nav>
    </section>
    <div style="height: 95%;display: inline-flex;width: 100%;margin: 0px;margin-top: 30px;">
        <div style="width: 100%;height: 100%;">
            <div class="text-center" style="height: 65.1875px;width: 550px;margin-left: 24%;">
                <h1 style="width: 170%;margin-left: 30px;font-family: Roboto, sans-serif;">Lista de Ordens de Serviço</h1>
            </div>
            <div class="text-center" style="width: 1800px;margin-left: 60px;margin-top: -11px;">
                <h3 style="font-family: Roboto, sans-serif;">Filtros</h3>
                <input type="text" style="margin-right: 15px;font-family: Roboto, sans-serif;" id="filterTitle" placeholder="Título">
                <input type="Date" style="margin-right: 15px;font-family: Roboto, sans-serif;" placeholder="Data abertura" id="filterStartDate">
                <input type="Date" style="margin-right: 15px;font-family: Roboto, sans-serif;" id="filterEndDate" placeholder="Data fechamento">
                <input type="text" style="margin-right: 15px;font-family: Roboto, sans-serif;" id="filterCustomer" placeholder="Nome cliente">
                <input type="checkbox" id="filterClosed" style="height: 17px;">
                <span style="padding-left: 7px;font-size: 25px;font-family: Roboto, sans-serif;">Fechada</span>
                <button class="btn btn-primary" type="button" style="margin-left: 30px;font-family: Roboto, sans-serif;" onclick="search()">Buscar</button>
                <button class="btn btn-primary" type="button" style="margin-left: 30px;font-family: Roboto, sans-serif;" onclick="report()">Imprimir</button>
                <button class="btn btn-primary" type="button" style="margin-left: 30px;font-family: Roboto, sans-serif;" onclick="location.href='/addso';">Criar OS</button>
                <button class="btn btn-primary" type="button" style="margin-left: 30px;font-family: Roboto, sans-serif;" onclick="editOs()">Editar OS</button>
            </div>
            <div class="table-responsive" style="margin-top: 30px;height: 80%;margin-left: 15px;margin-right: 15px;border-style: solid;border-color: rgb(204,204,204);">
                <table class="table" id="dataTable">
                    <thead>
                        <tr class="text-start" style="color: rgb(204,204,204);border-width: 0px;border-style: solid;">
                            <th style="border-width: 1px;border-style: solid;font-family: Roboto, sans-serif;">ID</th>
                            <th style="border-width: 1px;border-style: solid;font-family: Roboto, sans-serif;">Titulo</th>
                            <th style="border-width: 1px;border-style: solid;font-family: Roboto, sans-serif;">Data Abertura</th>
                            <th style="border-width: 1px;border-style: solid;font-family: Roboto, sans-serif;">Data Fechamento</th>
                            <th style="border-width: 1px;border-style: solid;font-family: Roboto, sans-serif;">Cliente</th>
                            <th style="border-width: 1px;border-style: solid;font-family: Roboto, sans-serif;">Pgto</th>
                            <th style="border-width: 1px;border-style: solid;font-family: Roboto, sans-serif;">Valor Total</th>
                            <th style="border-width: 1px;border-style: solid;border-left-style: solid;color: rgb(204, 204, 204);font-family: Roboto, sans-serif;">Fechada</th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="/assets/js/serviceOrder.js"></script>
</body>

</html>