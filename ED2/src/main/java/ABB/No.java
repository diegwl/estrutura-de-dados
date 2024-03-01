package ABB;

public class No {

	private int valor;
	private No direito;
	private No esquerdo;
	
	public No (int valor) {
		this.valor = valor;
		direito = null;
		esquerdo = null;
	}
	public No (int valor, No direito, No esquerdo) {
		this.valor = valor;
		this.esquerdo = esquerdo;
		this.direito = direito;
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public No getDireito() {
		return direito;
	}
	public void setDireito(No direito) {
		this.direito = direito;
	}
	public No getEsquerdo() {
		return esquerdo;
	}
	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}
	public boolean ehFolha() {
		return (esquerdo==null && direito==null);
	}
	
	
	
}
