package testes_AnalisadorCompilador;

public class compilador{
    
    
    
    public class Boleano{
        Boolean boleano;
        public Boleano(Boolean boleano){this.boleano = boleano;}
    }
    
    public class Palavra{
        String palavra;
        public Palavra(String palavra){this.palavra = palavra;}
    }

    public class Numero{
        Double numero;
        Numero(int n){numero=(double)n;}
        Numero(float n){numero=(double)n;}
        Numero(double n){numero=n;}
    }
}
