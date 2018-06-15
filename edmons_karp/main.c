#include <stdio.h>
#include <stdlib.h>
#include "edmons_karp.h"
#include "listcad.h"

#define N 5

int main() {
	int arvore[N][N], fluxoMaximo = 0;
	int matriz[N][N] = {0,2,3,1,0,
						0,0,4,1,3,
						0,0,0,1,2,
						0,0,0,0,2,
						0,0,0,0,0};
	while (1) {
		inicia(arvore);
		largura(arvore,matriz,0,4);
		int controle = 0;
		for (int i = 0; i < N; i++) {
			controle += arvore[i][4]; 
		}
		if (controle <= 0) {
			break;
		}
		linked_list *caminho = encontraCaminho(arvore,0,4);
		int gargalo = 1073741823;
		
		int temp = 0, temp2 = 0, path[N], i = 1;
		temp = remove_last(caminho);
		path[0] = temp;
		while (count(caminho) > 0) {
			temp2 = remove_last(caminho);
			if (gargalo > matriz[temp][temp2]) {
				gargalo = matriz[temp][temp2];
				printf("Gargalo: %d\n", gargalo);
			}
			path[i] = temp2;
			i++;
			temp = temp2;
		}
		while (i > 1) {
			i--;
			matriz[path[i-1]][path[i]] -= gargalo; 
		}
		printf("Nova Matriz: \n");
		print_matriz(matriz);
		fluxoMaximo += gargalo;
	}

	printf("Fluxo Maximo: %d\n", fluxoMaximo);

	return 0;
}