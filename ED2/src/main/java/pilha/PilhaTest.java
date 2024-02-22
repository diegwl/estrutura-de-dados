package pilha;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PilhaTest {
	
	Pilha pilha;
	
	@BeforeEach
	void inicializaPilha() {
		pilha = new Pilha();
	}

	@Test
	void adicionarPilhaVazia() {
		
		pilha.push("fernando");
		
		assertEquals(1, pilha.pegarTamanho());
		assertEquals("fernando", pilha.top());
		assertEquals("fernando", pilha.pegarPrimeiro());
		assertTrue(pilha.contem("fernando"));
	}
	
	@Test
	void adicionarPilhaComElementos() {
		
		pilha.push("fernando");
		pilha.push("maria");
		pilha.push("dede");
		
		assertEquals(3, pilha.pegarTamanho());
		assertTrue(pilha.contem("fernando"));
		assertTrue(pilha.contem("maria"));
		assertTrue(pilha.contem("dede"));
		assertEquals("dede", pilha.top());
		assertEquals("fernando", pilha.pegarPrimeiro());
		
	}

}





