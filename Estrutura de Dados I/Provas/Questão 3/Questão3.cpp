/*INSTITUTO FEDERAL DE MATO GROSSO - Campus Octayde.
	*Prova de Estrutura de Dados I - Professor Me. Constantino.
	*Autores(a): André Geraldo, Danubia Macedo
	*Data:08/11/2019
 	*Questão 3.

 	*Algoritmo cujo o objetivo é com a utilização do módulos de Filas, ter uma entrada de valores inteiros para uma fila, a mesma ser
     dividida em duas novas filas com os seus intercalados.
 */

#include "queue.h"

void intercalacao(fila * f,fila *f1,fila *f2);

int main(){
	//declaração de variáveis
	fila *f1,*f2,*f;
	elem x;
	char resposta;

	f = inicializa();
	f1 = inicializa();
	f2= inicializa();	

	printf("\n-----------------------------------------------\n");
	printf("\nALGORITMO PARA SEPARAR ELEMENTOS DE UMA FILA EM DUAS\n");
	do{

		printf("\nDigite o elemento da fila\n");
			scanf(" %d", &x);
			enqueue(f,x);

			printf("\nDeseja inserir um novo dado?(s/n)\n");
				scanf(" %c", &resposta);

	}while(resposta == 's');

	printf("\n<><><><><><><><><><><><><><><><><><><><><><><><><>\n");	

		intercalacao(f,f1,f2);

	printf("\nElemetos da fila 1\n");
	printf("\n\n");
	while(!qisEmpty(f1)){

		x = dequeue(f1);
		printf("Elementos: %d\n", x);
	}	

	printf("\nElemetos da fila 2\n");
	printf("\n\n");
	while(!qisEmpty(f2)){

		x = dequeue(f2);
		printf("Elementos: %d\n", x);
	}
	
	return 0;
}

void intercalacao(fila * f,fila *f1,fila *f2){

	while(!qisEmpty(f)){

		enqueue(f1,dequeue(f));

		 if(!qisEmpty(f)){

			enqueue(f2,dequeue(f));
			}
	}
}