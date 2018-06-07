#include <stdio.h>
#include <stdlib.h>
#include "largura.h"


	int matriz_final[3][3] = {1,2,3,0,7,4,6,8,5};
	int matriz_deck[3][3];

	void newtree(node **T) {

	*T = NULL;
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


		if((*raiz) == NULL)
			*raiz = create_node(&(*raiz),matriz);


		if(verificar((*raiz)->num)) {
			return;
		}



		else {



		int aui,auj;
		aui = achar_i(matriz);
		auj = achar_j(matriz);

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				matriz_deck[i][j] = matriz[i][j];
			}
		}

		if(aui == 1 && auj == 0 && (matriz_deck[aui-1][auj] != 1)) {


			matriz_deck[aui][auj] = matriz[aui-1][auj];
			matriz_deck[aui-1][auj] = 0;
			gera_estado(&((*raiz)->down),matriz_deck);
		}

		else if(aui == 1 && auj == 0 && (matriz_deck[aui][auj+1] != 0)) {

			matriz_deck[aui][auj] = matriz[aui][auj+1];
			matriz_deck[aui][auj+1] = 0;
			gera_estado(&((*raiz)->left),matriz_deck);
		}

		else if(aui == 1 && auj == 0 && (matriz_deck[aui+1][auj] != 6)) {

			matriz_deck[aui][auj] = matriz[aui+1][auj];
			matriz_deck[aui+1][auj] = 0;
			gera_estado(&((*raiz)->up),matriz_deck);

		}

			else if(aui == 1 && auj == 1 && (matriz_deck[aui-1][auj] != 2)) {
				matriz_deck[aui][auj] = matriz[aui-1][auj];
				matriz_deck[aui-1][auj] = 0;
				gera_estado(&((*raiz)->down),matriz_deck);
			}

			else if(aui == 1 && auj == 1 && (matriz_deck[aui+1][auj] != 6)) {
				matriz_deck[aui][auj] = matriz[aui+1][auj];
				matriz_deck[aui+1][auj] = 0;
				gera_estado(&((*raiz)->up),matriz_deck);
			}

			else if(aui == 1 && auj == 1 && (matriz_deck[aui][auj-1] != 8)) {
				matriz_deck[aui][auj] = matriz[aui][auj-1];
				matriz_deck[aui][auj-1] = 0;
				gera_estado(&((*raiz)->right),matriz_deck);
			}

			else if(aui == 1 && auj == 1 && (matriz_deck[aui][auj+1] != 4)) {
				matriz_deck[aui][auj] = matriz[aui][auj+1];
				matriz_deck[aui][auj+1] = 0;
				gera_estado(&((*raiz)->left),matriz_deck);
			}

			else if(aui == 2 && auj == 1 && (matriz_deck[aui][auj-1] != 7)) {
				matriz_deck[aui][auj] = matriz[aui][auj-1];
				matriz_deck[aui][auj-1] = 0;
				gera_estado(&((*raiz)->right),matriz_deck);
			}

			else if(aui == 2 && auj == 0 && (matriz_deck[aui-1][auj] != 8)) {
				matriz_deck[aui][auj] = matriz[aui-1][auj];
				matriz_deck[aui-1][auj] = 0;
				gera_estado(&((*raiz)->down),matriz_deck);
			}
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




int verificar(int num) {

	if(num != 123804765)
		return 0;
	else
		return 1;
}


void exibir(node *raiz) {

	if(raiz == NULL) {
		return;
	}

	else {



		printf("%d\n",raiz->num);
		exibir(raiz->left);
		exibir(raiz->right);
		exibir(raiz->up);
		exibir(raiz->down);
	}
}
