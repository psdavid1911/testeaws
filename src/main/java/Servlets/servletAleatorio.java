package Servlets;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/aleatorio"})
public class servletAleatorio extends HttpServlet{

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        response.setContentType("text/html");
        response.getWriter().print(aleatorio());
    }

    public int aleatorio(){
        return new Random().nextInt(100);
    }
}
