/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interessantes;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import org.junit.Test;

/**
 *
 * @author psdav
 */
public class NewEmptyJUnitTest{

    @Test
    public void teste(){
        String content=null;
        URLConnection connection=null;
        try{
            connection=new URL("http://www.google.com").openConnection();
            Scanner scanner=new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content=scanner.next();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        System.out.println(content);
    }
}
