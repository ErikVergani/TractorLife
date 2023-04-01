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
                <form method="POST" action="/login">
                    <h2>Login</h2>
                    <div class="inputbox">
                        <input id="username" type="text" name="username" required>
                        <label>Usuário</label>
                    </div>
                    <div class="inputbox">
                        <input id="password" type="password"  name="password" required>
                        <label>Senha</label>
                    </div>
                    <div class="forget">
                        <a href="">Esqueci minha senha</a>
                    </div>
                    <button name="submit" type="submit">Entrar</button>
                </form>
            </div>
        </div>
        <div>

            <!-- Check for login error -->

            <c:if test="${param.error != null}">

                <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                    Invalid username and password.
                </div>

            </c:if>

            <!-- Check for logout -->

            <c:if test="${param.logout != null}">

                <div class="alert alert-success col-xs-offset-1 col-xs-10">
                    You have been logged out.
                </div>

            </c:if>

        </div>
    </section>
</body>
</html>