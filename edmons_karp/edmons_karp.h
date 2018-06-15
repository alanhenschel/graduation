#ifndef EDMONS_KARP_H_
#define EDMONS_KARP_H_

#include <stdlib.h>
#include <stdio.h>
#include "listcad.h"

#define N 5

void largura(int arvore[N][N], int matriz[N][N], int inicial, int final);
void edmons_karp(int arvore[N][N], int matriz[N][N], int inicial, int final);
void print_matriz(int matriz[N][N]);
void inicia(int matriz[N][N]);
int ifFechado(int matriz[N][N], int x);
linked_list *encontraCaminho(int arvore[N][N], int inicial, int final);

#endif