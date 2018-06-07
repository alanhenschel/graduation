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
int info, color;
struct Treeno *father;
struct Treeno *left;
struct Treeno *right;
} no;

no *father( no *n);
no* novo_no(int x);
void emOrdem(no *T);
 no *avo( no *n);
 no *acha_tio( no *n);
 no *tio( no *n);
void esquerda( no *n);
void direita( no *n);
no *insert( no *root,  no *n);
void insert_first( no *root,  no *n);
void reparar( no *n);
void caso1( no *n);
void caso3( no *n);
void caso4( no *n);
void caso4_2( no *n);
#endif 

