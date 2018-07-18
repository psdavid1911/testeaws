package Servlets.KultaVendas;

import Servlets.TiposDeDados.Data;
import KultaEnumeracoes.COR;
import KultaEnumeracoes.NOME;
import KultaEnumeracoes.TAMANHO;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author david
 */
public class Venda implements Serializable, Comparable<Venda>{
    private Data data;
    private Double valordaunidade;
    private COR cor;
    private Integer unidadesvendidas;
    private TAMANHO tamanho;
    private NOME nome;

    public NOME getNome(){
        return nome;
    }

    public void setNome(NOME nome){
        this.nome = nome;
    }

    public Data getData(){
        return data;
    }

    public void setData(Data data){
        this.data = data;
    }

    public Double getValordaunidade(){
        return valordaunidade;
    }

    public void setValordaunidade(Double valordaunidade){
        this.valordaunidade = valordaunidade;
    }

    public COR getCor(){
        return cor;
    }

    public void setCor(COR cor){
        this.cor = cor;
    }

    public Integer getUnidadesvendidas(){
        return unidadesvendidas;
    }

    public void setUnidadesvendidas(Integer unidadesvendidas){
        this.unidadesvendidas = unidadesvendidas;
    }

    public TAMANHO getTamanho(){
        return tamanho;
    }

    public void setTamanho(TAMANHO tamanho){
        this.tamanho = tamanho;
    }

    public static Venda setTudo(NOME nomeDoProduto, String data, Integer unidadesvendidas, Double valordaunidade, COR cor, TAMANHO tamanho){
        Venda venda = new Venda();
        venda.setData(new Data(LocalDate.parse(data, DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
        venda.setCor(cor);
        venda.setTamanho(tamanho);
        venda.setUnidadesvendidas(unidadesvendidas);
        venda.setValordaunidade(valordaunidade);
        venda.setNome(nomeDoProduto);
        return venda;
    }

    @Override
    public String toString(){
        return ""
                +"Nome: "
                +nome
                +" Tamanho: "
                +tamanho
                +" Cor:"
                +cor
                +" Data: "
                +data.toString()
                +" Valor unitário: "
                +valordaunidade
                +" Unidades vendidas:"
                +unidadesvendidas;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        Venda nova = new Venda();
        nova.setNome(nome);
        nova.setCor(cor);
        nova.setTamanho(tamanho);
        nova.setUnidadesvendidas(unidadesvendidas);
        nova.setValordaunidade(valordaunidade);
        nova.setData(data);
        return nova;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Venda))
            return false;
        Venda outra = (Venda) obj;
        if(outra.getNome().equals(nome)
                &&outra.getTamanho().equals(tamanho)
                &&outra.getCor().equals(cor)
                &&outra.getData().equals(data)
                &&outra.getUnidadesvendidas().equals(unidadesvendidas))
            return true;
        else
            return false;
    }

    @Override
    public int compareTo(Venda outraVenda){
        return nome.toString().compareTo(outraVenda.nome.toString());
    }
}
