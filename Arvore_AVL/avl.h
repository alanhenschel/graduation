/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   avl.h
 * Author: alan
 *
 * Created on 29 de Outubro de 2017, 19:49
 */

#ifndef AVL_H
#define AVL_H

typedef struct Treeno {
int info;
int altura;
struct Treeno *left;
struct Treeno *right;
} no;

int Fb(no *T); // calcula balanceamento
int altura_avl(no *T); // calcula altura
no* insere(no *T, int x);
no* balance(no *T);
no* novo_no(int x);
void newtree(no **T);
void emOrdem(no *T);
void preOrdem(no *T);
void posOrdem(no *T);
no *pesq_Menor(no **T);
int remove_no(no **T, int x);
#endif 

