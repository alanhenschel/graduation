#include <stdio.h>
#include <stdlib.h>
#include "arvore.h"

void newtree(no **T) {

	*T = NULL;
}

void insert_no(no **T, int x) {

	if(*T == NULL) {
		*T = (no*) malloc(sizeof(no));
		(*T)->info = x;
		(*T)->left = NULL;
		(*T)->right = NULL;
	}
	else {
		if(x < (*T)->info) {
			insert_no(&((*T)->left),x);
		}
		else {
		if(x > (*T)->info) {
			insert_no(&((*T)->right),x);
		}
			else
				return;
	}
	}
}

void emOrdem(no *T) {

	if(T != NULL) {
		emOrdem(T->left);
		printf("\n %d\n",T->info);
		emOrdem(T->right);
	}
}

void preOrdem(no *T) {
	if(T == NULL) {
		return;
	}
	else {
		printf("\n%d\n",T->info);
		preOrdem(T->left);
		preOrdem(T->right);
	}
}

void posOrdem(no *T) {
	if(T == NULL) {
		return;
	}
	else {
		posOrdem(T->left);
		posOrdem(T->right);
		printf("\n%d\n",T->info);
	}
}

no *pesq_AB(no **T, int x) {

	if(*T == NULL) {
		return NULL;
	}
	else {
		if((*T)->info == x) {
		return *T;
		}
		else { 
			if(x < (*T)->info) {
				pesq_AB(&((*T)->left),x);
			}
			else {
				if(x > (*T)->info) {
					pesq_AB(&((*T)->right),x);
				}
			}
		}
	}
}

void exibeFolha(no *T) {

	if(T != NULL) {
		exibeFolha(T->left);
		if(T->left == NULL && T->right == NULL) {
		printf("\n folha:%d\n",T->info);
		}
		exibeFolha(T->right);
	}

}

void apagaTree(no **T) {

	no *p;
	if(*T != NULL) {
	apagaTree(&((*T)->left));
	apagaTree(&((*T)->right));
	p = *T;
	*T = NULL;
	free(p);
	}	
}

void contaNo(no *T, int *count) {

	if(T != NULL) {
		contaNo(T->left,count);
		(*count)++;
		contaNo(T->right,count);
	}
}

no *pesq_Menor(no **T) {

	if((*T)->left == NULL) {
		return *T;
	}

	else {
		pesq_Menor(&((*T)->left));
	}
}

no *pesq_Maior(no **T) {

	if((*T)->right == NULL) {
		return *T;
	}

	else {
		pesq_Maior(&((*T)->right));
	}
}

int pesq_nivel(no *T, int x, int nivel) {

		if(x == T->info) {
			return nivel;
		}
		else {
			if(x < T->info) {
					nivel++;
					pesq_nivel(T->left,x,nivel);
				}
				else {
					if(x > T->info) {
					nivel++;
					pesq_nivel(T->right,x,nivel);
					}
			}
		}	
}

int altura_arvore(no *T) {

	if(T == NULL) {
		return -1;
	}
	else {
		int esquerda = altura_arvore(T->left);
		int direita = altura_arvore(T->right);
		if(esquerda < direita) {
			return direita + 1;
		}
		else {
			return esquerda + 1;
		}
	}
}

int remove_no(no **T, int x) {

	no *p;

	if(*T == NULL) {
		return 0;
	}
	else {
		if(x < (*T)->info) {
			remove_no(&((*T)->left),x);
		}
		else {
			if(x > (*T)->info) {
				remove_no(&((*T)->right),x);
			}
			else {
				if (((*T)->left== NULL) && ((*T)->right == NULL)){
				p = (*T);
				free(p);
				(*T) = NULL;
				return (1);
				}
				else {
					if ((*T)->left == NULL){ /* NO so tem filho direita */
					p = (*T);
					(*T) = (*T)->right;
					free(p);
					return (1);
					}
					else {
						if ((*T)->right == NULL){
						p = (*T);
						(*T) = (*T)->left;
						free((p));
						return (1);
						}
						else {
							/* NO com 2 filhos */
							p = pesq_Maior(&(*T)->left);
							(*T)->info = p->info;
							remove_no(&((*T)->left),p->info);
						}
					}
				}
			}
		}
	}
}

