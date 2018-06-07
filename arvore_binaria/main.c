#include <stdio.h>
#include <stdlib.h>
#include "arvore.h"

int main() {

	no *T;
	no *p;
	int nivel = 0, count = 0,remove = 0;

	newtree(&T);
	insert_no(&T,20);
	insert_no(&T,11);
	insert_no(&T,33);
	insert_no(&T,4);
	insert_no(&T,2);
	printf("Em ordem\n");
	emOrdem(T);
	p = pesq_AB(&T,70);
	if(p == NULL) {
		printf("Valor nao encontrado\n");
	}
	else
		printf("valor encontrado:%d\n", p->info);
	printf("pre ordem\n");
	preOrdem(T);
	printf("pos ordem\n");
	posOrdem(T);
	exibeFolha(T);
	//apagaTree(&T);
	emOrdem(T);
	contaNo(T,&count);
	printf("contador:%d\n",count);
	p = NULL;
	p = pesq_Menor(&(T->left));
	printf("\no menor eh:%d\n",p->info);
	p = NULL;
	p = pesq_Maior(&(T->right));
	printf("\no maior eh:%d\n",p->info);
	printf("\no nivel do no eh:%d\n",pesq_nivel(T,2,nivel));
	printf("a altura da arvore eh:%d\n",altura_arvore(T));

	//remove=remove_no(&T,32);
	//remove=remove_no(&T,10);
	//remove=remove_no(&T,2);
	//remove=remove_no(&T,18);
	//remove=remove_no(&T,3);
	//if(remove == 1) {
	//	printf("valor apagado\n");
	//}
	//emOrdem(T);
	//printf("a altura:%d\n",altura_arvore(T));
	//insert_no(&T,11);
	//insert_no(&T,33);
	//insert_no(&T,4);
	//insert_no(&T,2);
	//emOrdem(T);
	//printf("a altura:%d\n",altura_arvore(T));

	return 0;

}