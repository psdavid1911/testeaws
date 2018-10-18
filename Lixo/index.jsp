<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="js/include.js"></script>
    </head>
    <body onload="CarregarPos()">
        <div class="coluna">
            <div id="menu" class="linha menu"></div>
            <div class="linha titulo">Log in</div>
            <fieldset>
                <input id="idCampoEntrada"  type="text" placeholder="Usuário">
                <input id="idCampoEntrada2"  type="password" placeholder="Password">
                <input type="button"   value="Entrar" onclick="entra();" />
                <br>
                <div class="linha" style="height: 10px;"></div>
                <p id="idSaida" ></p>
            </fieldset>
            <div id="rodape" class="linha rodape"></div>
        </div>
    </body>
</html>
