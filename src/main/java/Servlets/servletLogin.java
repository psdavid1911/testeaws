package Servlets;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/entrar"})
public class servletLogin extends HttpServlet{

    @Override protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html");
        String login=request.getParameter("usuario");
        String senha=request.getParameter("senha");
        String resultado="Esta não é a senha.";
        if(login.equals("psdavid1911")&&senha.equals("bolsonaro2018"))resultado="Seja bem vindo!";
        response.getWriter().print(resultado);
    }
}
