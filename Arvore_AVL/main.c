/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: alan
 *
 * Created on 29 de Outubro de 2017, 19:47
 */

#include <stdio.h>
#include <stdlib.h>
#include "avl.h"

/*
 * 
 */
int main() {

    no *T;
    int i;
    newtree(&T);
    T=insere(T,2);
    T=insere(T,1);
    T=insere(T,3);
    T=insere(T,4);
    T=insere(T,5);
    printf("em ordem\n");
    emOrdem(T);
    printf("pre ordem\n");
    preOrdem(T);
    printf("pos ordem\n");
    posOrdem(T);
    i = remove_no(&T,1);
    printf("pos remoçao\n");
    printf("em ordem:\n");
     emOrdem(T);
     printf("em pre ordem:\n");
     preOrdem(T);
     printf("em pos ordem:\n");
     posOrdem(T);
    return 0;
}

