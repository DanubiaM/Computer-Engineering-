#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "fila.h"
#define n 10
struct fila{
	int total;
	int comeco;
	int final;
	Elem dados[n];
};

//procedimento para iniciar  a fila
Fila*  inicializa(){
	Fila *f;
	f=(Fila*)malloc(sizeof(struct fila));
	f->total=0;
	f->comeco=1;
	f->final=1;
	return f;
}
//procedimento responsavel por deixar a fila rotativa, e verificar se não tem nenhuma posição faltando
int adc(int i){
	i++;
	if(i>n){
		i=0;
	}
  return i;
}
bool qisEmpty(Fila *f){
	if(f->total==0){
		return true;
	}else{
		return false;
	}
}
bool qisFull(Fila *f){

		if(f->total==n){
			return true;
		}else{
			return false;
		}

}
void enqueue(Fila *f, Elem x){
	if(!qisFull(f)){
		f->dados[f->final]=x; 
		f->final=adc(f->final);
		f->total++;
	}else{
		printf("FILA CHEIA!\n");
	} 
}
Elem dequeue(Fila *f){
	if(!qisEmpty(f)){
		int t = f->dados[f->comeco];
		f->comeco=adc(f->comeco);
		f->total--;
		return t;
	}else{
		printf("FILA CHEIA!\n");
	}
}