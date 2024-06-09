package ChallengeAppResolved;

import ChallengeAppResolved.model.Customer;
import ChallengeAppResolved.order.Ordenador;
import ChallengeAppResolved.search.ArvoreRN;
import ChallengeAppResolved.search.BxTree;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CustomerOperatorTest {

	private Date inicio;
	private Date termino;

	@Test
	void testFindById() {

		iniciarTarefa("testFindById()");

		List<Customer> customers = CustomerOperator.loadCustomersFromCSV("customerDb200.csv");
		assertEquals(200000, customers.size());

		// =================================================

		ArvoreRN arvore = new ArvoreRN();
		for (Customer customer : customers) {
			arvore.inserir(customer.getId());
		}
		assertEquals(451, arvore.buscarNoPorValor(451).getDado());

		// =================================================

		terminarTarefa("testFindById()");
		System.out.println("Duracao (ms): " + calcularDuracaoEmSegundosTarefa());

	}

	@Test
	void testOrderById() {

		iniciarTarefa("testOrderById()");

		List<Customer> customers = CustomerOperator.loadCustomersFromCSV("customerDb200.csv");
		assertEquals(200000, customers.size()); // testa quantidade de elementos carregados
		assertEquals(77163, customers.get(0).getId()); // verifica o primeiro elemento antes de ordenar
		assertEquals(126598, customers.get(199999).getId()); // verifica o ultimo elemento antes de ordenar

		// =================================================

		Customer[] arrayCustomers = customers.toArray(new Customer[customers.size()]);
		Ordenador.smoothsort(arrayCustomers, 0, 199999);
		// arrayCustomers = MergeSort.sort(arrayCustomers);

		// =================================================

		assertEquals(200000, arrayCustomers.length); // testa quantidade de elementos no vetor ordenado
		assertEquals(0, arrayCustomers[0].getId()); // verifica o primeiro elemento depois de ordenar
		assertEquals(199999, arrayCustomers[199999].getId()); // verifica o ultimo elemento depois de ordenar

		terminarTarefa("testOrderById()");
		System.out.println("Duracao (ms): " + calcularDuracaoEmSegundosTarefa());

	}

	private void iniciarTarefa(String nomeTarefa) {
		inicio = new Date();
		System.out.println("Tarefa " + nomeTarefa + " iniciada em: " + inicio);
	}

	private void terminarTarefa(String nomeTarefa) {
		termino = new Date();
		System.out.println("Tarefa " + nomeTarefa + " terminada em: " + termino);
	}

	private long calcularDuracaoEmSegundosTarefa() {
		if (inicio == null || termino == null) {
			System.out.println("A tarefa não foi iniciada ou terminada.");
			return 0;
		}
		long duracaoEmMilissegundos = termino.getTime() - inicio.getTime();
		return duracaoEmMilissegundos;
	}
}
