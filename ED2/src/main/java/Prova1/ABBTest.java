package Prova1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ABBTest {

	private ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
	private ArvoreBinariaBuilder builder = new ArvoreBinariaBuilder();

	@Test
	void pegarNumeroDeParesVazia() {
		arvore = builder.montaArvoreVazia();

		assertEquals(0, arvore.pegarNumeroDePares());
	}

	@Test
	void pegarNumeroDePares() {
		arvore = builder.montaArvoreCheia();

		assertEquals(4, arvore.pegarNumeroDePares());
	}

	@Test
	void pegarNumeroDeParesDnv() {
		arvore = builder.montaArvoreCheia2();

		assertEquals(6, arvore.pegarNumeroDePares());
	}

	@Test
	void pegarMaiorVazia() {
		arvore = builder.montaArvoreVazia();

		assertEquals(0, arvore.pegarMaiorValor());
	}

	@Test
	void pegarMaior() {
		arvore = builder.montaArvoreCheia();

		assertEquals(79, arvore.pegarMaiorValor());
	}

	@Test
	void pegarMaiorDnv() {
		arvore = builder.montaArvoreCheia2();

		assertEquals(78, arvore.pegarMaiorValor());
	}

}
