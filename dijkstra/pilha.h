


typedef struct node {

	int	num;
	struct node *prox;
}node;


int vazia(node *p);
node *aloca(int x);
void liberar(node *p);
void exibir(node *p);
void push(node *p,int x);
void pop(node *p);