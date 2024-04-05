package TabelaHash;

public class TabelaHash {
	
	private Cliente[] elementos;
	private ListaLigada[] colisoes;
	
	public TabelaHash(int tamanho) {
		
		elementos = new Cliente[tamanho];
		colisoes = new ListaLigada[tamanho];
		
		inicializarListaColisoes(tamanho);
		
	}

	private void inicializarListaColisoes(int tamanho) {
		
		for (int i=0; i<tamanho; i++) {
			colisoes[i] = new ListaLigada();
		}
	}

	public Cliente[] getElementos() {
		return elementos;
	}

	public void setElementos(Cliente[] elementos) {
		this.elementos = elementos;
	}

	public ListaLigada[] getColisoes() {
		return colisoes;
	}

	public void setColisoes(ListaLigada[] colisoes) {
		this.colisoes = colisoes;
	}

}
