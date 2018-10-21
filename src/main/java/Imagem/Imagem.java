package Imagem;

import EstruturasDeDados.Par;
import FluxoDeArquivos.GerenciadorDeArquivo;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Imagem{

    Graphics pincel;
    BufferedImage imagem;
    int largura;
    int altura;

    /**
     * Cria uma nova imagem em
     * <a href="http://blogwebdesignmicrocamp.com.br/webdesign/conversao-de-pixels-em-centimetros/">pixels</a>
     *
     * @param largura
     * @param altura
     */
    public Imagem(int largura, int altura){
        this.altura = altura;
        this.largura = largura;
        imagem = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_ARGB);
        pincel = imagem.createGraphics();
        pincel.setFont(new Font("Dialog", Font.PLAIN, 12));
    }

  
    public void corDoFundo(Color cor){
        desenhaRetangulo(cor, 0, 0, largura, altura);
    }

    public void desenhaRetangulo(Color cor, int x, int y, int largura, int altura){
        pincel.setColor(cor);
        pincel.fillRect(x, y, largura, altura);
    }

    public void desenhaRetangulo_cm(Color cor, int x, int y, int largura, int altura){
        pincel.setColor(cor);
        pincel.fillRect(x, y, largura, altura);
    }

    public Par<Integer, Integer> desenhaTexto(Color cor, String texto, int x, int y){
        pincel.setColor(cor);
        x -= larguraDoTexto(texto) / 2;
        y += alturaDaFonte() / 2;
        pincel.drawString(texto, x, y);
        return new Par<Integer, Integer>(larguraDoTexto(texto), alturaDaFonte());
    }

    /**
     *
     * @param cor cor
     * @param x coordenada do centro x
     * @param y coordenada do centro y
     * @param raio raio
     */
    public void desenhaCircunferenciaPeloCentro(Color cor, int x, int y, int raio){
        x -= raio + 1;// posicao do centro real
        y -= raio - 1;// posicao do centro real
        raio *= 2; // largura x altura
        pincel.setColor(cor);
        pincel.drawArc(x, y, raio, raio, 0, 360);
    }

    /**
     *
     * @param cor cor
     * @param x coordenada do centro x
     * @param y coordenada do centro y
     * @param raio raio
     */
    public void desenhaCirculoPeloCentro(Color cor, int x, int y, int raio){
        x -= raio + 1;// posicao do centro real
        y -= raio - 1;// posicao do centro real
        raio *= 2; // largura x altura
        pincel.setColor(cor);
        pincel.fillArc(x, y, raio, raio, 0, 360);
    }

    public void desenhaLinha(Color cor, int x, int y, int x2, int y2){
        pincel.setColor(cor);
        pincel.drawLine(x, y, x2, y2);
    }

    public int larguraDoTexto(String texto){
        FontMetrics metricas = pincel.getFontMetrics();
        return metricas.stringWidth(texto);
    }

    public int alturaDaFonte(){
        FontMetrics metricas = pincel.getFontMetrics();
        return metricas.getHeight();
    }

    public Image getImagem(){
        return imagem.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
    }

    public void desenhaCircu(Color cor, int x, int y, int raio){
        desenhaCirculoPeloCentro(cor, x, y, raio / 2);
    }

    public void desenhaEixoCentral(int dimx, int dimy){
        desenhaLinha(Color.red, 0, dimy / 2, dimx, dimy / 2);
        desenhaLinha(Color.red, dimx / 2, 0, dimx / 2, dimy);
    }

    public void desenhaCircunferenciaEmVolta(Color cor, int x, int y, int raio){
        desenhaCircunferenciaPeloCentro(cor, x, y, raio / 2);
    }

    public void desenhaEspiralDeArquimedes(int xAnterior, int yAnterior, int quantidadePontos){
        int xDoCentro = xAnterior;
        int yDoCentro = yAnterior;
        double angulo = 0;
        for (int i = 0; i < quantidadePontos; i++){
            double raio = 50 + 5 * Math.toRadians(angulo); // espiral de arquimedes // a + b angulo // a buraco do meio // b espaco entre linhas
            Par<Integer, Integer> coordenadas = coordCartesianas(raio, angulo);
            int xNovo, yNovo;
            xNovo = coordenadas.X() + xDoCentro;
            yNovo = coordenadas.Y() + yDoCentro;
            //System.out.println("x "+Integer.toString(xNovo)+"   y "+Integer.toString(yNovo));
            desenhaLinha(Color.red, xAnterior, yAnterior, xNovo, yNovo);
            angulo += 57; // aumenta ou diminue a precisao em graus 0 - 180
            xAnterior = xNovo;
            yAnterior = yNovo;
        }
    }

    public Par<Integer, Integer> coordCartesianas(double raio, double angulo){
        Integer x, y;
        x = (int) (raio * Math.cos(angulo));
        y = (int) (raio * Math.sin(angulo));
        return new Par<Integer, Integer>(x, y);
    }

    public void salvaNoArquivo(String caminhoArquivo){
        GerenciadorDeArquivo arquivo = new GerenciadorDeArquivo(caminhoArquivo);
        arquivo.apaga();
        try{
            ImageIO.write(imagem, "jpg", arquivo);
        } catch (IOException ex){
            Logger.getLogger(Imagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
