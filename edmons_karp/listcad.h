#ifndef LISTCAD_H
#define LISTCAD_H

typedef struct Node {
	int value;
	struct Node *next;
} node;

typedef struct {
	node *first;
	int count;
	int max;
} linked_list;

linked_list *new_linked_list(int size);
int is_empty(linked_list *l);
int count(linked_list *l);
int is_full(linked_list *l);
void insert_first(int x, linked_list *l);
node *create_node(int x);
void print(linked_list *l);
void destroy_linked_list(linked_list **l);
int remove_first(linked_list *l);
void insert_last(int x, linked_list *l);
int remove_last(linked_list *l);
void remove_value(int x, linked_list *l);
void insert_at(int x, int i, linked_list *l);
int search(int x, linked_list *l);

#endif