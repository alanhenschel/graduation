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
#include "rb.h"

/*
 * 
 */
int main() {

    no *T;
    T=insert(T,novo_no(4));
    T=insert(T,novo_no(2));
    T=insert(T,novo_no(6));
    T=insert(T,novo_no(7));
    T=insert(T,novo_no(1));
    T=insert(T,novo_no(5));
    T=insert(T,novo_no(8));
    T=insert(T,novo_no(9));
    T=insert(T,novo_no(10));
    T=insert(T,novo_no(11));
    T=insert(T,novo_no(12));
    T=insert(T,novo_no(13));
    T=insert(T,novo_no(14));
    
    emOrdem(T);
    return 0;
}

