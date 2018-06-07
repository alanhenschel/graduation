#include <stdlib.h>
#include <stdio.h>
#define N 6

typedef struct aresta {
	int v1, v2, estimativa,aberto;
} aresta;

typedef struct vertice {
	int estimativa,aberto;
}vertice;


void ordena(aresta *p, int t);
void exibir_final(aresta *p, int t, int v1_final, int v2_final);
int estimativa_menor(int estimativa);
void carregar(int matriz[N][N]);
void dijkstra(aresta *p, int inicio, int fim,int t);
int verificar_estimativa(vertice *p);
int verificar(vertice *p);



