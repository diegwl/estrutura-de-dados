package Sort.Selection_Insertion_Bubble;

public class Ordenacao {

	public static void main(String[] args) {
		
		Pessoa[] pessoas = {
				new Pessoa("Joao", 5000),
				new Pessoa("Carlos", 1200),
				new Pessoa("Chico", 10000),
				new Pessoa("Neuza", 1300),
				new Pessoa("Bruno", 2),		
		};
		
		//selectionSort(pessoas, 5);
		//bubbleSort(pessoas, 5);
		insertionSort(pessoas, 5);
		
		for (int i=0; i<pessoas.length; i++) {
			System.out.println(pessoas[i].getNome() + " - " + pessoas[i].getSalario());
		}
		
	}

	
	private static void insertionSort(Pessoa[] pessoas, int quantidadeElementos){
		
		for (int posicaoAtual=1; posicaoAtual<quantidadeElementos; posicaoAtual++) {
			int posAnalise = posicaoAtual;
			while(posAnalise > 0 && pessoas[posAnalise].getSalario() < pessoas[posAnalise-1].getSalario()) {
				trocar(pessoas, posAnalise, posAnalise - 1);
				posAnalise--;
			}
		}

	}
	
	
	private static void bubbleSort(Pessoa[] pessoas, int quantidadeElementos) {
		
		for (int i=0; i<quantidadeElementos-1; i++) {
			for (int j=0; j<quantidadeElementos-1-i; j++) {
				if (pessoas[j].getSalario() > pessoas[j+1].getSalario() ) {
					trocar(pessoas, j, j+1);
				}
			}
		}
	}
	
	private static void selectionSort(Pessoa[] pessoas, int quantidadeElementos) {
		
		for (int posicaoAtual=0; posicaoAtual < quantidadeElementos; posicaoAtual++) {
			int posicaoMenor = buscaMenorSalario(pessoas, posicaoAtual, quantidadeElementos - 1);
			trocar(pessoas, posicaoAtual, posicaoMenor);
		}

	}


	private static void trocar(Pessoa[] pessoas, int posicaoPrimeiro, int posicaoSegundo) {
		
		Pessoa primeiro = pessoas[posicaoPrimeiro];
		Pessoa segundo = pessoas [posicaoSegundo];
		pessoas[posicaoPrimeiro] = segundo;
		pessoas [posicaoSegundo] = primeiro;
	}
	

	private static int buscaMenorSalario(Pessoa[] pessoas, int posicaoInicio, int posicaoTermino) {
		
		int posicaoMenorSalario = posicaoInicio;
		
		for (int posicaoAtual=posicaoInicio+1; posicaoAtual<=posicaoTermino; posicaoAtual++) {
			
			if (pessoas[posicaoAtual].getSalario() < pessoas[posicaoMenorSalario].getSalario()) {
				posicaoMenorSalario = posicaoAtual;
			}
		}
		return posicaoMenorSalario;
	}
	
	
	
	

}
