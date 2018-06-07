#include <stdlib.h>
#include <stdio.h>
#include "dijkstra.h"
#include "pilha.h"
#define N 6

int comp;


void carregar(int matriz[N][N]) {

	aresta *p = malloc((N*N) * sizeof(aresta));
	aresta *p2 = malloc((N*N) * sizeof(aresta));
	aresta *p3 = malloc((N*N) * sizeof(aresta));

	int x,t,z;
	x = 1;
	t = 0;
	int count = 0;

	for(int i = 0; i < N; i++) {
		for(int j = 0; j < N; j++) {
			if(matriz[i][j] != 0) {
				(p+count)->aberto = 1;
				count++;
			}
		}
	}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {

				if(matriz[i][j] != 0 && (p+t)->aberto == 1) {
					(p+t)->v1 = i;	
					(p+t)->v2 = j;
					(p+t)->estimativa = matriz[i][j];
					(p+t)->aberto = 1;
					t++;
				}
			}
		}

		for(int i = 0; i < t; i++)
			printf("(%c %c) = %d\n",(p+i)->v1+65,(p+i)->v2+65,(p+i)->estimativa);

	dijkstra(p,0,2,t);
	//exibir_final(p,t,(p+2)->v1,(p+2)->v2);
}

void dijkstra(aresta *p, int inicio, int fim,int t) {

	node *pilha = (node*) malloc(sizeof(node));
	pilha->prox = NULL;


	vertice *p2 = malloc((N*N) * sizeof(vertice));

	int aux = inicio;
	int temp;

	for(int i = 0; i < N; i++) {
		(p2+i)->estimativa = -1;
		(p2+i)->aberto = 1;
	}

	(p2+aux)->estimativa = 0;
	while(verificar(p2)) {



		if((p2+aux)->aberto == 1) {
			for(int i = 0; i < t; i++) {
				if((p+i)->v1 == aux) {
					temp = (p+i)->v2;
					if((p2+temp)->aberto == 1 && (p2+temp)->estimativa == -1) {
						(p2+temp)->estimativa = (p+i)->estimativa + (p2+aux)->estimativa;
					}	else{
						if((p2+temp)->aberto == 1 && (p2+temp)->estimativa >(p2+temp)->estimativa + (p+i)->estimativa)
							(p2+temp)->estimativa = (p2+temp)->estimativa + (p+i)->estimativa;
					}
				}
			}
		}
			((p2+aux)->aberto = 0);
		aux = verificar_estimativa(p2);
	}
	
	aux = fim;
	push(pilha,fim);
	while(aux != inicio) {

			for(int i = 0; i < t; i++) {
				if((p+i)->v1 == aux) {
					if((p2+((p+i)->v1))->estimativa - (p+i)->estimativa == (p2+((p+i)->v2))->estimativa) {
						aux = (p+i)->v2;
						push(pilha,aux);
						break;
					}
				}

			}


	}

	exibir(pilha);


}


int busca(aresta *p,int v1, int v2, int t) {

	for(int i = 0; i << t; i++) {
		if((p+i)->v1 == v1 && (p+i)->v2 == v2)
			return (p+i)->estimativa;
	}
	printf("erro\n");
}

int verificar_estimativa(vertice *p) {

	int menor[2] = {0,200};

	for(int i = 0; i < N; i++) {
		if((p+i)->aberto == 1) {
			if((p+i)->estimativa < menor[1] && (p+i)->estimativa != -1) {
				menor[0] = i;
				menor[1] = (p+i)->estimativa;
			}
		}
	}
	return menor[0];
}

int verificar(vertice *p) {
	for(int i = 0; i < N; i++) {
		if((p+i)->aberto == 1)
			return 1;
	}
	return 0;
}

void ordena(aresta *p, int t) {
    int i,j,temp;
    for(i=1;i<t;i++) {
        temp = (p+i)->estimativa;
        j=i;
        while(j>0 && (p+j-1)->estimativa > temp) {
            (p+j)->estimativa = (p+j-1)->estimativa ;
            j--;
        }
        (p+j)->estimativa = temp;
    }
}

void exibir_final(aresta *p, int t, int v1_final, int v2_final) {

	int aux;

	for(int i = 0; i < t; i++) {
		if ((p+i)->v1 == v1_final && (p+i)->v2 == v2_final) {
			
		}
	}
}