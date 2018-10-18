package Servlets.BancosDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BancoDeDados{

    Connection connection = null;
    Statement statement = null;
    boolean tabela = false;

    // Cria o banco de dados
    public BancoDeDados(){
        criaTabela();
        if (tabela){
            insereDados();
            pegaDados();
        }
//        try {
//            connection = DriverManager.getConnection("jdbc:sqlite:novo.db"); //Posso mudar o nome
//            statement = connection.createStatement();
//            statement.setQueryTimeout(10);
//
//            statement.executeUpdate("drop table if exists person");
//            statement.executeUpdate("create table person (id integer, name string)");
//            statement.executeUpdate("insert into person values(1, 'leo')");
//            statement.executeUpdate("insert into person values(2, 'yui')");
//            ResultSet rs = statement.executeQuery("select * from person");
//            while (rs.next()) {
//                // read the result set
//                System.out.println("name = " + rs.getString("name"));
//                System.out.println("id = " + rs.getInt("id"));
//            }
//        } catch (SQLException e) {
//            // if the error message is "out of memory",
//            // it probably means no database file is found
//            System.err.println(e.getMessage());
//        } finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                // connection close failed.
//                System.err.println(e);
//            }
//        }
    }

    private void criaTabela(){
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:novo.db"); //Posso mudar o nome
            statement = connection.createStatement();
            statement.setQueryTimeout(10);
            statement.executeUpdate("create table if not exists person (id integer, name string)");
            tabela = true;
        } catch (SQLException ex){
            erro("nao pude criar a tabela");
        } finally{
            try{
                if (connection != null)
                    connection.close();
            } catch (SQLException e){
                erro(e.getMessage());
            }
        }
    }

    private void insereDados(){
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:novo.db"); //Posso mudar o nome
            statement = connection.createStatement();
            statement.setQueryTimeout(10);
            statement.executeUpdate("insert into person values(1, 'leo')");
            statement.executeUpdate("insert into person values(2, 'yui')");
        } catch (SQLException ex){
            erro("nao pude criar a tabela");
        } finally{
            try{
                if (connection != null)
                    connection.close();
            } catch (SQLException e){
                erro(e.getMessage());
            }
        }
    }

    private void pegaDados(){
        try{
            connection = DriverManager.getConnection("jdbc:sqlite:novo.db"); //Posso mudar o nome
            statement = connection.createStatement();
            statement.setQueryTimeout(10);
            ResultSet rs = statement.executeQuery("select * from person");
            while (rs.next()){
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        } catch (SQLException ex){
            erro("nao pude criar a tabela");
        } finally{
            try{
                if (connection != null)
                    connection.close();
            } catch (SQLException e){
                erro(e.getMessage());
            }
        }
    }

    public static void main(String[] args){
        new BancoDeDados();
    }

    private void erro(String erro){
        System.out.println(erro);
    }
}
