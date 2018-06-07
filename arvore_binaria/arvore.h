#ifndef ARVORE_H
#define ARVORE_H

typedef struct tree{
	int info;
	struct tree *left;
	struct tree *right;
} no;

void newtree(no **T); // cria a raiz da arvore
void insert_no(no **T, int x); // inserir um numero na arvore
void emOrdem(no *T); // imprimi arvore
no *pesq_AB(no **T, int x); // pesquisa na arvore
void preOrdem(no *T); // imprimi em pre ordem
void posOrdem(no *T); // imprimi em pos ordem
void exibeFolha(no *T); // imprimi somente as folhas
void apagaTree(no **T); // apaga toda a arvore
void contaNo(no *T, int *count); // conta os nos da arvore
no *pesq_Menor(no **T); //pesquisa o menor valor
no *pesq_Maior(no **T); // pesquisa o maior valor
int pesq_nivel(no *T, int x, int nivel); // pesquisa o nivel do no
int altura_arvore(no *T); // altura da arvore
int remove_no(no **T, int x); // apaga no
#endif