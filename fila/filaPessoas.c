#include <stdio.h>
#include <stdlib.h>

typedef struct pessoas {
    char nome[50], genero;
    int idade;
} Pessoa;

typedef struct no {
    Pessoa dado;
    struct no *proximo;
} No;

typedef struct fila {
    No *inicio, *final;
} Fila;

void inserir(Pessoa pessoa);
void inicializar();
int verificarVazia();
void imprimir();
Pessoa remover();

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

void inserir(Pessoa pessoa) {
    No *novoNo = (No*) malloc(sizeof(No));

    if(novoNo != NULL) {
        novoNo->dado = pessoa;
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
			printf("\nNome %s \t Idade %d \t Genero %c", aux->dado.nome, aux->dado.idade, aux->dado.genero);
			aux = aux->proximo;
		}
    } else {
        printf("\nA fila estah vazia.");
    }
}

Pessoa remover() {
    if(!verificarVazia()) {
        No *aux;
        Pessoa dado;

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
	Pessoa temp;
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
                fflush(stdin);

				printf("Digite o nome: ");
				scanf("%[^\n]s", temp.nome);

				fflush(stdin);

                printf("Digite a idade: ");
				scanf("%d", &temp.idade);

                fflush(stdin);

                printf("Digite o genero: ");
				scanf("%c", &temp.genero);

                fflush(stdin);
                
                inserir(temp);
				break;
			case 3:
				temp = remover();
				printf("\nPessoa Removida: %s", temp.nome);
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
