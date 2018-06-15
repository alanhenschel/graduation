#include <stdio.h>
#include <stdlib.h>
#include "edmons_karp.h"
#include "listcad.h"

#define N 5

void largura(int arvore[N][N], int matriz[N][N], int inicial, int final) {
	linked_list *fila = new_linked_list(N+1);
	insert_last(inicial,fila);
	while(count(fila) > 0) {
		int temp = remove_first(fila);
		for(int j = 0; j < N; j++) {
			if (matriz[temp][j] > 0 && !ifFechado(arvore,j)) {
				insert_last(j,fila);
				arvore[temp][j] = matriz[temp][j];
				if (j == final) return;
			}
		}
	}
}

void print_matriz(int matriz[N][N]) {
	for (int i = 0; i < N; i++) {
		printf("\n");
		for (int j = 0; j < N; j++) {
			printf(" %d", matriz[i][j]);
		}
	}
	printf("\n");
}

void inicia(int matriz[N][N]) {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			matriz[i][j] = 0;
		}
	}
}

int ifFechado(int matriz[N][N], int x) {
	for (int i = 0; i < N; i++) {
		if (matriz[x][i] != 0 || matriz[i][x] != 0) return 1;
	}
	return 0;
}

linked_list *encontraCaminho(int arvore[N][N], int inicial, int final) {
	int next = final;
	linked_list *pilha = new_linked_list(N);
	insert_last(next,pilha);
	while (next != inicial) {
		for (int i = 0; i < N; i++) {
			if (arvore[i][next] > 0) {
				next = i;
				insert_last(next,pilha);
			}
		}
	}
	return pilha;
}