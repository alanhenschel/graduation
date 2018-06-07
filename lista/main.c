#include <stdlib.h>
#include <stdio.h>
#include "lista.h"




void main() {


	node *lista = (node*) malloc(sizeof(node));
	lista->prox = NULL;

	inserir_comeco(lista,2);
	inserir_comeco(lista,3);
	inserir_comeco(lista,4);
	inserir_comeco(lista,5);
	inserir_comeco(lista,6);
	inserir_fim(lista,1);
	exibir(lista);
	node *r = retirar_comeco(lista);
	node *r2 = retirar_final(lista);
	inserir_posicao(lista,10,2);
	exibir(lista);
}
