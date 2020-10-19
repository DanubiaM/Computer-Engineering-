#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define TAM 5

typedef struct Cliente{

	char nome[30];
	char cpf[14];
}cliente;

typedef struct Fila fila;

bool qisEmpty(fila *f);

bool qisFull(fila *f);

void enqueue(fila *f,cliente x);

cliente dequeue(fila *f);

fila * inicializa();

int adc(int i);