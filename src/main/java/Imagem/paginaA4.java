package Imagem;
import java.awt.Color;
import java.awt.Image;

public class paginaA4{

    Imagem i;
    int altura=297;
    int largura=210;
    int dpi=72;
    int margemSuperior=20;
    int margemEsquerda=30;
    int margemDireita=20;
    int margemInferior=20;
    int margemCabecalho=10;
    int alturaPX=mm_px_porDPI(altura,dpi);
    int larguraPX=mm_px_porDPI(largura,dpi);
    int margemSuperiorPX=mm_px_porDPI(margemSuperior,dpi);
    int margemEsquerdaPX=mm_px_porDPI(margemEsquerda,dpi);
    int margemDireitaPX=mm_px_porDPI(margemDireita,dpi);
    int margemInferiorPX=mm_px_porDPI(margemInferior,dpi);
    int margemCabecalhoPX=mm_px_porDPI(margemCabecalho,dpi);

    static public int cm_px_porDPI(double valor,int dpi){
        return new Double(valor*(dpi/2.54d)).intValue();
    }

    static public int mm_px_porDPI(double valor,int dpi){
        return new Double((valor/10)*(dpi/2.54d)).intValue();
    }

    public paginaA4(String tamanho){
        i=new Imagem(larguraPX,alturaPX);
        i.corDoFundo(Color.WHITE);
        i.desenhaRetangulo(
                new Color(0,0,0,175),
                0,
                0,
                larguraPX, // largura
                margemSuperiorPX // altura
        );
        i.desenhaRetangulo(
                new Color(0,0,0,175),
                0,
                alturaPX-margemInferiorPX,
                larguraPX,
                margemInferiorPX
        );
        i.desenhaRetangulo(
                new Color(0,0,0,175),
                0,
                0,
                margemEsquerdaPX,
                alturaPX
        );
        i.desenhaRetangulo(
                new Color(0,0,0,175),
                larguraPX-margemDireitaPX,
                0,
                margemDireitaPX,
                alturaPX
        );
        i.desenhaRetangulo(
                new Color(0,0,0,175),
                0,
                margemSuperiorPX,
                larguraPX,
                margemCabecalhoPX
        );
        salva();
    }

    public Image getImagem(){
        return i.getImagem();
    }

    public void salva(){
        i.salvaNoArquivo("imagem.jpg");
    }
}
