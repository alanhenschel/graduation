#include <stdio.h>
#include <stdlib.h>
#include "largura.h"


void main() {

	int matriz_inicial[3][3] = {1,2,3,0,7,4,8,6,5};
	int matriz_deck[3][3];


	node *raiz;

	newtree(&raiz);


	gera_estado(&raiz,matriz_inicial);

	exibir(raiz);





}