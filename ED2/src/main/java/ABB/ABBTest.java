package ABB;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ABBTest {

	@Test
	void pegaQuantidadeNosSubNoNulo() {
		
		ABB arvore = new ABB();
		assertEquals(0, arvore.pegaQuantidadeNosSubNo(null));
	}
	
	@Test
	void pegaQuantidadeNosSubNoComValor() {
		
		ABB arvore = new ABB();
		
		No no10 = new No(10);
		arvore.setRaiz(no10);
		assertEquals(1, arvore.pegaQuantidadeNosSubNo(no10));
		
		No no17 = new No(17);
		No no3 = new No(3);
		
		no10.setEsquerdo(no3);
		no10.setDireito(no17);
		assertEquals(3, arvore.pegaQuantidadeNosSubNo(no10));
		assertEquals(1, arvore.pegaQuantidadeNosSubNo(no3));
		assertEquals(1, arvore.pegaQuantidadeNosSubNo(no17));
		
		No no12 = new No(12);
		No no18 = new No(18);
		no17.setEsquerdo(no12);
		no17.setDireito(no18);
		
		No no40 = new No(40);
		no18.setDireito(no40);
		
		assertEquals(6, arvore.pegaQuantidadeNosSubNo(no10));
		assertEquals(1, arvore.pegaQuantidadeNosSubNo(no3));
		assertEquals(4, arvore.pegaQuantidadeNosSubNo(no17));
		assertEquals(1, arvore.pegaQuantidadeNosSubNo(no12));
		assertEquals(2, arvore.pegaQuantidadeNosSubNo(no18));
		assertEquals(1, arvore.pegaQuantidadeNosSubNo(no40));
	
	}
	
	@Test
	void pegaAlturaNoNuloArvoreVazia() {
		
		ABB arvore = new ABB();
		assertEquals(0, arvore.pegaAlturaNo(null));
	}
	
	@Test
	void pegaAlturaNoComValor() {
		
		ABB arvore = new ABB();
		
		No no10 = new No(10);
		arvore.setRaiz(no10);
		assertEquals(0, arvore.pegaAlturaNo(no10));
		
		No no17 = new No(17);
		No no3 = new No(3);
		
		no10.setEsquerdo(no3);
		no10.setDireito(no17);
		assertEquals(1, arvore.pegaAlturaNo(no10));
		assertEquals(0, arvore.pegaAlturaNo(no3));
		assertEquals(0, arvore.pegaAlturaNo(no17));
		
		No no12 = new No(12);
		No no18 = new No(18);
		no17.setEsquerdo(no12);
		no17.setDireito(no18);
		
		No no40 = new No(40);
		no18.setDireito(no40);
		
		assertEquals(3, arvore.pegaAlturaNo(no10));
		assertEquals(0, arvore.pegaAlturaNo(no3));
		assertEquals(2, arvore.pegaAlturaNo(no17));
		assertEquals(0, arvore.pegaAlturaNo(no12));
		assertEquals(1, arvore.pegaAlturaNo(no18));
		assertEquals(0, arvore.pegaAlturaNo(no40));
	
	}

	@Test
	void pegaProfundidadeNoNuloArvoreVazia() {

		ABB arvore = new ABB();
		assertEquals(0, arvore.pegaProfundidadeDoNo(null));
	}

	@Test
	void pegaProfundidadeNoComValor() {

		ABB arvore = new ABB();

		No no10 = new No(10);
		arvore.setRaiz(no10);
		assertEquals(0, arvore.pegaProfundidadeDoNo(no10));

		No no17 = new No(17);
		No no3 = new No(3);

		no10.setEsquerdo(no3);
		no10.setDireito(no17);
		assertEquals(0, arvore.pegaProfundidadeDoNo(no10));
		assertEquals(1, arvore.pegaProfundidadeDoNo(no3));
		assertEquals(1, arvore.pegaProfundidadeDoNo(no17));

		No no12 = new No(12);
		No no18 = new No(18);
		no17.setEsquerdo(no12);
		no17.setDireito(no18);

		No no40 = new No(40);
		no18.setDireito(no40);

		assertEquals(0, arvore.pegaProfundidadeDoNo(no10));
		assertEquals(1, arvore.pegaProfundidadeDoNo(no3));
		assertEquals(1, arvore.pegaProfundidadeDoNo(no17));
		assertEquals(2, arvore.pegaProfundidadeDoNo(no12));
		assertEquals(2, arvore.pegaProfundidadeDoNo(no18));
		assertEquals(3, arvore.pegaProfundidadeDoNo(no40));

	}

	@Test
	void pegaNoNulo() {

		ABB arvore = new ABB();

		assertNull(arvore.pegaNoArvorePorValor(10));

		No no10 = new No(10);
		arvore.setRaiz(no10);

		assertNull(arvore.pegaNoArvorePorValor(12));
	}

	@Test
	void pegaNoPorValor() {

		ABB arvore = new ABB();

		No no10 = new No(10);
		arvore.setRaiz(no10);
		assertEquals(no10, arvore.pegaNoArvorePorValor(10));

		No no17 = new No(17);
		No no3 = new No(3);

		no10.setEsquerdo(no3);
		no10.setDireito(no17);
		assertEquals(no10, arvore.pegaNoArvorePorValor(10));
		assertEquals(no3, arvore.pegaNoArvorePorValor(3));
		assertEquals(no17, arvore.pegaNoArvorePorValor(17));

		No no12 = new No(12);
		No no18 = new No(18);
		no17.setEsquerdo(no12);
		no17.setDireito(no18);

		No no40 = new No(40);
		no18.setDireito(no40);

		assertEquals(no12, arvore.pegaNoArvorePorValor(12));
		assertEquals(no18, arvore.pegaNoArvorePorValor(18));
		assertEquals(no40, arvore.pegaNoArvorePorValor(40));

	}

	@Test
	void contemValor() {

		ABB arvore = new ABB();

		No no10 = new No(10);
		arvore.setRaiz(no10);
		assertTrue(arvore.contem(10));

		No no17 = new No(17);
		No no3 = new No(3);

		no10.setEsquerdo(no3);
		no10.setDireito(no17);

		assertTrue(arvore.contem(3));
		assertTrue(arvore.contem(17));

		assertFalse(arvore.contem(300));
	}

}
