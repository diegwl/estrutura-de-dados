package ABB;
public class ABB {
	
	private No raiz;
	
	public ABB() {
		raiz = null;
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}
	
	public boolean ehVazia() {
		return (raiz==null);
	}
	
	public int pegaQuantidadeNosSubNo (No noReferencia) {
		
		if (noReferencia == null) {
			return 0;
		}
		else {
			return  pegaQuantidadeNosSubNo(noReferencia.getEsquerdo()) 
					+ 1 
					+ pegaQuantidadeNosSubNo(noReferencia.getDireito());
		}
	}
	
	public int pegaQuantidadeNos() {
		return pegaQuantidadeNosSubNo(raiz);
	}
	
	public int pegaAlturaNo(No noReferencia) {
		if (ehVazia()) {
			return 0;
		}
		else {
			return pegaAlturaSubNo(noReferencia) - 1;
		}
	}
	
	private int pegaAlturaSubNo(No noReferencia) {
		
		if (noReferencia == null) {
			return 0;
		}
		
		int alturaDireita = pegaAlturaSubNo(noReferencia.getDireito());
		int alturaEsquerda = pegaAlturaSubNo(noReferencia.getEsquerdo());
		
		return 1 + Math.max(alturaDireita, alturaEsquerda);
		
		
	}

	private int contaNosProfundidade(No noReferencia, No noAtual) {
		if (noReferencia == null || noReferencia == noAtual) {
			return 0;
		}

		if (noReferencia.getValor() <= noAtual.getValor()) {
			return 1 + contaNosProfundidade(noReferencia, noAtual.getEsquerdo());
		} else if (noReferencia.getValor() > noAtual.getValor()) {
			return 1 + contaNosProfundidade(noReferencia, noAtual.getDireito());
		}
		return 0;
	}
	
	public int pegaProfundidadeDoNo(No noReferencia) {
		if (noReferencia == null) {
			return 0;
		}

		No no = procuraNo(noReferencia.getValor(), raiz);

        return contaNosProfundidade(noReferencia, raiz);
	}

	private No procuraNo(int valor, No noReferencia) {
		if (valor == noReferencia.getValor()) {
			return noReferencia;
		} else if (valor <= noReferencia.getValor()) {
			return procuraNo(valor, noReferencia.getEsquerdo());
		} else if (valor > noReferencia.getValor()) {
			return procuraNo(valor, noReferencia.getDireito());
		}
		return null;
	}

	public No pegaNoArvorePorValor(int valor) {
        return procuraNo(valor, raiz);
	}

	public boolean contem(int valor) {
		No no = procuraNo(valor, raiz);
        return no != null;
    }

}
