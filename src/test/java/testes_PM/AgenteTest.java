package testes_PM;

import EstruturasDeDados.Lista;
import PM.AgenteAntigo;
import PM.Gerar;
import PM.Servico;
import PM.Tipo_de_escala;
import Tempo.DataHora;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author psdav
 */
public class AgenteTest{

    AgenteAntigo agente = new AgenteAntigo();

    @Before
    public void setUp(){
        agente.setContato("3333-3333");
        agente.setEscala(Gerar.tipo_de_escala(4, 2));
        agente.setNome("David");
        agente.setNumeral(32711);
        agente.setServicos(new Lista<Servico>(
                Gerar.servico(new DataHora(7, 30), new DataHora(14, 30), "Caça e pesca"),
                Gerar.servico(new DataHora(10, 00), new DataHora(17, 0), "Tia")
        ));
    }

    @Test
    public void testGetNumeral(){
        System.out.println("getNumeral");
        Integer expResult = 32711;
        Integer result = agente.getNumeral();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNome(){
        System.out.println("getNome");
        String expResult = "David";
        String result = agente.getNome();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetServicos(){
        System.out.println("getServicos");
        Lista<Servico> expResult = new Lista<Servico>(
                Gerar.servico(new DataHora(7, 30), new DataHora(14, 30), "Caça e pesca"),
                Gerar.servico(new DataHora(10, 00), new DataHora(17, 0), "Tia")
        );
        Lista<Servico> result = agente.getServicos();
        assertEquals(expResult.toString(), result.toString());
    }

    @Test
    public void testAddServico(){
        System.out.println("addServico");
        Servico servico = Gerar.servico(new DataHora(0, 0), new DataHora(0, 0), "Arapao");
        agente.addServico(servico);
        Lista<Servico> expResult = new Lista<Servico>(
                Gerar.servico(new DataHora(7, 30), new DataHora(14, 30), "Caça e pesca"),
                Gerar.servico(new DataHora(10, 00), new DataHora(17, 0), "Tia"),
                Gerar.servico(new DataHora(0, 0), new DataHora(0, 0), "Arapao")
        );
        Lista<PM.Servico> result = agente.getServicos();
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of getEscala method, of class AgenteAntigo.
     */
    @Test
    public void testGetEscala(){
        System.out.println("getEscala");
        Tipo_de_escala expResult = Gerar.tipo_de_escala(4, 2);
        Tipo_de_escala result = agente.getEscala();
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionaServico method, of class AgenteAntigo.
     */
    @Test
    public void testAdicionaServico(){
        System.out.println("adicionaServico"); // verificar diferencas depois
        Servico servico = Gerar.servico(new DataHora(0, 0), new DataHora(0, 0), "Arapao");
        agente.addServico(servico);
        Lista<Servico> expResult = new Lista<Servico>(
                Gerar.servico(new DataHora(7, 30), new DataHora(14, 30), "Caça e pesca"),
                Gerar.servico(new DataHora(10, 00), new DataHora(17, 0), "Tia"),
                Gerar.servico(new DataHora(0, 0), new DataHora(0, 0), "Arapao")
        );
        Lista<Servico> result = agente.getServicos();
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of removeServico method, of class AgenteAntigo.
     */
    @Test
    public void testRemoveServico(){
        System.out.println("removeServico");
        agente.removeServico(Gerar.servico(new DataHora(10, 00), new DataHora(17, 0), "Tia"));
        Lista<Servico> expResult = new Lista<Servico>(
                Gerar.servico(new DataHora(7, 30), new DataHora(14, 30), "Caça e pesca")
        );
        Lista<Servico> result = agente.getServicos();
        System.out.println(agente.getServicos().toString());
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of getContato method, of class AgenteAntigo.
     */
    @Test
    public void testGetContato(){
        System.out.println("getContato");
        String expResult = "3333-3333";
        String result = agente.getContato();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class AgenteAntigo.
     */
    @Test
    public void testCompareTo(){
        System.out.println("compareTo");
        AgenteAntigo outroAgente = Gerar.agente("", Gerar.tipo_de_escala(4, 2), "neo", 0, new Lista<Servico>(), "01/01/2018");
        int expResult = 1;
        int result = agente.compareTo(outroAgente);
        assertEquals(expResult, result);
    }

    /**
     * Test of disponibilidadeDoHorario method, of class AgenteAntigo.
     */
    @Test
    public void testDisponibilidadeDoHorario(){
        System.out.println("disponibilidadeDoHorario");
        boolean expResult = true;
        boolean result = agente.disponibilidadeDoHorario(new DataHora(6, 30), new DataHora(6, 59));
        assertEquals(expResult, result);
        expResult = false;
        result = agente.disponibilidadeDoHorario(new DataHora(14, 01), new DataHora(15, 00));
        assertEquals(expResult, result);
    }
}
