<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en" style="height: 100%;font-family: Roboto, sans-serif;">

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
        <nav class="navbar navbar-light navbar-expand-md navbar-fixed-top navigation-clean-button" style="background: rgb(184,100,0);border-radius: 20;border-top-left-radius: 20;border-top-right-radius: 20;border-bottom-right-radius: 20;border-bottom-left-radius: 20;border-style: none;padding-top: 0;padding-bottom: 10px;width: 1920px;height: 60px;">
            <div class="container"><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div><a class="navbar-brand" href="#"><span style="color: rgb(255,255,255);">TractorLife</span> </a></div>
                <div class="collapse navbar-collapse" id="navcol-1" style="color: rgb(255,255,255);width: 1252.7px;margin-right: -277px;padding-right: 39px;">
                    <ul class="navbar-nav nav-right">
                        <li class="nav-item"><a class="nav-link active" href="/index.html" style="color: rgba(0,0,0,0.9);font-family: Roboto, sans-serif;">Home</a></li>
                    </ul>
                    <ul class="navbar-nav nav-right">
                        <li class="nav-item"><a class="nav-link active" href="/index.html" style="color: rgba(0,0,0,0.9);font-family: Roboto, sans-serif;">Ordens de serviço</a></li>
                    </ul>
                    <ul class="navbar-nav nav-right">
                        <li class="nav-item"><a class="nav-link active" href="/solist.html" style="color: rgba(0,0,0,0.9);font-family: Roboto, sans-serif;">Clientes</a></li>
                    </ul>
                    <ul class="navbar-nav nav-right">
                        <li class="nav-item"><a class="nav-link active" href="reports.html" style="color: rgba(0,0,0,0.9);font-family: Roboto, sans-serif;">Relatórios</a></li>
                    </ul>
                    <ul class="navbar-nav nav-right">
                        <li class="nav-item"><a class="nav-link active" href="/index.html" style="color: rgba(0,0,0,0.9);font-family: Roboto, sans-serif;">Configurações</a></li>
                    </ul>
                    <p class="ms-auto navbar-text actions" style="width: 132.922px;text-align: right;padding-left: 60px;"> <a class="btn btn-light action-button" role="button" href="signup.html" style="color: rgba(0,0,0,0.9);background: var(--bs-danger);border-radius: 10px;border-style: solid;border-color: rgba(0,0,0,0.9);font-size: 16px;padding: 5px 8px;text-align: center;">Logout</a></p>
                </div>
            </div>
        </nav>
    </section>
    <div style="height: 95%;display: inline-flex;width: 100%;margin: 0px;margin-top: 5px;">
        <div style="width: 36%;">
            <div class="text-center" style="height: 65.1875px;width: 550px;margin-left: 25%;">
                <h1 style="width: 60%;">Lista de Produtos</h1>
            </div>
            <div class="text-center" style="height: 85px;width: 649px;margin-left: 50px;padding-left: 0px;">
                <h3 style="height: 26.5938px;width: 534px;">Filtros</h3>
                <input type="text" style="margin-right: 15px;" placeholder="Nome" id="filterName">
                <input type="text" style="margin-right: 15px;" placeholder="Categoria" id="filterCategory">
                <button class="btn btn-primary" type="button" style="margin-left: 30px;" onclick="search()">Buscar</button>
            </div>
            <div class="table-responsive" style="margin-top: 10px;height: 80%;margin-left: 30px;margin-right: 0px;border-style: solid;border-color: rgb(204,204,204);">
                <table class="table" id="products">
                    <thead>
                        <tr class="text-start" style="color: rgb(204,204,204);border-width: 0px;border-style: solid;">
                            <th style="border-width: 1px;border-style: solid;">ID</th>
                            <th style="border-width: 1px;border-style: solid;">Nome</th>
                            <th style="border-width: 1px;border-style: solid;">Categoria</th>
                            <th style="border-width: 1px;border-style: solid;">Valor unitário</th>
                            <th style="border-width: 1px;border-style: solid;">Estoque</th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
        <div style="width: 25%;margin-top: 215px;">
            <form style="height: 87%;margin: 0px;margin-left: 15%;width: 69%;padding-left: 15px;border-radius: 35px;border-style: solid;border-color: rgb(204,204,204);">
                <input class="form-control" type="text" style="width: 95%;border-radius: 35px;border-width: 0px; display: none" id="pId" >
                <div class="input-group" style="display: block;">
                    <span class="input-group-text" style="margin-top: 15px;width: 50%;margin-left: 14px;padding-left: 24px;border-radius: 93px 0px 0px 6px;border-top-right-radius: 25px;background: rgb(255,255,255);">Ordem de serviço</span>
                    <input class="form-control" type="text" style="width: 95%;border-radius: 35px;border-width: 0px;" value="${id}" id="soId" disabled>
                </div>
                <div class="input-group" style="display: block;">
                    <span class="input-group-text" style="margin-top: 15px;width: 50%;border-radius: 67px 0px 0px 6px;margin-left: 14px;padding-left: 24px;">Produto</span>
                    <input class="form-control" type="text" style="width: 95%;border-radius: 35px;border-width: 0px;" id="pName" disabled>
                </div>
                <div class="input-group" style="display: block;">
                    <span class="input-group-text" style="margin-top: 15px;width: 50%;border-radius: 67px 0px 0px 6px;margin-left: 14px;padding-left: 24px;">Categoria</span>
                    <input class="form-control" type="text" style="width: 95%;border-radius: 35px;border-width: 0px;" id="pCategory" disabled>
                </div>
                <div class="input-group" style="display: block;">
                    <span class="input-group-text" style="margin-top: 15px;width: 50%;border-radius: 67px 0px 0px 6px;margin-left: 14px;padding-left: 24px;">Valor Unitário</span>
                    <input class="form-control" type="text" style="width: 95%;border-radius: 35px;border-width: 0px;" id="pValue" disabled>
                </div>
                <div class="input-group" style="display: block;">
                    <span class="input-group-text" style="margin-top: 15px;width: 50%;border-radius: 67px 0px 0px 6px;margin-left: 14px;padding-left: 24px;">Quantidade</span>
                    <input class="form-control" type="text" style="width: 95%;border-radius: 35px;border-width: 0px;" id="qtde">
                </div>
                <div class="input-group" style="display: block;">

                </div>
                <div class="d-xxl-flex justify-content-xxl-center align-items-xxl-center" style="display: flex;text-align: center;margin-top: 9px;">
                    <button class="btn btn-primary" id="btnsalvar-1" type="button" style="height: 48px;width: 100px;border-radius: 36px;background: rgb(23,145,102);margin-left: -26px;" onclick="addProduct()">Adicionar</button>
                    <input type="hidden" id="productId">
                </div>
            </form>
        </div>
        <div style="height: 91%;width: 38%;margin-top: 80px;">
            <div class="text-center" style="height: 65.1875px;width: 540px;margin-left: 24%;">
                <h1 style="width: 65%;margin-bottom: 0px;">Produtos na ordem</h1>
            </div>
            <div class="table-responsive" style="margin-top: 10px;height: 90%;margin-left: 0px;margin-right: 30px;border-style: solid;border-color: rgb(204,204,204);">
                <table class="table" id="osProducts">
                    <thead>
                        <tr class="text-start" style="color: rgb(204,204,204);border-width: 0px;border-style: solid;">
                            <th style="border-width: 1px;border-style: solid;">ID</th>
                            <th style="border-width: 1px;border-style: solid;">Nome</th>
                            <th style="border-width: 1px;border-style: solid;">Categoria</th>
                            <th style="border-width: 1px;border-style: solid;">Valor Unitário</th>
                            <th style="border-width: 1px;border-style: solid;">Quantidade</th>
                            <th style="border-width: 1px;border-style: solid;">Total</th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="/assets/js/serviceProducts.js"></script>
</body>

</html>