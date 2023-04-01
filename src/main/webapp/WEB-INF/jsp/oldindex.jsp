<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/menu.css">
    <title>TractorLife</title>
</head>
<body>
    <div class="principal">

        <div class="title">
            <div class="content" >
                <h1>TractorLife, improve ur production!</h1>
            </div>
        </div>

        <div class="modules">
            <ul>
                <li> <a href=""> Ordens de Serviço </a> </li>
                <li> <a href="/customer"> Clientes </a> </li>
                <li> <a href=""> Produtos </a> </li>
                <li> <a href=""> Relatórios </a> </li>
                <li> <a href=""> Configurações </a> </li>
            </ul>
        </div>

        <table>
        <%
            for ( int i = 0; i < 10; i++)
            {
        %>
            <tr>
                <td> <%=i%> </td>
            </tr>
            <%
                }
            %>
        </table>


        <div class="title">
            <div class="content" >
                <h1> </h1>
            </div>
        </div>
    </div>
</body>
</html>