package Servlets.TiposDeDados;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Data implements Comparable<Data>{
    LocalDate data;

    public Data(int dia, int mes, int ano){
        try{
            data = LocalDate.of(ano, mes, dia);
        }catch(Exception e){
            System.out.println("A data informada esta invalida.");
        }
    }

    public Data(LocalDate data){
        this.data = data;
    }

    public int mes(){
        return data.getMonthValue();
    }

    public int dia(){
        return data.getDayOfMonth();
    }

    public int ano(){
        return data.getYear();
    }

    public LocalDate original(){
        return data;
    }

    @Override
    public int compareTo(Data outraData){
        return data.compareTo(outraData.original());
    }

    @Override
    public String toString(){
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
