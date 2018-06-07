#include <stdlib.h>
#include <stdio.h>
#include "pilha.h"



int vazia(node *p) {

	if(p->prox == NULL)
		return 1;
	else
		return 0;
}

node *aloca(int x) {

	node *p = (node*) malloc(sizeof(node));
	p->num = x;
	p->prox = NULL;
	return p;
}

void liberar(node *p) {

	node *prox,*atual;

	atual = p->prox;

	while(atual != NULL) {

		prox = atual->prox;
		free(atual);
		atual = prox;
	}
	p->prox = NULL;
}

void exibir(node *p) {

	if(vazia(p)) {
		printf("pilha vazia\n");
	}

	node *aux;
	aux = p->prox;

	while(aux != NULL) {

		printf("elemento:%c\n", aux->num+65);
		aux = aux->prox;
	}

}

void push(node *p,int x) {


	node *novo = aloca(x);

	novo->prox =NULL;

	if(vazia(p)) {

		p->prox = novo;
	}

	else {

		node *temp = p->prox;

		while(temp->prox != NULL) {

			temp = temp->prox;

		}
		temp->prox = novo;
	}


}

void pop(node *p) {

	if(vazia(p)) {
		return;
	}

	else {

		node *ultimo, *pultimo;

		ultimo = p->prox;

		while(ultimo->prox != NULL) {

			pultimo = ultimo;
			ultimo = ultimo->prox;
		}

		pultimo->prox = NULL;
		free(ultimo);
		ultimo = NULL;

	}
}