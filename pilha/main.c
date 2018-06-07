#include <stdlib.h>
#include <stdio.h>
#include "pilha.h"




void main () {


	node *pilha = (node*) malloc(sizeof(node));
	pilha->prox = NULL;

	push(pilha,2);
	push(pilha,3);
	push(pilha,4);
	push(pilha,5);
	push(pilha,6);
	push(pilha,7);
	push(pilha,8);
	push(pilha,9);
	push(pilha,10);
	exibir(pilha);
	pop(pilha);
	exibir(pilha);
	liberar(pilha);
	exibir(pilha);

}