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
</head>

<body style="color: rgb(19,24,30);background: linear-gradient(68deg, #634100 13%, rgb(183,124,37) 51%, #634100 84%), rgba(255,255,255,0.21);">
    <nav class="navbar navbar-light navbar-expand-md navbar-fixed-top navigation-clean-button" style="background: rgb(184,100,0);border-radius: 20;border-top-left-radius: 20;border-top-right-radius: 20;border-bottom-right-radius: 20;border-bottom-left-radius: 20;border-style: none;padding-top: 0;padding-bottom: 10px;">
        <div class="container"><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div><a class="navbar-brand" href="#"><span style="color: rgb(255,255,255); margin-left: 100px;">TractorLife</span> </a></div>
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
                    <li class="nav-item"><a class="nav-link active" href="/chart" style="color: rgba(0,0,0,0.9);font-family: Roboto, sans-serif;">Chart</a></li>
                </ul>
                <p class="ms-auto navbar-text actions" style="width: 132.922px;text-align: right;padding-left: 60px;"> <a class="btn btn-light action-button" role="button" href="/logout" style="color: rgba(0,0,0,0.9);background: var(--bs-danger);border-radius: 10px;border-style: solid;border-color: rgba(0,0,0,0.9);font-size: 16px;padding: 5px 8px;text-align: center;">Logout</a></p>
            </div>
        </div>
    </nav>
    <section class="py-4 py-xl-5" style="height: 865.797px;">
        <div style="display: inline-flex;">
            <div class="row mb-5" style="height: 156px;">
                <div class="col-md-8 col-xl-6 text-center mx-auto">
                    <h1 style="color: rgb(0,0,0);border-color: rgb(13,227,22);font-family: Roboto, sans-serif;">A melhor escolha para o cuidado do seu equipamento!</h1>
                    <p class="text-center" style="color: rgb(0,0,0);border-color: rgb(7,17,10);font-family: Roboto, sans-serif;font-size: 18px;">A tractorLife disponibiliza uma série de serviços para garantir a a manutenção do seu equipamento, sempre utilizando dos melhores produtos disponíveis no mercado</p>
                </div>
            </div>

            <div class="hg-weather">
                <span id="city">Obtendo cidade</span> <span id="temp">00</span>º C<br>
                <span id="description">Obtendo tempo...</span><br>
                Nascer do Sol: <span id="sunrise">00:00</span> - Pôr do Sol: <span id="sunset">00:00</span><br>
                Velocidade do vento: <span id="wind_speedy">-- km/h</span><br>
                <img src="http://assets.api.hgbrasil.com/weather/images/44.png" id="image"><br>
            </div>
        </div>
        <div class="container py-4 py-xl-5" style="margin-top: -20px;">
            <div class="row gy-4 row-cols-1 row-cols-md-2 row-cols-xl-3">
                <div class="col">
                    <div class="card"><img class="card-img-top w-100 d-block fit-cover" style="height: 200px;" src="/assets/img/revisao.jpg">
                        <div class="card-body p-4" style="margin-bottom: 70px;padding-top: 57px;padding-left: 20px;padding-bottom: 19px;">
                            <p class="text-primary card-text mb-0">Aumente a vida útil do seu equipamento</p>
                            <h4 class="card-title">Revisões de qualidade Tractorlife</h4>
                            <p class="card-text">Todo equipamento merece ser bem cuidado, ele é responsável por garantir a sua produtividade. Confira as ofertas de revisões disponíveis!</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card"><img class="card-img-top w-100 d-block fit-cover" style="height: 200px;" src="/assets/img/produtos.jpg">
                        <div class="card-body p-4" style="margin-bottom: 72px;padding-bottom: 0px;padding-top: 27px;">
                            <p class="text-primary card-text mb-0">O óleo é o sangue da máquina</p>
                            <h4 class="card-title">Produtos de qualidade</h4>
                            <p class="card-text">Os produtos utilizados nas revisões são os melhores disponíveis no mercado, garantindo que o seu equipamento&nbsp;trabalhará com eficiência.</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="card"><img class="card-img-top w-100 d-block fit-cover" style="height: 200px;" src="/assets/img/obra.jpg">
                        <div class="card-body p-4" style="margin-bottom: 70px;">
                            <p class="text-primary card-text mb-0">Os mecânicos são os médicos</p>
                            <h4 class="card-title">Mão de obra qualificada</h4>
                            <p class="card-text">Com uma mão de obra de ponta, a Tractorlife garante a qualidade dos seus serviços. Todos mecânicos possuem treinamento de ponta.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="/assets/js/temp.js"></script>
</body>

</html>