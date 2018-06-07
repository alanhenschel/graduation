#include <stdio.h>
#include <stdlib.h>
#include "largura.h"
#include "fila.c"


	int matriz_final[3][3] = {1,2,3,0,7,4,6,8,5};
	int pronto = 0;
	int matriz_deck[3][3] = {0,0,0,0,0,0,0,0,12};

	no *abertos;
	no *fechados;


	void newtree(node **T) {

	*T = NULL;
	abertos = (no*) malloc(sizeof(no));
	abertos->prox = NULL;
	abertos->tam = 0;
	fechados = (no*) malloc(sizeof(no));
	fechados->prox = NULL;
	fechados->tam = 0;
	}

	node *create_node(node **raiz, int matriz[][3]) {


		(*raiz) = (node*) malloc(sizeof(node));
		(*raiz)->num = funcao(matriz);
		(*raiz)->down = NULL;
		(*raiz)->up = NULL;
		(*raiz)->left = NULL;
		(*raiz)->right = NULL;

		return *raiz;


	}


	void gera_estado(node **raiz, int matriz[][3]) {



		if((*raiz) == NULL) {


			if(verificar_vet(funcao(matriz))) {
				return;
			}

			*raiz = create_node(&(*raiz),matriz);
					if(pronto == 1) {
			return;
		}
		}

		if(verificar(funcao(matriz))){
			return;
		}

			else {
				int aui,auj;
				aui = achar_i(matriz);
				auj = achar_j(matriz);

				int aux;

				carregar1(matriz);

				if(aui != 0) {

					aux = matriz_deck[aui-1][auj];
					matriz[aui-1][auj] = 0;
					matriz[aui][auj] = aux;
					gera_estado(&((*raiz)->up),matriz);
					if(verificar_vet(funcao(matriz)) != 1 && verificar_vet2(funcao(matriz)) != 1) {
						insere(abertos,funcao(matriz));
					}
					carregar2(matriz);
				}

				else if(auj != 2) {


					aux = matriz_deck[aui][auj+1];
					matriz[aui][auj+1] = 0;
					matriz[aui][auj] = aux;
					gera_estado(&((*raiz)->right),matriz);
					if(verificar_vet(funcao(matriz)) != 1 && verificar_vet2(funcao(matriz)) != 1) {
						insere(abertos,funcao(matriz));
					}
					carregar2(matriz);
				}
				else if(aui != 2) {

					aux = matriz_deck[aui+1][auj];
					matriz[aui+1][auj] = 0;
					matriz[aui][auj] = aux;
					gera_estado(&((*raiz)->down),matriz);
					if(verificar_vet(funcao(matriz)) != 1 && verificar_vet2(funcao(matriz)) != 1) {
						insere(abertos,funcao(matriz));
					}
					carregar2(matriz);
				}

				else if(auj != 0) {

					
					aux = matriz_deck[aui][auj-1];
					matriz[aui][auj-1] = 0;
					matriz[aui][auj] = aux;
					gera_estado(&((*raiz)->left),matriz);

					if(verificar_vet(funcao(matriz)) != 1 && verificar_vet2(funcao(matriz)) != 1) {
						insere(abertos,funcao(matriz));
					}
					carregar2(matriz);
				}
	}

				insere(fechados,funcao(matriz));
}
 // USAR GOTO


int verificar_vet(int x) {

	if(abertos->prox == NULL) {
		insere(abertos,x);
		return 0;
	}


	no *aux = abertos->prox;

	while(aux->prox != NULL) {

		if(aux->num == x) {
			return 1;
		}
		aux = aux->prox;
	}

	insere(abertos,x);
	return 0;
}
int verificar_vet2(int x) {

	if(fechados->prox == NULL) {
		return 0;
	}


	no *aux = fechados->prox;

	while(aux->prox != NULL) {

		if(aux->num == x) {
			return 1;
		}
		aux = aux->prox;
	}
	return 0;
}


int verificar(int num) {

		if(num == 123804765) {
			pronto = 1;
			return 1;
		}

		else {
			return 0;
		}
}





int achar_i(int matriz[][3]) {


		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {

				if(matriz[i][j] == 0) {

					return i;
				}

			}
		}
}

int achar_j(int matriz[][3]) {


		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {

				if(matriz[i][j] == 0) {

					return j;

				}

			}
		}

}

int funcao(int matriz[][3]) {

	int aux = 0;
	int count = 100000000;

	for(int i = 0; i < 3; i++) {
		for(int j = 0; j < 3; j++) {


				aux = (aux + count*matriz[i][j]);
				count = count/10;

		}
	}
	return aux;
}

void carregar1 (int vet[][3]) {

	for(int i = 0; i < 3; i++) {
		for(int j = 0; j < 3; j++) {
			matriz_deck[i][j] = vet[i][j];
		}
	}

}

void carregar2(int vet[][3]) {

	for(int i = 0; i < 3; i++) {
		for(int j = 0; j < 3; j++) {
			vet[i][j] = matriz_deck[i][j];
		}
	}


}



void exibir(node *raiz) {

	if(raiz != NULL) {

		printf("%d\n",raiz->num);
		exibir(raiz->up);
		exibir(raiz->right);
		exibir(raiz->down);
		exibir(raiz->left);
	}
}
