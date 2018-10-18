package PM;

import static java.lang.Integer.parseInt;

public class Policial_Militar{

    private String Contato = "";
    private String Endereco = "";
    private String Posto_Graduacao = "";
    private String matricula;
    private String nomeDeGuerra;
    private String numeral;

    public Policial_Militar(String matricula, String nomeDeGuerra, String numeral){
        this.matricula = matricula;
        this.nomeDeGuerra = nomeDeGuerra;
        this.numeral = numeral;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj)return true;
        if (obj == null)return false;
        if (getClass() != obj.getClass())return false;
        final Policial_Militar other = (Policial_Militar) obj;
        if ((this.getNomeDeGuerra() == null) ? (other.getNomeDeGuerra() != null) : !this.nomeDeGuerra.equals(other.nomeDeGuerra))return false;
        return true;
    }

    public String getContato(){
        return Contato;
    }

    public void setContato(String Contato){
        this.Contato = Contato;
    }

    public String getEndereco(){
        return Endereco;
    }

    public void setEndereco(String Endereco){
        this.Endereco = Endereco;
    }

    public String getMatricula(){
        return matricula;
    }

    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    public String getNomeDeGuerra(){
        return nomeDeGuerra;
    }

    public void setNomeDeGuerra(String nomeDeGuerra){
        this.nomeDeGuerra = nomeDeGuerra;
    }

    public String getNumeral(){
        return numeral;
    }

    public void setNumeral(String numeral){
        this.numeral = numeral;
    }

    public String getPosto_Graduacao(){
        return Posto_Graduacao;
    }

    public void setPosto_Graduacao(String Posto_Graduacao){
        this.Posto_Graduacao = Posto_Graduacao;
    }

    @Override
    public int hashCode(){
        return parseInt(getMatricula());
    }

    @Override
    public String toString(){
        return "Agente{" + "matricula=" + getMatricula() + ", nomeDeGuerra=" + getNomeDeGuerra() + ", numeral=" + getNumeral() + '}';
    }
}
