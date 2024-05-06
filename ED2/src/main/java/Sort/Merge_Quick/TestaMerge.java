package Sort.Merge_Quick;

public class TestaMerge {

	public static void main(String[] args) {
		
		Nota[] notasRui = {
				new Nota("andre", 4),
				new Nota ("amarildo", 5),
				new Nota("carlos", 8.5),
				new Nota ("paulo", 9),
		};
		Nota[] notasTony = {
				new Nota("jonas", 3),
				new Nota ("juliana", 6.7),
				new Nota("guilherme", 7),
				new Nota ("lucia", 9.3),
				new Nota("ana", 10)		
		};
		
		Nota [] rank = intercalar(notasRui, notasTony);
		for (Nota nota: rank) {
			System.out.println(nota.getAluno() + " "+ nota.getValor());
		}

	}

	private static Nota[] intercalar(Nota[] notas1, Nota[] notas2) {
		int total = notas1.length + notas2.length;
		Nota[] resultado = new Nota[total];
		
		int atual1 = 0;
		int atual2 = 0;
		int atual = 0;
		
		while (atual1 < notas1.length &&
				atual2 < notas2.length) {
		
			Nota nota1 = notas1[atual1];
			Nota nota2 = notas2[atual2];
			
			if (nota1.getValor() < nota2.getValor()) {
				resultado[atual] = nota1;
				atual1++;
			} else {
				resultado[atual] = nota2;
				atual2++;
			}
			atual++;
		}
		
		while (atual1 < notas1.length) {
			resultado[atual] = notas1[atual1];
			atual++;
			atual1++;
		}
		
		while (atual2 < notas2.length) {
			resultado[atual] = notas2[atual2];
			atual++;
			atual2++;
		}
		
		return resultado;
	}

}















