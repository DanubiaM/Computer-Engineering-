#include <stdbool.h>
typedef struct pilha Pilha;
Pilha *inicializa();
void push(Pilha *p, int elem);
int pop (Pilha *p);
int top(Pilha *p);
bool isFull(Pilha *p);
bool isEmpty(Pilha *p);
void libera (Pilha *p);