package testes_AnalisadorCompilador;

import org.junit.Test;

public class teste_GrafoR {
	
	@Test public void testeCriacao() {
		Arvore arvore = ArvoreUtils.parseArvore("2+1-2.5*4/2-0.5");
		ArvoreUtils.simplifica(arvore);
		arvore.imprime();
	}
}
