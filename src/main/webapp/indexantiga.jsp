<%-- 
    Document   : inicio
    Created on : 12/06/2018, 06:01:25
    Author     : psdav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Desafio</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
      body{
          top: 0;
          left: 0;
          border: 0;
          padding: 0;
          margin: 0;
          background-color: black;    
      }
      div{
          display: -webkit-box;
          display: -moz-box;
          display: -ms-flexbox;
          display: -moz-flex;
          display: -webkit-flex;
          display: flex;
          text-align: center;
          justify-content: center;
          align-self: center;
          margin: 0;
          border: 0;
          padding: 5px 5px 5px 5px;
          color: white;
          background-color:  rgba(255,255,255,0.1);
      }
      .projeto{
          align-items: center;
          width: 200px;
          height: 250px;
          font: 36px sans-serif;
      }
      .coluna{
          flex-direction: column;
      }
      .linha{
          flex-direction: row;
      }
      .titulo{
          font: 36px sans-serif;
      }
      .coluna, .linha, .titulo{
          /*background-color: rgba(0,0,0,1);*/
      }
      a{
          text-decoration: none;
      }
    </style>
  </head>
  <body>
    <div class="coluna">


      <div class="linha titulo" style="font-size: 48px;">
        Bem vindo
      </div>
      <div class="linha titulo">
        <a href="calculadora.jsp"><div class="projeto">Calculadora</div></a>
        <a href="analisador_sintatico.jsp"><div class="projeto">Analisador<br>sintático</div></a>
        <a href="escala_de_trabalho.jsp"><div class="projeto">Escala<br>de<br>trabalho</div></a>
        <a href="gerador_de_trabalhos.jsp"><div class="projeto">Gerador<br>de<br>trabalhos</div></a>
      </div>
      <div class="linha titulo">
        <a href="programa_estatistico.jsp"><div class="projeto">Programa<br>etatístico</div></a>
        <a href="gerenciador_de_estoque.jsp"><div class="projeto">Gerenciador<br>de<br>estoque</div></a>
        <a href="https://psdavid1911.github.io/"><div class="projeto">Página<br>pessoal</div></a>
      </div>
    </div>

  </body>
</html>
