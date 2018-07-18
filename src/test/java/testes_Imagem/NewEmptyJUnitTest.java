/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes_Imagem;

import Imagem.paginaA4;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author david
 */
public class NewEmptyJUnitTest{
    paginaA4 documento = new paginaA4("");

    @Before
    public void setUp(){
    }

    @Test
    public void salvaImagem(){
        documento.salva();
    }
}
