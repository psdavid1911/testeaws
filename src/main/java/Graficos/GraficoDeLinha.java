package Graficos;
import EstruturasDeDados8.Lista;
import EstruturasDeDados8.Par8;
import EstruturasDeDados8.TabelaHash8;
import java.io.*;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoDeLinha<TIPOX extends Comparable,TIPOY extends Number>{

    DefaultCategoryDataset conjuntoDeDados=new DefaultCategoryDataset();

    public void adicionaConjuntoDeDados(TabelaHash8<TIPOX,TIPOY> dados,String NomeDaSerie){
        for(Entry<TIPOX,TIPOY> entrada:dados.conjunto())
            conjuntoDeDados.addValue(entrada.getValue(),NomeDaSerie,entrada.getKey());
    }

    public void adicionaConjuntoDeDados(Lista<Par8<TIPOX,TIPOY>> dados,String NomeDaSerie){
        for(Par8<TIPOX,TIPOY> par:dados)
            conjuntoDeDados.addValue(par.getY(),NomeDaSerie,par.getX());
    }

    public void criaGrafico(TabelaHash8<TIPOX,TIPOY> dados,String NomeDaSerie,String rotuloX,String rotuloY,String titulo){
        adicionaConjuntoDeDados(dados,NomeDaSerie);
        JFreeChart lineChartObject=ChartFactory.createLineChart(titulo,
                rotuloX,
                rotuloY,
                conjuntoDeDados,
                PlotOrientation.VERTICAL,
                true,true,false
        );
        int largura=800;
        /*
         * Width of the image
         */
        int altura=600;
        /*
         * Height of the image
         */
        File arquivo=new File(titulo+".jpeg");
        try{
            ChartUtilities.saveChartAsJPEG(arquivo,lineChartObject,largura,altura);
        }catch(IOException ex){
            Logger.getLogger(GraficoDeLinha.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void criaGrafico(String rotuloX,String rotuloY,String titulo){
        JFreeChart lineChartObject=ChartFactory.createLineChart(titulo,
                rotuloX,
                rotuloY,
                conjuntoDeDados,
                PlotOrientation.VERTICAL,
                true,true,false
        );
        int largura=800;
        /*
         * Width of the image
         */
        int altura=600;
        /*
         * Height of the image
         */
        File arquivo=new File(titulo+".jpeg");
        try{
            ChartUtilities.saveChartAsJPEG(arquivo,lineChartObject,largura,altura);
        }catch(IOException ex){
            Logger.getLogger(GraficoDeLinha.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
