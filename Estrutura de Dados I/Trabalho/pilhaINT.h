#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

#define TAM 10

//criação de variável pilha

typedef struct pilha PilhaInt;

//criação de um novo tipo 
typedef int tipo;

//função para inicializar pilha
PilhaInt* inicializaInt();

//subrotina para inserir na pilha
//(pilha,tamanho_da_pilha)
void pushInt(PilhaInt *p,int elem);

// void pushInt(PilhaInt *p,int elem);/


//função para remoção de um elemento da pilha
int popInt(PilhaInt *p);

//função para verificar se está cheio
bool isFullInt(PilhaInt  *p);

//função para verificar se está vazio
bool isEmptyInt(PilhaInt  *p);

//subrotina para liberar memória
void liberaInt(PilhaInt  *p);