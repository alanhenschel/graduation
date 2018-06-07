#include <stdlib.h>
#include <stdio.h>
#include "fila.h"



node *aloca(int x) {

	node *f = (node*) malloc(sizeof(node));
	f->num = x;
	return f;
}


int vazia(node *f) {

	if(f->prox == 0)
		return 1;
	else
		return 0;
}

void insere(node *f ,int x) {

	node *novo = aloca(x);
	novo->prox = NULL;

	if(vazia(f)) {

		f->prox = novo;
	}


	else {

		node *temp = f->prox;

		while(temp->prox != NULL) {

			temp = temp->prox;
		}
		temp->prox = novo;
	}
	f->tam++;
}

int retirar(node *f, int x) {

	if(vazia(f))
		return;

	else {

		node *temp = f->prox;
		f->prox = temp->prox;
		f->tam--;
		return temp->num;
	}
}

void exibir(node *f) {



	if(vazia(f)) {
		printf("fila vazia\n");
		return;
	}


	else {

		node *temp = f->prox;


		while(temp != NULL) {

			printf("%5d\n", temp->num);
			temp = temp->prox;
		}
	}
	printf("tamanho da fila:%d\n" ,f->tam);

}


void liberar(node *f) {

	if(!vazia(f)) {

		node *prox, *atual;

		atual = f->prox;

		while(atual != NULL) {

			prox = atual->prox;
			free(atual);
			atual = prox;
		}
		f->prox = NULL;
	}
}





