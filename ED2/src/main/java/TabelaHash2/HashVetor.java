package TabelaHash2;
public class HashVetor {

	private int tamanho;
	private TabelaHash tabelaHash;
	public int registrosTotais;

	public HashVetor(int tamanho) {

		if (tamanho <= 0) {
			throw new IllegalArgumentException("Tamanho Inválido.");
		}
		this.tamanho = tamanho;
		tabelaHash = new TabelaHash(tamanho);
		this.registrosTotais = 0;
	}

	private int calcularHash(int chave) {

		String chaveConvertida = String.valueOf(chave);
		int h = 0;
		for (int i = 0; i < chaveConvertida.length(); i++) {
			h = 31 * h + chaveConvertida.charAt(i);
		}
		return h % tamanho;
	}

	public int adicionar(Cliente novoCliente) {

		int enderecoAdicionado = calcularHash(novoCliente.getCodigo());

		tabelaHash.getElementos()[enderecoAdicionado].adicionarNoFinal(novoCliente);

		registrosTotais++;

		return enderecoAdicionado;

	}
	
	public Cliente buscarClienteCodigo(int codigoBuscado) {
		
		int enderecoBuscado = calcularHash(codigoBuscado);
		
		if (tabelaHash.getElementos()[enderecoBuscado] != null) {
			int tamanhoLista = tabelaHash.getElementos()[enderecoBuscado].pegarTotalElementos();
			if (tamanhoLista != 0) {
				for (int i=0; i<tamanhoLista; i++) {
					Cliente cliente = (Cliente) tabelaHash.getElementos()[enderecoBuscado].pegar(i);
					if (cliente.getCodigo() == codigoBuscado) {
						return cliente;
					}
				}
			}
		}
	
		return null;
		
	}

	private Cliente removerClienteCodigo(int codigoBuscado) {

		int enderecoBuscado = calcularHash(codigoBuscado);

		if (tabelaHash.getElementos()[enderecoBuscado] != null) {
			int tamanhoLista = tabelaHash.getElementos()[enderecoBuscado].pegarTotalElementos();
			if (tamanhoLista != 0) {
				for (int i = 0; i < tamanhoLista; i++) {
					Cliente cliente = (Cliente) tabelaHash.getElementos()[enderecoBuscado].pegar(i);
					if (cliente.getCodigo() == codigoBuscado) {
						tabelaHash.getElementos()[enderecoBuscado].removerNaPosicao(i);
						registrosTotais--;
						return cliente;
					}
				}
			}
		}

		return null;
	}

	public Cliente remover(Cliente cliente) {
		return removerClienteCodigo(cliente.getCodigo());
	}

	public boolean contem(Cliente cliente) {
		Cliente clienteEncontrado = buscarClienteCodigo(cliente.getCodigo());
		return clienteEncontrado != null;
	}

	public double tamanhoMedioPesquisa() {
		double media = 0;
		int tamanhoPesquisaTotal = 0;

		for (int i = 0; i < tamanho; i++) {
			int tamanhoLista = tabelaHash.getElementos()[i].pegarTotalElementos();
			if (tamanhoLista != 0) {
				for (int j = 0; j < tamanhoLista; j++) {
					tamanhoPesquisaTotal = tamanhoPesquisaTotal + (j + 1);
				}
			}
		}
		media = (double) tamanhoPesquisaTotal / registrosTotais;
		return media;
	}

}
