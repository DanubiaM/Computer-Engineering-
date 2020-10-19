#include <stdio.h>
#include <stdlib.h>
#define fnt "%d\n"	//definicao do dormao de exibição
typedef int Item;
typedef struct no{
	Item item;
	struct no*prox;
}*Lista;			//Tipo de ponteiro para lista.
Lista no(Item x, Lista p);
void exibir(Lista I);
void destroi(Lista *L);

int main(){
	Lista I;
	I=no(3,no(1,no(5,NULL)));
	//pode ser
	//I=(5,NULL);
	//I=(1,I);
	//I=(3,I);
	exibir(I);
	printf("LIMPANOD A LISTA\n");
	destroi(&I);
	printf("EXIBINDO LISTA DESTROIDA\n");
	exibir(I);
	
}
void exibir(Lista I){
	if(I!=NULL){	
		while(I!=NULL){
			printf(fnt,I->item);
			I=I->prox;
		}
	}else{
		printf("A lista esta vazia!\n");
	}

}
Lista no(Item x,Lista p){
	Lista n=malloc(sizeof(struct no)); 
	n->item=x;
	n->prox=p;
	return n;
}
void destroi(Lista *L){
	while(*L!=NULL){
		Lista n=*L;
		*L=n->prox;
		free(n);		
		
	}
}