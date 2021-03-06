<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Desafio</title>
        <script src="js/include.js"></script>
        <style>
            * {box-sizing:border-box}
            .mySlides {display:none}
            /* Slideshow container */
            .slideshow-container {
                max-width: 1000px;
                position: relative;
                margin: auto;
            }
            /* Next & previous buttons */
            .prev, .next {
                cursor: pointer;
                position: absolute;
                top: 50%;
                width: auto;
                padding: 16px;
                margin-top: -22px;
                color: white;
                font-weight: bold;
                font-size: 18px;
                transition: 0.6s ease;
                border-radius: 0 3px 3px 0;
            }
            /* Position the "next button" to the right */
            .next {
                right: 0;
                border-radius: 3px 0 0 3px;
            }
            /* On hover, add a black background color with a little bit see-through */
            .prev:hover, .next:hover {
                background-color: rgba(0,0,0,0.8);
            }
            /* Caption text */
            .text {
                color: #f2f2f2;
                font-size: 15px;
                padding: 8px 12px;
                position: absolute;
                bottom: 8px;
                width: 100%;
                text-align: center;
            }
            /* Number text (1/3 etc) */
            .numbertext {
                color: #f2f2f2;
                font-size: 12px;
                padding: 8px 12px;
                position: absolute;
                top: 0;
            }
            /* The dots/bullets/indicators */
            .dot {
                cursor:pointer;
                height: 13px;
                width: 13px;
                margin: 0 2px;
                background-color: #bbb;
                border-radius: 50%;
                display: inline-block;
                transition: background-color 0.6s ease;
            }
            .active, .dot:hover {
                background-color: #717171;
            }
            /* Fading animation */
            .fade {
                -webkit-animation-name: fade;
                -webkit-animation-duration: 1.5s;
                animation-name: fade;
                animation-duration: 1.5s;
            }
            @-webkit-keyframes fade {
                from {opacity: .4} 
                to {opacity: 1}
            }
            @keyframes fade {
                from {opacity: .4} 
                to {opacity: 1}
            }
            /* On smaller screens, decrease text size */
            @media only screen and (max-width: 300px) {
                .prev, .next,.text {font-size: 11px}
            }
        </style>
        <script>
            function calcula() {
                var xhttp = new XMLHttpRequest();

                xhttp.onreadystatechange = function () {
                    if (this.readyState === 4 && this.status === 200)
                        document.getElementById("idSaidaCalculadora").innerHTML = this.responseText;
                };

                xhttp.open("GET", "calcular?entrada=" + encodeURIComponent(document.getElementById("idCampoEntrada").value), true);
                xhttp.send();
            }

            var ligado = false;
            var contador = 0;

            function troca() {
                ligado ? ligado = false : ligado = true;
                if (ligado)
                    aleatorio();
            }

            function aleatorio() {
                var today = new Date();
                var h = corrigeTempo(today.getHours());
                var m = corrigeTempo(today.getMinutes());
                var s = corrigeTempo(today.getSeconds());
                pegaAleatorio();
                document.getElementById("idSaidaGerador").innerHTML += "<p> " + numeroAleatorio + "</p><p>[" + contador++ + "]  [" + h + ":" + m + ":" + s + "]";
                if (ligado)
                    setTimeout(function () {
                        aleatorio();
                    }, 4000);
            }

            function corrigeTempo(i) {
                return i < 10 ? "0" + i : i;
            }

            var numeroAleatorio;

            function pegaAleatorio() {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState === 4 && this.status === 200)
                        numeroAleatorio = this.responseText;
                };
                xhttp.open("GET", "aleatorio", true);
                xhttp.send();
            }
        </script>
    </head>


    <body onload="CarregarPos();">
        <div class="coluna">
            <div id="menu" class="linha menu"></div>
            <div class="linha titulo">Calculadora</div>
            <div class="linha" style="height: 100px"></div>
            <div class="linha">
                <img src="imagens/marcas.png" style="width:100%; height: 100%;">
            </div>
            <div class="linha" style="height: 150px"></div>
            <div class="linha">
                <h1>Tecnologias utilizadas</h1>
                <p>Foram usadas apenas ferramentas livres, sejam elas:</p>
            </div>
            <div class="linha">
                <ul>
                    <li>Netbeans</li>
                    <li>Google Chrome</li>
                    <li>Gimp</li>
                    <li>Inkscape</li>
                    <li>Git</li>
                    <li>GitHub</li>
                    <li>Apache</li>
                    <li>Java</li>
                    <li>HTML 5</li>
                    <li>CSS 3</li>
                    <li>Ajax</li>
                    <li>XML</li>
                </ul>
            </div>
            <div class="linha">


                <h1>Como usar a Calculadora</h1>

                <p>Para utilizar a calculadora insira uma express&atilde;o qualquer, exemplos:</p>
                <pre>
