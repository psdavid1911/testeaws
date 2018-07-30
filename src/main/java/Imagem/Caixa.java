package Imagem;

public class Caixa{

    public Caixa(Coordenada origem,Dimensao dimensao){
        this.origem=origem;
        this.dimensao=dimensao;
        destino.setX(origem.getX()+dimensao.getLargura());
        destino.setY(origem.getY()+dimensao.getAltura());
    }
    // Variáveis
    Caixa anterior=null;
    Caixa proxima=null;
    Coordenada origem;
    Coordenada destino;
    Dimensao dimensao;
}
