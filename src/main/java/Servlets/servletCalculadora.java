package Servlets;
import Matematica.Calculadora;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/calcular"})
public class servletCalculadora extends HttpServlet{

    @Override protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        Calculadora calc=new Calculadora();
        calc.setaExpressao(request.getParameter("entrada"));
        response.setContentType("text/html");
        response.getWriter().print(calc.calculaExpressao());
    }
}
