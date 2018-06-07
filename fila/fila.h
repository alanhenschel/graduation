

typedef struct node{

	int num;
	struct node *prox;
	int tam;

}node;

int vazia(node *f);
void insere(node *f ,int x);
void exibir(node *f);
int retirar(node *f);
void liberar(node *f);