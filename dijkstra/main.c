#include <stdlib.h>
#include <stdio.h>
#include "dijkstra.h"
#define N 6



void main() {


int matriz_inicial[N][N] = {0,2,0,0,3,2,
							2,0,7,0,0,6,
							0,7,0,5,0,8,
							0,0,5,0,4,0,
							3,0,0,4,0,1,
							2,6,8,0,1,0};

	//exibir(matriz_inicial);
	carregar(matriz_inicial);
}