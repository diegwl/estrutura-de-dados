#include <stdio.h>
#include <stdlib.h>

typedef struct livro {
	char nome[50];
	int qtd;
	float valor;
} Livro;

void push(Livro l);
Livro pop();
void imprimir();
int verificarVazia();
void inicializar();

typedef struct no {
	Livro dado;
	struct no *anterior;
} No;

typedef struct pilha {
	No *topo;
} Pilha;

Pilha p;

void inicializar(){
	p.topo = NULL;
}

int verificarVazia(){
	if(p.topo == NULL)
		return 1;
	else return 0;
}

void push(Livro livro){
	No *novoNoh = (No *) malloc(sizeof(No));
	if(novoNoh != NULL) {
		novoNoh->dado = livro;
		novoNoh->anterior = p.topo;
		p.topo = novoNoh;	
	} else{
		printf("\nA pilha estah cheia pois nao ha mais memoria disponivel");
	}
}

Livro pop(){
	if(!verificarVazia()) {
		No *aux;
		Livro dado;
		aux = p.topo;
		dado = p.topo->dado;
		p.topo = aux->anterior;
		free(aux);
		return dado;
	} else {
		printf("\nA pilha estah vazia.");
	}
}

void imprimir(){
	if(!verificarVazia()) {
		No *aux;
		aux = p.topo;
		while(aux != NULL) {
			printf("Livro -> Nome: %s\tQtd: %d\tValor: %.2f\n", aux->dado.nome, aux->dado.qtd, aux->dado.valor);
			aux = aux->anterior;
		}	
	} else {
		printf("\nA pilha esta vazia.");
	}
}

int main(int argc, char *argv[]) {
	int opcao;
	Livro temp;
	inicializar();

	do {
		//exibir o menu
		printf("\n    MENU");
		printf("\n1. Inicializar");
		printf("\n2. Inserir");
		printf("\n3. Remover");
		printf("\n4. Imprimir");
		printf("\n5. Sair");
		printf("\nDigite a opcao desejada: ");
		
		//ler a opcao desejada pelo usuario
		scanf("%d", &opcao);
		
		//processar a funcionalidade
		switch(opcao) {
			case 1:
				inicializar();
				break;
			case 2:
				printf("Digite o Nome do Livro: ");
				scanf("%s", temp.nome);
				printf("Digite a Quantidade do Livro: ");
				scanf("%d", &temp.qtd);
				printf("Digite o Valor do Livro: ");
				scanf("%f", &temp.valor);
				push(temp);
				break;
			case 3:
				temp = pop();
				printf("Livro removido: %s", temp.nome);
				break;
			case 4:
				imprimir();
				break;
			case 5:
				printf("Encerrando o programa...");
				break;
			default:
				printf("\nOpcao invalida. Escolha um numero valido de opcao.");
		}
		
	} while(opcao != 5);
}