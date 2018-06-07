#include <stdlib.h>
#include <stdio.h>
#include "fila.h"


void main() {

	node *f;
	f = (node*) malloc(sizeof(node));
	f->prox = NULL;
	f->tam = 0;
	insere(f,10);
	insere(f,20);
	insere(f,30);
	insere(f,40);
	insere(f,50);
	insere(f,60);
	insere(f,70);
	insere(f,80);
	insere(f,90);
	exibir(f);
	printf("o valor retirado foi:%d\n", retirar(f));
	exibir(f);
	liberar(f);
	exibir(f);
}


