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
#include "avl.h"

/*
 * 
 */

void newtree(no **T) {
    *T = NULL;
}

int Fb(no *T) {
    return (altura_avl(T->right) - altura_avl(T->left));
}

int altura_avl(no *T) {
    
   if (T == NULL) 
      return -1; // altura da árvore vazia
   else {
      int he = altura_avl(T->left);
      int hd = altura_avl(T->right);
      if (he < hd) 
        return hd + 1;
      else 
         return he + 1;
   }
}

no* rotacao_Direita(no *T) {
    no *q;
    q = T->left;
    T->left = q->right;
    q->right = T;
    //altura_avl(T);
    //altura_avl(q);
    return q;
}

no* rotacao_Esquerda(no *T) {
    no *q;
    q = T->right;
    T->right = q->left;
    q->left = T;
    //altura_avl(T);
    //altura_avl(q);
    return q;
}


no* insere(no *T, int x) {
    if( T == NULL) {
        return novo_no(x);
    }
    if( x<T->info)
        T->left = insere(T->left,x);
    else
        T->right = insere(T->right,x);
   return balance(T);
}

no* novo_no(int x) {
    no *T = malloc(sizeof(no));
    T->info = x;
    T->left = NULL;
    T->right = NULL;
    return T;
}

no* balance(no *T) {
    
    //altura_avl(T);
    if( Fb(T) == 2 ) {
        if( Fb(T->right) < 0 )
            T->right = rotacao_Direita(T->right);
        return rotacao_Esquerda(T);
    }
    if( Fb(T) == -2 ) {
        if( Fb(T->left) > 0 )
            T->left = rotacao_Esquerda(T->left);
        return rotacao_Direita(T);
    }
    return T;
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

int remove_no(no **T, int x) {
    no *p;
    int aux;
    if(*T == NULL) {
        return 0;
    }
    else {
        if(x < (*T)->info) {
            aux = remove_no(&((*T)->left),x);
            if ( aux != 1 ) 
                return 0;
            *T=balance((*T));
        }
        else {
            if(x > (*T)->info) {
                aux = remove_no(&((*T)->right),x);
                if ( aux != 1 ) 
                    return 0;
                T=balance((*T));
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
                        else {/* NO com 2 filhos */
                            p = pesq_Menor(&(*T)->right);
                            (*T)->info = p->info;
                            remove_no(&((*T)->right),p->info);
                        }
                    }
                }
            }
        }
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