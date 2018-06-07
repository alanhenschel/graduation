

typedef struct node {

	int num;
	struct node *prox;
}node;

int vazia(node *l);
node *aloca(int x);
void inserir_comeco(node *l, int x);
void inserir_fim(node *l, int x);
void exibir(node *l);
void liberar(node *l);
node *retirar_comeco(node *l);
node *retirar_final(node *l);
void inserir_posicao(node *l, int x, int pos);