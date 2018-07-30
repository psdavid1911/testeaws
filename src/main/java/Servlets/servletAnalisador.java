package Servlets;
import AnalisadorSintatico.Parsing;
import AnalisadorSintatico.Separador;
import EstruturasDeDados.Lista;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/analisar"})
public class servletAnalisador extends HttpServlet{

    @Override protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        request.setCharacterEncoding("UTF-8");
        String resultadoFinal="";
        String uri=request.getRequestURI(); //uri = "/context/someAction"
        String url=request.getRequestURL().toString();// url = "http://server.name:8080/context/someAction"
        url=url.replaceFirst(uri,"");// url = "http://server.name:8080"
        Parsing analisador=new Parsing(url+"/arquivos/lexico.txt",url+"/arquivos/gramatica.txt");
        Lista<String> conversaoInicial=new Lista<String>();
        response.setContentType("text/html");
        String original=request.getParameter("entrada");
        for(String palavra:Separador.separa(original)) conversaoInicial.add(analisador.lexico.get(palavra));
        Lista<String> resultado=analisador.configuraTesta("Período","Agramatical",conversaoInicial);
        resultadoFinal+=resultado;
        for(String momento:analisador.procedimento) resultadoFinal+=momento;
        resultadoFinal+="<br>Substituição |^|: "+conversaoInicial.toString();
        resultadoFinal+="<br>Substituição |^|: "+new Lista<String>(original.split(" ")).toString();
        response.getWriter().print(resultadoFinal);
    }

    
}
