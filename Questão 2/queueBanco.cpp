#include "queueBanco.h"
struct Fila{

	//total que permite reutilizar a fila
	int total;
	int comeco;
	int final;
	cliente dados[TAM];

};

//função para verificar se está cheio usando o total
bool qisFull(fila *f){
	//qisFull = (f.final>n);

	if(f->total == TAM){
		return 1;
	}else{
		return 0;
	}
}

//função para verificar se está vazio usando o total
bool qisEmpty(fila *f){
	//qisEmpty = (f.comeco = final);

	if(f->total == 0){
		return 1;
		
	}else{

		return 0;
	}
}

//subrotina/procedimento para inserir elementos no final da fila
void enqueue(fila *f,cliente x){

	if(!qisFull(f)){//se caso não tiver cheio

		f->dados[f->final] = x;//adc elemento no final da Fila
		f->final = adc(f->final);//incrementa o final pela subrotina adc
		f->total++;//o total é incrementado

	}else{
		printf("\nOH NO! Fila Cheia \n");
	}

}

//função que remove elemento no inicio da fila e retorna o valor removido
cliente dequeue(fila *f){

	if(!qisEmpty(f)){//caso não tiver vazio

		cliente dequeue = f->dados[f->comeco];//recebe o elem que está no começo da fila
		f->comeco = adc(f->comeco);//comeco é incrementado
		f->total--;//total é decrementado

		return dequeue;

	}else{

		printf("\nEBA! Fila Vazia\n");

	}
}

//função para inicializar o ponteiro Fila
fila * inicializa(){

	//Declaração de variável do tipo ponteiro
	//alocação de memória do tipo Fila e conversão do retorno para o tipo FILA
	fila * f = (fila *) malloc(sizeof(struct Fila));



	if(f != NULL){ 

		f->comeco = 0;
		f->final = 0;
		f->total = 0;

		return f;//retorna ponteiro
	}
}

//função para incrementar 
int adc(int  i){

	i++;
	if(i>TAM) i = 0;
	return i;
}








