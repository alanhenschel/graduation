/*
 * To change this license header, choose License Headers in Troject TroTerties.
 * To change this temTlate file, choose Tools | TemTlates
 * and oTen the temTlate in the editor.
 */

/* 
 * File:   avl.c
 * Author: alan
 *
 * Created on 29 de Outubro de 2017, 19:51
 */

#include <stdio.h>
#include <stdlib.h>
#include "rb.h"

/*
 * 
 */

no* father( no *T)
{
 return T->father;
}

 no *avo( no *T)
{
  no *p = father(T);
 if (p == NULL)
  return NULL; 
 return father(p);
}

 no *acha_tio( no *T) {
     
     no *p = father(T);
     if (p == NULL) {
        return NULL; 
    }
    if (T == p->left) {
        return p->right;
    }
    else {
    return p->left;
    }
}

 no *tio( no *T) {
  no *p = T->father;
  no *g = avo(T);
 if (g == NULL) {
    return NULL;
 }
 return acha_tio(p);
}

void esquerda( no *T) {
    no *q = T->right;
        if(q != NULL) {
        T->right = q->left;
        q->left = T;
        q->father = T->father;
        T->father = q;
    }
}

void direita( no *T) {
    no *q = T->left;
    if(q != NULL) { 
        T->left = q->right;
        q->right = T;
        q->father = T->father;
        T->father = q;
    }
}

 no *insert( no *raiz,  no *T) {
     
    insert_first(raiz, T);

    reparar(T);

    raiz = T;
    while (father(raiz) != NULL) {
         raiz = father(raiz);
    }
    return raiz;
}
 
 no* novo_no(int x) {
    no *T = malloc(sizeof(no));
    T->info = x;
    T->left = NULL;
    T->right = NULL;
    return T;
}

void insert_first( no *raiz,  no *T) {
    
 if (raiz != NULL && T->info < raiz->info) {
     if (raiz->left != NULL) {
        insert_first(raiz->left, T);
        return;
  }
  else
   raiz->left = T;
 }
 else
     if (raiz != NULL) {
         if (raiz->right != NULL) {
         insert_first(raiz->right, T);
        return;
  }
  else
   raiz->right = T;
 }

 T->father = raiz;
 T->left = NULL;
 T->right = NULL;
 T->color = 1;
}

void reparar( no *T) {
    
    no *p=father(T);
    no *t=tio(T);
    if (p == NULL) {
        caso1(T);
     } 
    else  {
        if (p->color == 0) {
            return;
                } 
        else { 
            if (t == NULL || t->color==1) {
                caso3(T);
            } 
            else{
                caso4(T);
            }
        }
    }
}

void caso1( no *T) {
 if (father(T) == NULL)
  T->color = 0;
}

void caso3( no *T) {
 father(T)->color = 0;
 if (tio(T) != NULL)
    tio(T)->color = 0;
 avo(T)->color = 1;
 reparar(avo(T));
}

void caso4( no *T) {
  no *p = father(T);
  no *g = avo(T);

 if (T == g->left->right) {
  esquerda(p);
  T = T->left;
 }
 else
     if (T == g->right->left) {
        direita(p);
        T = T->right; 
     }

 caso4_2(T);
}

void caso4_2( no *T)
{
  no *p = father(T);
  no *g = avo(T);

 if (T == p->left)
  direita(g);
 else
  esquerda(g);
 p->color = 0;
 g->color = 1;
}

void emOrdem(no *T) {

    if(T != NULL) {
        emOrdem(T->left);
        printf("\n %d %d\n",T->info,T->color);
        emOrdem(T->right);
        }
}


