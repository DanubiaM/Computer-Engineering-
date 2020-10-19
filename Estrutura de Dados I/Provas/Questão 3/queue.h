#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>

#define TAM 10

typedef int elem;

typedef struct Fila fila;

bool qisEmpty(fila *f);

bool qisFull(fila *f);

void enqueue(fila *f,elem x);

elem dequeue(fila *f);

fila * inicializa();

int adc(int i);