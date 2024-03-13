package contatos.ABB;

import contatos.Contato;

public class No {

	private Contato valor;
	private No direito;
	private No esquerdo;
	
	public No (Contato valor) {
		this.valor = valor;
		direito = null;
		esquerdo = null;
	}
	public No (Contato valor, No direito, No esquerdo) {
		this.valor = valor;
		this.esquerdo = esquerdo;
		this.direito = direito;
	}
	
	public Contato getValor() {
		return valor;
	}
	public void setValor(Contato valor) {
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
	public int getCodigoContato() {
		return getValor().getCodigo();
	}
	public String getNomeContato() {
		return getValor().getNome();
	}
}
