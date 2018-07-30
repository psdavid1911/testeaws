package Servlets.PDF;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author psdav
 */
public class PDF{

    String nomeDoArquivo;

    public PDF(String nomeDoArquivo){
        this.nomeDoArquivo=nomeDoArquivo;
    }

    public void criaPDF(){
        try{
            PDDocument documento=new PDDocument();
            PDPage pagina=new PDPage(PDRectangle.A4);
            documento.addPage(pagina);
            PDPageContentStream conteudo=new PDPageContentStream(documento,pagina);
            conteudo.beginText();
            conteudo.setFont(PDType1Font.COURIER_OBLIQUE,12);
            conteudo.newLineAtOffset(medidas.x_cm(1.5f),medidas.y_cm(3f));
            conteudo.showText("Agora vai comecar a ficar interessante");
            conteudo.endText();
            conteudo.close();
            documento.save(nomeDoArquivo);
            documento.close();
            System.out.print("arquivo criado em: "+System.getProperty("user.dir"));
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
}
