import EstruturasDeDados8.Lista;
import Matematica.EstatisticaDescritiva;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/calcularEstatistico"})
public class servletEstatistico extends HttpServlet{

    @Override protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        doPost(request,response);
    }

    @Override protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        EstatisticaDescritiva e=new EstatisticaDescritiva();
        response.setContentType("text/html");
        String entrada=request.getParameter("entrada");
        String[] nova=null;
        Lista<Double> conjunto=new Lista<Double>();
        if(entrada==null){
            response.getWriter().print("Entrada vazia");
            return;
        }else if(entrada.contains(";"))
            nova=entrada.split(";");
        else if(entrada.contains(","))
            nova=entrada.split(",");
        else if(entrada.contains("\\s"))
            nova=entrada.split("\\s");
        for(String s:nova)
            conjunto.add(new Double(s));
        String s=""
                +"<h1>Média Aritmética</h1><br>"
                +"Média aritmética de dois ou mais termos é o quociente do resultado da divisão da soma dos números dados pela quantidade de números somados.<br>"
                +"Média aritmética: "+e.mediaAritimetica(conjunto)+"<br>"
                +"<br>"
                +"<h1>Média Geométrica</h1><br>"
                +"Na matemática, a média geométrica de um conjunto de números positivos é definida como o produto de todos os membros do conjunto elevado ao inverso do número de membros. Indica a tendência central ou o valor típico de um conjunto de números usando o produto dos seus valores<br>"
                +"Média Geométrica: "+e.mediaGeometrica(conjunto)+"<br>"
                +"<br>"
                +"<h1>Média Quadrática</h1><br>"
                +"Raiz da soma dos quadrados divididos pelo número de elementos. RMS(Root Mean Square).<br>"
                +"Média quadrática: "+e.mediaQuadratica(conjunto)+"<br>"
                +"<br>"
                +"<h1>Desvio Padrão</h1><br>"
                +"Fórmula usada quando se conhece todos os elementos de um dado conjuntonete caso os valores informados. É a medida de que representa a média do quão afastados estãos os elementos de sua média. Esta medida é de mais fácil compreensão se comparada com a variância pois seus valores não estão elevados ao quadrado.<br>"
                +"Desvio Padrão: "+e.desvioPadrao(conjunto)+"<br>"
                +"<br>"
                +"<h1>Mediana</h1><br>"
                +"Compreendido entre a média e a moda, este valor representa o valor central da distribuição, divide o conjunto de dados em duas partes iguais.<br>"
                +"Mediana: "+e.mediana(conjunto)+"<br>"
                +"<br>"
                +"<h1>Máximo</h1><br>"
                +"Maior valor do conjunto fornecido.<br>"
                +"Máximo: "+e.maximo(conjunto)+"<br>"
                +"<br>"
                +"<h1>Mínimo</h1><br>"
                +"Menor valor do conjunto informado.<br>"
                +"Mínimo: "+e.minimo(conjunto)+"<br>"
                +"<br>"
                +"<h1>Número de termos</h1><br>"
                +"Número de termos: "+e.numeroDeTermos(conjunto)+"<br>"
                +"<br>"
                +"<h1>Soma</h1><br>"
                +"Soma dos valores informados<br>"
                +"Soma: "+e.soma(conjunto)+"<br>"
                +"<br>"
                +"<h1>Soma dos quadrados</h1><br>"
                +"Eleva cada termo ao gadrado e os soma<br>"
                +"Soma dos quadrados: "+e.somaDosQuadrados(conjunto)+"<br>"
                +"<br>"
                +"<h1>Variância da amostra</h1><br>"
                +"Fórmula usada quando NÃO se conhece todos os elementos de um dado conjunto, isto é, quando pegamos apenas uma pequena parcela para representar um todo maior. É a medida de que representa a média do quão afastados estãos os elementos de sua média. Contudo esta medida pode ser de difícil interpretação uma vez que seus valores estão elevados ao quadrado.<br>"
                +"Variância da amostra: "+e.varianciaDaAmostra(conjunto)+"<br>"
                +"<br>"
                +"<h1>Variância da população</h1><br>"
                +"Fórmula usada quando se conhece todos os elementos de um dado conjunto. É a medida de que representa a média do quão afastados estãos os elementos de sua média. Contudo esta medida pode ser de difícil interpretação uma vez que seus valores estão elevados ao quadrado.<br>"
                +"Variância da população: "+e.varianciaDaPopulacao(conjunto)+"<br>"
                +"<br>"
                +"<h1>Assimetria</h1><br>"
                +"Assimetria do conjunto e dado como um valor entre -1 e 1, o ponto central 0 significa que a curva é simétrica enquanto valores negativos indicam inclinação para esquerda, positivos para a direita.<br>"
                +"Assimetria: "+e.assimetria(conjunto)+"<br>"
                +"<br>"
                +"<h1>Valores ordenados</h1><br>"
                +"Mostra os valores informados de maneira organizada.<br."
                +"Valores : "+e.valoresOrdenados(conjunto)+"<br>"
                +"<br>"
                +"<h1>Percentil</h1><br>"
                +"<br>"
                +"Percentil (10%): "+e.percentil(conjunto,10D)+"<br>"
                +"Percentil (25%): "+e.percentil(conjunto,25D)+"<br>"
                +"Percentil (50%): "+e.percentil(conjunto,50D)+"<br>"
                +"Percentil (75%): "+e.percentil(conjunto,75D)+"<br>"
                +"<br>"
                +"<h1>Curtose</h1><br>"
                +"Medida de achatamento de uma curva de distribuição de frequências.<br>"
                +"Curtose"+e.curtose(conjunto)+"<br>"
                +"<br>"
                +"<h1>Frequência Absoluta</h1><br>"
                +"Por melhorar!!!!!!!"+" "+"<br>"
                +"<br>"
                +"<h1>Frequência Percentual</h1><br>"
                +"Por melhorar!!!!!!!"+" "+"<br>"
                +"<br>"
                +"<h1>Moda</h1><br>"
                +"Uma lista dos elementos que mais se repetem no conjunto.<br>"
                +"Moda: "+e.moda(conjunto)+"<br>"
                +"<br>"
                +"<h1>Frequência Acumulada Absoluta</h1><br>"
                +"A MELHORAR!!!!!!!!<br>"
                +"Frequência Acumulada Absoluta: "+" "+"<br>"
                +"<br>"
                +"<h1>Frequência Acumulada Relativa</h1><br>"
                +"A MELHORAR!!!!!!!!<br>"
                +"Frequência Acumulada Percentual: "+" "+"<br>"
                +"<br>"
                +"<h1>Soma das Frequências</h1><br>"
                +"Soma das frequências<br>"
                +"Soma das frequências: "+e.somaDasFrequencias(conjunto)+"<br>"
                +"<br>"
                +"<h1>Número de elementos distintos</h1><br>"
                +"Número de elementos distintos<br>"
                +"Número de elementos distintos: "+e.numeroDeElementosDistintos(conjunto)+"<br>"
                +"<br>"
                +"";
        response.getWriter().print(s);
    }
}
