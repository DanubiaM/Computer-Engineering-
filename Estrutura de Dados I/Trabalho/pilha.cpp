#include "pilha.h"


#define tam 10

struct pilha{
	int topo;
	char vet[tam];
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
void push(Pilha *p,char elem){
	if(!isFull(p)){
		p->topo++;
		p->vet[p->topo]=elem;
		
	}else{
		printf("\nPILHA CHEIA!\n");
	}
}
char pop(Pilha *p){
	char x;
	if(!isEmpty(p)){
		x=p->vet[p->topo];
		p->topo--;
	}else{
		printf("\n Pilha vazia\n");
	}
	return x;
}
char top (Pilha *p){
	char x;
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
//PROJETO DA PROVA
char infixaPposfixa(Pilha *p,char elem[30],int i,char posfixa [30], int *px){
	//declaração de variáveis
	int flag = 0,pr1,pr2;
	char x,v;


	if(isEmpty(p)){//se a pilha estiver vazia, simplismente manda o elemento para a pilha
		
		push(p,elem[i]);

	}else{
		switch(elem[i]){			
			case '('://caso seja uma parênteses aberto, mandamos e atribuimos 1 a flag
				push(p,elem[i]);
				flag = 1;

				break;
			case '+':
			case '-':
				pr1 = 2;
				break;
				
			case '*':
			case '/':
				pr1 = 3;
				break;				
			case ')':
					
				//quando achar ')' temos que desempilhar a pilha de operadores e mandar para a saída
				while(p->vet[p->topo] != '('){					
					posfixa[*px]= pop(p);
					++*px;					
				}

				x = pop(p);//retira '(' da pilha
				flag = 1;
				break;

		}//fim do switch do elem

		switch(p->vet[p->topo]){

			case '(':
				pr2 = 1;
				break;
			case '+':
			case '-':
				pr2 = 2;
				break;
			case '*':
			case '/':
				pr2 = 3;
				break;
		}//fim do switch do topo	

		if( flag == 0){

			if(pr2>pr1 || (pr1 == pr2)){//pr1 = exp e pr2 = vet[topo]			
				posfixa[*px] = pop(p);//retira da pilha e manda para a saída
				push(p,elem[i]);//manda o atual elemento para a pilha
				++*px;//incrementação do index 
				
			}else{

				push(p,elem[i]);
			}

		}
	}

flag = 0;//resetar a flag

}