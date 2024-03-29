<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/customer.css">
    <script src="js/Customer.js"></script>
    <title>Clientes</title>
</head>
    <body>
        <div class="title">
            <h1>Gerenciamento de clientes</h1>
        </div>

        <section class="form">
            <div class="form-box">
                <div class="form-value">
                    <form>
                        <div class="inputbox">
                            <input id="nameField" disabled>
                            <label for="">id</label>
                        </div>

                        <div class="inputbox">
                            <input id="nameField" type="text" required>
                            <label for="">Nome completo</label>
                        </div>

                        <div class="inputbox">
                            <input id="cpfField" type="text" oninput="cpfMask( this )" required>
                            <label for="">CPF</label>
                        </div>

                        <div class="inputbox">
                            <input id="addressField" type="text" required>
                            <label for="">Endereço</label>
                        </div>

                        <div class="inputbox">
                            <input id="cellField" type="text"required>
                            <label for="">Celular</label>
                        </div>

                        <div class="inputbox">
                            <input id="emailField" type="email" required placeholder=" ">
                            <label for="">Email</label>
                        </div>

                        <div class="inputbox">
                            <input id="cityField" type="text" required>
                            <label for="">Cidade </label>
                            <button> ME CLICA E SELECIONA</button>
                        </div>

                        <div class="inputbox">
                            <input id="balanceField" type="text" required>
                            <label for="">Limite de compra</label>
                        </div>

                        <div class="inputbox">
                            <input id="balanceField" disabled>
                            <label for="">Saldo devedor</label>
                        </div>
                        
                        <div class="inputbox">
                            <input id="creationField" type="date" disabled >
                            <label for="">Data de cadastro</label>
                        </div>

                        <div class="checkbox">
                            <input id="checkboxField" type="checkbox">
                            <label for="">Cliente ativo</label>
                        </div>
                        
                        <div class="buttons">
                            <input value="Salvar" onclick="send()" type="button" />
                            <input value="Limpar" onclick="clearFields()" type="button" />
                            <input value="Imprimir" onclick="print()" type="button" />
                        </div>
                    </form>
                </div>
            </div>
        </section>

        <section class="table">
            <table class="dataTable">
                <div class="filters">
                    <h4>Filtragem de busca</h4>
                    <thead>
                        <tr id="filter">
                            <td></td>
                            <td> <input id="nameFilter" oninput="refresh()" placeholder="nome"type="text" /> </td>
                            <td> <input id="cpfFilter" oninput="refresh()" placeholder="CPF" type="text" /> </td>
                            <td> <input id="emailFilter" oninput="refresh()" placeholder="Email" type="text" /> </td>
                            <td> <input id="cityFilter" oninput="refresh()" placeholder="Cidade" type="text" /> </td>
                            <td> <input id="debitFilter" oninput="refresh()" placeholder="Saldo devedor" type="text" /> </td>
                            <td>
                                <td> <p> Ativo </p> </td>
                                <td> <input id="activeFilter" oninput="refresh()" type="checkbox" checked="true" /> </td>
                            </td>
                        </tr>
                </div>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Email</th>
                        <th>Cidade</th>
                        <th>Saldo Devedor</th>
                        <th>Usuário ativo</th>
                    </tr>
                </thead>
            </table>
        </section>
</body>
</html>