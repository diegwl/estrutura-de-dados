#include <stdio.h>
#include <stdlib.h>

void inserir(float numero);
void inicializar();
int verificarVazia();
void imprimir();
float remover();

typedef struct no {
    float dado;
    struct no *proximo;
} No;

typedef struct fila {
    No *inicio, *final;
} Fila;

Fila f;

void inicializar() {
    f.inicio = NULL;
    f.final = NULL;
}

int verificarVazia() {
    if(f.inicio == NULL)
        return 1;
    else return 0;
}

void inserir(float numero) {
    No *novoNo = (No*) malloc(sizeof(No));

    if(novoNo != NULL) {
        novoNo->dado = numero;
        novoNo->proximo = NULL;
        if(verificarVazia()) {
            f.inicio = novoNo;
        } else {
            f.final->proximo = novoNo;
        }
        f.final = novoNo;
    } else {
		printf("\nNao eh possivel adicionar na fila pois nao ha mais memoria disponivel.");
	}
}

void imprimir() {
    if(!verificarVazia()) {
        No *aux;
	    printf("\nOs elementos na fila sao: ");

        aux = f.inicio;

        while(aux != NULL) {
			printf(" %.2f", aux->dado);
			aux = aux->proximo;
		}
    } else {
        printf("\nA fila estah vazia.");
    }
}

float remover() {
    if(!verificarVazia()) {
        No *aux;
        float dado;

        aux = f.inicio;
        dado = aux->dado;
        f.inicio = aux->proximo;

        if(f.final == aux) {
            f.final = NULL;
        }

        free(aux);
        return dado;
    } else {
        printf("A fila estah vazia.");
    }
}

int main(int argc, char *argv[]) {
	float temp;
	int opcao;
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
				printf("Digite o numero: ");
				scanf("%f", &temp);
				inserir(temp);
				break;
			case 3:
				temp = remover();
				printf("\nNumero removido: %.2f", temp);
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
