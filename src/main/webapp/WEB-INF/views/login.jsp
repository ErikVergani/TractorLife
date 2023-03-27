<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt_br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/login.css">
    <title>Tractor Life</title>
</head>
<body>
    <section>
        <div class="form-box">
            <div class="form-value">
                <form action="/login" method="POST">
                    <h2>Login</h2>
                    <div class="inputbox">
                        <input id="username" type="text" name="username" required>
                        <label for="">Usuário</label>
                    </div>
                    <div class="inputbox">
                        <input id="password" type="password"  name="password" required>
                        <label for="">Senha</label>
                    </div>
                    <div class="forget">
                        <a href="">Esqueci minha senha</a>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <button name="submit" type="submit">Entrar</button>
                </form>
            </div>
        </div>
    </section>
</body>
</html>