#include <stdio.h>
#include <stdlib.h>
#define N 16

void solicita_no(int vet[N]) {
	int i;
	int b;
	int j;

	printf("Entre com o indice do no\n");
	scanf("%d",&i);
	printf("O que você gostaria de saber sobre o no :\nPara saber seu pai digite 1\nPara saber seu filho da esquerda digite 2 e da direita 3\nDigite 4 para ver todas os três\n");
	scanf("%d",&b);

	switch(b) {

		case 1:
			if(i == 1) 
				printf("No raiz sem pai\n");

			else {
				i = i/2;
				printf("pai:vet[%d]=%d\n",i,vet[i]);
			}
		break;

		case 2:
			if(2*i > N)
				printf("Sem filhos a esquerda\n");
			else {
				i = 2*i;
				printf("o filho da esquerda:vet[%d]=%d\n",i,vet[i]);
			}
 		break;

		case 3:
			if((2*i)+1 > N)
				printf("Sem filhos a direita\n");
			else {
				i = ((2*i)+1);
				printf("o filho da direita:vet[%d]=%d\n",i,vet[i]);
			}
		break;


		case 4:

			j=i;

			if(i == 1) 
				printf("No raiz sem pai\n");
			else {
				i = i/2;
				printf("pai:vet[%d]=%d\n",i,vet[i]);
			}
			if(2*j > N)
				printf("Sem filhos a esquerda\n");
			else {
				i = 2*j;
				printf("o filho da esquerda:vet[%d]=%d\n",i,vet[i]);
			}
			if((2*j)+1 > N)
				printf("Sem filhos a direita\n");
			else {
				i = ((2*j)+1);
				printf("o filho da direita:vet[%d]=%d\n",i,vet[i]);
			}
		break;
	}
}

void solicita_no2(int vet[N]) {

	int esquerda,direita,x,i;

	printf("Entre com o valor para a busca:\n");
	scanf("%d",&x);

	for(i = 0; i < N; i++) {
		esquerda = 2 *i;
		direita = ((2*i)+1);
		if(x == vet[i]) {

			if(i == 1) {
				printf("No raiz sem pai\n");
			}
			else {
				i = i/2;
				printf("pai:vet[%d]=%d\n",i,vet[i]);
			}
			if(esquerda > N) {
				printf("Sem filhos a esquerda\n");
			}
			else {
				printf("o filho da esquerda:vet[%d]=%d\n",esquerda,vet[esquerda]);
			}
			if(direita > N) {
				printf("Sem filhos a direita\n");
				return;
			}
			else {
				printf("o filho da direita:vet[%d]=%d\n",direita,vet[direita]);
				return;
			}

		}
	}
}
int main() {

	int vet[N] = {0,50,30,70,22,35,61,78,8,27,33,41,52,63,74,85};
	char c;

	for(int j = 1; j < N; j++)
		printf("vet[%d]=%d\n",j,vet[j]);
	printf("Para buscar por indice digite 'i' ou por valor digite 'v'\n");
	scanf("%c",&c);

	switch(c) {

		case 'i':
			solicita_no(vet);
		break;
		case 'v':
			solicita_no2(vet);
		break;
	}
	return 0;
}