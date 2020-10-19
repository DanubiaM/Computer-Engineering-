#include <stdbool.h>
#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct pilha Pilha;
Pilha *inicializa();
void push(Pilha *p, char elem);
char pop (Pilha *p);
char top(Pilha *p);
bool isFull(Pilha *p);
bool isEmpty(Pilha *p);
void libera (Pilha *p);
char infixaPposfixa(Pilha *p,char elem[30],int i,char posfixa[30], int *px);