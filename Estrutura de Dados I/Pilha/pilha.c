#include "pilha.h"
#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
//#include <stdbool.h>
#define tam 10

struct pilha{
	int topo;
	int vet[tam];
};
Pilha* inicializa(){
	Pilha *p;
	p = (Pilha*)malloc(sizeof(struct pilha));
	if (p != NULL){
		p->topo=-1;
	}
	return p;
}
bool isFull(Pilha *p){
	if(p->topo==tam-1){
		return true;
	}else{
		return false;
	}
}
bool isEmpty(Pilha *p){
	if(p-> topo==-1)
		return true;
	else
		return false;
	
}
void push(Pilha *p,int elem){
	if(!isFull(p)){
		p->topo++;
		p->vet[p->topo]=elem;
		
	}else{
		printf("\nPILHA CHEIA!\n");
	}
}
int pop(Pilha *p){
	int x;
	if(!isEmpty(p)){
		x=p->vet[p->topo];
		p->topo--;
	}else{
		printf("\n Pilha vazia\n");
	}
	return x;
}
int top (Pilha *p){
	int x;
	if(!isEmpty(p)){
		x=p->vet[p->topo];
		
	}else{
		printf("\n Pilha Vazia!\n");
	}
	return x;
}
void libera(Pilha *p){
    free(p);
}