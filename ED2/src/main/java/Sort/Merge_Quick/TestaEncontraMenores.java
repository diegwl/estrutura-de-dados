package Sort.Merge_Quick;

public class TestaEncontraMenores {

	public static void main(String[] args) {
		Nota guilherme = new Nota("guilherme", 7);
		Nota[] notas = { 
				new Nota("andre", 4), 
				new Nota("carlos", 8.5),
				new Nota("ana", 10),
				new Nota("jonas", 3),
				new Nota("juliana", 6.7), 
				guilherme,
				new Nota("paulo", 9),
				new Nota("amarildo", 5), 
				new Nota("lucia", 9.3)};
		
		
		int menores = encontraMenores(guilherme, notas);
		System.out.println("Numeros menores: "+ menores);

	}

	private static int encontraMenores(Nota busca, Nota[] notas) {
		
		int menores = 0;
		for (int atual=0; atual < notas.length; atual++) {
			Nota nota = notas[atual];
			if (nota.getValor() < busca.getValor()) {
				menores++;
			}
		}
		return menores;
		
	}

}
