#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "fila.c"
//https://pt.stackoverflow.com/questions/213633/erro-ao-criar-arquivo-makefile/213804#213804
int main(){
	Fila *f;
	f= inicializa();
	int i;
	for(i=0;i<=10;i++){
		printf("Inserindo valor %d na Fila!\n",i);
		enqueue(f,i);
	}
	printf("\n\n");
	for(i=1;i<=10;i++){
		printf("%d\n",dequeue(f));
	}

	return 0;

}
