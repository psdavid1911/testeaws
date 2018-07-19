<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="UTF-8">
    <script src="js/include.js"></script>
    <script>
        function analisaEstatisticamente() {
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function () {
                if (this.readyState === 4 && this.status === 200)
                    document.getElementById("idSaida").innerHTML = this.responseText;
            };
            xhttp.open("GET", "calcularEstatistico?entrada=" + encodeURIComponent(document.getElementById("idCampoEntrada").value), true);
            xhttp.send();
        }
    </script>
  </head>
  <body>
    <script>leitorDeArquivo("Esqueletos/marca.html");</script>
    <div class="coluna">
      <div class="linha titulo" style="font-size: 90pt;">Estatística Descritiva</div>
      <div class="linha" style="height: 150px"></div>
      <div class="linha">
        <form>
          <fieldset>
            <input id="idCampoEntrada"  type="text" placeholder="Digite uma série, como por exemplo: 1,2,3">
            <input type="button" style="width: auto;"  value="Analisar" onclick="analisaEstatisticamente();" /><br>
            <div class="linha" style="height: 100px"></div>
            <p id="idSaida" >Saída do programa</p>
          </fieldset>
        </form>
      </div>
      <script>leitorDeArquivo("Esqueletos/rodape.html");</script>
    </div>
  </body>
</html>
