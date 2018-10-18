package GeometriaAnalitica;

import static GeometriaAnalitica.Crescimento.CRESCENTE;
import static GeometriaAnalitica.Crescimento.DECRESCENTE;
import static java.lang.Math.atan;

public class Reta{

    private Double alfa_coeficienteAngular;
    private Crescimento crescimento;
    private Double elevacao;
    private Double m_inclinacao;
    private Ponto p1;
    private Ponto p2;
    private Double passo;

    /**
     * Reta considerada a partir da origem
     *
     * @param p2
     */
    public Reta(Ponto p2){
        p1 = new Ponto();
        this.p2 = p2;
        elevacao = p2.deltaY(p1);
        passo = p2.deltaX(p1);
        m_inclinacao = elevacao / passo;
        alfa_coeficienteAngular = atan(m_inclinacao);
        crescimento = m_inclinacao < 0 ? DECRESCENTE : CRESCENTE;
    }

    public Reta(Ponto p1, Ponto p2){
        this.p1 = p1;
        this.p2 = p2;
        elevacao = p2.deltaY(p1);
        passo = p2.deltaX(p1);
        m_inclinacao = elevacao / passo;
        alfa_coeficienteAngular = atan(m_inclinacao);
        crescimento = m_inclinacao < 0 ? DECRESCENTE : CRESCENTE;
    }

    public String equacaoDaReta(){
        return "y-" + getP1().getX() + "=" + getM_inclinacao() + ".(x-" + getP1().getX() + ")";
    }

    /**
     * Inconpleta, precisa de uma formula pra verificar interceptação.
     *
     * @return
     */
    public String equacaoReduzidaDaReta(){
        if (getP1().getX() == 0)return "y=" + getM_inclinacao() + ".x+" + getP1().getY() + ")";
        else if (getP2().getX() == 0)return "y=" + getM_inclinacao() + ".x+" + getP2().getY() + ")";
        else throw new Error("Esta reta aparentemente não intercepta o eixo x.");
    }

    public Double getY(Double x){
        return getM_inclinacao() * (x - getP1().getX()) + getP1().getY();
    }

    public void imprime(){
        System.out.println(this);
    }

    @Override
    public String toString(){
        return "<INFORMAÇÕES SOBRE A RETA>\n"
                + "<P1> " + getP1().toString() + "\n"
                + "<P2> " + getP2().toString() + "\n"
                + "Inclinação: " + getM_inclinacao() + "\n"
                + "Crescimento: " + getCrescimento() + "\n"
                + "Coeficiente angular: " + getAlfa_coeficienteAngular();
    }

    public Double getAlfa_coeficienteAngular(){
        return alfa_coeficienteAngular;
    }

    public Crescimento getCrescimento(){
        return crescimento;
    }

    public Double getElevacao(){
        return elevacao;
    }

    public Double getM_inclinacao(){
        return m_inclinacao;
    }

    public Ponto getP1(){
        return p1;
    }

    public Ponto getP2(){
        return p2;
    }

    public Double getPasso(){
        return passo;
    }
}
