package pilha;

import listaligada.ListaLigada;

public class Pilha {
	
	private ListaLigada lista = new ListaLigada();
	
	public void push(Object novoElemento) {
		lista.adicionarNoFinal(novoElemento);
	}
	
	public void pop() {
		lista.removerDoFinal();
	}
	
	public Object top() {  //peek
		return lista.pegarUltima();
	}
	
	public boolean contem(Object elemento) {
		return lista.contem(elemento);
	}
	
	public int pegarTamanho() {
		return lista.pegarTotalElementos();
	}
	
	public Object pegarPrimeiro() {
		return lista.pegarPrimeiro();
	}
}
