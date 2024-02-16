package listaligada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaLigadaTest {
	
	ListaLigada lista;
	
	@BeforeEach
	void inicializaLista() {
		lista = new ListaLigada();
	}
	
	

	@Test
	void testAdicionarNoComecoVazia() {
		
		lista.adicionarNoComeco("Jose");
		
		assertFalse(lista.ehVazia());
		assertEquals(1, lista.pegaTotalElementos());
		
	}
	
	@Test
	void testAdicionarNoComecoComElementos() {
		
		
		lista.adicionarNoComeco("Jose");
		lista.adicionarNoComeco("Maria");
		lista.adicionarNoComeco("Antonio");
		
		assertFalse(lista.ehVazia());
		assertEquals(3, lista.pegaTotalElementos());
		assertEquals("Jose", lista.pegar(2));
		assertEquals("Maria", lista.pegar(1));
		assertEquals("Antonio", lista.pegar(0));
		
	}
	
	
	@Test
	void testAdicionarNoFinalVazia() {
		
		lista.adicionarNoFinal("Jose");
		
		assertFalse(lista.ehVazia());
		assertEquals(1, lista.pegaTotalElementos());
		
	}
	
	@Test
	void testAdicionarNoFinalComElementos() {
		
		
		lista.adicionarNoFinal("Jose");
		lista.adicionarNoFinal("Maria");
		lista.adicionarNoFinal("Antonio");
		
		assertFalse(lista.ehVazia());
		assertEquals(3, lista.pegaTotalElementos());
		assertEquals("Jose", lista.pegar(0));
		assertEquals("Maria", lista.pegar(1));
		assertEquals("Antonio", lista.pegar(2));
	}
	
	@Test
	void testContemListaVazia() {
		
		assertFalse(lista.contem("Jose"));
		
	}
	
	@Test
	void testContemComElementosNaoAchado() {
		
		
		lista.adicionarNoFinal("Jose");
		lista.adicionarNoFinal("Maria");
		lista.adicionarNoFinal("Antonio");
		
		assertFalse(lista.contem("Zeca"));
	}
	
	@Test
	void testContemComElementosAchado() {
		
		
		lista.adicionarNoFinal("Jose");
		lista.adicionarNoFinal("Maria");
		lista.adicionarNoFinal("Antonio");
		
		assertTrue(lista.contem("Maria"));
	}
	
	@Test
	void testPegarPosicaoValidaListaVazia() {
		
		assertThrows(IllegalArgumentException.class, ()->lista.pegar(2));
		
	}
	
	@Test
	void testPegarPosicaoInvalidaListaVazia() {
		
		assertThrows(IllegalArgumentException.class, ()->lista.pegar(-2));
		
	}
	
	@Test
	void testPegarPosicaoValidaComElementos() {
		
		lista.adicionarNoFinal("Jose");
		lista.adicionarNoFinal("Maria");
		lista.adicionarNoFinal("Antonio");
		
		assertEquals("Jose", lista.pegar(0));
		assertEquals("Maria", lista.pegar(1));
		assertEquals("Antonio", lista.pegar(2));
		
	}
	
	@Test
	void testPegarPosicaoInvalidaComElementos() {
		
		lista.adicionarNoFinal("Jose");
		lista.adicionarNoFinal("Maria");
		lista.adicionarNoFinal("Antonio");
		
		assertThrows(IllegalArgumentException.class, ()->lista.pegar(-2));
		assertThrows(IllegalArgumentException.class, ()->lista.pegar(5));
	
		
	}
	
	
	@Test
	void testAdicionarPosicaoZeroVazia() {
		
		lista.adicionarNaPosicao("Jose", 0);
		
		assertFalse(lista.ehVazia());
		assertEquals(1, lista.pegaTotalElementos());
		assertEquals("Jose", lista.pegar(0));
		
	}
	
	@Test
	void testAdicionarPosicaoZeroComElementos() {
		
		lista.adicionarNoComeco("Jose");
		
		lista.adicionarNaPosicao("Maria", 0);
		
		assertFalse(lista.ehVazia());
		assertEquals(2, lista.pegaTotalElementos());
		assertEquals("Maria", lista.pegar(0));
		assertEquals("Jose", lista.pegar(1));
		
	}
	
	
	@Test
	void testAdicionarPosicaoFinalComElementos() {
		
		lista.adicionarNoComeco("Jose");
		lista.adicionarNoComeco("Maria");
		
		lista.adicionarNaPosicao("Antonio", 2);
		
		assertFalse(lista.ehVazia());
		assertEquals(3, lista.pegaTotalElementos());
		assertEquals("Maria", lista.pegar(0));
		assertEquals("Jose", lista.pegar(1));
		assertEquals("Antonio", lista.pegar(2));
		
	}
	
	@Test
	void testAdicionarPosicaoMeioComElementos() {
		
		lista.adicionarNoComeco("Jose");
		lista.adicionarNoComeco("Maria");
		
		lista.adicionarNaPosicao("Antonio", 1);
		
		assertFalse(lista.ehVazia());
		assertEquals(3, lista.pegaTotalElementos());
		assertEquals("Maria", lista.pegar(0));
		assertEquals("Antonio", lista.pegar(1));
		assertEquals("Jose", lista.pegar(2));
		
		
	}
	
	@Test
	void testAdicionarPosicaoInvalidaComElementos() {
		
		lista.adicionarNoComeco("Jose");
		lista.adicionarNoComeco("Maria");
		
		assertThrows(IllegalArgumentException.class, ()->lista.adicionarNaPosicao("Xuxa", -2));
		assertThrows(IllegalArgumentException.class, ()->lista.adicionarNaPosicao("Xuxa", 5));
	
		
	}
	
	@Test
	void testAdicionarPosicaoInvalidaVazia() {
		
		assertThrows(IllegalArgumentException.class, ()->lista.adicionarNaPosicao("Xuxa", -2));
		assertThrows(IllegalArgumentException.class, ()->lista.adicionarNaPosicao("Xuxa", 5));
	
		
	}

	@Test
	void testRemoverNoComecoVazia() {

		assertTrue(lista.ehVazia());
		assertThrows(IllegalArgumentException.class, ()->lista.removerNoComeco());

	}

	@Test
	void testRemoverNoComecoComElementos() {

		lista.adicionarNoComeco("Jose");
		lista.adicionarNoComeco("Maria");
		lista.adicionarNoComeco("Antonio");

		assertFalse(lista.ehVazia());
		lista.removerNoComeco();
		assertEquals(2, lista.pegaTotalElementos());
		assertEquals("Jose", lista.pegar(1));
		assertEquals("Maria", lista.pegar(0));

	}

	@Test
	void testRemoverNoComecoComUmElemento() {

		lista.adicionarNoComeco("Jose");

		assertFalse(lista.ehVazia());
		lista.removerNoComeco();
		assertEquals(0, lista.pegaTotalElementos());

	}


	@Test
	void testRemoverNoFinalVazia() {

		assertTrue(lista.ehVazia());
		assertThrows(IllegalArgumentException.class, ()->lista.removerNoFinal());

	}

	@Test
	void testRemoverNoFinalComElementos() {

		lista.adicionarNoComeco("Jose");
		lista.adicionarNoComeco("Maria");
		lista.adicionarNoComeco("Antonio");

		assertFalse(lista.ehVazia());
		lista.removerNoFinal();

		assertEquals(2, lista.pegaTotalElementos());
		assertEquals("Antonio", lista.pegar(0));
		assertEquals("Maria", lista.pegar(1));
	}

	@Test
	void testRemoverNoFinalComUmElemento() {

		lista.adicionarNoComeco("Jose");

		assertFalse(lista.ehVazia());
		lista.removerNoFinal();
		assertEquals(0, lista.pegaTotalElementos());

	}

	@Test
	void testRemoverPosicaoZeroComElementos() {

		lista.adicionarNoComeco("Jose");
		lista.adicionarNaPosicao("Maria", 0);

		lista.removerNaPosicao(0);

		assertEquals(1, lista.pegaTotalElementos());
		assertEquals("Jose", lista.pegar(0));
		assertThrows(IllegalArgumentException.class, ()->lista.pegar(1));

	}


	@Test
	void testRemoverPosicaoFinalComElementos() {

		lista.adicionarNoComeco("Jose");
		lista.adicionarNaPosicao("Maria", 0);

		lista.removerNaPosicao(1);

		assertEquals(1, lista.pegaTotalElementos());
		assertEquals("Maria", lista.pegar(0));
		assertThrows(IllegalArgumentException.class, ()->lista.pegar(1));

	}

	@Test
	void testRemoverPosicaoMeioComElementos() {

		lista.adicionarNoComeco("Jose");
		lista.adicionarNoComeco("Maria");
		lista.adicionarNaPosicao("Antonio", 1);

		lista.removerNaPosicao(1);

		assertFalse(lista.ehVazia());
		assertEquals(2, lista.pegaTotalElementos());
		assertEquals("Maria", lista.pegar(0));
		assertEquals("Jose", lista.pegar(1));
		assertThrows(IllegalArgumentException.class, ()->lista.pegar(2));


	}

	@Test
	void testRemoverPosicaoInvalidaComElementos() {

		lista.adicionarNoComeco("Jose");
		lista.adicionarNoComeco("Maria");

		assertThrows(IllegalArgumentException.class, ()->lista.removerNaPosicao(-2));
		assertThrows(IllegalArgumentException.class, ()->lista.removerNaPosicao(5));


	}

	@Test
	void testRemoverPosicaoInvalidaVazia() {

		assertThrows(IllegalArgumentException.class, ()->lista.removerNaPosicao(-2));
		assertThrows(IllegalArgumentException.class, ()->lista.removerNaPosicao(5));


	}

}
