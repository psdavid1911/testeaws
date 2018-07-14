package PM;

import Tempo.DataHora;

public class Escalacao implements Comparable<Escalacao>{

    private String pm;
    private String posto;
    private DataHora horaInicial;
    private DataHora horaFinal;
    private String contato;
    
    @Override
    public int compareTo(Escalacao escalacao) {
        return this.posto.compareTo(escalacao.getPosto());
    }

    public String getPm() {
        return pm;
    }

    public void setPm(String pm) {
        this.pm = pm;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public DataHora getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(DataHora horaInicial) {
        this.horaInicial = horaInicial;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "\nEscalacao{" + "pm=" + pm + ", posto=" + posto + ", qtr=" + horaInicial + ", contato=" + contato + '}';
    }

    public DataHora getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(DataHora horaFinal) {
        this.horaFinal = horaFinal;
    }
    
    
    
}
