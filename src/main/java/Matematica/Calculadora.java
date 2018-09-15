package Matematica;

import EstruturasDeDados.Pilha;

public class Calculadora{

    private String exp;

    public void setaExpressao( String expressao ){
        this.exp=expressao;
    }

    public String calculaExpressao(){
        return calculaExpressao(exp);
    }

    private String calculaExpressao( String expressao ){
        int posicaoInicial=0;
        int tamanhoDaExpressao=expressao.length();
        int posicaoFinal=expressao.indexOf(')'); // primeiro fechamento
        if( posicaoFinal != -1 ){
            for( int x=posicaoFinal; x >= 0; x-- )
                if( expressao.charAt(x) == '(' ){
                    posicaoInicial=x; // Seu par de abertura
                    break;
                }
            String substringParentada=expressao.substring(posicaoInicial, posicaoFinal + 1);
            String substringTemp=expressao.substring(posicaoInicial + 1, posicaoFinal);
            return Calculadora.this.calculaExpressao(expressao.replace(substringParentada, Calculadora.this.calculaExpressao(substringTemp)));
        }else return calculaSubExpressao(expressao.substring(posicaoInicial, tamanhoDaExpressao));
    }

    private String calculaSubExpressao( String expressao ){
        Pilha<String> pilha=new Pilha<String>();
        int inicio=0;
        String temp="";
        // Monta a pilha de operadores e operandos
        for( int x=0; x < expressao.length(); x++ )
            switch( expressao.charAt(x) ){
                case '^':
                    pilha.empilha(temp);
                    temp="";
                    pilha.empilha("^");
                    inicio=x + 1;
                    break;
                case '*':
                    pilha.empilha(temp);
                    temp="";
                    pilha.empilha("*");
                    inicio=x + 1;
                    break;
                case '/':
                    pilha.empilha(temp);
                    temp="";
                    pilha.empilha("/");
                    inicio=x + 1;
                    break;
                case '+':
                    pilha.empilha(temp);
                    temp="";
                    pilha.empilha("+");
                    inicio=x + 1;
                    break;
                case '-':
                    pilha.empilha(temp);
                    temp="";
                    pilha.empilha("-");
                    inicio=x + 1;
                    break;
                case '#':
                    pilha.empilha(temp);
                    temp="";
                    pilha.empilha("#");
                    inicio=x + 1;
                    break;
                case '%':
                    pilha.empilha(temp);
                    temp="";
                    pilha.empilha("%");
                    inicio=x + 1;
                    break;
                default:
                    temp+=expressao.charAt(x);
                    break;
            }
        pilha.empilha(temp); // o ultimo valor que falta inserir
        // Esvazia pilha com o resultado
        while( pilha.tamanho() > 1 ){
            Double temp2;
            // Cuidado com essa ordem
            double operando1=new Double(pilha.desempilha());
            char operador=pilha.desempilha().charAt(0);
            double operando2=new Double(pilha.desempilha());
            switch( operador ){
                case '^':
                    temp2=Math.pow(operando2, operando1);
                    pilha.empilha(temp2.toString());
                    break;
                case '*':
                    temp2=operando2 * operando1;
                    pilha.empilha(temp2.toString());
                    break;
                case '/':
                    temp2=operando2 / operando1;
                    pilha.empilha(temp2.toString());
                    break;
                case '+':
                    temp2=operando2 + operando1;
                    pilha.empilha(temp2.toString());
                    break;
                case '-':
                    temp2=operando2 - operando1;
                    pilha.empilha(temp2.toString());
                    break;
                case '#':
                    temp2=Math.pow(operando2, 1 / operando1);
                    pilha.empilha(temp2.toString());
                    break;
                case '%':
                    temp2=operando2 % operando1;
                    pilha.empilha(temp2.toString());
                    break;
                default:
                    break;
            }
        }
        return pilha.desempilha();
    }

    //@Test
    private void testaCalcula(){
        Calculadora calc=new Calculadora();
        calc.setaExpressao("4#2");
        System.out.println(calc.calculaExpressao());
    }
}