2+2               Express&otilde;es simples
(2+3)             Express&otilde;es com parenteses
3^(3)             Pot&ecirc;ncias
3%(3)             Restos
(4#2)             Radicia&ccedil;&atilde;o
2*(2+2)           Express&otilde;es com e sem par&ecirc;nteses
(2+2)+(3+3)       Par&ecirc;nteses combinados
(5+(3*1)+(7))     Express&otilde;es aninhadas
(5+(3*1)+(7))     Express&otilde;es aninhadas
(30.5/2)+(2^2)    Express&otilde;es com n&uacute;meros decimais
(30000/2)+(2^2)   N&uacute;mero de diversas casas
                </pre>

                <p>As opera&ccedil;&otilde;es s&atilde;o infixadas e com dois operandos, os operadores conhecidos pelo avaliador de express&otilde;es s&atilde;o:</p>
            </div>
            <div class="linha">
                <ul>
                    <li>"+" Soma</li>
                    <li>"-" Subtra&ccedil;&atilde;o</li>
                    <li>"*" Multiplica&ccedil;&atilde;o</li>
                    <li>"/" Divis&atilde;o</li>
                    <li>"^" Potencia&ccedil;&atilde;o</li>
                    <li>"#" Radicia&ccedil;&atilde;o</li>
                </ul>
            </div>
            <div class="linha">
                <p>Observa&ccedil;&atilde;o:: A calculadora n&atilde;o entende precedencia entre operadores, cuidado para n&atilde;o esperar resultados que nunca surgir&atilde;o. (Pode ser implementado no futuro).</p>
                <h1>Como usar o Gerador</h1>
                <p>O gerador de n&uacute;meros aleat&oacute;rios gera um n&uacute;mero aleat&oacute;rio dentro do intervalo [0,99] a cada 4 segundos, clicar no bot&atilde;o "Iniciar/Parar" alterna entre o funcionamento e o n&atilde;o funcionamento da aplica&ccedil;&atilde;o, mas n&atilde;o interrompe a thread que ja est&aacute; sendo executada, na maioria dos casos o usu&aacute;rio ter&aacute; a impress&atilde;o de que sempre haver&aacute; mais uma sa&iacute;da ao final, isto &eacute; normal.</p>
            </div>
            <div class="linha">
                <h1>Programas</h1>
            </div>
            <div class="linha" style="height: 50px"></div>
            <form>
                <fieldset>
                    <legend>Calculadora</legend>
                    <input id="idCampoEntrada" type="text">
                    <input type="button" value="Calcular" onclick="calcula();" />
                    <p id="idSaidaCalculadora">Sa&iacute;da do programa</p>
                </fieldset>
            </form>
            <div class="linha" style="height: 200px"></div>
            <form>
                <fieldset>
                    <legend>Gerador de aleatórios</legend>
                    <div class="linha" style="height: 25px"></div>
                    <input type="button" value="Iniciar/Parar" onclick="troca();" />
                    <p id="idSaidaGerador">Saida do gerador</p>
                </fieldset>
            </form>
            <div id="rodape" class="linha rodape"></div>
        </div>
    </div>
</body>
</html>
