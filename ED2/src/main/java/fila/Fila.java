package fila;

import listaligada.ListaLigada;

public class Fila  {
	
	private ListaLigada lista = new ListaLigada();
	
	public void adicionar(Object elemento) {
		lista.adicionarNoFinal(elemento);
	}
	
	public void remover() {
		lista.removerNoComeco();
	}
	
	public boolean ehVazia() {
		return lista.ehVazia();
	}
	
	public Object poll() {
		
		if (ehVazia()) {
			return null;
		}
		else {
			Object primeiro = lista.pegar(0);
			lista.removerNoComeco();
			return primeiro;
		}
	}
	
	public boolean contem(Object elemento) {
		return lista.contem(elemento);
	}
	
	public Object pegaPrimeiro() {
		return lista.pegar(0);
	}
	
	public Object pegaUltimo() {
		return lista.pegar(pegarTamanho() - 1);
	}

	public Object pegaPosicao(int posicao) {
		return lista.pegar(posicao);
	}
	
	public int pegarTamanho() {
		return lista.pegaTotalElementos();
	}

	public Object pollPosicao(int posicao) {
		Object removido = lista.pegar(posicao);
		lista.removerNaPosicao(posicao);
		return removido;
	}

}
