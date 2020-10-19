#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
typedef struct fila Fila;
typedef int Elem;
int adc(int i);
Fila*  inicializa();
bool qisEmpty(Fila *f);
bool qisFull(Fila *f);
void enqueue(Fila *f, Elem x);
Elem dequeue(Fila *f);
