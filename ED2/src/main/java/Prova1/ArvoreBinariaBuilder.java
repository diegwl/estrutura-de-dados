package Prova1;

public class ArvoreBinariaBuilder {
	
	private ArvoreBinariaBusca arvore;
		
	public ArvoreBinariaBusca montaArvoreVazia() {
		this.arvore = new ArvoreBinariaBusca();
		return arvore;
	}

	public ArvoreBinariaBusca montaArvoreCheia() {
		this.arvore = new ArvoreBinariaBusca();
		arvore.adicionaNo(37);
		arvore.adicionaNo(56);
		arvore.adicionaNo(12);
		arvore.adicionaNo(49);
		arvore.adicionaNo(23);
		arvore.adicionaNo(79);
		arvore.adicionaNo(20);
		arvore.adicionaNo(11);
		arvore.adicionaNo(13);
		arvore.adicionaNo(6);
		arvore.adicionaNo(7);
		arvore.adicionaNo(3);
		return arvore;
	}
	
	public ArvoreBinariaBusca montaArvoreCheia2() {
		
		this.arvore = new ArvoreBinariaBusca();
		arvore.adicionaNo(25);
		arvore.adicionaNo(36);
		arvore.adicionaNo(40);
		arvore.adicionaNo(53);
		arvore.adicionaNo(78);
		arvore.adicionaNo(5);
		arvore.adicionaNo(22);
		arvore.adicionaNo(73);
		arvore.adicionaNo(10);
		arvore.adicionaNo(6);
		arvore.adicionaNo(7);
		arvore.adicionaNo(3);
		return arvore;
		
		
	}

}
