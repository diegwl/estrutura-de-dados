#include <stdio.h>
#include <stdlib.h>

typedef struct pratos {
    char marca[50];
    char cor[20];
    float peso;
} Prato;

typedef struct no {
	Prato dado;
	struct no *anterior;
} No;

typedef struct pilha {
	No *topo;
} Pilha;

Pilha p;

void push(Prato prato);
Prato pop();
void imprimir();
int verificarVazia();
void inicializar();

void inicializar(){
	p.topo = NULL;
}

int verificarVazia(){
	if(p.topo == NULL)
		return 1;
	else return 0;
}

void push(Prato prato){
	//aloca memoria para um novo noh da pilha
	No *novoNoh = (No *) malloc(sizeof(No));
	//se foi alocado memoria, adiciona o novoNo no topo da pilha
	if(novoNoh != NULL) {
		//guarda o elemento a inserir na pilha no membro dado do novoNo
		novoNoh->dado = prato;
		//o proximo elemento do novoNo serah o elemento que estah no topo
		novoNoh->anterior = p.topo;
		//Atualiza o topo da pilha
		p.topo = novoNoh;	
	} else{
		//senao informa o usuario que nao ha mais memoria
		printf("\nA pilha estah cheia pois nao ha mais memoria disponivel");
	}
}

Prato pop(){
	//verificar se a pilha n?o estah vazia
	if(!verificarVazia()) {
		//cria variavel que vai apontar para o noh a ser removido
		No *aux;
		//cria variavel para guardar o dado do noh a ser removido
		Prato dado;
		//aux aponta para o noh do topo
		aux = p.topo;
		//dado ira guardar o elemento do topo da pilha
		dado = p.topo->dado;
		//atualizar o topo da pilha
		p.topo = aux->anterior;
		//libera a memoria ocupada pelo noh removido
		free(aux);
		//retorna o valor do noh removido
		return dado;
	} else {
		//se a pilha estiver vazia, informa o usuario
		printf("\nA pilha estah vazia.");
	}
}

void imprimir(){
	//verificar se a pilha nao estah vazia
	if(!verificarVazia()) {
		//Declara uma variavel ponteiro auxiliar para percorrer os nohs da pilha
		No *aux;
		//comeca a percorrer a partir do topo
		aux = p.topo;
		//enquanto nao chegar no fim
		while(aux != NULL) {
			//imprimir o dado do noh apontado por aux
			printf("\nMarca %s \t Cor %s \t Peso %f", aux->dado.marca, aux->dado.cor, aux->dado.peso);
			//vai para o proximo noh
			aux = aux->anterior;
		}	
	} else {
		//se estiver vazia, informa o usuario
		printf("\nA pilha esta vazia.");
	}
}

int main(int argc, char *argv[]) {
	int opcao;
	Prato temp;
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
				printf("\nDigite a marca do prato: ");
				scanf("%s", temp.marca);
				fflush(stdin);
				printf("\nDigite a cor do prato: ");
				scanf("%s", temp.cor);
				fflush(stdin);
				printf("\nDigite o peso do prato: ");
				scanf("%f", &temp.peso);
				push(temp);
				break;
			case 3:
				temp = pop();
				printf("Marca do prato removido: %s", temp.marca);
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