#include <stdlib.h>
#include <stdio.h>
#include "kruskal.h"
#define N 6



void main() {


int matriz_inicial[N][N] = {0,5,0,0,6,0,
							5,0,7,0,13,9,
							0,7,0,8,0,3,
							0,0,8,0,9,15,
							6,13,0,9,0,11,
							0,9,3,15,11,0};

	//exibir(matriz_inicial);
	kruskal(matriz_inicial);
}