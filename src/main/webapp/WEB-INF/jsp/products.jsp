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
    <div style="height: 95%;display: inline-flex;width: 100%;margin: 0px;margin-top: 30px;">
        <div style="width: 50%;margin-top: 0px;">
            <h1 class="text-start" style="text-align: center;margin-left: 12%;font-size: 44px;height: 65.1875px;">Gerenciamento de Produtos</h1>
            <form style="height: 75%;margin: 0px;margin-left: 20%;width: 60%;padding-left: 15px;border-radius: 35px;border-style: solid;border-color: rgb(204,204,204);" method="post" action="/employee">
                <div class="input-group" style="display: block;"><span class="input-group-text" style="margin-top: 15px;width: 50%;margin-left: 14px;padding-left: 35px;border-radius: 93px 0px 0px 6px;border-top-right-radius: 25px;background: rgb(255,255,255);">Nome</span><input class="form-control" type="text" style="width: 95%;border-radius: 35px;border-width: 0px;" name="name" required=""></div>
                <div class="input-group" style="display: block;"><span class="input-group-text" style="margin-top: 15px;width: 50%;border-radius: 67px 0px 0px 6px;margin-left: 14px;padding-left: 35px;">Categoria</span><input class="form-control" type="text" style="width: 95%;border-radius: 35px;border-width: 0px;" name="cpf"></div>
                <div class="input-group" style="display: block;"><span class="input-group-text" style="margin-top: 15px;width: 50%;border-radius: 67px 0px 0px 6px;margin-left: 14px;padding-left: 35px;">Unidade métrica</span><input class="form-control" type="text" style="width: 95%;border-radius: 35px;border-width: 0px;" name="address"></div>
                <div class="input-group" style="display: block;"><span class="input-group-text" style="margin-top: 15px;width: 50%;border-radius: 67px 0px 0px 6px;margin-left: 14px;padding-left: 35px;">Preço de compra</span><input class="form-control" type="text" style="width: 95%;border-radius: 35px;border-width: 0px;" name="phone"></div>
                <div class="input-group" style="display: block;"><span class="input-group-text" style="margin-top: 15px;width: 50%;border-radius: 67px 0px 0px 6px;margin-left: 14px;padding-left: 35px;">Preço de venda</span><input class="form-control" type="text" style="width: 95%;border-radius: 35px;border-width: 0px;" name="city"></div>
                <div class="input-group" style="display: block;"><span class="input-group-text" style="margin-top: 15px;width: 50%;border-radius: 67px 0px 0px 6px;margin-left: 14px;padding-left: 35px;">Qtde em estoque</span><input class="form-control" type="text" style="width: 95%;border-radius: 35px;border-width: 0px;" name="email"></div>
                <div class="d-xxl-flex justify-content-xxl-center align-items-xxl-center" style="display: flex;text-align: center;margin-top: 9px;">
                    <div class="form-check fs-2" style="margin-top: 5px;margin-left: 15px;"><input class="form-check-input" type="checkbox" id="formCheck-1" checked="" name="checkbox"><label class="form-check-label" for="formCheck-1">Ativo</label></div><button class="btn btn-primary" id="btnsalvar" type="submit" style="margin-right: 20px;margin-left: 70px;height: 48px;width: 100px;border-radius: 36px;background: rgba(255,0,0,0.39);">Excluir</button><button class="btn btn-primary" id="btnsalvar-1" type="submit" style="height: 48px;width: 100px;border-radius: 36px;background: rgb(23,145,102);">Salvar</button>
                </div>
            </form>
        </div>
        <div style="height: 100%;width: 70%;">
            <div class="text-center" style="height: 65.1875px;width: 550px;margin-left: 24%;">
                <h1 style="width: 100%;margin-left: 17px;">Lista de Produtos</h1>
            </div>
            <div class="text-center" style="height: 85px;width: 1102px;margin-left: 15px;padding-left: 0px;">
                <h3 style="height: 26.5938px;">Filtros</h3><input type="text" style="margin-right: 15px;" placeholder="Nome" name="filterName"><input type="text" style="margin-right: 15px;" placeholder="Categoria" name="filterCategory"><button class="btn btn-primary" type="button" style="margin-left: 30px;">Imprimir</button><button class="btn btn-primary" type="button" style="margin-left: 30px;">Buscar</button>
            </div>
            <div class="table-responsive" style="margin-top: 10px;height: 80%;margin-left: 15px;margin-right: 15px;border-style: solid;border-color: rgb(204,204,204);">
                <table class="table">
                    <thead>
                        <tr class="text-start" style="color: rgb(204,204,204);border-width: 0px;border-style: solid;">
                            <th style="border-width: 1px;border-style: solid;">ID</th>
                            <th style="border-width: 1px;border-style: solid;">Nome</th>
                            <th style="border-width: 1px;border-style: solid;">CPF</th>
                            <th style="border-width: 1px;border-style: solid;">Endereço</th>
                            <th style="border-width: 1px;border-style: solid;">Telefone</th>
                            <th style="border-width: 1px;border-style: solid;">Cidade</th>
                            <th style="border-width: 1px;border-style: solid;">Categoria</th>
                            <th style="border-width: 1px;border-style: solid;">Email</th>
                            <th style="border-width: 1px;border-style: solid;">Login</th>
                            <th style="border-width: 1px;border-style: solid;border-left-style: solid;color: rgb(204, 204, 204);">Ativo</th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
        </div>
    </div>
    <script src="/assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>