package pilha;

import listaligada.ListaLigada;

public class Pilha {
	
	private ListaLigada lista = new ListaLigada();
	
	public void push(Object novoElemento) {
		lista.adicionarNoFinal(novoElemento);
	}
	
	public void pop() {
		lista.removerNoFinal();
	}
	
	public Object top() {  //peek
		return lista.pegar(pegarTamanho() - 1);
	}
	
	public boolean contem(Object elemento) {
		return lista.contem(elemento);
	}
	
	public int pegarTamanho() {
		return lista.pegaTotalElementos();
	}
	
	public Object pegarPrimeiro() {
		return lista.pegar(0);
	}
}
