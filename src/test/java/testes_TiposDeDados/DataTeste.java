package testes_TiposDeDados;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import TiposDeDados.Data;

public class DataTeste {
	@Test public void test() {	
		Data d = new Data(15,5,2018);
		assertEquals(20, d.semana());
	}
}
