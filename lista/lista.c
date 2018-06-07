#include <stdlib.h>
#include <stdio.h>
#include "lista.h"

int tam;

int vazia(node *l) {

	if(l->prox == NULL)
		return 1;
	else
		return 0;
}


node *aloca(int x) {

	node *l = (node*) malloc(sizeof(node));
	l->num = x;
	l->prox = NULL;
	return l;
}

void inserir_comeco(node *l, int x) {

	node *novo = aloca(x);


	if(vazia(l)) {

		l->prox = novo;
	}

	else {

		node *temp = l->prox;

		l->prox = novo;
		novo->prox = temp;
	}
	tam++;

}

void inserir_fim(node *l, int x) {

	node *novo = aloca(x);

	if(vazia(l)) {

		l->prox = novo;
	}
	else {

		node *temp = l->prox;


		while(temp->prox != NULL) {

			temp = temp->prox;
		}

		temp->prox = novo;
	}
	tam++;
}

void exibir(node *l) {

	if(vazia(l))
		printf("lista vazia\n");

	else {

		node *temp = l->prox;


		printf("lista:");
		while(temp != NULL) {

			printf("%5d", temp->num);
			temp = temp->prox;
		}

		printf("\n        ");

	for(int i=0 ; i < tam ; i++)
		printf("  ^  ");
	printf("\nOrdem:");
	for(int i=0 ; i < tam ; i++)
		printf("%5d", i+1);
	
	printf("\n\n");
	}

}

void liberar(node *l) {

	if(vazia(l))
		return;

	else {

		node *temp = l->prox;
		node *aux;

		while(temp != NULL) {

			aux = temp->prox;
			free(temp);
			temp = aux;

		}
		l->prox = NULL;
		tam = 0;
	}

}


node *retirar_comeco(node *l) {

	if(vazia(l))
		return NULL;

	else {

		node *temp = l->prox;

		l->prox = temp->prox;

		tam--;

		return temp;

	}
}

node *retirar_final(node *l) {

	if(vazia(l))
		return NULL;

	else {

		node *temp = l->prox;
		node * aux;

		while(temp->prox != NULL) {

			aux = temp;

			temp = temp->prox;
		}

		aux->prox = NULL;
		tam--;
		return aux;


	}
}

void inserir_posicao(node *l, int x, int pos) {

	if(pos > 0 && pos <= tam) {
		if(pos == 0)
			inserir_comeco(l,x);

		else {

			node *atual = l->prox;
			node *anterior = l;

			for(int i = 0; i < pos; i++) {

				anterior = atual;
				atual = atual->prox;
			}

			node *novo = aloca(x);
			anterior->prox = novo;
			novo->prox = atual;
			tam++;

		}
	}
}

