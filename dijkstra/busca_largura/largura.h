	#include <stdio.h>
#include <stdlib.h>


typedef struct node{

	int num;
	struct node *down;
	struct node *up;
	struct node *left;
	struct node *right;
}node;

void newtree(node **T);
void gera_estado(node **raiz, int matriz[][3]);
int funcao(int matriz[][3]);
int achar_i(int matriz[][3]);
int achar_j(int matriz[][3]);
node *create_node(node **raiz, int matriz[][3]);
node *esquerda(int matriz[][3],int i,int j);
node *baixo(int matriz[][3],int i,int j);
node *cima(int matriz[][3],int aui,int auj);
node *cima2(int matriz[][3],int aui,int auj);
int verificar(int num);
void exibir(node *raiz);
int verificar_vet(int x);
int verificar_vet2(int x);