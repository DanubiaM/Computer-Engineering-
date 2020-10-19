/* ESTRUTURA DE DADOS I - Professor Constantino
	*Implementação da construção de uma LISTA
	*
	*Autor(a):Danubia Gama Macedo - 3º Semestre - Engenharia da Computação
	*Desenvolvido no dia 30 de outubro de 2019.
*/

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#define fnt "%d\n"	//definicao do dormao de exibição
typedef int Item;
typedef struct no{
	Item item;
	struct no*prox;
}*Lista;			//Tipo de ponteiro para lista.
Lista no(Item x, Lista p);
void exibir(Lista I);
void destroi(Lista *L);
int tamanho(Lista L);
bool pert(Item X, Lista L);
Lista clone(Lista L);
void rem(Item x, Lista *L);
bool em (Item x, Lista L);
void ins(Item x, Lista *L);

int main(){
	int op,x;
	Lista I;
	Lista O;
	//criação de uma lista encadeada
	I=no(3,no(1,no(5,NULL)));
	//criação de uma lista ordenada
	O=no(7,NULL);
	ins(1,&O);
	ins(10,&O);

	//pode ser
	//I=(5,NULL);
	//I=(1,I);
	//I=(3,I);
	printf("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
	do{
	printf("Selecione a opcao que deseja realizar:\n (1)Exibir\n (2) Detroir\n (3) Exibir tamanho\n (4)Procurar um valor\n (5)Clonar lista\n (6)TRABALHAR COM LISTA ORDENADA\n (7) SAIR\n");	
	printf("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n>>");
	scanf("%d",&op);
	switch(op){
		case 1:
			printf("Impressão da lista:\n");
			exibir(I);
		break;
		case 2:
			printf("Lista destroida\n");
			destroi(&I);
		break;
		case 3:
			printf("Tamanho da lista:\n>>");
			printf("%d\n",tamanho(I));
		break;
		case 4:
			printf("Digite um valor que deseja procurar na lista:\n");
			scanf("%d",&x);
			//comando condicional terciario
			printf(pert(x,I)?"O elemento esta presente!\n":"O elemento esta ausente!\n");
		break;
		case 5:
			printf("Lista Clonada!\n");
			exibir(clone(I));
			
		break;
		case 6:
		
			printf("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
			printf("Escolha a opcao: (1)Excluir um valor (2) Procurar um elemento (3)Exibir lista ordenada\n");
			int op2;
			scanf("%d",&op2);
			if (op2==1){
				printf("Digite o valor que deseja remover:\n>>");
				int r;
				scanf("%d",&r);
				rem(r,&O);
			}
			if(op2==2){
				int v;
				printf("Digite o valor que deseja buscar:\n>>");
				scanf("%d",&v);
				printf(em(v,O)?"O elemento esta presente:!\n":"O elemento não existe!\n");
			}
			if(op2==3){
				printf("\n Lista Ordenada:\n");
				exibir(O);
				printf("--------\n");
			}
		
			
			break;
	}
	}while(op!=7);

}
//Responsvel por exibir os dados da lista
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
//Função responsavel construir ou criar a lista
Lista no(Item x,Lista p){
	Lista n=malloc(sizeof(struct no)); 
	n->item=x;
	n->prox=p;
	return n;
}
//Responsavel por destruir a lista
void destroi(Lista *L){
	while(*L!=NULL){
		Lista n=*L;
		*L=n->prox;
		free(n);		
		
	}
}
//Função responsavel por contar o tamanho da lista
int tamanho (Lista L){
	if(L==NULL){
		return 0;
	}
	return 1+tamanho(L->prox);
		
}
//Responsavel por procurar se existe um valor na lista
bool pert(Item X, Lista L){
	if(L==NULL){
		return false;
	}
	if(L->item==X){
		return true;
	}
	return pert(X,L->prox);
}
//Função responsavel por clonar a lista
Lista clone(Lista L){
	if(L==NULL){
		return NULL;
	}
	return no(L->item,clone(L->prox));
}
//Procedimento para inserção ordenada na lista
void ins(Item x, Lista *L){
	while(*L!=NULL && (*L)->item < x){
		L=&(*L)->prox;
	}
	*L=no(x,*L);	
}
//procedimento responsavel por excluir o valor contido na lista ordenada
void rem(Item x, Lista *L){
	while(*L != NULL && (*L)->item<x)
		L=&(*L)->prox;
	if(*L==NULL || (*L)->item>x)
		return;	
	Lista n=*L;
	*L=n->prox;
	free(n);
}
//Função responsavel por verificar se existe o valor na lista ordenada
bool em (Item x, Lista L){
	while(L!=NULL && L->item<x)
		L=L->prox;
	return (L!=NULL && L->item==x?true:false);
}
