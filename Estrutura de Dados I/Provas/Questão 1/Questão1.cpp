/*INSTITUTO FEDERAL DE MATO GROSSO - Campus Octayde.
	*Prova de Estrutura de Dados I - Professor Me. Constantino.
	*Autores(a): André Geraldo, Danubia Macedo
	*Data:08/11/2019
 	*Questão 1.

 	*Algoritmo cujo o objetivo é com a utilização do módulos de Filas, ter a entrada de duas filas inteiras e ambas serem contatenadas em
 	uma unica fila.
 */

#include "queue.h"
 
void concatene(fila * f1,fila * f2);

int main(){
	//declaração de variáveis
	fila *f1,*f2;
	elem x;
	char resposta;
	f1 = inicializa();
	f2 = inicializa();	

	printf("\n-----------------------------------------------\n");
	printf("\n ALGORITMO PARA CONCATENAÇÃO DE UMA FILA EM OUTRA\n");
	do{

		printf("\nDigite o elemento da fila 1\n");
			scanf(" %d", &x);
			enqueue(f1,x);

			printf("\nDeseja inserir um novo dado?(s/n)\n");
				scanf(" %c", &resposta);

	}while(resposta == 's');

	printf("\n<><><><><><><><><><><><><><><><><><><><><><><>\n");	

	do{

		printf("\nDigite o elemento da fila 2\n");
			scanf(" %d", &x);

			enqueue(f2,x);

			printf("\nDeseja inserir um novo dado?(s/n)\n");
				scanf(" %c", &resposta);

	}while(resposta == 's');
	//chamado do procedimento
	concatene(f1,f2);


	printf("\nElemetos da fila 1\n");
	while(!qisEmpty(f1)){

		x = dequeue(f1);
		printf("Elementos: %d\n", x);
	}	

	return 0;
}

void concatene(fila *f1,fila *f2){

	while(!qisEmpty(f2)){

		enqueue(f1,dequeue(f2));
	}
}