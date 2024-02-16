package listaligada;

public class ListaLigada {
	
	private static final String ERRO_POSICAO_INVALIDA_PARA_INSERIR = "Posicao Invalida para Inserir";
	private static final String ERRO_POSICAO_INVALIDA_RECUPERAR = "Posicao invalida";
	private static final String ERRO_REMOVER_VAZIA = "Lista Vazia, não há o que remover";
	
	private Celula primeiraCelula;
	private Celula ultimaCelula;
	int totalDeElementos = 0;
	
	public boolean ehVazia() {
		return(primeiraCelula == null);
	}
	
	public int pegaTotalElementos() {
		return totalDeElementos;
	}
	
	public void adicionarNoComeco(Object novoIdentificador) {
		
		Celula nova;
		
		if (ehVazia()) {
			nova = new Celula(novoIdentificador);
			ultimaCelula = nova;
		}
		else {
			nova = new Celula(novoIdentificador, primeiraCelula);
			primeiraCelula.setAnterior(nova);
		}
		primeiraCelula = nova;
		totalDeElementos++;
	}
	
	public void adicionarNoFinal(Object novoIdentificador) {
		
		if (ehVazia()) {
			adicionarNoComeco(novoIdentificador);
		}
		else {
			Celula nova = new Celula(novoIdentificador);
			ultimaCelula.setProximo(nova);
			nova.setAnterior(ultimaCelula);
			ultimaCelula = nova;
			totalDeElementos++;
		}
	}
	
	public boolean contem(Object elementoBuscado) {
		
		Celula atual = primeiraCelula;
		
		while (atual != null) {
			
			if (atual.getElemento().equals(elementoBuscado)) {
				return true;
			}
			atual = atual.getProximo();
			
		}
		
		return false;
	}
	
	private boolean validarPosicaoRecuperacao(int posicao) {
		return (posicao >=0 && posicao < totalDeElementos);
	}
	
	private Celula pegarCelula (int posicao) {
		
		if (!validarPosicaoRecuperacao(posicao)) {
			throw new IllegalArgumentException(ERRO_POSICAO_INVALIDA_RECUPERAR);
		}
		
		Celula atual = primeiraCelula;
		
		for (int i=0; i < posicao; i++) {
			atual = atual.getProximo();
		}
		
		return atual;
		
	}
	
	
	public Object pegar (int posicao) {
		
		return pegarCelula(posicao).getElemento();
	}
	
	
	private boolean validarPosicaoInserir(int posicao) {
		return (posicao >=0 && posicao <= totalDeElementos);
	}
	
	public void adicionarNaPosicao(Object novoElemento, int posicao) {
		
		
		if (!validarPosicaoInserir(posicao)) {
			throw new IllegalArgumentException(ERRO_POSICAO_INVALIDA_PARA_INSERIR);

		}
		
		if (posicao == 0) {
			adicionarNoComeco(novoElemento);
		}
		else if (posicao == totalDeElementos) {
			adicionarNoFinal(novoElemento);
		}
		else {
			
			Celula anterior = pegarCelula(posicao - 1);
			Celula proximo = anterior.getProximo();
			
			Celula nova = new Celula(novoElemento, proximo);
			proximo.setAnterior(nova);
			
			anterior.setProximo(nova);
			nova.setAnterior(anterior);
			
			totalDeElementos++;

		}
	
	}

	public void removerNoComeco() {
		if (ehVazia()) {
			throw new IllegalArgumentException(ERRO_REMOVER_VAZIA);
		} else {
			Celula celulaRemovida = primeiraCelula;
			primeiraCelula = primeiraCelula.getProximo();
			celulaRemovida.setProximo(null);
			totalDeElementos--;
		}
	}

	public void removerNoFinal() {
		if (ehVazia()) {
			throw new IllegalArgumentException(ERRO_REMOVER_VAZIA);
		} else if (totalDeElementos == 1) {
			removerNoComeco();
		} else {
			Celula celulaRemovida = ultimaCelula;
			ultimaCelula = ultimaCelula.getAnterior();
			celulaRemovida.setAnterior(null);
			totalDeElementos--;
		}
	}

	public void removerNaPosicao(int posicao) {
		if (!validarPosicaoRecuperacao(posicao)) {
			throw new IllegalArgumentException(ERRO_POSICAO_INVALIDA_RECUPERAR);
		}

		if (posicao == 0) {
			removerNoComeco();
		} else if (posicao == totalDeElementos - 1) {
			removerNoFinal();
		} else {
			Celula removido = pegarCelula(posicao);
			Celula anterior = removido.getAnterior();
			Celula proximo = removido.getProximo();

			removido.setAnterior(null);
			removido.setProximo(null);

			anterior.setProximo(proximo);
			proximo.setAnterior(anterior);
			totalDeElementos--;
		}
	}
	
}
