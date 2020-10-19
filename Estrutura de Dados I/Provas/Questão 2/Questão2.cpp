/*INSTITUTO FEDERAL DE MATO GROSSO - Campus Octayde.
	*Prova de Estrutura de Dados I - Professor Me. Constantino.
	*Autores(a): André Geraldo, Danubia Macedo
	*Data:08/11/2019
 	*Questão 2.

 	*Algoritmo cujo o objetivo é com a utilização do módulos de Filas, formar uma fila contendo o nome e o cpf de clientes de um banco.
 */

#include "queueBanco.h"

int main(){
	//declaração de variáveis
	fila *f;
	char nome[30],cpf[14];
	cliente bancoCliente, imprima;

	f = inicializa();

	printf("\n-----------------------------------------------\n");
	printf("\nALGORITMO PARA SEPARAR ELEMENTOS DE UMA FILA EM DUAS\n");

	for(int i; i<TAM;i++){


		printf("\nDigite o nome e cpf,respectivamente:\n");
			scanf(" %s %s", nome, cpf);
			
			strcpy(bancoCliente.nome, nome);
			strcpy(bancoCliente.cpf, cpf);
			//Chamado do procedimento
			enqueue(f,bancoCliente);			
	}

	printf("\n<><><><><><><><><><><><><><><><><><><><><><><><><>\n");
	printf("\nA fila do banco:\n");
	printf("\n");
	int i = 1;
	while(!qisEmpty(f)){

		imprima = dequeue(f);

		printf("Sr(a): %s, se direcione ao caixa %d\n",imprima.nome ,i);
		i++;
	}		
	return 0;
}

