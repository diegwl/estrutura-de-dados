#include <stdio.h>
#include <stdlib.h>

typedef struct candidato
{
	int ID;
	char nome[50], telefone[14];
} Candidato;

void inserir(Candidato candidato);
Candidato remover(int id);
void imprimir();
void inicializar();
int verificarVazia();
Candidato* pesquisar(int id);
void alterar(int id);

typedef struct no
{
	Candidato dado;
	struct no *proximo;
} No;

typedef struct lista
{
	No *inicio;
} Lista;

Lista l;

void inicializar()
{
	l.inicio = NULL;
}

int verificarVazia()
{
	return l.inicio == NULL;
}

Candidato* pesquisar(int id)
{
	if (!verificarVazia())
	{
		No *aux = l.inicio;
		while (aux != NULL)
		{
			if (aux->dado.ID == id)
			{
				return &(aux->dado);
			}
			aux = aux->proximo;
		}
	}
	return NULL;
}

void inserir(Candidato candidato)
{
	No *novoNo = (No *)malloc(sizeof(No));
	if (novoNo != NULL)
	{
		Candidato *aux = pesquisar(candidato.ID);

		if (aux == NULL)
		{
			novoNo->dado = candidato;
			novoNo->proximo = NULL;
			if (verificarVazia())
			{
				l.inicio = novoNo;
			}
			else
			{
				No *ultimo = l.inicio;
				while (ultimo->proximo != NULL)
				{
					ultimo = ultimo->proximo;
				}
				ultimo->proximo = novoNo;
			}
		}
		else
		{
			printf("\nEsse ID ja existe.\n");
			free(novoNo);
		}
	}
	else
	{
		printf("\nNao eh possivel adicionar na lista pois nao ha mais memoria disponivel.\n");
	}
}

void imprimir()
{
	if (!verificarVazia())
	{
		No *aux = l.inicio;
		while (aux != NULL)
		{
			printf("\nID: %d\tNome: %s \tTelefone: %s\n", aux->dado.ID, aux->dado.nome, aux->dado.telefone);
			aux = aux->proximo;
		}
	}
	else
	{
		printf("\nA lista esta vazia\n");
	}
}

Candidato remover(int id)
{
	if (!verificarVazia())
	{
		No *aux = l.inicio;
		No *anterior = NULL;
		Candidato dado;
		while (aux != NULL && aux->dado.ID != id)
		{
			anterior = aux;
			aux = aux->proximo;
		}

		if (aux != NULL)
		{
			if (anterior == NULL)
			{
				l.inicio = aux->proximo;
			}
			else
			{
				anterior->proximo = aux->proximo;
			}
			dado = aux->dado;
			free(aux);
			return dado;
		}
		else
		{
			printf("\nCandidato nao encontrado.\n");
		}
	}
	else
	{
		printf("\nA lista estah vazia.\n");
	}
}

void alterar(int id)
{
	Candidato *candidato = pesquisar(id);
	if (candidato != NULL)
	{
		printf("\nID: %d\tNome: %s \tTelefone: %s\n", candidato->ID, candidato->nome, candidato->telefone);

		fflush(stdin);
		printf("\nDigite o nome do candidato: ");
		scanf("%s", candidato->nome);

		fflush(stdin);
		printf("\nDigite o telefone do candidato: ");
		scanf("%s", candidato->telefone);

		printf("Candidato alterado com sucesso.\n");
	}
	else
	{
		printf("\nCandidato nao encontrado.\n");
	}
}

int main(int argc, char *argv[])
{
	int opcao, id;
	Candidato temp;

	inicializar();

	do
	{
		printf("\n MENU");
		printf("\n1. Pesquisar");
		printf("\n2. Inserir");
		printf("\n3. Remover");
		printf("\n4. Exibir");
		printf("\n5. Alterar");
		printf("\n6. Sair");
		printf("\nDigite a opcao desejada: ");
		scanf("%i", &opcao);

		switch (opcao)
		{
		case 1:
			printf("\nDigite o ID que deseja pesquisar: ");
			scanf("%d", &id);
			Candidato *ptr = pesquisar(id);
			if (ptr != NULL)
			{
				printf("\nCandidato encontrado -> ID: %d\tNome: %s \tTelefone: %s\n", ptr->ID, ptr->nome, ptr->telefone);
			}
			else
			{
				printf("\nCandidato nao encontrado.\n");
			}
			break;
		case 2:
			printf("\nDigite o ID do candidato: ");
			scanf("%d", &temp.ID);

			fflush(stdin);
			printf("\nDigite o nome do candidato: ");
			scanf("%s", temp.nome);

			fflush(stdin);
			printf("\nDigite o telefone do candidato: ");
			scanf("%s", temp.telefone);

			inserir(temp);
			break;
		case 3:
			printf("\nDigite o ID que deseja remover: ");
			scanf("%d", &id);
			Candidato removido = remover(id);
			printf("Candidato removido -> ID: %d\tNome: %s \tTelefone: %s\n", removido.ID, removido.nome, removido.telefone);
			break;
		case 4:
			imprimir();
			break;
		case 5:
			printf("\nDigite o ID que deseja alterar: ");
			scanf("%d", &id);
			alterar(id);
			break;
		case 6:
			printf("\nSaindo do programa...\n");
			break;
		default:
			printf("\nEscolha uma opcao valida!\n");
		}

	} while (opcao != 6);

	return 0;
}
