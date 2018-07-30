package Servlets.PDF;

/**
 *
 * @author psdav
 */
public class medidas{

    static float pt2mmForWeb72dpi(float pt){
        return pt2mm(pt,72);
    }

    static float pt2mmForPrint300dpi(float pt){
        return pt2mm(pt,300);
    }

    static float pt2mmForPrint600dpi(float pt){
        return pt2mm(pt,600);
    }

    static float pt2mm(float pt,float dpi){
        return pt*25.4f/dpi;
    }

    static float cm2pt(float x){
        return (float)((595.27563*x)/21);
    }

    static float posicaoY(float x){
        return (float)(841.8898-x);
    }

    static float x_cm(float x){
        return cm2pt(x);
    }

    static float y_cm(float y){
        return posicaoY(cm2pt(y));
    }
}
