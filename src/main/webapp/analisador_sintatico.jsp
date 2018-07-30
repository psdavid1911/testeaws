<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <script src="js/include.js"></script>
  </head>
  <body onload="CarregarPos();">
    <div class="coluna">
      <div id="menu" class="linha menu"></div>
      <div class="linha titulo" style="font-size: 90pt;">Analisador sintático</div>
      <div class="linha" style="height: 150px"></div>
      <div class="linha">
        <form>
          <fieldset>
            <input id="idCampoEntrada"  type="text" placeholder="Digite a oração a analisar..." />
            <input type="button" style="width: auto;"  value="Analisar" onclick="analisaSintaxe();" /><br>
            <div class="linha" style="height: 100px"></div>
            <p id="idSaida" >Saída do programa</p>
          </fieldset>
        </form>
      </div>
      <div id="rodape" class="linha rodape"></div>
    </div>
  </body>
</html>
