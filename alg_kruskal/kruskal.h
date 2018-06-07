#include <stdlib.h>
#include <stdio.h>
#define N 6

typedef struct aresta {
	int v1, v2, custo;
} aresta;



void exibir(int matriz[][N]);
void kruskal(int matriz[N][N]);
void ordena(aresta *p, int t);
void exibir_final(aresta *p, int t);



