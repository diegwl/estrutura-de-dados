package TabelaHash2;

public class TabelaHash {

	private ListaLigada[] elementos;
	
	public TabelaHash(int tamanho) {

		elementos = new ListaLigada[tamanho];
		
		inicializarListaElementos(tamanho);
		
	}

	private void inicializarListaElementos(int tamanho) {
		
		for (int i=0; i<tamanho; i++) {
			elementos[i] = new ListaLigada();
		}
	}

	public ListaLigada[] getElementos() {
		return elementos;
	}

	public void setElementos(ListaLigada[] elementos) {
		this.elementos = elementos;
	}

}
