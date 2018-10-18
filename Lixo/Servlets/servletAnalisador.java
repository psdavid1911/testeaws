package Servlets;

import AnalisadorSintatico.Parsing;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/analisar"})
public class servletAnalisador extends HttpServlet{

    String gramatica = "file:///C:/Users/psdav/Documents/NetBeansProjects/testeaws/src/main/webapp/arquivos/gramatica.txt";
    String lexico = "file:///C:/Users/psdav/Documents/NetBeansProjects/testeaws/src/main/webapp/arquivos/lexico.txt";
    public Parsing analisador = new Parsing(gramatica, lexico);

    @Override protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        String uri = request.getRequestURI(); //uri = "/context/someAction"
        String url = request.getRequestURL().toString();// url = "http://server.name:8080/context/someAction"
        url = url.replaceFirst(uri, "");// url = "http://server.name:8080"
        response.setContentType("text/html");
        String original = request.getParameter("entrada");
        analisador.testa("Período", "Agramatical", original);
        response.getWriter().print(analisador);
    }
}
