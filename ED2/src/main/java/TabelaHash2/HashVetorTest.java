package TabelaHash2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashVetorTest {
	
	private HashVetor tabelaHash;

	@BeforeEach
	void inicializar() {
		tabelaHash = new HashVetor(10);
	}
	
	@Test
	void testCriarTabelaTamanhoZeroNegativo() {
		assertThrows(IllegalArgumentException.class, ()-> new HashVetor(0));
		assertThrows(IllegalArgumentException.class, ()-> new HashVetor(-10));
	}
	
	@Test
	void testAdicionarClienteSemColisao() {
		
		Cliente c1 = new Cliente(22, "Fernando", "Rua das Coves, 23");
		Cliente c2 = new Cliente(7, "Maria", "Rua 15 de Novembro, 200");
		
		assertEquals(0, tabelaHash.adicionar(c1));
		assertEquals(5, tabelaHash.adicionar(c2));
		
		assertEquals(22, tabelaHash.buscarClienteCodigo(22).getCodigo());
		assertEquals(7, tabelaHash.buscarClienteCodigo(7).getCodigo());
		
	}
	
	@Test
	void testAdicionarClienteComColisao() {
		
		Cliente c1 = new Cliente(22, "Fernando", "Rua das Coves, 23");
		Cliente c2 = new Cliente(7, "Maria", "Rua 15 de Novembro, 200");		
		Cliente c3 = new Cliente(3645, "Andre", "Rua 10, 230");
		Cliente c4 = new Cliente(511, "Rose", "Rua Das Flores, 2000");
		Cliente c5 = new Cliente(123, "Paulo", "Rua Monte Sinai, 253");
		
		
		assertEquals(0, tabelaHash.adicionar(c1));
		assertEquals(5, tabelaHash.adicionar(c2));
		assertEquals(0, tabelaHash.adicionar(c3));
		assertEquals(1, tabelaHash.adicionar(c4));
		assertEquals(0, tabelaHash.adicionar(c5));
	
		
		assertEquals(22, tabelaHash.buscarClienteCodigo(22).getCodigo());
		assertEquals(7, tabelaHash.buscarClienteCodigo(7).getCodigo());
		assertEquals(3645, tabelaHash.buscarClienteCodigo(3645).getCodigo());
		assertEquals(511, tabelaHash.buscarClienteCodigo(511).getCodigo());
		assertEquals(123, tabelaHash.buscarClienteCodigo(123).getCodigo());
		
		
	}

	@Test
	void testRemoverClienteSemColisao() {

		Cliente c1 = new Cliente(22, "Fernando", "Rua das Coves, 23");
		Cliente c2 = new Cliente(7, "Maria", "Rua 15 de Novembro, 200");

		assertEquals(0, tabelaHash.adicionar(c1));
		assertEquals(5, tabelaHash.adicionar(c2));

		assertEquals(22, tabelaHash.buscarClienteCodigo(22).getCodigo());
		assertEquals(7, tabelaHash.buscarClienteCodigo(7).getCodigo());

		tabelaHash.remover(c1);
		tabelaHash.remover(c2);

		assertNull(tabelaHash.buscarClienteCodigo(22));
		assertNull(tabelaHash.buscarClienteCodigo(7));
	}

	@Test
	void testRemoverClienteComColisao() {

		Cliente c1 = new Cliente(22, "Fernando", "Rua das Coves, 23");
		Cliente c2 = new Cliente(7, "Maria", "Rua 15 de Novembro, 200");
		Cliente c3 = new Cliente(3645, "Andre", "Rua 10, 230");
		Cliente c4 = new Cliente(511, "Rose", "Rua Das Flores, 2000");
		Cliente c5 = new Cliente(123, "Paulo", "Rua Monte Sinai, 253");


		assertEquals(0, tabelaHash.adicionar(c1));
		assertEquals(5, tabelaHash.adicionar(c2));
		assertEquals(0, tabelaHash.adicionar(c3));
		assertEquals(1, tabelaHash.adicionar(c4));
		assertEquals(0, tabelaHash.adicionar(c5));


		assertEquals(22, tabelaHash.buscarClienteCodigo(22).getCodigo());
		assertEquals(7, tabelaHash.buscarClienteCodigo(7).getCodigo());
		assertEquals(3645, tabelaHash.buscarClienteCodigo(3645).getCodigo());
		assertEquals(511, tabelaHash.buscarClienteCodigo(511).getCodigo());
		assertEquals(123, tabelaHash.buscarClienteCodigo(123).getCodigo());

		tabelaHash.remover(c1);
		tabelaHash.remover(c2);
		tabelaHash.remover(c5);

		assertNull(tabelaHash.buscarClienteCodigo(22));
		assertNull(tabelaHash.buscarClienteCodigo(7));
		assertNull(tabelaHash.buscarClienteCodigo(123));
		assertEquals(3645, tabelaHash.buscarClienteCodigo(3645).getCodigo());
		assertEquals(511, tabelaHash.buscarClienteCodigo(511).getCodigo());
	}

	@Test
	void testContemClienteSemColisao() {

		Cliente c1 = new Cliente(22, "Fernando", "Rua das Coves, 23");
		Cliente c2 = new Cliente(7, "Maria", "Rua 15 de Novembro, 200");

		assertEquals(0, tabelaHash.adicionar(c1));
		assertEquals(5, tabelaHash.adicionar(c2));

		assertEquals(22, tabelaHash.buscarClienteCodigo(22).getCodigo());
		assertEquals(7, tabelaHash.buscarClienteCodigo(7).getCodigo());

		assertTrue(tabelaHash.contem(c1));
		assertTrue(tabelaHash.contem(c2));
	}

	@Test
	void testContemClienteComColisao() {

		Cliente c1 = new Cliente(22, "Fernando", "Rua das Coves, 23");
		Cliente c2 = new Cliente(7, "Maria", "Rua 15 de Novembro, 200");
		Cliente c3 = new Cliente(3645, "Andre", "Rua 10, 230");
		Cliente c4 = new Cliente(511, "Rose", "Rua Das Flores, 2000");
		Cliente c5 = new Cliente(123, "Paulo", "Rua Monte Sinai, 253");


		assertEquals(0, tabelaHash.adicionar(c1));
		assertEquals(5, tabelaHash.adicionar(c2));
		assertEquals(0, tabelaHash.adicionar(c3));
		assertEquals(1, tabelaHash.adicionar(c4));


		assertEquals(22, tabelaHash.buscarClienteCodigo(22).getCodigo());
		assertEquals(7, tabelaHash.buscarClienteCodigo(7).getCodigo());
		assertEquals(3645, tabelaHash.buscarClienteCodigo(3645).getCodigo());
		assertEquals(511, tabelaHash.buscarClienteCodigo(511).getCodigo());

		assertTrue(tabelaHash.contem(c1));
		assertFalse(tabelaHash.contem(c5));
	}

	@Test
	void testMediaPesquisaSemColisao() {

		Cliente c1 = new Cliente(22, "Fernando", "Rua das Coves, 23");
		Cliente c2 = new Cliente(7, "Maria", "Rua 15 de Novembro, 200");

		assertEquals(0, tabelaHash.adicionar(c1));
		assertEquals(5, tabelaHash.adicionar(c2));

		assertEquals(22, tabelaHash.buscarClienteCodigo(22).getCodigo());
		assertEquals(7, tabelaHash.buscarClienteCodigo(7).getCodigo());

		assertEquals(1.0, tabelaHash.tamanhoMedioPesquisa());
	}

	@Test
	void tesMediaPesquisaComColisao() {

		Cliente c1 = new Cliente(22, "Fernando", "Rua das Coves, 23");
		Cliente c2 = new Cliente(7, "Maria", "Rua 15 de Novembro, 200");
		Cliente c3 = new Cliente(3645, "Andre", "Rua 10, 230");
		Cliente c4 = new Cliente(511, "Rose", "Rua Das Flores, 2000");
		Cliente c5 = new Cliente(123, "Paulo", "Rua Monte Sinai, 253");


		assertEquals(0, tabelaHash.adicionar(c1));
		assertEquals(5, tabelaHash.adicionar(c2));
		assertEquals(0, tabelaHash.adicionar(c3));
		assertEquals(1, tabelaHash.adicionar(c4));
		assertEquals(0, tabelaHash.adicionar(c5));


		assertEquals(22, tabelaHash.buscarClienteCodigo(22).getCodigo());
		assertEquals(7, tabelaHash.buscarClienteCodigo(7).getCodigo());
		assertEquals(3645, tabelaHash.buscarClienteCodigo(3645).getCodigo());
		assertEquals(511, tabelaHash.buscarClienteCodigo(511).getCodigo());
		assertEquals(123, tabelaHash.buscarClienteCodigo(123).getCodigo());

		assertEquals(1.6, tabelaHash.tamanhoMedioPesquisa());
	}

}
