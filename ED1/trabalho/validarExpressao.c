#include <stdio.h>
#include <stdlib.h>

void push(char caractere);
char pop();
void imprimir();
int verificarVazia();
void inicializar();
int verificarExpressao(char exp[100]);

typedef struct no {
	char dado;
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

void push(char caractere){
	No *novoNoh = (No *) malloc(sizeof(No));
	if(novoNoh != NULL) {
		novoNoh->dado = caractere;
		novoNoh->anterior = p.topo;
		p.topo = novoNoh;	
	} else{
		printf("\nA pilha estah cheia pois nao ha mais memoria disponivel");
	}
}

char pop(){
	if(!verificarVazia()) {
		No *aux;
		char dado;
		aux = p.topo;
		dado = p.topo->dado;
		p.topo = aux->anterior;
		free(aux);
		return dado;
	} else {
		printf("\nA pilha estah vazia.");
		return 0;
	}
}

void imprimir(){
	if(!verificarVazia()) {
		No *aux;
		aux = p.topo;
		while(aux != NULL) {
			printf(" %c", aux->dado);
			aux = aux->anterior;
		}	
	} else {
		printf("\nA pilha esta vazia.");
	}
}

int verificarExpressao(char exp[100]) {
    inicializar();
    int valid = 1, count = 0;
    char letra, iniciador;

    while (exp[count] != '\0') {
        letra = exp[count];
        
        if (letra == '(' || letra == '[' || letra == '{'){
            push(letra);
        }
            
        if (letra == ')' || letra == ']' || letra == '}') {
            if (verificarVazia()){
                valid = 0;
            } else {
                iniciador = pop();
                if (!(iniciador == '(' && letra == ')') && !(iniciador == '[' && letra == ']') && !(iniciador == '{' && letra == '}')) {
                    valid = 0;
                }
            }
        }
        count++;
    }
    if (!verificarVazia()) {
        valid = 0;
    }

    return valid;
}

int main(int argc, char *argv[]) {
    int opcao, resultado;
    char temp[100];
	inicializar();

    do {
        printf("\n    MENU");
		printf("\n1. Validar Expressao");
		printf("\n2. Sair");
        printf("\nDigite a opcao desejada: ");

        scanf("%d", &opcao);

        switch(opcao) {
            case 1:
                printf("Digite uma Expressao: ");
				scanf("%s", temp);

                resultado = verificarExpressao(temp);
                if (resultado)
                    printf("%s", "a expressao eh valida");
                else
                    printf("%s", "a expressao eh invalida");
                break;
            case 2:
                printf("Encerrando o programa...");
				break;
        }
    } while(opcao != 2);
}