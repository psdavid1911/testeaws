package TiposDeDados;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Data implements Comparable<Data>{

    LocalDate data;

    public Data(int dia, int mes, int ano){
        try{
            data = LocalDate.of(ano, mes, dia);
        } catch (Exception e){
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
    
    public int semana() {
   	 TemporalField woy = WeekFields.of(Locale.getDefault()).weekOfWeekBasedYear(); 
   	 return data.get(woy);
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
