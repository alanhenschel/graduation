

typedef struct no{

	int num;
	struct no *prox;
	int tam;

}no;

int vazia(no *f);
void insere(no *f ,int x);
void exibir2(no *f);
no *retirar(no *f);
void liberar(no *f);
int pesquisar(no *f, int x);