#include <stdlib.h>
#include <stdio.h>
#include "fila.h"

no *aloca(int x) {

	no *f = (no*) malloc(sizeof(no));
	f->num = x;
	return f;
}


int vazia(no *f) {

	if(f->prox == NULL)
		return 1;
	else
		return 0;
}

void insere(no *f ,int x) {

	no *novo = aloca(x);
	novo->prox = NULL;

	if(vazia(f)) {

		f->prox = novo;
	}


	else {

		no *temp = f->prox;

		while(temp->prox != NULL) {

			temp = temp->prox;
		}
		temp->prox = novo;
	}
	f->tam++;
}

int pesquisar(no *f, int x) {


	no *aux = f->prox;

	while(aux != NULL) {
		if(aux->num == x)
			return 1;
		aux = aux->prox;
	}

	return 0;
}

no *retirar(no *f) {

	if(vazia(f))
		return 0;

	else {

		no *temp = f->prox;
		f->prox = temp->prox;
		f->tam--;
		return temp;
	}
}

void exibir2(no *f) {



	if(vazia(f)) {
		printf("fila vazia\n");
		return;
	}


	else {

		no *temp = f->prox;


		while(temp != NULL) {

			printf("%5d\n", temp->num);
			temp = temp->prox;
		}
	}
	printf("tamanho da fila:%d\n" ,f->tam);

}


void liberar(no *f) {

	if(!vazia(f)) {

		no *prox, *atual;

		atual = f->prox;

		while(atual != NULL) {

			prox = atual->prox;
			free(atual);
			atual = prox;
		}
		f->prox = NULL;
	}
}





