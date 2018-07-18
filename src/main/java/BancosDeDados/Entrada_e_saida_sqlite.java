package Servlets.BancosDeDados;
//package BancosDeDados;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.Arrays;
//
//public class Entrada_e_saida_sqlite{
//    Connection connection = null;
//    Statement statement = null;
//    boolean tabelExiste = false;
//
//    public Entrada_e_saida_sqlite(){
//        ArrayList<String> lista = new ArrayList<String>(Arrays.asList(
//                "insert into person values(1, 'leo')",
//                "insert into person values(2, 'david')",
//                "insert into person values(3, 'pedro')",
//                "insert into person values(4, 'ricardo')"
//        ));
//        criaTabela("person (id integer, name string)");
//        if(tabelExiste){
//            erro("a tabela existe");
//            insereDados(lista);
//            pegaDados().forEach(texto -> {
//                erro(texto);
//            });
//            apagaTabela("person");
//        }
//    }
//
//    /**
//     * Apenas a tabela e os campos o resto e feito automático
//     */
//    private void criaTabela(String tabela){
//        try{
//            connection = DriverManager.getConnection("jdbc:sqlite:novo.db"); //Posso mudar o nome
//            statement = connection.createStatement();
//            statement.setQueryTimeout(10);
//            statement.executeUpdate("create table if not exists "+tabela);
//            this.tabelExiste = true;
//        }catch(SQLException ex){
//            erro("nao pude criar a tabela");
//        }finally{
//            try{
//                if(connection!=null)
//                    connection.close();
//            }catch(SQLException e){
//                erro(e.getMessage());
//            }
//        }
//    }
//
//    /**
//     * Uma query por linha querys completas
//     */
//    private void insereDados(ArrayList<String> inserts){
//        if(this.tabelExiste)
//            inserts.forEach(entrada -> {
//                try{
//                    connection = DriverManager.getConnection("jdbc:sqlite:novo.db"); //Posso mudar o nome
//                    statement = connection.createStatement();
//                    statement.setQueryTimeout(10);
//                    statement.executeUpdate(entrada);
//                }catch(SQLException ex){
//                    erro("Nao pude inserir dados.");
//                }finally{
//                    try{
//                        if(connection!=null)
//                            connection.close();
//                    }catch(SQLException e){
//                        erro(e.getMessage());
//                    }
//                }
//            });
//    }
//
//    private ArrayList<String> pegaDados(){
//        ArrayList<String> resultados = new ArrayList<>();
//        try{
//            connection = DriverManager.getConnection("jdbc:sqlite:novo.db"); //Posso mudar o nome
//            statement = connection.createStatement();
//            statement.setQueryTimeout(10);
//            ResultSet rs = statement.executeQuery("select * from person");
//            while(rs.next())
//                resultados.add("name = "+rs.getString("name")+" id = "+rs.getInt("id"));
//        }catch(SQLException ex){
//            erro("Nao pude pegar os dados.");
//        }finally{
//            try{
//                if(connection!=null)
//                    connection.close();
//            }catch(SQLException e){
//                erro(e.getMessage());
//            }
//            return resultados;
//        }
//    }
//
//    private void apagaTabela(String tabela){
//        try{
//            connection = DriverManager.getConnection("jdbc:sqlite:novo.db"); //Posso mudar o nome
//            statement = connection.createStatement();
//            statement.setQueryTimeout(10);
//            statement.executeUpdate("drop table if exists "+tabela);
//            this.tabelExiste = false;
//        }catch(SQLException ex){
//            erro("nao pude apagar a tabela");
//        }finally{
//            try{
//                if(connection!=null)
//                    connection.close();
//            }catch(SQLException e){
//                erro(e.getMessage());
//            }
//        }
//    }
//
//    private void erro(String erro){
//        System.out.println(erro);
//    }
//
//    public static void main(String[] args){
//        new Entrada_e_saida_sqlite();
//    }
//}
