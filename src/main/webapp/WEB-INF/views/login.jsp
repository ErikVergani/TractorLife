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
                <form method="POST" action="menu">
                    <h2>Login</h2>
                    <div class="inputbox">
                        <input type="text" required>
                        <label for="">Usuário</label>
                    </div>
                    <div class="inputbox">
                        <input type="password" required>
                        <label for="">Senha</label>
                    </div>
                    <div class="forget">
                        <a href="">Esqueci minha senha</a>
                    </div>
                    <button>Entrar</button>
                </form>
            </div>
        </div>
    </section>
</body>
</html>