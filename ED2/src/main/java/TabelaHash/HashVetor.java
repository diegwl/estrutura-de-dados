package TabelaHash;

public class HashVetor {

	private int tamanho;
	private TabelaHash tabelaHash;

	public HashVetor(int tamanho) {

		if (tamanho <= 0) {
			throw new IllegalArgumentException("Tamanho Inválido.");
		}
		this.tamanho = tamanho;
		tabelaHash = new TabelaHash(tamanho);
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

		if (tabelaHash.getElementos()[enderecoAdicionado] != null) {
			tabelaHash.getColisoes()[enderecoAdicionado].adicionarNoFinal(novoCliente);
		} else {
			tabelaHash.getElementos()[enderecoAdicionado] = novoCliente;
		}

		return enderecoAdicionado;

	}
	
	public Cliente buscarClienteCodigo(int codigoBuscado) {
		
		int enderecoBuscado = calcularHash(codigoBuscado);
		
		if (tabelaHash.getElementos()[enderecoBuscado] != null) {
			if (tabelaHash.getElementos()[enderecoBuscado].getCodigo() == codigoBuscado) {
				return tabelaHash.getElementos()[enderecoBuscado];
			}
			else {
				int tamanhoListaColisao = tabelaHash.getColisoes()[enderecoBuscado].pegarTotalElementos();
				if (tamanhoListaColisao != 0) {
					for (int i=0; i<tamanhoListaColisao; i++) {
						Cliente clienteColisao = (Cliente) tabelaHash.getColisoes()[enderecoBuscado].pegar(i);
						if (clienteColisao.getCodigo() == codigoBuscado) {
							return clienteColisao;
						}
					}
				}
			}
			
		}
	
		return null;
		
	}

	public Cliente removerClienteCodigo(int codigoBuscado) {
		int enderecoBuscado = calcularHash(codigoBuscado);

		if (tabelaHash.getElementos()[enderecoBuscado] != null) {
			if (tabelaHash.getElementos()[enderecoBuscado].getCodigo() == codigoBuscado) {
				var cliente = tabelaHash.getElementos()[enderecoBuscado];

				if (tabelaHash.getColisoes()[enderecoBuscado].pegarTotalElementos() != 0) {
					tabelaHash.getElementos()[enderecoBuscado] = (Cliente) tabelaHash.getColisoes()[enderecoBuscado].pegar(0);
					tabelaHash.getColisoes()[enderecoBuscado].removerDoComeco();
				} else {
					tabelaHash.getElementos()[enderecoBuscado] = null;
				}
				return cliente;
			}
			else {
				int tamanhoListaColisao = tabelaHash.getColisoes()[enderecoBuscado].pegarTotalElementos();
				if (tamanhoListaColisao != 0) {
					for (int i=0; i<tamanhoListaColisao; i++) {
						Cliente clienteColisao = (Cliente) tabelaHash.getColisoes()[enderecoBuscado].pegar(i);
						if (clienteColisao.getCodigo() == codigoBuscado) {
							tabelaHash.getColisoes()[enderecoBuscado].removerNaPosicao(i);
							return clienteColisao;
						}
					}
				}
			}
		}

		return null;
	}

}
