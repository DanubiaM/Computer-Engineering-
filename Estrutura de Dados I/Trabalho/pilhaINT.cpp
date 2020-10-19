#include "pilhaINT.h"

struct pilha
{
	int topo;
	tipo vet[TAM];
};

//função iniciliza pilha
PilhaInt* inicializaInt(){

	PilhaInt *p;

	//reservar uma área de memória
	p = (PilhaInt*) malloc(sizeof(struct pilha));


	if(p != NULL){

		//topo recebe a posição -1
		p->topo = -1;

		return p;
	}

}

//função para verificar se a pilha está cheia
bool isFullInt(PilhaInt *p){
	
	//verificação se chegamos limite do topo
	if(p->topo == TAM-1){
		return true;
	}else{
		return false;
	}

}

//função para verificar se a pilha está vazia
bool isEmptyInt(PilhaInt *p){

	//verificação se estamos antes de começar a pilha
	if(p->topo == -1){
		return true;

	}else{
		return false;

	}


}

//subrotina para inserir elementos na pilha
void pushInt(PilhaInt *p, tipo elem){

	//verificação se a pilha não está cheia
	if(!isFullInt(p)){
		p->topo++; //incrementamos o topo para atribuir um novo elem

		p->vet[p->topo] = elem;

	}else{
		printf("\n A pilha está cheia !\n");
	}

}

//função para remover elementos da pilha
tipo popInt(PilhaInt *p){
	//declaração de variável para guardar o valor removido
	tipo x;
	//verificação se a pilha não está vazia
	if(!isEmptyInt(p)){

		//recebendo o elemento atual no topo	
		x = p->vet[p->topo];


		//voltando uma posição do topo
		p->topo--;



	}else{
		
		printf("\nA pilha está vazia !\n");
		
	}
 		
	
		//retornando o valor removido
		return x;
}


//subrotina para liberar memória do ponteiro
void liberaInt(PilhaInt *p){
	free(p);
}