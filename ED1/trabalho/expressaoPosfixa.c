#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void push(double numero);
double pop();
void imprimir();
int verificarVazia();
void inicializar();
double resolverExpressao(char expressao[100]);

typedef struct no {
	double dado;
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

void push(double numero){
	No *novoNoh = (No *) malloc(sizeof(No));
	if(novoNoh != NULL) {
		novoNoh->dado = numero;
		novoNoh->anterior = p.topo;
		p.topo = novoNoh;	
	} else{
		printf("\nA pilha estah cheia pois nao ha mais memoria disponivel");
	}
}

double pop(){
	if(!verificarVazia()) {
		No *aux;
		double dado;
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
			printf(" %.2lf", aux->dado);
			aux = aux->anterior;
		}	
	} else {
		printf("\nA pilha esta vazia.");
	}
}

double operacao(double a, double b, char x) {
	switch(x) {
		case '+':
			return a + b;
			break;
		case '-':
			return a - b;
			break;
		case '*':
			return a * b;
			break;
		case '/':
			return a / b;
			break;
	}
}

double resolverExpressao(char expressao[100]) {
	char *pt;
	double num, n1, n2;

	// separa a string nos " "
	pt = strtok(expressao, " ");
	// Enquanto ainda tiver algo na string
	while (pt) {
		// se o caracter for uma operacao
		if(pt[0] == '+' || pt[0] == '-' || pt[0] == '*' || pt[0] == '*') {
			// desempilha os ultimos 2 numeros e realiza a conta
			n1 = pop();
			n2 = pop();
			num = operacao(n2, n1, pt[0]);
			// empilha o resultado
			push(num);
		} else {
			// se o caracter nao for uma operacao, ele serah um numero, portanto convertemos e empilhamos ele
			num = strtol(pt, NULL, 10);
			push(num);
		}
		// separa novamente a string
		pt = strtok(NULL, " ");
	}

	// desempilha o resultado final
	num = pop();
	// retorna o resultado para o usuario
	return  num;
}

int main(int argc, char *argv[]) {
	char exp[100];
	double resultado;
	int opcao;

	do {
        printf("\n    MENU");
		printf("\n1. Resolver Expressao");
		printf("\n2. Converter Expressao");
		printf("\n3. Sair");
        printf("\nDigite a opcao desejada: ");

        scanf("%d", &opcao);

        switch(opcao) {
            case 1:
				inicializar();
                printf("Digite uma Expressao Posfixa: ");
				fflush(stdin);
				scanf("%[^\n]s", exp);
				fflush(stdin);

				printf("\nO resultado da Expressao %s eh:", exp);
                resultado = resolverExpressao(exp);
                printf("\n%.2lf", resultado);
                break;
            case 2:
                printf("\nEncerrando o programa...");
				break;
        }
    } while(opcao != 2);
}